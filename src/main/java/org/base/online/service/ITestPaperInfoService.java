package org.base.online.service;

import java.util.List;

import org.base.online.entity.TestPaperInfo;
import org.base.system.service.IBaseSpringService;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:27:14
 * @see org.base.online.service.TestPaperInfo
 */
public interface ITestPaperInfoService extends IBaseSpringService {

	/**
	 * 根据ID查找
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TestPaperInfo findTestPaperInfoById(Object id) throws Exception;

	/**
	 * 根据试卷id查找试卷信息
	 * 
	 * @param paperId
	 * @return
	 * @throws Exception
	 */
	List<TestPaperInfo> findTestPaperInfoByPaperId(int paperId)
			throws Exception;

}
