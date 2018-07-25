package com.codecool;

class OnlyNumberOfPrimes {

    private boolean[] booleanArray;

    OnlyNumberOfPrimes() {
    }

    int eSieveForLimitedCPU(int arrayLength) {

        boolean[] booleanArray = createLimitedCpuArray(arrayLength);

        int primeIteratorLimit = (int) Math.sqrt(arrayLength);
        int nextLeastPrime = 1;
        while (nextLeastPrime < primeIteratorLimit) {

            for (int i = nextLeastPrime + 1; i < arrayLength; i++) {
                if (booleanArray[i]) {
                    nextLeastPrime = i;
                    break;
                }
            }

            int lengthLimit = booleanArray.length / nextLeastPrime;
            int maximumIndex;
            if (lengthLimit % 2 == 0) {
                maximumIndex = lengthLimit;
            } else {
                maximumIndex = lengthLimit + 1;
            }


            for (int j = 2; j < maximumIndex; j++) {
                int primeMultiples = nextLeastPrime * j;
                int currentPrimeIndex = Math.min(primeMultiples, booleanArray.length - 1);
                booleanArray[currentPrimeIndex] = false;
            }

        }

        return getNumberOfPrimes(booleanArray);
    }

    boolean[] createLimitedCpuArray(int arrayLength) {

        boolean[] booleanArray = new boolean[arrayLength];
        for (int i = 2; i < arrayLength; i++) {
            booleanArray[i] = true;
        }
        return booleanArray;
    }

    public int getNumberOfPrimes(boolean[] booleanArray) {
        int numberOfPrimes = 0;
        for (boolean booleanItem : booleanArray) {
            if (booleanItem) {
                numberOfPrimes++;
            }
        }
        return numberOfPrimes;
    }


}
