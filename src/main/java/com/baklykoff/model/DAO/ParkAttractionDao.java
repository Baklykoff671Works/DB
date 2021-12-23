package com.baklykoff.model.DAO;

public class ParkAttractionDao implements com.baklykoff.model.DAO.interfaces.ParkAttractionDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("ParkAttraction");
        }
        return queryGenerator;
    }
}
