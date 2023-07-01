package com.my.gym.repository;

import com.my.gym.model.Registration;
import com.my.gym.model.User;
import com.my.gym.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    @Query(value = "select * from registrations where workout_id =?1", nativeQuery = true)
    List<Registration> findByWorkout(Workout workout);
}
