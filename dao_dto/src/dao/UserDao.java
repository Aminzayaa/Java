package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao {

	private static final String SQL_SELECT_ALL = "SELECT user_id, user_name, tel_no FROM users ORDER BY user_id";
	private static final String SQL_SELECT_WHERE_USER_ID = "SELECT user_id, user_name, tel_no FROM users WHERE user_id = ?";
	private static final String SQL_INSERT = "INSERT INTO users (user_id, user_name, tel_no) VALUES (?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE users SET user_name = ?, tel_no = ? WHERE user_id = ?";
	private static final String SQL_DELETE = "DELETE FROM users WHERE user_id = ?";

	private Connection connection;

	public UserDao(Connection connection) {
		this.connection = connection;
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<User>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User u = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("tel_no"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public User findById(int userId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_USER_ID)) {
			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("tel_no"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	public int insert(User user) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setInt(1, user.getUserId());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getTelNo());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int update(User user) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getTelNo());
			stmt.setInt(3, user.getUserId());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int delete(int userId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {
			stmt.setInt(1, userId);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
