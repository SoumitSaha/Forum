package com.example.demo.services;

import com.example.demo.model.Comments;
import com.example.demo.model.Discussion;
import com.example.demo.model.Users;
import com.example.demo.repo.CommentsRepo;
import com.example.demo.repo.DiscussionRepo;
import com.example.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentsService {
    private final CommentsRepo commentsRepo;
    private final UsersRepo usersRepo;
    private final DiscussionRepo discussionRepo;

    @Autowired
    public CommentsService(CommentsRepo commentsRepo, UsersRepo usersRepo, DiscussionRepo discussionRepo) {
        this.discussionRepo = discussionRepo;
        this.usersRepo = usersRepo;
        this.commentsRepo = commentsRepo;
    }

    public Comments addComments(Comments comments) {
        return commentsRepo.save(comments);
    }

    public List<Comments> findAllComments() {
        return commentsRepo.findAll();
    }

    public Comments updateComments(Comments comments) {
        return commentsRepo.save(comments);
    }

    public Comments findCommentsById(Long id) {
        return commentsRepo.findCommentsById(id);
    }

    @Transactional
    public void deleteComments(Long id) {
        commentsRepo.deleteCommentsById(id);
    }
}
