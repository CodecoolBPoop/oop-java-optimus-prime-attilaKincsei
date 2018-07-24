package com.codecool;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class TestOptimusPrime {

    static OptimusPrime optimusPrime;
    static FileHandling fileHandling;
    static int largestElement;

    @BeforeAll
    static void createTestClassInstance() {
        largestElement = 10000;
        optimusPrime = new OptimusPrime(largestElement);
        fileHandling = new FileHandling();
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 1000, 10000})
    void numberOfPrimes_AssertEqual_True(int largestElement) {
        OptimusPrime optimusPrime = new OptimusPrime(largestElement);
        int expected = fileHandling.getNumberOfPrimes("resources/primes_1million_per_line.txt", largestElement);
        int actual = optimusPrime.numberOfPrimes();
        assertEquals(expected, actual);
    }

//    @ParameterizedTest
//    @ValueSource(ints = {40, 30, 20, 10})
//    void testLimitedCpuSieveTimeOut(int milliseconds) {
//        assertTimeout(Duration.ofMillis(milliseconds), sieve::limitedCpuSieve, "Duration exeeds 20 milliseconds");
//    }

}