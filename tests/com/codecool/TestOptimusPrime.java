package com.codecool;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TestOptimusPrime {
    private static FileHandling fileHandling;

    @BeforeAll
    static void createTestClassInstance() {
        fileHandling = new FileHandling();
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 1000, 10_000, 100_000, 1_000_000})
    void numberOfPrimes_AssertEqual_True(int largestElement) {
        OptimusPrime optimusPrime = new OptimusPrime(largestElement);
        int expected = fileHandling.getNumberOfPrimes("resources/primes_1million_per_line.txt", largestElement);
        int actual = optimusPrime.numberOfPrimesLimitedCPU();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1_000_000, 10_000_000, 100_000_000})
    void numberOfPrimes_PerformanceTest(int largestElement) {
        OptimusPrime optimusPrime = new OptimusPrime(largestElement);
        assertTimeout(Duration.ofMillis(2000), optimusPrime::numberOfPrimesLimitedCPU, "Duration exeeds 2 seconds");
    }

}