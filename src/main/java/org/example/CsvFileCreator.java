package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */


public class CsvFileCreator implements FileCreator {

    /**
     *
     * @param filename
     * @throws IOException
     * This method creates a csv file and loops through a map collection to add title and author
     * to the csv created
     */
    public  void createCsvFile(String filename, String [] HEADERS, Map<Integer, String> PLAYER_LIST) throws IOException  {



        try{
            if(checkcsvFormat(filename)) {
                FileWriter out = new FileWriter(filename);
                System.out.println("File with the name" +  " " +  Arrays.asList(filename.split("\\.")).get(0) + " "
                        + "Was Created SuccessFully!.");
                try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT
                        .withHeader(HEADERS).withRecordSeparator("     \n"))) {

                    // Loop through AUTHOR_BOOK_MAP
                    PLAYER_LIST.forEach((playerno, playername) -> {
                        try {
                            // Prints all the objects in the given array handling nested collections/arrays as records.
                            printer.printRecord(playerno, playername);
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

    private boolean checkcsvFormat(String filename){
        Pattern  pattern = Pattern.compile("[A-Za-z]+\\.csv");
        Matcher matcher = pattern.matcher(filename);

        return matcher.matches();

    }

    /**
     *
     * @param filename
     * @throws IOException
     */


    public void reader(String filename) throws IOException {
      if(checkcsvFormat(filename)){
          try{
              FileReader in = new FileReader(filename);
              CSVParser records = new CSVParser(in, CSVFormat.DEFAULT);
              records.forEach((i) -> {
                  System.out.println(i.get(0)  + "\t\t" + i.get(1));
              });
          }catch (FileNotFoundException e){
              System.out.println("Error Message: " + "Fill is not Found, Please Check the File Format - >  \n" + e);
//            throw new FileNotFoundException("Error Message: " + "Fill is not Found, Please Check the File Format ");
          }
      }else{
          System.out.println("");
      }


    }

}
