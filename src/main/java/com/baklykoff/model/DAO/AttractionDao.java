package com.baklykoff.model.DAO;

public class AttractionDao implements com.baklykoff.model.DAO.interfaces.AttractionDao {

    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("Attraction");
        }
        return queryGenerator;
    }
}
