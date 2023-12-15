package pr4;

public class Book {
    private String author;
    private String name;
    private int year;
    private String isbn;

    public Book(String author, String name, int year, String isbn) {
        this.author = author;
        this.name = name;
        this.year = year;
        this.isbn = isbn;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getYear() {
        return year;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(String name) {
        return name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getAuthor(String author) {
        return author;
    }
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }
    public String getISBN(String isbn) {
        return isbn;
    }
    @Override
    public String toString() {
        return "Автор книги: " + this.author + ", Название книги: " + this.name
                + ", Год издания: " + this.year + ", ISBN: " + this.isbn;
    }
}
