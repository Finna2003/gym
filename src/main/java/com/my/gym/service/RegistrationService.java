package com.my.gym.service;

import com.my.gym.model.Registration;
import com.my.gym.model.Workout;

import java.util.List;

public interface RegistrationService {
    Registration create(Registration registration);
    Registration  readById(long id);
    Registration update(Registration registration);
    void delete(long id);
    List<Registration> findByWorkout(Workout workout);
    List<Registration> getAll();
}
