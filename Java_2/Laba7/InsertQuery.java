package com.lablll.labwork7;

public class InsertQuery implements Query {

    private DataBase slavickDB;

    InsertQuery(DataBase slavickDB) {
        this.slavickDB = slavickDB;
    }

    @Override
    public Object execute (String queryStr) {
        Object[] data = parseDataForInsert(queryStr);

        if (data.length != 8) {
            return null;
        }

        return this.slavickDB.insert(Integer.valueOf(String.valueOf(data[0])), data[1], data[2], data[3], data[4],
                Integer.parseInt((String) data[5]), Integer.parseInt((String) data[6]), Integer.parseInt((String) data[7]));
    }

    @Override
    public void unExecute(String queryStr) {
        this.slavickDB.delete(parseId(queryStr));
    }

    private static int parseId(String query) {
    Parser.ParameterizedQuery parameterizedQuery = Parser.parse(query);
    return Integer.parseInt(parameterizedQuery.params[0].value);

    }

    private static Object[] parseDataForInsert(String query) {

        Parser.ParameterizedQuery parameterizedQuery = Parser.parse(query);
        Object[] data = new Object[parameterizedQuery.params.length];
        for(int i = 0; i < parameterizedQuery.params.length; i++) {
            data[i] = parameterizedQuery.params[i].value;
        }
        return data;
    }
}
