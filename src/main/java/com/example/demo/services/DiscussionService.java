package com.example.demo.services;

import com.example.demo.model.Discussion;
import com.example.demo.model.Users;
import com.example.demo.repo.DiscussionRepo;
import com.example.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DiscussionService {
    private final DiscussionRepo discussionRepo;
    private final UsersRepo usersRepo;

    @Autowired
    public DiscussionService(DiscussionRepo discussionRepo, UsersRepo usersRepo) {
        this.discussionRepo = discussionRepo;
        this.usersRepo = usersRepo;
    }

    public Discussion addDiscussion(Discussion discussion) {
        return discussionRepo.save(discussion);
    }

    public List<Discussion> findAllDiscussion() {
        return discussionRepo.findAll();
    }

    public Discussion updateDiscussion(Discussion discussion) {
        return discussionRepo.save(discussion);
    }

    public Discussion findDiscussionById(Long id) {
        return discussionRepo.findDiscussionById(id);
    }

    @Transactional
    public void deleteDiscussion(Long id) {
        discussionRepo.deleteDiscussionById(id);
    }
}
