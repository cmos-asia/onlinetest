package org.base.online.service;

import java.util.List;

import org.base.online.entity.TopicType;
import org.base.system.service.IBaseSpringService;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:27:59
 * @see org.base.online.service.TopicType
 */
public interface ITopicTypeService extends IBaseSpringService {

	/**
	 * 根据ID查找
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	TopicType findTopicTypeById(Object id) throws Exception;

	/**
	 * 查找所有题型
	 * 
	 * @return
	 * @throws Exception
	 */
	List<TopicType> findAllTopicTypes() throws Exception;

}
