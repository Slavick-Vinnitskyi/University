package com.lablll.labwork4;

/**
 * My Flyweight
 */
public class EnglishCharacter {
    char c;
    EnglishCharacter(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "{" +
                "char=" + c +
                '}';
    }
}
