package pl.sda.programming1;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiConsumer;

public class CsvReaderUtils implements CsvReader {



    @Override
    public List<String[]> readLines(File file) {
        String[] carParameters;
        List<String[]> listOfString = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int i = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (i != 0) {
                    carParameters = line.split(";");
                    listOfString.add(carParameters);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfString;
    }

    @Override
    public List<Map<String, Object>> convert(List<String[]> lines) {

        List<Map<String, Object>> result = new ArrayList<>();

        for (String[] line : lines) {
            // procesowanie pojedynczego elementu - start
            Map<String, Object> element = convertSingleElement(line);
            result.add(element);
            // procesowanie pojedynczego elementu - stop
        }

        return result;
    }

    private Map<String, Object> convertSingleElement(String[] array) {
        Map<String, Object> map = new HashMap<>();
        map.put("MARKA", array[0]);
        map.put("MODEL", array[1]);
        map.put("ROK", Integer.valueOf(array[2]));
        map.put("KM", Integer.valueOf(array[3]));
        map.put("CENA", new BigDecimal(array[4]));
        return map;
    }

    @Override
    public List<Car> objects(List<Map<String, Object>> values) {
        return null;
    }
}
