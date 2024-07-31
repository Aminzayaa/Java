package jp.co.axiz.web.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.web.dao.RoleDao;
import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.util.DbUtil;

/**
 * roleテーブル用サービス
 */
public class RoleService {

    /**
     * 全件取得
     */
    public List<Role> findAll() {
        List<Role> list = new ArrayList<Role>();

        try (Connection conn = DbUtil.getConnection()) {
            RoleDao roleDao = new RoleDao(conn);
            list = roleDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}