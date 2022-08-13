package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */


public class CsvFileCreator {


    Map<String, String> AUTHOR_BOOK_MAP = new HashMap<>() {
        {
            put("Dan Simmons", "Hyperion");
            put("Douglas Adams", "The Hitchhiker's Guide to the Galaxy");
        }
    };
    String[] HEADERS = { "author", "title"};


    /**
     *
     * @param filename
     * @throws IOException
     * This method creates a csv file and loops through a map collection to add title and author
     * to the csv created
     */
    public  void createCsvFile(String filename)  throws IOException{

        Pattern  pattern = Pattern.compile("[A-Za-z]+\\.csv");
        Matcher matcher = pattern.matcher(filename);
       // // Writes a file

        try{
            if(matcher.matches()) {
                FileWriter out = new FileWriter(filename);
                System.out.println("File with the name" +  " " +  Arrays.asList(filename.split("\\.")).get(0) + "\n "
                        + "Was Created SuccessFully!.");
                try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                        .withHeader(HEADERS).withRecordSeparator("     \n"))) {

                    // Loop through AUTHOR_BOOK_MAP
                    AUTHOR_BOOK_MAP.forEach((author, tile) -> {
                        try {
                            // Prints all the objects in the given array handling nested collections/arrays as records.
                            printer.printRecord(author, tile);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                }catch (IOException e){
                    throw new IOException("");
                }

                out.close();
            }else {
                System.out.println("File name can't be created, Please correct the syntax or the format");
                System.out.println("File name was created this way " + filename + "\n");
                System.out.println("Right way to create your  a file name would be: " + "\n" +
                        "\t\t " + Arrays.asList(filename.split("\\.")).get(0) + ".csv");
            }
        }catch (IllegalArgumentException e){
            System.out.println("file name ");
        }

//        FileWriter out = new FileWriter(filename); // // Writes a file
        //// Creates a printer that will print values to the given stream following the CSVFormat



    }


    /**
     *
     * @param filename
     * @throws IOException
     */


    public void reader(String filename) throws IOException {
        FileReader in = new FileReader(filename);
        CSVParser records = new CSVParser(in, CSVFormat.DEFAULT);
        records.forEach((i) -> {
            System.out.println(i.get(0)  + "\t\t" + i.get(1));
        });


    }

}
