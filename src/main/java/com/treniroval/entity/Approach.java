package com.treniroval.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "approach")
@Getter
@Setter
public class Approach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TRAINING_ID")
    private Long trainingId;

    @Column(name = "EXERCISE_ID")
    private Long exerciseId;

    @Column(name = "APPROACH_NUMBER")
    private int approachNumber;

    @Column(name = "repetitions_number")
    private int repetitions_number;

    @Column(name = "WORKLOAD")
    private int workload;

    public Approach(Long trainingId, Long exerciseId, int approachNumber, int repetitions_number, int workload) {
        this.trainingId = trainingId;
        this.exerciseId = exerciseId;
        this.approachNumber = approachNumber;
        this.repetitions_number = repetitions_number;
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
                ", approachNumber='" + approachNumber + '\'' +
                ", repetitions_number='" + repetitions_number + '\'' +
                ", workload='" + workload + '\'' +
                '}';
    }

}
