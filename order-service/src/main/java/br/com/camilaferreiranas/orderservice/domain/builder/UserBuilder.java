package br.com.camilaferreiranas.orderservice.domain.builder;

import br.com.camilaferreiranas.orderservice.domain.model.User;

public class UserBuilder {

    private Long id;
    private String name;
    private String telephone;
    private String email;


    public UserBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }


    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }


    public User of() {
        return new User(id, name, telephone, email);
    }
}
