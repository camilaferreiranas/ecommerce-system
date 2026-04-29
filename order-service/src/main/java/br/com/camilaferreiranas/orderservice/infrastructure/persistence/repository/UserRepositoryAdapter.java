package br.com.camilaferreiranas.orderservice.infrastructure.persistence.repository;

import br.com.camilaferreiranas.orderservice.domain.model.User;
import br.com.camilaferreiranas.orderservice.domain.repository.UserRepository;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities.UserEntity;
import br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.repository.UserRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepository {



    private final UserRepositoryJpa userRepositoryJpa;

    public UserRepositoryAdapter(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @Override
    public User save(User user) {
        var entity = new UserEntity();
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setTelephone(user.getTelephone());
        UserEntity entityToSave = userRepositoryJpa.save(entity);
        return toDomain(entityToSave);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepositoryJpa.findByEmail(email).map(this::toDomain);
    }


    public User toDomain(UserEntity entity) {
        return new User(entity.getId(), entity.getName(), entity.getTelephone(), entity.getEmail());
    }



}
