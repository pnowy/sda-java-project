package pl.sda.programming1.datastructures;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetUtilsImpl implements SetUtils {

    @Override
    public <T> Set<T> findDuplicates(List<T> values) {
        Set<T> duplicates = new HashSet<>();
        Set<T> all = new HashSet<>();
        for (T value : values) {
            boolean isAdded = all.add(value);
            if (!isAdded) {
                duplicates.add(value);
            }
        }
        return duplicates;
    }

}
