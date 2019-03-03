package pl.sda.programming1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        return null;
    }

    @Override
    public List<Car> objects(List<Map<String, Object>> values) {
        return null;
    }
}
