package com.codecool;

import com.codecool.util.FileHandling;

import java.util.Arrays;
import java.util.List;

public class ManualTestsForActualPrimes {

    private static int largestElement;
    private static List<String> expectedPrimes;
    private static boolean doesTestPass;
    private static Integer[] actualCpuPrimes;
    private static String actualPrimeStrings;
    private static String expectedPrimeStrings;


    private static void createExpectedPrimesList(String fileName) {

        FileHandling testFH = new FileHandling();
        expectedPrimes = testFH.readPrimesFromFile(fileName, largestElement);

    }

    private static void runFunctionalityTest() {
        ActualPrimes sieveOfEratosthenes = new ActualPrimes();
        actualCpuPrimes = sieveOfEratosthenes.limitedCpuSieve(largestElement);
        actualPrimeStrings = Arrays.toString(actualCpuPrimes);

        expectedPrimeStrings = expectedPrimes.toString();
        doesTestPass = expectedPrimeStrings.equals(actualPrimeStrings);
    }

    private static void printFunctionalityResult() {
        System.out.println("---- Limited CPU functionality test ----");
        if (doesTestPass) {
            System.out.println("--- TEST PASSED ---");
        } else {
            System.out.println("--- TEST FAILED! ---");
        }

        if (largestElement < 101) {
            System.out.printf("Expected: %s", expectedPrimeStrings);
            System.out.println();
            System.out.printf("Actual:   %s", actualPrimeStrings);
            System.out.println();
        } else {
            System.out.printf("Expected number of primes: %s", expectedPrimes.size());
            System.out.println();
            System.out.printf("Actual number of primes:   %s", actualCpuPrimes.length);
            System.out.println();

        }
        System.out.println();
    }

    private static long runPerformanceTest() {
        ActualPrimes actualPrimesInstance = new ActualPrimes();
        long start = System.currentTimeMillis();
        actualPrimesInstance.limitedCpuSieve(largestElement);
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



    public static void main(String[] args) {
        String inputFileName = "resources/primes_1million_per_line.txt";
        int timesToRun = 10;
        largestElement = 1_000_000;
        createExpectedPrimesList(inputFileName);

        runFunctionalityTest();
        printFunctionalityResult();
        printPerformanceAverage(timesToRun);
    }

}
