package com.codecool.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandling {

    public List<String> readPrimesFromFile(String fileName, Integer largestElement) {

        List<String> primesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (Integer.parseInt(line) > largestElement) {
                    return primesList;
                }
                primesList.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return primesList;

    }

    public Integer[] readIntPrimesFromFile(String fileName, Integer largestElement) {

        List<Integer> primesList = new ArrayList<>();
        Integer[] primesArray = null;


        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (Integer.parseInt(line) > largestElement) {
                    return primesList.toArray(new Integer[primesList.size()]);
                }
                primesList.add(Integer.parseInt(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return primesArray;

    }

    public int getNumberOfPrimes(String fileName, Integer largestElement) {

        int numberOfPrimes = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (Integer.parseInt(line) > largestElement) {
                    return numberOfPrimes;
                }
                numberOfPrimes++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return numberOfPrimes;

    }


}
