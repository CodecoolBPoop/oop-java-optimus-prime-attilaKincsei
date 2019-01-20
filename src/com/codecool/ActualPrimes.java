package com.codecool;

import java.util.*;

class ActualPrimes {

    ActualPrimes() {
    }

    private Integer[] createIntegerArray(int length) {
        Integer[] integerArray = new Integer[length + 2];
        for (int i = 0; i < length + 2; i++) {
            integerArray[i] = i;
        }
        return integerArray;
    }


    Integer[] limitedCpuSieve(int largestNumber) {

        Integer[] integerArray = createIntegerArray(largestNumber);
        integerArray[0] = -1;
        integerArray[1] = -1;

        int primeIteratorLimit = (int) Math.sqrt(integerArray.length);

        int nextLeastPrime = 1;
        while (nextLeastPrime < primeIteratorLimit) {

            nextLeastPrime = getNextLeastPrime(integerArray, nextLeastPrime);

            int maximumIndex = integerArray.length / nextLeastPrime + 1;


            for (int j = 2; j < maximumIndex; j++) {
                int primeMultiples = nextLeastPrime * j;
                int currentPrimeIndex = Math.min(primeMultiples, integerArray.length - 1);
                integerArray[currentPrimeIndex] = -1;
            }

        }

        return getIntegerList(integerArray).toArray(new Integer[0]);
    }

    private List<Integer> getIntegerList(Integer[] integerArray) {
        List<Integer> integerList = new ArrayList<>();
        for (Integer integer : integerArray) {
            if (integer != -1) {
                integerList.add(integer);
            }
        }
        return integerList;
    }

    private int getNextLeastPrime(Integer[] integerArray, int nextLeastPrime) {
        for (int i = nextLeastPrime + 1; i < integerArray.length; i++) {
            if (integerArray[i] != -1) {
                nextLeastPrime = integerArray[i];
                return nextLeastPrime;
            }
        }
        return nextLeastPrime;
    }
}
