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
    @JoinColumn(name = "training_id")
    private List<Approach> approaches;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "training_topic")
    private String trainingTopic;

    @Column(name = "date")
    private String date;

    @Column(name = "user_id")
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
