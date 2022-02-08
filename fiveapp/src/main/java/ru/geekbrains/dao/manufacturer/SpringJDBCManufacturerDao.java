package ru.geekbrains.dao.manufacturer;

import lombok.RequiredArgsConstructor;
import ru.geekbrains.dao.Dao;
import ru.geekbrains.entity.Manufacturer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

//@Component
@RequiredArgsConstructor
public class SpringJDBCManufacturerDao implements Dao<Manufacturer> {

    private final DataSource dataSource;

    @Override
    public Iterable<Manufacturer> findAll() {
        Connection connection = null;
        Set<Manufacturer> result = new HashSet<>();

        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM manufacturer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                final Manufacturer manufacturer = Manufacturer.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .build();
                result.add(manufacturer);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    @Override
    public Manufacturer findById(Long id) {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Manufacturer product) {

    }

    @Override
    public void update(Manufacturer product) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
