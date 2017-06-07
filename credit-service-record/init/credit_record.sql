/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.185
Source Server Version : 50635
Source Host           : 192.168.1.185:3306
Source Database       : credit_record

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-06-06 11:17:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for company_track
-- ----------------------------
DROP TABLE IF EXISTS `company_track`;
CREATE TABLE `company_track` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name_cn` varchar(255) DEFAULT NULL COMMENT '公司中文名',
  `company_name_en` varchar(255) DEFAULT NULL COMMENT '公司英文名',
  `industry` text COMMENT '行业',
  `type` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_track
-- ----------------------------

-- ----------------------------
-- Table structure for customer_behavior
-- ----------------------------
DROP TABLE IF EXISTS `customer_behavior`;
CREATE TABLE `customer_behavior` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) DEFAULT NULL COMMENT '用户id',
  `ip` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `action` varchar(255) DEFAULT NULL COMMENT '行为',
  `time` datetime DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_behavior
-- ----------------------------

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `name_cn` varchar(255) DEFAULT NULL COMMENT '中文公司名',
  `name_en` varchar(255) DEFAULT NULL COMMENT '英文公司名',
  `source` varchar(20) DEFAULT NULL COMMENT '来源',
  `url` varchar(255) DEFAULT NULL COMMENT '访问url',
  `order_no` varchar(40) DEFAULT NULL COMMENT '订单号',
  `is_success` bit(1) DEFAULT NULL COMMENT '是否成功',
  `country_code` varchar(40) DEFAULT NULL COMMENT '国家代码',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for search_keyword
-- ----------------------------
DROP TABLE IF EXISTS `search_keyword`;
CREATE TABLE `search_keyword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keyword` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of search_keyword
-- ----------------------------
