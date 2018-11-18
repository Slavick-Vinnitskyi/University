package com.lablll.labwork7;

import java.time.LocalDate;
import java.util.*;

public class DataBase {

//    "id",          "group",       "first_name", "last_name", "birth_date", "OOP", "DataBases", "Java"
//    "PRIMARY_KEY", "VARCHAR",     "VARCHAR",   "VARCHAR",   "DATE",        "INT", "INT",       "INT"

    private ArrayList<Map<String, Object>> table = new ArrayList<>();

    DataBase() {
        Map<String, Object> row = new HashMap<>();
        row.put("id", 0);
        row.put("group", "IP-64");
        row.put("first_name", "Slavick");
        row.put("last_name", "Vinnitskyi");
        row.put("birth_date", LocalDate.of(1998, 1, 3));
        row.put("OOP", 80);
        row.put("DataBases", 95);
        row.put("Java", 110);

        this.table.add(row);
    }

    Map<String, Object> select(int id) {
        int i = 0;
        for (Map<String, Object> value : table) {
            if (value.get("id").equals(id)) {
                return table.get(i);
            }
            i++;
        }
        return null;
    }

    public Map<String, Object> insert(Object id, Object group, Object firstName, Object lastName, Object birthDate, Object oop, Object dataBases, Object java) {

        Map<String, Object> row = new HashMap<>();

        row.put("id", id);
        row.put("group", group);
        row.put("first_name", firstName);
        row.put("last_name", lastName);
        row.put("birth_date", birthDate);
        row.put("OOP", oop);
        row.put("DataBases", dataBases);
        row.put("Java", java);
        this.table.add(row);

        return row;
    }

    public Map<String, Object> delete(Object id) {
        int i = 0;
        for (Map<String, Object> value : table) {
            if (value.get("id").equals(id)) {
                break;
            }
            i++;
        }
        table.remove(table.get(i));
        return null;
    }
}

