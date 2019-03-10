package pl.sda.programming1.datastructures;

import java.util.List;
import java.util.Set;

public interface SetUtils {

    /**
     * Zwraca zbiór wartości które występują więcej niż raz w liście.
     */
    <T> Set<T> findDuplicates(List<T> values);

    /**
     * Zwraca zbiór wszystkich wartości występujących w obu listach.
     */
    <T> Set<T> findCommonValues(List<T> list1, List<T> list2);

}
