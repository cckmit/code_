/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.185
Source Server Version : 50635
Source Host           : 192.168.1.185:3306
Source Database       : credit_verify

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-05-08 14:30:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for mobilephone_name
-- ----------------------------
DROP TABLE IF EXISTS `mobilephone_name`;
CREATE TABLE `mobilephone_name` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correct_person_name` varchar(600) DEFAULT NULL COMMENT '修正人名',
  `del_flag` varchar(6) DEFAULT NULL,
  `note` varchar(400) DEFAULT NULL,
  `person_name` varchar(150) DEFAULT NULL,
  `phone` varchar(150) DEFAULT NULL,
  `source_flag` varchar(6) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `time_score` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mobilephone_name
-- ----------------------------

-- ----------------------------
-- Table structure for telephone_companyname
-- ----------------------------
DROP TABLE IF EXISTS `telephone_companyname`;
CREATE TABLE `telephone_companyname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_code` varchar(30) DEFAULT NULL,
  `company_name` varchar(150) DEFAULT NULL,
  `correct_name` varchar(600) DEFAULT NULL,
  `del_flag` varchar(6) DEFAULT NULL,
  `note` varchar(400) DEFAULT NULL,
  `source_flag` varchar(6) DEFAULT NULL,
  `tel` varchar(150) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of telephone_companyname
-- ----------------------------
