package br.com.camilaferreiranas.orderservice.infrastructure.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "user_tb")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String telephone;

    @Column(nullable = false)
    private String email;
}
