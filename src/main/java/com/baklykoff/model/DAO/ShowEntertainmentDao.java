package com.baklykoff.model.DAO;

public class ShowEntertainmentDao implements com.baklykoff.model.DAO.interfaces.ShowEntertainmentDao {
    private QueryGenerator queryGenerator;

    @Override
    public QueryGenerator getQueryGenerator() {
        if (queryGenerator == null) {
            queryGenerator = new QueryGenerator("ShowEntertainment");
        }
        return queryGenerator;
    }
}
