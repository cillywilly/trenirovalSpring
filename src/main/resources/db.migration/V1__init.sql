create table approach
(
    id                 bigint not null auto_increment,
    approach_number    integer,
    exercise_id        bigint,
    repetitions_number integer,
    training_id        bigint,
    workload           integer,
    primary key (id)
)
create table exercise
(
    id            bigint not null auto_increment,
    exercise_name varchar(255),
    primary key (id)
)
create table training
(
    id             bigint not null auto_increment,
    date           varchar(255),
    training_topic varchar(255),
    user_id        bigint,
    primary key (id)
)
create table user
(
    id       bigint not null auto_increment,
    login    varchar(255),
    password varchar(255),
    primary key (id)
)
alter table approach
    add constraint approach_training foreign key (training_id) references training (id);
alter table approach
    add constraint approach_exercise foreign key (exercise_id) references exercise (id);
alter table training
    add constraint training_user foreign key (user_id) references user (id);

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

