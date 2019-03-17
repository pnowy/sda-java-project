package pl.sda.programming1;

import pl.sda.programming1.datastructures.domain.Book;
import pl.sda.programming1.datastructures.domain.BookRepository;
import pl.sda.programming1.datastructures.domain.Student;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

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

    @Override
    public String concat(List<Integer> integers) {
        return integers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" | ", "{", "}"));
    }

    @Override
    public String concatConditional(List<Integer> integers) {
        return integers.stream()
                .map(x -> {
                    return x % 2 == 0 ? "e" + x : "o" + x;
                })
                .collect(Collectors.joining(" , ", "[", "]"));
    }

    @Override
    public int sumGreaterThan10(List<Integer> integers) {
        return 0;
    }

    @Override
    public List<String> distinctUpperCase(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<String> findAuthorByTitle(BookRepository repository, String title) {
        return repository.findByTitle(title).map(Book::getAuthor);
    }

    @Override
    public List<String> authorsOf(Book... books) {
        return Arrays.stream(books)
                .map(Book::getAuthor)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> keywordIn(Book... books) {
        return Arrays.stream(books)
                .map(Book::getTitle)
                .flatMap(title -> Arrays.stream(title.split("\\s+")))
                .peek(System.out::println)
                .map(word -> word.replaceAll("\\W", ""))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toSet());
    }

    @Override
    public Map<String, Book> byTitle(Book... books) {
        return Arrays.stream(books)
                .collect(Collectors.toMap(book -> book.getTitle(), book -> book));
    }

    @Override
    public Optional<Book> findMostEditions(Book... books) {
        return Arrays.stream(books)
                .reduce((book1, book2) -> {
                    return book2.getNumEditions() > book1.getNumEditions()
                            ? book2
                            : book1;
//                    if (book2.getNumEditions() > book1.getNumEditions()) {
//                        return book2;
//                    } else {
//                        return book1;
//                    }
                });
    }
}
