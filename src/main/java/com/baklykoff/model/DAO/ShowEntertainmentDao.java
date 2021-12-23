package com.baklykoff.model.DAO;

import com.baklykoff.model.models.ShowEntertainment;
import com.baklykoff.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowEntertainmentDao implements com.baklykoff.model.DAO.interfaces.ShowEntertainmentDao {
    @Override
    public String getAll() {
        return "SELECT * FROM show_entertainment";
    }

    @Override
    public String getById() {
        return "SELECT * FROM show_entertainment WHERE show_entertainment.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT show_entertainment(description, park_id) VALUES (?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE show_entertainment SET description=?, park_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM show_entertainment WHERE id=?";
    }

    @Override
    public ShowEntertainment recordEntity(ResultSet resultSet) throws SQLException {
        return (ShowEntertainment) new Transformer<>(ShowEntertainment.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, ShowEntertainment showEntertainment) throws SQLException {
        preparedStatement.setString(1, showEntertainment.getDescription());
        preparedStatement.setInt(2, showEntertainment.getParkId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, ShowEntertainment showEntertainment) throws SQLException {
        preparedStatement.setInt(3, showEntertainment.getId());
        return preparedStatement;
    }
}
