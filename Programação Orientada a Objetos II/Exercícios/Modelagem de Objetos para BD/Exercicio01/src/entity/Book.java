package entity;

public class Book {
    private int id_book;
    private String title;
    private int date_book;
    private int id_author;

    public Book(String title, int date_book, int id_author) {
        this.title = title;
        this.date_book = date_book;
        this.id_author = id_author;
    }

    public Book() {

    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate_book() {
        return date_book;
    }

    public void setDate_book(int date_book) {
        this.date_book = date_book;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    @Override
    public String toString() {
        return "Book {" +
                "id_book = " + id_book +
                ", title = '" + title + "\'" +
                ", date_book = " + date_book +
                ", id_author = " + id_author +
                "}";
    }
}
