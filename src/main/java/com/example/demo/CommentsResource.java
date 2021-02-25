package com.example.demo;

import com.example.demo.model.Comments;
import com.example.demo.model.Discussion;
import com.example.demo.model.Users;
import com.example.demo.services.CommentsService;
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
public class CommentsResource {
    private final CommentsService commentsService;
    private final UsersService usersService;
    private final DiscussionService discussionService;

    public CommentsResource(CommentsService commentsService, UsersService usersService, DiscussionService discussionService) {
        this.commentsService = commentsService;
        this.usersService = usersService;
        this.discussionService = discussionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comments>> getAllComments() {
        List<Comments> comments = commentsService.findAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Comments> getCommentsById(@PathVariable("id") Long id) {
        Comments comments = commentsService.findCommentsById(id);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    public Boolean validitycheck(Comments comments) {
        Users user = usersService.findUsersById(comments.getUser_id().getId());
        if(user == null) {
            return Boolean.FALSE;
        }
        Discussion discussion = discussionService.findDiscussionById(comments.getDiscussion_id().getid());
        if(discussion == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addComments(@RequestBody Comments comments) {
        if(validitycheck(comments) == Boolean.FALSE) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
        Comments newcomments = commentsService.addComments(comments);
        newcomments.setPosted_at(new Timestamp(new Date().getTime()));
        return new ResponseEntity<>(newcomments, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Comments> updateComments(@RequestBody Comments comments) {
        if(validitycheck(comments) == Boolean.FALSE) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
        Discussion discussion = discussionService.findDiscussionById(comments.getDiscussion_id().getid());
        if(discussion == null) {
            return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        }
        Comments newcomments = commentsService.updateComments(comments);
        return new ResponseEntity<>(newcomments, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComments(@PathVariable("id") Long id) {
        commentsService.deleteComments(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

