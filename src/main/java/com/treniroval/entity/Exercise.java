package com.treniroval.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exercise")
@Getter
@Setter
@NoArgsConstructor
public class Exercise {

    @OneToMany
    @JoinColumn(name = "exercise_id")
    private List<Approach> approaches;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "exercise_name")
    private String exerciseName;

    public Exercise(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "idExercise=" + id +
                ", exerciseName=" + exerciseName +
                '}';
    }

}
