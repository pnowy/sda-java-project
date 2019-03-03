package pl.sda.programming1;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        CsvReaderUtils csvReaderUtils = new CsvReaderUtils();
        List<String[]> listOfCars = csvReaderUtils.readLines(new File("cars.csv"));
        listOfCars.forEach(record -> {
            System.out.println(Arrays.toString(record));
        });

        List<Map<String, Object>> convertedList = csvReaderUtils.convert(listOfCars);
        convertedList.forEach(record ->{
            System.out.println(Arrays.toString(new Map[]{record}));
        });

        List<Car> cars = csvReaderUtils.objects(convertedList);
        cars.forEach(System.out::println);
    }

}
