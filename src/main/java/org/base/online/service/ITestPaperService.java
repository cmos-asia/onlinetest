package org.base.online.service;

import java.util.List;

import org.base.online.entity.TestPaper;
import org.base.system.service.IBaseSpringService;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:27:02
 * @see org.base.online.service.TestPaper
 */
public interface ITestPaperService extends IBaseSpringService {

	/**
	 * 根据ID查找
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TestPaper findTestPaperById(Object id) throws Exception;

	/**
	 * 根据科目ID查找试卷
	 * 
	 * @param subjectsId
	 * @return
	 */
	List<TestPaper> findTestPaperListBySubjects(int subjectsId)
			throws Exception;

}
