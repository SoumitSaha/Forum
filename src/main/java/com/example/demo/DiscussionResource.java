package com.example.demo;

import com.example.demo.model.Discussion;
import com.example.demo.model.Users;
import com.example.demo.services.DiscussionService;
import com.example.demo.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/discussions")
public class DiscussionResource {
    private final DiscussionService discussionService;
    private final UsersService usersService;

    public DiscussionResource(DiscussionService discussionService, UsersService usersService) {
        this.discussionService = discussionService;
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Discussion>> getAllDiscussion() {
        List<Discussion> discussion = discussionService.findAllDiscussion();
        return new ResponseEntity<>(discussion, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Discussion> getDiscussionById(@PathVariable("id") Long id) {
        Discussion discussion = discussionService.findDiscussionById(id);
        return new ResponseEntity<>(discussion, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addDiscussion(@RequestBody Discussion discussion) {
        Users user = usersService.findUsersById(discussion.getUser_id().getId());
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
        Discussion newdiscussion = discussionService.addDiscussion(discussion);
        newdiscussion.setPosted_at(new Timestamp(new Date().getTime()));
        return new ResponseEntity<>(newdiscussion, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Discussion> updateDiscussion(@RequestBody Discussion discussion) {
        Users user = usersService.findUsersById(discussion.getUser_id().getId());
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
        Discussion newdiscussion = discussionService.updateDiscussion(discussion);
        return new ResponseEntity<>(newdiscussion, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDiscussion(@PathVariable("id") Long id) {
        discussionService.deleteDiscussion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
