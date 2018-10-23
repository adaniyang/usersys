package com.springboot.usersys.pojo;
public class Department1 {
    private Long id;//主键
    private String departmentName;//部门名
    private Integer delStatus;//删除状态
    private java.util.Date createTime;//创建时间
    private java.util.Date updateTime;//更新时间
    private Long parentId;//父节点的ID
    public Department1() {
        super();
    }
    public Department1(Long id,String departmentName,Integer delStatus,java.util.Date createTime,java.util.Date updateTime,Long parentId) {
        super();
        this.id = id;
        this.departmentName = departmentName;
        this.delStatus = delStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.parentId = parentId;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

}
