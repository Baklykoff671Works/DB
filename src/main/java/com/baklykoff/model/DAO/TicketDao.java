package com.baklykoff.model.DAO;

import com.baklykoff.model.models.Ticket;
import com.baklykoff.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDao implements com.baklykoff.model.DAO.interfaces.TicketDao {
    @Override
    public String getAll() {
        return "SELECT * FROM ticket";
    }

    @Override
    public String getById() {
        return "SELECT * FROM ticket WHERE ticket.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT ticket(expiration_date, start_date, is_vip, price, park_attraction_id) VALUES (?,?,?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE ticket SET expiration_date=?, start_date=?, is_vip=?, price=?, park_attraction_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM ticket WHERE id=?";
    }

    @Override
    public Ticket recordEntity(ResultSet resultSet) throws SQLException {
        return (Ticket) new Transformer<>(Ticket.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Ticket ticket) throws SQLException {
        preparedStatement.setString(1, ticket.getExpirationDate());
        preparedStatement.setString(2, ticket.getStartDate());
        preparedStatement.setInt(3, ticket.getIsVip());
        preparedStatement.setFloat(4, ticket.getPrice());
        preparedStatement.setInt(5, ticket.getParkAttractionId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Ticket ticket) throws SQLException {
        preparedStatement.setInt(6, ticket.getId());
        return preparedStatement;
    }
}
