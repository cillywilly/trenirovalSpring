package com.treniroval.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "training")
@Getter
@Setter
public class Training {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "TRAINING_ID")
    private List<Approach> approaches;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TRAINING_TOPIC")
    private String trainingTopic;

    @Column(name = "DATE")
    private String date;

    @Column(name = "USER_ID")
    private Long userId;

    public Training(String trainingTopic, String date, Long userId) {
        this.trainingTopic = trainingTopic;
        this.date = date;
        this.userId = userId;
    }

    public Training() {
    }

    @Override
    public String toString() {
        return "Training{" +
                "idTraining=" + id +
                ", trainingTopic='" + trainingTopic + '\'' +
                ", date='" + date + '\'' +
                ", idUser=" + userId +
                '}';
    }

}
