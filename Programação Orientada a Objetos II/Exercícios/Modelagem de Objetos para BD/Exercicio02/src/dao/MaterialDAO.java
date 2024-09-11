package dao;

import entity.Material;
import entity.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO extends BaseDAO {
    public void create() {
        String sql = """
                create table if not exists material(id_material integer primary key autoincrement, name varchar(255), quantity integer);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(Material material) {
        String sql = """
                insert into material(name, quantity) values (?, ?);
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, material.getName());
            pre.setInt(2, material.getQuantity());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Material material) {
        String sql = """
                update material set name = ? where id_material = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setString(1, material.getName());
            pre.setInt(2, material.getId_material());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Material material) {
        String sql = """
                delete from material where id_material = ?;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql)) {
            pre.setInt(1, material.getId_material());
            pre.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Material> getAll() {
        List<Material> list = new ArrayList<>();
        String sql = """
                select * from material;
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            while (rs.next()) {
                Material material = new Material();
                material.setId_material(rs.getInt("id_material"));
                material.setName(rs.getString("name"));
                material.setQuantity(rs.getInt("quantity"));
                list.add(material);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Material> materialsPerProject(Project project) throws SQLException {
        List<Material> list = new ArrayList<>();
        String sql = """
                select m.* from material m join material_consumption mc on m.id_material = mc.id_material where mc.id_project = ?
                """;
        try(Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {
            pre.setInt(1, project.getId_project());
            try (ResultSet rs2 = pre.executeQuery()) {
                while (rs2.next()) {
                    Material material = new Material();
                    material.setId_material(rs.getInt("id_material"));
                    material.setName(rs.getString("name"));
                    material.setQuantity(rs.getInt("quantity"));
                    list.add(material);
                }
            }
        }
        return list;
    }
}
