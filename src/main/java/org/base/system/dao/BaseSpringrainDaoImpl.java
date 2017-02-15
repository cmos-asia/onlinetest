package org.base.system.dao;

import javax.annotation.Resource;

import org.base.frame.dao.BaseJdbcDaoImpl;
import org.base.frame.dao.IBaseJdbcDao;
import org.base.frame.dao.dialect.IDialect;
import org.base.frame.entity.IAuditLog;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *   springrain项目的基础Dao,代理demo数据库
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version  2013-03-19 11:08:15
 * @see org.springrain.system.dao.BaseSpringrainDaoImpl
 */
@Repository("baseSpringrainDao")
public class BaseSpringrainDaoImpl extends BaseJdbcDaoImpl implements IBaseJdbcDao{

	/**
	 * demo  数据库的jdbc,对应 spring配置的 jdbc bean
	 */
	@Resource
	NamedParameterJdbcTemplate jdbc;
	/**
	 * demo  数据库的jdbcCall,对应 spring配置的 jdbcCall bean
	 */
	@Resource
	public SimpleJdbcCall jdbcCall;
    /**
     * mysqlDialect 是mysql的方言,springBean的name,可以参考 IDialect的实现
     */
	@Resource
	public IDialect mysqlDialect;
	@Override
	public IDialect getDialect() {
		return mysqlDialect;
	}

	public BaseSpringrainDaoImpl() {
	}


	/**
	 * 实现父类方法,demo  数据库的jdbc,对应 spring配置的 jdbc bean
	 */
	@Override
	public SimpleJdbcCall getJdbcCall() {
		return this.jdbcCall;
	}
	/**
	 * 实现父类方法,demo  数据库的jdbcCall,对应 spring配置的 jdbcCall bean
	 */
	@Override
	public NamedParameterJdbcTemplate getJdbc() {
		return jdbc;
	}


/**
 * 实现父类方法,返回记录日志的Entity接口实现,reutrn null 则代表不记录日志
 */
	@Override
	public IAuditLog getAuditLog() {
		return null;
		//return new AuditLog();
	}
	
	/**
	 * 是否打印sql语句,默认false
	 * 
	 * @return
	 */
	@Override
	public boolean showsql() {
		return true;
	}


}
