package br.com.camilaferreiranas.orderservice.infrastructure.persistence.repository;

import br.com.camilaferreiranas.orderservice.domain.enums.Status;
import br.com.camilaferreiranas.orderservice.domain.model.Order;
import br.com.camilaferreiranas.orderservice.domain.model.OrderItem;
import br.com.camilaferreiranas.orderservice.domain.model.User;
import br.com.camilaferreiranas.orderservice.domain.repository.OrderRepository;
import br.com.camilaferreiranas.orderservice.domain.repository.UserRepository;
import br.com.camilaferreiranas.orderservice.infrastructure.builder.OrderEntityBuilder;
import br.com.camilaferreiranas.orderservice.infrastructure.feign.dto.Product;
import br.com.camilaferreiranas.orderservice.infrastructure.feign.dto.ProductItemDTO;
import br.com.camilaferreiranas.orderservice.infrastructure.feign.service.ProductClient;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.OrderEntity;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.OrderItemEntity;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.UserEntity;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.repository.OrderRepositoryJpa;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.repository.UserRepositoryJpa;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderRepositoryAdapter implements OrderRepository {


    private final OrderRepositoryJpa  orderRepositoryJpa;
    private final UserRepository userRepository;

    private final ProductClient productClient;


    public OrderRepositoryAdapter(OrderRepositoryJpa orderRepositoryJpa, UserRepository userRepository, ProductClient productClient) {
        this.orderRepositoryJpa = orderRepositoryJpa;
        this.userRepository = userRepository;
        this.productClient = productClient;
    }

    @Override
    public Order save(Order order) {

        var userToSave = userRepository.findByEmail(order.getUser().getEmail())
                .orElseGet(() -> userRepository.save(order.getUser()));
        var user = toUserEntity(userToSave);

        List<OrderItemEntity> items = toOrderItemEntity(order.getOrderItems());
        OrderEntity entity = new OrderEntityBuilder()
                .total(calculateTotal(items))
                .description(order.getDescription())
                .items(items)
                .status(order.getStatus())
                .user(user)
                .of();

        items.forEach(item -> item.setOrder(entity));
        var orderToSave = orderRepositoryJpa.saveAndFlush(entity);

        return toDomain(orderToSave);
    }

    @Override
    public List<Order> findAll() {
        return orderRepositoryJpa.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public Order findById(UUID id) {
        return null;
    }

    @Override
    public List<Order> listByStatus(Status status) {
        return List.of();
    }


    public Order toDomain(OrderEntity order) {
        return new Order(order.getId(), order.getDescription(), toUserDomain(order.getUser()), order.getTotal(),
                order.getCreatedAt(), order.getUpdatedAt(), order.getStatus(), toOrderItemDomain(order.getOrderItemEntities()));
    }


    public User toUserDomain(UserEntity user) {
        return new User(user.getId(), user.getName(), user.getTelephone(), user.getEmail());
    }

    public List<OrderItem> toOrderItemDomain(List<OrderItemEntity> itemEntity) {
        return itemEntity.stream()
                .map((value) -> new OrderItem(value.getId(), value.getProductId(), value.getQuantity(), value.getPrice())).toList();
    }

    public UserEntity toUserEntity(User user) {
        var entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setTelephone(user.getTelephone());
        entity.setEmail(user.getEmail());
        return entity;
    }


    private List<OrderItemEntity> toOrderItemEntity(List<OrderItem> orderItems) {

        List<ProductItemDTO> ids = orderItems.stream().map(item -> new ProductItemDTO(item.getProductId()))
                .toList();

        List<Product> products = productClient.findByBatch(ids);

        Map<String, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getId, p -> p));

        List<OrderItemEntity> itemsToAdd = new ArrayList<>();
        for (OrderItem orderItem: orderItems) {
            Product product = productMap.get(orderItem.getProductId());
            if(product == null) {
                throw  new IllegalArgumentException("Product not found" + orderItem.getProductId());
            }

            OrderItemEntity entity = new OrderItemEntity();
            entity.setProductId(product.getId());
            entity.setQuantity(orderItem.getQuantity());
            entity.setPrice(product.getPrice());
            itemsToAdd.add(entity);
        }

        return itemsToAdd;

    }


    private BigDecimal calculateTotal(List<OrderItemEntity> orderItem) {
        BigDecimal resultOrder = BigDecimal.ZERO;
        for(OrderItemEntity item: orderItem) {
            BigDecimal result = item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            resultOrder = resultOrder.add(result);
        }

        return resultOrder;
    }


}
