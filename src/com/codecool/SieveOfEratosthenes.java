package com.codecool;

import java.util.*;

class SieveOfEratosthenes {

    private Integer[] integerArray;
    private int nonPrimes = 0;
    private int cpuIterator = 0;

    private ArrayList<Integer> integerList = new ArrayList<Integer>();

    SieveOfEratosthenes(int length) {
        integerArray = new Integer[length];
        for (int i = 0; i < length; i++) {
            integerArray[i] = i + 1;
        }

        integerList.addAll(Arrays.asList(integerArray));
        integerList.remove(0);
    }

    int[] limitedCpuSieve() {
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

    ArrayList<Integer> limitedMemorySieve() {
        int largestPossibleDivisor = (int) Math.ceil((double) integerList.size() / 2);


        for (int j = 2; j < largestPossibleDivisor; j++) {
            for (Iterator<Integer> iterator = integerList.listIterator(); iterator.hasNext();) {
                Integer currentElement = iterator.next();
                if (currentElement % j == 0 && currentElement != j) {
                    iterator.remove();
                }
            }
        }

        return integerList;
    }

}
