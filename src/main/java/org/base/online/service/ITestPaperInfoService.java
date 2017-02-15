package org.base.online.service;

import org.base.online.entity.TestPaperInfo;
import org.base.system.service.IBaseSpringService;
/**
 * TODO 在此加入类描述
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version  2017-02-13 20:27:14
 * @see org.base.online.service.TestPaperInfo
 */
public interface ITestPaperInfoService extends IBaseSpringService {
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TestPaperInfo findTestPaperInfoById(Object id) throws Exception;
	
	
	
}
