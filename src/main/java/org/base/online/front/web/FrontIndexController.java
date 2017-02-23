package org.base.online.front.web;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.util.WebUtils;
import org.base.frame.util.GlobalStatic;
import org.base.frame.util.MessageUtils;
import org.base.frame.util.ReturnDatas;
import org.base.frame.util.SecUtils;
import org.base.online.entity.Student;
import org.base.online.service.IStudentService;
import org.base.system.entity.User;
import org.base.system.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * APP首页Controller,前台
 * 
 */
@Controller
@RequestMapping("/front")
public class FrontIndexController extends FrontBaseController {
	@Resource
	private IUserService userService;
	@Resource
	private IStudentService studentService;

	// 首页页面路径
	private static String index_url = "/online/front/index";
	// 注册页面路径
	private static String register_url = "/online/front/register";
	// 登录页面路径
	private static String login_url = "/online/front/login";
	private static String salaryDetail_url = "/enterprise/front/salaryDetail_list";

	/**
	 * 首页的映射
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/")
	public String index() throws Exception {
		return super.redirect + "/index";
	}

	/**
	 * 首页跳转
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/index")
	public String index(Model model, HttpServletRequest request,
			HttpSession session, HttpServletResponse response, User user)
			throws Exception {
		String ctx = request.getParameter("ctx");
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		model.addAttribute("siteName", "我是中文站点");
		model.addAttribute("ctx", ctx);
		Student s = (Student) session.getAttribute("login_student");
		returnObject.setData(s);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return index_url;
	}

	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpServletRequest request,
			HttpSession session, HttpServletResponse response, User user)
			throws Exception {
		String ctx = request.getParameter("ctx");
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		model.addAttribute("siteName", "我是中文站点");
		model.addAttribute("ctx", ctx);
		session.removeAttribute("login_student");
		Student s = (Student) session.getAttribute("login_student");
		returnObject.setData(s);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return index_url;
	}

	/**
	 * 注册页面跳转
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/register")
	public String register(Model model, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String ctx = request.getParameter("ctx");
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		model.addAttribute("siteName", "我是中文站点");
		model.addAttribute("ctx", ctx);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return register_url;
	}

	/**
	 * 登录页面跳转
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/login")
	public String login(Model model, HttpServletRequest request,
			HttpServletResponse response, User user) throws Exception {
		String ctx = request.getParameter("ctx");
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		model.addAttribute("siteName", "我是中文站点");
		model.addAttribute("ctx", ctx);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return login_url;
	}

	/**
	 * 学生前台注册
	 * 
	 * @param model
	 * @param student
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/student/register")
	public @ResponseBody ReturnDatas studentRegister(Model model,
			HttpSession session, Student student, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getErrorReturnDatas();
		try {

			// 系统产生的验证码
			String code = (String) session
					.getAttribute(GlobalStatic.DEFAULT_CAPTCHA_PARAM);
			if (StringUtils.isNotBlank(code)) {
				code = code.toLowerCase().toString();
			}
			// 用户产生的验证码
			String submitCode = WebUtils.getCleanParam(request,
					GlobalStatic.DEFAULT_CAPTCHA_PARAM);
			if (StringUtils.isNotBlank(submitCode)) {
				submitCode = submitCode.toLowerCase().toString();
			}
			// 如果验证码不匹配,跳转到登录
			if (StringUtils.isBlank(submitCode) || StringUtils.isBlank(code)
					|| !code.equals(submitCode)) {
				returnObject.setMessage("验证码错误");
				returnObject.setStatus(ReturnDatas.WARNING);
				return returnObject;
			}

			// 手机号
			String phone = student.getPhone();

			// 密码（明文）
			String password = student.getPassword();
			if (StringUtils.isBlank(phone)) {
				returnObject.setMessage("手机号为空");
				return returnObject;
			}

			if (StringUtils.isBlank(password)) {
				returnObject.setMessage("密码为空");
				return returnObject;
			}

			if (!isMobileNO(phone)) {
				returnObject.setMessage("手机号格式不正确");
				return returnObject;
			}

			// 根据手机号查询已有学生信息，避免手机号重复
			List<Student> studentList = studentService
					.findStudentByPhone(phone);
			if (CollectionUtils.isNotEmpty(studentList)) {
				returnObject.setMessage("该手机号[" + phone + "]已注册，请直接登录");
				return returnObject;
			}

			// 密码进行md5加密
			student.setPassword(SecUtils.encoderByMd5With32Bit(password));
			student.setCreate_time(new Date());
			student.setUpdate_time(new Date());
			returnObject.setMessage(MessageUtils.ADD_SUCCESS);
			student.setUpdate_time(new Date());
			studentService.saveorupdate(student);
			returnObject.setStatus(ReturnDatas.SUCCESS);
		} catch (Exception e) {
			String errorMessage = e.getLocalizedMessage();
			logger.error(errorMessage);
			returnObject.setStatus(ReturnDatas.ERROR);
			returnObject.setMessage(MessageUtils.UPDATE_ERROR);
		}
		return returnObject;

	}

	@RequestMapping("/student/login")
	public @ResponseBody ReturnDatas studentLogin(Model model,
			HttpSession session, Student student, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getErrorReturnDatas();
		try {

			// 手机号
			String phone = student.getPhone();

			// 密码（明文）
			String password = student.getPassword();
			if (StringUtils.isBlank(phone)) {
				returnObject.setMessage("手机号为空");
				return returnObject;
			}

			if (StringUtils.isBlank(password)) {
				returnObject.setMessage("密码为空");
				return returnObject;
			}

			if (!isMobileNO(phone)) {
				returnObject.setMessage("手机号格式不正确");
				return returnObject;
			}

			// 根据手机号查询已有学生信息，避免手机号重复
			List<Student> studentList = studentService
					.findStudentByPhone(phone);
			if (CollectionUtils.isEmpty(studentList)) {
				returnObject.setMessage("该手机号[" + phone + "]尚未注册，请前往快速注册页面注册");
				return returnObject;
			}

			Student s = studentList.get(0);
			String passMd5 = SecUtils.encoderByMd5With32Bit(password);
			if (!passMd5.equalsIgnoreCase(s.getPassword())) {
				returnObject.setMessage("密码错误，请重新输入");
				return returnObject;
			}
			session.setAttribute("login_student", s);
			returnObject.setStatus(ReturnDatas.SUCCESS);
		} catch (Exception e) {
			String errorMessage = e.getLocalizedMessage();
			logger.error(errorMessage);
			returnObject.setStatus(ReturnDatas.ERROR);
			returnObject.setMessage(MessageUtils.UPDATE_ERROR);
		}
		return returnObject;

	}

	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
}
