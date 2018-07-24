package com.codecool;

public class OptimusPrime {

    boolean[] booleanArray;
    int arrayLength;

    public OptimusPrime(int arrayLength) {
        this.arrayLength = arrayLength;
        booleanArray = new boolean[this.arrayLength];
        for (int i = 0; i < this.arrayLength; i++) {
            booleanArray[i] = true;
        }
    }

    int numberOfPrimes() {
        int largestPossibleDivisor = (int) Math.ceil((double) arrayLength / 2);

        int nonPrimes = 0;
        booleanArray[0] = false;
        nonPrimes++;

        for (int j = 2; j < largestPossibleDivisor; j++) {
            for (int i = 0; i < arrayLength; i++) {
                if (booleanArray[i] && i % j == 0 && i != j) {
                    booleanArray[i] = false;
                    nonPrimes++;
                }
            }
        }

        return arrayLength - nonPrimes - 1;
    }


}
