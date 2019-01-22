package com.common;

import com.common.vo.Result;

/**
 * 
* Copyright: Copyright (c) 2017 eaglesoul100
* 
* @ClassName: ResultUtil.java
* @Description: 结果工具类
*
* @version: v1.0.0
* @author: lvyonggang
* @date: 2017年9月30日 上午11:48:10 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2017年9月30日      lvyonggang          v1.0.0             创建
 */
public class ResultUtil {

	/**
	 * 
	* @Function: Result success(Object data)
	* @Description: 成功时使用默认的状态和信息
	*
	* @param:data 要返回的数据对象
	* @return：返回一个成功对象 new Result("OK","success",data)
	*
	* @version: v1.0.0
	* @author: lvyonggang
	* @date: 2017年9月30日 上午11:49:59 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年9月30日     lvyonggang           v1.0.0            创建
	 */
	public static Result success(Object data) {
        return new Result("OK","success",data);
    }
	
	/**
	 * 
	* @Function: Result success(Object data)
	* @Description: 成功时使用默认的状态和信息
	*
	* @param:msg 要返回的信息
	* @return：返回一个成功对象 new Result("OK","success",data)
	*
	* @version: v1.0.0
	* @author: lvyonggang
	* @date: 2017年9月30日 上午11:49:59 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年9月30日     lvyonggang           v1.0.0            创建
	 */
	public static Result success(String msg) {
        return new Result("OK","success",msg);
    }
	
	/**
	 * 
	* @Function: Result success()
	* @Description: 使用默认的成功的信息和信息，用在返回成功时，不用返回的数据的情况下
	*
	* @return：返回一个成功对象 new Result("OK","success",null)
	*
	* @version: v1.0.0
	* @author: lvyonggang
	* @date: 2017年9月30日 上午11:54:19 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年9月30日     lvyonggang           v1.0.0            创建
	 */
	public static Result success() {
        return success(null);
    }

	/**
	 * 
	* @Function: Result error(String code, String msg)
	* @Description: 请求失败时，自定义返回的状态和消息
	*
	* @param:code 自定义的状态码
	* @param msg 自定义的错误消息
	* @return：new Result(code,msg,null);错误结果对象
	*
	* @version: v1.0.0
	* @author: lvyonggang
	* @date: 2017年9月30日 上午11:59:20 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年9月30日     lvyonggang           v1.0.0            创建
	 */
	public static Result error(String code, String msg) {
        return new Result(code,msg,null);
    }

	/**
	 * 
	* @Function: Result error(String msg) 
	* @Description: 请求失败时，使用默认的错误状态码
	*
	* @param: msg 返回的错误消息
	* @return：new Result("ERROR",msg,null); 错误结果对象
	*
	* @version: v1.0.0
	* @author: lvyonggang
	* @date: 2017年9月30日 下午12:05:43 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* 2017年9月30日     lvyonggang           v1.0.0            创建
	 */
	public static Result error(String msg) {
        return error("ERROR", msg);
    }
}
