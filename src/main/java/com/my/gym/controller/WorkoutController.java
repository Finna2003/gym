package com.my.gym.controller;

import com.my.gym.model.User;
import com.my.gym.model.Workout;
import com.my.gym.service.UserService;
import com.my.gym.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/workouts")
public class WorkoutController {
    private final UserService userService;
    private final WorkoutService workoutService;
    @Autowired
    public WorkoutController(UserService userService,WorkoutService workoutService){
        this.userService=userService;
        this.workoutService=workoutService;
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/create")
    public String create(Model model,@ModelAttribute("workout") Workout workout) {

        return "create-workout";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/create")
    public String create(@ModelAttribute("workout")@Valid Workout workout, BindingResult bindingResult, Authentication authentication) {
        if (bindingResult.hasErrors()){
            return "create-workout";
        }
        String userEmail = authentication.getName();
        User user = userService.findByEmail(userEmail);
        workout.setUser(user);
        workoutService.create(workout);
        return "redirect:/workouts/all";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(name="id") Integer id) {
        workoutService.delete(id);
        return "redirect:/workouts/all";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}/update")
    public String update(Model model, @PathVariable(name="id") Integer id) {
        Workout workout=workoutService.readById(id);
        model.addAttribute("workout",workout);
        return "update-workout";
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") int id, @ModelAttribute("workout")@Valid Workout workout, BindingResult result,Authentication authentication) {
        if (result.hasErrors() ) {
            return "update-user";
        }
        workout.setId(id);
        String userEmail = authentication.getName();
        User user = userService.findByEmail(userEmail);
        workout.setUser(user);
        workoutService.update(workout);
        return "redirect:/workouts/all";
    }
    @GetMapping("/all")
    public String getAll(Model model) {
        List<Workout> workouts = workoutService.getAll();
        model.addAttribute("workoutsList", workouts);
        return "workout-list";
    }
}
