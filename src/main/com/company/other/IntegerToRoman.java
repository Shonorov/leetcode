package com.company.other;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class IntegerToRoman {

    private static final Map<Integer, String> numToRoman = new TreeMap<>(Comparator.reverseOrder());

    static {
        numToRoman.put(1000, "M");
        numToRoman.put(900, "CM");
        numToRoman.put(500, "D");
        numToRoman.put(400, "CD");
        numToRoman.put(100, "C");
        numToRoman.put(90, "XC");
        numToRoman.put(50, "L");
        numToRoman.put(40, "XL");
        numToRoman.put(10, "X");
        numToRoman.put(9, "IX");
        numToRoman.put(5, "V");
        numToRoman.put(4, "IV");
        numToRoman.put(1, "I");
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            for (Integer i : numToRoman.keySet()) {
                if (num >= i) {
                    result.append(numToRoman.get(i));
                    num -= i;
                    break;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman app = new IntegerToRoman();
        System.out.println(app.intToRoman(2135)); // MMCXXXV
        System.out.println(app.intToRoman(58)); // LVIII
        System.out.println(app.intToRoman(3)); // III
        System.out.println(app.intToRoman(4)); // IV
        System.out.println(app.intToRoman(9)); // IX
        System.out.println(app.intToRoman(1994)); // MCMXCIV
    }
}
