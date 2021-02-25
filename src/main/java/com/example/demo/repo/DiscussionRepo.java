package com.example.demo.repo;

import com.example.demo.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionRepo extends JpaRepository<Discussion, Long> {
    void deleteDiscussionById(Long id);
    Discussion findDiscussionById(Long id);
}