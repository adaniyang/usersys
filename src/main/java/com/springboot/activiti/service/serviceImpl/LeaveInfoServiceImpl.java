package com.springboot.activiti.service.serviceImpl;

import com.common.Assist;
import com.springboot.activiti.dao.LeaveInfoDao;
import com.springboot.activiti.domain.LeaveInfo;
import com.springboot.activiti.service.LeaveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveInfoServiceImpl implements LeaveInfoService {
    @Autowired
    private LeaveInfoDao leaveInfoDao;
    @Override
    public long getLeaveInfoRowCount(Assist assist){
        return leaveInfoDao.getLeaveInfoRowCount(assist);
    }
    @Override
    public List<LeaveInfo> selectLeaveInfo(Assist assist){
        return leaveInfoDao.selectLeaveInfo(assist);
    }
    @Override
    public LeaveInfo selectLeaveInfoByObj(LeaveInfo obj){
        return leaveInfoDao.selectLeaveInfoByObj(obj);
    }
    @Override
    public LeaveInfo selectLeaveInfoById(Long id){
        return leaveInfoDao.selectLeaveInfoById(id);
    }
    @Override
    public int insertLeaveInfo(LeaveInfo value){
        return leaveInfoDao.insertLeaveInfo(value);
    }
    @Override
    public int insertNonEmptyLeaveInfo(LeaveInfo value){
        return leaveInfoDao.insertNonEmptyLeaveInfo(value);
    }
    @Override
    public int insertLeaveInfoByBatch(List<LeaveInfo> value){
        return leaveInfoDao.insertLeaveInfoByBatch(value);
    }
    @Override
    public int deleteLeaveInfoById(Long id){
        return leaveInfoDao.deleteLeaveInfoById(id);
    }
    @Override
    public int deleteLeaveInfo(Assist assist){
        return leaveInfoDao.deleteLeaveInfo(assist);
    }
    @Override
    public int updateLeaveInfoById(LeaveInfo enti){
        return leaveInfoDao.updateLeaveInfoById(enti);
    }
    @Override
    public int updateLeaveInfo(LeaveInfo value, Assist assist){
        return leaveInfoDao.updateLeaveInfo(value,assist);
    }
    @Override
    public int updateNonEmptyLeaveInfoById(LeaveInfo enti){
        return leaveInfoDao.updateNonEmptyLeaveInfoById(enti);
    }
    @Override
    public int updateNonEmptyLeaveInfo(LeaveInfo value, Assist assist){
        return leaveInfoDao.updateNonEmptyLeaveInfo(value,assist);
    }

    public LeaveInfoDao getLeaveInfoDao() {
        return this.leaveInfoDao;
    }

    public void setLeaveInfoDao(LeaveInfoDao leaveInfoDao) {
        this.leaveInfoDao = leaveInfoDao;
    }

}