package org.example;

import com.google.common.base.Splitter;

import java.io.IOException;
import java.util.*;

public class CsvRunner {

    public static void main(String[] args) throws IOException {

        Map<String, String> AUTHOR_BOOK_MAP = new HashMap<>() {
            {
                put("Dan Simmons", "Hyperion");
                put("Douglas Adams", "The Hitchhiker's Guide to the Galaxy");
            }
        };
        String[] HEADERS = { "author", "title"};


        String Filename = "Folder.csv";

        CsvFileCreator csvcreator = new CsvFileCreator();
        csvcreator.createCsvFile(Filename, HEADERS, AUTHOR_BOOK_MAP);
        csvcreator.reader(Filename);








    }





}

