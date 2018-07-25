package com.codecool;

class OnlyNumberOfPrimes {

    private boolean[] booleanArray;

    int eSieveForLimitedCPU(int arrayLength) {

        createBooleanArray(arrayLength);

        int primeIteratorLimit = (int) Math.sqrt(arrayLength);
        int nextLeastPrime = 1;
        while (nextLeastPrime < primeIteratorLimit) {

            for (int i = nextLeastPrime + 1; i < arrayLength; i++) {
                if (booleanArray[i]) {
                    nextLeastPrime = i;
                    break;
                }
            }

            int maximumIndex = arrayLength / nextLeastPrime + 1;

            for (int j = 2; j < maximumIndex; j++) {
                int primeMultiples = nextLeastPrime * j;
                int currentPrimeIndex = Math.min(primeMultiples, arrayLength - 1);
                booleanArray[currentPrimeIndex] = false;
            }

        }

        return calculateNumberOfPrimes(booleanArray);
    }

    private void createBooleanArray(int arrayLength) {

        booleanArray = new boolean[arrayLength];
        for (int i = 2; i < arrayLength; i++) {
            booleanArray[i] = true;
        }
    }

    private int calculateNumberOfPrimes(boolean[] booleanArray) {
        int numberOfPrimes = 0;
        for (boolean booleanItem : booleanArray) {
            if (booleanItem) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }


}
