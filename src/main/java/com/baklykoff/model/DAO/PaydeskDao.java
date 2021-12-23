package com.baklykoff.model.DAO;

import com.baklykoff.model.models.Paydesk;
import com.baklykoff.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaydeskDao implements com.baklykoff.model.DAO.interfaces.PaydeskDao {
    @Override
    public String getAll() {
        return "SELECT * FROM paydesk";
    }

    @Override
    public String getById() {
        return "SELECT * FROM paydesk WHERE paydesk.id = ?";
    }

    @Override
    public String createElem() {
        return "INSERT paydesk(attraction_id, has_ticket, park_id) VALUES (?,?,?)";
    }

    @Override
    public String updateElem() {
        return "UPDATE paydesk SET attraction_id=?, has_ticket=?, park_id=? WHERE id=?";
    }

    @Override
    public String removeElem() {
        return "DELETE FROM paydesk WHERE id=?";
    }

    @Override
    public Paydesk recordEntity(ResultSet resultSet) throws SQLException {
        return (Paydesk) new Transformer<>(Paydesk.class).extractModelFromData(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Paydesk paydesk) throws SQLException {
        preparedStatement.setInt(1, paydesk.getAttractionId());
        preparedStatement.setInt(2, paydesk.getHasTicket());
        preparedStatement.setInt(3, paydesk.getParkId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Paydesk paydesk) throws SQLException {
        preparedStatement.setInt(4, paydesk.getId());
        return preparedStatement;
    }
}
