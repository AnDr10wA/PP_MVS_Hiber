package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public List<User> showAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
        entityManager.flush();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User showUser(Long id) {
        return entityManager.find(User.class, id);
    }
}
