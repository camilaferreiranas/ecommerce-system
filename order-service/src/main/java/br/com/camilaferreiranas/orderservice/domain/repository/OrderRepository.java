package br.com.camilaferreiranas.orderservice.domain.repository;

import br.com.camilaferreiranas.orderservice.domain.enums.Status;
import br.com.camilaferreiranas.orderservice.domain.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {

    Order save(Order order);
    List<Order> findAll();
    Order findById(UUID id);
    List<Order> listByStatus(Status status);
}
