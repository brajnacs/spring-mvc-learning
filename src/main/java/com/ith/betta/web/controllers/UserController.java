package com.ith.betta.web.controllers;

import com.ith.betta.web.models.User;
import com.ith.betta.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping(value = "/users")
    public ModelAndView index(Model model) {
        ArrayList<User> users = (ArrayList<User>)userRepository.findAll();
        ModelAndView mv = new ModelAndView("userindex");
        mv.addObject("users", users);
        return mv;
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity show(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity create(@RequestBody User user) {
        return new ResponseEntity(userRepository.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity update(@PathVariable Long userId, @RequestBody User userRequest) {
        Optional<User> user = userRepository.findById(userId);
        User userToUpdate = user.get();
        userToUpdate.setEmail(userRequest.getEmail());
        userToUpdate.setFirstName(userRequest.getFirstName());
        userToUpdate.setLastName(userRequest.getLastName());
        userToUpdate.setPassword(userRequest.getPassword());

        return new ResponseEntity(userRepository.save(userToUpdate), HttpStatus.OK);

    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity delete(@PathVariable Long userId) {
        userRepository.deleteById(userId);
        return new ResponseEntity(null, HttpStatus.ACCEPTED);
    }

}
