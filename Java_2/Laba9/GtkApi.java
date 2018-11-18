package com.lablll.labwork9;

public class GtkApi implements ApiFactory {

    @Override
    public Button createButton() {
        return new GthApiButton();
    }
}
