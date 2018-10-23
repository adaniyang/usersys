package com.springboot.usersys.service;
import java.util.List;
import com.springboot.usersys.pojo.Department1;
import com.common.Assist;
public interface DepartmentService1{
	/**
	 * 获得Department1数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getDepartment1RowCount(Assist assist);
	/**
	 * 获得Department1数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<Department1> selectDepartment1(Assist assist);
	/**
	 * 获得一个Department1对象,以参数Department1对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    Department1 selectDepartment1ByObj(Department1 obj);
	/**
	 * 通过Department1的id获得Department1对象
	 * @param id
	 * @return
	 */
    Department1 selectDepartment1ById(Long id);
	/**
	 * 插入Department1到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertDepartment1(Department1 value);
	/**
	 * 插入Department1中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyDepartment1(Department1 value);
	/**
	 * 批量插入Department1到数据库
	 * @param value
	 * @return
	 */
    int insertDepartment1ByBatch(List<Department1> value);
	/**
	 * 通过Department1的id删除Department1
	 * @param id
	 * @return
	 */
    int deleteDepartment1ById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除Department1
	 * @param assist
	 * @return
	 */
    int deleteDepartment1(Assist assist);
	/**
	 * 通过Department1的id更新Department1中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateDepartment1ById(Department1 enti);
 	/**
	 * 通过辅助工具Assist的条件更新Department1中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateDepartment1(Department1 value,  Assist assist);
	/**
	 * 通过Department1的id更新Department1中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyDepartment1ById(Department1 enti);
 	/**
	 * 通过辅助工具Assist的条件更新Department1中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyDepartment1(Department1 value, Assist assist);
}