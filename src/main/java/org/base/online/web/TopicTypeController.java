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
import org.base.online.entity.TopicType;
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
 * @version 2017-02-13 20:27:59
 * @see org.base.online.web.TopicType
 */
@Controller
@RequestMapping(value = "/topictype")
public class TopicTypeController extends BaseController {
	@Resource
	private ITopicTypeService topicTypeService;

	private String listurl = "/online/topictype/topictypeList";

	/**
	 * 列表数据,调用listjson方法,保证和app端数据统一
	 * 
	 * @param request
	 * @param model
	 * @param topicType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model,
			TopicType topicType) throws Exception {
		ReturnDatas returnObject = listjson(request, model, topicType);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return listurl;
	}

	/**
	 * json数据,为APP提供数据
	 * 
	 * @param request
	 * @param model
	 * @param topicType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list/json")
	public @ResponseBody ReturnDatas listjson(HttpServletRequest request,
			Model model, TopicType topicType) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		// ==构造分页请求
		Page page = newPage(request);
		// ==执行分页查询
		List<TopicType> datas = topicTypeService.findListDataByFinder(null,
				page, TopicType.class, topicType);
		returnObject.setQueryBean(topicType);
		returnObject.setPage(page);
		returnObject.setData(datas);
		return returnObject;
	}

	@RequestMapping("/list/export")
	public void listexport(HttpServletRequest request,
			HttpServletResponse response, Model model, TopicType topicType)
			throws Exception {
		// ==构造分页请求
		Page page = newPage(request);

		File file = topicTypeService.findDataExportExcel(null, listurl, page,
				TopicType.class, topicType);
		String fileName = "topicType" + GlobalStatic.excelext;
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
		return "/online/topictype/topictypeLook";
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
			TopicType topicType = topicTypeService.findTopicTypeById(id);
			returnObject.setData(topicType);
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
			TopicType topicType, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		returnObject.setMessage(MessageUtils.UPDATE_SUCCESS);
		try {
			int subId = NumberUtils
					.toInt(String.valueOf(topicType.getId()), -1);
			if (subId == -1) {
				returnObject.setMessage(MessageUtils.ADD_SUCCESS);
				topicType.setCreate_time(new Date());
			} else {
				TopicType oldTopicType = topicTypeService.findById(
						topicType.getId(), TopicType.class);
				topicType.setCreate_time(oldTopicType.getCreate_time());
			}
			topicType.setUpdate_time(new Date());
			topicTypeService.saveorupdate(topicType);

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
		return "/online/topictype/topictypeCru";
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
				topicTypeService.deleteById(id, TopicType.class);
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
			topicTypeService.deleteByIds(ids, TopicType.class);
		} catch (Exception e) {
			return new ReturnDatas(ReturnDatas.ERROR,
					MessageUtils.DELETE_ALL_FAIL);
		}
		return new ReturnDatas(ReturnDatas.SUCCESS,
				MessageUtils.DELETE_ALL_SUCCESS);

	}

}
