package ru.jack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;
}
