package br.com.camilaferreiranas.orderservice.infrastructure.persistence.repository;

import br.com.camilaferreiranas.orderservice.domain.enums.Status;
import br.com.camilaferreiranas.orderservice.domain.model.Order;
import br.com.camilaferreiranas.orderservice.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class OrderRepositoryAdapter implements OrderRepository {


    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    @Override
    public Order findById(UUID id) {
        return null;
    }

    @Override
    public List<Order> listByStatus(Status status) {
        return List.of();
    }
}
