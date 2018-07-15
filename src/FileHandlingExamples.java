import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GERI's file reading*/
public class FileHandlingExamples {

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

    List<String> transformOneLineString(String fileName) {

        List<String> tempPrimesList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                tempPrimesList.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> primesList1229 = new ArrayList<>();

        String[] stringArray = tempPrimesList.get(0).split(", ");
        for (String primes : stringArray) {
            primesList1229.add(primes);
        }


        return primesList1229;


    }

    void transformToOnePrimePerLine(String inputFileName, String outputFileName) {

        List<String> primesListString = transformOneLineString(inputFileName);

        int bufferSize = 8 * 1024;
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

}
