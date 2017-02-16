package org.base.online.web;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.base.frame.controller.BaseController;
import org.base.frame.util.GlobalStatic;
import org.base.frame.util.MessageUtils;
import org.base.frame.util.Page;
import org.base.frame.util.ReturnDatas;
import org.base.online.entity.Subjects;
import org.base.online.service.ISubjectsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO 在此加入类描述
 * 
 * @copyright {@link 9iu.org}
 * @author springrain<Auto generate>
 * @version 2017-02-13 20:26:05
 * @see org.base.online.web.Subjects
 */
@Controller
@RequestMapping(value = "/subjects")
public class SubjectsController extends BaseController {
	@Resource
	private ISubjectsService subjectsService;

	private String listurl = "/online/subjects/subjectsList";

	/**
	 * 列表数据,调用listjson方法,保证和app端数据统一
	 * 
	 * @param request
	 * @param model
	 * @param subjects
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model,
			Subjects subjects) throws Exception {
		ReturnDatas returnObject = listjson(request, model, subjects);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return listurl;
	}

	/**
	 * json数据,为APP提供数据
	 * 
	 * @param request
	 * @param model
	 * @param subjects
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/json")
	public @ResponseBody ReturnDatas listjson(HttpServletRequest request,
			Model model, Subjects subjects) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		// ==构造分页请求
		Page page = newPage(request);
		// ==执行分页查询
		List<Subjects> datas = subjectsService.findListDataByFinder(null, page,
				Subjects.class, subjects);
		returnObject.setQueryBean(subjects);
		returnObject.setPage(page);
		returnObject.setData(datas);
		return returnObject;
	}

	@RequestMapping("/list/export")
	public void listexport(HttpServletRequest request,
			HttpServletResponse response, Model model, Subjects subjects)
			throws Exception {
		// ==构造分页请求
		Page page = newPage(request);

		File file = subjectsService.findDataExportExcel(null, listurl, page,
				Subjects.class, subjects);
		String fileName = "subjects" + GlobalStatic.excelext;
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
		return "/online/subjects/subjectsLook";
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
		if (StringUtils.isNotBlank(strId)) {
			id = java.lang.Integer.valueOf(strId.trim());
			Subjects subjects = subjectsService.findSubjectsById(id);
			returnObject.setData(subjects);
		} else {
			returnObject.setStatus(ReturnDatas.ERROR);
		}
		return returnObject;

	}

	/**
	 * 新增/修改 操作吗,返回json格式数据
	 * 
	 */
	@RequestMapping("/update")
	public @ResponseBody ReturnDatas saveorupdate(Model model,
			Subjects subjects, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		returnObject.setMessage(MessageUtils.UPDATE_SUCCESS);
		try {

			// 新科目无id
			int subId = NumberUtils.toInt(String.valueOf(subjects.getId()), -1);
			if (subId == -1) {
				returnObject.setMessage(MessageUtils.ADD_SUCCESS);
				subjects.setCreate_time(new Date());
			} else {
				Subjects oldSubjects = subjectsService.findById(
						subjects.getId(), Subjects.class);
				subjects.setCreate_time(oldSubjects.getCreate_time());
			}
			subjects.setUpdate_time(new Date());
			subjectsService.saveorupdate(subjects);
			logger.info("subjects add or update, subjects=[{}]", subjects);
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
		return "/online/subjects/subjectsCru";
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
				subjectsService.deleteById(id, Subjects.class);
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
			subjectsService.deleteByIds(ids, Subjects.class);
		} catch (Exception e) {
			return new ReturnDatas(ReturnDatas.ERROR,
					MessageUtils.DELETE_ALL_FAIL);
		}
		return new ReturnDatas(ReturnDatas.SUCCESS,
				MessageUtils.DELETE_ALL_SUCCESS);

	}

}
