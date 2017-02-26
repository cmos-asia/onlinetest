package org.base.online.service.impl;

import java.io.File;
import java.util.List;

import org.base.frame.entity.IBaseEntity;
import org.base.frame.util.ClassUtils;
import org.base.frame.util.Finder;
import org.base.frame.util.Page;
import org.base.online.entity.TestRecord;
import org.base.online.service.ITestRecordService;
import org.base.system.service.BaseSpringServiceImpl;
import org.springframework.stereotype.Service;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:27:28
 * @see org.base.online.service.impl.TestRecord
 */
@Service("testRecordService")
public class TestRecordServiceImpl extends BaseSpringServiceImpl implements
		ITestRecordService {

	@Override
	public String save(Object entity) throws Exception {
		TestRecord testRecord = (TestRecord) entity;
		return super.save(testRecord).toString();
	}

	@Override
	public String saveorupdate(Object entity) throws Exception {
		TestRecord testRecord = (TestRecord) entity;
		return super.saveorupdate(testRecord).toString();
	}

	@Override
	public Integer update(IBaseEntity entity) throws Exception {
		TestRecord testRecord = (TestRecord) entity;
		return super.update(testRecord);
	}

	@Override
	public TestRecord findTestRecordById(Object id) throws Exception {
		return super.findById(id, TestRecord.class);
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
	public TestRecord findTestRecordBySidPidStatus(TestRecord testRecord)
			throws Exception {
		Finder finder = new Finder();
		finder.append("select * from "
				+ ClassUtils.getTableNameByClass(TestRecord.class));
		finder.append(" where student_id=" + testRecord.getStudent_id());
		finder.append(" and paper_id=" + testRecord.getPaper_id());
		finder.append(" and status=" + testRecord.getStatus());
		return super.queryForObject(finder, TestRecord.class);
	}

	@Override
	public List<TestRecord> findTestRecordListBySid(int studentId)
			throws Exception {
		Page page = new Page();
		page.setSort("desc");
		page.setOrder("id");
		Finder finder = new Finder();
		finder.append("select * from "
				+ ClassUtils.getTableNameByClass(TestRecord.class));
		finder.append(" where student_id=" + studentId);
		finder.append(" and (status !=2)");
		return super.findListDataByFinder(finder, page, TestRecord.class, null);
	}

}
