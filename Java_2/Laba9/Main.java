package com.lablll.labwork9;

public class Main {
    public static void main(String[] args) {

        ApiFactory factory = getFactory("QT");
        Button button = factory.createButton();
        button.paint();
//        TODO: Сделать UML похожей на пример из книги
    }


    private static ApiFactory getFactory(String api) {
        switch (api.toLowerCase()) {
            case "win":
                return new WinApi();
            case "gtk":
                return new GtkApi();
            case "qt":
                return new QtApi();
            default:
                throw new RuntimeException("No such api :" + api);
        }
    }
}
