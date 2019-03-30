package pl.sda.programming1;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionsTest {
    private static final Logger log = LoggerFactory.getLogger(RegularExpressionsTest.class);
    @Test
    public void simpleMatchingFromString() {

//        String example = " \"Pan \\ Tadeusz\"  \r\n Nowa linia";
//        System.out.println(example);
//
//        String path = "c:\\Users\\";
//        String pathLinux = "c:/Users" + File.separator;
//        System.out.println(path);
//
//        Path p = Paths.get("users", "documents", "sda");
//        System.out.println(p);

        boolean numberMatching = "144523".matches("\\d{3,5}");
        System.out.println(numberMatching);
    }

    @Test
    public void regularExpressionTest() {
        boolean matches = "abaadfafew@@#@#@#".matches("a.*");
        System.out.println(matches);
    }

    @Test
    public void patternExample() {
        Pattern pattern = Pattern.compile("ala");
        boolean matches = pattern.matcher("ala").matches();
        System.out.println(matches);
    }

    @Test
    public void testQuestionMark() {
        Pattern pattern = Pattern.compile("kr?at");
        System.out.println(pattern.matcher("krat").matches());
        System.out.println(pattern.matcher("kat").matches());
        System.out.println(pattern.matcher("krxat").matches());
    }

    @Test
    public void testSymbolAsterix() {
        Pattern pattern = Pattern.compile("uwa*ga");
        System.out.println(pattern.matcher("uwaga").matches());
        System.out.println(pattern.matcher("uwaaaaaaaaga").matches());
        System.out.println(pattern.matcher("uwga").matches());
    }

    @Test
    public void testSymbolPlus() {
        Pattern pattern = Pattern.compile("trampo+lina");
        System.out.println(pattern.matcher("trampolina").matches());
        System.out.println(pattern.matcher("tramplina").matches());
        System.out.println(pattern.matcher("trampoooolina").matches());
    }

    @Test
    public void testDotSymbol() {
        Pattern pattern = Pattern.compile("k+a.*ta");
        System.out.println(pattern.matcher("katapulta").matches());
    }

    @Test
    public void testSimpleCases() {
        Pattern pattern = Pattern.compile("[A-Ga-w][rtmp]aca");
        System.out.println(pattern.matcher("1taca").matches());
        System.out.println(pattern.matcher("2raca").matches());
        System.out.println(pattern.matcher("gaca").matches());
    }

    @Test
    public void rangeTest() {
        Pattern pattern = Pattern.compile("[a-cA-C0-3]bum");
        System.out.println(pattern.matcher("abum").matches());
        System.out.println(pattern.matcher("3bum").matches());
    }

    @Test
    public void negationTest() {
        Pattern pattern = Pattern.compile("[^xyz]kom");
        System.out.println(pattern.matcher("xkom").matches());
        System.out.println(pattern.matcher("bkom").matches());
    }

    @Test
    public void simpleGroupTest() {
        Pattern pattern = Pattern.compile("(k.?t)");
        Matcher matcher = pattern.matcher("Ala ma kota, kot ma ale");
        while (matcher.find()) {
            log.info("group={}, start={}, end={}", matcher.group(), matcher.start(), matcher.end());
        }
    }

    @Test
    public void testNipWithGroups() {
        Pattern pattern = Pattern.compile("(\\d{3}-?\\d{3}-?\\d{2}-?\\d{2})");
        Matcher matcher = pattern.matcher("Klient posiada NIP 863-234-34-34 dla podanego towaru, inny nip: 7453434534");
        while (matcher.find()) {
            log.info("group={}, start={}, end={}", matcher.group(), matcher.start(), matcher.end());
        }
    }



}
