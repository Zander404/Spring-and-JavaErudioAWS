package com.zander404.springandjavaerudio.utils;

public class Calculator {

    public static Double sum(Double a, Double b){
        return a+b;
    }

    public static Double sub(Double a, Double b){
        return a-b;
    }

    public static Double mul(Double a, Double b){
        return a*b;
    }

    public static Double div(Double a, Double b){
        return a/b;
    }

    public static Double mean(Double a, Double b){
        return (a+b)/2;
    }

    public static Double sqrt(Double a){
        return Math.sqrt(a);
    }

    public static Double pow(Double a, Double b){
        return Math.pow(a, b);
    }
}

