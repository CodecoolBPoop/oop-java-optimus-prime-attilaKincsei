package com.codecool;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class FileHandling {

    List<String> readPrimesFromFile(String fileName, Integer largestElement) {

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


}
