package com.baklykoff.model.DAO;

import com.baklykoff.model.models.Attraction;
import com.baklykoff.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttractionDao implements com.baklykoff.model.DAO.interfaces.AttractionDao {
    @Override
    public String getAll() {
        return "SELECT * FROM attraction";
    }

    @Override
    public String getById() {
        return "SELECT * FROM attraction WHERE attraction.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT attraction(name, max_visitors, min_permision, has_option_vip) VALUES (?,?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE attraction SET name=?, max_visitors=?, min_permision=?, has_option_vip=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM attraction WHERE id=?";
    }

    @Override
    public Attraction recordEntity(ResultSet resultSet) throws SQLException {
        return (Attraction) new Transformer<>(Attraction.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Attraction attraction) throws SQLException {
        preparedStatement.setString(1, attraction.getName());
        preparedStatement.setInt(2, attraction.getMaxVisitors());
        preparedStatement.setInt(3, attraction.getMinPermision());
        preparedStatement.setInt(4, attraction.getHasOptionVip());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Attraction attraction) throws SQLException {
        preparedStatement.setInt(5, attraction.getId());
        return preparedStatement;
    }
}
