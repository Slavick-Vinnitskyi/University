package com.lablll.labwork9;

public class QtApi implements ApiFactory {
    @Override
    public Button createButton() {
        return new QtButton();
    }
}
