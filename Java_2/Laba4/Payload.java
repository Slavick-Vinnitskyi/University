package com.lablll.labwork4;

public class Payload {

//    private char symbol;

    public StringBuilder draw(char c, int x, int y) {

        StringBuilder returnStr = new StringBuilder();
        returnStr
                .append(c)
                .append("(")
                .append(x)
                .append(":")
                .append(y)
                .append(")");

        return returnStr;
    }
}