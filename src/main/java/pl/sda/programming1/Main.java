package pl.sda.programming1;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CsvReaderUtils csvReaderUtils = new CsvReaderUtils();
        List<String[]> listOfCars = csvReaderUtils.readLines(new File("cars.csv"));
        listOfCars.forEach(record -> {
            System.out.println(Arrays.toString(record));
        });
    }

}
