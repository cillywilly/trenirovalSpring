package com.treniroval.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EXERCISE")
@NoArgsConstructor
@Getter
@Setter
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EXERCISE")
    private int idExercise;

    @Column(name = "EXERCISE_NAME")
    private String exerciseName;

    @ManyToMany
    @JoinTable(name = "TRAINING_EXERCISE"
            , joinColumns = @JoinColumn(name = "ID_EXERCISE")
            , inverseJoinColumns = @JoinColumn(name = "ID_TRAINING"))
    public List<Training> trainings;

    public void addTrainingToExercise(Training training) {
        if (trainings == null) {
            trainings = new ArrayList<>();
        }
        trainings.add(training);
    }

    public Exercise(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "idExercise=" + idExercise +
                ", exerciseName=" + exerciseName +
                '}';
    }

}
