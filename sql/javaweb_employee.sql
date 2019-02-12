/*
Navicat MySQL Data Transfer

Source Server         : 本地项目数据库(Maxcj)
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : javaweb_employee

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-02-12 16:40:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_applicant
-- ----------------------------
DROP TABLE IF EXISTS `tb_applicant`;
CREATE TABLE `tb_applicant` (
  `applicant_id` int(10) NOT NULL AUTO_INCREMENT,
  `applicant_email` varchar(20) NOT NULL,
  `applicant_pwd` varchar(20) NOT NULL,
  PRIMARY KEY (`applicant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_applicant
-- ----------------------------
INSERT INTO `tb_applicant` VALUES ('1', '903283542@qq.com', 'zxcv123456');
INSERT INTO `tb_applicant` VALUES ('2', '1@qq.com', 'zxcv123456');
INSERT INTO `tb_applicant` VALUES ('3', '2@qq.com', 'zxcv123456');

-- ----------------------------
-- Table structure for tb_info_basicinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_info_basicinfo`;
CREATE TABLE `tb_info_basicinfo` (
  `info_id` int(10) NOT NULL AUTO_INCREMENT,
  `age` int(10) DEFAULT NULL,
  `job` varchar(255) DEFAULT NULL,
  `experience` varchar(255) DEFAULT NULL,
  `applicant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`info_id`),
  KEY `applicant_id` (`applicant_id`),
  CONSTRAINT `applicant_id` FOREIGN KEY (`applicant_id`) REFERENCES `tb_applicant` (`applicant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_info_basicinfo
-- ----------------------------
INSERT INTO `tb_info_basicinfo` VALUES ('1', '20', 'C ', 'Less than one year', '2');
INSERT INTO `tb_info_basicinfo` VALUES ('2', '23', 'IOS ', 'More than three years', '3');

-- ----------------------------
-- Table structure for tb_message
-- ----------------------------
DROP TABLE IF EXISTS `tb_message`;
CREATE TABLE `tb_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_content` varchar(255) DEFAULT NULL,
  `notice_id` int(11) DEFAULT NULL,
  `applicant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`message_id`),
  KEY `applicant_id` (`applicant_id`),
  KEY `FK_tb_message_tb_notice` (`notice_id`),
  CONSTRAINT `FK_tb_message_tb_notice` FOREIGN KEY (`notice_id`) REFERENCES `tb_notice` (`notice_id`),
  CONSTRAINT `tb_message_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `tb_applicant` (`applicant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_message
-- ----------------------------

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice` (
  `notice_id` int(11) NOT NULL AUTO_INCREMENT,
  `notice_title` varchar(255) DEFAULT NULL,
  `notice_content` varchar(255) DEFAULT NULL,
  `notice_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_notice
-- ----------------------------
INSERT INTO `tb_notice` VALUES ('1', '6.01儿童节', '照常上班', '2018-06-01 10:09:08');

-- ----------------------------
-- Table structure for tb_resume_basicinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_resume_basicinfo`;
CREATE TABLE `tb_resume_basicinfo` (
  `basicinfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `applicant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`basicinfo_id`),
  KEY `applicant_id` (`applicant_id`),
  CONSTRAINT `tb_resume_basicinfo_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `tb_applicant` (`applicant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_resume_basicinfo
-- ----------------------------
INSERT INTO `tb_resume_basicinfo` VALUES ('1', 'Maxcj', '110', '1@qq.com', 'male', '2');
INSERT INTO `tb_resume_basicinfo` VALUES ('2', '李四', '620', '2@qq.com', 'female', '3');

-- ----------------------------
-- Table structure for tb_salary
-- ----------------------------
DROP TABLE IF EXISTS `tb_salary`;
CREATE TABLE `tb_salary` (
  `salary_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_salary` varchar(255) DEFAULT NULL,
  `attendance_salary` varchar(255) DEFAULT NULL,
  `bonus` varchar(255) DEFAULT NULL,
  `total_salary` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `applicant_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`salary_id`),
  KEY `applicant_id` (`applicant_id`),
  CONSTRAINT `tb_salary_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `tb_applicant` (`applicant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_salary
-- ----------------------------
