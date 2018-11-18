package com.lablll.labwork8;

public class Main {

    public static void main(String[] args) {

        Texture oval = new Component("овал", "зелёный");
        Texture line = new Component("линия", "коричневая");
        Texture square = new Component("квадрат", "зелёный");


        SmallComposite leaf = new SmallComposite("листок");
        leaf.addComponent(oval);

        SmallComposite treeTrunk = new SmallComposite("cтолп");
        treeTrunk.addComponent(line);

        SmallComposite grass = new SmallComposite("трава");
        grass.addComponent(leaf);

        SmallComposite land = new SmallComposite("земля");
        land.addComponent(square);


        //поле
        BigComposite field = new BigComposite("поле");
        field.addComponent(grass, land);

        BigComposite tree = new BigComposite("дерево");
        tree.addComponent(treeTrunk, leaf);

        GameArea gameArea = new GameArea();
        gameArea.addComponent(tree, field);


        GameArea gameAreaCopy = gameArea.copy();
        GameArea gameAreaDeepCopy = gameArea.deepCopy();
        gameArea.removeComponent(tree);

        ((Component) square).setColor("Black");
        System.out.println("Setting square color to black...");
        System.out.println(gameArea.toString());
        System.out.println(gameAreaCopy.toString());
        System.out.println(gameAreaDeepCopy.toString());


        System.out.println("Game area equals GameArea Copy : " + gameArea.equals(gameAreaCopy));
        System.out.println("Game area equals GameArea DeepCopy : " + gameArea.equals(gameAreaDeepCopy));

        ((Component) square).setColor("Yellow");
        System.out.println("Game area equals GameArea Copy : " + gameArea.equals(gameAreaCopy));
        System.out.println("Game area equals GameArea DeepCopy : " + gameArea.equals(gameAreaDeepCopy));
//        TODO: Заменить sout на логирование
//        TODO: Сделать логирование при выполнении каждой операции
    }
}
