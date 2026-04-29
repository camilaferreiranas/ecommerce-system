package br.com.camilaferreiranas.orderservice.infrastructure.persistence.repository;

import br.com.camilaferreiranas.orderservice.domain.enums.Status;
import br.com.camilaferreiranas.orderservice.domain.model.Order;
import br.com.camilaferreiranas.orderservice.domain.model.User;
import br.com.camilaferreiranas.orderservice.domain.repository.OrderRepository;
import br.com.camilaferreiranas.orderservice.domain.repository.UserRepository;
import br.com.camilaferreiranas.orderservice.infrastructure.builder.OrderEntityBuilder;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.OrderEntity;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.UserEntity;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.repository.OrderRepositoryJpa;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.repository.UserRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OrderRepositoryAdapter implements OrderRepository {


    private final OrderRepositoryJpa  orderRepositoryJpa;
    private final UserRepository userRepository;

    public OrderRepositoryAdapter(OrderRepositoryJpa orderRepositoryJpa, UserRepository userRepository) {
        this.orderRepositoryJpa = orderRepositoryJpa;
        this.userRepository = userRepository;
    }


    @Override
    public Order save(Order order) {

        var userToSave = userRepository.findByEmail(order.getUser().getEmail())
                .orElse(userRepository.save(order.getUser()));
        var user = toUserEntity(userToSave);
        OrderEntity entity = new OrderEntityBuilder()
                .total(order.getTotal())
                .description(order.getDescription())
                .status(order.getStatus())
                .user(user)
                .of();
        var orderToSave = orderRepositoryJpa.save(entity);

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
                order.getCreatedAt(), order.getUpdatedAt(), order.getStatus());
    }


    public User toUserDomain(UserEntity user) {
        return new User(user.getId(), user.getName(), user.getTelephone(), user.getEmail());
    }

    public UserEntity toUserEntity(User user) {
        var entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setTelephone(user.getTelephone());
        entity.setEmail(user.getEmail());
        return entity;
    }


}
