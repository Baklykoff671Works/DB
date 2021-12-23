package com.baklykoff.model.DAO;

public class VisitorDao implements com.baklykoff.model.DAO.interfaces.VisitorDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Visitor");
        }
        return queryGenerator;
    }
}
