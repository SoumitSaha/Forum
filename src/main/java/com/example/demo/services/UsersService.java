package com.example.demo.services;

import com.example.demo.model.Users;
import com.example.demo.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsersService {
    private final UsersRepo usersRepo;

    @Autowired
    public UsersService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public Users addUsers(Users users) {
        return usersRepo.save(users);
    }

    public List<Users> findAllUsers() {
        return usersRepo.findAll();
    }

    public Users updateUsers(Users users) {
        return usersRepo.save(users);
    }

    public Users findUsersById(Long id) {
        return usersRepo.findUsersById(id);
    }

    @Transactional
    public void deleteUsers(Long id) {
        usersRepo.deleteUsersById(id);
    }
}
