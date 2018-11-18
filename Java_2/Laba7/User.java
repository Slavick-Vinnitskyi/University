package com.lablll.labwork7;

public class User {

    private Query query;

    User(Query query) {
        this.query = query;
    }

    void selectRow(String queryStr) {
        System.out.println("Selected row : " + query.execute(queryStr));
    }

    void insertRow(String queryStr) {
        if(query.execute(queryStr) == null) {
            System.out.println("Row was not inserted! Please, set all the parameters");
        }
        else System.out.println("Row was inserted!");
    }

    void undoInsert(String queryStr) {
        query.unExecute(queryStr);
        System.out.println("Undo for insert action has been executed!");
    }

    void deleteRow(String queryStr) {
        query.unExecute(queryStr);
        System.out.println("Row was deleted!");

    }
    void undoDelete(String queryStr) {
        query.unExecute(queryStr);
            System.out.println("Undo for delete action has been executed!");

    }

}
