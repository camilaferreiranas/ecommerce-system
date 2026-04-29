package br.com.camilaferreiranas.orderservice.domain.repository;

import br.com.camilaferreiranas.orderservice.domain.model.User;

import java.util.Optional;

public interface UserRepository {


     User save(User user);
     Optional<User> findByEmail(String email);

}
