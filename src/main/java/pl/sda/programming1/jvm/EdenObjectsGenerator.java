package pl.sda.programming1.jvm;

public class EdenObjectsGenerator {

    private void createArrays() {
        int arraySize = 50_000;

        while (true) {
            System.out.println(Runtime.getRuntime().freeMemory());
            int[] fillMemory = new int[arraySize];
        }
    }

    public static void main(String[] args) {
        EdenObjectsGenerator edenObjectsGenerator = new EdenObjectsGenerator();
        edenObjectsGenerator.createArrays();
    }

}
