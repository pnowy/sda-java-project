package pl.sda.programming1;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface Streams {

    /**
     * Pierwszy indeks pod którym podany znak znajduje się w podanym Stringu
     */
    OptionalInt indexOf(String string, char c);

    OptionalInt getMax(int[] ints);

    OptionalInt getMax(List<Integer> ints);
}