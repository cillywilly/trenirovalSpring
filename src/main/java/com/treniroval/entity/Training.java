package com.treniroval.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TRAINING")
@NoArgsConstructor
@Getter
@Setter
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRAINING")
    private int idTraining;

    @Column(name = "TRAINING_TOPIC")
    private String trainingTopic;

    @Column(name = "DATE")
    private String date;

    @Column(name = "ID_USER")
    private int idUser;

    @ManyToMany
    @JoinTable(name = "TRAINING_EXERCISE"
            , joinColumns = @JoinColumn(name = "ID_TRAINING")
            , inverseJoinColumns = @JoinColumn(name = "ID_EXERCISE"))
    private List<Exercise> exercises;

    public void addExerciseToTraining(Exercise exercise) {
        if (exercises == null) {
            exercises = new ArrayList<>();
        }
        exercises.add(exercise);
    }

    public Training(String trainingTopic, String date, int idUser) {
        this.trainingTopic = trainingTopic;
        this.date = date;
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Training{" +
                "idTraining=" + idTraining +
                ", trainingTopic='" + trainingTopic + '\'' +
                ", date='" + date + '\'' +
                ", idUser=" + idUser +
                '}';
    }

}
