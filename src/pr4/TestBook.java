package pr4;

public class TestBook {
    public static void main(String[] args) {
        Book book = new Book("Никколо Макиавелли", "Государь",  2022, "978-5-38-907365-4 ");
        System.out.println(book);
        book.setYear(2023);
        System.out.println(book);
    }
}
