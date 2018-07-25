package com.codecool;

import java.util.Arrays;
import java.util.List;

public class MyTestPrimes {

    private static int largestElement;
    private static List<String> expectedPrimes;
    private static boolean doesTestPass;
    private static String actualPrimeStrings;
    private static String expectedPrimeStrings;

    private static boolean doesMemoryTestPass;
    private static String actualmemoryPrimes;

    private static void createExpectedPrimesList(String fileName) {

        FileHandling testFH = new FileHandling();
        expectedPrimes = testFH.readPrimesFromFile(fileName, largestElement);

    }

    private static void runFunctionalityTest() {
        // Creating primes array with tested algorithm
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        Integer[] actualPrimes = sieveOfEratosthenes.limitedCpuSieve(largestElement);
        actualPrimeStrings = Arrays.toString(actualPrimes);

        // Creating expected primes array
        expectedPrimeStrings = expectedPrimes.toString();
        doesTestPass = expectedPrimeStrings.equals(actualPrimeStrings);
    }

    private static void printFunctionalityResult() {
        System.out.println("---- Limited CPU functionality test ----");
        if (doesTestPass) {
            System.out.println("Congrats! Test passed");
        } else {
            System.out.println("Test FAILED!");
        }
//        System.out.printf("Expected: %s", expectedPrimeStrings);
//        System.out.println();
//        System.out.printf("Actual:   %s", actualPrimeStrings);
//        System.out.println();

    }

    private static long runPerformanceTest() {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        long start = System.currentTimeMillis();
        sieveOfEratosthenes.limitedCpuSieve(largestElement);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long averagePerformance(int timesToRun) {
        long runTimeSum = 0;
        for (int i = 0; i < timesToRun; i++) {
            long runtime = runPerformanceTest();
            runTimeSum += runtime;
        }

        return runTimeSum / timesToRun;
    }

    private static void printPerformanceAverage(int timesToRun) {
        long performanceAverage = averagePerformance(timesToRun);
        System.out.println("---------- Performance tests ----------");
        System.out.printf("Test took %d ms on average", performanceAverage);
        System.out.println();
        System.out.printf("Number of runs: %d", timesToRun);
        System.out.println();
        System.out.printf("Test array length of integers: %d", largestElement);
        System.out.println();
    }


    private static void limitedMemoryFunctionalityTest() {
        // Creating primes array with tested algorithm
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        Integer[] primesArray = sieveOfEratosthenes.limitedMemorySieve(largestElement);
        actualmemoryPrimes = Arrays.toString(primesArray);

        expectedPrimeStrings = expectedPrimes.toString();
        doesMemoryTestPass = expectedPrimeStrings.equals(actualmemoryPrimes);
    }

    private static void printMemoryFunctionalityResult() {
        System.out.println("---- Limited memory functionality test ----");
        if (doesMemoryTestPass) {
            System.out.println("Congrats! Test passed");
        } else {
            System.out.println("Test FAILED!");
        }
//        System.out.printf("Expected: %s", expectedPrimeStrings);
//        System.out.println();
//        System.out.printf("Actual:   %s", actualmemoryPrimes);
//        System.out.println();

    }

    private static long memoryPerformanceTest() {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        long start = System.currentTimeMillis();
        sieveOfEratosthenes.limitedMemorySieve(largestElement);
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static long averageMemoryPerformance(int timesToRun) {
        long runTimeSum = 0;
        for (int i = 0; i < timesToRun; i++) {
            long runtime = memoryPerformanceTest();
            runTimeSum += runtime;
        }

        return runTimeSum / timesToRun;
    }

    private static void printMemoryPerformanceAverage(int timesToRun) {
        long performanceAverage = averageMemoryPerformance(timesToRun);
        System.out.println("---------- Limited Memory performance tests ----------");
        System.out.printf("Test took %d ms on average", performanceAverage);
        System.out.println();
        System.out.printf("Number of runs: %d", timesToRun);
        System.out.println();
        System.out.printf("Test array length of integers: %d", largestElement);
        System.out.println();
    }


    public static void main(String[] args) {
        String inputFileName = "resources/primes_1million_per_line.txt";
        int timesToRun = 1;
        largestElement = 9973;
        createExpectedPrimesList(inputFileName);

        runFunctionalityTest();
        printFunctionalityResult();
        printPerformanceAverage(timesToRun);
        System.out.println();
        System.out.println();
        limitedMemoryFunctionalityTest();
        printMemoryFunctionalityResult();
        printMemoryPerformanceAverage(timesToRun);

    }

}
