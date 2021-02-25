package com.example.demo.repo;

import com.example.demo.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepo extends JpaRepository<Comments, Long> {
    void deleteCommentsById(Long id);
    Comments findCommentsById(Long id);
}