package com.baklykoff.model.DAO;

import com.baklykoff.model.models.Visitor;
import com.baklykoff.model.models.Worker;
import com.baklykoff.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VisitorDao implements com.baklykoff.model.DAO.interfaces.VisitorDao {
    @Override
    public String getAll() {
        return "SELECT * FROM visitor";
    }

    @Override
    public String getById() {
        return "SELECT * FROM visitor WHERE visitor.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT visitor(first_name, last_name, ticket_id) VALUES (?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE visitor SET first_name=?, last_name=?, ticket_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM visitor WHERE id=?";
    }

    @Override
    public Visitor recordEntity(ResultSet resultSet) throws SQLException {
        return (Visitor) new Transformer<>(Visitor.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Visitor visitor) throws SQLException {
        preparedStatement.setString(1, visitor.getFirstName());
        preparedStatement.setString(2, visitor.getLastName());
        preparedStatement.setInt(3, visitor.getTicketId());

        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Visitor visitor) throws SQLException {
        preparedStatement.setInt(4, visitor.getId());
        return preparedStatement;
    }
}
