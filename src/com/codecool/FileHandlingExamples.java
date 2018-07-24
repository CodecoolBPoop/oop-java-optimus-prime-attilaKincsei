package com.codecool;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GERI's file reading*/
public class FileHandlingExamples {

    /**
     * Reading a file line by line*/
    List<String> readFromFileLineByLine(String fileName, Integer largestElement) {

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

    List<String> transformOneLineString(String fileName, String regex) {

        List<String> tempPrimesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                tempPrimesList.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> primesList = new ArrayList<>();

        for (String line : tempPrimesList) {
            String[] stringArray = line.trim().split(regex);
            for (String prime : stringArray) {
                primesList.add(prime.trim());
                System.out.println(prime.toCharArray());
            }
        }

        return primesList;
    }

    void transformToOnePrimePerLine(String inputFileName, String outputFileName, String regex) {

        List<String> primesListString = transformOneLineString(inputFileName, regex);

        int bufferSize = 16 * 1024;
        try {
            FileWriter output = new FileWriter(outputFileName);

            try(BufferedWriter bufferedWriter =
                        new BufferedWriter(output, bufferSize)) {

                for (String prime : primesListString) {
                    bufferedWriter.write(prime);
                    bufferedWriter.newLine();
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void removeBlankLinesFromFile(String inputFileName, String outputFileName) {
        Scanner file;
        PrintWriter writer;

        try {

            file = new Scanner(new File(inputFileName));
            writer = new PrintWriter(outputFileName);

            while (file.hasNext()) {
                String line = file.nextLine();
                if (!line.isEmpty()) {
                    writer.write(line);
                    writer.write("\n");
                }
            }

            file.close();
            writer.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * TheHistory file reading*/
    private static String readFromFile(String filename) {
        BufferedReader in = null;
        String s;
        StringBuilder sb = new StringBuilder();
        try {
            in = new BufferedReader(new FileReader(filename));
            while ((s = in.readLine()) != null)
                sb.append(s).append("\n");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return sb.toString();
    }


    /**
     * This class shows how to write file in java
     * @param args
     * @throws IOException
     */
    /**
     * Use Streams when you are dealing with raw data
     * @param data
     */
    private static void writeUsingOutputStream(String data) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("/Users/pankaj/os.txt"));
            os.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Use Files class from Java 1.7 to write files, internally uses OutputStream
     * @param data
     */
    private static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("/Users/pankaj/files.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Use BufferedWriter when number of write operations are more
     * It uses internal buffer to reduce real IO operations and saves time
     * @param data
     * @param noOfLines
     */
    private static void writeUsingBufferedWriter(String data, int noOfLines) {
        File file = new File("/Users/pankaj/BufferedWriter.txt");
        FileWriter fr = null;
        BufferedWriter br = null;
        String dataWithNewLine=data+System.getProperty("line.separator");
        try{
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            for(int i = noOfLines; i>0; i--){
                br.write(dataWithNewLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Use FileWriter when number of write operations are less
     * @param data
     */
    private static void writeUsingFileWriter(String data) {
        File file = new File("/Users/pankaj/FileWriter.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                Objects.requireNonNull(fr).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        String data = "I will write this String to File in Java";
//        int noOfLines = 10000;
//        writeUsingFileWriter(data);
//
//        writeUsingBufferedWriter(data, noOfLines);
//
//        writeUsingFiles(data);
//
//        writeUsingOutputStream(data);
//        System.out.println("DONE");

        FileHandlingExamples fhInstance = new FileHandlingExamples();
//        fhInstance.transformToOnePrimePerLine(
//                "primes_first_1million.txt",
//                "bad.txt",
//                "\\s+"
//        );

//        fhInstance.removeBlankLinesFromFile("resources/bad.txt", "resources/primes_1million_per_line.txt");

    }


}
