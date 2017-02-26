package org.base.online.service.impl;

import java.io.File;
import java.util.List;

import org.base.frame.entity.IBaseEntity;
import org.base.frame.util.ClassUtils;
import org.base.frame.util.Finder;
import org.base.frame.util.Page;
import org.base.online.entity.TestRecordInfo;
import org.base.online.service.ITestRecordInfoService;
import org.base.system.service.BaseSpringServiceImpl;
import org.springframework.stereotype.Service;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:27:47
 * @see org.base.online.service.impl.TestRecordInfo
 */
@Service("testRecordInfoService")
public class TestRecordInfoServiceImpl extends BaseSpringServiceImpl implements
		ITestRecordInfoService {

	@Override
	public String save(Object entity) throws Exception {
		TestRecordInfo testRecordInfo = (TestRecordInfo) entity;
		return super.save(testRecordInfo).toString();
	}

	@Override
	public String saveorupdate(Object entity) throws Exception {
		TestRecordInfo testRecordInfo = (TestRecordInfo) entity;
		return super.saveorupdate(testRecordInfo).toString();
	}

	@Override
	public Integer update(IBaseEntity entity) throws Exception {
		TestRecordInfo testRecordInfo = (TestRecordInfo) entity;
		return super.update(testRecordInfo);
	}

	@Override
	public TestRecordInfo findTestRecordInfoById(Object id) throws Exception {
		return super.findById(id, TestRecordInfo.class);
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
	public TestRecordInfo findTestRecordInfoByPIdSidPaperId(int testRecordId,
			int paperId, int paperInfoId) throws Exception {
		Finder finder = new Finder();
		finder.append("select * from "
				+ ClassUtils.getTableNameByClass(TestRecordInfo.class));
		finder.append(" where record_id=" + testRecordId);
		finder.append(" and paper_id=" + paperId);
		finder.append(" and paper_info_id=" + paperInfoId);
		return super.queryForObject(finder, TestRecordInfo.class);
	}

}
