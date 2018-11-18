package com.lablll.labwork2;

/**
 * This class Cl2 implements methods from interface If2 and extends class Cl1
 * Agregete Cl1
 */
public class Cl2 extends Cl1 implements If2 {

    public Cl1 class1 = new Cl1();

    @Override
    public String meth2() {
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        return class1.meth1() + " " + methodName + ":::" + this.getClass().getSimpleName();
    }

    @Override
    public String meth1() {
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        return methodName + ":::" + this.getClass().getSimpleName();
    }
}