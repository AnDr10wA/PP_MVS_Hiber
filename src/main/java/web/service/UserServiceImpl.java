package web.service;


import org.springframework.stereotype.Service;
import web.dao.UserDAO;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<User> showAllUsers() {
        return userDAO.showAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(showUser(id));
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public User showUser(Long id) {
        return userDAO.showUser(id);
    }
}
