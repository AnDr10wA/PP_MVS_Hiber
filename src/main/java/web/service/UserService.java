package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> showAllUsers();
    public void addUser(User user);
    public void deleteUser(Long id);
    public void updateUser(User user);
    public User showUser(Long id);

}
