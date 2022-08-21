package com.treniroval.entity;

import javax.persistence.*;

@Entity
@Table(name = "EXERCISE")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "EXERCISE_NAME")
    private String exerciseName;

    public Exercise(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public Exercise() {
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "idExercise=" + id +
                ", exerciseName=" + exerciseName +
                '}';
    }

    public int getIdExercise() {
        return id;
    }

    public void setIdExercise(int idExercise) {
        this.id = idExercise;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
}
