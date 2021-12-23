package com.baklykoff.model.DAO;

public class TicketDao implements com.baklykoff.model.DAO.interfaces.TicketDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Ticket");
        }
        return queryGenerator;
    }
}
