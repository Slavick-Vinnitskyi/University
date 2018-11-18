package com.lablll.labwork2;

/**
 * Class implements creation of objects Cl1,Cl2,Cl3
 */
public class Main {
    public static void main(String[] args) {
        Cl1 cl1 = new Cl1();
        System.out.println("Obj 1 : " + cl1.meth1());
        System.out.println("Obj 1 : " + cl1.meth2());
        Cl2 cl2 = new Cl2();
        System.out.println("Obj 2 : " + cl2.meth2());
        System.out.println("Obj 2 : " + cl2.meth1());
        Cl3 cl3 = new Cl3();
        System.out.println("Obj 3 : " + cl3.meth1());
        System.out.println("Obj 3 : " + cl3.meth2());
        System.out.println("Obj 3 : " + cl3.meth3());
    }
}