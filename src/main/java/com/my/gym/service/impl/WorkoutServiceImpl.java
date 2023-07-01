package com.my.gym.service.impl;

import com.my.gym.model.Workout;
import com.my.gym.repository.WorkoutRepository;
import com.my.gym.service.WorkoutService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutServiceImpl implements WorkoutService {
    private WorkoutRepository workoutRepository;
    public WorkoutServiceImpl(WorkoutRepository workoutRepository){
        this.workoutRepository=workoutRepository;
    }
    @Override
    public Workout create(Workout workout) {
        return workoutRepository.save(workout);
    }

    @Override
    public Workout readById(long id) {
        Optional<Workout> optional = workoutRepository.findById(id);
        return optional.get();
    }

    @Override
    public Workout update(Workout workout) {
        Workout oldUser = readById(workout.getId());
        return workoutRepository.save(workout);
    }

    @Override
    public void delete(long id) {
        workoutRepository.deleteById(id);
    }

    @Override
    public List<Workout> getAll() {
        List<Workout> workouts = workoutRepository.findAll();
        return workouts.isEmpty() ? new ArrayList<>() : workouts;
    }

}
