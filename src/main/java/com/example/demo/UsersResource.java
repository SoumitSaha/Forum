package com.example.demo;

import com.example.demo.model.Users;
import com.example.demo.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersResource {
    private final UsersService usersService;

    public UsersResource(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getUsersById(@PathVariable("id") Long id) {
        Users users = usersService.findUsersById(id);
        if(users == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Email for user with id " + users.getId() + ": " +users.getEmail());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Users> addUsers(@RequestBody Users user) {
        Users newuser = usersService.addUsers(user);
        return new ResponseEntity<>(newuser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Users> updateUsers(@RequestBody Users user) {
        Users newuser = usersService.updateUsers(user);
        return new ResponseEntity<>(newuser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable("id") Long id) {
        usersService.deleteUsers(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
