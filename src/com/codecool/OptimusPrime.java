package com.codecool;

class OptimusPrime {

    private boolean[] booleanArray;

    OptimusPrime() {
    }

    boolean[] createLimitedCpuArray(int arrayLength) {

        boolean[] booleanArray = new boolean[arrayLength];
        for (int i = 2; i < arrayLength; i++) {
            booleanArray[i] = true;
        }
        return booleanArray;
    }


    boolean[] createLimitedMemoryArray(int maxArrayLength, int startIndex) {

        int subArrayLength = (int) Math.sqrt(maxArrayLength);

        boolean[] booleanArray = new boolean[subArrayLength];
        for (int i = startIndex; i < subArrayLength; i++) {
            booleanArray[i] = true;
        }
        return booleanArray;
    }

    int numberOfPrimesLimitedMemory(int maxArrayLength) {
        // TODO: the whole logic has to be based on calculating the actual primes not only registering if something prime or not
        boolean[] booleanSubArray1 = createLimitedMemoryArray(maxArrayLength, 0);

        int delta = booleanSubArray1.length;

        int numberOfPrimesDelta1 = numberOfPrimesLimitedCPU(delta);

        int primeIteratorLimit = (int) Math.sqrt(booleanSubArray1.length);

        int jumps = 1;
        while (jumps < primeIteratorLimit) {

            for (int i = jumps + 1; i < booleanSubArray1.length; i++) {
                if (booleanSubArray1[i]) {
                    jumps = i;
                    break;
                }
            }

            int lengthLimit = booleanSubArray1.length / jumps;
            int maximumIndex;
            if (lengthLimit % 2 == 0) {
                maximumIndex = lengthLimit;
            } else {
                maximumIndex = lengthLimit + 1;
            }


            for (int j = 2; j < maximumIndex; j++) {
                int primeMultiples = jumps * j;
                int currentPrimeIndex = Math.min(primeMultiples, booleanSubArray1.length - 1);
                booleanSubArray1[currentPrimeIndex] = false;
            }

        }


        int numberOfPrimes = 0;
        for (boolean booleanItem : booleanSubArray1) {
            if (booleanItem) {
                numberOfPrimes++;
            }
        }

        numberOfPrimes = delta;
        // delta * ???

        return numberOfPrimes;
    }



    int numberOfPrimesLimitedCPU(int arrayLength) {

        boolean[] booleanArray = createLimitedCpuArray(arrayLength);

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
