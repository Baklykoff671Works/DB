package com.baklykoff.model.DAO;

import com.baklykoff.model.models.ParkAttraction;
import com.baklykoff.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkAttractionDao implements com.baklykoff.model.DAO.interfaces.ParkAttractionDao {
    @Override
    public String getAll() {
        return "SELECT * FROM park_attraction";
    }

    @Override
    public String getById() {
        return "SELECT * FROM park_attraction WHERE park_attraction.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT park_attraction(park_id, attraction_id) VALUES (?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE park_attraction SET park_id=?, attraction_id=? WHERE park_attraction.id = ?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM park_attraction WHERE park_attraction.id = ?";
    }

    @Override
    public ParkAttraction recordEntity(ResultSet resultSet) throws SQLException {
        return (ParkAttraction) new Transformer<>(ParkAttraction.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, ParkAttraction parkAttraction) throws SQLException {
        preparedStatement.setInt(1, parkAttraction.getParkId());
        preparedStatement.setInt(2, parkAttraction.getAttractionId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, ParkAttraction parkAttraction) throws SQLException {
        preparedStatement.setInt(3, parkAttraction.getId());
        return preparedStatement;
    }
}
