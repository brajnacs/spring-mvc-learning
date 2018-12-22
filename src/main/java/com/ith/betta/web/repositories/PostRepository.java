package com.ith.betta.web.repositories;

import com.ith.betta.web.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface PostRepository extends CrudRepository<Post, Long> {

    Iterable<Post> findByUserId(Long userId);
}
