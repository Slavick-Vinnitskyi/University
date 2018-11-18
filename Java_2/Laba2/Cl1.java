package com.lablll.labwork2;

/**
 * This class Cl1 implements methods from interface If1
 *  Agregete Cl1
 */
public class Cl1 implements If1 {

    public Cl1 class1;

    @Override
    public String meth1() {
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        return methodName + ":::" + this.getClass().getSimpleName();
    }

    @Override
    public String meth2() {
        String methodName = new Object() {
        }.getClass().getEnclosingMethod().getName();
        return methodName + ":::" + this.getClass().getSimpleName();
    }
}
