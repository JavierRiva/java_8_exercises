package com.javier;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String a = "           YES      leading spaces        are valid,    problemsetters are         evillllll   ";
        String b = "boo:and:foo";
        String[] arrb = b.split("b");
        String[] arr = a.split("[ !,?._'@]+");


        System.out.println(arrb.length);
        for (String e : arrb) {
            System.out.println(e);
        }
    }
}
