package com.my.gym.service;

import com.my.gym.model.User;
import com.my.gym.model.Workout;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface WorkoutService {
    Workout create(Workout workout);
    Workout  readById(long id);
    Workout update(Workout workout);
    void delete(long id);
    List<Workout> getAll();
}
