package com.treniroval.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private int idUser;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login=" + login +
                ", password=" + password +
                '}';
    }

}
