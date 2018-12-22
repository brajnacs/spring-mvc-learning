package com.ith.betta.web.controllers;

import com.ith.betta.web.models.Post;
import com.ith.betta.web.repositories.PostRepository;
import com.ith.betta.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{userId}/posts")
    public Iterable<Post> index(@PathVariable(value = "userId") Long userId) {
        Iterable<Post> posts = postRepository.findByUserId(userId);
        return posts;
    }
}
