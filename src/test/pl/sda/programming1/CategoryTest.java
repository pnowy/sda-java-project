package pl.sda.programming1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.sda.programming1.datastructures.domain.Box;
import pl.sda.programming1.datastructures.domain.Category;

import java.util.Arrays;
import java.util.UUID;

public class CategoryTest {

    private static final Logger log = LoggerFactory.getLogger(CategoryTest.class);

    @Test
    public void categoryTest() {
        Category root = new Category("Kategoria główna");
        Category engines = root.addSubcategory("Silniki");
        engines.addSubcategory("Filtry");
        Category tires = root.addSubcategory("Opony");
        Category zimowe = tires.addSubcategory("Zimowe");
        zimowe.addSubcategory("Michelin");
        Category summerTires = tires.addSubcategory("Letnie");
        summerTires.addSubcategory("Dunlop");

        log.info("{}", root);
    }

    @Test
    public void uuidTest() {
        System.out.println(UUID.randomUUID().toString());
    }

    @Test
    public void carTest() {
        Box box = new Box();
        box
                .setId(2L)
                .setModel("New")
                .setName("MyBox");

//        Arrays.asList("A", "B", "C", "D").stream()
//                .filter()
//                .map()
//                .peek()
//                .count();
    }
}
