package org.base.online.service;

import org.base.online.entity.TestRecordInfo;
import org.base.system.service.IBaseSpringService;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:27:47
 * @see org.base.online.service.TestRecordInfo
 */
public interface ITestRecordInfoService extends IBaseSpringService {

	/**
	 * 根据ID查找
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TestRecordInfo findTestRecordInfoById(Object id) throws Exception;

	/**
	 * 根据记录id,试卷id,试提id查询
	 * 
	 * @param testRecordId
	 * @param paperId
	 * @param paperInfoId
	 * @return
	 * @throws Exception
	 */
	TestRecordInfo findTestRecordInfoByPIdSidPaperId(int testRecordId,
			int paperId, int paperInfoId) throws Exception;

}
