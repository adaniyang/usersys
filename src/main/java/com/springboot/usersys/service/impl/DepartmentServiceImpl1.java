package com.springboot.usersys.service.Impl;
import java.util.List;
import com.springboot.usersys.dao.DepartmentDao1;
import com.springboot.usersys.pojo.Department1;
import com.common.Assist;
import com.springboot.usersys.service.DepartmentService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DepartmentServiceImpl1 implements DepartmentService1{
    @Autowired
    private DepartmentDao1 departmentDao1;
    @Override
    public long getDepartment1RowCount(Assist assist){
        return departmentDao1.getDepartment1RowCount(assist);
    }
    @Override
    public List<Department1> selectDepartment1(Assist assist){
        return departmentDao1.selectDepartment1(assist);
    }
    @Override
    public Department1 selectDepartment1ByObj(Department1 obj){
        return departmentDao1.selectDepartment1ByObj(obj);
    }
    @Override
    public Department1 selectDepartment1ById(Long id){
        return departmentDao1.selectDepartment1ById(id);
    }
    @Override
    public int insertDepartment1(Department1 value){
        return departmentDao1.insertDepartment1(value);
    }
    @Override
    public int insertNonEmptyDepartment1(Department1 value){
        return departmentDao1.insertNonEmptyDepartment1(value);
    }
    @Override
    public int insertDepartment1ByBatch(List<Department1> value){
        return departmentDao1.insertDepartment1ByBatch(value);
    }
    @Override
    public int deleteDepartment1ById(Long id){
        return departmentDao1.deleteDepartment1ById(id);
    }
    @Override
    public int deleteDepartment1(Assist assist){
        return departmentDao1.deleteDepartment1(assist);
    }
    @Override
    public int updateDepartment1ById(Department1 enti){
        return departmentDao1.updateDepartment1ById(enti);
    }
    @Override
    public int updateDepartment1(Department1 value, Assist assist){
        return departmentDao1.updateDepartment1(value,assist);
    }
    @Override
    public int updateNonEmptyDepartment1ById(Department1 enti){
        return departmentDao1.updateNonEmptyDepartment1ById(enti);
    }
    @Override
    public int updateNonEmptyDepartment1(Department1 value, Assist assist){
        return departmentDao1.updateNonEmptyDepartment1(value,assist);
    }

    public DepartmentDao1 getDepartmentDao1() {
        return this.departmentDao1;
    }

    public void setDepartmentDao1(DepartmentDao1 departmentDao1) {
        this.departmentDao1 = departmentDao1;
    }

}