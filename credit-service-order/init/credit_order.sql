/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.185
Source Server Version : 50635
Source Host           : 192.168.1.185:3306
Source Database       : credit_order

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-05-09 12:25:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business_order
-- ----------------------------
DROP TABLE IF EXISTS `business_order`;
CREATE TABLE `business_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `no` varchar(20) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL COMMENT '订单状态',
  `product_id` int(11) DEFAULT NULL COMMENT '产品id',
  `country_code` varchar(2) DEFAULT NULL COMMENT '国家代码',
  `source` tinyint(4) DEFAULT NULL COMMENT '订单来源',
  `is_provider` bit(1) DEFAULT NULL COMMENT '是否提供数据',
  `crefo_no` varchar(20) DEFAULT NULL,
  `source_id` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `path_data` varchar(255) DEFAULT NULL COMMENT '数据路径',
  `expect_hour` int(3) DEFAULT NULL COMMENT '制作时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of business_order
-- ----------------------------

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '明细Id',
  `name` varchar(50) NOT NULL COMMENT '模块名',
  `enable` bit(1) DEFAULT b'0' COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('1', '财务', '');
INSERT INTO `module` VALUES ('2', '工商', '');
INSERT INTO `module` VALUES ('3', '诉讼', '');
INSERT INTO `module` VALUES ('4', '采访', '');
INSERT INTO `module` VALUES ('5', '新闻', '');
INSERT INTO `module` VALUES ('6', '资质', '');
INSERT INTO `module` VALUES ('7', '其他', '');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(11) DEFAULT NULL COMMENT '订单Id',
  `crefo_no` varchar(50) DEFAULT NULL,
  `company_name` varchar(200) NOT NULL COMMENT '公司名',
  `company_namecn` varchar(200) DEFAULT NULL COMMENT '公司名中文名',
  `company_no` varchar(30) DEFAULT NULL COMMENT '公司编号',
  `price` decimal(10,2) NOT NULL COMMENT '应付金额',
  `price_actual` decimal(10,2) NOT NULL COMMENT '实付金额',
  `product_id` int(11) DEFAULT NULL COMMENT '产品Id',
  `report_lang` tinyint(4) NOT NULL DEFAULT '1' COMMENT '报告语言 1：中文 2：英文',
  `status` tinyint(4) DEFAULT NULL COMMENT '明细状态: 1-待支付 2-调查中 3-待分配 4-制作中 5-待审核 6-审核中 7-待发布 8-完成 0-取消',
  `country_id` int(11) DEFAULT NULL COMMENT '国家Id',
  `country_name` varchar(50) DEFAULT NULL COMMENT '国家名',
  `path_file` varchar(200) DEFAULT NULL COMMENT '上传文件地址',
  `path_data` varchar(200) DEFAULT NULL COMMENT '数据TXT保存路径',
  `path_data_file` varchar(200) DEFAULT NULL COMMENT '由数据生成的pdf保存路径',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `expect_hour` int(11) DEFAULT '24' COMMENT '制作期限，以支付时间开始算，以小时为单位',
  `expect_time` datetime DEFAULT NULL COMMENT '应交付日期，根据期限计算出来（-法定节日，+加班日）的日期',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间，发布时间',
  `supplier_expect_hour` int(11) DEFAULT NULL COMMENT '供应商制作期限',
  `supplier_expect_time` datetime DEFAULT NULL COMMENT '供应商应交付日期',
  `supplier_id` int(11) DEFAULT NULL COMMENT '供应商ID ==== BasicData',
  `report_user_id` int(11) DEFAULT NULL COMMENT '报告制作人员==== Users',
  `check_user_id` int(11) DEFAULT NULL COMMENT '审核人员==== Users',
  `charge_user_id` int(11) DEFAULT NULL COMMENT '负责人ID ==== Users',
  `is_special` bit(1) DEFAULT b'0' COMMENT '是否特殊订单',
  `is_express` bit(1) DEFAULT b'0' COMMENT '是否加急',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `db_is_update` bit(1) DEFAULT b'0' COMMENT '外部接口数据保存标识',
  `cpm_is_update` bit(1) DEFAULT b'0' COMMENT 'cpm数据保存标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1667 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `no` varchar(30) NOT NULL COMMENT '订单编号',
  `source` tinyint(4) NOT NULL COMMENT '订单来源 1：全球鹰 2：全搜 3：估估 4：CPM',
  `status` tinyint(4) NOT NULL COMMENT '订单状态: 1-待支付 4-制作中  8-完成  0-取消',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `expect_time` datetime DEFAULT NULL COMMENT '预计交付时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间，业务中，需在预计交付时间前',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id，除手工订单，系统下单均不能为空。',
  `customer_name` varchar(50) DEFAULT NULL COMMENT '客户名',
  `customer_no` varchar(30) DEFAULT NULL COMMENT '客户号，客户给予',
  `customer_email` varchar(255) DEFAULT NULL COMMENT '客户邮件，除手工订单，系统下单均不能为空。业务发送邮件所用',
  `create_user_id` int(11) DEFAULT NULL COMMENT '操作员Id，适用于手工订单',
  `create_user_name` varchar(50) DEFAULT NULL COMMENT '操作员名字',
  `amount` decimal(10,2) NOT NULL COMMENT '应付金额',
  `amount_actual` decimal(10,2) NOT NULL COMMENT '实付金额，典型场景：升级报告减差价',
  `currency` varchar(3) DEFAULT 'CNY' COMMENT '币种,取3位国际编码',
  `has_pay` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否支付',
  `pay_method` tinyint(4) DEFAULT NULL COMMENT '支付方式 0：帐号余额 1：支付宝 2：微信',
  `detail_count` tinyint(4) NOT NULL COMMENT '明细数量',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `type` tinyint(4) DEFAULT NULL COMMENT '订单类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1685 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品Id',
  `no` varchar(30) NOT NULL COMMENT '产品号',
  `name` varchar(50) NOT NULL COMMENT '产品名',
  `desc` varchar(255) DEFAULT NULL COMMENT '产品描述',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_person` varchar(50) NOT NULL COMMENT '创建人',
  `last_update_time` datetime DEFAULT NULL COMMENT '最近更新时间',
  `last_update_person` varchar(50) DEFAULT NULL COMMENT '最近更新人',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格',
  `source` tinyint(4) NOT NULL DEFAULT '0' COMMENT '产品来源 0：通用 1：全球鹰 2：全搜 3：估估 4：CPM',
  `expect_hour` int(11) DEFAULT '24' COMMENT '制作期限，以小时为单位',
  `model_url` varchar(200) DEFAULT NULL COMMENT '样本url',
  `product_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '产品类型 1:中国报告,2:外国报告,3:自定义报告',
  `currency` varchar(3) NOT NULL DEFAULT 'CNY' COMMENT '币种,取3位国际编码',
  `level` tinyint(4) NOT NULL COMMENT '产品等级',
  `is_express` bit(1) DEFAULT b'0' COMMENT '是否加急',
  `enable` bit(1) DEFAULT NULL COMMENT '产品是否可用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '0001', '数据库报告', '一个Html数据库报告', '2017-03-14 13:43:47', '111', '2017-03-29 16:37:15', 'a', '99.00', '1', '0', null, '1', 'CNY', '1', null, '');
INSERT INTO `product` VALUES ('2', '0002', '数据库完整报告', '一个Html数据库完整报告（含财务信息）', '2017-03-14 13:44:55', '111', null, null, '399.00', '1', '0', null, '1', 'CNY', '2', null, '');
INSERT INTO `product` VALUES ('3', '0003', '完整版报告', '一个PDF完整版报告+一个Html数据库报告', '2017-03-14 13:45:29', '111', null, null, '999.00', '1', '48', null, '1', 'CNY', '3', null, '');
INSERT INTO `product` VALUES ('4', '0004', '完整版报告-加急', '一个PDF完整版报告+一个Html数据库报告', '2017-03-21 10:26:01', '111', null, null, '1199.00', '1', '24', null, '1', 'CNY', '3', null, '');
INSERT INTO `product` VALUES ('5', '0005', '数据库报告', '一个Html数据库报告', '2017-03-21 10:27:09', '111', null, null, '99.00', '1', '0', null, '2', 'USD', '1', null, '');
INSERT INTO `product` VALUES ('6', '0006', '完整版报告', '一个PDF完整版报告+一个Html数据库报告', '2017-03-21 10:27:43', '111', null, null, '399.00', '1', '48', null, '2', 'USD', '3', null, '');
INSERT INTO `product` VALUES ('7', '0007', '完整版报告-加急', '一个PDF完整版报告+一个Html数据库报告', '2017-03-21 10:28:17', '111', null, null, '999.00', '1', '24', null, '2', 'USD', '3', null, '');
INSERT INTO `product` VALUES ('8', '0008', 'Legal info', 'Including ①', '2017-03-21 10:43:32', '222', null, null, '19.00', '2', '0', null, '1', 'USD', '1', null, '');
INSERT INTO `product` VALUES ('9', '0009', 'Performance info', 'Including ① + ②', '2017-03-21 10:45:36', '222', null, null, '69.00', '2', '48', null, '1', 'USD', '2', null, '');
INSERT INTO `product` VALUES ('10', '0010', 'Credit info', 'Including ① + ② + ③', '2017-03-21 10:47:07', '222', null, null, '129.00', '2', '96', null, '1', 'USD', '3', null, '');
INSERT INTO `product` VALUES ('11', '0011', '完整版报告', '一个PDF完整版报告', '2017-03-21 11:47:10', '111', null, null, '999.00', '1', '48', null, '3', 'CNY', '3', null, '');
INSERT INTO `product` VALUES ('12', '0012', '完整版报告-加急', '一个PDF完整版报告', '2017-03-21 11:47:57', '111', null, null, '1199.00', '1', '24', null, '3', 'CNY', '3', null, '');
INSERT INTO `product` VALUES ('13', '0013', 'Full report', 'A full PDF version of the report', '2017-04-21 13:50:02', '222', null, null, '999.00', '2', '48', null, '3', 'CNY', '3', '\0', '');
INSERT INTO `product` VALUES ('14', '0014', 'Full report - urgent', 'A full PDF version of the report', '2017-04-21 13:51:46', '222', null, null, '1199.00', '2', '24', null, '3', 'CNY', '3', '\0', '');

-- ----------------------------
-- Table structure for product_module
-- ----------------------------
DROP TABLE IF EXISTS `product_module`;
CREATE TABLE `product_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Id',
  `product_id` int(11) NOT NULL COMMENT '产品Id',
  `module_id` int(11) NOT NULL COMMENT '模块id',
  `is_provider` bit(1) DEFAULT b'0' COMMENT '是否供应商制作',
  `sql` varchar(2000) DEFAULT NULL COMMENT '查询SQL，需要加密',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_module
-- ----------------------------

-- ----------------------------
-- Table structure for quick_order
-- ----------------------------
DROP TABLE IF EXISTS `quick_order`;
CREATE TABLE `quick_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_no` varchar(30) NOT NULL COMMENT '订单编号',
  `no` varchar(30) DEFAULT NULL COMMENT '快速订单编号',
  `source` tinyint(4) DEFAULT NULL COMMENT '订单来源 1：全球鹰 2：全搜 3：估估 4：CPM',
  `status` tinyint(4) DEFAULT NULL COMMENT '订单状态: 0-取消1-新订单2-确认中3-制作中4-已完成（0取消，1待确认，2反馈中，3制作中，4完成）',
  `product_id` int(11) NOT NULL COMMENT '产品Id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `expect_time` datetime DEFAULT NULL COMMENT '预计交付时间',
  `expect_hour` int(11) DEFAULT '24' COMMENT '制作期限，以支付时间开始算，以小时为单位',
  `finish_time` datetime DEFAULT NULL COMMENT '完成时间，业务中，需在预计交付时间前',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id，除手工订单，系统下单均不能为空。',
  `customer_name` varchar(50) DEFAULT NULL COMMENT '客户名',
  `customer_no` varchar(30) DEFAULT NULL COMMENT '客户号，客户给予',
  `customer_email` varchar(255) DEFAULT NULL COMMENT '客户邮件，除手工订单，系统下单均不能为空。业务发送邮件所用',
  `create_user_id` int(11) DEFAULT NULL COMMENT '操作员Id，适用于手工订单',
  `create_user_name` varchar(50) DEFAULT NULL COMMENT '操作员名字',
  `amount` decimal(10,2) NOT NULL COMMENT '应付金额',
  `amount_actual` decimal(10,2) NOT NULL COMMENT '实付金额，典型场景：升级报告减差价',
  `currency` varchar(3) DEFAULT 'CNY' COMMENT '币种,取3位国际编码',
  `has_pay` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否支付',
  `pay_method` tinyint(4) DEFAULT NULL COMMENT '支付方式 0：帐号余额 1：支付宝 2：微信',
  `company_area` varchar(20) NOT NULL COMMENT '订购企业所属洲或地区',
  `company_country` varchar(20) NOT NULL COMMENT '订购企业所属国家',
  `company_name` varchar(200) NOT NULL COMMENT '企业名称',
  `company_address` varchar(255) DEFAULT NULL COMMENT '企业地址',
  `company_phone` varchar(50) DEFAULT NULL COMMENT '企业电话',
  `company_website` varchar(255) DEFAULT NULL COMMENT '企业网站',
  `img_url` varchar(255) DEFAULT NULL COMMENT '公司信息图片地址',
  `other_info` varchar(255) DEFAULT NULL COMMENT '其他信息',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of quick_order
-- ----------------------------

-- ----------------------------
-- View structure for v_order_detail
-- ----------------------------
DROP VIEW IF EXISTS `v_order_detail`;
CREATE ALGORITHM=UNDEFINED DEFINER=``@`` SQL SECURITY INVOKER VIEW `v_order_detail` AS select `order_detail`.`id` AS `id`,`order_detail`.`order_id` AS `order_id`,`order_detail`.`crefo_no` AS `crefo_no`,`order_detail`.`company_name` AS `company_name`,`order_detail`.`company_no` AS `company_no`,`order_detail`.`price` AS `price`,`order_detail`.`price_actual` AS `price_actual`,`order_detail`.`product_id` AS `product_id`,`order_detail`.`report_lang` AS `report_lang`,`order_detail`.`status` AS `status`,`order_detail`.`country_id` AS `country_id`,`order_detail`.`country_name` AS `country_name`,`order_detail`.`path_file` AS `path_file`,`order_detail`.`path_data` AS `path_data`,`order_detail`.`update_time` AS `update_time`,`order_detail`.`expect_hour` AS `expect_hour`,`order_detail`.`expect_time` AS `expect_time`,`order_detail`.`finish_time` AS `finish_time`,`order_detail`.`supplier_expect_hour` AS `supplier_expect_hour`,`order_detail`.`supplier_expect_time` AS `supplier_expect_time`,`order_detail`.`supplier_id` AS `supplier_id`,`order_detail`.`report_user_id` AS `report_user_id`,`order_detail`.`check_user_id` AS `check_user_id`,`order_detail`.`charge_user_id` AS `charge_user_id`,`order_detail`.`is_special` AS `is_special`,`order_detail`.`is_express` AS `is_express`,`order_detail`.`remark` AS `remark`,`orders`.`no` AS `order_no`,`orders`.`source` AS `source`,`orders`.`status` AS `order_status`,`orders`.`create_time` AS `create_time`,`orders`.`pay_time` AS `pay_time`,`orders`.`update_time` AS `order_update_time`,`orders`.`expect_time` AS `order_expect_time`,`orders`.`finish_time` AS `order_finish_time`,`orders`.`customer_id` AS `customer_id`,`orders`.`customer_name` AS `customer_name`,`orders`.`customer_no` AS `customer_no`,`orders`.`customer_email` AS `customer_email`,`orders`.`create_user_id` AS `create_user_id`,`orders`.`create_user_name` AS `create_user_name`,`orders`.`amount` AS `amount`,`orders`.`amount_actual` AS `amount_actual`,`orders`.`currency` AS `currency`,`orders`.`has_pay` AS `has_pay`,`orders`.`pay_method` AS `pay_method`,`orders`.`detail_count` AS `detail_count`,`orders`.`remark` AS `order_remark`,`product`.`product_type` AS `product_type`,`order_detail`.`path_data_file` AS `path_data_file`,`order_detail`.`company_namecn` AS `company_namecn`,`order_detail`.`db_is_update` AS `db_is_update`,`order_detail`.`cpm_is_update` AS `cpm_is_update` from ((`orders` join `order_detail`) join `product` on(((`orders`.`id` = `order_detail`.`order_id`) and (`order_detail`.`product_id` = `product`.`id`)))) ;
