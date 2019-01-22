package com.springboot.activiti.service;

import com.common.Assist;
import com.springboot.activiti.domain.AuditUser;

import java.util.List;

public interface AuditUserService{
	/**
	 * 获得AuditUser数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getAuditUserRowCount(Assist assist);
	/**
	 * 获得AuditUser数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<AuditUser> selectAuditUser(Assist assist);
	/**
	 * 获得一个AuditUser对象,以参数AuditUser对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    AuditUser selectAuditUserByObj(AuditUser obj);
	/**
	 * 通过AuditUser的id获得AuditUser对象
	 * @param id
	 * @return
	 */
    AuditUser selectAuditUserById(Long id);
	/**
	 * 插入AuditUser到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertAuditUser(AuditUser value);
	/**
	 * 插入AuditUser中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyAuditUser(AuditUser value);
	/**
	 * 批量插入AuditUser到数据库
	 * @param value
	 * @return
	 */
    int insertAuditUserByBatch(List<AuditUser> value);
	/**
	 * 通过AuditUser的id删除AuditUser
	 * @param id
	 * @return
	 */
    int deleteAuditUserById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除AuditUser
	 * @param assist
	 * @return
	 */
    int deleteAuditUser(Assist assist);
	/**
	 * 通过AuditUser的id更新AuditUser中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateAuditUserById(AuditUser enti);
 	/**
	 * 通过辅助工具Assist的条件更新AuditUser中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateAuditUser(AuditUser value, Assist assist);
	/**
	 * 通过AuditUser的id更新AuditUser中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyAuditUserById(AuditUser enti);
 	/**
	 * 通过辅助工具Assist的条件更新AuditUser中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyAuditUser(AuditUser value, Assist assist);
}