package com.codecool;

import java.util.Arrays;

public class ErastothenesSieve {

    int[] integerArray;
    int[] cpuPrimes;
    int nonPrimes = 0;
    int cpuIterator = 0;

    public ErastothenesSieve(int length) {
        integerArray = new int[length];
        for (int i = 0; i < length; i++) {
            integerArray[i] = i + 1;
        }
    }

    int[] cpuSieve() {
        cpuPrimes = new int[nonPrimes];
        int largestDivisor = (int) Math.ceil((double) integerArray.length / 2);

        for (int j = 2; j < integerArray.length; j++) {
            for (int i = 0; i < integerArray.length; i++) {
                if (integerArray[i] % j == 0 && integerArray[i] != j) {
                    integerArray[i] = -1;
                    nonPrimes++;
                }
            }
        }

        integerArray[0] = -1;
        nonPrimes++;

        cpuPrimes = new int[integerArray.length - nonPrimes];

        for (int i = 0; i < integerArray.length; i++) {
            if (integerArray[i] != -1) {
                cpuPrimes[cpuIterator] = integerArray[i];
                cpuIterator++;
                }
        }
        return cpuPrimes;
    }

}
