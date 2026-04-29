package br.com.camilaferreiranas.orderservice.application.usecases.orders;

import br.com.camilaferreiranas.orderservice.domain.model.Order;
import br.com.camilaferreiranas.orderservice.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListOrdersUseCase {

    private final OrderRepository orderRepository;

    public ListOrdersUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> execute() {
        return orderRepository.findAll();
    }
}
