package pl.sda.programming1;

import pl.sda.programming1.datastructures.domain.Student;

import java.util.*;
import java.util.function.Function;
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

    @Override
    public OptionalDouble getAverage(List<Integer> integers) {
        return integers.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    @Override
    public OptionalDouble getStudentsAverage(Student... students) {
        return Arrays.stream(students)
                .flatMap(s -> s.getGrades().stream())
//                .peek(System.out::println)
                .mapToDouble(Integer::doubleValue)
                .average();
    }
}
