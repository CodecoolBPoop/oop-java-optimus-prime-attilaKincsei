package com.codecool;

import java.util.*;

class SieveOfEratosthenes {

    SieveOfEratosthenes() {
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

        int jumps = 1;
        while (jumps < primeIteratorLimit) {

            for (int i = jumps + 1; i < integerArray.length; i++) {
                if (integerArray[i] != -1) {
                    jumps = integerArray[i];
                    break;
                }
            }

            int lengthLimit = integerArray.length / jumps;
            int maximumIndex;
            if (lengthLimit % 2 == 0) {
                maximumIndex = lengthLimit;
            } else {
                maximumIndex = lengthLimit + 1;
            }


            for (int j = 2; j < maximumIndex; j++) {
                int primeMultiples = jumps * j;
                int currentPrimeIndex = Math.min(primeMultiples, integerArray.length - 1);
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


    Integer[] limitedMemorySieve(int largestNumber) {

        Integer[] integerArray = createIntegerArray(largestNumber);

        List<Integer> integerList = new ArrayList<>(Arrays.asList(integerArray));
        integerList.remove(0);
        integerList.remove(0);
        integerList.remove(integerList.size() - 1);

        int primeIteratorLimit = (int) Math.sqrt(integerArray.length);


        for (int j = 2; j < primeIteratorLimit; j++) {
            for (Iterator<Integer> iterator = integerList.listIterator(); iterator.hasNext();) {
                Integer currentElement = iterator.next();
                if (currentElement % j == 0 && currentElement != j) {
                    iterator.remove();
                }
            }
        }

        return integerList.toArray(new Integer[0]);
    }

}
