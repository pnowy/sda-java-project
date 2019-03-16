package pl.sda.programming1.datastructures.domain;

public class Book {
    private final String title;
    private final String author;
    private final int numEditions;

    public Book(String title, String author, int numEditions) {
        this.title = title;
        this.author = author;
        this.numEditions = numEditions;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumEditions() {
        return numEditions;
    }
}
