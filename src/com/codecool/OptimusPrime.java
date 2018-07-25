package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

    int numberOfPrimesLimitedCPU() {

        booleanArray[0] = false;
        booleanArray[1] = false;

        int primeIteratorLimit = (int) Math.sqrt(booleanArray.length);

        int jumps = 1;
        while (jumps < primeIteratorLimit) {

            for (int i = jumps + 1; i < booleanArray.length; i++) {
                if (booleanArray[i]) {
                    jumps = i;
                    break;
                }
            }

            int lengthLimit = booleanArray.length / jumps;
            int maximumIndex;
            if (lengthLimit % 2 == 0) {
                maximumIndex = lengthLimit;
            } else {
                maximumIndex = lengthLimit + 1;
            }


            for (int j = 2; j < maximumIndex; j++) {
                int primeMultiples = jumps * j;
                int currentPrimeIndex = Math.min(primeMultiples, booleanArray.length - 1);
                booleanArray[currentPrimeIndex] = false;
            }

        }


        int numberOfPrimes = 0;
        for (boolean booleanItem : booleanArray) {
            if (booleanItem) {
                numberOfPrimes++;
            }
        }

        return numberOfPrimes;
    }


}
