package application.fileHandlers;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.util.*;

public class CSVCarList {
    private static final String dir = "src\\main\\resources\\marki.csv";


    public static Map<String, Set<String>> readAndMapFile() throws Exception {
        FileReader fileReader = new FileReader(new File(dir));
        CSVParser parser = new CSVParser(fileReader, CSVFormat.EXCEL);
        Map<String, Set<String>> brandAndModels= new TreeMap<>();
        Set<String> models = new TreeSet<>();
        String make = "make";
        for (CSVRecord record:parser) {
            if(!record.get(0).equals(make)){
                brandAndModels.put(make, models);
                make = record.get(0);
                models = new TreeSet<>();
            }
            models.add(record.get(1));
        }
        brandAndModels.remove("make");
        brandAndModels.remove("other");

        return brandAndModels;
    }

}
