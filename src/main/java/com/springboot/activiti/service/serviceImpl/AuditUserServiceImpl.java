package com.springboot.activiti.service.serviceImpl;

import com.common.Assist;
import com.springboot.activiti.dao.AuditUserDao;
import com.springboot.activiti.domain.AuditUser;
import com.springboot.activiti.service.AuditUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditUserServiceImpl implements AuditUserService {
    @Autowired
    private AuditUserDao auditUserDao;
    @Override
    public long getAuditUserRowCount(Assist assist){
        return auditUserDao.getAuditUserRowCount(assist);
    }
    @Override
    public List<AuditUser> selectAuditUser(Assist assist){
        return auditUserDao.selectAuditUser(assist);
    }
    @Override
    public AuditUser selectAuditUserByObj(AuditUser obj){
        return auditUserDao.selectAuditUserByObj(obj);
    }
    @Override
    public AuditUser selectAuditUserById(Long id){
        return auditUserDao.selectAuditUserById(id);
    }
    @Override
    public int insertAuditUser(AuditUser value){
        return auditUserDao.insertAuditUser(value);
    }
    @Override
    public int insertNonEmptyAuditUser(AuditUser value){
        return auditUserDao.insertNonEmptyAuditUser(value);
    }
    @Override
    public int insertAuditUserByBatch(List<AuditUser> value){
        return auditUserDao.insertAuditUserByBatch(value);
    }
    @Override
    public int deleteAuditUserById(Long id){
        return auditUserDao.deleteAuditUserById(id);
    }
    @Override
    public int deleteAuditUser(Assist assist){
        return auditUserDao.deleteAuditUser(assist);
    }
    @Override
    public int updateAuditUserById(AuditUser enti){
        return auditUserDao.updateAuditUserById(enti);
    }
    @Override
    public int updateAuditUser(AuditUser value, Assist assist){
        return auditUserDao.updateAuditUser(value,assist);
    }
    @Override
    public int updateNonEmptyAuditUserById(AuditUser enti){
        return auditUserDao.updateNonEmptyAuditUserById(enti);
    }
    @Override
    public int updateNonEmptyAuditUser(AuditUser value, Assist assist){
        return auditUserDao.updateNonEmptyAuditUser(value,assist);
    }

    public AuditUserDao getAuditUserDao() {
        return this.auditUserDao;
    }

    public void setAuditUserDao(AuditUserDao auditUserDao) {
        this.auditUserDao = auditUserDao;
    }

}