package pl.sda.programming1;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.domain.Book;
import pl.sda.programming1.datastructures.domain.BookRepository;
import pl.sda.programming1.datastructures.domain.PatientType;
import pl.sda.programming1.datastructures.domain.Student;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static pl.sda.programming1.datastructures.domain.PatientType.*;

public class StreamTest {

    private static final Logger log = LoggerFactory.getLogger(StreamTest.class);

    private Streams streams = new StreamsImpl();

    @Test
    public void indexOfTest() {
        assertThat(streams.indexOf("ala ma kota", 'k')).hasValue(7);
        assertThat(streams.indexOf("ala ma kota", 'd').isPresent()).isFalse();
        assertThat(streams.indexOf("ala ma kota", 'd')).isNotPresent();
    }

    @Test
    public void maxTest() {
        assertThat(streams.getMax(new int[]{4, 7, 199, 9})).hasValue(199);
        assertThat(streams.getMax(new int[]{})).isEmpty();
        PatientType patientType = GOLD;
        patientType.doSomething();
        assertThat(patientType).isNotEqualTo(DEAD);

        assertThat(streams.getMax(Lists.newArrayList(34, 5, 111))).hasValue(111);
    }

    @Test
    public void avgTest() {
        assertThat(streams.getAverage(Arrays.asList(3, 6, 9))).hasValue(6.0);
    }

    @Test
    public void streamExamples() {
        Function<String, Integer> convertToInteger = stringValue -> {
            return Integer.valueOf(stringValue);
        };
        Consumer<Integer> printlnConsumerContract = System.out::println;
        Function<String, Integer> transformStringToInteger = Integer::valueOf;
        Lists.newArrayList("1", "2", "3").stream()
                .map(transformStringToInteger)
                .map(intValue -> {
                    return intValue * 2;
                })
                .filter(integer -> integer > 1)
                .forEach(printlnConsumerContract);

//        ArrayList<String> myList = Lists.newArrayList("1", "2", "3");
//        Stream<String> myStream = myList.stream();
//        Stream<String> stream = myList.stream();
//        stream.forEach(System.out::println);
//        List<String> myNewList = stream.collect(Collectors.toList());


//        myStream.forEach(System.out::println);

    }

    @Test
    public void studentTest() {
        OptionalDouble studentsAverage = streams.getStudentsAverage(
                new Student("Maciej", 4, 5),
                new Student("Witek", 3, 6)
        );
        log.info("students avg = {}", studentsAverage);
    }

    @Test
    public void concatTest() {
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 10);
        log.info("concat {} gives {}", integers, streams.concat(integers));
        log.info("concat conditional {} gives {}", integers, streams.concatConditional(integers));
    }

    @Test
    public void distinctNamesTest() {
        log.info("distinct names = {}", streams.distinctUpperCase(Lists.newArrayList("Kowalski",
                "Nowak", "Moniuszko", "Słowacki", "Kowalski", "Adamski", "adAmSki")));
    }

    private Book effectiveJava = new Book("Effective Java", "Joshua Bloch", 3);
    private Book cleanCode = new Book("Clean - code", "Robert C. Martin", 1);
    private Book cleanCode2 = new Book("Clean code 2", "Robert C. Martin", 2);
    private Book javaConcurrency = new Book("Java Concurrency", "Brian Goetz", 1);

    @Test
    public void reduceBookTest() {
        Optional<Book> mostEditions = streams.findMostEditions(effectiveJava, cleanCode, javaConcurrency);
        log.info("book with most editions={}", mostEditions);
    }

    @Test
    public void findAuthorByTitleTest() {
//        Map<String, Book> books = new HashMap<>();
//        books.put(effectiveJava.getTitle(), effectiveJava);
//        books.put(cleanCode.getTitle(), cleanCode);
//        books.put(javaConcurrency.getTitle(), javaConcurrency);
        // equivalent of above code
        Map<String, Book> books = ImmutableMap.<String, Book>builder()
                .put(effectiveJava.getTitle(), effectiveJava)
                .put(cleanCode.getTitle(), cleanCode)
                .put(javaConcurrency.getTitle(), javaConcurrency)
                .build();

        BookRepository bookRepository =
                title -> Optional.ofNullable(books.get(title));

        assertThat(bookRepository.findByTitle("Clean code")).isPresent();
        assertThat(bookRepository.findByTitle("Cooking on the beach")).isNotPresent();
    }

    @Test
    public void authorsOfBooksTest() {
//        List<String> authors = streams.authorsOf(cleanCode2, javaConcurrency, effectiveJava, cleanCode);
//        log.info("Authors={}", authors);
        log.info("Title words={}", streams.keywordIn(javaConcurrency, cleanCode, effectiveJava));
    }

    @Test
    public void regularTest() {
        System.out.println(Arrays.toString("ala ma    kota".split("\\s+")));
    }

    @Test
    public void byTitleTest() {
        Map<String, Book> booksByTitle =
                streams.byTitle(javaConcurrency, cleanCode, effectiveJava);
        log.info("Books by title={}", booksByTitle);
    }
}
