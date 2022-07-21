package org.example.utils;


import static org.example.utils.Color.RESET;

public class Writer {

    public static void print(Object obj, String color){
        System.out.print(obj + color + RESET);
    }
    public static void print(Object obj, String color, String bg){
        System.out.print(obj + bg + color + RESET);
    }

    public static void println(Object obj, String color){
        System.out.println(color + obj + RESET);
    }
    public static void println(Object obj){
        System.out.println(obj);
    }

    public static void println(){
        System.out.println();
    }
}
