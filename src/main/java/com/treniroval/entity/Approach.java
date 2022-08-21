package com.treniroval.entity;

import javax.persistence.*;

@Entity
@Table(name = "APPROACH")
public class Approach {

    @OneToOne
    @JoinColumn(name = "ID")
    private Exercise exercise;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ID_TRAINING")
    private int idTraining;

    @Column(name = "ID_EXERCISE")
    private int idExercise;

    @Column(name = "APPROACH_NUMBER")
    private int approachNumber;

    @Column(name = "REPEAT")
    private int repeat;

    @Column(name = "WORKLOAD")
    private int workload;

    public Approach(int idTraining, int idExercise, int approachNumber, int repeat, int workload) {
        this.idTraining = idTraining;
        this.idExercise = idExercise;
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
                ", idTraining=" + idTraining +
                ", idExercise=" + idExercise +
                ", approach='" + approachNumber + '\'' +
                ", repeat='" + repeat + '\'' +
                ", workload='" + workload + '\'' +
                '}';
    }

    public int getIdTrainingExercise() {
        return id;
    }

    public void setIdTrainingExercise(int idTrainingExercise) {
        this.id = idTrainingExercise;
    }

    public int getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(int idTraining) {
        this.idTraining = idTraining;
    }

    public int getIdExercise() {
        return idExercise;
    }

    public void setIdExercise(int idExercise) {
        this.idExercise = idExercise;
    }

    public int getApproach() {
        return approachNumber;
    }

    public void setApproach(int approachNumber) {
        this.approachNumber = approachNumber;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getWorkload() {
        return workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
    }

}
