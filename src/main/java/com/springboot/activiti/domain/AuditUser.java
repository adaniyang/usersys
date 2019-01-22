package com.springboot.activiti.domain;
public class AuditUser {
    private Long id;//主键
    private Long userfkcode;//审核人外键
    private Integer delstatus;//删除状态
    private java.util.Date createtime;//创建时间
    private java.util.Date updatetime;//修改时间
    private String level;//几级审核人
    private String username;//审核人名字
    private Long fkcode;//外键
    public AuditUser() {
        super();
    }
    public AuditUser(Long id,Long userfkcode,Integer delstatus,java.util.Date createtime,java.util.Date updatetime,String level,String username,Long fkcode) {
        super();
        this.id = id;
        this.userfkcode = userfkcode;
        this.delstatus = delstatus;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.level = level;
        this.username = username;
        this.fkcode = fkcode;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserfkcode() {
        return this.userfkcode;
    }

    public void setUserfkcode(Long userfkcode) {
        this.userfkcode = userfkcode;
    }

    public Integer getDelstatus() {
        return this.delstatus;
    }

    public void setDelstatus(Integer delstatus) {
        this.delstatus = delstatus;
    }

    public java.util.Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public java.util.Date getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(java.util.Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getFkcode() {
        return this.fkcode;
    }

    public void setFkcode(Long fkcode) {
        this.fkcode = fkcode;
    }

}
