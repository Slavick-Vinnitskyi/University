package com.lablll.labwork7;

public interface Query {

    Object execute(String query);

    void unExecute(String query);
}
