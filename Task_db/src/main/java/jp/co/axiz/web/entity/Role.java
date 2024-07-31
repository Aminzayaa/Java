package jp.co.axiz.web.entity;

/**
 * roleテーブルのEntity
 */
public class Role {

    private Integer roleId; // role_id
    private String roleName; // role_name

    public Role() {
    }

    public Role(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer _roleId) {
        this.roleId = _roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String _roleName) {
        this.roleName = _roleName;
    }
}