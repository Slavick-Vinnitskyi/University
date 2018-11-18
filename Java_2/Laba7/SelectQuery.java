package com.lablll.labwork7;

public class SelectQuery implements Query {

    private DataBase slavickDB;

    SelectQuery(DataBase dataBase) {

        this.slavickDB = dataBase;
    }

    @Override
    public Object execute(String query) throws IndexOutOfBoundsException {
        int id = parseId(query);
        Object o = slavickDB.select(id);
        if (o == null) {
            return "This row does`nt exist!!";
        }
        return o;
    }

    @Override
    public void unExecute(String query) {
        System.out.println("You cannot undo a SELECT statement!!");
    }

    private static int parseId(String query) {
        Parser.ParameterizedQuery query1 = Parser.parse(query);
        return Integer.parseInt(query1.params[0].value);
    }
}
