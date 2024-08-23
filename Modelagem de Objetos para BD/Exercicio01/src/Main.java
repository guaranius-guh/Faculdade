import dao.AuthorDAO;
import dao.BookDAO;
import entity.Author;
import entity.Book;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Author author = new Author("Mario Müller", "German");
        Book book = new Book("The Witcher II", 2007, 3);

        AuthorDAO authorDAO = new AuthorDAO();
        //authorDAO.create();
        //authorDAO.insert(author);
        //authorDAO.update(author);
        //authorDAO.delete(author);
        for(var a : authorDAO.getAll()) {
            System.out.println(a);
        }

        BookDAO bookDAO = new BookDAO();
        //bookDAO.create();
        //bookDAO.insert(book);
        //bookDAO.update(book);
        //bookDAO.delete(book);
        for(var a : bookDAO.getAll()) {
            System.out.println(a);
        }
    }
}
