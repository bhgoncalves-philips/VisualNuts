package com.br.app.exercise1;

public class Multiples {

    private static boolean isMultipleOf( int numerator, int dividend){
        return numerator % dividend == 0;
    }

    public static boolean isMultipleOf5(int numerator)
    {
        return isMultipleOf(numerator, 5);
    }

    public static boolean isMultipleOf3 (int numerator)
    {
        return isMultipleOf(numerator, 3);
    }

}
