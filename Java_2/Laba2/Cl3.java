package com.lablll.labwork2;

import java.io.Serializable;

/**
 * This class Cl2 implements methods from interface If3
 * Agregete If1
 */
public class Cl3 implements If3 {

    public If1 interface1 = new Cl2();


    @Override
    public String meth3() {

        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        return "interface1.meth1: " + interface1.meth1()  + "\t" + methodName + ":::" + this.getClass().getSimpleName();
    }

    @Override
    public String meth2() {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        return methodName + ":::" + this.getClass().getSimpleName();
    }

    @Override
    public String meth1() {
        String methodName = new Object() {}.getClass().getEnclosingMethod().getName();
        return methodName + ":::" + this.getClass().getSimpleName();
    }
}
