package org.base.online.service;

import java.util.List;

import org.base.online.entity.TestRecord;
import org.base.system.service.IBaseSpringService;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:27:28
 * @see org.base.online.service.TestRecord
 */
public interface ITestRecordService extends IBaseSpringService {

	/**
	 * 根据ID查找
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TestRecord findTestRecordById(Object id) throws Exception;

	/**
	 * 根据学生id,试卷id,做题状态查找答题记录
	 * 
	 * @param testRecord
	 * @return
	 * @throws Exception
	 */
	TestRecord findTestRecordBySidPidStatus(TestRecord testRecord)
			throws Exception;

	/**
	 * 根据学生 信息查询考试记录
	 * 
	 * @param studentId
	 * @return
	 * @throws Exception
	 */
	List<TestRecord> findTestRecordListBySid(int studentId) throws Exception;

}
