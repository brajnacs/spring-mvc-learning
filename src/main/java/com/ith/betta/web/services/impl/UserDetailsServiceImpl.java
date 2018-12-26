package com.ith.betta.web.services.impl;

import com.ith.betta.web.models.User;
import com.ith.betta.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        Optional<User> user = userRepository.findByEmail(username);
        if (user.isPresent()) {
            User dbUser = user.get();
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(dbUser.getPassword());
            String[] authorities = {"ROLE_USER"};
            builder.authorities(authorities);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
        return builder.build();
    }
}
