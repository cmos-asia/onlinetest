package org.base.online.front.web;

import java.util.ArrayList;
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
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shiro.web.util.WebUtils;
import org.base.frame.util.GlobalStatic;
import org.base.frame.util.MessageUtils;
import org.base.frame.util.ReturnDatas;
import org.base.frame.util.SecUtils;
import org.base.online.entity.PaperAnswer;
import org.base.online.entity.PaperAnswerList;
import org.base.online.entity.PaperOptions;
import org.base.online.entity.Student;
import org.base.online.entity.Subjects;
import org.base.online.entity.TestPaper;
import org.base.online.entity.TestPaperInfo;
import org.base.online.entity.TestRecord;
import org.base.online.entity.TestRecordInfo;
import org.base.online.entity.TopicType;
import org.base.online.service.IStudentService;
import org.base.online.service.ISubjectsService;
import org.base.online.service.ITestPaperInfoService;
import org.base.online.service.ITestPaperService;
import org.base.online.service.ITestRecordInfoService;
import org.base.online.service.ITestRecordService;
import org.base.online.service.ITopicTypeService;
import org.base.system.entity.User;
import org.base.system.enumeration.Enumerations;
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
	@Resource
	private ISubjectsService subjectsService;
	@Resource
	private ITestPaperService testPaperService;
	@Resource
	private ITestPaperInfoService testPaperInfoService;
	@Resource
	private ITopicTypeService topicTypeService;
	@Resource
	private ITestRecordService testRecordService;
	@Resource
	private ITestRecordInfoService testRecordInfoService;

	// 首页页面路径
	private static String index_url = "/online/front/index";
	// 注册页面路径
	private static String register_url = "/online/front/register";
	// 登录页面路径
	private static String login_url = "/online/front/login";
	// 账户安全/个人资料页面
	private static String account_url = "/online/front/account";
	// 答题记录列表页面
	private static String recordList_url = "/online/front/recordList";
	// 试题页面
	private static String testPaper_url = "/online/front/testPaper";
	// 试题列表页面
	private static String testPaperList_url = "/online/front/testPaperList";
	private static String result_url = "/online/front/result";

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
		if (s != null) {
			List<Subjects> subjectsList = subjectsService.findActiveSubjects();
			returnObject.setOtherData(subjectsList);
		}
		returnObject.setData(s);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return index_url;
	}

	/**
	 * 我的资料、学生信息页面
	 * 
	 * @param model
	 * @param request
	 * @param session
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/account")
	public String userInfo(Model model, HttpServletRequest request,
			HttpSession session, HttpServletResponse response, User user)
			throws Exception {
		String ctx = request.getParameter("ctx");
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		model.addAttribute("siteName", "我是中文站点");
		model.addAttribute("ctx", ctx);
		Student s = (Student) session.getAttribute("login_student");
		returnObject.setData(s);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return account_url;
	}

	/**
	 * 答题页面
	 * 
	 * @param model
	 * @param request
	 * @param session
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/testPaper")
	public String question(Model model, HttpServletRequest request,
			HttpSession session, HttpServletResponse response, User user)
			throws Exception {
		String ctx = request.getParameter("ctx");
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		model.addAttribute("siteName", "我是中文站点");
		model.addAttribute("ctx", ctx);

		// 试卷id
		int id = NumberUtils.toInt(String.valueOf(request.getParameter("id")),
				0);

		// 试卷
		TestPaper testPaper = testPaperService.findById(id, TestPaper.class);

		Student s = (Student) session.getAttribute("login_student");
		returnObject.setData(s);

		// 未登录，直接返回
		if (s == null) {
			model.addAttribute(GlobalStatic.returnDatas, returnObject);
			return testPaper_url;
		}

		// 试题信息
		if (testPaper == null) {
			model.addAttribute(GlobalStatic.returnDatas, returnObject);
			return testPaper_url;
		}
		Subjects subjects = subjectsService.findSubjectsById(testPaper
				.getSubjects());
		if (subjects != null) {
			testPaper.setSubjectsName(subjects.getName());
		}

		returnObject.setOtherData(testPaper);

		// 根据试卷id查找试题详情
		List<TestPaperInfo> paperInfoRtn = getTestPaperInfoListByPaperId(testPaper
				.getId());
		if (CollectionUtils.isEmpty(paperInfoRtn)) {
			model.addAttribute(GlobalStatic.returnDatas, returnObject);
			return testPaper_url;
		}

		testPaper.setTestPaperInfoList(paperInfoRtn);
		// 服务器当前时间
		Date serverNowTime = new Date();
		// 考试结束时间
		Date serverEndTime = DateUtils.addMinutes(serverNowTime,
				testPaper.getAnswer_time());

		testPaper.setServerNowDate(serverNowTime);
		testPaper.setServerEndTime(serverEndTime);
		returnObject.setOtherData(testPaper);

		// 考试记录保存
		createOrUpdate(testPaper, serverNowTime, s);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return testPaper_url;
	}

	/**
	 * 提交试卷处理
	 * 
	 * @param model
	 * @param paperAnswerList
	 * @param paper_id
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/testPaper/add")
	public @ResponseBody ReturnDatas save(Model model,
			PaperAnswerList paperAnswerList, String paper_id, String used_time,
			HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ReturnDatas returnObject = ReturnDatas.getErrorReturnDatas();
		List<PaperAnswer> paperAnswers = paperAnswerList.getAnswers();
		if (CollectionUtils.isEmpty(paperAnswers)) {
			returnObject.setMessage("答题信息为空");
			return returnObject;
		}

		// 当前时间
		Date nowDate = new Date();
		// 试卷
		TestPaper testPaper = testPaperService.findById(paper_id,
				TestPaper.class);
		if (testPaper == null) {
			returnObject.setMessage("试卷信息不存在");
			return returnObject;
		}

		// 登录信息校验
		Student s = (Student) session.getAttribute("login_student");
		if (s == null) {
			returnObject.setMessage("请先登录");
			return returnObject;
		}

		// 考试记录查看
		TestRecord testRecord = getTestRecord(testPaper, s);

		if (testRecord == null) {
			returnObject.setMessage("未知错误");
			return returnObject;
		}
		// 用时
		testRecord.setUsed_time(NumberUtils.toLong(used_time, 0));
		// 根据试卷id查找试题信息
		int rightScore = 0;

		// 初始数组
		String[] arrs = new String[] { "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "WZ" };
		List<TestRecordInfo> recordInfoList = new ArrayList<TestRecordInfo>();
		// 遍历答题信息，统计正确结果，插入答题记录
		for (PaperAnswer pa : paperAnswers) {
			TestPaperInfo paperInfo = testPaperInfoService
					.findTestPaperInfoById(pa.getId());
			if (paperInfo != null) {
				int isRight = 0;
				int answerScore = 0;
				// 正确答案
				String rightResult = paperInfo.getRight_answer();
				int optionId = NumberUtils.toInt(
						String.valueOf(pa.getOptionId()), arrs.length - 1);

				String answerResult = arrs[optionId];
				if (rightResult.equalsIgnoreCase(answerResult)) {
					isRight = 1;
					rightScore += paperInfo.getScore();
					answerScore = paperInfo.getScore();
				}

				// 考试记录试题详情表
				TestRecordInfo recordInfo = new TestRecordInfo();
				recordInfo.setAnswer_result(answerResult);
				recordInfo.setAnswer_score(answerScore);
				recordInfo.setIsRight(isRight);
				recordInfo.setPaper_id(NumberUtils.toInt(paper_id));
				recordInfo.setPaper_info_id(paperInfo.getId());
				recordInfo.setRecord_id(testRecord.getId());
				recordInfoList.add(recordInfo);
			}
		}
		int isPass = 0;
		int passMark = NumberUtils.toInt(
				String.valueOf(testPaper.getPass_mark()), 0);
		if (rightScore >= passMark) {
			isPass = 1;
		}

		testRecord.setAnswer_finish_time(nowDate);
		testRecord.setUpdate_time(nowDate);
		testRecord.setRight_score(rightScore);
		testRecord.setIsPass(isPass);
		testRecord.setStatus(Enumerations.TestStatus.已做.getTestStatus());
		testRecordService.update(testRecord);
		testRecordInfoService.save(recordInfoList);
		returnObject.setStatus(ReturnDatas.SUCCESS);
		int recordId = testRecord.getId();
		returnObject.setMessage(String.valueOf(recordId));
		return returnObject;
	}

	/**
	 * 查询考试记录
	 * 
	 * @param testPaper
	 * @param s
	 * @return
	 * @throws Exception
	 */
	private TestRecord getTestRecord(TestPaper testPaper, Student s)
			throws Exception {
		// 试题记录信息
		TestRecord testRecord = new TestRecord();
		testRecord.setPaper_id(testPaper.getId());
		testRecord.setStudent_id(s.getId());
		testRecord.setStatus(Enumerations.TestStatus.未做.getTestStatus());
		TestRecord oldTestRecord = testRecordService
				.findTestRecordBySidPidStatus(testRecord);
		return oldTestRecord;
	}

	/**
	 * 根据试卷id查找试卷详情
	 * 
	 * @param paperId
	 * @return
	 * @throws Exception
	 */
	private List<TestPaperInfo> getTestPaperInfoListByPaperId(int paperId)
			throws Exception {
		List<TestPaperInfo> paperInfoList = testPaperInfoService
				.findTestPaperInfoByPaperId(paperId);
		if (CollectionUtils.isEmpty(paperInfoList)) {
			return null;
		}

		// 返回页面实体
		List<TestPaperInfo> paperInfoRtn = new ArrayList<TestPaperInfo>();
		for (TestPaperInfo paper : paperInfoList) {

			// 题目类型
			TopicType topic = topicTypeService.findTopicTypeById(paper
					.getTopic_type());
			paper.setTopicTypeName(topic.getName());
			String options = paper.getOptions();
			List<PaperOptions> paperOptionsList = new ArrayList<PaperOptions>();
			if (StringUtils.isNotBlank(options)) {
				String[] arrStr = options.split("/");
				for (int i = 0; i < arrStr.length; i++) {
					PaperOptions paperOptions = new PaperOptions();
					paperOptions.setId(i);
					paperOptions.setOption(arrStr[i]);
					paperOptionsList.add(paperOptions);
				}
			}
			paper.setPaperOptions(paperOptionsList);
			paperInfoRtn.add(paper);
		}
		return paperInfoRtn;
	}

	/**
	 * 创建或修改考试记录
	 * 
	 * @param testPaper
	 * @param serverNowTime
	 * @param s
	 * @return
	 * @throws Exception
	 */
	private TestRecord createOrUpdate(TestPaper testPaper, Date serverNowTime,
			Student s) throws Exception {
		// 试题记录信息
		TestRecord testRecord = new TestRecord();
		testRecord.setPaper_id(testPaper.getId());
		testRecord.setStudent_id(s.getId());
		testRecord.setStatus(Enumerations.TestStatus.未做.getTestStatus());
		TestRecord oldTestRecord = testRecordService
				.findTestRecordBySidPidStatus(testRecord);
		if (oldTestRecord != null) {
			testRecord.setId(oldTestRecord.getId());
		}
		testRecord.setAnswer_start_time(serverNowTime);
		testRecord.setCreate_time(serverNowTime);

		testRecord.setPaper_name(testPaper.getName());

		testRecord.setTotal_score(testPaper.getTotal_score());
		testRecord.setUpdate_time(serverNowTime);
		testRecordService.saveorupdate(testRecord);
		return testRecord;
	}

	/**
	 * 试题列表页面
	 * 
	 * @param model
	 * @param request
	 * @param session
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/testPaperList")
	public String questionList(Model model, HttpServletRequest request,
			HttpSession session, HttpServletResponse response, User user)
			throws Exception {
		String ctx = request.getParameter("ctx");
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		model.addAttribute("siteName", "我是中文站点");
		model.addAttribute("ctx", ctx);
		Student s = (Student) session.getAttribute("login_student");
		returnObject.setData(s);
		String subjects = request.getParameter("subjects");
		int subjectsId = NumberUtils.toInt(subjects, 0);
		List<TestPaper> paperList = testPaperService
				.findTestPaperListBySubjects(subjectsId);
		returnObject.setOtherData(paperList);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return testPaperList_url;
	}

	/**
	 * 考试记录列表页面
	 * 
	 * @param model
	 * @param request
	 * @param session
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/recordList")
	public String myRecord(Model model, HttpServletRequest request,
			HttpSession session, HttpServletResponse response, User user)
			throws Exception {
		String ctx = request.getParameter("ctx");
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		model.addAttribute("siteName", "我是中文站点");
		model.addAttribute("ctx", ctx);
		Student s = (Student) session.getAttribute("login_student");
		returnObject.setData(s);
		if (s == null) {
			// 试题记录页面
			model.addAttribute(GlobalStatic.returnDatas, returnObject);
			return recordList_url;
		}

		List<TestRecord> testRecordList = testRecordService
				.findTestRecordListBySid(s.getId());
		returnObject.setOtherData(testRecordList);

		// 试题记录页面
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return recordList_url;
	}

	@RequestMapping(value = "/result")
	public String result(Model model, HttpServletRequest request,
			HttpSession session, HttpServletResponse response, User user)
			throws Exception {
		ReturnDatas returnObject = ReturnDatas.getSuccessReturnDatas();
		String recordId = request.getParameter("recordId");
		model.addAttribute("siteName", "我是中文站点");
		String ctx = request.getParameter("ctx");
		model.addAttribute("ctx", ctx);
		Student s = (Student) session.getAttribute("login_student");
		returnObject.setData(s);
		if (s == null) {
			model.addAttribute(GlobalStatic.returnDatas, returnObject);
			return result_url;
		}

		// @Resource
		// private ITestRecordService testRecordService;
		// @Resource
		// private ITestRecordInfoService testRecordInfoService;
		TestRecord testRecord = testRecordService.findTestRecordById(recordId);
		if (testRecord == null) {
			model.addAttribute(GlobalStatic.returnDatas, returnObject);
			return result_url;
		}

		// 试卷
		TestPaper testPaper = testPaperService.findById(
				testRecord.getPaper_id(), TestPaper.class);

		// 试题信息
		if (testPaper == null) {
			model.addAttribute(GlobalStatic.returnDatas, returnObject);
			return testPaper_url;
		}
		Subjects subjects = subjectsService.findSubjectsById(testPaper
				.getSubjects());
		if (subjects != null) {
			testPaper.setSubjectsName(subjects.getName());
		}

		// 根据试卷id查找试题详情
		List<TestPaperInfo> paperInfoRtn = getTestPaperInfoListByPaperId(testPaper
				.getId());
		if (CollectionUtils.isEmpty(paperInfoRtn)) {
			testRecord.setTestPaper(testPaper);
			returnObject.setOtherData(testRecord);
			model.addAttribute(GlobalStatic.returnDatas, returnObject);
			return result_url;
		}

		for (TestPaperInfo info : paperInfoRtn) {
			TestRecordInfo recordInfo = testRecordInfoService
					.findTestRecordInfoByPIdSidPaperId(testRecord.getId(),
							testPaper.getId(), info.getId());
			info.setRecordInfo(recordInfo);
		}
		testPaper.setTestPaperInfoList(paperInfoRtn);
		testRecord.setTestPaper(testPaper);
		returnObject.setOtherData(testRecord);
		model.addAttribute(GlobalStatic.returnDatas, returnObject);
		return result_url;
	}

	/**
	 * 退出接口
	 * 
	 * @param model
	 * @param request
	 * @param session
	 * @param response
	 * @param user
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * 
	 * @param model
	 * @param session
	 * @param student
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/student/update")
	public @ResponseBody ReturnDatas studentUpdate(Model model,
			String old_password, HttpSession session, Student student,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
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

			if (StringUtils.isBlank(password)
					|| StringUtils.isBlank(old_password)) {
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
			Student oldStudent = studentList.get(0);

			String oldPwdMd5 = SecUtils.encoderByMd5With32Bit(old_password);
			if (!oldPwdMd5.equalsIgnoreCase(oldStudent.getPassword())) {
				returnObject.setMessage("原密码错误");
				return returnObject;
			}

			// 密码进行md5加密
			student.setId(oldStudent.getId());
			student.setPassword(SecUtils.encoderByMd5With32Bit(password));
			student.setCreate_time(oldStudent.getCreate_time());
			student.setUpdate_time(new Date());
			returnObject.setMessage(MessageUtils.UPDATE_SUCCESS);
			student.setUpdate_time(new Date());
			studentService.saveorupdate(student);
			session.setAttribute("login_student", student);
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
				.compile("^((13[0-9])|(17[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
}
