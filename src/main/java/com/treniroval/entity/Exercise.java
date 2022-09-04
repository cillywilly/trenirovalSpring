package com.treniroval.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercise")
public class Exercise {

    @OneToMany
    @JoinColumn(name = "EXERCISE_ID")
    private List<Approach> approaches;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }
}
