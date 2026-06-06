package ru.vsu.cs.demolang.runtime;

import java.util.Scanner;
import java.util.Locale;
import java.util.Random;

public class Runtime {

    private static final Random rnd = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    static {
        Locale.setDefault(Locale.ROOT);
    }

    public static void print(String p0) {
        System.out.print(p0);
    }

    public static void println(String p0) {
        System.out.println(p0);
    }

    public static void println_empty() {
        System.out.println();
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static String convert_int(int v) {
        return "" + v;
    }

    public static String convert_float(double v) {
        return "" + v;
    }

    public static String convert_bool(boolean v) {
        return "" + v;
    }

    public static int to_int(String s) {
        return Integer.parseInt(s);
    }

    public static double to_float(String s) {
        return Double.parseDouble(s);
    }

    public static String concat(String a, String b) {
        return a + b;
    }

    public static int compare(String a, String b) {
        return a.compareTo(b);
    }

    public static int length(String s) {
        return s.length();
    }

    public static int rnd(int max) {
        return rnd.nextInt(max);
    }

    public static double sqrt(double v) {
        return Math.sqrt(v);
    }

    public static int abs_int(int v) {
        return Math.abs(v);
    }

    public static double abs_float(double v) {
        return Math.abs(v);
    }
}