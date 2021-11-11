package net.estremadoyro.userservice.service;

import net.estremadoyro.userservice.model.Role;
import net.estremadoyro.userservice.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    // This should take a page parameter, loading all users at once is not efficient nor useful
    List<User> getUsers();
}
