package com.springboot.activiti.dao;

import com.common.Assist;
import com.springboot.activiti.domain.LeaveInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LeaveInfoDao{
	/**
	 * 获得LeaveInfo数据的总行数,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    long getLeaveInfoRowCount(Assist assist);
	/**
	 * 获得LeaveInfo数据集合,可以通过辅助工具Assist进行条件查询,如果没有条件则传入null
	 * @param assist
	 * @return
	 */
    List<LeaveInfo> selectLeaveInfo(Assist assist);
	/**
	 * 获得一个LeaveInfo对象,以参数LeaveInfo对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    LeaveInfo selectLeaveInfoByObj(LeaveInfo obj);
	/**
	 * 通过LeaveInfo的id获得LeaveInfo对象
	 * @param id
	 * @return
	 */
    LeaveInfo selectLeaveInfoById(Long id);
	/**
	 * 插入LeaveInfo到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertLeaveInfo(LeaveInfo value);
	/**
	 * 插入LeaveInfo中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyLeaveInfo(LeaveInfo value);
	/**
	 * 批量插入LeaveInfo到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertLeaveInfoByBatch(List<LeaveInfo> value);
	/**
	 * 通过LeaveInfo的id删除LeaveInfo
	 * @param id
	 * @return
	 */
    int deleteLeaveInfoById(Long id);
	/**
	 * 通过辅助工具Assist的条件删除LeaveInfo
	 * @param assist
	 * @return
	 */
    int deleteLeaveInfo(Assist assist);
	/**
	 * 通过LeaveInfo的id更新LeaveInfo中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateLeaveInfoById(LeaveInfo enti);
 	/**
	 * 通过辅助工具Assist的条件更新LeaveInfo中的数据,包括null值
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateLeaveInfo(@Param("enti") LeaveInfo value, @Param("assist") Assist assist);
	/**
	 * 通过LeaveInfo的id更新LeaveInfo中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyLeaveInfoById(LeaveInfo enti);
 	/**
	 * 通过辅助工具Assist的条件更新LeaveInfo中属性不为null的数据
	 * @param value
	 * @param assist
	 * @return
	 */
    int updateNonEmptyLeaveInfo(@Param("enti") LeaveInfo value, @Param("assist") Assist assist);
}
