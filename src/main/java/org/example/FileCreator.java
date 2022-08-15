package org.example;

import java.io.IOException;
import java.util.Map;

public interface FileCreator {
    public  void createCsvFile(String filename, String [] HEADERS, Map<Integer, String> PLAYER_LIST) throws IOException;
    public void reader(String filename) throws IOException;


}
