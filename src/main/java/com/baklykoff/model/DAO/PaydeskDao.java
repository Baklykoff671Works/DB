package com.baklykoff.model.DAO;

public class PaydeskDao implements com.baklykoff.model.DAO.interfaces.PaydeskDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Paydesk");
        }
        return queryGenerator;
    }
}
