package com.springboot.usersys.pojo.vo;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/2/28 19:23
 * @Modify by:
 */
public class EduRoleVo {
    private String roleFkCode;
    private String roleName;
    private Integer delStatus;

    public String getRoleFkCode() {
        return roleFkCode;
    }

    public void setRoleFkCode(String roleFkCode) {
        this.roleFkCode = roleFkCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }
}
