package org.example.springsecuritymvcaopvalidationdemo.mvc.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }
}
