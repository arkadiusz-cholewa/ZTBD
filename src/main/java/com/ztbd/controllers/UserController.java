package com.ztbd.controllers;

import com.ztbd.models.User;
import com.ztbd.repositories_mongodb.UserNoSQLRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class UserController {
    private UserNoSQLRepository userRepository;

    public UserController(UserNoSQLRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}