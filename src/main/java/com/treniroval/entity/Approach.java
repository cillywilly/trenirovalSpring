package com.treniroval.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "APPROACH")
@Getter
@Setter
public class Approach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TRAINING_ID")
    private int trainingId;

    @Column(name = "EXERCISE_ID")
    private int exerciseId;

    @Column(name = "APPROACH_NUMBER")
    private int approachNumber;

    @Column(name = "REPEAT")
    private int repeat;

    @Column(name = "WORKLOAD")
    private int workload;

    public Approach(int trainingId, int exerciseId, int approachNumber, int repeat, int workload) {
        this.trainingId = trainingId;
        this.exerciseId = exerciseId;
        this.approachNumber = approachNumber;
        this.repeat = repeat;
        this.workload = workload;
    }

    public Approach() {
    }

    @Override
    public String toString() {
        return "TrainingExercise{" +
                "idTrainingExercise=" + id +
                ", idTraining=" + trainingId +
                ", idExercise=" + exerciseId +
                ", approach='" + approachNumber + '\'' +
                ", repeat='" + repeat + '\'' +
                ", workload='" + workload + '\'' +
                '}';
    }

}
