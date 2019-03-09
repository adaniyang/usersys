package com.springboot.usersys.pojo.vo;

import java.util.List;

/**
 * @Author:adayang
 * @Describe:
 * @Date:2019/2/28 19:17
 * @Modify by:
 */
public class RoleGroupInforVo {
    private String roleGroupFkCode;
    private String roleGroupName;
    private List<EduRoleVo> eduRoleVoList;

    public String getRoleGroupFkCode() {
        return roleGroupFkCode;
    }

    public void setRoleGroupFkCode(String roleGroupFkCode) {
        this.roleGroupFkCode = roleGroupFkCode;
    }

    public String getRoleGroupName() {
        return roleGroupName;
    }

    public void setRoleGroupName(String roleGroupName) {
        this.roleGroupName = roleGroupName;
    }

    public List<EduRoleVo> getEduRoleVoList() {
        return eduRoleVoList;
    }

    public void setEduRoleVoList(List<EduRoleVo> eduRoleVoList) {
        this.eduRoleVoList = eduRoleVoList;
    }
}
