package com.my.gym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "registrations")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;
    public Registration(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }



    public Workout getWorkouts() {
        return workout;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setWorkouts(Workout workout) {
        this.workout = workout;
    }
}
