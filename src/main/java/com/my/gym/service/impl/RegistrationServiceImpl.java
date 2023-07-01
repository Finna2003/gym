package com.my.gym.service.impl;

import com.my.gym.exception.NullEntityReferenceException;
import com.my.gym.model.Registration;
import com.my.gym.model.User;
import com.my.gym.model.Workout;
import com.my.gym.repository.RegistrationRepository;
import com.my.gym.service.RegistrationService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationRepository registrationRepository;
    public RegistrationServiceImpl(RegistrationRepository registrationRepository){
        this.registrationRepository=registrationRepository;
    }
    @Override
    public Registration create(Registration registration) {
        if (registration != null) {
        return registrationRepository.save(registration);}
        throw new NullEntityReferenceException("User cannot be 'null'");
    }

    @Override
    public Registration readById(long id) {
        Optional<Registration> optional = registrationRepository.findById(id);
        return optional.get();
    }

    @Override
    public Registration update(Registration registration) {
        Registration oldUser = readById(registration.getId());
        return registrationRepository.save(registration);
    }

    @Override
    public void delete(long id) {
        registrationRepository.deleteById(id);
    }

    @Override
    public List<Registration> getAll() {
        List<Registration> registrations = registrationRepository.findAll();
        return registrations.isEmpty() ? new ArrayList<>() : registrations;
    }
    @Override
   public  List<Registration> findByWorkout(Workout workout){
        List<Registration> registrations = registrationRepository.findByWorkout(workout);
        return registrations.isEmpty() ? new ArrayList<>() : registrations;
    }
}
