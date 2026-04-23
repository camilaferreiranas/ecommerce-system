package br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.repository;


import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepositoryJpa extends JpaRepository<OrderEntity, UUID> {
}
