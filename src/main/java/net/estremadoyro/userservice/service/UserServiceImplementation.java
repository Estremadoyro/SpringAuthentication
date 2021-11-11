package net.estremadoyro.userservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.estremadoyro.userservice.model.Role;
import net.estremadoyro.userservice.model.User;
import net.estremadoyro.userservice.repository.RoleRepo;
import net.estremadoyro.userservice.repository.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/*
* @Service                 ==> Indicates a bean and holds the business logic
* @RequiredArgsConstructor ==> Needed to inject UserRepo & RoleRepo
* @Transactional           ==> Semantics of a transaction in a method, catches errors
* @Slf4j                   ==> Generates a logger field
*/
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImplementation implements UserService {
    /* @RequiredArgsConstructor -> Generates constructor arguments UNLESS those are:
    * --> Non-final fields
    * --> Initialized final fields
    * --> Static fields
    */
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving {} into database", user.getName());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving {} into database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role {} to {}", roleName, username);
        User user = userRepo.findByUserName(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Retrieving user: {}", username);
        return userRepo.findByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }
}
