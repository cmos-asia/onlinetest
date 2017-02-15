package org.base.system.service;

import org.base.system.entity.AuditLog;

/**
 * TODO 在此加入类描述
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version  2013-04-02 10:17:31
 * @see org.springrain.springrain.service.AuditLog
 */
public interface IAuditlogService extends IBaseSpringService {
	String saveAuditlog(AuditLog entity) throws Exception;
    String saveorupdateAuditlog(AuditLog entity) throws Exception;
	Integer updateAuditlog(AuditLog entity) throws Exception;
	AuditLog findAuditlogById(Object id) throws Exception;
	
}
