package com.ith.betta.web.repositories;

import com.ith.betta.web.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByLastName(String lastName);

    Optional<User> findByEmail(String username);
}
