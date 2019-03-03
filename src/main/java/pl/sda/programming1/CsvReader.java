package pl.sda.programming1;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface CsvReader {

    String[] readLines(File file);

    List<Map<String, Object>> convert(String[] lines);

    List<Car> objects(List<Map<String, Object>> values);

}
