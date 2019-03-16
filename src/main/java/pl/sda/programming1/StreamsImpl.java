package pl.sda.programming1;

import java.util.Arrays;
import java.util.OptionalInt;

public class StreamsImpl implements Streams {
    @Override
    public OptionalInt indexOf(String string, char c) {
        int i = string.indexOf(c);
        return i == -1 ? OptionalInt.empty() : OptionalInt.of(i);
    }

    @Override
    public OptionalInt getMax(int[] ints) {
        return Arrays.stream(ints).max();
    }
}
