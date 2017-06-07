
SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `credit_globalsearch`;
CREATE DATABASE `credit_globalsearch` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
use `credit_globalsearch`;

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(255) NOT NULL COMMENT '公司名称',
  `company_no` varchar(40) DEFAULT NULL COMMENT '公司编码',
  `order_level` varchar(20) DEFAULT NULL COMMENT '订单等级',
  `currency` varchar(10) DEFAULT NULL COMMENT '币种',
  `online_price` float DEFAULT NULL COMMENT '线上普通价格',
  `online_express_price` float DEFAULT NULL COMMENT '线上加急价格',
  `online_normail_delivery_days` int(11) DEFAULT NULL COMMENT '线上普通时间',
  `online_express_delivery_days` int(11) DEFAULT NULL COMMENT '线上加急时间',
  `offline_price` float DEFAULT NULL COMMENT '线下价格',
  `offline_express_price` float DEFAULT NULL COMMENT '线下加急价格',
  `offline_normail_delivery_days` int(11) DEFAULT NULL COMMENT '线下普通时间',
  `offline_express_delivery_days` int(11) DEFAULT NULL COMMENT '线下加急时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `customer_id` int(11) NOT NULL COMMENT '客户id',
  `company_info_id` int(11) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL COMMENT '城市id',
  `is_custom_order` varchar(2) DEFAULT '否',
  `total_price` float(11,0) DEFAULT NULL,
  `upload_pic_path` varchar(40) DEFAULT NULL COMMENT '图片上传路径',
  `crefo_no` varchar(40) DEFAULT NULL,
  `is_china_order` varchar(2) DEFAULT '否',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=345 DEFAULT CHARSET=utf8 COMMENT='购物车';

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for company_info
-- ----------------------------
DROP TABLE IF EXISTS `company_info`;
CREATE TABLE `company_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `company_name` varchar(40) DEFAULT NULL COMMENT '公司名字',
  `company_address` varchar(200) DEFAULT NULL COMMENT '公司地址',
  `company_country` varchar(40) DEFAULT NULL COMMENT '城市',
  `company_phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `company_website` varchar(40) DEFAULT NULL COMMENT '公司网址',
  `company_fax` varchar(20) DEFAULT NULL COMMENT '传真',
  `company_email` varchar(40) DEFAULT NULL COMMENT 'EMAIL',
  `company_contact` varchar(20) DEFAULT NULL COMMENT '联系人',
  `bank` varchar(20) DEFAULT NULL COMMENT '银行',
  `bank_account` varchar(20) DEFAULT NULL COMMENT '银行账号',
  `bank_address` varchar(200) DEFAULT NULL COMMENT '银行地址',
  `bank_contact` varchar(20) DEFAULT NULL COMMENT '银行联系人',
  `bank_phone` varchar(20) DEFAULT NULL COMMENT '银行电话',
  `trade_ref` varchar(40) DEFAULT NULL COMMENT '贸易供应商',
  `trade_ref_contact` varchar(20) DEFAULT NULL COMMENT '贸易供应商联系人',
  `trade_ref_phone` varchar(20) DEFAULT NULL COMMENT '贸易供应商联系人电话',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='自定义订单公司信息';

-- ----------------------------
-- Records of company_info
-- ----------------------------

-- ----------------------------
-- Table structure for continent
-- ----------------------------
DROP TABLE IF EXISTS `continent`;
CREATE TABLE `continent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编码',
  `cn_name` varchar(40) DEFAULT NULL COMMENT '中文名',
  `en_name` varchar(40) DEFAULT NULL COMMENT '英文名',
  `is_enable` varchar(2) DEFAULT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='洲信息';

-- ----------------------------
-- Records of continent
-- ----------------------------
INSERT INTO `continent` VALUES ('1', '亚洲', 'Asia', '是');
INSERT INTO `continent` VALUES ('2', '非洲', 'Africa', '是');
INSERT INTO `continent` VALUES ('3', '欧洲', 'Europe', '是');
INSERT INTO `continent` VALUES ('4', '美洲', 'America', '是');
INSERT INTO `continent` VALUES ('8', '中东', 'Middle East', '是');

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(20) NOT NULL COMMENT '编码',
  `cn_name` varchar(30) NOT NULL COMMENT '中文名称名称',
  `en_name` varchar(30) NOT NULL COMMENT '英文名称',
  `online_order_cny_price` float DEFAULT '0' COMMENT '在线报告价格(人民币)',
  `online_order_usd_price` float DEFAULT NULL COMMENT '在线报告价格(美元)',
  `online_order_eur_price` float DEFAULT NULL COMMENT '在线报告价格(欧元)',
  `online_normail_delivery_days` int(11) DEFAULT NULL COMMENT '在线报告普通制作时间',
  `online_express_delivery_days` int(11) DEFAULT NULL COMMENT '在线报告加急制作时间',
  `online_express_delivery_cny_price` float DEFAULT NULL COMMENT '线上报告加急人民币价格',
  `online_express_delivery_usd_price` float DEFAULT NULL COMMENT '线上报告加急美元价格',
  `online_express_delivery_eur_price` float DEFAULT NULL COMMENT '线上报告加急欧元价格',
  `offline_order_cny_price` float DEFAULT '0' COMMENT '离线报告价格(人名币)',
  `offline_order_usd_price` float DEFAULT NULL COMMENT '离线报告价格(美元)',
  `offline_order_eur_price` float DEFAULT NULL COMMENT '离线报告价格(欧元)',
  `offline_normail_delivery_days` int(11) DEFAULT NULL COMMENT '离线报告普通制作时间',
  `offline_express_delivery_days` int(11) DEFAULT NULL COMMENT '离线报告加急制作时间',
  `offline_express_delivery_cny_price` float DEFAULT NULL COMMENT '离线报告制作加急人民币费用',
  `offline_express_delivery_usd_price` float DEFAULT NULL COMMENT '离线报告制作加急美元费用',
  `offline_express_delivery_eur_price` float DEFAULT NULL COMMENT '离线报告制作加急欧元费用',
  `is_enable` varchar(2) DEFAULT NULL,
  `continent_id` int(11) DEFAULT NULL,
  `online_full_order_cny_price` float DEFAULT '0' COMMENT '在线报告价格(人民币)',
  `online_full_order_usd_price` float DEFAULT NULL COMMENT '在线报告价格(美元)',
  `online_full_order_eur_price` float DEFAULT NULL COMMENT '在线报告价格(欧元)',
  `online_full_normail_delivery_days` int(11) DEFAULT NULL COMMENT '在线报告普通制作时间',
  `online_full_express_delivery_days` int(11) DEFAULT NULL COMMENT '在线报告加急制作时间',
  `online_full_express_delivery_cny_price` float DEFAULT NULL COMMENT '线上报告加急人民币价格',
  `online_full_express_delivery_usd_price` float DEFAULT NULL COMMENT '线上报告加急美元价格',
  `online_full_express_delivery_eur_price` float DEFAULT NULL COMMENT '线上报告加急欧元价格',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=248 DEFAULT CHARSET=utf8 COMMENT='城市信息';

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES ('1', 'AF', '阿富汗', 'Afghanistan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('2', 'AX', '奥兰群岛', 'Aland Islands', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('3', 'AL', '阿尔巴尼亚', 'Albania', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('4', 'DZ', '阿尔及利亚', 'Algeria', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('5', 'AS', '美属萨摩亚', 'American Samoa', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('6', 'AD', '安道尔共和国', 'Andorra', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('7', 'AO', '安哥拉', 'Angola', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('8', 'AI', '安圭拉岛', 'Anguilla', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('9', 'AQ', '南极洲', 'Antarctica', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('10', 'AG', '安提瓜和巴布达', 'Antigua and Barbuda', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('11', 'AR', '阿根廷', 'Argentina', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('12', 'AM', '亚美尼亚', 'Armenia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('13', 'AW', '阿鲁巴', 'Aruba', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('14', 'AU', '澳大利亚', 'Australia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('15', 'AT', '奥地利', 'Austria', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('16', 'AZ', '阿塞拜疆', 'Azerbaijan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('17', 'BS', '巴哈马', 'Bahamas', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('18', 'BH', '巴林', 'Bahrain', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('19', 'BD', '孟加拉国', 'Bangladesh', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('20', 'BB', '巴巴多斯', 'Barbados', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('21', 'BY', '白俄罗斯', 'Belarus', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('22', 'BE', '比利时', 'Belgium', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('23', 'BZ', '伯利兹', 'Belize', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('24', 'BJ', '贝宁', 'Benin', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('25', 'BM', '百慕大群岛', 'Bermuda', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('26', 'BT', '不丹', 'Bhutan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('27', 'BO', '玻利维亚', 'Plurinational State of Bolivia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('28', 'BA', '波斯尼亚和黑塞哥维那', 'Bosnia and Herzegovina', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('29', 'BW', '博茨瓦纳', 'Botswana', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('30', 'BV', '布维岛', 'Bouvet Island', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('31', 'BR', '巴西', 'Brazil', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('32', 'IO', '英属印度洋领地', 'British Indian Ocean Territory', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('33', 'BN', '文莱', 'Brunei Darussalam', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('34', 'BG', '保加利亚', 'Bulgaria', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('35', 'BF', '布基纳法索', 'Burkina Faso', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('36', 'BI', '布隆迪', 'Burundi', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('37', 'KH', '柬埔寨', 'Cambodia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('38', 'CM', '喀麦隆', 'Cameroon', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('39', 'CA', '加拿大', 'Canada', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('40', 'CV', '佛得角', 'Cape Verde', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('41', 'KY', '开曼群岛', 'Cayman Islands', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('42', 'CF', '中非共和国', 'Central African Republic', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('43', 'TD', '乍得', 'Chad', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('44', 'CL', '智利', 'Chile', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('45', 'CN', '中国', 'China', '99', '20', '30', '40', '50', '60', '70', '80', '999', '200', '100', '4', '2', '1199', '400', '5', '是', '1', '399', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('46', 'CX', '圣诞岛', 'Christmas Island', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('47', 'CC', '科科斯（基林）群岛', 'Cocos (Keeling) Islands', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('48', 'CO', '哥伦比亚', 'Colombia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('49', 'KM', '科摩罗', 'Comoros', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('50', 'CG', '刚果', 'Congo', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('51', 'CD', '刚果，刚果民主共和国', 'Democratic Republic of the Con', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('52', 'CK', '库克群岛', 'Cook Islands', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('53', 'CR', '哥斯达黎加', 'Costa Rica', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('54', 'CI', '科特迪瓦', 'Coate dIvoire', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('55', 'HR', '克罗地亚', 'Croatia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('56', 'CU', '古巴', 'Cuba', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('57', 'CY', '塞浦路斯', 'Cyprus', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('58', 'CZ', '捷克', 'Czech Republic', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('59', 'DK', '丹麦', 'Denmark', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('60', 'DJ', '吉布提', 'Djibouti', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('61', 'DM', '多米尼加', 'Dominica', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('62', 'DO', '多米尼加共和国', 'Dominican Republic', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('63', 'EC', '厄瓜多尔', 'Ecuador', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('64', 'EG', '埃及', 'Egypt', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('65', 'SV', '萨尔瓦多', 'El Salvador', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('66', 'GQ', '赤道几内亚', 'Equatorial Guinea', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('67', 'ER', '厄立特里亚', 'Eritrea', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('68', 'EE', '爱沙尼亚', 'Estonia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('69', 'ET', '埃塞俄比亚', 'Ethiopia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('70', 'FK', '福克兰群岛（马尔维纳斯）', 'Falkland Islands (Malvinas)', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('71', 'FO', '法罗群岛', 'Faroe Islands', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('72', 'FJ', '斐济', 'Fiji', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('73', 'FI', '芬兰', 'Finland', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('74', 'FR', '法国', 'France', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('75', 'GF', '法属圭亚那', 'French Guiana', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('76', 'PF', '法属波利尼西亚', 'French Polynesia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('77', 'TF', '法国南部领土', 'French Southern Territories', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('78', 'GA', '加蓬', 'Gabon', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('79', 'GM', '冈比亚', 'Gambia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('80', 'GE', '格鲁吉亚', 'Georgia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('81', 'DK', '德国', 'Germany', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('82', 'GH', '加纳', 'Ghana', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('83', 'GI', '直布罗陀', 'Gibraltar', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('84', 'GR', '希腊', 'Greece', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('85', 'GL', '格陵兰', 'Greenland', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('86', 'GD', '格林纳达', 'Grenada', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('87', 'GP', '瓜德罗普岛', 'Guadeloupe', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('88', 'GU', '关岛', 'Guam', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('89', 'GT', '危地马拉', 'Guatemala', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('90', 'GG', '根西岛', 'Guernsey', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('91', 'GN', '几内亚', 'Guinea', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('92', 'GW', '几内亚比绍', 'The Republic of Guinea-Bissau', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('93', 'GY', '圭亚那', 'Guyana', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('94', 'HT', '海地', 'Haiti', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('95', 'HM', '赫德岛和麦当劳群岛', 'Heard Island and McDonald Isla', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('96', 'HN', '洪都拉斯', 'Honduras', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('97', 'HK', '香港', 'Hong Kong', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('98', 'HU', '匈牙利', 'Hungary', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('99', 'IS', '冰岛', 'Iceland', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('100', 'IN', '印度', 'India', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('101', 'ID', '印度尼西亚', 'Indonesia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('102', 'IR', '伊朗', 'Islamic Republic of Iran', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('103', 'IQ', '伊拉克', 'Iraq', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('104', 'IE', '爱尔兰', 'Ireland', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('105', 'IM', '马恩岛', 'Isle of Man', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('106', 'IL', '以色列', 'Israel', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('107', 'IT', '意大利', 'Italy', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('108', 'JM', '牙买加', 'Jamaica', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('109', 'JP', '日本', 'Japan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('110', 'JE', '新泽西州', 'Jersey', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('111', 'JO', '约旦', 'Jordan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('112', 'KZ', '哈萨克斯坦', 'Kazakhstan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('113', 'KE', '肯尼亚', 'Kenya', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('114', 'KI', '基里巴斯', 'Kiribati', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('115', 'KP', '韩国，朝鲜民主主义人民共和国，', 'Democratic Peoples Republic of', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('116', 'KR', '韩国', 'Republic of Korea', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('117', 'KW', '科威特', 'Kuwait', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('118', 'KG', '吉尔吉斯坦', 'Kyrgyzstan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('119', 'LA', '老挝', 'Lao Peoples Democratic Republi', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('120', 'LV', '拉脱维亚', 'Latvia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('121', 'LB', '黎巴嫩', 'Lebanon', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('122', 'LS', '莱索托', 'Lesotho', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('123', 'LR', '利比里亚', 'Liberia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('124', 'LY', '利比亚', 'Libyan Arab Jamahiriya', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('125', 'LI', '列支敦士登', 'Liechtenstein', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('126', 'LT', '立陶宛', 'Lithuania', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('127', 'LU', '卢森堡', 'Luxembourg', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('128', 'MO', '澳门', 'Macao', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('129', 'MK', '马其顿，前南斯拉夫的马其顿共和国', 'The Republic of Macedonia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('130', 'MG', '马达加斯加', 'Madagascar', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('131', 'MW', '马拉维', 'Malawi', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('132', 'MY', '马来西亚', 'Malaysia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('133', 'MV', '马尔代夫', 'Maldives', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('134', 'ML', '马里', 'Mali', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('135', 'MT', '马耳他', 'Malta', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('136', 'MH', '马绍尔群岛', 'Marshall Islands', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('137', 'MQ', '马提尼克岛', 'Martinique', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('138', 'MR', '毛里塔尼亚', 'Mauritania', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('139', 'MU', '毛里求斯', 'Mauritius', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('140', 'YT', '马约特', 'Mayotte', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('141', 'MX', '墨西哥', 'Mexico', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('142', 'FM', '密克罗尼西亚联邦', 'Federated States of Micronesia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('143', 'MD', '摩尔多瓦', 'The Republic of Moldova', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('144', 'MC', '摩纳哥', 'Monaco', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('145', 'MN', '蒙古', 'Mongolia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('146', 'ME', '黑山', 'Montenegro', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('147', 'MS', '蒙特塞拉特岛', 'Montserrat', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('148', 'MA', '摩洛哥', 'Morocco', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('149', 'MZ', '莫桑比克', 'Mozambique', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('150', 'MM', '缅甸', 'Myanmar', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('151', 'NA', '纳米比亚', 'Namibia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('152', 'NR', '瑙鲁', 'Nauru', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('153', 'NP', '尼泊尔', 'Nepal', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('154', 'NL', '荷兰', 'Netherlands', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('155', 'AN', '荷属安的列斯群岛', 'Netherlands Antilles', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('156', 'NC', '新喀里多尼亚', 'New Caledonia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('157', 'NZ', '新西兰', 'New Zealand', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('158', 'NI', '尼加拉瓜', 'Nicaragua', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('159', 'NE', '尼日尔', 'Niger', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('160', 'NG', '尼日利亚', 'Nigeria', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('161', 'NU', '纽埃', 'Niue', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('162', 'NF', '诺福克岛', 'Norfolk Island', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('163', 'MP', '北马里亚纳群岛', 'Northern Mariana Islands', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('164', 'NO', '挪威', 'Norway', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('165', 'OM', '阿曼', 'Oman', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('166', 'PK', '巴基斯坦', 'Pakistan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('167', 'PW', '帕劳', 'Palau', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('168', 'PS', '被占巴勒斯坦领土', 'Palestinian Territory, Occupie', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('169', 'PA', '巴拿马', 'Panama', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('170', 'PG', '巴布亚新几内亚', 'Papua New Guinea', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('171', 'PY', '巴拉圭', 'Paraguay', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('172', 'PE', '秘鲁', 'Peru', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('173', 'PH', '菲律宾', 'Philippines', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('174', 'PN', '皮特凯恩', 'Pitcairn', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('175', 'PL', '波兰', 'Poland', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('176', 'PT', '葡萄牙', 'Portugal', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('177', 'PR', '波多黎各', 'Puerto Rico', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('178', 'QA', '卡塔尔', 'Qatar', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('179', 'RE', '留尼汪岛', 'Reunion Island', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('180', 'RO', '罗马尼亚', 'Romania', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('181', 'RU', '俄罗斯', 'Russian Federation', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('182', 'RW', '卢旺达', 'Rwanda', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('183', 'BL', '圣巴泰勒米', 'Saint Barth Island', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('184', 'SH', '圣赫勒拿岛，阿森松岛和特里斯坦-达库尼亚群岛', 'Saint Helena', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('185', 'KN', '圣基茨和尼维斯', 'Saint Kitts and Nevis', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('186', 'LC', '圣卢西亚', 'Saint Lucia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('187', 'MF', '圣马丁（法国一部分）', 'Saint Martin (French part)', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('188', 'PM', '圣皮埃尔和密克隆', 'Saint Pierre and Miquelon', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('189', 'VC', '圣文森特岛', 'Saint Vincent and the Grenadin', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('190', 'WS', '萨摩亚', 'Samoa', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('191', 'SM', '圣马力诺', 'San Marino', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('192', 'ST', '圣多美和普林西比', 'Sao Tome and Principe', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('193', 'SA', '沙特阿拉伯', 'Saudi Arabia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('194', 'SN', '塞内加尔', 'Senegal', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('195', 'RS', '塞尔维亚', 'Serbia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('196', 'SC', '塞舌尔', 'Seychelles', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('197', 'SL', '塞拉利昂', 'Sierra Leone', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('198', 'SG', '新加坡', 'Singapore', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('199', 'SK', '斯洛伐克', 'Slovakia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('200', 'SI', '斯洛文尼亚', 'Slovenia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('201', 'SB', '所罗门群岛', 'Solomon Islands', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('202', 'SO', '索马里', 'Somalia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('203', 'ZA', '南非', 'South Africa', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('204', 'GS', '南乔治亚岛和南桑威奇群岛', 'South Georgia and the South Sa', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('205', 'ES', '西班牙', 'Spain', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('206', 'LK', '斯里兰卡', 'Sri Lanka', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('207', 'SD', '苏丹', 'Sudan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('208', 'SR', '苏里南', 'Suriname', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('209', 'SJ', '斯瓦尔巴岛和扬马延岛', 'Svalbard and Jan Mayen', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('210', 'SZ', '斯威士兰', 'Swaziland', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('211', 'SE', '瑞典', 'Sweden', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('212', 'CH', '瑞士', 'Switzerland', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('213', 'SY', '叙利亚', 'Syrian Arab Republic', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('214', 'TW', '台湾省', 'Taiwan, Province of China', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('215', 'TJ', '塔吉克斯坦', 'Tajikistan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('216', 'TZ', '坦桑尼亚', 'The United Republic of Tanzani', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('217', 'TH', '泰国', 'Thailand', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('218', 'TL', '东帝汶', 'Democratic Republic of Timor-L', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('219', 'TG', '多哥', 'Togo', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('220', 'TK', '托克劳', 'Tokelau', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('221', 'TO', '汤加', 'Tonga', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('222', 'TT', '特立尼达和多巴哥', 'Trinidad and Tobago', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('223', 'TN', '突尼斯', 'Tunisia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('224', 'TR', '土耳其', 'Turkey', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('225', 'TM', '土库曼斯坦', 'Turkmenistan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('226', 'TC', '特克斯和凯科斯群岛', 'Turks and Caicos Islands', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('227', 'TV', '图瓦卢', 'Tuvalu', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('228', 'UG', '乌干达', 'Uganda', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('229', 'UA', '乌克兰', 'Ukraine', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('230', 'AE', '阿拉伯联合酋长国', 'United Arab Emirates', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('231', 'GB', '英国', 'United Kingdom', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('232', 'US', '美国', 'United States', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '是', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('233', 'UM', '美国本土外小岛屿', 'United States Minor Outlying I', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('234', 'UY', '乌拉圭', 'Uruguay', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('235', 'UZ', '乌兹别克斯坦', 'Uzbekistan', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('236', 'VU', '南斯拉夫', 'Socialist Federal Republic of', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('237', 'VA', '梵蒂冈', 'Vatican City State', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '3', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('238', 'VE', '委内瑞拉', 'Bolivarian Republic of Venezue', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '4', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('239', 'VN', '越南', 'Viet Nam', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '1', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('240', 'VG', '英属维尔京群岛', 'Virgin Islands, British', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('241', 'VI', '美属维尔京群岛', 'Virgin Islands, U.S.', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('242', 'WF', '瓦利斯群岛和富图纳群岛', 'Wallis and Futuna', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('243', 'EH', '西撒哈拉', 'Western Sahara', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('244', 'YE', '也门', 'Yemen', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '8', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('245', 'ZM', '赞比亚', 'Zambia', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('246', 'ZW', '津巴布韦', 'Zimbabwe', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', '2', '0', null, null, null, null, null, null, null);
INSERT INTO `country` VALUES ('247', 'QT', '其他', 'Other', '199', '20', '30', '40', '50', '60', '70', '80', '1199', '200', '100', '300', '4', '1499', '400', '5', '否', null, '0', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `dept_id` varchar(20) DEFAULT NULL,
  `corp_id` varchar(20) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL COMMENT '工号/登陆名',
  `passwd` varchar(45) DEFAULT NULL COMMENT '密码',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `theme` varchar(45) DEFAULT 'default',
  `idcard` varchar(45) DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(45) DEFAULT NULL COMMENT '家庭电话',
  `addr` varchar(200) DEFAULT NULL COMMENT '地址',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_count` int(11) DEFAULT '0' COMMENT '登陆次数',
  `last_time` datetime DEFAULT NULL COMMENT '上次登陆时间',
  `enable` varchar(1) DEFAULT NULL COMMENT '是否启用',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建人',
  `sex` char(20) DEFAULT NULL COMMENT '性别\n男/女/无',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  `mobile` varchar(45) DEFAULT NULL COMMENT '手机',
  `other_contact` varchar(45) DEFAULT NULL COMMENT '其它联系方式',
  `sos_person` varchar(45) DEFAULT NULL COMMENT '紧急联系人',
  `sos_mobile` varchar(45) DEFAULT NULL COMMENT '紧急联系人手机',
  `born_place` varchar(45) DEFAULT NULL COMMENT '户籍',
  `level_id` int(11) DEFAULT NULL COMMENT '客户等级',
  `balance` float DEFAULT '0' COMMENT '余额',
  `company_name` varchar(40) DEFAULT NULL COMMENT '公司名称',
  `company_address` varchar(200) DEFAULT NULL COMMENT '公司地址',
  `company_phone` varchar(40) DEFAULT NULL COMMENT '公司电话',
  `position` varchar(20) DEFAULT NULL COMMENT '职位',
  `company_attach` text COMMENT '附件,使用json格式存储',
  `company_desc` varchar(400) DEFAULT NULL COMMENT '公司简要说明',
  `is_audit` varchar(1) DEFAULT NULL COMMENT '是否审计',
  `auth_sub_time` datetime DEFAULT NULL COMMENT '提交认证时间',
  `auth_end_time` datetime DEFAULT NULL COMMENT '认证结束时间',
  `fail_reason` varchar(200) DEFAULT NULL COMMENT '认证失败原因',
  `check_status` varchar(20) DEFAULT NULL COMMENT '审核状态',
  `check_status_option` varchar(200) DEFAULT NULL COMMENT '审核状态选项',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='客户信息';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', null, null, null, '21218CCA77804D2BA1922C33E0151105', null, 'default', null, null, null, 'service@3acredit.com', '2016-11-15 13:10:34', '0', null, '是', null, null, null, null, null, null, null, null, '1', '99802', null, null, null, null, null, null, null, null, null, null, '是', null);
INSERT INTO `customer` VALUES ('29', null, null, null, '96E79218965EB72C92A549DD5A330112', null, null, null, null, null, 'mika.zhang@3acredit.cn', '2016-12-02 09:45:26', null, null, null, null, null, null, null, null, null, null, null, '1', '85811', null, null, null, null, null, null, null, null, null, null, '是', null);
INSERT INTO `customer` VALUES ('34', null, null, 'a', '0CC175B9C0F1B6A831C399E269772661', null, null, null, null, null, null, '2017-01-10 14:17:42', null, null, null, null, null, null, null, null, null, null, null, '1', '9575', null, null, null, null, null, null, null, null, null, null, '否', null);

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `company_no` varchar(40) NOT NULL COMMENT '公司编码',
  `company_name` varchar(40) NOT NULL COMMENT '公司名称',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `customer_id` varchar(40) NOT NULL COMMENT '客户id',
  `country_id` int(11) NOT NULL COMMENT '城市id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='客户浏览历史';

-- ----------------------------
-- Records of history
-- ----------------------------

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` varchar(20) DEFAULT NULL,
  `corp_id` varchar(20) DEFAULT NULL,
  `code` varchar(45) NOT NULL COMMENT '工号/登陆名',
  `passwd` varchar(45) NOT NULL COMMENT '密码',
  `name` varchar(45) NOT NULL COMMENT '姓名',
  `theme` varchar(45) DEFAULT 'default',
  `idcard` varchar(45) DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(45) DEFAULT NULL COMMENT '家庭电话',
  `addr` varchar(200) DEFAULT NULL COMMENT '地址',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_count` int(11) DEFAULT '0' COMMENT '登陆次数',
  `last_time` datetime DEFAULT NULL COMMENT '上次登陆时间',
  `enable` bit(1) DEFAULT NULL COMMENT '是否启用',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建人',
  `sex` char(2) DEFAULT NULL COMMENT '性别\n男/女/无',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  `mobile` varchar(45) DEFAULT NULL COMMENT '手机',
  `other_contact` varchar(45) DEFAULT NULL COMMENT '其它联系方式',
  `sos_person` varchar(45) DEFAULT NULL COMMENT '紧急联系人',
  `sos_mobile` varchar(45) DEFAULT NULL COMMENT '紧急联系人手机',
  `born_place` varchar(45) DEFAULT NULL COMMENT '户籍',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('2', null, null, 'a', '0CC175B9C0F1B6A831C399E269772661', 'a', 'default', null, null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `crefo_no` varchar(40) DEFAULT NULL COMMENT 'crefoNo cpm订单编号',
  `order_no` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `send_date` datetime DEFAULT NULL,
  `price` float DEFAULT NULL COMMENT '订单价格',
  `is_send` varchar(2) DEFAULT '否' COMMENT '是否发送给客户',
  `send_email` varchar(40) DEFAULT NULL COMMENT '发送报告的EMAIL',
  `is_finished` varchar(2) DEFAULT '否' COMMENT '是否订单完成',
  `is_read` varchar(2) DEFAULT '否',
  `ip` varchar(20) DEFAULT NULL COMMENT 'ip地址',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id',
  `confirm_manager_id` int(11) DEFAULT NULL COMMENT '订单确认管理员ID',
  `order_status_id` varchar(2) DEFAULT NULL,
  `is_pay` varchar(2) DEFAULT '否',
  `order_detail_count` int(11) DEFAULT NULL COMMENT '报告数量',
  `weixin_code_url` varchar(50) DEFAULT NULL,
  `weixin_expire_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=687 DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `order_level` varchar(20) DEFAULT NULL COMMENT '订单级别',
  `company_no` varchar(40) DEFAULT NULL COMMENT '公司编码',
  `company_name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `upload_file_path` varchar(255) DEFAULT NULL COMMENT 'pdf下载URL',
  `currency` varchar(10) DEFAULT NULL COMMENT '币种',
  `online_price` float DEFAULT NULL COMMENT '线上普通价格',
  `online_express_price` float DEFAULT NULL COMMENT '线上加急价格',
  `online_normail_delivery_days` int(11) DEFAULT NULL COMMENT '线上普通时间',
  `online_express_delivery_days` int(11) DEFAULT NULL COMMENT '线上加急时间',
  `offline_price` float DEFAULT NULL COMMENT '线下价格',
  `offline_express_price` float DEFAULT NULL COMMENT '线下加急价格',
  `offline_normail_delivery_days` int(11) DEFAULT NULL COMMENT '线下普通时间',
  `offline_express_delivery_days` int(11) DEFAULT NULL COMMENT '线下加急时间',
  `country_id` int(11) DEFAULT NULL COMMENT '城市id',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `customer_id` int(11) DEFAULT NULL COMMENT '客户id',
  `manager_id` int(11) DEFAULT NULL COMMENT '管理员id',
  `order_status_id` int(11) DEFAULT NULL COMMENT '订单状态ID',
  `is_custom_order` varchar(2) DEFAULT '否' COMMENT '是否是自定义订单',
  `is_read` varchar(2) DEFAULT '否',
  `company_info_id` int(11) DEFAULT NULL COMMENT '自定义订单公司信息',
  `total_price` float(11,0) DEFAULT NULL,
  `is_finished` varchar(2) DEFAULT '否',
  `online_data_json` longtext COMMENT '在线数据json',
  `offline_data_json` longtext COMMENT '线下数据json',
  `upload_pic_path` varchar(40) DEFAULT NULL COMMENT '图片上传路径',
  `crefo_no` varchar(40) DEFAULT NULL,
  `is_china_order` varchar(2) DEFAULT '否',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=674 DEFAULT CHARSET=utf8 COMMENT='订单';

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for order_status
-- ----------------------------
DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(10) NOT NULL COMMENT '编码',
  `name` varchar(100) NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='订单状态';

-- ----------------------------
-- Records of order_status
-- ----------------------------
INSERT INTO `order_status` VALUES ('1', '0001', '制作中');
INSERT INTO `order_status` VALUES ('2', '0002', '已完成');

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `amount` float NOT NULL COMMENT '金额',
  `method_id` int(11) NOT NULL COMMENT '充值方式',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `status_id` int(11) NOT NULL COMMENT '状态id',
  `finish_date` date DEFAULT NULL COMMENT '完成时间',
  `customer_id` int(11) NOT NULL COMMENT '客户id',
  `manager_id` int(11) DEFAULT NULL COMMENT '管理员id',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='充值信息';

-- ----------------------------
-- Records of recharge
-- ----------------------------

-- ----------------------------
-- Table structure for s_button
-- ----------------------------
DROP TABLE IF EXISTS `s_button`;
CREATE TABLE `s_button` (
  `id` varchar(20) NOT NULL,
  `menu_id` varchar(20) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT '按钮显示名',
  `target` varchar(20) NOT NULL DEFAULT '_self' COMMENT '打开方式\n_self  本窗口\n_blank  新窗口\n_parent  父窗口\n_top  顶级窗口\n框架名   指定框架打开',
  `func` varchar(45) NOT NULL COMMENT '函数名，该函数定义在相应模块的js文件',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '序号，页面显示时根据序号排序',
  `enable` bit(1) NOT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`,`menu_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_button
-- ----------------------------

-- ----------------------------
-- Table structure for s_category
-- ----------------------------
DROP TABLE IF EXISTS `s_category`;
CREATE TABLE `s_category` (
  `id` varchar(20) NOT NULL,
  `name` varchar(45) NOT NULL COMMENT '分类名称',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '序号，页面显示时根据序号排序',
  `is_sys` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否内置，不允许前台修改',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_category
-- ----------------------------
INSERT INTO `s_category` VALUES ('DEVCATE', '开发设计', '100', '');
INSERT INTO `s_category` VALUES ('ORGCATE', '组织机构', '99', '');

-- ----------------------------
-- Table structure for s_condition
-- ----------------------------
DROP TABLE IF EXISTS `s_condition`;
CREATE TABLE `s_condition` (
  `id` varchar(20) NOT NULL,
  `condition_group_id` varchar(20) NOT NULL,
  `title` varchar(45) NOT NULL COMMENT '标题显示名',
  `col_name` varchar(45) NOT NULL COMMENT '要查询的字段名，保持与数据库一致',
  `type` varchar(45) NOT NULL COMMENT '查询方式\nbetween  介于\nlt  小于\ngt  大于\nqt  等于\nlike  模糊\nllike  左模糊\nrlike 右模糊',
  PRIMARY KEY (`id`,`condition_group_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_condition
-- ----------------------------

-- ----------------------------
-- Table structure for s_condition_group
-- ----------------------------
DROP TABLE IF EXISTS `s_condition_group`;
CREATE TABLE `s_condition_group` (
  `id` varchar(20) NOT NULL,
  `type` varchar(45) NOT NULL COMMENT 'and \nor ',
  `menu_id` varchar(20) NOT NULL,
  `menu_category_id` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`menu_id`,`menu_category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_condition_group
-- ----------------------------

-- ----------------------------
-- Table structure for s_corp
-- ----------------------------
DROP TABLE IF EXISTS `s_corp`;
CREATE TABLE `s_corp` (
  `id` varchar(20) NOT NULL,
  `pid` varchar(20) DEFAULT NULL COMMENT '上级机构',
  `lev` int(11) NOT NULL COMMENT '级次\n最上级为1，依次递增',
  `code` varchar(45) NOT NULL COMMENT '机构编码',
  `name` varchar(45) NOT NULL COMMENT '机构名称',
  `tel` varchar(45) NOT NULL,
  `addr` varchar(200) DEFAULT NULL,
  `corp_type_id` varchar(20) DEFAULT NULL,
  `artificial` varchar(45) DEFAULT NULL COMMENT '法人代表',
  `job` varchar(45) NOT NULL COMMENT '主要职能',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_corp
-- ----------------------------
INSERT INTO `s_corp` VALUES ('0000000000', null, '1', 'sh.mzj', '上海', '111', null, null, null, '111');

-- ----------------------------
-- Table structure for s_corp_type
-- ----------------------------
DROP TABLE IF EXISTS `s_corp_type`;
CREATE TABLE `s_corp_type` (
  `id` varchar(20) NOT NULL,
  `code` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_corp_type
-- ----------------------------

-- ----------------------------
-- Table structure for s_dept
-- ----------------------------
DROP TABLE IF EXISTS `s_dept`;
CREATE TABLE `s_dept` (
  `id` varchar(20) NOT NULL,
  `corp_id` varchar(20) NOT NULL,
  `pid` varchar(20) DEFAULT NULL,
  `lev` int(11) NOT NULL COMMENT '级次\n最上级为1，依次递增',
  `code` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `chief` varchar(45) DEFAULT NULL COMMENT '负责人',
  `job` varchar(45) DEFAULT NULL COMMENT '主要职能',
  PRIMARY KEY (`id`,`corp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_dept
-- ----------------------------
INSERT INTO `s_dept` VALUES ('0000000000', '0000000000', null, '1', 'xxjsb', '信息技术部', null, null);

-- ----------------------------
-- Table structure for s_group
-- ----------------------------
DROP TABLE IF EXISTS `s_group`;
CREATE TABLE `s_group` (
  `id` varchar(20) NOT NULL,
  `code` varchar(45) NOT NULL COMMENT '组编码',
  `name` varchar(45) NOT NULL COMMENT '组名称',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_group
-- ----------------------------
INSERT INTO `s_group` VALUES ('14EB461EA6D', '0001', '管理员');
INSERT INTO `s_group` VALUES ('14EB49D8FC4', '0002', '333');
INSERT INTO `s_group` VALUES ('14EB4A1A306', '0003', 'ff');
INSERT INTO `s_group` VALUES ('14EB4BEEC26', '0005', 'rr');
INSERT INTO `s_group` VALUES ('14EB4C102CC', '0006', 'tt');
INSERT INTO `s_group` VALUES ('14EB4C1D4E1', '0007', 'tt');

-- ----------------------------
-- Table structure for s_group_has_button
-- ----------------------------
DROP TABLE IF EXISTS `s_group_has_button`;
CREATE TABLE `s_group_has_button` (
  `group_id` varchar(20) NOT NULL,
  `button_id` varchar(20) NOT NULL,
  `access` char(1) NOT NULL COMMENT '访问方式\n0-可用\n1-不可用\n2-不显示',
  PRIMARY KEY (`group_id`,`button_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_group_has_button
-- ----------------------------

-- ----------------------------
-- Table structure for s_group_has_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_group_has_menu`;
CREATE TABLE `s_group_has_menu` (
  `group_id` varchar(20) NOT NULL,
  `menu_id` varchar(20) NOT NULL,
  `access` char(1) NOT NULL COMMENT '访问方式\n0-可用\n1-不可用\n2-不显示',
  PRIMARY KEY (`group_id`,`menu_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_group_has_menu
-- ----------------------------
INSERT INTO `s_group_has_menu` VALUES ('14EB4BEEC26', 'CATEMENU', '1');
INSERT INTO `s_group_has_menu` VALUES ('14EB4BEEC26', 'CORPTYPEMENU', '1');
INSERT INTO `s_group_has_menu` VALUES ('14EB4C102CC', 'CATEMENU', '2');
INSERT INTO `s_group_has_menu` VALUES ('14EB4C102CC', 'CORPMENU', '2');
INSERT INTO `s_group_has_menu` VALUES ('14EB4C102CC', 'CORPTYPEMENU', '1');
INSERT INTO `s_group_has_menu` VALUES ('14EB4C102CC', 'MENUMENU', '1');
INSERT INTO `s_group_has_menu` VALUES ('14EB4C1D4E1', 'CATEMENU', '1');
INSERT INTO `s_group_has_menu` VALUES ('14EB4C1D4E1', 'CORPMENU', '1');
INSERT INTO `s_group_has_menu` VALUES ('14EB4C1D4E1', 'MENUMENU', '1');

-- ----------------------------
-- Table structure for s_group_has_user
-- ----------------------------
DROP TABLE IF EXISTS `s_group_has_user`;
CREATE TABLE `s_group_has_user` (
  `group_id` varchar(20) NOT NULL,
  `user_id` varchar(20) NOT NULL,
  PRIMARY KEY (`group_id`,`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_group_has_user
-- ----------------------------

-- ----------------------------
-- Table structure for s_help
-- ----------------------------
DROP TABLE IF EXISTS `s_help`;
CREATE TABLE `s_help` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cate_id` int(11) NOT NULL,
  `title` varchar(200) NOT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_help
-- ----------------------------
INSERT INTO `s_help` VALUES ('1', '1', '账户无法登录', 'JTNDcCUzRSVFNiU4OCU5MSVFNyU5QSU4NCVFOCVCNCVBNiVFNiU4OCVCNyVFNiU5NyVBMCVFNiVCMyU5NSVFNyU5OSVCQiVFNSVCRCU5NSUzQyUyRnAlM0UlMEE=');
INSERT INTO `s_help` VALUES ('3', '3', '报告类型的区别', 'JTNDcCUzRSVFOCVBRiVCNyVFNCVCOCU4QiVFOCVCRCVCRCVFNiVBMCVCNyVFNiU5QyVBQyVFNiU4QSVBNSVFNSU5MSU4QSVFNSU4QyVCQSVFNSU4OCVBQiUzQyUyRnAlM0UlMEElMEElM0NwJTNFJUU2JTk1JUIwJUU2JThEJUFFJUU2JThBJUE1JUU1JTkxJThBJTIwJUU0JUI4JThCJUU4JUJEJUJEJTNDJTJGcCUzRSUwQSUwQSUzQ3AlM0UlRTglQjQlQTIlRTUlOEElQTElRTYlOEElQTUlRTUlOTElOEElMjAlRTQlQjglOEIlRTglQkQlQkQlM0MlMkZwJTNFJTBBJTBBJTNDcCUzRSVFOCVBRiU4NCVFNCVCQyVCMCVFNiU4QSVBNSVFNSU5MSU4QSUyMCVFNCVCOCU4QiVFOCVCRCVCRCUzQyUyRnAlM0UlMEE=');
INSERT INTO `s_help` VALUES ('4', '3', '报告数据不准确', 'JTNDcCUzRSVFOCVBRiVCNyVFNSVCMCU4NiVFOSU5NCU5OSVFOCVBRiVBRiVFOSU5NyVBRSVFOSVBMiU5OCVFNSU4RiU5MSVFOSU4MCU4MSVFOCU4NyVCMyUzQyUyRnAlM0UlMEElMEElM0NwJTNFUmVwb3J0JTQwZ2xvYmFsLWVhZ2xlLmNuJTNDJTJGcCUzRSUwQSUwQSUzQ3AlM0UlMjZuYnNwJTNCJTNDJTJGcCUzRSUwQQ==');
INSERT INTO `s_help` VALUES ('5', '3', '申请Svip账户', 'JTNDcCUzRSVFNCVCOCU4RCVFNyU5NCVBOCVFNCVCOCU4QiVFOCVBRSVBMiVFNSU4RCU5NSVFRiVCQyU4QyVFNSU4RiVBRiVFNyU5QiVCNCVFNiU4RSVBNSVFNiU5RiVBNSVFOCVBRiVBMiUzQyUyRnAlM0UlMEElMEElM0NwJTNFJUU4JUFGJUI3JUU4JTgxJTk0JUU3JUIzJUJCNDAwNzcyOTAyOSUzQyUyRnAlM0UlMEE=');
INSERT INTO `s_help` VALUES ('6', '3', '数据报告发现是旧的数据', 'JTNDcCUzRSVFNiU5NSVCMCVFNiU4RCVBRSVFNiU4QSVBNSVFNSU5MSU4QSVFNiU5OCVBRiVFNCVCOCVCQSVFNSVBRSU5QSVFNiU5QyU5RiVFNiU5QiVCNCVFNiU5NiVCMCVFRiVCQyU4QyVFNSU4RiVBRiVFOCU4MyVCRCVFNSVBRCU5OCVFNSU5QyVBOCVFNCVCOCU4MCVFNSVBRSU5QSVFNyU5QSU4NCVFNiU5NyVCNiVFNiU5NSU4OCVFNiU4MCVBNyUzQyUyRnAlM0UlMEE=');

-- ----------------------------
-- Table structure for s_help_cate
-- ----------------------------
DROP TABLE IF EXISTS `s_help_cate`;
CREATE TABLE `s_help_cate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_help_cate
-- ----------------------------
INSERT INTO `s_help_cate` VALUES ('1', '账户管理');
INSERT INTO `s_help_cate` VALUES ('3', '中国报告相关问题');
INSERT INTO `s_help_cate` VALUES ('4', '国际报告相关问题');
INSERT INTO `s_help_cate` VALUES ('5', '注册及登陆');
INSERT INTO `s_help_cate` VALUES ('7', '订单管理');
INSERT INTO `s_help_cate` VALUES ('8', '我的报告管理');

-- ----------------------------
-- Table structure for s_list_col
-- ----------------------------
DROP TABLE IF EXISTS `s_list_col`;
CREATE TABLE `s_list_col` (
  `id` varchar(20) NOT NULL,
  `title` varchar(45) NOT NULL COMMENT '表头标题显示名',
  `col_name` varchar(45) NOT NULL COMMENT '绑定字段名',
  `type` char(1) NOT NULL DEFAULT '0' COMMENT '类型\n0-显示\n1-隐藏域',
  `format` varchar(45) DEFAULT NULL COMMENT '格式化类型\n如\ndate@yyyy-MM-dd\nnumber@0.##',
  `sort` int(11) NOT NULL COMMENT '排序',
  `menu_id` varchar(20) NOT NULL,
  `menu_category_id` varchar(20) NOT NULL,
  PRIMARY KEY (`id`,`menu_id`,`menu_category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_list_col
-- ----------------------------

-- ----------------------------
-- Table structure for s_menu
-- ----------------------------
DROP TABLE IF EXISTS `s_menu`;
CREATE TABLE `s_menu` (
  `id` varchar(20) NOT NULL COMMENT '页面上菜单ID采用menu+ID',
  `category_id` varchar(20) NOT NULL COMMENT '所属分类',
  `name` varchar(45) NOT NULL COMMENT '菜单显示名',
  `icon` varchar(45) DEFAULT NULL COMMENT '菜单图标样式名',
  `url` varchar(500) NOT NULL COMMENT '菜单链接',
  `form_url` varchar(500) DEFAULT NULL COMMENT '表单链接',
  `query_sql` varchar(1000) DEFAULT NULL COMMENT '列表查询sql，与condition_group联用',
  `enable` bit(1) NOT NULL COMMENT '是否启用',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '序号，页面显示时根据序号排序',
  `is_sys` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否内置，不允许前台修改',
  PRIMARY KEY (`id`,`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_menu
-- ----------------------------

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_id` varchar(20) DEFAULT NULL,
  `corp_id` varchar(20) DEFAULT NULL,
  `code` varchar(45) NOT NULL COMMENT '工号/登陆名',
  `passwd` varchar(45) NOT NULL COMMENT '密码',
  `name` varchar(45) NOT NULL COMMENT '姓名',
  `theme` varchar(45) DEFAULT 'default',
  `idcard` varchar(45) DEFAULT NULL COMMENT '身份证号',
  `phone` varchar(45) DEFAULT NULL COMMENT '家庭电话',
  `addr` varchar(200) DEFAULT NULL COMMENT '地址',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `login_count` int(11) DEFAULT '0' COMMENT '登陆次数',
  `last_time` datetime DEFAULT NULL COMMENT '上次登陆时间',
  `enable` bit(1) DEFAULT NULL COMMENT '是否启用',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建人',
  `sex` char(2) DEFAULT NULL COMMENT '性别\n男/女/无',
  `birthday` date DEFAULT NULL COMMENT '出生年月',
  `mobile` varchar(45) DEFAULT NULL COMMENT '手机',
  `other_contact` varchar(45) DEFAULT NULL COMMENT '其它联系方式',
  `sos_person` varchar(45) DEFAULT NULL COMMENT '紧急联系人',
  `sos_mobile` varchar(45) DEFAULT NULL COMMENT '紧急联系人手机',
  `born_place` varchar(45) DEFAULT NULL COMMENT '户籍',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
-- ----------------------------
-- Table structure for search
-- ----------------------------
DROP TABLE IF EXISTS `search`;
CREATE TABLE `search` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(40) DEFAULT NULL COMMENT '公司名',
  `crefo_no` varchar(40) DEFAULT NULL COMMENT 'crefo编码',
  `reg_id` varchar(40) DEFAULT NULL COMMENT '注册号',
  `local` varchar(40) DEFAULT NULL COMMENT '地区',
  `url` varchar(40) DEFAULT NULL COMMENT '网址',
  `status` varchar(40) DEFAULT NULL COMMENT '状态',
  `search_type` varchar(40) DEFAULT NULL COMMENT '查询种类',
  `content` text COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of search
-- ----------------------------