package com.codecool;

import java.util.*;

class SieveOfEratosthenes {

    private Integer[] integerArray;
    private int nonPrimes = 0;
    private int cpuIterator = 0;

    private ArrayList<Integer> integerList = new ArrayList<Integer>();

    public SieveOfEratosthenes() {
    }

    SieveOfEratosthenes(int length) {
        integerArray = new Integer[length];
        for (int i = 0; i < length; i++) {
            integerArray[i] = i + 1;
        }

        integerList.addAll(Arrays.asList(integerArray));
        integerList.remove(0);
    }

    Integer[] limitedCpuSieve() {
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

        Integer[] cpuPrimes = new Integer[integerArray.length - nonPrimes];

        for (int integer : integerArray) {
            if (integer != -1) {
                cpuPrimes[cpuIterator] = integer;
                cpuIterator++;
            }
        }
        return cpuPrimes;
    }

    Integer[] limitedCpuSieveV2(int length) {
        Integer[] integerArray = new Integer[length + 2];
        for (int i = 0; i <= length; i++) {
            integerArray[i] = i;
        }


        int largestPossibleDivisor = (int) Math.ceil((double) integerArray.length / 2);

        integerArray[0] = -1;
        integerArray[1] = -1;

        for (int jumps = 2; jumps < largestPossibleDivisor; jumps++) {

            int lengthLimit = integerArray.length / jumps;
            int maximumIndex;
            if (lengthLimit % 2 == 0) {
                maximumIndex = lengthLimit;
            } else {
                maximumIndex = lengthLimit + 1;
            }


            for (int i = 2; i < maximumIndex; i++) {
                int currentPrime = jumps * i;
                int currentPrimeIndex = Math.min(currentPrime, integerArray.length - 1);
                integerArray[currentPrimeIndex] = -1;
            }

        }


        List<Integer> integerList = new ArrayList<>();
        for (Integer integer : integerArray) {
            if (integer != -1) {
                integerList.add(integer);
            }
        }

        return integerList.toArray(new Integer[0]);
    }


    Integer[] limitedMemorySieve() {
        int largestPossibleDivisor = (int) Math.ceil((double) integerList.size() / 2);


        for (int j = 2; j < largestPossibleDivisor; j++) {
            for (Iterator<Integer> iterator = integerList.listIterator(); iterator.hasNext();) {
                Integer currentElement = iterator.next();
                if (currentElement % j == 0 && currentElement != j) {
                    iterator.remove();
                }
            }
        }

        return integerList.toArray(new Integer[integerList.size()]);
    }

}
