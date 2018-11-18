package com.lablll.labwork5;

import java.util.*;

public class MyArrayList {

    private static String[] tasks = {"Родиться", "Воспитать cына", "Построить дом", "Посадить дерево", "Уйти в монастырь", "Ты прошёл жизнь" };

    MyIterator getIterator() {
        return new MyOwnIterator();
    }

    MyIterator getSortedIterator(Comparator<String> cmp) {
        return new SortedIterator(cmp);
    }

    private class MyOwnIterator implements MyIterator {

        int index = 0;

        @Override
        public boolean hasNext() {

            return index < tasks.length;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }

    public static class SortedIterator implements MyIterator {
        int index = 0;
        Comparator<String> comparator;
        String[] strings;

        SortedIterator(Comparator<String> cmp) {
            this.comparator = cmp;
            strings = Arrays.stream(tasks).sorted(cmp).toArray(String[]::new);
        }

        @Override
        public boolean hasNext() {
        return index < tasks.length;
        }

        @Override
        public Object next() {
            return strings[index++];
        }
    }
}
