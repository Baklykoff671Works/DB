package com.baklykoff.model.DAO;

import com.baklykoff.model.models.Worker;
import com.baklykoff.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerDao implements com.baklykoff.model.DAO.interfaces.WorkerDao {
    @Override
    public String getAll() {
        return "SELECT * FROM worker";
    }

    @Override
    public String getById() {
        return "SELECT * FROM worker WHERE worker.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT worker(first_name, last_name, position, passport_number, salary, permision, park_id) VALUES (?,?,?,?,?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE worker SET first_name=?, last_name=?, position=?, passport_number=?, salary=?, permision=?, park_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM worker WHERE id=?";
    }

    @Override
    public Worker recordEntity(ResultSet resultSet) throws SQLException {
        return (Worker) new Transformer<>(Worker.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Worker worker) throws SQLException {
        preparedStatement.setString(1, worker.getFirstName());
        preparedStatement.setString(2, worker.getLastName());
        preparedStatement.setString(3, worker.getPosition());
        preparedStatement.setInt(4, worker.getPassportNumber());
        preparedStatement.setFloat(5, worker.getSalary());
        preparedStatement.setInt(6, worker.getPermision());
        preparedStatement.setInt(7, worker.getParkId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Worker worker) throws SQLException {
        preparedStatement.setInt(8, worker.getId());
        return preparedStatement;
    }
}
