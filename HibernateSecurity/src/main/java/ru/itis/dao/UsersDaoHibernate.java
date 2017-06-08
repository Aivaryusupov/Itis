package ru.itis.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.itis.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UsersDaoHibernate implements UsersDao {

    private final static String JPA_FIND_ALL = "SELECT u FROM User u ";

    @PersistenceContext
    private EntityManager entityManager;

    public FilmsDaoHibernate() {
    }

    @Override
    public User find(int id) {
        User user = entityManager.createQuery(JPA_FIND_ALL +" where id = :id", User.class)
                .setParameter("id", id).getSingleResult();
        return user;
    }

    @Override
    public int save(User model) {
        entityManager.persist(model);
        entityManager.flush();
        return model.getId();
    }

    @Override
    public void update(User model) {
        entityManager.merge(model);
    }

    @Override
    public void delete(int id) {
        User user = find(id);
       entityManager.remove(user);
    }

    @Override
    public List<User> findAll() {

        List<User> users = entityManager.createQuery(JPA_FIND_ALL, User.class).getResultList();
        return users;
    }
}
