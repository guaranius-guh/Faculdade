package dao;

import entity.Author;
import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends BaseDAO {
    public void create() {
        String sql = """
                create table if not exists book(id_book integer primary key autoincrement, title varchar(255), date_book int(4), id_author int, foreign key(id_author) references author(id_author));
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Book book) {
        String sql = """
                insert into book(title, date_book, id_author) values(?, ?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, book.getTitle());
            pre.setInt(2, book.getDate_book());
            pre.setInt(3, book.getId_author());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Book book) {
        String sql = """
                update book set title = ? where id_book = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, book.getTitle());
            pre.setInt(2, book.getId_book());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Book book) {
        String sql = """
                delete from book where id_book = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, book.getId_book());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        String sql = """
                select * from book;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                Book book = new Book();
                book.setId_book(rs.getInt("id_book"));
                book.setTitle(rs.getString("title"));
                book.setDate_book(rs.getInt("date_book"));
                book.setId_author(rs.getInt("id_author"));
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
