package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {

        if ( i < 0) {
            throw new IllegalArgumentException("Argument must be at least zero!");
        }

        int result = 1;

        while (i != 0) {
            result = result * i;
            i--;
        }

        return result;
    }
}
