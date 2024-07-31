package jp.co.axiz.web.servlet;

import java.util.List;

import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.entity.UserInfo;

/**
 * セッション情報を纏めて管理するためのクラス
 */
public class SessionInfo {
    UserInfo loginUser; // ログインユーザ情報
    List<Role> roleList; // Role一覧
    UserInfo registerUser; // 登録画面で入力したユーザ情報
    UserInfo prevUpdateUser; // 更新画面で取得した更新前のユーザ情報
    UserInfo updateUser; // 更新画面で入力したユーザ情報

    /**
     * ログインユーザ情報設定
     */
    public void setLoginUser(UserInfo _loginUser) {
        loginUser = _loginUser;
    }

    /**
     * ログインユーザ情報取得
     */
    public UserInfo getLoginUser() {
        return loginUser;
    }

    /**
     * Role情報一覧設定
     */
    public void setRoleList(List<Role> _roleList) {
        roleList = _roleList;
    }

    /**
     * Role情報一覧取得
     */
    public List<Role> getRoleList() {
        return roleList;
    }

    /**
     * 登録画面で入力したユーザ情報設定
     */
    public void setRegisterUser(UserInfo _registerUser) {
        registerUser = _registerUser;
    }

    /**
     * 登録画面で入力したユーザ情報取得
     */
    public UserInfo getRegisterUser() {
        return registerUser;
    }

    /**
     * 更新画面で取得した更新前のユーザ情報設定
     */
    public void setPrevUpdateUser(UserInfo _prevUpdateUser) {
        prevUpdateUser = _prevUpdateUser;
    }

    /**
     * 更新画面で取得した更新前のユーザ情報取得
     */
    public UserInfo getPrevUpdateUser() {
        return prevUpdateUser;
    }

    /**
     * 更新画面で入力したユーザ情報設定
     */
    public void setUpdateUser(UserInfo _updateUser) {
        updateUser = _updateUser;
    }

    /**
     * 更新画面で入力したユーザ情報取得
     */
    public UserInfo getUpdateUser() {
        return updateUser;
    }
}