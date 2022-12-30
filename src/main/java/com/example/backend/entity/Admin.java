package com.example.backend.entity;

import javax.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String email;

    private String password;

    private Boolean active;

}