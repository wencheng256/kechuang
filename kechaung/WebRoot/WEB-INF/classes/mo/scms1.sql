/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : scms1

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-05-09 18:40:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tc_account
-- ----------------------------
DROP TABLE IF EXISTS `tc_account`;
CREATE TABLE `tc_account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `project` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_account_01` (`project`),
  KEY `ind` (`username`,`password`),
  CONSTRAINT `fk_account_01` FOREIGN KEY (`project`) REFERENCES `tc_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc_account
-- ----------------------------
INSERT INTO `tc_account` VALUES ('1', 'wencheng', '5833aa8a9a66dd0f760cc60c6b9c306b', '1');

-- ----------------------------
-- Table structure for tc_message
-- ----------------------------
DROP TABLE IF EXISTS `tc_message`;
CREATE TABLE `tc_message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `content` text COMMENT '站内信息内容',
  `time` datetime DEFAULT NULL COMMENT '发送时间',
  `sender` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '发信息人',
  `receiver` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '接收人',
  PRIMARY KEY (`id`),
  KEY `receiver` (`receiver`),
  KEY `message_ibfk_1` (`sender`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`sender`) REFERENCES `tc_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `message_ibfk_2` FOREIGN KEY (`receiver`) REFERENCES `tc_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc_message
-- ----------------------------
INSERT INTO `tc_message` VALUES ('1', 'hello', '2015-05-09 13:34:44', '1', '1');
INSERT INTO `tc_message` VALUES ('2', '111', '2015-05-09 14:29:25', '1', '1');
INSERT INTO `tc_message` VALUES ('3', '你好啊', '2015-05-09 14:29:30', '1', '1');
INSERT INTO `tc_message` VALUES ('4', '确实是！', '2015-05-09 14:29:35', '1', '1');
INSERT INTO `tc_message` VALUES ('5', '真棒邦达', '2015-05-09 14:29:41', '1', '1');
INSERT INTO `tc_message` VALUES ('6', '点赞支持！！！！！！！！！！！！！！！！！！！！！！！！！！！！！', '2015-05-09 14:29:51', '1', '1');
INSERT INTO `tc_message` VALUES ('7', '你好', '2015-05-09 14:30:13', '1', '1');
INSERT INTO `tc_message` VALUES ('8', '000', '2015-05-09 14:30:19', '1', '1');
INSERT INTO `tc_message` VALUES ('9', '000', '2015-05-09 14:32:12', '1', '1');
INSERT INTO `tc_message` VALUES ('10', '000', '2015-05-09 14:32:13', '1', '1');
INSERT INTO `tc_message` VALUES ('11', '000', '2015-05-09 14:32:13', '1', '1');
INSERT INTO `tc_message` VALUES ('12', '000', '2015-05-09 14:32:34', '1', '1');
INSERT INTO `tc_message` VALUES ('13', '000', '2015-05-09 14:32:36', '1', '1');
INSERT INTO `tc_message` VALUES ('14', '000', '2015-05-09 14:32:37', '1', '1');
INSERT INTO `tc_message` VALUES ('15', '000', '2015-05-09 14:32:38', '1', '1');
INSERT INTO `tc_message` VALUES ('16', '000', '2015-05-09 14:32:38', '1', '1');
INSERT INTO `tc_message` VALUES ('17', '000', '2015-05-09 14:32:38', '1', '1');
INSERT INTO `tc_message` VALUES ('18', '000', '2015-05-09 14:33:09', '1', '1');
INSERT INTO `tc_message` VALUES ('19', '11', '2015-05-09 14:38:39', '1', '1');
INSERT INTO `tc_message` VALUES ('20', '11', '2015-05-09 14:38:50', '1', '1');
INSERT INTO `tc_message` VALUES ('21', '11', '2015-05-09 14:38:51', '1', '1');
INSERT INTO `tc_message` VALUES ('22', '11', '2015-05-09 14:38:52', '1', '1');
INSERT INTO `tc_message` VALUES ('23', '11', '2015-05-09 14:38:52', '1', '1');
INSERT INTO `tc_message` VALUES ('24', '11', '2015-05-09 14:38:54', '1', '1');
INSERT INTO `tc_message` VALUES ('25', '11', '2015-05-09 14:38:54', '1', '1');
INSERT INTO `tc_message` VALUES ('26', '22', '2015-05-09 14:39:45', '1', '1');
INSERT INTO `tc_message` VALUES ('27', '22', '2015-05-09 14:39:47', '1', '1');
INSERT INTO `tc_message` VALUES ('28', '22', '2015-05-09 14:39:47', '1', '1');
INSERT INTO `tc_message` VALUES ('29', '33', '2015-05-09 14:41:37', '1', '1');
INSERT INTO `tc_message` VALUES ('30', '2222', '2015-05-09 14:41:45', '1', '1');
INSERT INTO `tc_message` VALUES ('31', '33', '2015-05-09 14:55:17', '1', '1');
INSERT INTO `tc_message` VALUES ('32', '333', '2015-05-09 14:57:20', '1', '1');
INSERT INTO `tc_message` VALUES ('33', 'wewqeq', '2015-05-09 15:29:31', '1', '1');
INSERT INTO `tc_message` VALUES ('34', '33', '2015-05-09 18:34:30', '1', '1');

-- ----------------------------
-- Table structure for tc_project
-- ----------------------------
DROP TABLE IF EXISTS `tc_project`;
CREATE TABLE `tc_project` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `grade` int(11) NOT NULL DEFAULT '2011' COMMENT '届',
  `important` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否是重点项目',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '项目名称',
  `class` tinyint(4) unsigned NOT NULL DEFAULT '1' COMMENT '类别 E(1|A|A, 2|B|B,3|C|C,4|D|D)',
  `proj_permitid` varchar(20) NOT NULL COMMENT '项目编号',
  `school` int(10) unsigned NOT NULL COMMENT '学院',
  `apply_time` datetime NOT NULL COMMENT '申请时间',
  `progress` int(11) NOT NULL DEFAULT '0' COMMENT '进度',
  `rank` tinyint(4) NOT NULL DEFAULT '0' COMMENT '最终评级 E(0|NULL|无, 1|A|A, 2|B|B, 3|C|C, 4|D|D)',
  `status` tinyint(4) NOT NULL DEFAULT '4' COMMENT '项目状况 E(1|END|终止, 2|STAGNANT|停滞, 3|SLOW|迟缓, 4|SMOOTH|顺利, 5|AHEAD|超前)',
  `finish_time` datetime DEFAULT NULL COMMENT '结束时间',
  `warnning` int(11) NOT NULL DEFAULT '0' COMMENT '当前警告数',
  PRIMARY KEY (`id`),
  UNIQUE KEY `proj_permitid` (`proj_permitid`),
  KEY `fk_projerct_01` (`school`),
  KEY `ind` (`grade`),
  CONSTRAINT `fk_projerct_01` FOREIGN KEY (`school`) REFERENCES `tc_school` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc_project
-- ----------------------------
INSERT INTO `tc_project` VALUES ('1', '0', '0', '好项目2', '1', '201200800502', '1', '2015-05-07 13:23:30', '60', '0', '4', null, '0');
INSERT INTO `tc_project` VALUES ('2', '0', '0', '好项目1', '1', '201200800503', '1', '2015-05-07 13:24:22', '0', '0', '4', null, '0');

-- ----------------------------
-- Table structure for tc_project_application
-- ----------------------------
DROP TABLE IF EXISTS `tc_project_application`;
CREATE TABLE `tc_project_application` (
  `project_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `is_public` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否公开',
  `situation` text COMMENT '研究现状',
  `innovation` text COMMENT '需要解决的关键问题和创新点',
  `feasibility` text COMMENT '项目研究可行性分析',
  `reference` text COMMENT '参考文献',
  `research_context` text COMMENT '研究内容',
  `research_method` text COMMENT '研究方法',
  `schedule` text COMMENT '研究进度及安排',
  `achievement_modus` text COMMENT '预期研究成果及其展现形式',
  `equipment` text COMMENT '所需仪器设备',
  `come_from` text COMMENT '项目来源',
  `summary` text COMMENT '项目概要',
  `base` text COMMENT '研究基础',
  PRIMARY KEY (`project_id`),
  CONSTRAINT `pre_project_application_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `tc_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc_project_application
-- ----------------------------

-- ----------------------------
-- Table structure for tc_project_director
-- ----------------------------
DROP TABLE IF EXISTS `tc_project_director`;
CREATE TABLE `tc_project_director` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `phone` varchar(20) NOT NULL DEFAULT '0' COMMENT '手机号',
  `work` varchar(50) NOT NULL COMMENT '职位',
  `project` int(10) unsigned NOT NULL COMMENT '所属项目',
  `school` int(10) unsigned NOT NULL COMMENT '学院',
  PRIMARY KEY (`id`),
  KEY `fk_director_01` (`project`),
  KEY `fk_director_02` (`school`),
  CONSTRAINT `fk_director_01` FOREIGN KEY (`project`) REFERENCES `tc_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_director_02` FOREIGN KEY (`school`) REFERENCES `tc_school` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc_project_director
-- ----------------------------

-- ----------------------------
-- Table structure for tc_project_fare
-- ----------------------------
DROP TABLE IF EXISTS `tc_project_fare`;
CREATE TABLE `tc_project_fare` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project` int(10) unsigned NOT NULL COMMENT '项目',
  `reason` varchar(400) NOT NULL COMMENT '理由',
  `amount` double(11,0) NOT NULL DEFAULT '0' COMMENT '金额',
  PRIMARY KEY (`id`),
  KEY `fk_fare_01` (`project`),
  CONSTRAINT `fk_fare_01` FOREIGN KEY (`project`) REFERENCES `tc_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc_project_fare
-- ----------------------------
INSERT INTO `tc_project_fare` VALUES ('1', '1', 'eqwe', '200');
INSERT INTO `tc_project_fare` VALUES ('2', '1', 'dasdd', '2333');
INSERT INTO `tc_project_fare` VALUES ('3', '1', 'sad', '2');

-- ----------------------------
-- Table structure for tc_project_final_report
-- ----------------------------
DROP TABLE IF EXISTS `tc_project_final_report`;
CREATE TABLE `tc_project_final_report` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `project` int(10) unsigned NOT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `condition` text COMMENT '项目完成情况',
  `achievement` text COMMENT '研究成果',
  `thoughts` text COMMENT '感想体会',
  `expenses` text COMMENT '经费使用情况',
  `is_public` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否公开',
  PRIMARY KEY (`id`),
  KEY `ind` (`project`),
  CONSTRAINT `fk_report_01` FOREIGN KEY (`project`) REFERENCES `tc_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc_project_final_report
-- ----------------------------

-- ----------------------------
-- Table structure for tc_project_journal
-- ----------------------------
DROP TABLE IF EXISTS `tc_project_journal`;
CREATE TABLE `tc_project_journal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `project` int(10) unsigned NOT NULL COMMENT '项目编号',
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '标题',
  `time` datetime NOT NULL COMMENT '时间',
  `is_public` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否公开',
  `status` tinyint(4) NOT NULL DEFAULT '2' COMMENT '状态 E(0|DRAFT|草稿, 1|CHECKING|审核中, 2|PASS|审核通过, 3|TRASH|回收站)',
  `editor` int(10) unsigned NOT NULL DEFAULT '10' COMMENT '编辑人',
  `content` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `project` (`project`),
  KEY `pre_project_journal_ibfk_2` (`editor`),
  CONSTRAINT `pre_project_journal_ibfk_2` FOREIGN KEY (`editor`) REFERENCES `tc_student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tc_project_journal_ibfk_1` FOREIGN KEY (`project`) REFERENCES `tc_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc_project_journal
-- ----------------------------

-- ----------------------------
-- Table structure for tc_school
-- ----------------------------
DROP TABLE IF EXISTS `tc_school`;
CREATE TABLE `tc_school` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc_school
-- ----------------------------
INSERT INTO `tc_school` VALUES ('1', '机电与信息工程学院');

-- ----------------------------
-- Table structure for tc_student
-- ----------------------------
DROP TABLE IF EXISTS `tc_student`;
CREATE TABLE `tc_student` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `num` varchar(15) NOT NULL COMMENT '学号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `phone` varchar(20) NOT NULL DEFAULT '0' COMMENT '手机号',
  `degree` tinyint(4) NOT NULL DEFAULT '0' COMMENT '学历',
  `project` int(10) unsigned NOT NULL COMMENT '所属项目',
  `school` int(10) unsigned NOT NULL COMMENT '学院',
  `is_cap` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `num` (`num`),
  KEY `fk_student_01` (`project`),
  KEY `fk_userinfo_01` (`school`),
  CONSTRAINT `fk_student_01` FOREIGN KEY (`project`) REFERENCES `tc_project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_userinfo_01` FOREIGN KEY (`school`) REFERENCES `tc_school` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc_student
-- ----------------------------
INSERT INTO `tc_student` VALUES ('1', '201200800502', '韩文程', '605015344@qq.com', '18369189857', '0', '1', '1', '1');
INSERT INTO `tc_student` VALUES ('2', '201200800528', '王琨', '842295010@qq.com', '18369189872', '0', '1', '1', '0');
INSERT INTO `tc_student` VALUES ('3', '201200800497', '陈柏年', '2222@qq.com', '18369187557', '0', '1', '1', '0');
