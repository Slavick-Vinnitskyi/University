package com.lablll.labwork5;

import java.util.Comparator;

/**
 * Managing class
 */
public class Main {
    public static void main(String[] args) {

        MyArrayList arrayList = new MyArrayList();
        MyIterator iterator = arrayList.getIterator();
        System.out.println("\tОбход по очереди :");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "; ");
        }
//        arrayList
                                            /*Сотрировка по длине*/
        MyIterator iterator1 = arrayList.getSortedIterator(Comparator.comparingInt(String::length));
                                            /*Сортировка по первой букве*/
        MyIterator iterator2 = arrayList.getSortedIterator(Comparator.comparingInt(value -> value.codePointAt(0)));
                                            /*Сортировка по всей строке*/
        MyIterator iterator3 = arrayList.getSortedIterator(Comparator.comparing(Object::toString));
        System.out.println("\n\tОбход с фильтрацией по длине:");
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + "; ");

        }
        System.out.println("\n\tОбход с фильтрацией по первой букве:");
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + "; ");

        }
        System.out.println("\n\tОбход с фильтрацией по всей строке :");
        while (iterator3.hasNext()) {
            System.out.print(iterator3.next() + "; ");

        }
    }
}