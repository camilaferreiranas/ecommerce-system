package br.com.camilaferreiranas.orderservice.application.usecases.orders;

import br.com.camilaferreiranas.orderservice.api.dto.DefaultResponseDTO;
import br.com.camilaferreiranas.orderservice.api.dto.OrderItemDTO;
import br.com.camilaferreiranas.orderservice.api.dto.OrderRequestDTO;
import br.com.camilaferreiranas.orderservice.domain.builder.OrderBuilder;
import br.com.camilaferreiranas.orderservice.domain.builder.UserBuilder;
import br.com.camilaferreiranas.orderservice.domain.enums.Status;
import br.com.camilaferreiranas.orderservice.domain.model.OrderItem;
import br.com.camilaferreiranas.orderservice.domain.model.User;
import br.com.camilaferreiranas.orderservice.domain.repository.OrderRepository;
import br.com.camilaferreiranas.orderservice.domain.repository.UserRepository;
import br.com.camilaferreiranas.orderservice.infrastructure.kafka.OrderPublisher;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.repository.UserRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateOrderUseCase {

    private final OrderRepository repository;
    private final OrderPublisher orderPublisher;

    public CreateOrderUseCase(OrderRepository repository, OrderPublisher orderPublisher) {
        this.repository = repository;
        this.orderPublisher = orderPublisher;
    }


    public DefaultResponseDTO execute(OrderRequestDTO dto) {

        var user = new UserBuilder()
                .email(dto.user().email())
                .name(dto.user().name())
                .telephone(dto.user().telephone())
                .of();


        var items = dto.items().stream().map(this::toOrder).toList();


        var orderDomain = new OrderBuilder()
                .description(dto.description())
                .status(Status.CREATED)
                .items(items)

                .user(user)
                .of();

        var order = repository.save(orderDomain);
        orderPublisher.sendMessage("order-status", "ORDER_CREATED");
        return new DefaultResponseDTO(order.getId(), "Order created");
    }


    private OrderItem toOrder(OrderItemDTO items) {
       var itemToSave = new OrderItem();
       itemToSave.setProductId(items.id());
       itemToSave.setQuantity(items.quantity());
       return itemToSave;
    }
}
