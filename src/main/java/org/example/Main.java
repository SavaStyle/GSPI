package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println(countGoodDivisions("aacaba"));
    }

    public static int countGoodDivisions(String s) {
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            String p = s.substring(0, i);
            String q = s.substring(i);

            if (countElements(p) == countElements(q)) {
                count++;
            }
        }
        return count;
    }

    public static int countElements(String str) {
        int count = 0;
        boolean[] distinct = new boolean[256];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!distinct[c]) {
                distinct[c] = true;
                count++;
            }
        }
        return count;
    }
}


/*
* Имеется строка s на входе. Разделение этой строки на 2 непустые подстроки p и q называется хорошим тогда и только тогда,
когда конкатенация этих строк дает строку s и количество различных элементов в подстроке p равно количеству различных в q.
Напишите метод, принимающий строку s, который подсчитывает количество "хороших" разделений строки s.

* Например: aacaba
1. a - acaba (1 - 3)
2. aa - caba (1 - 3)
3. aac - aba (2 - 2) +
4. aaca - ba (2 - 2) +
5. aacab - a (3 - 1)

Итого 2 хороших разбиения
 */