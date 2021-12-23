package com.baklykoff.model.DAO;

import com.baklykoff.model.models.Park;
import com.baklykoff.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkDao implements com.baklykoff.model.DAO.interfaces.ParkDao {

    @Override
    public String getAll() {
        return "SELECT * FROM park";
    }

    @Override
    public String getById() {
        return "SELECT * FROM park WHERE park.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT park(name, visitors, location, max_visitors) VALUES (?,?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE park SET name=?, visitors=?, location=?, max_visitors=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM park WHERE id=?";
    }

    @Override
    public Park recordEntity(ResultSet resultSet) throws SQLException {
        return (Park) new Transformer<>(Park.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Park park) throws SQLException {
        preparedStatement.setString(1, park.getName());
        preparedStatement.setInt(2, park.getVisitors());
        preparedStatement.setString(3, park.getLocation());
        preparedStatement.setInt(4, park.getMaxVisitors());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Park park) throws SQLException {
        preparedStatement.setInt(5, park.getId());
        return preparedStatement;
    }


}
