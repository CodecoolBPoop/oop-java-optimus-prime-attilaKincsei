package com.codecool;

import com.codecool.util.FileHandling;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TestOnlyNumberOfPrimes {
    private static FileHandling fileHandling;
    private static OnlyNumberOfPrimes numberOfPrimesInstance;
    private static String fileName;

    @BeforeAll
    static void createTestClassInstance() {
        fileHandling = new FileHandling();
        numberOfPrimesInstance = new OnlyNumberOfPrimes();
        fileName = "resources/primes_1million_per_line.txt";
    }

    @ParameterizedTest()
    @ValueSource(ints = {0, 1, 100, 1000, 10_000, 100_000, 1_000_000})
    void numberOfPrimes_AssertEqual_True(int largestElement) {

        int expected = fileHandling.getNumberOfPrimes(fileName, largestElement);
        int actual = numberOfPrimesInstance.eSieveForLimitedCPU(largestElement);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {10_000_000, 100_000_000})
    void numberOfPrimes_PerformanceTest(int largestElement) {
        assertTimeout(
                Duration.ofMillis(2000),
                () -> numberOfPrimesInstance.eSieveForLimitedCPU(largestElement),
                "Duration exeeds 2 seconds"
        );
    }

}