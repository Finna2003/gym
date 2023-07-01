package com.my.gym.controller;

import com.my.gym.model.Registration;
import com.my.gym.model.User;
import com.my.gym.model.Workout;
import com.my.gym.repository.UserRepository;

import com.my.gym.security.SecurityUser;
import com.my.gym.service.RegistrationService;
import com.my.gym.service.UserService;
import com.my.gym.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {
    private final UserService userService;

//    private final UserDetails;

    private final UserRepository userRepository;
    private final WorkoutService workoutService;
    private final RegistrationService registrationService;
    @Autowired
    public RegistrationController(UserService userService,WorkoutService workoutService,RegistrationService registrationService,UserRepository userRepository){
        this.userService=userService;
        this.workoutService=workoutService;
        this.registrationService=registrationService;
        this.userRepository=userRepository;
    }
    @GetMapping("/create/workout/{workout_id}")
    public String create(Model model, @ModelAttribute("registration") Registration registration, @PathVariable(name = "workout_id") Integer workout_id,Authentication authentication) {
        String userEmail = authentication.getName();
        User user = userService.findByEmail(userEmail);
        model.addAttribute("user", user);
        model.addAttribute("registration", registration);
        model.addAttribute("workout", workoutService.readById(workout_id));
        return "create-registrations";
    }

    @PostMapping("/create/workout/{workout_id}")
    public String create(Model model, @ModelAttribute("registration") Registration registration, @PathVariable(name = "workout_id") Integer workout_id, BindingResult bindingResult,Authentication authentication) {
        if (bindingResult.hasErrors()) {
            return "create-registrations";
        }
        String userEmail = authentication.getName();
        User user = userService.findByEmail(userEmail);
        Workout workout = workoutService.readById(workout_id);
        registration.setUser(user);
        registration.setWorkouts(workout);
        registrationService.create(registration);
        return "redirect:/registrations/all/workout/"+workout_id;
    }
    @GetMapping("/all/workout/{workout_id}")
    public String getAll(Model model, @PathVariable(name = "workout_id") Integer workout_id) {
        List<Registration> registrations = registrationService.findByWorkout(workoutService.readById(workout_id));
        model.addAttribute("registrationsList", registrations);
        return "registration-list";
    }
    @GetMapping("/{id}/delete/workout/{workout_id}")
    public String delete(@PathVariable(name="id") Integer id,@PathVariable(name = "workout_id") Integer workout_id) {
        registrationService.delete(id);
        return "redirect:/registrations/all/workout/"+workout_id;
    }
}
