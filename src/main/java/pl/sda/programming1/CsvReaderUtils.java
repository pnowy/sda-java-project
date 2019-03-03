package pl.sda.programming1;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class CsvReaderUtils implements CsvReader {


    @Override
    public List<String[]> readLines(File file) {
        String[] carParameters;
        List<String[]> listOfString = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                carParameters = line.split(";");
                listOfString.add(carParameters);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfString;
    }

    @Override
    public List<Map<String, Object>> convert(List<String[]> lines) {
        List<Map<String, Object>> convertedList = new ArrayList<>();
        int i = 0;
        String[] keyWords = lines.get(0);
        for (String[] line : lines) {
            if (i != 0) {
                int j = 0;
                Map<String, Object> stringToMap = new HashMap<>();
                for (String word : line) {
                    stringToMap.put(keyWords[j], word);
                    j++;
                }
                convertedList.add(stringToMap);
            } else {
                keyWords = lines.get(i);
            }
            i++;
        }
        return convertedList;
    }

    @Override
    public List<Car> objects(List<Map<String, Object>> values) {
        List<Car> cars = new ArrayList<>();
        for (Map<String, Object> value : values) {
            cars.add(new Car(value.get("MARKA").toString(),
                    value.get("MODEL").toString(),
                    Integer.valueOf(value.get("ROK").toString()),
                    Integer.valueOf(value.get("KM").toString()),
                    new BigDecimal(Integer.valueOf(value.get("CENA").toString())),
                    value.get("WYPOSAŻENIE").toString()));
        }
        return cars;
    }
}
