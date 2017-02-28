/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : online

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2017-02-26 21:36:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `o_student`
-- ----------------------------
DROP TABLE IF EXISTS `o_student`;
CREATE TABLE `o_student` (
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `name` varchar(50) default NULL COMMENT '姓名',
  `sex` varchar(10) default '男' COMMENT '性别',
  `major` varchar(50) default NULL COMMENT '专业',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '修改时间',
  `id` int(11) NOT NULL auto_increment COMMENT '学生表',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_student
-- ----------------------------
INSERT INTO `o_student` VALUES ('18837195325', '急速蜗牛', '男', '3G软件', '25f9e794323b453885f5181f1b624d0b', '2017-02-26 17:46:48', '2017-02-26 17:46:48', '1');
INSERT INTO `o_student` VALUES ('18103847927', '奔跑的蜗牛', '男', '软件工程', '25f9e794323b453885f5181f1b624d0b', '2017-02-26 17:48:06', '2017-02-26 17:48:06', '2');
INSERT INTO `o_student` VALUES ('13345678765', 'tttt', '男', 'tttt', '32bf0e6fcff51e53bd74e70ba1d622b2', '2017-02-26 21:20:46', '2017-02-26 21:20:46', '3');
INSERT INTO `o_student` VALUES ('13333333333', 'rrrr', '男', 'rrrr', 'eb9279982226a42afdf2860dbdc29b45', '2017-02-26 21:22:15', '2017-02-26 21:22:15', '4');

-- ----------------------------
-- Table structure for `o_subjects`
-- ----------------------------
DROP TABLE IF EXISTS `o_subjects`;
CREATE TABLE `o_subjects` (
  `id` int(11) NOT NULL auto_increment COMMENT '科目表',
  `name` varchar(50) NOT NULL,
  `create_time` datetime default NULL,
  `update_time` datetime default NULL,
  `status` int(2) default '0' COMMENT '生效状态（0：不可用，1：可用）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_subjects
-- ----------------------------
INSERT INTO `o_subjects` VALUES ('0', '财经法规', '2017-02-19 13:25:50', '2017-02-19 13:25:50', '1');

-- ----------------------------
-- Table structure for `o_test_paper`
-- ----------------------------
DROP TABLE IF EXISTS `o_test_paper`;
CREATE TABLE `o_test_paper` (
  `id` int(11) NOT NULL auto_increment COMMENT '试卷信息表',
  `name` varchar(50) NOT NULL COMMENT '试卷名称',
  `subjects` int(4) default '0' COMMENT '科目',
  `status` int(2) default '0' COMMENT '生效状态（0：不可用，1：可以，2：已删除）',
  `answer_time` int(10) NOT NULL COMMENT '作答时间（单位：分钟）',
  `total_score` int(4) NOT NULL COMMENT '总分',
  `pass_mark` int(4) NOT NULL COMMENT '及格分数',
  `create_time` datetime default NULL COMMENT '创建日期',
  `update_time` datetime default NULL COMMENT '修改日期',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_test_paper
-- ----------------------------
INSERT INTO `o_test_paper` VALUES ('1', '2016年会计从业《财经法规与会计职业道德》真题2', '0', '1', '1', '3', '2', '2017-02-19 13:27:34', '2017-02-26 20:40:56');

-- ----------------------------
-- Table structure for `o_test_paper_info`
-- ----------------------------
DROP TABLE IF EXISTS `o_test_paper_info`;
CREATE TABLE `o_test_paper_info` (
  `id` int(11) unsigned NOT NULL auto_increment COMMENT '试卷信息详情表',
  `paper_id` int(11) default NULL COMMENT '试卷ID',
  `topic_type` int(2) default NULL COMMENT '题目类型',
  `score` int(10) default '0' COMMENT '分值',
  `problem_description` varchar(500) default NULL COMMENT '题目描述',
  `reference_description` varchar(10000) default NULL COMMENT '参考说明',
  `options` varchar(10000) default NULL COMMENT '选项',
  `right_answer` varchar(50) default NULL COMMENT '正确答案',
  `create_time` datetime default NULL COMMENT '创建日期',
  `update_time` datetime default NULL COMMENT '修改日期',
  `imgURL` varchar(500) default NULL COMMENT '图片路径',
  `isIMG` int(2) default '0' COMMENT '是否为图片类型题目（0：否，1：是）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_test_paper_info
-- ----------------------------
INSERT INTO `o_test_paper_info` VALUES ('2', '1', '1', '1', '以下法律文件属于法规层次的是（　　）。', '《中华人民共和国企业所得税》和《中华人民共和国税收征管法》由全国人民代表大会制定，属于法律范畴。《营业税实施细则》属于税收规章。', 'A.《中华人民共和国企业所得税法》/B.《增值税暂行条例》/C.《营业税实施细则》/D.《税收征管法》', 'B', '2017-02-19 15:07:53', '2017-02-19 15:28:46', '', '0');
INSERT INTO `o_test_paper_info` VALUES ('3', '1', '1', '1', '会计专业职务任期一般每任不超过（）年。', '会计专业职务任期一般不超过5年，根据工作需要可以续聘或连任。', 'A.3/B.4/C.5/D.7', 'C', '2017-02-19 14:48:09', '2017-02-19 14:48:09', '', '0');
INSERT INTO `o_test_paper_info` VALUES ('7', '1', '1', '1', '会计机构、会计人员对下列会计事项有权自行处理的是（　　）', '会计机构、会计人员发现会计账簿记录与实物、款项及有关资料不相符的，按照国家统一规定的会计制度的规定有权自行处理的，应当及时处理；无权处理的，应当立即向单位负责人报告，请求查明原因，作出处理。', 'A.核对账目时发现坏账/B.登记账目后发现遗漏/C.财产清查时发现大额货币资金短缺/D.发现贪污、舞弊行为', 'B', '2017-02-19 15:10:27', '2017-02-19 15:10:27', '', '0');

-- ----------------------------
-- Table structure for `o_test_record`
-- ----------------------------
DROP TABLE IF EXISTS `o_test_record`;
CREATE TABLE `o_test_record` (
  `id` int(11) NOT NULL auto_increment COMMENT '考试记录表',
  `student_id` int(11) default NULL COMMENT '学生ID',
  `paper_id` int(11) default NULL COMMENT '试题表ID',
  `paper_name` varchar(50) default NULL COMMENT '试题名称',
  `used_time` bigint(32) default NULL COMMENT '做题使用时间',
  `total_score` int(4) default '0' COMMENT '总分数',
  `right_score` int(11) default NULL COMMENT '得分',
  `answer_start_time` datetime default NULL COMMENT '作答开始时间',
  `answer_finish_time` datetime default NULL COMMENT '作答结束时间',
  `create_time` datetime default NULL COMMENT '创建日期',
  `update_time` datetime default NULL COMMENT '修改日期',
  `status` int(2) default '0' COMMENT '状态（0：未做 1：已做）',
  `isPass` int(2) default '0' COMMENT '是否及格（0：否，1：是）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_test_record
-- ----------------------------
INSERT INTO `o_test_record` VALUES ('8', '2', '1', '2016年会计从业《财经法规与会计职业道德》真题2', '7', '3', '3', '2017-02-26 20:38:09', '2017-02-26 20:38:16', '2017-02-26 20:38:09', '2017-02-26 20:38:16', '1', '1');
INSERT INTO `o_test_record` VALUES ('9', '2', '1', '2016年会计从业《财经法规与会计职业道德》真题2', '1', '3', '1', '2017-02-26 20:58:00', '2017-02-26 20:58:32', '2017-02-26 20:58:00', '2017-02-26 20:58:32', '1', '0');
INSERT INTO `o_test_record` VALUES ('10', '2', '1', '2016年会计从业《财经法规与会计职业道德》真题2', '1', '3', '0', '2017-02-26 21:06:09', '2017-02-26 21:06:10', '2017-02-26 21:06:09', '2017-02-26 21:06:10', '1', '0');
INSERT INTO `o_test_record` VALUES ('11', '4', '1', '2016年会计从业《财经法规与会计职业道德》真题2', '7', '3', '0', '2017-02-26 21:23:26', '2017-02-26 21:23:33', '2017-02-26 21:23:26', '2017-02-26 21:23:33', '1', '0');
INSERT INTO `o_test_record` VALUES ('12', '4', '1', '2016年会计从业《财经法规与会计职业道德》真题2', null, '3', null, '2017-02-26 21:24:07', null, '2017-02-26 21:24:07', '2017-02-26 21:24:07', '0', null);

-- ----------------------------
-- Table structure for `o_test_record_info`
-- ----------------------------
DROP TABLE IF EXISTS `o_test_record_info`;
CREATE TABLE `o_test_record_info` (
  `id` int(11) NOT NULL auto_increment COMMENT '考试记录详情表',
  `record_id` int(11) default NULL COMMENT '记录表ID',
  `paper_id` int(11) default NULL COMMENT '试题表ID',
  `paper_info_id` int(11) default NULL COMMENT '试题详情表ID',
  `answer_result` varchar(2) default '-1' COMMENT '作答答案',
  `answer_score` int(2) default '0' COMMENT '作答得分',
  `isRight` int(2) default '0' COMMENT '是否正确（0：否，1：是）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_test_record_info
-- ----------------------------
INSERT INTO `o_test_record_info` VALUES ('19', '8', '1', '2', 'B', '1', '1');
INSERT INTO `o_test_record_info` VALUES ('20', '8', '1', '3', 'C', '1', '1');
INSERT INTO `o_test_record_info` VALUES ('21', '8', '1', '7', 'B', '1', '1');
INSERT INTO `o_test_record_info` VALUES ('22', '9', '1', '2', 'C', '0', '0');
INSERT INTO `o_test_record_info` VALUES ('23', '9', '1', '3', 'B', '0', '0');
INSERT INTO `o_test_record_info` VALUES ('24', '9', '1', '7', 'B', '1', '1');
INSERT INTO `o_test_record_info` VALUES ('25', '10', '1', '2', 'WZ', '0', '0');
INSERT INTO `o_test_record_info` VALUES ('26', '10', '1', '3', 'WZ', '0', '0');
INSERT INTO `o_test_record_info` VALUES ('27', '10', '1', '7', 'WZ', '0', '0');
INSERT INTO `o_test_record_info` VALUES ('28', '11', '1', '2', 'A', '0', '0');
INSERT INTO `o_test_record_info` VALUES ('29', '11', '1', '3', 'WZ', '0', '0');
INSERT INTO `o_test_record_info` VALUES ('30', '11', '1', '7', 'WZ', '0', '0');

-- ----------------------------
-- Table structure for `o_topic_type`
-- ----------------------------
DROP TABLE IF EXISTS `o_topic_type`;
CREATE TABLE `o_topic_type` (
  `id` int(4) NOT NULL auto_increment COMMENT '题目类型表',
  `name` varchar(20) default NULL COMMENT '名称',
  `create_time` datetime default NULL COMMENT '创建日期',
  `update_time` datetime default NULL COMMENT '修改日期',
  `status` int(2) default '0' COMMENT '生效状态（0：不可用，1：可用）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of o_topic_type
-- ----------------------------
INSERT INTO `o_topic_type` VALUES ('1', '单选题', '2017-02-15 20:30:14', '2017-02-15 20:35:35', '1');
INSERT INTO `o_topic_type` VALUES ('2', '复选题', '2017-02-15 20:35:31', '2017-02-15 20:35:44', '0');

-- ----------------------------
-- Table structure for `t_auditlog_history_2017`
-- ----------------------------
DROP TABLE IF EXISTS `t_auditlog_history_2017`;
CREATE TABLE `t_auditlog_history_2017` (
  `id` varchar(40) NOT NULL COMMENT 'ID',
  `operationType` varchar(50) default NULL COMMENT '操作类型',
  `operatorName` varchar(50) default NULL COMMENT '操作人姓名',
  `preValue` text COMMENT '旧值',
  `curValue` text COMMENT '新值',
  `operationTime` datetime default NULL COMMENT '操作时间',
  `operationClass` varchar(500) default NULL COMMENT '操作类',
  `operationClassID` varchar(50) default NULL COMMENT '记录ID',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作记录';

-- ----------------------------
-- Records of t_auditlog_history_2017
-- ----------------------------

-- ----------------------------
-- Table structure for `t_fwlog_history_2017`
-- ----------------------------
DROP TABLE IF EXISTS `t_fwlog_history_2017`;
CREATE TABLE `t_fwlog_history_2017` (
  `id` varchar(100) NOT NULL COMMENT 'ID',
  `startDate` datetime default NULL COMMENT '访问时间',
  `strDate` varchar(100) default NULL COMMENT '访问时间(毫秒)',
  `tomcat` varchar(50) default NULL COMMENT 'Tomcat',
  `userCode` varchar(300) default NULL COMMENT '登陆账号',
  `userName` varchar(200) default NULL COMMENT '姓名',
  `sessionId` varchar(300) default NULL COMMENT 'sessionId',
  `ip` varchar(200) default NULL COMMENT 'IP',
  `fwUrl` varchar(3000) default NULL COMMENT '访问菜单',
  `menuName` varchar(100) default NULL COMMENT '菜单名称',
  `isqx` varchar(2) default NULL COMMENT '是否有权限访问',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='访问日志';

-- ----------------------------
-- Records of t_fwlog_history_2017
-- ----------------------------
INSERT INTO `t_fwlog_history_2017` VALUES ('00c5f409ea19419e857d4c910ac09e4b', '2017-02-26 17:53:06', '2017-02-26 17:53:06.0264', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('00d4940c82cd4247bdb4908be38a11f2', '2017-02-26 17:58:02', '2017-02-26 17:58:02.0265', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/user/update', '[修改用户]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('041e7aef4cd2494898cd7ccf75f342f9', '2017-02-26 18:03:38', '2017-02-26 18:03:38.0681', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('04cfbd639cdb48f188f255047c89d51d', '2017-02-26 17:53:39', '2017-02-26 17:53:39.0943', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('05c229aee3b24763ba446e49609f9408', '2017-02-26 17:54:20', '2017-02-26 17:54:20.0780', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('08b45fc2161b434e82eea4065c5c0fa9', '2017-02-26 17:54:31', '2017-02-26 17:54:31.0334', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('09f3e6f3888b4edbb750567f06fd29f4', '2017-02-26 20:40:57', '2017-02-26 20:40:57.0792', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('09fe67237fb54a4f8a843df11905de98', '2017-02-26 21:25:42', '2017-02-26 21:25:42.0773', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/topictype/list', '[题型管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('0c9d79b08afb4261a48f802dba139530', '2017-02-26 17:43:55', '2017-02-26 17:43:55.0894', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('0d3225de56cd473bb4ceac6af811608d', '2017-02-26 21:25:39', '2017-02-26 21:25:39.0955', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/subjects/list', '[科目管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('0e107bd7a47e45058dc995dd8a543abb', '2017-02-26 17:52:43', '2017-02-26 17:52:43.0028', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('0e3acedc86ab4db1991211245f0b1c66', '2017-02-26 20:40:56', '2017-02-26 20:40:56.0351', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/testpaper/update', '[试卷修改]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('10684712fac543ccb3ca7a2b4f21a931', '2017-02-26 17:54:02', '2017-02-26 17:54:02.0884', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('11bbe5d13dde41159e9f8b2a0bad6812', '2017-02-26 17:44:10', '2017-02-26 17:44:10.0722', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1343298a76c24a57b46de5899a60052a', '2017-02-26 17:43:59', '2017-02-26 17:43:59.0341', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', '[级别管理]', '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('151d0b4e9ca84d5093ab9d05aa2282cf', '2017-02-26 17:54:09', '2017-02-26 17:54:09.0362', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('18248afaaaa644c780c643c7384b781e', '2017-02-26 21:26:30', '2017-02-26 21:26:30.0257', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('183af6ea1e7b4cd9bb772db30319f3b9', '2017-02-26 17:52:49', '2017-02-26 17:52:49.0281', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1a5f319c963345269a409aa8bfa36cab', '2017-02-26 17:52:54', '2017-02-26 17:52:54.0581', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1a8031130f4e4f2794eabf091cf67d4b', '2017-02-26 18:03:43', '2017-02-26 18:03:43.0126', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/testrecord/list', '[考试记录查看]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1a823f18b0cb439cbaf9f0040ff247e8', '2017-02-26 18:02:23', '2017-02-26 18:02:23.0968', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('1b86a92f7f274aff88040e796fa0d5db', '2017-02-26 17:52:36', '2017-02-26 17:52:36.0005', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1c2cd5c662fc4200bddc0c32f5b26ac4', '2017-02-26 21:27:25', '2017-02-26 21:27:25.0526', null, 'admin', 'admin', '9a68d67f-8ea3-4317-b919-f33b155cb77e', '127.0.0.1', 'http://127.0.0.1/online/system/role/list', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1c940acaddec44c2bc23fcd06356622f', '2017-02-26 17:52:42', '2017-02-26 17:52:42.0856', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1e00c22783c44206aeadfd4590220ca1', '2017-02-26 17:52:01', '2017-02-26 17:52:01.0197', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1eae4ec5d14d46acac45aea68dafc993', '2017-02-26 17:44:00', '2017-02-26 17:44:00.0629', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/subjects/list', '[科目管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1ee03ca42fa048c1b618caa2f4e11aa2', '2017-02-26 18:02:12', '2017-02-26 18:02:12.0561', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/menu/tree/pre', '[菜单树形结构]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1f00124ed96a4f20b0699798b9acce03', '2017-02-26 17:54:32', '2017-02-26 17:54:32.0312', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('1fa2d28e0f934392906ee0504a6aff05', '2017-02-26 17:52:50', '2017-02-26 17:52:50.0287', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('2022e14d5d26419baed9a94e36ac7aac', '2017-02-26 21:26:30', '2017-02-26 21:26:30.0033', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('227845d8d7b34ef18a86273868dea9f7', '2017-02-26 17:54:27', '2017-02-26 17:54:27.0739', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('285d98a476cd4c22b4859d5d92542569', '2017-02-26 21:25:28', '2017-02-26 21:25:28.0382', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('2a181ec4b55b4658bbfbedabd1beeaec', '2017-02-26 17:52:53', '2017-02-26 17:52:53.0435', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('2a78bf606e864f91af2e844b9731671c', '2017-02-26 17:53:06', '2017-02-26 17:53:06.0117', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('2d6ff16a860c4c7cac0411e227009652', '2017-02-26 17:43:55', '2017-02-26 17:43:55.0506', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('2ea0de7bc5bd48d09f45e7d792fd5f94', '2017-02-26 17:52:20', '2017-02-26 17:52:20.0760', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('2fbbc40ea766408d9a4a80195f5593aa', '2017-02-26 17:53:47', '2017-02-26 17:53:47.0349', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('30064519707e40c7b5798ef796385bc2', '2017-02-26 17:44:16', '2017-02-26 17:44:16.0567', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', '[级别管理]', '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('3272bd08034e4beca4559208f21e1522', '2017-02-26 17:53:32', '2017-02-26 17:53:32.0883', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('32d141c5df364f5bb1fe7fdf76a3dead', '2017-02-26 18:01:57', '2017-02-26 18:01:57.0975', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('335f9cd57fe343b7822d2342f28cfd6c', '2017-02-26 17:43:48', '2017-02-26 17:43:48.0708', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('33d0868ae0c04b41823fffdd1ee95dac', '2017-02-26 17:52:00', '2017-02-26 17:52:00.0735', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('35bc8caecb0542b2a8169b763dce7fce', '2017-02-26 17:52:07', '2017-02-26 17:52:07.0167', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('3766fbabcbfa4db9b8ca094107fd043e', '2017-02-26 17:53:25', '2017-02-26 17:53:25.0175', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('378e893487c74bb4a157a51ffa884324', '2017-02-26 17:53:20', '2017-02-26 17:53:20.0842', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('3cc75330bf5a4ca0bfbc1ed1b8c7b475', '2017-02-26 17:52:46', '2017-02-26 17:52:46.0924', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('3d26578c609e402585a8a8ab0d077973', '2017-02-26 17:52:19', '2017-02-26 17:52:19.0608', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('3da9de360ddf42d7a9ecc2273ac24192', '2017-02-26 17:54:21', '2017-02-26 17:54:21.0911', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('3dfe5b6051e54d3188485ebbecc14a05', '2017-02-26 17:53:36', '2017-02-26 17:53:36.0163', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('4268c8ee534242bba7080a415d73f476', '2017-02-26 17:54:01', '2017-02-26 17:54:01.0356', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('42cb37d076364959993f0349e2b0c0e5', '2017-02-26 17:54:15', '2017-02-26 17:54:15.0794', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('434213fa29ec4caa8074809d50fe4a05', '2017-02-26 17:53:02', '2017-02-26 17:53:02.0386', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('43f291273e4b4ff2ac0f8d7499fef438', '2017-02-26 17:53:09', '2017-02-26 17:53:09.0652', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('4506cae710184cbf9a53a0f17f2d6084', '2017-02-26 21:27:22', '2017-02-26 21:27:22.0786', null, 'admin', 'admin', '9a68d67f-8ea3-4317-b919-f33b155cb77e', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('4661ed31bc994e41972b8fc775d1941a', '2017-02-26 17:52:58', '2017-02-26 17:52:58.0568', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('46b69184476c432aaf848f4d3684b116', '2017-02-26 17:53:36', '2017-02-26 17:53:36.0001', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('475efbccd72943ebb2afaffd9038dadc', '2017-02-26 17:53:40', '2017-02-26 17:53:40.0073', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('4b3cebe2da474c378ad2987da48bdfe5', '2017-02-26 18:00:15', '2017-02-26 18:00:15.0368', null, 'admin', 'admin', '13b2de81-4c59-4533-8c52-0e49f0d0e082', '127.0.0.1', 'http://127.0.0.1/online/system/user/update', '[修改用户]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('4b8dcbd0587e42d596e1c899557a0398', '2017-02-26 17:54:32', '2017-02-26 17:54:32.0449', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('4bfd6e6e547d4680bb35dc5f0bf78fbd', '2017-02-26 17:53:09', '2017-02-26 17:53:09.0742', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('4f409d92004b4fcaba2a5a150437b692', '2017-02-26 17:52:29', '2017-02-26 17:52:29.0548', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('505b038f3c3d4df39ced9fba3463e7e2', '2017-02-26 17:43:59', '2017-02-26 17:43:59.0013', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('51e907c438494ad886130e42867aade1', '2017-02-26 17:52:41', '2017-02-26 17:52:41.0735', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('53a5d292962041e4b7a24fdfed0ab856', '2017-02-26 17:53:43', '2017-02-26 17:53:43.0500', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('54fa438e53e54b7d9d249560bd8af44c', '2017-02-26 17:44:13', '2017-02-26 17:44:13.0385', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/student/list', '[学生管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('5593c241a882439fb8cd40c4b7ad72b3', '2017-02-26 18:00:02', '2017-02-26 18:00:02.0439', null, 'admin', 'admin', '13b2de81-4c59-4533-8c52-0e49f0d0e082', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('58a07659213748768cc780254dda756a', '2017-02-26 17:44:16', '2017-02-26 17:44:16.0441', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('5a8331bb8d6c4f92a05305ed43922921', '2017-02-26 18:02:38', '2017-02-26 18:02:38.0257', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/user/update', '[修改用户]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('5c2810d514504b389297c82d99beb73e', '2017-02-26 17:53:42', '2017-02-26 17:53:42.0545', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('5c66caa33cda492c9127c834017bb47a', '2017-02-26 21:25:03', '2017-02-26 21:25:03.0481', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('5d2352e1f55f4bacbb7828cab945eeed', '2017-02-26 17:52:05', '2017-02-26 17:52:05.0586', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('6131bf86a6d44109b81c7454bef3489e', '2017-02-26 17:53:13', '2017-02-26 17:53:13.0682', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('61dda4ab4cf14066975d0c943b417625', '2017-02-26 18:03:21', '2017-02-26 18:03:21.0540', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('625ebe9370294966be9d398b22907b05', '2017-02-26 17:53:45', '2017-02-26 17:53:45.0932', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('62b70d81b3274077be226aaf7f94c288', '2017-02-26 21:25:28', '2017-02-26 21:25:28.0390', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('64ee5064d1214282b7feaf9ab804856e', '2017-02-26 17:44:16', '2017-02-26 17:44:16.0568', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('6559e41b297e4359a51aeb292479832f', '2017-02-26 18:04:03', '2017-02-26 18:04:03.0304', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('65ba53796df149808735bc999b02305d', '2017-02-26 17:52:45', '2017-02-26 17:52:45.0548', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('678fe8a5ef6b4bbabe2d352bfb717b6b', '2017-02-26 20:40:21', '2017-02-26 20:40:21.0731', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('6aade00890bc4228be0851e4b3f07ea5', '2017-02-26 17:53:17', '2017-02-26 17:53:17.0375', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('6c1a63b5a7a248cdb5904026bc87da80', '2017-02-26 18:03:38', '2017-02-26 18:03:38.0676', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('6c23cd99422b46f59227af2522814ee2', '2017-02-26 18:02:20', '2017-02-26 18:02:20.0313', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/role/list', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('6dc6c8945cb948e48552be9da83c9a29', '2017-02-26 21:25:44', '2017-02-26 21:25:44.0730', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/testrecord/list', '[考试记录查看]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('6e05c672808a40c6a126ed9d366b80d6', '2017-02-26 18:03:21', '2017-02-26 18:03:21.0694', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('6f8aee9d475d4c3e9fdb0d7547ef1325', '2017-02-26 17:44:16', '2017-02-26 17:44:16.0058', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/subjects/list', '[科目管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('73f79754f2e54e098c3036f2148c499d', '2017-02-26 17:53:28', '2017-02-26 17:53:28.0258', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('76b0c9bd3f0b48ecbe3575e53e6510ad', '2017-02-26 21:26:30', '2017-02-26 21:26:30.0255', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('76f031440b974ace93d2ceb6c8738ff3', '2017-02-26 18:03:34', '2017-02-26 18:03:34.0482', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('78d02ac30c4e4f06b210a2b272a72bce', '2017-02-26 17:52:58', '2017-02-26 17:52:58.0651', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('79cc46f1e93546c783d8afb7dab1f6cb', '2017-02-26 17:52:07', '2017-02-26 17:52:07.0023', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('7b6e22b5a8c14eda8e5e4ee417cb3b8a', '2017-02-26 21:25:28', '2017-02-26 21:25:28.0138', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('7fb555aa14924b8cb55239dde11fe156', '2017-02-26 17:52:54', '2017-02-26 17:52:54.0449', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('81c42e7ea4f54f4ba916b6519b3e3c76', '2017-02-26 17:51:57', '2017-02-26 17:51:57.0955', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('822db110a63d4283a2e714349f2943a2', '2017-02-26 18:00:51', '2017-02-26 18:00:51.0355', null, 'admin', 'admin', '13b2de81-4c59-4533-8c52-0e49f0d0e082', '127.0.0.1', 'http://127.0.0.1/online/system/user/update', '[修改用户]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('83b090b0aceb4739919c8302dc91adac', '2017-02-26 17:54:27', '2017-02-26 17:54:27.0939', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('844ce2d60c6d410fb148e46d4031fb1f', '2017-02-26 18:03:47', '2017-02-26 18:03:47.0960', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/student/list', '[学生管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('844f46e264074fdcb1353bf7f2263e5a', '2017-02-26 17:53:25', '2017-02-26 17:53:25.0262', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('850897026ce843bbbac68b0b9e04c47f', '2017-02-26 17:54:14', '2017-02-26 17:54:14.0612', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('850bca241ab94eccb6f39604cb1f7f93', '2017-02-26 17:52:50', '2017-02-26 17:52:50.0389', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('865d7fb04aa24710bc9f178fac79ac32', '2017-02-26 17:52:28', '2017-02-26 17:52:28.0489', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('873a7e877ac04c52b8040d1f724aa8dd', '2017-02-26 17:53:32', '2017-02-26 17:53:32.0796', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('88967103282e4f43a2e2f2f9fd7b1e95', '2017-02-26 18:02:23', '2017-02-26 18:02:23.0978', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('88e90eca198046dfa0c6cfd324c5aa22', '2017-02-26 17:52:15', '2017-02-26 17:52:15.0273', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('89f8f62c8ffd4476aaa9f80130ffc1a4', '2017-02-26 17:53:43', '2017-02-26 17:53:43.0610', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('8bd8a6d8fe144106ac49d319ac0e6ab0', '2017-02-26 17:52:57', '2017-02-26 17:52:57.0232', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('8ddcda8efcd6495d8c9cc660401b57ca', '2017-02-26 17:52:29', '2017-02-26 17:52:29.0430', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('8deb972bdc864c2ba5a47d92dd303f11', '2017-02-26 17:53:19', '2017-02-26 17:53:19.0705', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('8efda9b7a01243fa9d134518f8153c8d', '2017-02-26 17:54:09', '2017-02-26 17:54:09.0481', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('9106e59cd92e43efa623ea7a609d91d5', '2017-02-26 17:54:58', '2017-02-26 17:54:58.0154', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', '[级别管理]', '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('919acc8e16c947cbab96ea4e0451a123', '2017-02-26 18:01:57', '2017-02-26 18:01:57.0973', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('9520a5a22e2d4ac7b6f24470c2014e27', '2017-02-26 17:52:26', '2017-02-26 17:52:26.0076', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('954ae3a17ef544b08cf6054af0a0810d', '2017-02-26 21:25:10', '2017-02-26 21:25:10.0914', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('95ba241efcab4e21833108feac140e49', '2017-02-26 20:40:15', '2017-02-26 20:40:15.0181', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('976bdd924b04469eacca57c2dbcbec0a', '2017-02-26 17:53:29', '2017-02-26 17:53:29.0195', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('977d26a55f454af5b51a0689590f5de5', '2017-02-26 17:53:47', '2017-02-26 17:53:47.0428', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('986b6f7033d04172b6aa3ce12e6f2e12', '2017-02-26 17:53:17', '2017-02-26 17:53:17.0259', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('9987613ef7764f239ece7347623e6b81', '2017-02-26 17:44:15', '2017-02-26 17:44:15.0140', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('99d0532d69d34fee88e1f27677bbea06', '2017-02-26 17:54:26', '2017-02-26 17:54:26.0910', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('9b028dcda04641529bcd9633326cfe5e', '2017-02-26 17:52:24', '2017-02-26 17:52:24.0716', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('9b3288b27777474e88dc5d668b73c1c3', '2017-02-26 17:44:14', '2017-02-26 17:44:14.0641', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/testrecord/list', '[考试记录查看]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('9b3869181d4448c980b11fa4ac6fae0a', '2017-02-26 17:53:01', '2017-02-26 17:53:01.0216', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('9dcc7743155a4e2091ac0ceb5f49fa82', '2017-02-26 21:25:18', '2017-02-26 21:25:18.0933', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/student/list', '[学生管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('9e2d05fd831d4d74b94f1f8174b720db', '2017-02-26 21:27:00', '2017-02-26 21:27:00.0902', null, 'admin', 'admin', '9a68d67f-8ea3-4317-b919-f33b155cb77e', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('a412810177a24b68be7e3b3fb1bae3fb', '2017-02-26 17:52:25', '2017-02-26 17:52:25.0927', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('a4c6ddb7b73643688375e27acf170978', '2017-02-26 17:52:37', '2017-02-26 17:52:37.0313', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('a506279610bd4c9a92991664fe8bdc9d', '2017-02-26 17:52:13', '2017-02-26 17:52:13.0326', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('a5725b755ca44f478df421160d2d7b50', '2017-02-26 18:03:52', '2017-02-26 18:03:52.0684', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('a5df0162b27349e7be75db73ba3389c2', '2017-02-26 18:01:37', '2017-02-26 18:01:37.0101', null, 'admin', 'admin', '13b2de81-4c59-4533-8c52-0e49f0d0e082', '127.0.0.1', 'http://127.0.0.1/online/system/user/update', '[修改用户]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('a5fc9764cc1246bcb03504fb8bd1f110', '2017-02-26 17:54:08', '2017-02-26 17:54:08.0178', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('a69d93619b2748b9ae0616be93275d76', '2017-02-26 17:44:05', '2017-02-26 17:44:05.0556', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('a6e20fe14f9040b0bad7978a89d63761', '2017-02-26 17:53:02', '2017-02-26 17:53:02.0254', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('a80dc85721914b338b1c7aecc020bc78', '2017-02-26 18:02:02', '2017-02-26 18:02:02.0857', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/role/list', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('a84b7ba5985146f8b4aa2888cfe63236', '2017-02-26 18:01:54', '2017-02-26 18:01:54.0326', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('a979a830135240a8acdc845e17808932', '2017-02-26 17:53:05', '2017-02-26 17:53:05.0055', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('a9ec88136f6343c195e030cca2f8e22c', '2017-02-26 18:00:05', '2017-02-26 18:00:05.0501', null, 'admin', 'admin', '13b2de81-4c59-4533-8c52-0e49f0d0e082', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('aac4c4c53f604cdb94b7885dbd9706af', '2017-02-26 17:53:20', '2017-02-26 17:53:20.0929', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('ab2d346939d64535969fa720cdd3f9b0', '2017-02-26 17:52:46', '2017-02-26 17:52:46.0708', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('ab377a561e38448eb51c5e872180ed60', '2017-02-26 18:03:21', '2017-02-26 18:03:21.0688', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('ac361bb7e470464db1b4478f1133b1ce', '2017-02-26 21:25:14', '2017-02-26 21:25:14.0003', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/testrecord/list', '[考试记录查看]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('ac7882b8f5e843c788c7f4065b9573e3', '2017-02-26 18:03:42', '2017-02-26 18:03:42.0298', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/topictype/list', '[题型管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('ae07146fcf1e4be49e4a5a7ccb01cb34', '2017-02-26 17:53:08', '2017-02-26 17:53:08.0718', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('b08b7592a0da40f3b09bf6724cc9e5fe', '2017-02-26 17:52:20', '2017-02-26 17:52:20.0985', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('b29b605523b64f2db9b0abb2e846b82f', '2017-02-26 18:03:40', '2017-02-26 18:03:40.0078', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/subjects/list', '[科目管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('b4c9af417cd74082aac342411e1db5a0', '2017-02-26 20:40:20', '2017-02-26 20:40:20.0062', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/testpaperinfo/list', '[试题管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('b63a71e8686e43fda85ddb52d20b031a', '2017-02-26 21:26:59', '2017-02-26 21:26:59.0962', null, 'admin', 'admin', '9a68d67f-8ea3-4317-b919-f33b155cb77e', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('b70b0ed673fc474082cd09d915f88c65', '2017-02-26 18:01:57', '2017-02-26 18:01:57.0800', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('b80c08b60eda458a9592607c893d3682', '2017-02-26 21:26:59', '2017-02-26 21:26:59.0785', null, 'admin', 'admin', '9a68d67f-8ea3-4317-b919-f33b155cb77e', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('b8366bc38f7e47efa47140abe332329b', '2017-02-26 20:40:00', '2017-02-26 20:40:00.0057', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/index', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('b8bc659bd1284730a8755737edf6f0bf', '2017-02-26 17:53:31', '2017-02-26 17:53:31.0767', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('b96dbcb7c1cf48f087ee62482761617d', '2017-02-26 17:53:13', '2017-02-26 17:53:13.0803', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('bac8c783e173476884f5f54b30c25a1b', '2017-02-26 17:54:15', '2017-02-26 17:54:15.0718', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('bdc8e9f1a7404ee99db128ed9145d276', '2017-02-26 18:00:05', '2017-02-26 18:00:05.0709', null, 'admin', 'admin', '13b2de81-4c59-4533-8c52-0e49f0d0e082', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', null, '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('be68154367734777b0dbfcf0b6df8665', '2017-02-26 17:44:15', '2017-02-26 17:44:15.0552', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/topictype/list', '[题型管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('bfe0ac27f26c4f16a9c70fed59eac6df', '2017-02-26 17:52:14', '2017-02-26 17:52:14.0681', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('c0c592d507ef4c8d8ce29286a0fbc171', '2017-02-26 17:54:21', '2017-02-26 17:54:21.0823', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('c1433db028b6423f89a30f8f9b2519dd', '2017-02-26 17:54:02', '2017-02-26 17:54:02.0743', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('c21e06758fbd4b43985f326b74cbdbde', '2017-02-26 17:44:11', '2017-02-26 17:44:11.0440', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/testrecord/list', '[考试记录查看]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('c605f1c23dd348caaac72d0653f0e9b2', '2017-02-26 18:03:54', '2017-02-26 18:03:54.0636', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/testpaperinfo/list', '[试题管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('c60ce42730524db4a0037c75349ea239', '2017-02-26 17:54:58', '2017-02-26 17:54:58.0163', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('c69acdcdc07e4eb1b3ed8594af0b20df', '2017-02-26 17:43:52', '2017-02-26 17:43:52.0986', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/role/list', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('c76daff9a0074843b782ec693cc8b975', '2017-02-26 17:54:57', '2017-02-26 17:54:57.0956', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('ca3c422576504429910c07605bbb945f', '2017-02-26 17:53:34', '2017-02-26 17:53:34.0478', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/update', '[修改菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('ca427cfd3b9446d084cd9dbc4d73215f', '2017-02-26 21:27:22', '2017-02-26 21:27:22.0557', null, 'admin', 'admin', '9a68d67f-8ea3-4317-b919-f33b155cb77e', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('cda549086bfa4ff8bfd577761a35dc08', '2017-02-26 17:53:12', '2017-02-26 17:53:12.0629', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('cf164293e90d42d58b192862a88f94be', '2017-02-26 17:53:39', '2017-02-26 17:53:39.0054', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('d21a93e72df240c6b32b5fccf2a7bc12', '2017-02-26 17:43:55', '2017-02-26 17:43:55.0894', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/dicdata/grade/list/json', '[级别管理]', '否');
INSERT INTO `t_fwlog_history_2017` VALUES ('d46af5d6569e4b9d99c5d6ae4c0ef7df', '2017-02-26 18:03:20', '2017-02-26 18:03:20.0124', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/user/update', '[修改用户]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('d5370ca05e7245beab87a7aad7705327', '2017-02-26 17:52:37', '2017-02-26 17:52:37.0434', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('d58f9e26929d4698893276ec28d86693', '2017-02-26 17:53:24', '2017-02-26 17:53:24.0001', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('d81e59bbb0a2413695613cad0f2ce05c', '2017-02-26 18:02:18', '2017-02-26 18:02:18.0841', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/role/update', '[修改角色]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('d85c3023d1f74582a3329377c95846ae', '2017-02-26 21:25:22', '2017-02-26 21:25:22.0142', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('d8f6fca4cee34894a0d2f1d830b117d0', '2017-02-26 17:53:29', '2017-02-26 17:53:29.0121', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('dbb7839fde694927981c26e825645271', '2017-02-26 20:40:06', '2017-02-26 20:40:06.0738', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('dcdbf712e1e54b3ca0efefa2fcf9322e', '2017-02-26 17:53:16', '2017-02-26 17:53:16.0328', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/menu/delete', '[删除菜单]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('dfe5da32974e455c808abd973f631e2d', '2017-02-26 21:25:49', '2017-02-26 21:25:49.0084', null, 'lyf', '用户', '53bf8cd9-7f75-46bb-890a-abd3e8bc6f3e', '127.0.0.1', 'http://127.0.0.1/online/student/list', '[学生管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('e369fe231be54f8e9f771c3b935132fb', '2017-02-26 17:43:59', '2017-02-26 17:43:59.0351', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('e395a5b6714f4174ba8d15e65019eb57', '2017-02-26 18:03:38', '2017-02-26 18:03:38.0571', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('e45bbaf3d13c414d9411df2b42c16c84', '2017-02-26 20:40:45', '2017-02-26 20:40:45.0467', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/testpaper/list', '[试卷管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('e621ccb5c1714f76889a19eaec67bcb5', '2017-02-26 18:02:23', '2017-02-26 18:02:23.0794', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/user/list', '[用户管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('e6e5fc5c9183407988406002103de728', '2017-02-26 20:40:09', '2017-02-26 20:40:09.0843', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/testpaper/update/pre', '[试卷修改]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('e75abbcd62264b2e90980f46a3e66c30', '2017-02-26 20:40:05', '2017-02-26 20:40:05.0822', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/topictype/list', '[题型管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('e9b6e26efa4341aaaac8a94fc950cfa5', '2017-02-26 18:04:01', '2017-02-26 18:04:01.0042', null, 'lyf', '用户', 'fed3f40c-68e1-49d8-af82-ad9ea43feffb', '127.0.0.1', 'http://127.0.0.1/online/testpaperinfo/update/pre', '[试题添加]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('ec49a98f1bc74dd69100e8638007c976', '2017-02-26 20:40:48', '2017-02-26 20:40:48.0052', null, 'lyf', '用户', '2ee27534-4205-4b8f-986c-25b86024f651', '127.0.0.1', 'http://127.0.0.1/online/testpaper/update/pre', '[试卷修改]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('ef32fa4bbc8745e4bbb9a0ddc00a1cb6', '2017-02-26 17:44:08', '2017-02-26 17:44:08.0273', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/testpaperinfo/list', '[试题管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('f3d5e68f868b4ad5ba002732d57b9f1f', '2017-02-26 17:44:04', '2017-02-26 17:44:04.0179', null, 'admin', 'admin', '4b566c8a-5bde-4a02-8784-22901ba37e35', '127.0.0.1', 'http://127.0.0.1/online/topictype/list', '[题型管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('f4a0e3db7fa04d5392182164bfb90d9b', '2017-02-26 18:00:05', '2017-02-26 18:00:05.0710', null, 'admin', 'admin', '13b2de81-4c59-4533-8c52-0e49f0d0e082', '127.0.0.1', 'http://127.0.0.1/online/system/role/list/json', '[角色管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('fc2c9f47738b404a95685224b8d4fc39', '2017-02-26 18:02:12', '2017-02-26 18:02:12.0688', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/system/menu/list/json', '[菜单管理]', '是');
INSERT INTO `t_fwlog_history_2017` VALUES ('fff71c7962f045ee9529ca88145857a7', '2017-02-26 18:03:23', '2017-02-26 18:03:23.0519', null, 'admin', 'admin', '85bb1c62-05fc-4ab3-8fa3-84605ea83776', '127.0.0.1', 'http://127.0.0.1/online/subjects/list', '[科目管理]', '是');

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `id` varchar(40) NOT NULL,
  `name` varchar(60) default NULL,
  `pid` varchar(40) default NULL,
  `description` varchar(2000) default NULL COMMENT '描述',
  `pageurl` varchar(3000) default NULL,
  `type` int(11) default NULL COMMENT '0.功能按钮,1.导航菜单',
  `state` varchar(2) default '是' COMMENT '是否有效',
  `sort` int(11) default NULL,
  `icon` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('02426ce2684649b7b36a1dc761d77c86', '试题添加', '0adc2ddc16aa4d469e8fe01283b0f7bf', '', '/testpaperinfo/update', '0', '是', '5', '');
INSERT INTO `t_menu` VALUES ('03143042900d4e568bcbf0470db9b8f2', '题型管理', 'business_manager', '', '/topictype/list', '1', '是', '4', '');
INSERT INTO `t_menu` VALUES ('0adc2ddc16aa4d469e8fe01283b0f7bf', '试卷管理', 'business_manager', '', '/testpaper/list', '1', '是', '5', '');
INSERT INTO `t_menu` VALUES ('13590171f00747c0ba8c6434f9489105', '题型修改', '03143042900d4e568bcbf0470db9b8f2', '', '/topictype/update', '0', '是', '4', '');
INSERT INTO `t_menu` VALUES ('33999e81827e43c1b863e884c0f4ed1a', '题型导出', '03143042900d4e568bcbf0470db9b8f2', '', '/topictype/list/export', '0', '是', '4', '');
INSERT INTO `t_menu` VALUES ('34abd0ae276647d79476a9ad162c8588', '科目导出', '451dd30483e34a18b6258c4a8a7bd72f', '', '/subjects/list/export', '0', '是', null, '');
INSERT INTO `t_menu` VALUES ('44a1b903eb8848e5964e8937db7700cc', '试卷修改', '0adc2ddc16aa4d469e8fe01283b0f7bf', '', '/testpaper/update', '0', '是', '5', '');
INSERT INTO `t_menu` VALUES ('451dd30483e34a18b6258c4a8a7bd72f', '科目管理', 'business_manager', '', '/subjects/list', '1', '是', '3', '');
INSERT INTO `t_menu` VALUES ('466e0acb0b8846048a6ace7e64200d3b', '学生删除', '5ebb7cc381124ce7a5bdd80a0ce616da', '', '/student/delete', '0', '是', '5', '');
INSERT INTO `t_menu` VALUES ('49e81fc125c14978b0fe3017a082fff0', '考试记录详情', '6cdc9507b8a44d2b8ceb4c22d7d27d44', '', '/testrecordinfo/list', '0', '是', '8', '');
INSERT INTO `t_menu` VALUES ('5c9c49b9cccb4726bdbe69b43f0534f8', '学生导出', '5ebb7cc381124ce7a5bdd80a0ce616da', '', '/student/list/export', '0', '是', '5', '');
INSERT INTO `t_menu` VALUES ('5ebb7cc381124ce7a5bdd80a0ce616da', '学生管理', 'business_manager', '', '/student/list', '1', '是', '5', '');
INSERT INTO `t_menu` VALUES ('63925fae69394290bf11b2ffb216b7c3', '试卷导出', '0adc2ddc16aa4d469e8fe01283b0f7bf', '', '/testpaper/list/export', '0', '是', '5', '');
INSERT INTO `t_menu` VALUES ('6cdc9507b8a44d2b8ceb4c22d7d27d44', '考试记录查看', 'business_manager', '', '/testrecord/list', '1', '是', '5', '');
INSERT INTO `t_menu` VALUES ('6e2e9480f4f64c0786c2ecb46c230d42', '试题删除', '0adc2ddc16aa4d469e8fe01283b0f7bf', '', '/testpaperinfo/delete', '0', '是', '5', '');
INSERT INTO `t_menu` VALUES ('875bf86f60bc4e9e898ffb9d1f9c461b', '试题打印', '0adc2ddc16aa4d469e8fe01283b0f7bf', '', '/testpaperinfo/print', '0', '是', '5', '');
INSERT INTO `t_menu` VALUES ('a88501ed7ca8492889485df8021556c0', '科目删除', '451dd30483e34a18b6258c4a8a7bd72f', '', '/subjects/delete', '0', '是', null, '');
INSERT INTO `t_menu` VALUES ('ac44e2c8cb774b71aab27c6c8c15b2e8', '题型删除', '03143042900d4e568bcbf0470db9b8f2', '', '/topictype/delete', '0', '是', '4', '');
INSERT INTO `t_menu` VALUES ('business_manager', '业务管理', null, '', null, '1', '是', '2', '');
INSERT INTO `t_menu` VALUES ('d1f98a5d89654aa4a9844b46e5c73573', '试卷删除', '0adc2ddc16aa4d469e8fe01283b0f7bf', '', '/testpaper/delete', '0', '是', '5', '');
INSERT INTO `t_menu` VALUES ('eb373b1c5cea413ba57f1d1b95743e94', '试题管理', '0adc2ddc16aa4d469e8fe01283b0f7bf', '', '/testpaperinfo/list', '0', '是', '5', '');
INSERT INTO `t_menu` VALUES ('f0fcfe6718ff4a54bd3b4decdbe31888', '学生修改', '5ebb7cc381124ce7a5bdd80a0ce616da', '', '/student/update', '0', '是', '5', '');
INSERT INTO `t_menu` VALUES ('f13dfa52ba7d4261832f56691a53162a', '科目修改', '451dd30483e34a18b6258c4a8a7bd72f', '', '/subjects/update', '0', '是', '3', '');
INSERT INTO `t_menu` VALUES ('system_manager', '系统管理', null, '', null, '1', '是', '1', '');
INSERT INTO `t_menu` VALUES ('t_auditlog_list', '修改日志', 'system_manager', null, '/system/auditlog/list', '1', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_auditlog_look', '查看修改日志', 't_auditlog_list', null, '/system/auditlog/look', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_fwlog_list', '访问日志', 'system_manager', null, '/system/fwlog/list', '1', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_fwlog_look', '查看访问日志', 't_fwlog_list', null, '/system/fwlog/look', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_menu_delete', '删除菜单', 't_menu_list', null, '/system/menu/delete', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_menu_deletemore', '批量删除菜单', 't_menu_list', null, '/system/menu/delete/more', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_menu_list', '菜单管理', 'system_manager', null, '/system/menu/list', '1', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_menu_look', '查看菜单', 't_menu_list', null, '/system/menu/look', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_menu_tree', '菜单树形结构', 't_menu_list', null, '/system/menu/tree', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_menu_update', '修改菜单', 't_menu_list', null, '/system/menu/update', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_role_delete', '删除角色', 't_role_list', null, '/system/role/delete', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_role_deletemore', '批量删除角色', 't_role_list', null, '/system/role/delete/more', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_role_list', '角色管理', 'system_manager', '', '/system/role/list', '1', '是', null, '');
INSERT INTO `t_menu` VALUES ('t_role_look', '查看角色', 't_role_list', null, '/system/role/look', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_role_update', '修改角色', 't_role_list', null, '/system/role/update', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_user_delete', '删除用户', 't_user_list', null, '/system/user/delete', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_user_deletemore', '批量删除用户', 't_user_list', null, '/system/user/delete/more', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_user_list', '用户管理', 'business_manager', null, '/system/user/list', '1', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_user_list_export', '导出用户', 't_user_list', null, '/system/user/list/export', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_user_look', '查看用户', 't_user_list', null, '/system/user/look', '0', '是', null, null);
INSERT INTO `t_menu` VALUES ('t_user_update', '修改用户', 't_user_list', null, '/system/user/update', '0', '是', null, null);

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` varchar(40) NOT NULL COMMENT '角色ID',
  `name` varchar(60) default NULL COMMENT '角色名称',
  `code` varchar(255) default NULL COMMENT '权限编码',
  `pid` varchar(40) default NULL COMMENT '上级角色ID',
  `remark` varchar(255) default NULL COMMENT '备注',
  `state` varchar(2) default '是' COMMENT '是否有效(否/是)',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('admin', '管理员', null, null, '', '是');
INSERT INTO `t_role` VALUES ('f573ea99c42347cf88a1b6117a9265ea', '用户', null, null, '', '是');

-- ----------------------------
-- Table structure for `t_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `roleId` varchar(40) NOT NULL COMMENT '角色编号',
  `menuId` varchar(40) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY  (`id`),
  KEY `fk_t_role_menu_roleId_t_role_id` (`roleId`),
  KEY `fk_t_role_menu_menuId_t_menu_id` (`menuId`),
  CONSTRAINT `fk_t_role_menu_menuId_t_menu_id` FOREIGN KEY (`menuId`) REFERENCES `t_menu` (`id`),
  CONSTRAINT `fk_t_role_menu_roleId_t_role_id` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单中间表';

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES ('00e749bd036146948bd87b5f435af67f', 'admin', '34abd0ae276647d79476a9ad162c8588');
INSERT INTO `t_role_menu` VALUES ('033d3863068044e3862ef3d2988ed472', 'f573ea99c42347cf88a1b6117a9265ea', '466e0acb0b8846048a6ace7e64200d3b');
INSERT INTO `t_role_menu` VALUES ('042a56a8c4f44a3692fdbf9fa7237d4d', 'admin', '5c9c49b9cccb4726bdbe69b43f0534f8');
INSERT INTO `t_role_menu` VALUES ('0b7dfdbb29004753889ed108be9fc0ae', 'admin', 'd1f98a5d89654aa4a9844b46e5c73573');
INSERT INTO `t_role_menu` VALUES ('0d15a2ad3fc84b4f9204633ac6b33879', 'f573ea99c42347cf88a1b6117a9265ea', 't_user_look');
INSERT INTO `t_role_menu` VALUES ('0dad7ff486764db79738eaf2d28f5d85', 'admin', '0adc2ddc16aa4d469e8fe01283b0f7bf');
INSERT INTO `t_role_menu` VALUES ('10da05c805bb47948912b57da7760029', 'f573ea99c42347cf88a1b6117a9265ea', '13590171f00747c0ba8c6434f9489105');
INSERT INTO `t_role_menu` VALUES ('223b4681d6a840299da96d2b8eb93d1d', 'admin', 't_user_delete');
INSERT INTO `t_role_menu` VALUES ('23f6b8d8a2d24c9db0e5f90c540f0d70', 'f573ea99c42347cf88a1b6117a9265ea', '451dd30483e34a18b6258c4a8a7bd72f');
INSERT INTO `t_role_menu` VALUES ('311df73e73b04690b8069f8e44e35f8d', 'f573ea99c42347cf88a1b6117a9265ea', '6e2e9480f4f64c0786c2ecb46c230d42');
INSERT INTO `t_role_menu` VALUES ('33fb0a31a73b4594867d409a313904c2', 'admin', 't_role_deletemore');
INSERT INTO `t_role_menu` VALUES ('3f2e80f6082f438c91e6ed280280a0aa', 'admin', 't_menu_deletemore');
INSERT INTO `t_role_menu` VALUES ('4504dfd08a3140109554544fd72c9cd9', 'f573ea99c42347cf88a1b6117a9265ea', '49e81fc125c14978b0fe3017a082fff0');
INSERT INTO `t_role_menu` VALUES ('48e3fcaf17274741a55eba4539fdd2e5', 'admin', 't_user_look');
INSERT INTO `t_role_menu` VALUES ('4972ac4730ce4f1a97b48ca1054a14e7', 'f573ea99c42347cf88a1b6117a9265ea', '0adc2ddc16aa4d469e8fe01283b0f7bf');
INSERT INTO `t_role_menu` VALUES ('4f72c1be2bd047439b0c7b6db1c8141c', 'f573ea99c42347cf88a1b6117a9265ea', 't_user_list_export');
INSERT INTO `t_role_menu` VALUES ('50fc15c24b6b412d978051c74c5c9a7f', 'admin', 't_menu_update');
INSERT INTO `t_role_menu` VALUES ('515fd1f79ae645e1a2b92798b0a917c0', 'admin', '44a1b903eb8848e5964e8937db7700cc');
INSERT INTO `t_role_menu` VALUES ('51cf5b5179ad44148df8efcfb03767a8', 'f573ea99c42347cf88a1b6117a9265ea', 'f13dfa52ba7d4261832f56691a53162a');
INSERT INTO `t_role_menu` VALUES ('539a8ccd9bc7438da12e11cee3c93780', 'admin', '02426ce2684649b7b36a1dc761d77c86');
INSERT INTO `t_role_menu` VALUES ('569513fa8a8e412ea1246c5125028457', 'admin', '03143042900d4e568bcbf0470db9b8f2');
INSERT INTO `t_role_menu` VALUES ('5bbe36693e1e45c6ac616284d2c9fe69', 'f573ea99c42347cf88a1b6117a9265ea', 'a88501ed7ca8492889485df8021556c0');
INSERT INTO `t_role_menu` VALUES ('5df5919bb9ff4131a34115ea921a270c', 'admin', '451dd30483e34a18b6258c4a8a7bd72f');
INSERT INTO `t_role_menu` VALUES ('613d7eb2d50b43f4836ce71ace78182f', 'admin', 'eb373b1c5cea413ba57f1d1b95743e94');
INSERT INTO `t_role_menu` VALUES ('633dd27999f646db86cd1a9142c7edc8', 'admin', 'business_manager');
INSERT INTO `t_role_menu` VALUES ('659e8fe12b3d49579363c295398dbf5c', 'f573ea99c42347cf88a1b6117a9265ea', '03143042900d4e568bcbf0470db9b8f2');
INSERT INTO `t_role_menu` VALUES ('6cc9098e3e2546c9ae8adaa852d535e0', 'admin', 't_user_update');
INSERT INTO `t_role_menu` VALUES ('706e417e61ed4e61b2d2ae34a400b867', 'admin', '6cdc9507b8a44d2b8ceb4c22d7d27d44');
INSERT INTO `t_role_menu` VALUES ('709ee17d856242d4bbc912e6b34ec50c', 'admin', 't_role_update');
INSERT INTO `t_role_menu` VALUES ('725f9792317046c9a8d4f93e408832aa', 'f573ea99c42347cf88a1b6117a9265ea', 't_user_deletemore');
INSERT INTO `t_role_menu` VALUES ('781ae991e45240d799ee5488f03d382e', 'admin', 't_role_look');
INSERT INTO `t_role_menu` VALUES ('787af5aa3acf418fa31f4b301f5920ee', 'admin', 'system_manager');
INSERT INTO `t_role_menu` VALUES ('7f99a6756f0e40888fe06596425c4c67', 'admin', 'a88501ed7ca8492889485df8021556c0');
INSERT INTO `t_role_menu` VALUES ('81cc420ac9f847ba8dded8c676b71660', 'f573ea99c42347cf88a1b6117a9265ea', '33999e81827e43c1b863e884c0f4ed1a');
INSERT INTO `t_role_menu` VALUES ('841be407cb9f41d69d6ee2850e4939f8', 'admin', 't_user_deletemore');
INSERT INTO `t_role_menu` VALUES ('854f3f7a535f4cec99b504a3954721ea', 'f573ea99c42347cf88a1b6117a9265ea', '875bf86f60bc4e9e898ffb9d1f9c461b');
INSERT INTO `t_role_menu` VALUES ('863650b258154b9a94ac48d0ea88ee2d', 'f573ea99c42347cf88a1b6117a9265ea', 'f0fcfe6718ff4a54bd3b4decdbe31888');
INSERT INTO `t_role_menu` VALUES ('888619ce441246569fc44bddcb161e76', 'admin', 't_menu_tree');
INSERT INTO `t_role_menu` VALUES ('8abd96ffc57a4b03aa996d89a91badfe', 'admin', '49e81fc125c14978b0fe3017a082fff0');
INSERT INTO `t_role_menu` VALUES ('8b0dc1ecdcc04e5da5496b631895ff00', 'admin', 'ac44e2c8cb774b71aab27c6c8c15b2e8');
INSERT INTO `t_role_menu` VALUES ('8bdd0bf73544431a8587660db6a08053', 'f573ea99c42347cf88a1b6117a9265ea', 't_user_list');
INSERT INTO `t_role_menu` VALUES ('9699120553a64f578631d7ce4a457dd6', 'admin', 't_menu_delete');
INSERT INTO `t_role_menu` VALUES ('989ef0d559994d3db521f548325573d1', 'admin', 't_user_list_export');
INSERT INTO `t_role_menu` VALUES ('9a0283bae72d4b08aa3d11a24bfc998a', 'admin', '875bf86f60bc4e9e898ffb9d1f9c461b');
INSERT INTO `t_role_menu` VALUES ('9f81c6abf3494eb591acfc35975ce3f2', 'admin', '13590171f00747c0ba8c6434f9489105');
INSERT INTO `t_role_menu` VALUES ('a16361573fb34ec6a074a6ac75b006bf', 'admin', '5ebb7cc381124ce7a5bdd80a0ce616da');
INSERT INTO `t_role_menu` VALUES ('ae6bd00930044d328554f7a299a6cd25', 'f573ea99c42347cf88a1b6117a9265ea', 't_user_delete');
INSERT INTO `t_role_menu` VALUES ('af237d46e1f04d95a1b3733180218eb2', 'f573ea99c42347cf88a1b6117a9265ea', '6cdc9507b8a44d2b8ceb4c22d7d27d44');
INSERT INTO `t_role_menu` VALUES ('b5a4f9bb3cbf42c7be220a01e95b028b', 'admin', '466e0acb0b8846048a6ace7e64200d3b');
INSERT INTO `t_role_menu` VALUES ('b6041e63687244d1b52b2d70e9f829c8', 'f573ea99c42347cf88a1b6117a9265ea', 'business_manager');
INSERT INTO `t_role_menu` VALUES ('bb920b3d15694f85a354c547432325a7', 'admin', 't_menu_look');
INSERT INTO `t_role_menu` VALUES ('c349ba0c8deb43d9bc6c47d9504a6a87', 'f573ea99c42347cf88a1b6117a9265ea', 'd1f98a5d89654aa4a9844b46e5c73573');
INSERT INTO `t_role_menu` VALUES ('c625f0c478d24e82852db17411c82a58', 'f573ea99c42347cf88a1b6117a9265ea', '34abd0ae276647d79476a9ad162c8588');
INSERT INTO `t_role_menu` VALUES ('c70077e2a85e4472b3ab4d811a63132f', 'f573ea99c42347cf88a1b6117a9265ea', '44a1b903eb8848e5964e8937db7700cc');
INSERT INTO `t_role_menu` VALUES ('cd9ac3e12ff443ea9e1a5ae1b91be02e', 'admin', '33999e81827e43c1b863e884c0f4ed1a');
INSERT INTO `t_role_menu` VALUES ('d0a47dba07b446b2a5a2d5a2e01cf903', 'f573ea99c42347cf88a1b6117a9265ea', '02426ce2684649b7b36a1dc761d77c86');
INSERT INTO `t_role_menu` VALUES ('d57f58414c3745d29cc5e0b5a4d4b22d', 'admin', 't_role_delete');
INSERT INTO `t_role_menu` VALUES ('d5e89104df94479991c1a6df11bdedf9', 'f573ea99c42347cf88a1b6117a9265ea', 't_user_update');
INSERT INTO `t_role_menu` VALUES ('d8967412cad84f79b4a6df154e8d3c66', 'admin', 't_role_list');
INSERT INTO `t_role_menu` VALUES ('ddc957d69f184a89bdccf100ab2ac8e5', 'f573ea99c42347cf88a1b6117a9265ea', '63925fae69394290bf11b2ffb216b7c3');
INSERT INTO `t_role_menu` VALUES ('e2a44716d00343d09adc48f43bea737b', 'f573ea99c42347cf88a1b6117a9265ea', '5c9c49b9cccb4726bdbe69b43f0534f8');
INSERT INTO `t_role_menu` VALUES ('e6791fda0d2540468a058c4ade448b39', 'admin', 't_menu_list');
INSERT INTO `t_role_menu` VALUES ('e7e2c67fff9942a8a3cf2fe9cb1c75bc', 'admin', 'f13dfa52ba7d4261832f56691a53162a');
INSERT INTO `t_role_menu` VALUES ('e9f70657788e4a0fb371db870a19e723', 'admin', '63925fae69394290bf11b2ffb216b7c3');
INSERT INTO `t_role_menu` VALUES ('ea17ed70198d48f39c052ef5aae27bfb', 'admin', 'f0fcfe6718ff4a54bd3b4decdbe31888');
INSERT INTO `t_role_menu` VALUES ('ee5e4f58ade64bceb6ec6f581da4b040', 'admin', '6e2e9480f4f64c0786c2ecb46c230d42');
INSERT INTO `t_role_menu` VALUES ('f6d0150205e84869b949ec622dd1d12c', 'f573ea99c42347cf88a1b6117a9265ea', 'ac44e2c8cb774b71aab27c6c8c15b2e8');
INSERT INTO `t_role_menu` VALUES ('f995553f33c34fd5807caac0c48b637c', 'f573ea99c42347cf88a1b6117a9265ea', 'eb373b1c5cea413ba57f1d1b95743e94');
INSERT INTO `t_role_menu` VALUES ('fb00814ec498431881755248cd215213', 'f573ea99c42347cf88a1b6117a9265ea', '5ebb7cc381124ce7a5bdd80a0ce616da');
INSERT INTO `t_role_menu` VALUES ('fd37a88119b84b90996976b21205fcc9', 'admin', 't_user_list');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `name` varchar(30) default NULL COMMENT '姓名',
  `account` varchar(40) default NULL COMMENT '账号',
  `password` varchar(40) default NULL COMMENT '密码',
  `sex` varchar(2) default '男' COMMENT '性别',
  `mobile` varchar(16) default NULL COMMENT '手机号码',
  `email` varchar(60) default NULL COMMENT '邮箱',
  `weixinId` varchar(200) default NULL COMMENT '微信Id',
  `userType` int(11) default '0',
  `state` varchar(10) default '是' COMMENT '是否有效,是/否',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('admin', 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3', '男', null, null, null, '0', '是');
INSERT INTO `t_user` VALUES ('be86af5e5aa248529115ca2e6e5b894d', '用户', 'lyf', 'e10adc3949ba59abbe56e057f20f883e', '男', '', '', null, null, '是');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` varchar(40) NOT NULL COMMENT '编号',
  `userId` varchar(40) NOT NULL COMMENT '用户编号',
  `roleId` varchar(40) NOT NULL COMMENT '角色编号',
  PRIMARY KEY  (`id`),
  KEY `fk_t_user_role_userId_t_user_id` (`userId`),
  KEY `fk_t_user_role_roleId_t_role_id` (`roleId`),
  CONSTRAINT `fk_t_user_role_roleId_t_role_id` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`),
  CONSTRAINT `fk_t_user_role_userId_t_user_id` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('admin_admin', 'admin', 'admin');
INSERT INTO `t_user_role` VALUES ('b415d87c31a14a729e410e5d62359298', 'be86af5e5aa248529115ca2e6e5b894d', 'f573ea99c42347cf88a1b6117a9265ea');
