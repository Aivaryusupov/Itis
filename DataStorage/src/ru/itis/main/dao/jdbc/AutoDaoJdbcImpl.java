package ru.itis.main.dao.jdbc;


import ru.itis.main.dao.AutoDao;
import ru.itis.main.models.Auto;
import ru.itis.main.models.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoDaoJdbcImpl implements AutoDao {

    private Connection connection;

    //language=SQL
    private final String SQL_INSERT_AUTO
            = "INSERT INTO auto (model,color,carmileage,used,owner_id) VALUES (?,?,?,?,?)";
    //language=SQL
    private final String SQL_SELECT_AUTO_BY_USED
            = "SELECT * FROM auto WHERE used=? OR carmileage > 0";

    //language=SQL
    private final String SQL_SELECT_AUTO_BY_ID
            = "SELECT * FROM auto WHERE id=?";
    //language=SQL
    private final String SQL_SELECT_ALL_AUTO
            = "SELECT * FROM auto";
    //language=SQL
    private final String SQL_DELETE_AUTO_BY_ID
            = "DELETE FROM auto WHERE id=?";
    //language=SQL
    private final String SQL_UPDATE_AUTO_BY_ID
            = "UPDATE auto SET model=?,color=?,carmilage=?,used=?,owner_id=? WHERE id=?";
    //language=SQL
    private final String SQL_SELECT_ALL_AUTO_BY_OWNER
            = "SELECT * FROM auto WHERE owner_id = ?";

    public AutoDaoJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Auto find(int id) {

        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_AUTO_BY_ID);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            result.next();
            Auto auto = new Auto.Builder()
                    .id(result.getInt("id"))
                    .model(result.getString("model"))
                    .color(result.getString("color"))
                    .carMileage(result.getDouble("carmileage"))
                    .used(result.getBoolean("used"))
                    .idOwner(result.getInt("owner_id"))
                    .build();
            return auto;

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public int save(Auto model) {

        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_AUTO, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, model.getModel());
            statement.setString(2, model.getColor());
            statement.setDouble(3, model.getCarMileage());
            statement.setBoolean(4, model.isUsed());
            statement.setInt(5, model.getOwner());
            int addRowsCount = statement.executeUpdate();
            if (addRowsCount == 0) {
                throw new IllegalArgumentException("not save new auto");
            }
            ResultSet result = statement.getGeneratedKeys();
            result.next();
            return result.getInt(1);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_AUTO_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void update(Auto model) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_AUTO_BY_ID);
            preparedStatement.setString(1, model.getModel());
            preparedStatement.setString(2, model.getColor());
            preparedStatement.setDouble(3, model.getCarMileage());
            preparedStatement.setBoolean(4, model.isUsed());
            preparedStatement.setInt(5, model.getOwner());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Auto> findAll() {
        try {
            List<Auto> autos = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_AUTO);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Auto auto = new Auto.Builder()
                        .id(result.getInt("id"))
                        .model(result.getString("model"))
                        .color(result.getString("color"))
                        .carMileage(result.getDouble("carmileage"))
                        .used(result.getBoolean("used"))
                        .idOwner(result.getInt("owner_id"))
                        .build();
                autos.add(auto);
            }
            return autos;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Auto> findAllByUsed() {

        try {
            List<Auto> autos = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_AUTO_BY_USED);
            preparedStatement.setBoolean(1, true);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                Auto auto = new Auto.Builder()
                        .id(result.getInt("id"))
                        .model(result.getString("model"))
                        .color(result.getString("color"))
                        .carMileage(result.getDouble("carmileage"))
                        .used(result.getBoolean("used"))
                        .idOwner(result.getInt("owner_id"))
                        .build();
                autos.add(auto);
            }
            return autos;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Auto> findAllAutoByOwner(User user) {
        try {
            List<Auto> autos = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_AUTO_BY_OWNER);
            preparedStatement.setInt(1,user.getId());
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                Auto auto = new Auto.Builder()
                        .id(result.getInt("id"))
                        .model(result.getString("model"))
                        .color(result.getString("color"))
                        .carMileage(result.getDouble("carmileage"))
                        .used(result.getBoolean("used"))
                        .idOwner(result.getInt("owner_id"))
                        .build();
                autos.add(auto);
            }
            return autos;
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }


    }
}
