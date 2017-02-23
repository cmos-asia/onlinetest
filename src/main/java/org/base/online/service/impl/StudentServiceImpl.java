package org.base.online.service.impl;

import java.io.File;
import java.util.List;

import org.base.frame.entity.IBaseEntity;
import org.base.frame.util.ClassUtils;
import org.base.frame.util.Finder;
import org.base.frame.util.Page;
import org.base.online.entity.Student;
import org.base.online.service.IStudentService;
import org.base.system.service.BaseSpringServiceImpl;
import org.springframework.stereotype.Service;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:26:48
 * @see org.base.online.service.impl.Student
 */
@Service("studentService")
public class StudentServiceImpl extends BaseSpringServiceImpl implements
		IStudentService {

	@Override
	public String save(Object entity) throws Exception {
		Student student = (Student) entity;
		return super.save(student).toString();
	}

	@Override
	public String saveorupdate(Object entity) throws Exception {
		Student student = (Student) entity;
		return super.saveorupdate(student).toString();
	}

	@Override
	public Integer update(IBaseEntity entity) throws Exception {
		Student student = (Student) entity;
		return super.update(student);
	}

	@Override
	public Student findStudentById(Object id) throws Exception {
		return super.findById(id, Student.class);
	}

	/**
	 * 列表查询,每个service都会重载,要把sql语句封装到service中,Finder只是最后的方案
	 * 
	 * @param finder
	 * @param page
	 * @param clazz
	 * @param o
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> List<T> findListDataByFinder(Finder finder, Page page,
			Class<T> clazz, Object o) throws Exception {
		return super.findListDataByFinder(finder, page, clazz, o);
	}

	/**
	 * 根据查询列表的宏,导出Excel
	 * 
	 * @param finder
	 *            为空则只查询 clazz表
	 * @param ftlurl
	 *            类表的模版宏
	 * @param page
	 *            分页对象
	 * @param clazz
	 *            要查询的对象
	 * @param o
	 *            querybean
	 * @return
	 * @throws Exception
	 */
	@Override
	public <T> File findDataExportExcel(Finder finder, String ftlurl,
			Page page, Class<T> clazz, Object o) throws Exception {
		return super.findDataExportExcel(finder, ftlurl, page, clazz, o);
	}

	@Override
	public List<Student> findStudentByPhone(String phone) throws Exception {
		Finder finder = new Finder();
		finder.append("select * from "
				+ ClassUtils.getTableNameByClass(Student.class));
		finder.append(" where phone=" + phone);
		return super.findListDataByFinder(finder, null, Student.class, null);
	}
}
