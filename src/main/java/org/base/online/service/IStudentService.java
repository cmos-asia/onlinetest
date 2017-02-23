package org.base.online.service;

import java.util.List;

import org.base.online.entity.Student;
import org.base.system.service.IBaseSpringService;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:26:48
 * @see org.base.online.service.Student
 */
public interface IStudentService extends IBaseSpringService {

	/**
	 * 根据ID查找
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Student findStudentById(Object id) throws Exception;

	/**
	 * 根据手机号查找学生
	 * 
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	List<Student> findStudentByPhone(String phone) throws Exception;

}
