package jp.co.axiz.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.web.entity.Role;

public class RoleDao {

    private final String SELECT_ALL = "SELECT role_id, role_name FROM role ORDER BY role_id";

    private Connection connection;

    public RoleDao(Connection connection) {
        this.connection = connection;
    }
    public List<Role> findAll() {
        ArrayList<Role> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Role role = new Role();
                role.setRoleId(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                list.add(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}