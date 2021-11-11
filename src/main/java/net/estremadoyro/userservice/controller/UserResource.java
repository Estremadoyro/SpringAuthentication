package net.estremadoyro.userservice.controller;

import lombok.RequiredArgsConstructor;
import net.estremadoyro.userservice.model.User;
import net.estremadoyro.userservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserResource {
    // Constructs the userService with @RequiredArgsConstructor
    private final UserService userService;

    @GetMapping("/users")
    // ResponseEntity ==> Represents the whole HTTP response
    public ResponseEntity<List<User>> getUsers() {
        // ResponseEntity is a generic type, its response body can have any type
        // ok()   -> Represents the response status
        // body() -> The response contents
        return ResponseEntity.ok().body(userService.getUsers());
    }

}
