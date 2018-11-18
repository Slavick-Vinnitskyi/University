package com.lablll.labwork7;

import java.util.Map;

public class DeleteQuery implements Query {

    private Map<String, Object> save;
    private DataBase slavickDB;

    DeleteQuery(DataBase slavickDB) {
        this.slavickDB = slavickDB;
    }


    @Override
    public Object execute(String query) {
        try {

            int id = parseId(query);
            save = slavickDB.select(id);
            return this.slavickDB.delete(id);
        }catch (Exception ex) {
            System.out.println("You cannot delete row that does not exist!!!" + ex.getMessage());
        }
        return null;
    }

    @Override
    public void unExecute(String query) {
        try {
            slavickDB.insert(save.get("id"), save.get("group"), save.get("first_name"), save.get("last_name"), save.get("birth_date"), save.get("OOP"), save.get("DataBases"), save.get("Java"));
        }catch (Exception ex){
            System.out.println("You cannot execute undo delete for row that does not exist!!!" + ex.getMessage());
        }
    }

    private static int parseId(String query) {
        Parser.ParameterizedQuery parameterizedQuery = Parser.parse(query);

        return Integer.parseInt(parameterizedQuery.params[0].value);
    }
}
