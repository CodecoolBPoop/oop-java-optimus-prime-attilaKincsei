package com.codecool;

class sieveOfEratosthenes {

    private int[] integerArray;
    private int nonPrimes = 0;
    private int cpuIterator = 0;

    sieveOfEratosthenes(int length) {
        integerArray = new int[length];
        for (int i = 0; i < length; i++) {
            integerArray[i] = i + 1;
        }
    }

    int[] cpuSieve() {
        int largestPossibleDivisor = (int) Math.ceil((double) integerArray.length / 2);

        integerArray[0] = -1;
        nonPrimes++;

        for (int j = 2; j < largestPossibleDivisor; j++) {
            for (int i = 0; i < integerArray.length; i++) {
                if (integerArray[i] != -1 && integerArray[i] % j == 0 && integerArray[i] != j) {
                    integerArray[i] = -1;
                    nonPrimes++;
                }
            }
        }

        int[] cpuPrimes = new int[integerArray.length - nonPrimes];

        for (int integer : integerArray) {
            if (integer != -1) {
                cpuPrimes[cpuIterator] = integer;
                cpuIterator++;
            }
        }
        return cpuPrimes;
    }

}
