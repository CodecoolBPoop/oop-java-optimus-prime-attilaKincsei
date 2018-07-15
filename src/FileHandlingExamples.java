import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String data = "I will write this String to File in Java";
        int noOfLines = 10000;
        writeUsingFileWriter(data);

        writeUsingBufferedWriter(data, noOfLines);

        writeUsingFiles(data);

        writeUsingOutputStream(data);
        System.out.println("DONE");
    }


}
