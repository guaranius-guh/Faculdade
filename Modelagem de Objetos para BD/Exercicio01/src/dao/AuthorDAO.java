package dao;

import entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO extends BaseDAO {
    public void create() {
        String sql = """
                create table if not exists author (id_author integer primary key autoincrement, name varchar(255), nationality varchar(255));
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Author author) {
        String sql = """
                insert into author(name, nationality) values(?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, author.getName());
            pre.setString(2, author.getNationality());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Author author) {
        String sql = """
                update author set name = ? where id_author = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, author.getName());
            pre.setInt(2, author.getId_author());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Author author) {
        String sql = """
                delete from author where id_author = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, author.getId_author());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Author> getAll() {
        List<Author> list = new ArrayList<>();
        String sql = """
                select * from author;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                Author author = new Author();
                author.setId_author(rs.getInt("id_author"));
                author.setName(rs.getString("name"));
                author.setNationality(rs.getString("nationality"));
                list.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
