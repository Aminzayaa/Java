package jp.co.axiz.web.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.util.DbUtil;

/**
 * user_infoテーブル用サービス
 */
public class UserInfoService {

    /**
     * 認証処理
     */
    public UserInfo authentication(String loginId, String pass) {
        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);

            UserInfo user = userInfoDao.findByLoginIdAndPassword(loginId, pass);

            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 全件検索
     */
    public List<UserInfo> findAll() {
        List<UserInfo> list = new ArrayList<UserInfo>();

        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            list = userInfoDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 条件を指定した検索
     */
    public List<UserInfo> find(UserInfo cond) {
        List<UserInfo> list = new ArrayList<UserInfo>();

        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            list = userInfoDao.find(cond);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * login_idによる検索
     */
    public UserInfo findByLoginId(String loginId) {
        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            return userInfoDao.findByLoginId(loginId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 引数に指定したlogin_idのユーザが存在するかチェックする
     */
    public boolean existsUserByLoginId(String loginId) {
        return findByLoginId(loginId) != null;
    }

    /**
     * 引数に指定したlogin_idのユーザが存在するかチェックする
     * ※指定したuser_idは除外する。
     */
    public boolean existsUserByLoginIdExcludingUserId(String loginId, int findByLoginIdExcludingUserId) {
        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            return userInfoDao.findByLoginIdExcludingUserId(loginId, findByLoginIdExcludingUserId) != null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 登録
     */
    public void insert(UserInfo userInfo) {
        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            userInfoDao.insert(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新
     */
    public void update(UserInfo userInfo) {
        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            userInfoDao.update(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * user_idを指定して削除
     */
    public void delete(Integer userId) {
        try (Connection conn = DbUtil.getConnection()) {
            UserInfoDao userInfoDao = new UserInfoDao(conn);
            userInfoDao.delete(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}