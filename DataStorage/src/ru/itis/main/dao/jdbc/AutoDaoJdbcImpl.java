package ru.itis.main.dao.jdbc;


import ru.itis.main.dao.AutoDao;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;

import java.sql.Connection;
import java.util.List;

public class AutoDaoJdbcImpl implements AutoDao {

    private Connection connection;

    public AutoDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Auto find(int id) {
        return null;
    }

    @Override
    public int save(Auto model) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Auto model) {

    }

    @Override
    public List<Auto> findAll() {
        return null;
    }

    @Override
    public List<Auto> findAllByUsed() {
        return null;
    }

    @Override
    public List<Auto> findAllAutoByOwner(User user) {
        return null;
    }
}
