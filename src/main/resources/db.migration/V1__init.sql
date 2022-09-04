CREATE TABLE approach
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    training_id     BIGINT                NOT NULL,
    exercise_id     BIGINT                NOT NULL,
    approach_number INT                NOT NULL,
    repetitions_number        INT                NOT NULL,
    workload        INT                NOT NULL,
    CONSTRAINT pk_approach PRIMARY KEY (id)
);


CREATE TABLE exercise
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    exercise_name VARCHAR(255)       NULL,
    CONSTRAINT pk_exercise PRIMARY KEY (id)
);

CREATE TABLE training
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    training_topic VARCHAR(255)       NULL,
    date           VARCHAR(255)       NULL,
    user_id        BIGINT                NOT NULL,
    CONSTRAINT pk_training PRIMARY KEY (id)
);


CREATE TABLE user
(
    id       BIGINT AUTO_INCREMENT NOT NULL,
    login    VARCHAR(255)       NULL,
    password VARCHAR(255)       NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);


ALTER TABLE training
    ADD CONSTRAINT FK_TRAINING_ON_USER FOREIGN KEY (user_id) REFERENCES user (id);

ALTER TABLE approach
    ADD CONSTRAINT FK_APPROACH_ON_EXERCISE FOREIGN KEY (exercise_id) REFERENCES exercise (id);

ALTER TABLE approach
    ADD CONSTRAINT FK_APPROACH_ON_TRAINING FOREIGN KEY (training_id) REFERENCES training (id);

INSERT INTO user (LOGIN, PASSWORD)
VALUES ('admin', 'admin');


insert into training (TRAINING_TOPIC, DATE, USER_ID)
VALUES ('Грудь', '11.11.1111 11:11:11', 1);
insert into training (TRAINING_TOPIC, DATE, USER_ID)
VALUES ('Спина', '11.11.1111 11:11:12', 1);
insert into training (TRAINING_TOPIC, DATE, USER_ID)
VALUES ('Ноги', '11.11.1111 11:11:13', 1);

insert into exercise (EXERCISE_NAME)
    VALUE ('Жим лёжа');
insert into exercise (EXERCISE_NAME)
    VALUE ('Приседания');
insert into exercise (EXERCISE_NAME)
    VALUE ('Становая тяга');

insert into approach (TRAINING_ID, EXERCISE_ID, APPROACH_NUMBER, repetitions_number, WORKLOAD)
    VALUE (1,1,1,10,40);
insert into approach (TRAINING_ID, EXERCISE_ID, APPROACH_NUMBER, repetitions_number, WORKLOAD)
    VALUE (1,1,2,10,50);
insert into approach (TRAINING_ID, EXERCISE_ID, APPROACH_NUMBER, repetitions_number, WORKLOAD)
    VALUE (1,1,3,10,60);
insert into approach (TRAINING_ID, EXERCISE_ID, APPROACH_NUMBER, repetitions_number, WORKLOAD)
    VALUE (2,2,1,10,40);
insert into approach (TRAINING_ID, EXERCISE_ID, APPROACH_NUMBER, repetitions_number, WORKLOAD)
    VALUE (3,3,1,10,50);
insert into approach (TRAINING_ID, EXERCISE_ID, APPROACH_NUMBER, repetitions_number, WORKLOAD)
    VALUE (3,3,2,10,60);

