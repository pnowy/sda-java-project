package pl.sda.programming1.datastructures.domain;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        Integer o1Length = o1.length();
        return o1Length.compareTo(o2.length());
    }
}
