package pl.sda.programming1;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.ToIntFunction;

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

    @Override
    public OptionalInt getMax(List<Integer> ints) {
        return ints.stream()
                .mapToInt(Integer::intValue)
                .max();

//        Arrays.asList("1", "2", "3").stream()
//                .mapToInt(new ToIntFunction<String>() {
//                    @Override
//                    public int applyAsInt(String value) {
//                        return Integer.valueOf(value);
//                    }
//                }).max();

//        return ints.stream()
//                .max(Integer::compareTo);

//        return ints.stream()
//                .max((a, b) -> a - b);

//        return ints.stream()
//                .max((a, b) -> a.compareTo(b));
    }
}
