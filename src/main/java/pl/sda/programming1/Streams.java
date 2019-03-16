package pl.sda.programming1;

import pl.sda.programming1.datastructures.domain.BookRepository;
import pl.sda.programming1.datastructures.domain.Student;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface Streams {

    /**
     * Pierwszy indeks pod którym podany znak znajduje się w podanym Stringu
     */
    OptionalInt indexOf(String string, char c);

    OptionalInt getMax(int[] ints);

    OptionalInt getMax(List<Integer> ints);

    OptionalDouble getAverage(List<Integer> integers);

    OptionalDouble getStudentsAverage(Student ... students);

    /**
     * [1, 2, 10] -> "[1,2,10]"
     */
    String concat(List<Integer> integers);

    /**
     * Jeżeli liczba jest parzysta poprzedź ją 'e' jeżeli nieparzysta poprzed ją 'o'
     *
     * [1, 2, 10] -> "[o1, e2, e10]"
     */
    String concatConditional(List<Integer> integers);

    int sumGreaterThan10(List<Integer> integers);

    /**
     * Metoda powinna zwrócić unikalną listę imion (wielkimi literami) z ograniczeniem do maksymalnie 3.
     */
    List<String> distinctUpperCase(List<String> names);

    /**
     * Wyszukuje autora książki po podanym tytule.
     */
    Optional<String> findAuthorByTitle(BookRepository repository, String title);
}
