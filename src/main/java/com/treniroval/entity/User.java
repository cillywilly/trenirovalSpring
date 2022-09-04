package com.treniroval.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private List<Training> trainings;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + id +
                ", login=" + login +
                ", password=" + password +
                '}';
    }
}
