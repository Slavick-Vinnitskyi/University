package com.lablll.labwork9;

public class WinApi implements ApiFactory {
    @Override
    public Button createButton() {
        return new WinApiButton();
    }
}
