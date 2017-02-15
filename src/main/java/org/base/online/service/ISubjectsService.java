package org.base.online.service;

import org.base.online.entity.Subjects;
import org.base.system.service.IBaseSpringService;
/**
 * TODO 在此加入类描述
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version  2017-02-13 20:26:05
 * @see org.base.online.service.Subjects
 */
public interface ISubjectsService extends IBaseSpringService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Subjects findSubjectsById(Object id) throws Exception;
	
	
	
}
