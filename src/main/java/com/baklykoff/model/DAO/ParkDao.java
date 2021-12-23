package com.baklykoff.model.DAO;

public class ParkDao implements com.baklykoff.model.DAO.interfaces.ParkDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Park");
        }
        return queryGenerator;
    }
}
