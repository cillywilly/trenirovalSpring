package com.treniroval.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TRAINING_EXERCISE")
@NoArgsConstructor
@Getter
@Setter
public class TrainingExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRAINING_EXERCISE")
    private int idTrainingExercise;

    @Column(name = "ID_TRAINING")
    private int idTraining;

    @Column(name = "ID_EXERCISE")
    private int idExercise;

    @Column(name = "APPROACH")
    private int approach;

    @Column(name = "REPEATT")
    private int repeat;

    @Column(name = "WORKLOAD")
    private int workload;

    @Column(name = "EXERCISE_NUMBER")
    private int exerciseNumber;

    public TrainingExercise(int idTraining, int idExercise, int approach, int repeat, int workload, int exerciseNumber) {
        this.idTraining = idTraining;
        this.idExercise = idExercise;
        this.approach = approach;
        this.repeat = repeat;
        this.workload = workload;
        this.exerciseNumber = exerciseNumber;
    }

    @Override
    public String toString() {
        return "TrainingExercise{" +
                "idTrainingExercise=" + idTrainingExercise +
                ", idTraining=" + idTraining +
                ", idExercise=" + idExercise +
                ", approach='" + approach + '\'' +
                ", repeat='" + repeat + '\'' +
                ", workload='" + workload + '\'' +
                ", exerciseNumber=" + exerciseNumber +
                '}';
    }

}
