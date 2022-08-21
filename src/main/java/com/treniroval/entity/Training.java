package com.treniroval.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TRAINING")
public class Training {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TRAINING")
    private List<Approach> approaches;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TRAINING_TOPIC")
    private String trainingTopic;

    @Column(name = "DATE")
    private String date;

    @Column(name = "ID_USER")
    private int idUser;

    public Training(String trainingTopic, String date, int idUser) {
        this.trainingTopic = trainingTopic;
        this.date = date;
        this.idUser = idUser;
    }

    public Training() {
    }

    @Override
    public String toString() {
        return "Training{" +
                "idTraining=" + id +
                ", trainingTopic='" + trainingTopic + '\'' +
                ", date='" + date + '\'' +
                ", idUser=" + idUser +
                '}';
    }

    public int getIdTraining() {
        return id;
    }

    public void setIdTraining(int idTraining) {
        this.id = idTraining;
    }

    public String getTrainingTopic() {
        return trainingTopic;
    }

    public void setTrainingTopic(String trainingTopic) {
        this.trainingTopic = trainingTopic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

}
