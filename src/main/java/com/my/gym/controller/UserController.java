package com.my.gym.controller;

import com.my.gym.model.User;
import com.my.gym.service.RoleService;
import com.my.gym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.AttributedString;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("user")@Valid  User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "create-user";
        }

        user.setPassword(user.getPassword());
        user.setRole(roleService.readById(2));
        userService.create(user);
        return "redirect:/users/all";
    }

    @GetMapping("/{user_id}/update")
    public String update(Model model, @PathVariable(name="user_id") Integer user_id) {
        User user=userService.readById(user_id);
        model.addAttribute("user",user);
        return "update-user";
    }
    @PostMapping("/{user_id}/update")
    public String update(@PathVariable("user_id") int user_id, @ModelAttribute("user")@Valid  User user, BindingResult result) {
        if (result.hasErrors() || user.getPassword().equals(userService.readById(user_id).getPassword())) {
            return "update-user";
        }
        user.setId(user_id);
        userService.update(user);
        return "redirect:/users/all";
    }

    @GetMapping("/{user_id}/delete")
    public String delete(@PathVariable(name="user_id") Integer user_id) {
        userService.delete(user_id);
        return "redirect:/users/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        List<User> userList = userService.getAll();
        model.addAttribute("userList", userList);
        return "users-list";
    }
}
