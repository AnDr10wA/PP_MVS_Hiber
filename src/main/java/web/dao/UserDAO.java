package web.dao;

import web.model.User;

import java.util.List;
public interface UserDAO {
    public List<User> showAllUsers();
    public void addUser(User user);
    public void deleteUser(User user);
    public void updateUser(User user);
    public User showUser(Long id);
}
