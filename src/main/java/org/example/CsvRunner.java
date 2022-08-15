package org.example;



import java.io.IOException;
import java.util.*;

public class CsvRunner {

    public static void main(String[] args) throws IOException {

        Map<Integer, String> PLAYER_LIST = new HashMap<>() {
            {
                put(7, "Cristino Ronaldo");
                put(10 , "Kylian Mbapper");
            }
        };
        String[] HEADERS = { "Player No", "Player Name"};


        String Filename = "Folder.csv";

        CsvFileCreator csvcreator = new CsvFileCreator();
        csvcreator.createCsvFile(Filename, HEADERS, PLAYER_LIST);
        csvcreator.reader(Filename);













    }





}

