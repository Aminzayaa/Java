package jp.co.axiz.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.util.ParamUtil;

/**
 * user_infoテーブル用DAO
 */
public class UserInfoDao {

    private static final String SELECT_ALL = "SELECT user_id, login_id, user_name, telephone, password, r.role_id, role_name FROM user_info u JOIN role r ON u.role_id = r.role_id ORDER BY user_id";
    private static final String SELECT = "SELECT user_id, login_id, user_name, telephone, password, r.role_id, role_name FROM user_info u JOIN role r ON u.role_id = r.role_id WHERE ";
    private static final String SELECT_BY_LOGIN_ID = "SELECT user_id, login_id, user_name, telephone, password, r.role_id, role_name FROM user_info u JOIN role r ON u.role_id = r.role_id WHERE login_id = ?";
    private static final String SELECT_BY_LOGIN_ID_EXCLUDING_USER_ID = "SELECT user_id, login_id, user_name, telephone, password, r.role_id, role_name FROM user_info u JOIN role r ON u.role_id = r.role_id WHERE login_id = ? AND user_id <> ?";
    private static final String SELECT_BY_LOGIN_ID_AND_PASS = "SELECT user_id, login_id, user_name, telephone, password, r.role_id, role_name FROM user_info u JOIN role r ON u.role_id = r.role_id WHERE login_id = ? AND password = ?";
    private static final String ORDER_BY = " ORDER BY user_id";
    private static final String INSERT = "INSERT INTO user_info (login_id, user_name, telephone, password, role_id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE user_info SET login_id = ? ,user_name = ?, telephone = ?, password = ?, role_id = ? WHERE user_id = ?";
    private static final String DELETE = "DELETE FROM user_info WHERE user_id = ?";

    private Connection connection;

    public UserInfoDao(Connection connection) {
        this.connection = connection;
    }

    /**
     * 全件取得
     */
    public List<UserInfo> findAll() {
        ArrayList<UserInfo> list = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UserInfo u = new UserInfo(
                        rs.getInt("user_id"),
                        rs.getString("login_id"),
                        rs.getString("user_name"),
                        rs.getString("telephone"),
                        rs.getString("password"),
                        rs.getInt("role_id"),
                        rs.getString("role_name"));

                list.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    /**
     * 条件を指定した検索
     */
    public List<UserInfo> find(UserInfo cond) {
        ArrayList<String> whereCond = new ArrayList<>();
        ArrayList<Object> param = new ArrayList<>();

        if (cond == null || cond.isEmptyCondition()) {
            // 検索条件が無い場合は全検索
            return findAll();
        }

        // 検索条件の有無に応じて、sqlのWHERE句に指定する条件文、
        // プレースホルダー置き換えようの値をストックしていく。

        if (!ParamUtil.isNullOrEmpty(cond.getUserName())) {
            whereCond.add("user_name = ?");
            param.add(cond.getUserName());
        }

        if (!ParamUtil.isNullOrEmpty(cond.getTelephone())) {
            whereCond.add("telephone = ?");
            param.add(cond.getTelephone());
        }

        // WHERE句の文字列生成
        String whereString = String.join(" AND ", whereCond.toArray(new String[] {}));

        ArrayList<UserInfo> list = new ArrayList<>();

        // SQL分生成
        String sql = SELECT + whereString + ORDER_BY;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // プレースホルダーの値をセット
            for (int i = 0; i < param.size(); i++) {
                stmt.setObject(i + 1, param.get(i));
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                UserInfo u = new UserInfo(
                        rs.getInt("user_id"),
                        rs.getString("login_id"),
                        rs.getString("user_name"),
                        rs.getString("telephone"),
                        rs.getString("password"),
                        rs.getInt("role_id"),
                        rs.getString("role_name"));

                list.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    /**
     * login_idによる検索
     */
    public UserInfo findByLoginId(String loginId) {
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_BY_LOGIN_ID)) {
            stmt.setString(1, loginId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UserInfo u = new UserInfo(
                        rs.getInt("user_id"),
                        rs.getString("login_id"),
                        rs.getString("user_name"),
                        rs.getString("telephone"),
                        rs.getString("password"),
                        rs.getInt("role_id"),
                        rs.getString("role_name"));

                return u;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    /**
     * login_idによる検索
     * ※指定したuser_idは除外する
     */
    public UserInfo findByLoginIdExcludingUserId(String loginId, int excludingUserId) {
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_BY_LOGIN_ID_EXCLUDING_USER_ID)) {
            stmt.setString(1, loginId);
            stmt.setInt(2, excludingUserId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UserInfo u = new UserInfo(
                        rs.getInt("user_id"),
                        rs.getString("login_id"),
                        rs.getString("user_name"),
                        rs.getString("telephone"),
                        rs.getString("password"),
                        rs.getInt("role_id"),
                        rs.getString("role_name"));

                return u;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    /**
     * login_id、passwordによる検索
     */
    public UserInfo findByLoginIdAndPassword(String loginId, String password) {
        try (PreparedStatement stmt = connection.prepareStatement(SELECT_BY_LOGIN_ID_AND_PASS)) {
            stmt.setString(1, loginId);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                UserInfo u = new UserInfo();
                u.setUserId(rs.getInt("user_id"));
                u.setLoginId(rs.getString("login_id"));
                u.setUserName(rs.getString("user_name"));
                u.setTelephone(rs.getString("telephone"));
                u.setPassword(rs.getString("password"));
                u.setRoleId(rs.getInt("role_id"));
                u.setRoleName(rs.getString("role_name"));
                return u;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    /**
     * 登録
     */
    public void insert(UserInfo user) {
        try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {
            stmt.setString(1, user.getLoginId());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, user.getTelephone());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getRoleId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新
     */
    public void update(UserInfo user) {
        try (PreparedStatement stmt = connection.prepareStatement(UPDATE)) {
            stmt.setString(1, user.getLoginId());
            stmt.setString(2, user.getUserName());
            stmt.setString(3, user.getTelephone());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getRoleId());
            stmt.setInt(6, user.getUserId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * user_idを指定して削除
     */
    public void delete(Integer id) {
        try (PreparedStatement stmt = connection.prepareStatement(DELETE)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}