package org.base.online.web;

import java.io.File;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.base.frame.controller.BaseController;
import org.base.frame.util.GlobalStatic;
import org.base.frame.util.MessageUtils;
import org.base.frame.util.Page;
import org.base.frame.util.ReturnDatas;
import org.base.online.entity.Subjects;
import org.base.online.entity.TestPaper;
import org.base.online.entity.TestPaperInfo;
import org.base.online.entity.TopicType;
import org.base.online.service.ISubjectsService;
import org.base.online.service.ITestPaperInfoService;
import org.base.online.service.ITestPaperService;
import org.base.online.service.ITopicTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:27:14
 * @see org.base.online.web.TestPaperInfo
 */
@Controller
@RequestMapping(value = "/testpaperinfo")
public class TestPaperInfoController extends BaseController {
	@Resource
	private ITestPaperInfoService testPaperInfoService;
	@Resource
	private ITestPaperService testPaperService;
	@Resource
	private ISubjectsService subjectsService;
	@Resource
	private ITopicTypeService topicTypeService;

	private String listurl = "/online/testpaperinfo/testpaperinfoList";

	/**
	 * 列表数据,调用listjson方法,保证和app端数据统一
	 * 
	 * @param request
	 * @param model
	 * @param testPaperInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model,
			TestPaperInfo testPaperInfo) throws Exception {
		ReturnDatas returnObject = listjson(request, model, testPaperInfo);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return listurl;
	}

	/**
	 * json数据,为APP提供数据
	 * 
	 * @param request
	 * @param model
	 * @param testPaperInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/json")
	public @ResponseBody ReturnDatas listjson(HttpServletRequest request,
			Model model, TestPaperInfo testPaperInfo) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		// ==构造分页请求
		Page page = newPage(request);
		page.setSort("asc");
		page.setOrder("id");
		// ==执行分页查询
		List<TestPaperInfo> datas = testPaperInfoService.findListDataByFinder(
				null, page, TestPaperInfo.class, testPaperInfo);

		if (testPaperInfo.getPaper_id() >= 0) {

			// 试卷信息查询
			TestPaper testPaper = testPaperService.findById(
					testPaperInfo.getPaper_id(), TestPaper.class);
			if (testPaper != null) {

				// 科目信息查询
				Subjects subject = subjectsService.findById(
						NumberUtils.toInt(
								String.valueOf(testPaper.getSubjects()), -1),
						Subjects.class);

				if (subject != null) {
					testPaper.setSubjectsName(subject.getName());
				}
				returnObject.setOtherData(testPaper);
			}
		}

		if (CollectionUtils.isNotEmpty(datas)) {
			for (TestPaperInfo info : datas) {
				TopicType topicType = topicTypeService.findById(
						info.getTopic_type(), TopicType.class);
				if (topicType != null) {
					info.setTopicTypeName(topicType.getName());
				}
			}
		}

		returnObject.setQueryBean(testPaperInfo);
		returnObject.setPage(page);
		returnObject.setData(datas);
		return returnObject;
	}

	@RequestMapping("/list/export")
	public void listexport(HttpServletRequest request,
			HttpServletResponse response, Model model,
			TestPaperInfo testPaperInfo) throws Exception {
		// ==构造分页请求
		Page page = newPage(request);

		File file = testPaperInfoService.findDataExportExcel(null, listurl,
				page, TestPaperInfo.class, testPaperInfo);
		String fileName = "testPaperInfo" + GlobalStatic.excelext;
		downFile(response, file, fileName, true);
		return;
	}

	/**
	 * 查看操作,调用APP端lookjson方法
	 */
	@RequestMapping(value = "/look")
	public String look(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/online/testpaperinfo/testpaperinfoLook";
	}

	/**
	 * 查看的Json格式数据,为APP端提供数据
	 */
	@RequestMapping(value = "/look/json")
	public @ResponseBody ReturnDatas lookjson(Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		String strId = request.getParameter("id");
		java.lang.Integer id = null;
		TestPaperInfo testPaperInfo = new TestPaperInfo();
		if (StringUtils.isNotBlank(strId)) {
			id = java.lang.Integer.valueOf(strId.trim());
			testPaperInfo = testPaperInfoService.findTestPaperInfoById(id);
		} else {
			int paper_id = NumberUtils.toInt(request.getParameter("paper_id"),
					0);
			testPaperInfo.setPaper_id(paper_id);
			returnObject.setStatus(ReturnDatas.ERROR);
		}
		List<TopicType> topicTypeList = topicTypeService.findAllTopicTypes();
		returnObject.setData(testPaperInfo);
		returnObject.setOtherData(topicTypeList);
		return returnObject;

	}

	/**
	 * 新增/修改 操作吗,返回json格式数据
	 * 
	 */
	@RequestMapping("/update")
	public @ResponseBody ReturnDatas saveorupdate(Model model,
			TestPaperInfo testPaperInfo, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		returnObject.setMessage(MessageUtils.UPDATE_SUCCESS);
		try {
			String options = testPaperInfo.getOptions();
			options = URLEncoder.encode(options);
			int paperInfoId = NumberUtils.toInt(
					String.valueOf(testPaperInfo.getId()), -1);

			testPaperInfo.setCreate_time(new Date());
			if (paperInfoId != -1) {
				TestPaperInfo oldInfo = testPaperInfoService.findById(
						paperInfoId, TestPaperInfo.class);
				if (oldInfo.getCreate_time() != null) {
					testPaperInfo.setCreate_time(oldInfo.getCreate_time());
				}
			}
			testPaperInfo.setUpdate_time(new Date());
			testPaperInfoService.saveorupdate(testPaperInfo);
		} catch (Exception e) {
			String errorMessage = e.getLocalizedMessage();
			logger.error(errorMessage);
			returnObject.setStatus(ReturnDatas.ERROR);
			returnObject.setMessage(MessageUtils.UPDATE_ERROR);
		}
		return returnObject;

	}

	/**
	 * 进入修改页面,APP端可以调用 lookjson 获取json格式数据
	 */
	@RequestMapping(value = "/update/pre")
	public String updatepre(Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = lookjson(model, request, response);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return "/online/testpaperinfo/testpaperinfoCru";
	}

	/**
	 * 删除操作
	 */
	@RequestMapping(value = "/delete")
	public @ResponseBody ReturnDatas delete(HttpServletRequest request)
			throws Exception {

		// 执行删除
		try {
			String strId = request.getParameter("id");
			java.lang.Integer id = null;
			if (StringUtils.isNotBlank(strId)) {
				id = java.lang.Integer.valueOf(strId.trim());
				testPaperInfoService.deleteById(id, TestPaperInfo.class);
				return new ReturnDatas(ReturnDatas.SUCCESS,
						MessageUtils.DELETE_SUCCESS);
			} else {
				return new ReturnDatas(ReturnDatas.WARNING,
						MessageUtils.DELETE_WARNING);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new ReturnDatas(ReturnDatas.WARNING, MessageUtils.DELETE_WARNING);
	}

	/**
	 * 删除多条记录
	 * 
	 */
	@RequestMapping("/delete/more")
	public @ResponseBody ReturnDatas deleteMore(HttpServletRequest request,
			Model model) {
		String records = request.getParameter("records");
		if (StringUtils.isBlank(records)) {
			return new ReturnDatas(ReturnDatas.ERROR,
					MessageUtils.DELETE_ALL_FAIL);
		}
		String[] rs = records.split(",");
		if (rs == null || rs.length < 1) {
			return new ReturnDatas(ReturnDatas.ERROR,
					MessageUtils.DELETE_NULL_FAIL);
		}
		try {
			List<String> ids = Arrays.asList(rs);
			testPaperInfoService.deleteByIds(ids, TestPaperInfo.class);
		} catch (Exception e) {
			return new ReturnDatas(ReturnDatas.ERROR,
					MessageUtils.DELETE_ALL_FAIL);
		}
		return new ReturnDatas(ReturnDatas.SUCCESS,
				MessageUtils.DELETE_ALL_SUCCESS);

	}

}
