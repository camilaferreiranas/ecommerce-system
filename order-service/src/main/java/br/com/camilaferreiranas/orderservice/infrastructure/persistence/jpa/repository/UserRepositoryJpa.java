package br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.repository;

import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
