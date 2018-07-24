package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class SieveOfEratosthenesTest {

    private String inputFileName;
    private int largestElement;
    private Integer[] expectedPrimes;
    private SieveOfEratosthenes sieve;

    private void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    private void setLargestElement(int largestElement) {
        this.largestElement = largestElement;
    }

    @BeforeEach
    void createExpectedPrimesList() {
        setInputFileName("resources/1229_primes_per_line.txt");
        setLargestElement(1000);
        sieve = new SieveOfEratosthenes(largestElement);
        FileHandling testFH = new FileHandling();
        expectedPrimes = testFH.readIntPrimesFromFile(inputFileName, largestElement);
    }


    @Test
    void TestLimitedCpuSieve() {
        assertArrayEquals(expectedPrimes, sieve.limitedCpuSieve());
    }

    @Test
    void TestLimitedMemorySieve() {
        assertArrayEquals(expectedPrimes, sieve.limitedMemorySieve());
    }

    @ParameterizedTest
    @ValueSource(ints = {40, 30, 20, 10})
    void testLimitedCpuSieveTimeOut(int milliseconds) {
        assertTimeout(Duration.ofMillis(milliseconds), sieve::limitedCpuSieve, "Duration exeeds 20 milliseconds");
    }

    @Test
    void assumeOperatingSystem() {
        assumeFalse(
                System.getProperty("os.name").contains("Windows"),
                () -> "Aborting test. Not on Windows OS"
        );
        System.out.println(System.getProperty("os.name"));
    }

    @DisplayName("Runs under 10 millis")
    @RepeatedTest(value = 10, name = "{displayName}: {currentRepetition}/{totalRepetitions}")
    void assumeLargestElement() {
        assumingThat(
                largestElement < 1000,
                () -> {
                    assertArrayEquals(expectedPrimes, sieve.limitedCpuSieve());
                }
        );
        assertTimeout(Duration.ofMillis(9), sieve::limitedCpuSieve, "Duration exeeds 20 milliseconds");
    }


}