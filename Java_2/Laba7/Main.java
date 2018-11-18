package com.lablll.labwork7;

public class Main {
    public static void main(String[] args) {

        DataBase db = new DataBase();

        User slavick = new User(new SelectQuery(db));

        for (int i = 0; i < 5; i++) {
            slavick.selectRow("SELECT * from dataBase WHERE id =" + i);
        }

        slavick = new User(new InsertQuery(db));
        for (int i = 1; i < 11; i++) {
            slavick.insertRow("INSERT into dataBase AS db (id=" + i + ",group='IP-64',first_name = 'Slavick', last_name = 'Vinnitskyi', birth_date='30-12-1998', OOP= " + (i * 10) + ", DataBases=" + (i * 9) + ", Java =" + (i * 8) + ")");
        }
        slavick.undoInsert("UNDO INSERT from db WHERE id = 4");
        slavick.undoInsert("UNDO INSERT from db WHERE id = 5");
        slavick = new User(new SelectQuery(db));
        for (int i = 0; i < 11; i++) {
            slavick.selectRow("SELECT * from dataBase WHERE id = " + i);
        }

        slavick = new User(new DeleteQuery(db));
        slavick.deleteRow("DELETE * from db WHERE id = 10");
        slavick.undoDelete("DELETE * from db WHERE id =10");

    }
}
