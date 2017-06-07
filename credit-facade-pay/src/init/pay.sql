/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : credit_pay

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-02-17 14:34:42
*/

SET FOREIGN_KEY_CHECKS=0;

drop database if EXISTS `credit_pay`;
create database `credit_pay`;
use `credit_pay`;

-- ----------------------------
-- Table structure for pay_history
-- ----------------------------
DROP TABLE IF EXISTS `pay_history`;
CREATE TABLE `pay_history` (
  `id` BIGINT unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `app_name` TINYINT NOT NULL COMMENT '支付来源',
  `userCode` varchar(50) DEFAULT NULL COMMENT '用户编号',
  `order_no` varchar(50) NOT NULL COMMENT '订单编号',
   order_type TINYINT NOT NULL DEFAULT '0' COMMENT '订单类型',
  `title` varchar(100) NOT NULL COMMENT '标题',
  `currency` VARCHAR(3) NOT NULL DEFAULT 'CNY',
  `amount` DECIMAL(11,2) NOT NULL COMMENT '金额',
  `des` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `pay_method` TINYINT unsigned NOT NULL COMMENT '1-支付宝 2-微信',
  `pay_account` varchar(200) DEFAULT NULL COMMENT '支付账号',
  `code_url` varchar(200) DEFAULT NULL COMMENT '微信二维码连接',
  `expire_time` datetime DEFAULT NULL COMMENT '失效时间',
  `pay_status` TINYINT DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT 'id',
  `amount` DECIMAL(11,2) NOT NULL COMMENT '金额',
  `currency` VARCHAR(3) NOT NULL DEFAULT 'CNY',
  `pay_method` TINYINT unsigned NOT NULL COMMENT '1-支付宝 2-微信',
  `status` TINYINT DEFAULT NULL COMMENT '状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `customer_id` BIGINT NOT NULL COMMENT '客户id',
  `customer_name` varchar(50) NOT NULL COMMENT '客户名称',
  `manager_id` BIGINT DEFAULT NULL COMMENT '管理员id',
  `manager_name` varchar(50) NOT NULL COMMENT '管理员名称',
  `reward_amount` DECIMAL(11,2) DEFAULT NULL COMMENT '奖励金额',
  `no` varchar(50) NOT NULL COMMENT '充值编号',
  `app_name` TINYINT NOT NULL COMMENT '充值来源',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充值信息';

