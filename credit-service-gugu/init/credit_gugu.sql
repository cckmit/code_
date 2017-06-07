/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.185
Source Server Version : 50635
Source Host           : 192.168.1.185:3306
Source Database       : credit_gugu

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-05-06 16:52:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for business_card
-- ----------------------------
DROP TABLE IF EXISTS `business_card`;
CREATE TABLE `business_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `area_code` varchar(255) DEFAULT NULL COMMENT '电话区号',
  `card_address` varchar(255) DEFAULT NULL COMMENT '地址',
  `card_company` varchar(255) NOT NULL COMMENT '公司名称',
  `card_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `card_fax` varchar(255) DEFAULT NULL COMMENT '传真',
  `card_name` varchar(255) NOT NULL COMMENT '名字',
  `card_note` varchar(255) DEFAULT NULL COMMENT '沟通备注数',
  `card_phone` varchar(255) NOT NULL COMMENT '手机',
  `card_position` varchar(255) DEFAULT NULL COMMENT '职位',
  `card_tel` varchar(255) DEFAULT NULL COMMENT '电话',
  `card_website` varchar(255) DEFAULT NULL COMMENT '网址',
  `card_zip` varchar(255) DEFAULT NULL COMMENT '邮编',
  `business_card_no` varchar(255) NOT NULL COMMENT '名片号码',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志(1:不删除，其他删除)',
  `photo_path` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `update_time` datetime DEFAULT NULL COMMENT '新增时间',
  `user_id` int(11) NOT NULL COMMENT '用户ID(必填，不得修改)',
  `credit_certification` varchar(255) DEFAULT NULL COMMENT '信用认证标签(1：已认证)',
  `credit_verification` varchar(255) DEFAULT NULL COMMENT '名片核实标签(1：已核实)',
  `monitor` varchar(255) DEFAULT NULL COMMENT '监踪标签(1：已监踪)',
  `order_id` int(11) DEFAULT NULL COMMENT '订单Id',
  `verification_score` int(11) DEFAULT NULL COMMENT '核实分数',
  `verification_update_time` datetime DEFAULT NULL COMMENT '核实日期',
  `verfication_id` int(11) DEFAULT NULL COMMENT '核实ID',
  `monitor_id` int(11) DEFAULT NULL COMMENT '监踪ID',
  `card_common` varchar(255) DEFAULT NULL COMMENT '常用名录',
  `card_partner` varchar(255) DEFAULT NULL COMMENT '合作伙伴',
  `show_photo_path` varchar(255) DEFAULT NULL COMMENT '名片头像路径',
  `binding_card_id` varchar(255) DEFAULT NULL COMMENT '绑定名片ID(1.ID号绑定,如果绑定的是自己的ID则代表是自己的名片)',
  `update_flag` varchar(255) DEFAULT NULL COMMENT '标识下载(1:最新更新，0：已下载更新)',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `credit_certification_id` int(11) DEFAULT NULL COMMENT '认证ID',
  `repayment_index` varchar(255) DEFAULT NULL COMMENT '偿还指数',
  `credit_risk_evaluation` varchar(255) DEFAULT NULL COMMENT '信用风险评级',
  `certification_id` int(11) DEFAULT NULL COMMENT '认证id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_card
-- ----------------------------
INSERT INTO `business_card` VALUES ('117', null, '逸仙路2816号b栋12层', '', '', null, '顾', '0', '15821369435', '总裁', null, null, '', 'GU15BDBCE1FC7', null, 'group1/M00/00/0E/wKgBKE8HyE-AZDiRAAL7dbvcu_4532.jpg', '2017-05-06 16:47:43', '47', '1', '1', null, null, '20', '2017-05-06 13:08:23', '24', null, '1', '1', null, '0', null, '2017-05-06 11:29:31', null, null, null, '77');
INSERT INTO `business_card` VALUES ('118', '+8621', '中国上海市逸仙路2816号华滋奔腾大厦B幢12层', '商安信(上海)企业管理咨询股份有限公司', 'aaron.lu@3acredit.com', '', '陆歆煜', '0', '+8613801808362', '执行副总裁', '36386226', 'www.3acredit.cn', '200441', 'GU15BDCD54F05', '', 'group1/M00/00/0E/wKgBKE8HwoGAW1n-AAAUJuMJmaw536.jpg', '2017-05-06 16:16:59', '45', '', '1', '', null, '20', '2017-05-06 16:18:29', '100', null, '', '', '', '', '', '2017-05-06 16:16:59', null, '', '', null);
INSERT INTO `business_card` VALUES ('119', '+8621', '中国上海市逸仙路2816号华滋奔腾大厦B幢12层', '商安信(上海)企业管理咨询股份有限公司', 'aaron.lu@3acredit.com', '', '陆歆煜', '0', '+8613801808362', '执行副总裁', '36386226', 'www.3acredit.cn', '200441', 'GU15BDCD59067', '', 'group1/M00/00/0E/wKgBKE8HwpKAexmwAADzPP4q9rA096.jpg', '2017-05-06 16:17:16', '45', '', '1', '', null, '20', '2017-05-06 16:17:36', '86', null, '', '', '', '', '', '2017-05-06 16:17:15', null, '', '', null);
INSERT INTO `business_card` VALUES ('120', '+8621', '中国上海市逸仙路2816号华滋奔腾大厦B幢12层', '商安信(上海)企业管理咨询股份有限公司', 'aaron.lu@3acredit.com', '', '陆歆煜', '0', '+8613801808362', '执行副总裁', '36386226', 'www.3acredit.cn', '200441', 'GU15BDCDB76E1', '', 'group1/M00/00/0E/wKgBKE8HxBqADEQVAAAUJuMJmaw988.jpg', '2017-05-06 16:23:48', '45', '', '1', '', null, '20', '2017-05-06 16:24:08', '101', null, '', '', '', '', '', '2017-05-06 16:23:42', null, '', '', null);

-- ----------------------------
-- Table structure for business_card_extend
-- ----------------------------
DROP TABLE IF EXISTS `business_card_extend`;
CREATE TABLE `business_card_extend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `card_id` int(11) NOT NULL COMMENT '关联名片ID',
  `type` varchar(255) NOT NULL COMMENT '扩展类型(mobile,email,fax,web,zip)',
  `param_type` varchar(255) DEFAULT NULL COMMENT '参数类型(住宅,工作,iPhone,手机,主要,其他)',
  `param1` varchar(255) DEFAULT NULL COMMENT '参数1',
  `param2` varchar(255) DEFAULT NULL COMMENT '参数2',
  `param_ext` varchar(255) DEFAULT NULL COMMENT '参数扩展',
  `param_note` varchar(255) DEFAULT NULL COMMENT '参数备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2698 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of business_card_extend
-- ----------------------------
INSERT INTO `business_card_extend` VALUES ('2377', '118', 'mobile', null, null, '+8613801808362', null, '268,570,310,570,310,926,268,926');
INSERT INTO `business_card_extend` VALUES ('2378', '118', 'tel', null, '+8621', '36386226', null, '331,430,372,430,372,926,331,926');
INSERT INTO `business_card_extend` VALUES ('2379', '118', 'email', null, null, 'aaron.lu@3acredit.com', null, '201,491,249,491,249,925,201,925');
INSERT INTO `business_card_extend` VALUES ('2380', '118', 'web', null, null, 'www.3acredit.cn', null, '138,611,185,611,185,926,138,926');
INSERT INTO `business_card_extend` VALUES ('2381', '118', 'zip', null, null, '200441', null, null);
INSERT INTO `business_card_extend` VALUES ('2382', '118', 'fax', null, null, '36386718', null, null);
INSERT INTO `business_card_extend` VALUES ('2383', '119', 'mobile', null, null, '+8613801808362', null, '268,570,310,570,310,926,268,926');
INSERT INTO `business_card_extend` VALUES ('2384', '119', 'tel', null, '+8621', '36386226', null, '331,430,372,430,372,926,331,926');
INSERT INTO `business_card_extend` VALUES ('2385', '119', 'email', null, null, 'aaron.lu@3acredit.com', null, '201,491,249,491,249,925,201,925');
INSERT INTO `business_card_extend` VALUES ('2386', '119', 'web', null, null, 'www.3acredit.cn', null, '138,611,185,611,185,926,138,926');
INSERT INTO `business_card_extend` VALUES ('2387', '119', 'zip', null, null, '200441', null, null);
INSERT INTO `business_card_extend` VALUES ('2388', '119', 'fax', null, null, '36386718', null, null);
INSERT INTO `business_card_extend` VALUES ('2403', '120', 'mobile', null, null, '+8613801808362', null, '268,570,310,570,310,926,268,926');
INSERT INTO `business_card_extend` VALUES ('2404', '120', 'tel', null, '+8621', '36386226', null, '331,430,372,430,372,926,331,926');
INSERT INTO `business_card_extend` VALUES ('2405', '120', 'email', null, null, 'aaron.lu@3acredit.com', null, '201,491,249,491,249,925,201,925');
INSERT INTO `business_card_extend` VALUES ('2406', '120', 'web', null, null, 'www.3acredit.cn', null, '138,611,185,611,185,926,138,926');
INSERT INTO `business_card_extend` VALUES ('2407', '120', 'zip', null, null, '200441', null, null);
INSERT INTO `business_card_extend` VALUES ('2408', '120', 'fax', null, null, '36386718', null, null);
INSERT INTO `business_card_extend` VALUES ('2678', '117', 'tel', null, '021', '36655544', null, null);
INSERT INTO `business_card_extend` VALUES ('2679', '117', 'mobile', null, null, '15821369435', null, null);
INSERT INTO `business_card_extend` VALUES ('2680', '117', 'web', null, null, 'www.cim', null, null);
INSERT INTO `business_card_extend` VALUES ('2681', '117', 'email', null, null, '8627441@qq.com', null, null);
INSERT INTO `business_card_extend` VALUES ('2682', '117', 'zip', null, null, '2000554', null, null);
INSERT INTO `business_card_extend` VALUES ('2683', '117', 'fax', null, null, '26987896', null, null);
INSERT INTO `business_card_extend` VALUES ('2684', '117', 'web', '网址', null, '', null, null);
INSERT INTO `business_card_extend` VALUES ('2685', '117', 'zip', '邮编', null, null, null, null);
INSERT INTO `business_card_extend` VALUES ('2686', '117', 'zip', '邮编', null, null, null, null);
INSERT INTO `business_card_extend` VALUES ('2687', '117', 'fax', '传真', null, null, null, null);
INSERT INTO `business_card_extend` VALUES ('2688', '117', 'fax', '传真', null, null, null, null);
INSERT INTO `business_card_extend` VALUES ('2689', '117', 'fax', '传真', null, null, null, null);
INSERT INTO `business_card_extend` VALUES ('2690', '117', 'fax', '传真', null, null, null, null);
INSERT INTO `business_card_extend` VALUES ('2691', '117', 'mobile', '手机*', null, '15821369111', null, null);
INSERT INTO `business_card_extend` VALUES ('2692', '117', 'tel', '座机', '321', '6636542', null, null);
INSERT INTO `business_card_extend` VALUES ('2693', '117', 'zip', '邮编', null, null, null, null);
INSERT INTO `business_card_extend` VALUES ('2694', '117', 'email', '邮箱', null, null, null, null);
INSERT INTO `business_card_extend` VALUES ('2695', '117', 'email', '邮箱', null, null, null, null);
INSERT INTO `business_card_extend` VALUES ('2696', '117', 'email', '邮箱', null, null, null, null);
INSERT INTO `business_card_extend` VALUES ('2697', '117', 'tel', '座机', null, null, null, null);

-- ----------------------------
-- Table structure for card_note
-- ----------------------------
DROP TABLE IF EXISTS `card_note`;
CREATE TABLE `card_note` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_card_id` int(11) NOT NULL COMMENT '名片Id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志(1:不删除，其他删除)',
  `add_flag` varchar(255) DEFAULT NULL COMMENT '添加来源标识(1：用户自己添加 其他是系统添加)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card_note
-- ----------------------------
INSERT INTO `card_note` VALUES ('77', '117', '45', '发送邮件', '发送邮件至：(null)', '2017-05-06 11:59:22', '2', '2');
INSERT INTO `card_note` VALUES ('78', '117', '45', '拨打手机', '拨打手机至：18721411720', '2017-05-06 11:59:38', '2', '2');
INSERT INTO `card_note` VALUES ('79', '117', '45', '查看公司地图位置', '查看公司位置:逸仙路2816号b栋12层', '2017-05-06 12:01:40', '2', '2');

-- ----------------------------
-- Table structure for city_code
-- ----------------------------
DROP TABLE IF EXISTS `city_code`;
CREATE TABLE `city_code` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `p_id` int(10) NOT NULL COMMENT '省ID',
  `name_cn` varchar(50) NOT NULL COMMENT '中文名称',
  `name_en` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `del_flag` varchar(2) NOT NULL COMMENT '删除标志',
  `order_by` varchar(255) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `sdfas` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6591 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city_code
-- ----------------------------
INSERT INTO `city_code` VALUES ('2309', '23', '七台河市', 'Qitaihe', '1', null);
INSERT INTO `city_code` VALUES ('4602', '46', '三亚市', 'Sanya', '1', null);
INSERT INTO `city_code` VALUES ('3504', '35', '三明市', 'Sanming', '1', null);
INSERT INTO `city_code` VALUES ('4112', '41', '三门峡市', 'Sanmenxia', '1', null);
INSERT INTO `city_code` VALUES ('31', '2', '上海市', 'Shanghai', '1', null);
INSERT INTO `city_code` VALUES ('3611', '36', '上饶市', 'Shangrao', '1', null);
INSERT INTO `city_code` VALUES ('4419', '44', '东莞市', 'Dongguan', '1', null);
INSERT INTO `city_code` VALUES ('3705', '37', '东营市', 'Dongying', '1', null);
INSERT INTO `city_code` VALUES ('6405', '64', '中卫市', 'Zhongwei', '1', null);
INSERT INTO `city_code` VALUES ('4420', '44', '中山市', 'Zhongshan', '1', null);
INSERT INTO `city_code` VALUES ('6229', '62', '临夏回族自治州', 'Hui Autonomous Prefecture, Linxia', '1', null);
INSERT INTO `city_code` VALUES ('1410', '14', '临汾市', 'Linfen', '1', null);
INSERT INTO `city_code` VALUES ('3713', '37', '临沂市', 'Linyi', '1', null);
INSERT INTO `city_code` VALUES ('5309', '53', '临沧市', 'Lincang', '1', null);
INSERT INTO `city_code` VALUES ('2106', '21', '丹东市', 'Dandong', '1', null);
INSERT INTO `city_code` VALUES ('3311', '33', '丽水市', 'Lishui', '1', null);
INSERT INTO `city_code` VALUES ('5307', '53', '丽江市', 'Lijiang', '1', null);
INSERT INTO `city_code` VALUES ('1509', '15', '乌兰察布市', 'Wulanchabu', '1', null);
INSERT INTO `city_code` VALUES ('1503', '15', '乌海市', 'Wuhai', '1', null);
INSERT INTO `city_code` VALUES ('6501', '65', '乌鲁木齐市', 'Wulumuqi', '1', null);
INSERT INTO `city_code` VALUES ('5111', '51', '乐山市', 'Leshan', '1', null);
INSERT INTO `city_code` VALUES ('3604', '36', '九江市', 'Jiujiang', '1', null);
INSERT INTO `city_code` VALUES ('4453', '44', '云浮市', 'Yunfu', '1', null);
INSERT INTO `city_code` VALUES ('3416', '34', '亳州市', 'Bozhou', '1', null);
INSERT INTO `city_code` VALUES ('2307', '23', '伊春市', 'Yichun', '1', null);
INSERT INTO `city_code` VALUES ('6540', '65', '伊犁哈萨克自治州', 'Kazak Autonomous Prefecture, Yili', '1', null);
INSERT INTO `city_code` VALUES ('4406', '44', '佛山市', 'Foshan', '1', null);
INSERT INTO `city_code` VALUES ('2308', '23', '佳木斯市', 'Jiamusi', '1', null);
INSERT INTO `city_code` VALUES ('1306', '13', '保定市', 'Baoding', '1', null);
INSERT INTO `city_code` VALUES ('5305', '53', '保山市', 'Baoshan', '1', null);
INSERT INTO `city_code` VALUES ('4115', '41', '信阳市', 'Xinyang', '1', null);
INSERT INTO `city_code` VALUES ('6530', '65', '克孜勒苏柯尔克孜自治州', 'Kergez Autonomous Prefecture Of Kizilsu', '1', null);
INSERT INTO `city_code` VALUES ('6502', '65', '克拉玛依市', 'Kelamayi', '1', null);
INSERT INTO `city_code` VALUES ('3415', '34', '六安市', 'Liuan', '1', null);
INSERT INTO `city_code` VALUES ('5202', '52', '六盘水市', 'Liupanshui', '1', null);
INSERT INTO `city_code` VALUES ('6201', '62', '兰州市', 'Lanzhou', '1', null);
INSERT INTO `city_code` VALUES ('1522', '15', '兴安盟', 'Xingan', '1', null);
INSERT INTO `city_code` VALUES ('5110', '51', '内江市', 'Neijiang', '1', null);
INSERT INTO `city_code` VALUES ('5134', '51', '凉山彝族自治州', 'Yi Autonomous Prefecture, Liangshan', '1', null);
INSERT INTO `city_code` VALUES ('1502', '15', '包头市', 'Baotou', '1', null);
INSERT INTO `city_code` VALUES ('11', '1', '北京市', 'Beijing', '1', null);
INSERT INTO `city_code` VALUES ('4505', '45', '北海市', 'Beihai', '1', null);
INSERT INTO `city_code` VALUES ('4203', '42', '十堰市', 'Shiyan', '1', null);
INSERT INTO `city_code` VALUES ('3201', '32', '南京市', 'Nanjing', '1', null);
INSERT INTO `city_code` VALUES ('5113', '51', '南充市', 'Nanchong', '1', null);
INSERT INTO `city_code` VALUES ('4501', '45', '南宁市', 'Nanning', '1', null);
INSERT INTO `city_code` VALUES ('3507', '35', '南平市', 'Nanping', '1', null);
INSERT INTO `city_code` VALUES ('3601', '36', '南昌市', 'Nanchang', '1', null);
INSERT INTO `city_code` VALUES ('3206', '32', '南通市', 'Nantong', '1', null);
INSERT INTO `city_code` VALUES ('4113', '41', '南阳市', 'Nanyang', '1', null);
INSERT INTO `city_code` VALUES ('6527', '65', '博尔塔拉蒙古自治州', 'Boertala', '1', null);
INSERT INTO `city_code` VALUES ('3502', '35', '厦门市', 'Xiamen', '1', null);
INSERT INTO `city_code` VALUES ('2305', '23', '双鸭山市', 'Shuangyashan', '1', null);
INSERT INTO `city_code` VALUES ('3310', '33', '台州市', 'Taizhou', '1', null);
INSERT INTO `city_code` VALUES ('3401', '34', '合肥市', 'Hefei', '1', null);
INSERT INTO `city_code` VALUES ('3608', '36', '吉安市', 'Jian', '1', null);
INSERT INTO `city_code` VALUES ('2202', '22', '吉林市', 'Jilin', '1', null);
INSERT INTO `city_code` VALUES ('6521', '65', '吐鲁番地区', 'Tulufan', '1', null);
INSERT INTO `city_code` VALUES ('1411', '14', '吕梁市', 'Lu:liang', '1', null);
INSERT INTO `city_code` VALUES ('6403', '64', '吴忠市', 'Wuzhong', '1', null);
INSERT INTO `city_code` VALUES ('4116', '41', '周口市', 'Zhoukou', '1', null);
INSERT INTO `city_code` VALUES ('1507', '15', '呼伦贝尔市', 'Hulunbeier', '1', null);
INSERT INTO `city_code` VALUES ('1501', '15', '呼和浩特市', 'Huhehaote', '1', null);
INSERT INTO `city_code` VALUES ('6532', '65', '和田地区', 'Hetian', '1', null);
INSERT INTO `city_code` VALUES ('4212', '42', '咸宁市', 'Xianning', '1', null);
INSERT INTO `city_code` VALUES ('6104', '61', '咸阳市', 'Xianyang', '1', null);
INSERT INTO `city_code` VALUES ('6522', '65', '哈密地区', 'Hami', '1', null);
INSERT INTO `city_code` VALUES ('2301', '23', '哈尔滨市', 'Harbin', '1', null);
INSERT INTO `city_code` VALUES ('1302', '13', '唐山市', 'Tangshan', '1', null);
INSERT INTO `city_code` VALUES ('4114', '41', '商丘市', 'Shangqiu', '1', null);
INSERT INTO `city_code` VALUES ('6110', '61', '商洛市', 'Shangluo', '1', null);
INSERT INTO `city_code` VALUES ('6531', '65', '喀什地区', 'Kashen', '1', null);
INSERT INTO `city_code` VALUES ('3304', '33', '嘉兴市', 'Jiaxing', '1', null);
INSERT INTO `city_code` VALUES ('6202', '62', '嘉峪关市', 'Jiayuguan', '1', null);
INSERT INTO `city_code` VALUES ('2203', '22', '四平市', 'Siping', '1', null);
INSERT INTO `city_code` VALUES ('6404', '64', '固原市', 'Guyuan', '1', null);
INSERT INTO `city_code` VALUES ('6542', '65', '塔城地区', 'Tacheng', '1', null);
INSERT INTO `city_code` VALUES ('2327', '23', '大兴安岭地区', 'Daxinganling', '1', null);
INSERT INTO `city_code` VALUES ('1402', '14', '大同市', 'Datong', '1', null);
INSERT INTO `city_code` VALUES ('2306', '23', '大庆市', 'Daqing', '1', null);
INSERT INTO `city_code` VALUES ('5329', '53', '大理白族自治州', 'Bai Autonomous Prefecture, Dali', '1', null);
INSERT INTO `city_code` VALUES ('2102', '21', '大连市', 'Dalian', '1', null);
INSERT INTO `city_code` VALUES ('6205', '62', '天水市', 'Tianshui', '1', null);
INSERT INTO `city_code` VALUES ('12', '3', '天津市', 'Tianjin', '1', null);
INSERT INTO `city_code` VALUES ('1401', '14', '太原市', 'Taiyuan', '1', null);
INSERT INTO `city_code` VALUES ('3710', '37', '威海市', 'Weihai', '1', null);
INSERT INTO `city_code` VALUES ('4313', '43', '娄底市', 'Loudi', '1', null);
INSERT INTO `city_code` VALUES ('4209', '42', '孝感市', 'Xiaogan', '1', null);
INSERT INTO `city_code` VALUES ('3509', '35', '宁德市', 'Ningde City', '1', null);
INSERT INTO `city_code` VALUES ('3302', '33', '宁波市', 'Ningbo', '1', null);
INSERT INTO `city_code` VALUES ('3408', '34', '安庆市', 'Anqing', '1', null);
INSERT INTO `city_code` VALUES ('6109', '61', '安康市', 'Ankang', '1', null);
INSERT INTO `city_code` VALUES ('4105', '41', '安阳市', 'Anyang', '1', null);
INSERT INTO `city_code` VALUES ('5204', '52', '安顺市', 'Anshun', '1', null);
INSERT INTO `city_code` VALUES ('6211', '62', '定西市', 'Dingxi', '1', null);
INSERT INTO `city_code` VALUES ('5115', '51', '宜宾市', 'Yibin', '1', null);
INSERT INTO `city_code` VALUES ('4205', '42', '宜昌市', 'Yichang', '1', null);
INSERT INTO `city_code` VALUES ('3609', '36', '宜春市', 'Yichun', '1', null);
INSERT INTO `city_code` VALUES ('6103', '61', '宝鸡市', 'Baoji', '1', null);
INSERT INTO `city_code` VALUES ('3418', '34', '宣城市', 'Xuancheng', '1', null);
INSERT INTO `city_code` VALUES ('3413', '34', '宿州市', 'Suzhou', '1', null);
INSERT INTO `city_code` VALUES ('3213', '32', '宿迁市', 'Suqian', '1', null);
INSERT INTO `city_code` VALUES ('5422', '54', '山南地区', 'Shannan', '1', null);
INSERT INTO `city_code` VALUES ('4306', '43', '岳阳市', 'Yueyang', '1', null);
INSERT INTO `city_code` VALUES ('4514', '45', '崇左市', 'Chongzuo', '1', null);
INSERT INTO `city_code` VALUES ('5119', '51', '巴中市', 'Bazhong', '1', null);
INSERT INTO `city_code` VALUES ('1508', '15', '巴彦淖尔市', 'Bayannaoer', '1', null);
INSERT INTO `city_code` VALUES ('6528', '65', '巴音郭楞蒙古自治州', 'Bayinguoleng', '1', null);
INSERT INTO `city_code` VALUES ('3204', '32', '常州市', 'Changzhou', '1', null);
INSERT INTO `city_code` VALUES ('4307', '43', '常德市', 'Changde', '1', null);
INSERT INTO `city_code` VALUES ('6208', '62', '平凉市', 'Pingliang', '1', null);
INSERT INTO `city_code` VALUES ('4104', '41', '平顶山市', 'Pingdingshan', '1', null);
INSERT INTO `city_code` VALUES ('5108', '51', '广元市', 'Guangyuan', '1', null);
INSERT INTO `city_code` VALUES ('5116', '51', '广安市', 'Guangan', '1', null);
INSERT INTO `city_code` VALUES ('4401', '44', '广州市', 'Guangzhou', '1', null);
INSERT INTO `city_code` VALUES ('6210', '62', '庆阳市', 'Qingyang', '1', null);
INSERT INTO `city_code` VALUES ('1310', '13', '廊坊市', 'Langfang', '1', null);
INSERT INTO `city_code` VALUES ('6106', '61', '延安市', 'Yanan', '1', null);
INSERT INTO `city_code` VALUES ('2224', '22', '延边朝鲜族自治州', 'Yanbian', '1', null);
INSERT INTO `city_code` VALUES ('4102', '41', '开封市', 'Kaifeng', '1', null);
INSERT INTO `city_code` VALUES ('1307', '13', '张家口市', 'Zhangjiakou', '1', null);
INSERT INTO `city_code` VALUES ('4308', '43', '张家界市', 'Zhangjiajie', '1', null);
INSERT INTO `city_code` VALUES ('6207', '62', '张掖市', 'Zhangye', '1', null);
INSERT INTO `city_code` VALUES ('3203', '32', '徐州市', 'Xuzhou', '1', null);
INSERT INTO `city_code` VALUES ('5331', '53', '德宏傣族景颇族自治州', 'Dai And Jingpo Autonomous Prefecture, Dehong', '1', null);
INSERT INTO `city_code` VALUES ('3714', '37', '德州市', 'Dezhou', '1', null);
INSERT INTO `city_code` VALUES ('5106', '51', '德阳市', 'Deyang', '1', null);
INSERT INTO `city_code` VALUES ('1409', '14', '忻州市', 'Xinzhou', '1', null);
INSERT INTO `city_code` VALUES ('4312', '43', '怀化市', 'Huaihua', '1', null);
INSERT INTO `city_code` VALUES ('5333', '53', '怒江傈僳族自治州', 'Lisu Autonomous Prefecture, Nujiang', '1', null);
INSERT INTO `city_code` VALUES ('4228', '42', '恩施土家族苗族自治州', 'Tujia And Miao Autonomous Prefecture, Enshi', '1', null);
INSERT INTO `city_code` VALUES ('4413', '44', '惠州市', 'Huizhou', '1', null);
INSERT INTO `city_code` VALUES ('5101', '51', '成都市', 'chengdu', '1', null);
INSERT INTO `city_code` VALUES ('3210', '32', '扬州市', 'Yangzhou', '1', null);
INSERT INTO `city_code` VALUES ('1308', '13', '承德市', 'Chengde', '1', null);
INSERT INTO `city_code` VALUES ('3610', '36', '抚州市', 'Fuzhou', '1', null);
INSERT INTO `city_code` VALUES ('2104', '21', '抚顺市', 'Fushun', '1', null);
INSERT INTO `city_code` VALUES ('5401', '54', '拉萨市', 'Lasa', '1', null);
INSERT INTO `city_code` VALUES ('4452', '44', '揭阳市', 'Jieyang', '1', null);
INSERT INTO `city_code` VALUES ('5104', '51', '攀枝花市', 'Panzhihua', '1', null);
INSERT INTO `city_code` VALUES ('5326', '53', '文山壮族苗族自治州', 'Zhuang And Miao Autonomous Prefecture, Wenshan', '1', null);
INSERT INTO `city_code` VALUES ('4107', '41', '新乡市', 'Xinxiang', '1', null);
INSERT INTO `city_code` VALUES ('3605', '36', '新余市', 'Xinyu', '1', null);
INSERT INTO `city_code` VALUES ('3202', '32', '无锡市', 'Wuxi', '1', null);
INSERT INTO `city_code` VALUES ('5423', '54', '日喀则地区', 'Rikaze', '1', null);
INSERT INTO `city_code` VALUES ('3711', '37', '日照市', 'Rizhao', '1', null);
INSERT INTO `city_code` VALUES ('5301', '53', '昆明市', 'Kunming', '1', null);
INSERT INTO `city_code` VALUES ('6523', '65', '昌吉回族自治州', 'Hui Autonomous Prefecture, Changji', '1', null);
INSERT INTO `city_code` VALUES ('5421', '54', '昌都地区', 'Changdou', '1', null);
INSERT INTO `city_code` VALUES ('5306', '53', '昭通市', 'Zhaotong', '1', null);
INSERT INTO `city_code` VALUES ('1407', '14', '晋中市', 'Jinzhong', '1', null);
INSERT INTO `city_code` VALUES ('1405', '14', '晋城市', 'Jincheng', '1', null);
INSERT INTO `city_code` VALUES ('5308', '53', '普洱市', 'Market, Puer', '1', null);
INSERT INTO `city_code` VALUES ('3602', '36', '景德镇市', 'Jingdezhen', '1', null);
INSERT INTO `city_code` VALUES ('5303', '53', '曲靖市', 'Qujing', '1', null);
INSERT INTO `city_code` VALUES ('1406', '14', '朔州市', 'Shuozhou', '1', null);
INSERT INTO `city_code` VALUES ('2113', '21', '朝阳市', 'Chaoyang', '1', null);
INSERT INTO `city_code` VALUES ('2105', '21', '本溪市', 'Benxi', '1', null);
INSERT INTO `city_code` VALUES ('4513', '45', '来宾市', 'Laibin', '1', null);
INSERT INTO `city_code` VALUES ('3301', '33', '杭州市', 'Hangzhou', '1', null);
INSERT INTO `city_code` VALUES ('2207', '22', '松原市', 'Songyuan', '1', null);
INSERT INTO `city_code` VALUES ('5426', '54', '林芝地区', 'Linzhi', '1', null);
INSERT INTO `city_code` VALUES ('6326', '63', '果洛藏族自治州', 'Tibetan Autonomous Prefecture, Guoluo', '1', null);
INSERT INTO `city_code` VALUES ('3704', '37', '枣庄市', 'Zaozhuang', '1', null);
INSERT INTO `city_code` VALUES ('4502', '45', '柳州市', 'Liuzhou', '1', null);
INSERT INTO `city_code` VALUES ('4302', '43', '株洲市', 'Zhuzhou', '1', null);
INSERT INTO `city_code` VALUES ('4503', '45', '桂林市', 'Guilin', '1', null);
INSERT INTO `city_code` VALUES ('4414', '44', '梅州市', 'Meizhou', '1', null);
INSERT INTO `city_code` VALUES ('4504', '45', '梧州市', 'Wuzhou', '1', null);
INSERT INTO `city_code` VALUES ('5323', '53', '楚雄彝族自治州', 'Yi Autonomous Prefecture, Chuxiong', '1', null);
INSERT INTO `city_code` VALUES ('6108', '61', '榆林市', 'Yulin', '1', null);
INSERT INTO `city_code` VALUES ('6206', '62', '武威市', 'Wuwei', '1', null);
INSERT INTO `city_code` VALUES ('4201', '42', '武汉市', 'Wuhan', '1', null);
INSERT INTO `city_code` VALUES ('5205', '52', '毕节市', 'Market, Bijie', '1', null);
INSERT INTO `city_code` VALUES ('4311', '43', '永州市', 'Yongzhou', '1', null);
INSERT INTO `city_code` VALUES ('6107', '61', '汉中市', 'Hanzhong', '1', null);
INSERT INTO `city_code` VALUES ('4405', '44', '汕头市', 'Shantou', '1', null);
INSERT INTO `city_code` VALUES ('4415', '44', '汕尾市', 'Shanwei', '1', null);
INSERT INTO `city_code` VALUES ('4407', '44', '江门市', 'Jiangmen', '1', null);
INSERT INTO `city_code` VALUES ('3417', '34', '池州市', 'Chizhou', '1', null);
INSERT INTO `city_code` VALUES ('2101', '21', '沈阳市', 'Shenyang', '1', null);
INSERT INTO `city_code` VALUES ('1309', '13', '沧州市', 'Cangzhou', '1', null);
INSERT INTO `city_code` VALUES ('4512', '45', '河池市', 'Hechi', '1', null);
INSERT INTO `city_code` VALUES ('4416', '44', '河源市', 'Heyuan', '1', null);
INSERT INTO `city_code` VALUES ('3505', '35', '泉州市', 'Quanzhou', '1', null);
INSERT INTO `city_code` VALUES ('3709', '37', '泰安市', 'Taian', '1', null);
INSERT INTO `city_code` VALUES ('3212', '32', '泰州市', 'Taizhou', '1', null);
INSERT INTO `city_code` VALUES ('5105', '51', '泸州市', 'Luzhou', '1', null);
INSERT INTO `city_code` VALUES ('4103', '41', '洛阳市', 'Luoyang', '1', null);
INSERT INTO `city_code` VALUES ('3701', '37', '济南市', 'Jinan', '1', null);
INSERT INTO `city_code` VALUES ('3708', '37', '济宁市', 'Jining', '1', null);
INSERT INTO `city_code` VALUES ('6321', '63', '海东地区', 'Haidong', '1', null);
INSERT INTO `city_code` VALUES ('6322', '63', '海北藏族自治州', 'Tibetan Autonomous Prefecture, Haibei', '1', null);
INSERT INTO `city_code` VALUES ('6325', '63', '海南藏族自治州', 'Tibetan Autonomous Prefecture, Hainan', '1', null);
INSERT INTO `city_code` VALUES ('4601', '46', '海口市', 'Haikou', '1', null);
INSERT INTO `city_code` VALUES ('6328', '63', '海西蒙古族藏族自治州', 'Mongolia Tibetan Autonomous Prefecture, Haixi', '1', null);
INSERT INTO `city_code` VALUES ('3703', '37', '淄博市', 'Zibo', '1', null);
INSERT INTO `city_code` VALUES ('3406', '34', '淮北市', 'Huaibei', '1', null);
INSERT INTO `city_code` VALUES ('3404', '34', '淮南市', 'Huainan', '1', null);
INSERT INTO `city_code` VALUES ('3208', '32', '淮安市', 'Huaian', '1', null);
INSERT INTO `city_code` VALUES ('4403', '44', '深圳市', 'Shenzhen', '1', null);
INSERT INTO `city_code` VALUES ('4418', '44', '清远市', 'Qingyuan', '1', null);
INSERT INTO `city_code` VALUES ('3303', '33', '温州市', 'Wenzhou', '1', null);
INSERT INTO `city_code` VALUES ('6105', '61', '渭南市', 'Weinan', '1', null);
INSERT INTO `city_code` VALUES ('3305', '33', '湖州市', 'Huzhou', '1', null);
INSERT INTO `city_code` VALUES ('4303', '43', '湘潭市', 'Xiangtan', '1', null);
INSERT INTO `city_code` VALUES ('4331', '43', '湘西土家族苗族自治州', 'Xiangxi', '1', null);
INSERT INTO `city_code` VALUES ('4408', '44', '湛江市', 'Zhanjiang', '1', null);
INSERT INTO `city_code` VALUES ('3411', '34', '滁州市', 'Chuzhou', '1', null);
INSERT INTO `city_code` VALUES ('3716', '37', '滨州市', 'Binzhou', '1', null);
INSERT INTO `city_code` VALUES ('4111', '41', '漯河市', 'Luohe', '1', null);
INSERT INTO `city_code` VALUES ('3506', '35', '漳州市', 'Zhangzhou', '1', null);
INSERT INTO `city_code` VALUES ('3707', '37', '潍坊市', 'Weifang', '1', null);
INSERT INTO `city_code` VALUES ('4451', '44', '潮州市', 'Chaozhou', '1', null);
INSERT INTO `city_code` VALUES ('4109', '41', '濮阳市', 'Puyang', '1', null);
INSERT INTO `city_code` VALUES ('3706', '37', '烟台市', 'Yantai', '1', null);
INSERT INTO `city_code` VALUES ('4108', '41', '焦作市', 'Jiaozuo', '1', null);
INSERT INTO `city_code` VALUES ('2310', '23', '牡丹江市', 'Mudanjiang', '1', null);
INSERT INTO `city_code` VALUES ('4509', '45', '玉林市', 'Yulin', '1', null);
INSERT INTO `city_code` VALUES ('6327', '63', '玉树藏族自治州', 'Tibetan Autonomous Prefecture, Yushu', '1', null);
INSERT INTO `city_code` VALUES ('5304', '53', '玉溪市', 'Yuxi', '1', null);
INSERT INTO `city_code` VALUES ('4404', '44', '珠海市', 'Zhuhai', '1', null);
INSERT INTO `city_code` VALUES ('6230', '62', '甘南藏族自治州', 'Tibetan Autonomous Prefecture, Gannan', '1', null);
INSERT INTO `city_code` VALUES ('5133', '51', '甘孜藏族自治州', 'Ganzi', '1', null);
INSERT INTO `city_code` VALUES ('2208', '22', '白城市', 'Baicheng', '1', null);
INSERT INTO `city_code` VALUES ('2206', '22', '白山市', 'Baishan', '1', null);
INSERT INTO `city_code` VALUES ('6204', '62', '白银市', 'Baiyin', '1', null);
INSERT INTO `city_code` VALUES ('4510', '45', '百色市', 'Baise', '1', null);
INSERT INTO `city_code` VALUES ('4309', '43', '益阳市', 'Yiyang', '1', null);
INSERT INTO `city_code` VALUES ('3209', '32', '盐城市', 'Yancheng', '1', null);
INSERT INTO `city_code` VALUES ('2111', '21', '盘锦市', 'Panjin', '1', null);
INSERT INTO `city_code` VALUES ('4190', '41', '省直辖县级行政区划', ' Directly Under the Provincial Level Administrative Divisions', '1', null);
INSERT INTO `city_code` VALUES ('5114', '51', '眉山市', 'Meishan', '1', null);
INSERT INTO `city_code` VALUES ('6402', '64', '石嘴山市', 'Shizuishan', '1', null);
INSERT INTO `city_code` VALUES ('1301', '13', '石家庄市', 'Shijiazhuang', '1', null);
INSERT INTO `city_code` VALUES ('3501', '35', '福州市', 'Fuzhou', '1', null);
INSERT INTO `city_code` VALUES ('1303', '13', '秦皇岛市', 'Qinhuangdao', '1', null);
INSERT INTO `city_code` VALUES ('5325', '53', '红河哈尼族彝族自治州', 'Hani And Yi Autonomous Prefecture, Honghe', '1', null);
INSERT INTO `city_code` VALUES ('3306', '33', '绍兴市', 'Shaoxing', '1', null);
INSERT INTO `city_code` VALUES ('2312', '23', '绥化市', 'Suihua', '1', null);
INSERT INTO `city_code` VALUES ('5107', '51', '绵阳市', 'Mianyang', '1', null);
INSERT INTO `city_code` VALUES ('3715', '37', '聊城市', 'Liaocheng', '1', null);
INSERT INTO `city_code` VALUES ('4412', '44', '肇庆市', 'Zhaoqing', '1', null);
INSERT INTO `city_code` VALUES ('6590', '65', '自治区直辖县级行政区划', ' Autonomous Regions and Directly Under the County Administrative Divisions', '1', null);
INSERT INTO `city_code` VALUES ('5103', '51', '自贡市', 'Zigong', '1', null);
INSERT INTO `city_code` VALUES ('3309', '33', '舟山市', 'Zhoushan', '1', null);
INSERT INTO `city_code` VALUES ('3402', '34', '芜湖市', 'Wuhu', '1', null);
INSERT INTO `city_code` VALUES ('3205', '32', '苏州市', 'Suzhou', '1', null);
INSERT INTO `city_code` VALUES ('4409', '44', '茂名市', 'Maoming', '1', null);
INSERT INTO `city_code` VALUES ('4210', '42', '荆州市', 'Jingzhou', '1', null);
INSERT INTO `city_code` VALUES ('4208', '42', '荆门市', 'Jingmen', '1', null);
INSERT INTO `city_code` VALUES ('3503', '35', '莆田市', 'Putian', '1', null);
INSERT INTO `city_code` VALUES ('3712', '37', '莱芜市', 'Laiwu', '1', null);
INSERT INTO `city_code` VALUES ('3717', '37', '菏泽市', 'Heze', '1', null);
INSERT INTO `city_code` VALUES ('3603', '36', '萍乡市', 'Pingxiang', '1', null);
INSERT INTO `city_code` VALUES ('2108', '21', '营口市', 'Yingkou', '1', null);
INSERT INTO `city_code` VALUES ('2114', '21', '葫芦岛市', 'Huludao', '1', null);
INSERT INTO `city_code` VALUES ('3403', '34', '蚌埠市', 'Bangbu', '1', null);
INSERT INTO `city_code` VALUES ('1311', '13', '衡水市', 'Hengshui', '1', null);
INSERT INTO `city_code` VALUES ('4304', '43', '衡阳市', 'Hengyang', '1', null);
INSERT INTO `city_code` VALUES ('3308', '33', '衢州市', 'Quzhou', '1', null);
INSERT INTO `city_code` VALUES ('4206', '42', '襄阳市', 'Xiangyang City', '1', null);
INSERT INTO `city_code` VALUES ('5328', '53', '西双版纳傣族自治州', 'Dai Autonomous Prefecture, Xishuangbanna', '1', null);
INSERT INTO `city_code` VALUES ('6301', '63', '西宁市', 'Xining', '1', null);
INSERT INTO `city_code` VALUES ('6101', '61', '西安市', 'Xian', '1', null);
INSERT INTO `city_code` VALUES ('4110', '41', '许昌市', 'Xuchang', '1', null);
INSERT INTO `city_code` VALUES ('4508', '45', '贵港市', 'Guigang', '1', null);
INSERT INTO `city_code` VALUES ('5201', '52', '贵阳市', 'Guiyang', '1', null);
INSERT INTO `city_code` VALUES ('4511', '45', '贺州市', 'Hezhou', '1', null);
INSERT INTO `city_code` VALUES ('5120', '51', '资阳市', 'Ziyang', '1', null);
INSERT INTO `city_code` VALUES ('3607', '36', '赣州市', 'Ganzhou', '1', null);
INSERT INTO `city_code` VALUES ('1504', '15', '赤峰市', 'Chifeng', '1', null);
INSERT INTO `city_code` VALUES ('2204', '22', '辽源市', 'Liaoyuan', '1', null);
INSERT INTO `city_code` VALUES ('2110', '21', '辽阳市', 'Liaoyang', '1', null);
INSERT INTO `city_code` VALUES ('5117', '51', '达州市', 'Dazhou', '1', null);
INSERT INTO `city_code` VALUES ('1408', '14', '运城市', 'Yuncheng', '1', null);
INSERT INTO `city_code` VALUES ('3207', '32', '连云港市', 'Lianyungang', '1', null);
INSERT INTO `city_code` VALUES ('5334', '53', '迪庆藏族自治州', 'Tibetan Autonomous Prefecture, Diqing', '1', null);
INSERT INTO `city_code` VALUES ('2205', '22', '通化市', 'Tonghua', '1', null);
INSERT INTO `city_code` VALUES ('1505', '15', '通辽市', 'Tongliao', '1', null);
INSERT INTO `city_code` VALUES ('5109', '51', '遂宁市', 'Suining', '1', null);
INSERT INTO `city_code` VALUES ('5203', '52', '遵义市', 'Zunyi', '1', null);
INSERT INTO `city_code` VALUES ('1305', '13', '邢台市', 'Xingtai', '1', null);
INSERT INTO `city_code` VALUES ('5424', '54', '那曲地区', 'Neiqu', '1', null);
INSERT INTO `city_code` VALUES ('1304', '13', '邯郸市', 'Handan', '1', null);
INSERT INTO `city_code` VALUES ('4305', '43', '邵阳市', 'Shaoyang', '1', null);
INSERT INTO `city_code` VALUES ('4101', '41', '郑州市', 'Zhengzhou', '1', null);
INSERT INTO `city_code` VALUES ('4310', '43', '郴州市', 'Chenzhou', '1', null);
INSERT INTO `city_code` VALUES ('1506', '15', '鄂尔多斯市', 'Eerduosi', '1', null);
INSERT INTO `city_code` VALUES ('4207', '42', '鄂州市', 'Ezhou', '1', null);
INSERT INTO `city_code` VALUES ('6209', '62', '酒泉市', 'Jiuquan', '1', null);
INSERT INTO `city_code` VALUES ('50', '4', '重庆市', 'Chongqing', '1', null);
INSERT INTO `city_code` VALUES ('3307', '33', '金华市', 'Jinhua', '1', null);
INSERT INTO `city_code` VALUES ('6203', '62', '金昌市', 'Jinchang', '1', null);
INSERT INTO `city_code` VALUES ('4507', '45', '钦州市', 'Qinzhou', '1', null);
INSERT INTO `city_code` VALUES ('2112', '21', '铁岭市', 'Tieling', '1', null);
INSERT INTO `city_code` VALUES ('5206', '52', '铜仁市', 'Market, Tongren', '1', null);
INSERT INTO `city_code` VALUES ('6102', '61', '铜川市', 'Tongchuan', '1', null);
INSERT INTO `city_code` VALUES ('3407', '34', '铜陵市', 'Tongling', '1', null);
INSERT INTO `city_code` VALUES ('6401', '64', '银川市', 'Yinchuan', '1', null);
INSERT INTO `city_code` VALUES ('1525', '15', '锡林郭勒盟', 'Xilinguole', '1', null);
INSERT INTO `city_code` VALUES ('2107', '21', '锦州市', 'Jinzhou', '1', null);
INSERT INTO `city_code` VALUES ('3211', '32', '镇江市', 'Zhenjiang', '1', null);
INSERT INTO `city_code` VALUES ('2201', '22', '长春市', 'Changchun', '1', null);
INSERT INTO `city_code` VALUES ('4301', '43', '长沙市', 'Changsha', '1', null);
INSERT INTO `city_code` VALUES ('1404', '14', '长治市', 'Zhangzhi', '1', null);
INSERT INTO `city_code` VALUES ('2109', '21', '阜新市', 'Fuxin', '1', null);
INSERT INTO `city_code` VALUES ('3412', '34', '阜阳市', 'Fuyang', '1', null);
INSERT INTO `city_code` VALUES ('4506', '45', '防城港市', 'Fangchenggang', '1', null);
INSERT INTO `city_code` VALUES ('4417', '44', '阳江市', 'Yangjiang', '1', null);
INSERT INTO `city_code` VALUES ('1403', '14', '阳泉市', 'Yangquan', '1', null);
INSERT INTO `city_code` VALUES ('6529', '65', '阿克苏地区', 'Akesu', '1', null);
INSERT INTO `city_code` VALUES ('6543', '65', '阿勒泰地区', 'Aletai', '1', null);
INSERT INTO `city_code` VALUES ('5132', '51', '阿坝藏族羌族自治州', 'Tibetan And Qiang Autonomous Prefecture, Aba', '1', null);
INSERT INTO `city_code` VALUES ('1529', '15', '阿拉善盟', 'Alashan', '1', null);
INSERT INTO `city_code` VALUES ('5425', '54', '阿里地区', 'Ali', '1', null);
INSERT INTO `city_code` VALUES ('6212', '62', '陇南市', 'Longnan', '1', null);
INSERT INTO `city_code` VALUES ('4213', '42', '随州市', 'Suizhou', '1', null);
INSERT INTO `city_code` VALUES ('5118', '51', '雅安市', 'Yaan', '1', null);
INSERT INTO `city_code` VALUES ('3702', '37', '青岛市', 'Qingdao', '1', null);
INSERT INTO `city_code` VALUES ('2103', '21', '鞍山市', 'Anshan', '1', null);
INSERT INTO `city_code` VALUES ('4402', '44', '韶关市', 'Shaoguan', '1', null);
INSERT INTO `city_code` VALUES ('3405', '34', '马鞍山市', 'MaAnShan', '1', null);
INSERT INTO `city_code` VALUES ('4117', '41', '驻马店市', 'Zhumadian', '1', null);
INSERT INTO `city_code` VALUES ('2303', '23', '鸡西市', 'Jixi', '1', null);
INSERT INTO `city_code` VALUES ('4106', '41', '鹤壁市', 'Hebi', '1', null);
INSERT INTO `city_code` VALUES ('2304', '23', '鹤岗市', 'Hegang', '1', null);
INSERT INTO `city_code` VALUES ('3606', '36', '鹰潭市', 'Yingtan', '1', null);
INSERT INTO `city_code` VALUES ('4211', '42', '黄冈市', 'Huanggang', '1', null);
INSERT INTO `city_code` VALUES ('6323', '63', '黄南藏族自治州', 'Tibetan Autonomous Prefecture, Huangnan', '1', null);
INSERT INTO `city_code` VALUES ('3410', '34', '黄山市', 'Huangshan', '1', null);
INSERT INTO `city_code` VALUES ('4202', '42', '黄石市', 'Huangshi', '1', null);
INSERT INTO `city_code` VALUES ('2311', '23', '黑河市', 'Heihe', '1', null);
INSERT INTO `city_code` VALUES ('5226', '52', '黔东南苗族侗族自治州', 'Qiandongnan', '1', null);
INSERT INTO `city_code` VALUES ('5227', '52', '黔南布依族苗族自治州', 'Qiannan', '1', null);
INSERT INTO `city_code` VALUES ('5223', '52', '黔西南布依族苗族自治州', 'Buyei and Miao Autonomous Prefecture', '1', null);
INSERT INTO `city_code` VALUES ('2302', '23', '齐齐哈尔市', 'Qiqihaer', '1', null);
INSERT INTO `city_code` VALUES ('3508', '35', '龙岩市', 'Longyan', '1', null);

-- ----------------------------
-- Table structure for cn_basic_annua
-- ----------------------------
DROP TABLE IF EXISTS `cn_basic_annua`;
CREATE TABLE `cn_basic_annua` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `crefo_no` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `employee` varchar(255) DEFAULT NULL,
  `enterprise_status` varchar(255) DEFAULT NULL,
  `equity_transfer` varchar(255) DEFAULT NULL,
  `is_investment` varchar(255) DEFAULT NULL,
  `is_website` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `reg` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `affiliation` varchar(255) DEFAULT NULL,
  `funds_money` varchar(255) DEFAULT NULL,
  `is_guarantee_info` varchar(255) DEFAULT NULL,
  `operate_name` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fid` (`full_report_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=152 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_basic_annua
-- ----------------------------

-- ----------------------------
-- Table structure for cn_brands
-- ----------------------------
DROP TABLE IF EXISTS `cn_brands`;
CREATE TABLE `cn_brands` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `application_date` varchar(255) DEFAULT NULL,
  `application_number` varchar(255) DEFAULT NULL,
  `classification_number` varchar(255) DEFAULT NULL,
  `crefo_no` varchar(255) DEFAULT NULL,
  `patent_name` varchar(255) DEFAULT NULL,
  `release_date` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `apply_name` varchar(255) DEFAULT NULL,
  `case_status` varchar(255) DEFAULT NULL,
  `info_source` varchar(255) DEFAULT NULL,
  `inventor_name` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `priority` varchar(255) DEFAULT NULL,
  `proxy_info` varchar(255) DEFAULT NULL,
  `record_nature` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fid` (`full_report_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=255 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_brands
-- ----------------------------

-- ----------------------------
-- Table structure for cn_change_infos
-- ----------------------------
DROP TABLE IF EXISTS `cn_change_infos`;
CREATE TABLE `cn_change_infos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `after_cn` text,
  `after_en` text,
  `before_cn` text,
  `before_en` text,
  `change_date` varchar(255) DEFAULT NULL,
  `crefo_no` varchar(255) DEFAULT NULL,
  `company_type_id` int(11) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `change_type` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fid` (`full_report_id`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=3175 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_change_infos
-- ----------------------------

-- ----------------------------
-- Table structure for cn_executive
-- ----------------------------
DROP TABLE IF EXISTS `cn_executive`;
CREATE TABLE `cn_executive` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `currency_id` varchar(255) DEFAULT NULL,
  `status` text,
  `amount` text,
  `case_status_cn` varchar(255) DEFAULT NULL,
  `case_status_en` varchar(255) DEFAULT NULL,
  `child_check` varchar(255) DEFAULT NULL,
  `crefo_no` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `docket_no_cn` varchar(255) DEFAULT NULL,
  `docket_no_en` varchar(255) DEFAULT NULL,
  `enforcee_name_cn` varchar(255) DEFAULT NULL,
  `enforcee_name_en` varchar(255) DEFAULT NULL,
  `enterprise_court_name_cn` varchar(255) DEFAULT NULL,
  `enterprise_court_name_en` varchar(255) DEFAULT NULL,
  `enterprise_name_cn` varchar(255) DEFAULT NULL,
  `enterprise_name_en` varchar(255) DEFAULT NULL,
  `sort_time` varchar(255) DEFAULT NULL,
  `zxgg_id` varchar(255) DEFAULT NULL,
  `apply_name` varchar(255) DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `organizer_code` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `full_report_id` (`full_report_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of cn_executive
-- ----------------------------

-- ----------------------------
-- Table structure for cn_full_report
-- ----------------------------
DROP TABLE IF EXISTS `cn_full_report`;
CREATE TABLE `cn_full_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_cn` varchar(255) DEFAULT NULL,
  `crefo_no` varchar(20) DEFAULT NULL,
  `update_time` varchar(20) DEFAULT NULL,
  `grande_upde_time` varchar(20) DEFAULT NULL,
  `qian_hai_update_time` varchar(20) DEFAULT NULL,
  `litigation_update_time` varchar(20) DEFAULT NULL,
  `cpm_update_time` varchar(20) DEFAULT NULL,
  `financial_update_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`name_cn`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=264 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cn_full_report
-- ----------------------------

-- ----------------------------
-- Table structure for cn_fygg
-- ----------------------------
DROP TABLE IF EXISTS `cn_fygg`;
CREATE TABLE `cn_fygg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `body` text,
  `court` text,
  `crefo_no` text,
  `notice_type` text,
  `layout` text,
  `pname` text,
  `related_party` text,
  `fygg_id` text,
  `sort_time` text,
  `update_time` text,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `full_report_id` (`full_report_id`)
) ENGINE=MyISAM AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_fygg
-- ----------------------------

-- ----------------------------
-- Table structure for cn_icp_website
-- ----------------------------
DROP TABLE IF EXISTS `cn_icp_website`;
CREATE TABLE `cn_icp_website` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(255) DEFAULT NULL,
  `license_key` varchar(255) DEFAULT NULL,
  `registration_time` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `contact_add` varchar(255) DEFAULT NULL,
  `contact_tel` varchar(255) DEFAULT NULL,
  `domain_age` varchar(255) DEFAULT NULL,
  `get_date` varchar(255) DEFAULT NULL,
  `info_source` varchar(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `maturity_time` varchar(255) DEFAULT NULL,
  `organizer_name` varchar(255) DEFAULT NULL,
  `organizer_nature` varchar(255) DEFAULT NULL,
  `other_info` varchar(255) DEFAULT NULL,
  `register_different_country` varchar(255) DEFAULT NULL,
  `register_email` varchar(255) DEFAULT NULL,
  `register_name` varchar(255) DEFAULT NULL,
  `upd_date` varchar(255) DEFAULT NULL,
  `website_name` varchar(255) DEFAULT NULL,
  `website_species` varchar(255) DEFAULT NULL,
  `website_status` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `full_report_id` (`full_report_id`)
) ENGINE=MyISAM AUTO_INCREMENT=354 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_icp_website
-- ----------------------------

-- ----------------------------
-- Table structure for cn_managements
-- ----------------------------
DROP TABLE IF EXISTS `cn_managements`;
CREATE TABLE `cn_managements` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name_cn` varchar(255) DEFAULT NULL COMMENT '中文名称',
  `name_en` varchar(500) DEFAULT NULL COMMENT '英文名称',
  `gender` varchar(2) DEFAULT NULL COMMENT '性别',
  `birth_date` varchar(20) DEFAULT NULL COMMENT '出生日期',
  `age` varchar(20) DEFAULT NULL COMMENT '年龄',
  `post_id` int(11) DEFAULT NULL COMMENT '职位',
  `duty_id` int(11) DEFAULT NULL COMMENT '职能',
  `card_id` varchar(50) DEFAULT NULL COMMENT '证件号',
  `education_id` int(7) DEFAULT NULL COMMENT '教育',
  `country_cn` text COMMENT '中文国籍',
  `country_en` text COMMENT '英文国籍',
  `experience_cn` text COMMENT '中文工作经验',
  `experience_en` text COMMENT '英文工作经验',
  `note_cn` text COMMENT '中文备注',
  `note_en` text COMMENT '英文备注',
  `crefo_no` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `manage_years` varchar(255) DEFAULT NULL,
  `work_years` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `nameCn` (`name_cn`),
  KEY `nameEn` (`name_en`(333)),
  KEY `full_report_id` (`full_report_id`)
) ENGINE=MyISAM AUTO_INCREMENT=34940272 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_managements
-- ----------------------------

-- ----------------------------
-- Table structure for cn_media_records
-- ----------------------------
DROP TABLE IF EXISTS `cn_media_records`;
CREATE TABLE `cn_media_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `content` longtext,
  `link` varchar(255) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `get_time` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `full_report_id` (`full_report_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2293 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_media_records
-- ----------------------------

-- ----------------------------
-- Table structure for cn_operation_abnormal_infos
-- ----------------------------
DROP TABLE IF EXISTS `cn_operation_abnormal_infos`;
CREATE TABLE `cn_operation_abnormal_infos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(255) DEFAULT NULL,
  `include_date` varchar(255) DEFAULT NULL,
  `include_reasons` varchar(255) DEFAULT NULL,
  `org_decision` varchar(255) DEFAULT NULL,
  `remove_date` varchar(255) DEFAULT NULL,
  `remove_reason` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `full_report_id` (`full_report_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_operation_abnormal_infos
-- ----------------------------

-- ----------------------------
-- Table structure for cn_registration_infos
-- ----------------------------
DROP TABLE IF EXISTS `cn_registration_infos`;
CREATE TABLE `cn_registration_infos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  `crefo_no` varchar(20) DEFAULT NULL,
  `central_tax` varchar(255) DEFAULT NULL,
  `chn_code` varchar(255) DEFAULT NULL,
  `competition_id` int(11) DEFAULT NULL,
  `city_cn` varchar(255) DEFAULT NULL,
  `city_code` varchar(255) DEFAULT NULL,
  `city_en` varchar(255) DEFAULT NULL,
  `country_cn` varchar(255) DEFAULT NULL,
  `country_en` varchar(255) DEFAULT NULL,
  `company_properties_id` int(11) DEFAULT NULL,
  `credit_code` varchar(255) DEFAULT NULL,
  `company_status_id` int(11) DEFAULT NULL,
  `company_types_id` int(11) DEFAULT NULL,
  `deadline` varchar(255) DEFAULT NULL,
  `deadline_en` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `delist_date` varchar(255) DEFAULT NULL,
  `district_code` varchar(255) DEFAULT NULL,
  `establish_date` varchar(255) DEFAULT NULL,
  `eu_code` varchar(255) DEFAULT NULL,
  `int_code` varchar(255) DEFAULT NULL,
  `is_market` varchar(255) DEFAULT NULL,
  `land_tax` varchar(255) DEFAULT NULL,
  `legal_name_cn` text,
  `legal_name_en` text,
  `legal_position_cn` text,
  `legal_position_en` text,
  `market_code` varchar(255) DEFAULT NULL,
  `market_cities_id` int(11) DEFAULT NULL,
  `org` varchar(255) DEFAULT NULL,
  `paid_capital` varchar(255) DEFAULT NULL,
  `paid_capitalnote` varchar(255) DEFAULT NULL,
  `paid_currency` varchar(255) DEFAULT NULL,
  `paid_rate` varchar(255) DEFAULT NULL,
  `paid_real_capital` varchar(255) DEFAULT NULL,
  `paid_currency_id` int(11) DEFAULT NULL,
  `province_cn` varchar(255) DEFAULT NULL,
  `province_code` varchar(255) DEFAULT NULL,
  `province_en` varchar(255) DEFAULT NULL,
  `reg_currency_id` varchar(255) DEFAULT NULL,
  `reg` varchar(255) DEFAULT NULL,
  `reg_capital` varchar(255) DEFAULT NULL,
  `reg_capitalnote` varchar(255) DEFAULT NULL,
  `reg_city_code` varchar(255) DEFAULT NULL,
  `reg_currency` varchar(255) DEFAULT NULL,
  `reg_district_code` varchar(255) DEFAULT NULL,
  `reg_province_code` varchar(255) DEFAULT NULL,
  `reg_rate` varchar(255) DEFAULT NULL,
  `reg_real_capital` varchar(255) DEFAULT NULL,
  `registration_cn` text,
  `us_code` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `building_cn` text,
  `building_en` text,
  `business_scope_cn` text,
  `business_scope_en` text,
  `district_cn` text,
  `district_en` text,
  `registration_en` text,
  `street_cn` text,
  `street_en` text,
  `market_date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `full_report_id` (`full_report_id`)
) ENGINE=MyISAM AUTO_INCREMENT=244 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_registration_infos
-- ----------------------------

-- ----------------------------
-- Table structure for cn_rulingdocuments
-- ----------------------------
DROP TABLE IF EXISTS `cn_rulingdocuments`;
CREATE TABLE `cn_rulingdocuments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(20) DEFAULT NULL,
  `del_flag` varchar(20) DEFAULT NULL,
  `update_time` varchar(100) DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  `case_cause_id` varchar(255) DEFAULT NULL,
  `case_cause_type` varchar(255) DEFAULT NULL,
  `case_cause` text,
  `case_status_cn` text,
  `case_status_en` text,
  `case_type_cn` text,
  `case_type_en` text,
  `child_check` varchar(255) DEFAULT NULL,
  `currency_id` varchar(255) DEFAULT NULL,
  `court_rank` varchar(255) DEFAULT NULL,
  `cpws_id` varchar(255) DEFAULT NULL,
  `defendant_cn` text,
  `defendant_en` text,
  `docket_no_cn` text,
  `docket_no_en` text,
  `court_name_cn` text,
  `court_name_en` text,
  `judge` varchar(255) DEFAULT NULL,
  `judge_result` varchar(255) DEFAULT NULL,
  `note_cn` text,
  `note_en` text,
  `plaintiff_cn` text,
  `plaintiff_en` text,
  `sort_time` varchar(255) DEFAULT NULL,
  `title_cn` text,
  `title_en` text,
  `trial_procedure` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `full_report_id` (`full_report_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_rulingdocuments
-- ----------------------------

-- ----------------------------
-- Table structure for cn_shareholder_infos
-- ----------------------------
DROP TABLE IF EXISTS `cn_shareholder_infos`;
CREATE TABLE `cn_shareholder_infos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address_cn` varchar(255) DEFAULT NULL,
  `address_en` varchar(255) DEFAULT NULL,
  `business_scope_cn` text,
  `business_scope_en` text,
  `com_crefo_no` text,
  `contribution_date` varchar(255) DEFAULT NULL,
  `contribution_from` varchar(255) DEFAULT NULL,
  `country_cn` text,
  `country_en` text,
  `company_properties_id` int(11) DEFAULT NULL,
  `crefo_no` varchar(255) DEFAULT NULL,
  `company_status_id` int(11) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  `establish_date` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `name_cn` varchar(255) DEFAULT NULL,
  `name_en` varchar(255) DEFAULT NULL,
  `note_cn` varchar(255) DEFAULT NULL,
  `note_en` varchar(255) DEFAULT NULL,
  `register_id` int(11) DEFAULT NULL,
  `reg` varchar(255) DEFAULT NULL,
  `reg_capital` varchar(255) DEFAULT NULL,
  `contribution_id` int(11) DEFAULT NULL,
  `shares` varchar(255) DEFAULT NULL,
  `subconam` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `full_report_id` (`full_report_id`)
) ENGINE=MyISAM AUTO_INCREMENT=1632 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cn_shareholder_infos
-- ----------------------------

-- ----------------------------
-- Table structure for cn_sxgg
-- ----------------------------
DROP TABLE IF EXISTS `cn_sxgg`;
CREATE TABLE `cn_sxgg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` varchar(100) DEFAULT NULL,
  `basis_unit_cn` text,
  `basis_unit_en` text,
  `child_check` text,
  `del_flag` text,
  `docket_no_cn` text,
  `docket_no_en` text,
  `effective_obligation_cn` text,
  `effective_obligation_en` text,
  `enforcee_name_cn` text,
  `enforcee_name_en` text,
  `enforcee_perform_cn` text CHARACTER SET utf8 COLLATE utf8_bin,
  `enforcee_perform_en` text,
  `enforcement_basis_number_cn` text,
  `enforcement_basis_number_en` text,
  `ent_court_name_cn` text,
  `ent_court_name_en` text,
  `finish_date` text,
  `province_cn` text,
  `province_en` text,
  `crefo_no` varchar(255) DEFAULT NULL,
  `sort_time` varchar(255) DEFAULT NULL,
  `specific_circumstance_cn` varchar(255) DEFAULT NULL,
  `specific_circumstance_en` varchar(255) DEFAULT NULL,
  `sxgg_id` varchar(255) DEFAULT NULL,
  `idcard_no` varchar(255) DEFAULT NULL,
  `related_party` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `update_time` varchar(255) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `full_report_id` (`full_report_id`)
) ENGINE=MyISAM AUTO_INCREMENT=124 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of cn_sxgg
-- ----------------------------

-- ----------------------------
-- Table structure for communication
-- ----------------------------
DROP TABLE IF EXISTS `communication`;
CREATE TABLE `communication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `communication_content` varchar(255) NOT NULL COMMENT '主题内容',
  `communication_date` datetime DEFAULT NULL COMMENT '主题时间',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志',
  `role` varchar(255) NOT NULL COMMENT '角色(1：提问者；0：回答者；)',
  `status` varchar(255) NOT NULL COMMENT '状态',
  `title_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `question_type` varchar(255) NOT NULL COMMENT '问题类型(1：积分充值 2：订单 3：报告 4：账单 5：核实纠错  10:其他)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of communication
-- ----------------------------

-- ----------------------------
-- Table structure for company_detail
-- ----------------------------
DROP TABLE IF EXISTS `company_detail`;
CREATE TABLE `company_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID编号',
  `name_cn` varchar(255) DEFAULT NULL COMMENT '公司中文名称',
  `name_en` varchar(255) DEFAULT NULL COMMENT '公司英文名称',
  `province_cn` varchar(255) DEFAULT NULL COMMENT '省份中文名称',
  `province_en` varchar(255) DEFAULT NULL COMMENT '省份英文名称',
  `province_code` varchar(255) DEFAULT NULL COMMENT '省编号',
  `city_cn` varchar(255) DEFAULT NULL COMMENT '城市中文名称',
  `city_en` varchar(255) DEFAULT NULL COMMENT '城市英文名称',
  `city_code` varchar(255) DEFAULT NULL COMMENT '城市编号',
  `tel` varchar(255) DEFAULT NULL COMMENT '电话',
  `website` varchar(255) DEFAULT NULL COMMENT '网址',
  `reg_address` varchar(255) DEFAULT NULL COMMENT '经营地址',
  `area` varchar(255) DEFAULT NULL COMMENT '地区',
  `industry` varchar(255) DEFAULT NULL COMMENT '行业',
  `crefo_no` varchar(255) DEFAULT NULL COMMENT '科室号码',
  `level` varchar(255) DEFAULT NULL COMMENT '级别',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `org` varchar(255) DEFAULT NULL COMMENT '组织机构代码',
  `reg` varchar(255) DEFAULT NULL COMMENT '注册代码',
  `financial_year` varchar(255) DEFAULT NULL COMMENT '最新财务年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company_detail
-- ----------------------------

-- ----------------------------
-- Table structure for country_code
-- ----------------------------
DROP TABLE IF EXISTS `country_code`;
CREATE TABLE `country_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `del_flag` varchar(255) NOT NULL COMMENT '删除标志',
  `name_cn` varchar(255) NOT NULL COMMENT '中文名称',
  `name_en` varchar(255) NOT NULL COMMENT '英文名称',
  `order_by` varchar(255) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of country_code
-- ----------------------------

-- ----------------------------
-- Table structure for credit_certification
-- ----------------------------
DROP TABLE IF EXISTS `credit_certification`;
CREATE TABLE `credit_certification` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '信用认证ID',
  `card_id` int(11) NOT NULL COMMENT '名片ID',
  `order_id` int(11) NOT NULL COMMENT '订单ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `crefo_no` varchar(255) DEFAULT NULL COMMENT '科氏号码',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `repayment_index` varchar(255) DEFAULT NULL COMMENT '偿还指数',
  `credit_risk_evaluation` varchar(255) DEFAULT NULL COMMENT '信用风险评级',
  `credits` varchar(255) DEFAULT NULL COMMENT '建议信用额度',
  `credit_risk_score` varchar(255) DEFAULT NULL COMMENT '信用风险分数',
  `establish_date` varchar(255) DEFAULT NULL COMMENT '成立日期',
  `establish_date_score` varchar(255) DEFAULT NULL COMMENT '成立日期分数',
  `company_property` varchar(255) DEFAULT NULL COMMENT '企业性质',
  `company_property_score` varchar(255) DEFAULT NULL COMMENT '企业性质分数',
  `employee_num` varchar(255) DEFAULT NULL COMMENT '员工人数',
  `employee_num_score` varchar(255) DEFAULT NULL COMMENT '员工人数分数',
  `company_status` varchar(255) DEFAULT NULL COMMENT '企业现状',
  `company_status_score` varchar(255) DEFAULT NULL COMMENT '企业现状分数',
  `main_business` varchar(255) DEFAULT NULL COMMENT '主营业务',
  `main_business_score` varchar(255) DEFAULT NULL COMMENT '主营业务分数',
  `industry` varchar(255) DEFAULT NULL COMMENT '所属行业',
  `industry_score` varchar(255) DEFAULT NULL COMMENT '所属行业分数',
  `litigation_record` varchar(255) DEFAULT NULL COMMENT '诉讼记录',
  `litigation_record_score` varchar(255) DEFAULT NULL COMMENT '诉讼记录分数',
  `reg_capital` varchar(255) DEFAULT NULL COMMENT '注册资本',
  `reg_capital_score` varchar(255) DEFAULT NULL COMMENT '注册资本分数',
  `paid_capital` varchar(255) DEFAULT NULL COMMENT '实缴资本',
  `paid_capital_score` varchar(255) DEFAULT NULL COMMENT '实缴资本分数',
  `return_on_equity` varchar(255) DEFAULT NULL COMMENT '净资产收益率',
  `return_on_equity_score` varchar(255) DEFAULT NULL COMMENT '净资产收益率分数',
  `profit_margin` varchar(255) DEFAULT NULL COMMENT '利润率',
  `profit_margin_score` varchar(255) DEFAULT NULL COMMENT '利润率分数',
  `profit_margin_scope` varchar(255) DEFAULT NULL COMMENT '利润率范围',
  `current_ratio` varchar(255) DEFAULT NULL COMMENT '流动比率',
  `current_ratio_score` varchar(255) DEFAULT NULL COMMENT '流动比率分数',
  `current_ratio_scope` varchar(255) DEFAULT NULL COMMENT '流动比率范围',
  `quick_ratio` varchar(255) DEFAULT NULL COMMENT '速动比率',
  `quick_ratio_score` varchar(255) DEFAULT NULL COMMENT '速动比率分数',
  `quick_ratio_scope` varchar(255) DEFAULT NULL COMMENT '速动比率范围',
  `debt_ratio` varchar(255) DEFAULT NULL COMMENT '资产负债比率',
  `debt_ratio_score` varchar(255) DEFAULT NULL COMMENT '资产负债比率分数',
  `debt_ratio_scope` varchar(255) DEFAULT NULL COMMENT '资产负债比率范围',
  `sales_growth_rate` varchar(255) DEFAULT NULL COMMENT '销售成长比率',
  `sales_growth_rate_score` varchar(255) DEFAULT NULL COMMENT '销售成长比率分数',
  `sales_growth_rate_scope` varchar(255) DEFAULT NULL COMMENT '销售成长比率范围',
  `company_size` varchar(255) DEFAULT NULL COMMENT '企业规模',
  `paid_currency` varchar(255) DEFAULT NULL COMMENT '实收货币',
  `reg_currency` varchar(255) DEFAULT NULL COMMENT '注册货币',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志	1:不删除，其他删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of credit_certification
-- ----------------------------
INSERT INTO `credit_certification` VALUES ('76', '117', '723', '45', null, '2017-05-06 13:32:14', null, null, null, null, '2008-09-23', null, null, null, null, null, null, null, '企业管理咨询、经济信息咨询、贸易信息咨询、商务信息咨询、企业征信服务、市场信息咨询与调查（不得从事社会调查、社会调研、民意调查、民意测验），投资咨询（除专项）（以上咨询均除经纪）。【依法须经批准的项目，经相关部门批准后方可开展经营活动】', null, null, null, null, '没有记录', '0', '0', '0', '0', null, null, null, '0', '没有记录', null, '0', '没有记录', null, null, null, null, '0', '没有记录', null, '0', '没有记录', null, null, null, '1');
INSERT INTO `credit_certification` VALUES ('77', '117', '730', '45', null, '2017-05-06 15:04:40', null, null, null, null, '2008-09-23', null, null, null, null, null, null, null, '企业管理咨询、经济信息咨询、贸易信息咨询、商务信息咨询、企业征信服务、市场信息咨询与调查（不得从事社会调查、社会调研、民意调查、民意测验），投资咨询（除专项）（以上咨询均除经纪）。【依法须经批准的项目，经相关部门批准后方可开展经营活动】', null, null, null, null, '没有记录', '0', '0', '0', '0', null, null, null, '0', '没有记录', null, '0', '没有记录', null, null, null, null, '0', '没有记录', null, '0', '没有记录', null, null, null, '1');

-- ----------------------------
-- Table structure for district_code
-- ----------------------------
DROP TABLE IF EXISTS `district_code`;
CREATE TABLE `district_code` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `c_id` int(10) DEFAULT NULL COMMENT '城市ID',
  `name_cn` varchar(50) NOT NULL COMMENT '中文名称',
  `name_en` varchar(100) DEFAULT NULL COMMENT '英文名称',
  `del_flag` varchar(2) NOT NULL COMMENT '删除标志',
  `order_by` varchar(255) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `sdfas` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=659005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of district_code
-- ----------------------------
INSERT INTO `district_code` VALUES ('542125', '5421', '丁青县', null, '1', null);
INSERT INTO `district_code` VALUES ('520502', '5205', '七星关区', null, '1', null);
INSERT INTO `district_code` VALUES ('450305', '4503', '七星区', null, '1', null);
INSERT INTO `district_code` VALUES ('620103', '6201', '七里河区', null, '1', null);
INSERT INTO `district_code` VALUES ('130729', '1307', '万全县', null, '1', null);
INSERT INTO `district_code` VALUES ('469006', '4690', '万宁市', null, '1', null);
INSERT INTO `district_code` VALUES ('360828', '3608', '万安县', null, '1', null);
INSERT INTO `district_code` VALUES ('520603', '5206', '万山区', null, '1', null);
INSERT INTO `district_code` VALUES ('500101', '50', '万州区', null, '1', null);
INSERT INTO `district_code` VALUES ('361129', '3611', '万年县', null, '1', null);
INSERT INTO `district_code` VALUES ('140109', '1401', '万柏林区', null, '1', null);
INSERT INTO `district_code` VALUES ('511781', '5117', '万源市', null, '1', null);
INSERT INTO `district_code` VALUES ('450403', '4504', '万秀区', null, '1', null);
INSERT INTO `district_code` VALUES ('140822', '1408', '万荣县', null, '1', null);
INSERT INTO `district_code` VALUES ('360922', '3609', '万载县', null, '1', null);
INSERT INTO `district_code` VALUES ('350403', '3504', '三元区', null, '1', null);
INSERT INTO `district_code` VALUES ('610422', '6104', '三原县', null, '1', null);
INSERT INTO `district_code` VALUES ('510722', '5107', '三台县', null, '1', null);
INSERT INTO `district_code` VALUES ('340208', '3402', '三山区', null, '1', null);
INSERT INTO `district_code` VALUES ('440607', '4406', '三水区', null, '1', null);
INSERT INTO `district_code` VALUES ('450226', '4502', '三江侗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('131082', '1310', '三河市', null, '1', null);
INSERT INTO `district_code` VALUES ('522624', '5226', '三穗县', null, '1', null);
INSERT INTO `district_code` VALUES ('522732', '5227', '三都水族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('331022', '3310', '三门县', null, '1', null);
INSERT INTO `district_code` VALUES ('330102', '3301', '上城区', null, '1', null);
INSERT INTO `district_code` VALUES ('450621', '4506', '上思县', null, '1', null);
INSERT INTO `district_code` VALUES ('350823', '3508', '上杭县', null, '1', null);
INSERT INTO `district_code` VALUES ('450125', '4501', '上林县', null, '1', null);
INSERT INTO `district_code` VALUES ('360322', '3603', '上栗县', null, '1', null);
INSERT INTO `district_code` VALUES ('360724', '3607', '上犹县', null, '1', null);
INSERT INTO `district_code` VALUES ('230716', '2307', '上甘岭区', null, '1', null);
INSERT INTO `district_code` VALUES ('411722', '4117', '上蔡县', null, '1', null);
INSERT INTO `district_code` VALUES ('330682', '3306', '上虞市', null, '1', null);
INSERT INTO `district_code` VALUES ('410106', '4101', '上街区', null, '1', null);
INSERT INTO `district_code` VALUES ('361121', '3611', '上饶县', null, '1', null);
INSERT INTO `district_code` VALUES ('360923', '3609', '上高县', null, '1', null);
INSERT INTO `district_code` VALUES ('320107', '3201', '下关区', null, '1', null);
INSERT INTO `district_code` VALUES ('330103', '3301', '下城区', null, '1', null);
INSERT INTO `district_code` VALUES ('130706', '1307', '下花园区', null, '1', null);
INSERT INTO `district_code` VALUES ('420204', '4202', '下陆区', null, '1', null);
INSERT INTO `district_code` VALUES ('652825', '6528', '且末县', null, '1', null);
INSERT INTO `district_code` VALUES ('532626', '5326', '丘北县', null, '1', null);
INSERT INTO `district_code` VALUES ('130403', '1304', '丛台区', null, '1', null);
INSERT INTO `district_code` VALUES ('220421', '2204', '东丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('120110', '12', '东丽区', null, '1', null);
INSERT INTO `district_code` VALUES ('152525', '1525', '东乌珠穆沁旗', null, '1', null);
INSERT INTO `district_code` VALUES ('361029', '3610', '东乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('622926', '6229', '东乡族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('130923', '1309', '东光县', null, '1', null);
INSERT INTO `district_code` VALUES ('451224', '4512', '东兰县', null, '1', null);
INSERT INTO `district_code` VALUES ('511011', '5110', '东兴区', null, '1', null);
INSERT INTO `district_code` VALUES ('450681', '4506', '东兴市', null, '1', null);
INSERT INTO `district_code` VALUES ('510402', '5104', '东区', null, '1', null);
INSERT INTO `district_code` VALUES ('320981', '3209', '东台市', null, '1', null);
INSERT INTO `district_code` VALUES ('511402', '5114', '东坡区', null, '1', null);
INSERT INTO `district_code` VALUES ('110101', '11', '东城区', null, '1', null);
INSERT INTO `district_code` VALUES ('231024', '2310', '东宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('231002', '2310', '东安区', null, '1', null);
INSERT INTO `district_code` VALUES ('431122', '4311', '东安县', null, '1', null);
INSERT INTO `district_code` VALUES ('420802', '4208', '东宝区', null, '1', null);
INSERT INTO `district_code` VALUES ('230406', '2304', '东山区', null, '1', null);
INSERT INTO `district_code` VALUES ('350626', '3506', '东山县', null, '1', null);
INSERT INTO `district_code` VALUES ('530113', '5301', '东川区', null, '1', null);
INSERT INTO `district_code` VALUES ('370923', '3709', '东平县', null, '1', null);
INSERT INTO `district_code` VALUES ('469007', '4690', '东方市', null, '1', null);
INSERT INTO `district_code` VALUES ('220502', '2205', '东昌区', null, '1', null);
INSERT INTO `district_code` VALUES ('371502', '3715', '东昌府区', null, '1', null);
INSERT INTO `district_code` VALUES ('371728', '3717', '东明县', null, '1', null);
INSERT INTO `district_code` VALUES ('150202', '1502', '东河区', null, '1', null);
INSERT INTO `district_code` VALUES ('210403', '2104', '东洲区', null, '1', null);
INSERT INTO `district_code` VALUES ('320722', '3207', '东海县', null, '1', null);
INSERT INTO `district_code` VALUES ('371102', '3711', '东港区', null, '1', null);
INSERT INTO `district_code` VALUES ('210681', '2106', '东港市', null, '1', null);
INSERT INTO `district_code` VALUES ('360102', '3601', '东湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('441625', '4416', '东源县', null, '1', null);
INSERT INTO `district_code` VALUES ('150602', '1506', '东胜区', null, '1', null);
INSERT INTO `district_code` VALUES ('341721', '3417', '东至县', null, '1', null);
INSERT INTO `district_code` VALUES ('370502', '3705', '东营区', null, '1', null);
INSERT INTO `district_code` VALUES ('420112', '4201', '东西湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('220422', '2204', '东辽县', null, '1', null);
INSERT INTO `district_code` VALUES ('330783', '3307', '东阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('371524', '3715', '东阿县', null, '1', null);
INSERT INTO `district_code` VALUES ('210112', '2101', '东陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('230805', '2308', '东风区', null, '1', null);
INSERT INTO `district_code` VALUES ('621228', '6212', '两当县', null, '1', null);
INSERT INTO `district_code` VALUES ('532501', '5325', '个旧市', null, '1', null);
INSERT INTO `district_code` VALUES ('410102', '4101', '中原区', null, '1', null);
INSERT INTO `district_code` VALUES ('640521', '6405', '中宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('210202', '2102', '中山区', null, '1', null);
INSERT INTO `district_code` VALUES ('431221', '4312', '中方县', null, '1', null);
INSERT INTO `district_code` VALUES ('510623', '5106', '中江县', null, '1', null);
INSERT INTO `district_code` VALUES ('469033', '4690', '中沙群岛的岛礁及其海域', null, '1', null);
INSERT INTO `district_code` VALUES ('410122', '4101', '中牟县', null, '1', null);
INSERT INTO `district_code` VALUES ('410803', '4108', '中站区', null, '1', null);
INSERT INTO `district_code` VALUES ('141129', '1411', '中阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('130207', '1302', '丰南区', null, '1', null);
INSERT INTO `district_code` VALUES ('320321', '3203', '丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('110106', '11', '丰台区', null, '1', null);
INSERT INTO `district_code` VALUES ('360981', '3609', '丰城市', null, '1', null);
INSERT INTO `district_code` VALUES ('130826', '1308', '丰宁满族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('350503', '3505', '丰泽区', null, '1', null);
INSERT INTO `district_code` VALUES ('130208', '1302', '丰润区', null, '1', null);
INSERT INTO `district_code` VALUES ('220211', '2202', '丰满区', null, '1', null);
INSERT INTO `district_code` VALUES ('500230', '50', '丰都县', null, '1', null);
INSERT INTO `district_code` VALUES ('150981', '1509', '丰镇市', null, '1', null);
INSERT INTO `district_code` VALUES ('441423', '4414', '丰顺县', null, '1', null);
INSERT INTO `district_code` VALUES ('141124', '1411', '临县', null, '1', null);
INSERT INTO `district_code` VALUES ('130522', '1305', '临城县', null, '1', null);
INSERT INTO `district_code` VALUES ('622921', '6229', '临夏县', null, '1', null);
INSERT INTO `district_code` VALUES ('622901', '6229', '临夏市', null, '1', null);
INSERT INTO `district_code` VALUES ('330185', '3301', '临安市', null, '1', null);
INSERT INTO `district_code` VALUES ('361002', '3610', '临川区', null, '1', null);
INSERT INTO `district_code` VALUES ('370724', '3707', '临朐县', null, '1', null);
INSERT INTO `district_code` VALUES ('450322', '4503', '临桂县', null, '1', null);
INSERT INTO `district_code` VALUES ('431025', '4310', '临武县', null, '1', null);
INSERT INTO `district_code` VALUES ('220681', '2206', '临江市', null, '1', null);
INSERT INTO `district_code` VALUES ('371329', '3713', '临沭县', null, '1', null);
INSERT INTO `district_code` VALUES ('150802', '1508', '临河区', null, '1', null);
INSERT INTO `district_code` VALUES ('341221', '3412', '临泉县', null, '1', null);
INSERT INTO `district_code` VALUES ('620723', '6207', '临泽县', null, '1', null);
INSERT INTO `district_code` VALUES ('621124', '6211', '临洮县', null, '1', null);
INSERT INTO `district_code` VALUES ('331082', '3310', '临海市', null, '1', null);
INSERT INTO `district_code` VALUES ('370305', '3703', '临淄区', null, '1', null);
INSERT INTO `district_code` VALUES ('371581', '3715', '临清市', null, '1', null);
INSERT INTO `district_code` VALUES ('610502', '6105', '临渭区', null, '1', null);
INSERT INTO `district_code` VALUES ('430682', '4306', '临湘市', null, '1', null);
INSERT INTO `district_code` VALUES ('130423', '1304', '临漳县', null, '1', null);
INSERT INTO `district_code` VALUES ('623021', '6230', '临潭县', null, '1', null);
INSERT INTO `district_code` VALUES ('610115', '6101', '临潼区', null, '1', null);
INSERT INTO `district_code` VALUES ('430724', '4307', '临澧县', null, '1', null);
INSERT INTO `district_code` VALUES ('140821', '1408', '临猗县', null, '1', null);
INSERT INTO `district_code` VALUES ('530902', '5309', '临翔区', null, '1', null);
INSERT INTO `district_code` VALUES ('130535', '1305', '临西县', null, '1', null);
INSERT INTO `district_code` VALUES ('371424', '3714', '临邑县', null, '1', null);
INSERT INTO `district_code` VALUES ('411122', '4111', '临颍县', null, '1', null);
INSERT INTO `district_code` VALUES ('469024', '4690', '临高县', null, '1', null);
INSERT INTO `district_code` VALUES ('611022', '6110', '丹凤县', null, '1', null);
INSERT INTO `district_code` VALUES ('522636', '5226', '丹寨县', null, '1', null);
INSERT INTO `district_code` VALUES ('513323', '5133', '丹巴县', null, '1', null);
INSERT INTO `district_code` VALUES ('321112', '3211', '丹徒区', null, '1', null);
INSERT INTO `district_code` VALUES ('511424', '5114', '丹棱县', null, '1', null);
INSERT INTO `district_code` VALUES ('420381', '4203', '丹江口市', null, '1', null);
INSERT INTO `district_code` VALUES ('321181', '3211', '丹阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('542221', '5422', '乃东县', null, '1', null);
INSERT INTO `district_code` VALUES ('632625', '6326', '久治县', null, '1', null);
INSERT INTO `district_code` VALUES ('330782', '3307', '义乌市', null, '1', null);
INSERT INTO `district_code` VALUES ('210727', '2107', '义县', null, '1', null);
INSERT INTO `district_code` VALUES ('411281', '4112', '义马市', null, '1', null);
INSERT INTO `district_code` VALUES ('652927', '6529', '乌什县', null, '1', null);
INSERT INTO `district_code` VALUES ('230714', '2307', '乌伊岭区', null, '1', null);
INSERT INTO `district_code` VALUES ('632821', '6328', '乌兰县', null, '1', null);
INSERT INTO `district_code` VALUES ('152201', '1522', '乌兰浩特市', null, '1', null);
INSERT INTO `district_code` VALUES ('150626', '1506', '乌审旗', null, '1', null);
INSERT INTO `district_code` VALUES ('650205', '6502', '乌尔禾区', null, '1', null);
INSERT INTO `district_code` VALUES ('520112', '5201', '乌当区', null, '1', null);
INSERT INTO `district_code` VALUES ('653024', '6530', '乌恰县', null, '1', null);
INSERT INTO `district_code` VALUES ('150824', '1508', '乌拉特中旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150823', '1508', '乌拉特前旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150825', '1508', '乌拉特后旗', null, '1', null);
INSERT INTO `district_code` VALUES ('654202', '6542', '乌苏市', null, '1', null);
INSERT INTO `district_code` VALUES ('150304', '1503', '乌达区', null, '1', null);
INSERT INTO `district_code` VALUES ('230711', '2307', '乌马河区', null, '1', null);
INSERT INTO `district_code` VALUES ('650121', '6501', '乌鲁木齐县', null, '1', null);
INSERT INTO `district_code` VALUES ('451028', '4510', '乐业县', null, '1', null);
INSERT INTO `district_code` VALUES ('469027', '4690', '乐东黎族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('130225', '1302', '乐亭县', null, '1', null);
INSERT INTO `district_code` VALUES ('361025', '3610', '乐安县', null, '1', null);
INSERT INTO `district_code` VALUES ('360281', '3602', '乐平市', null, '1', null);
INSERT INTO `district_code` VALUES ('440281', '4402', '乐昌市', null, '1', null);
INSERT INTO `district_code` VALUES ('330382', '3303', '乐清市', null, '1', null);
INSERT INTO `district_code` VALUES ('512022', '5120', '乐至县', null, '1', null);
INSERT INTO `district_code` VALUES ('632123', '6321', '乐都县', null, '1', null);
INSERT INTO `district_code` VALUES ('371481', '3714', '乐陵市', null, '1', null);
INSERT INTO `district_code` VALUES ('150207', '1502', '九原区', null, '1', null);
INSERT INTO `district_code` VALUES ('220181', '2201', '九台市', null, '1', null);
INSERT INTO `district_code` VALUES ('513225', '5132', '九寨沟县', null, '1', null);
INSERT INTO `district_code` VALUES ('360421', '3604', '九江县', null, '1', null);
INSERT INTO `district_code` VALUES ('513324', '5133', '九龙县', null, '1', null);
INSERT INTO `district_code` VALUES ('500107', '50', '九龙坡区', null, '1', null);
INSERT INTO `district_code` VALUES ('520330', '5203', '习水县', null, '1', null);
INSERT INTO `district_code` VALUES ('513336', '5133', '乡城县', null, '1', null);
INSERT INTO `district_code` VALUES ('141029', '1410', '乡宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('371083', '3710', '乳山市', null, '1', null);
INSERT INTO `district_code` VALUES ('440232', '4402', '乳源瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('610424', '6104', '乾县', null, '1', null);
INSERT INTO `district_code` VALUES ('220723', '2207', '乾安县', null, '1', null);
INSERT INTO `district_code` VALUES ('410103', '4101', '二七区', null, '1', null);
INSERT INTO `district_code` VALUES ('152501', '1525', '二连浩特市', null, '1', null);
INSERT INTO `district_code` VALUES ('220105', '2201', '二道区', null, '1', null);
INSERT INTO `district_code` VALUES ('220503', '2205', '二道江区', null, '1', null);
INSERT INTO `district_code` VALUES ('210114', '2101', '于洪区', null, '1', null);
INSERT INTO `district_code` VALUES ('653226', '6532', '于田县', null, '1', null);
INSERT INTO `district_code` VALUES ('360731', '3607', '于都县', null, '1', null);
INSERT INTO `district_code` VALUES ('530922', '5309', '云县', null, '1', null);
INSERT INTO `district_code` VALUES ('331125', '3311', '云和县', null, '1', null);
INSERT INTO `district_code` VALUES ('445302', '4453', '云城区', null, '1', null);
INSERT INTO `district_code` VALUES ('445323', '4453', '云安县', null, '1', null);
INSERT INTO `district_code` VALUES ('520103', '5201', '云岩区', null, '1', null);
INSERT INTO `district_code` VALUES ('420923', '4209', '云梦县', null, '1', null);
INSERT INTO `district_code` VALUES ('430603', '4306', '云溪区', null, '1', null);
INSERT INTO `district_code` VALUES ('500235', '50', '云阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('350622', '3506', '云霄县', null, '1', null);
INSERT INTO `district_code` VALUES ('320303', '3203', '云龙区', null, '1', null);
INSERT INTO `district_code` VALUES ('532929', '5329', '云龙县', null, '1', null);
INSERT INTO `district_code` VALUES ('632126', '6321', '互助土族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('530102', '5301', '五华区', null, '1', null);
INSERT INTO `district_code` VALUES ('441424', '4414', '五华县', null, '1', null);
INSERT INTO `district_code` VALUES ('150821', '1508', '五原县', null, '1', null);
INSERT INTO `district_code` VALUES ('140922', '1409', '五台县', null, '1', null);
INSERT INTO `district_code` VALUES ('231182', '2311', '五大连池市', null, '1', null);
INSERT INTO `district_code` VALUES ('659004', '6590', '五家渠市', null, '1', null);
INSERT INTO `district_code` VALUES ('140928', '1409', '五寨县', null, '1', null);
INSERT INTO `district_code` VALUES ('420529', '4205', '五峰土家族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('230184', '2301', '五常市', null, '1', null);
INSERT INTO `district_code` VALUES ('469001', '4690', '五指山市', null, '1', null);
INSERT INTO `district_code` VALUES ('340322', '3403', '五河县', null, '1', null);
INSERT INTO `district_code` VALUES ('371121', '3711', '五莲县', null, '1', null);
INSERT INTO `district_code` VALUES ('230710', '2307', '五营区', null, '1', null);
INSERT INTO `district_code` VALUES ('511112', '5111', '五通桥区', null, '1', null);
INSERT INTO `district_code` VALUES ('360881', '3608', '井冈山市', null, '1', null);
INSERT INTO `district_code` VALUES ('511124', '5111', '井研县', null, '1', null);
INSERT INTO `district_code` VALUES ('130121', '1301', '井陉县', null, '1', null);
INSERT INTO `district_code` VALUES ('130107', '1301', '井陉矿区', null, '1', null);
INSERT INTO `district_code` VALUES ('542334', '5423', '亚东县', null, '1', null);
INSERT INTO `district_code` VALUES ('141130', '1411', '交口县', null, '1', null);
INSERT INTO `district_code` VALUES ('141122', '1411', '交城县', null, '1', null);
INSERT INTO `district_code` VALUES ('321102', '3211', '京口区', null, '1', null);
INSERT INTO `district_code` VALUES ('420821', '4208', '京山县', null, '1', null);
INSERT INTO `district_code` VALUES ('320902', '3209', '亭湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('510682', '5106', '什邡市', null, '1', null);
INSERT INTO `district_code` VALUES ('440224', '4402', '仁化县', null, '1', null);
INSERT INTO `district_code` VALUES ('510411', '5104', '仁和区', null, '1', null);
INSERT INTO `district_code` VALUES ('511421', '5114', '仁寿县', null, '1', null);
INSERT INTO `district_code` VALUES ('542330', '5423', '仁布县', null, '1', null);
INSERT INTO `district_code` VALUES ('520382', '5203', '仁怀市', null, '1', null);
INSERT INTO `district_code` VALUES ('140781', '1407', '介休市', null, '1', null);
INSERT INTO `district_code` VALUES ('440184', '4401', '从化市', null, '1', null);
INSERT INTO `district_code` VALUES ('522633', '5226', '从江县', null, '1', null);
INSERT INTO `district_code` VALUES ('350104', '3501', '仓山区', null, '1', null);
INSERT INTO `district_code` VALUES ('331024', '3310', '仙居县', null, '1', null);
INSERT INTO `district_code` VALUES ('429004', '4290', '仙桃市', null, '1', null);
INSERT INTO `district_code` VALUES ('350322', '3503', '仙游县', null, '1', null);
INSERT INTO `district_code` VALUES ('140923', '1409', '代县', null, '1', null);
INSERT INTO `district_code` VALUES ('321081', '3210', '仪征市', null, '1', null);
INSERT INTO `district_code` VALUES ('511324', '5113', '仪陇县', null, '1', null);
INSERT INTO `district_code` VALUES ('542333', '5423', '仲巴县', null, '1', null);
INSERT INTO `district_code` VALUES ('130982', '1309', '任丘市', null, '1', null);
INSERT INTO `district_code` VALUES ('130526', '1305', '任县', null, '1', null);
INSERT INTO `district_code` VALUES ('370811', '3708', '任城区', null, '1', null);
INSERT INTO `district_code` VALUES ('652223', '6522', '伊吾县', null, '1', null);
INSERT INTO `district_code` VALUES ('654021', '6540', '伊宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('654002', '6540', '伊宁市', null, '1', null);
INSERT INTO `district_code` VALUES ('410329', '4103', '伊川县', null, '1', null);
INSERT INTO `district_code` VALUES ('230702', '2307', '伊春区', null, '1', null);
INSERT INTO `district_code` VALUES ('220323', '2203', '伊通满族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('150627', '1506', '伊金霍洛旗', null, '1', null);
INSERT INTO `district_code` VALUES ('420503', '4205', '伍家岗区', null, '1', null);
INSERT INTO `district_code` VALUES ('341022', '3410', '休宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('513426', '5134', '会东县', null, '1', null);
INSERT INTO `district_code` VALUES ('431225', '4312', '会同县', null, '1', null);
INSERT INTO `district_code` VALUES ('620422', '6204', '会宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('360733', '3607', '会昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('530326', '5303', '会泽县', null, '1', null);
INSERT INTO `district_code` VALUES ('513425', '5134', '会理县', null, '1', null);
INSERT INTO `district_code` VALUES ('653129', '6531', '伽师县', null, '1', null);
INSERT INTO `district_code` VALUES ('330281', '3302', '余姚市', null, '1', null);
INSERT INTO `district_code` VALUES ('361127', '3611', '余干县', null, '1', null);
INSERT INTO `district_code` VALUES ('520329', '5203', '余庆县', null, '1', null);
INSERT INTO `district_code` VALUES ('330110', '3301', '余杭区', null, '1', null);
INSERT INTO `district_code` VALUES ('360622', '3606', '余江县', null, '1', null);
INSERT INTO `district_code` VALUES ('441821', '4418', '佛冈县', null, '1', null);
INSERT INTO `district_code` VALUES ('610730', '6107', '佛坪县', null, '1', null);
INSERT INTO `district_code` VALUES ('610828', '6108', '佳县', null, '1', null);
INSERT INTO `district_code` VALUES ('230123', '2301', '依兰县', null, '1', null);
INSERT INTO `district_code` VALUES ('230223', '2302', '依安县', null, '1', null);
INSERT INTO `district_code` VALUES ('141081', '1410', '侯马市', null, '1', null);
INSERT INTO `district_code` VALUES ('469029', '4690', '保亭黎族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('420626', '4206', '保康县', null, '1', null);
INSERT INTO `district_code` VALUES ('140931', '1409', '保德县', null, '1', null);
INSERT INTO `district_code` VALUES ('433125', '4331', '保靖县', null, '1', null);
INSERT INTO `district_code` VALUES ('360722', '3607', '信丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('440983', '4409', '信宜市', null, '1', null);
INSERT INTO `district_code` VALUES ('361102', '3611', '信州区', null, '1', null);
INSERT INTO `district_code` VALUES ('520123', '5201', '修文县', null, '1', null);
INSERT INTO `district_code` VALUES ('410821', '4108', '修武县', null, '1', null);
INSERT INTO `district_code` VALUES ('360424', '3604', '修水县', null, '1', null);
INSERT INTO `district_code` VALUES ('410381', '4103', '偃师市', null, '1', null);
INSERT INTO `district_code` VALUES ('140932', '1409', '偏关县', null, '1', null);
INSERT INTO `district_code` VALUES ('469003', '4690', '儋州市', null, '1', null);
INSERT INTO `district_code` VALUES ('510811', '5108', '元坝区', null, '1', null);
INSERT INTO `district_code` VALUES ('210602', '2106', '元宝区', null, '1', null);
INSERT INTO `district_code` VALUES ('150403', '1504', '元宝山区', null, '1', null);
INSERT INTO `district_code` VALUES ('130132', '1301', '元氏县', null, '1', null);
INSERT INTO `district_code` VALUES ('530428', '5304', '元江哈尼族彝族傣族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('532328', '5323', '元谋县', null, '1', null);
INSERT INTO `district_code` VALUES ('532528', '5325', '元阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('411522', '4115', '光山县', null, '1', null);
INSERT INTO `district_code` VALUES ('350723', '3507', '光泽县', null, '1', null);
INSERT INTO `district_code` VALUES ('230230', '2302', '克东县', null, '1', null);
INSERT INTO `district_code` VALUES ('150425', '1504', '克什克腾旗', null, '1', null);
INSERT INTO `district_code` VALUES ('230229', '2302', '克山县', null, '1', null);
INSERT INTO `district_code` VALUES ('650203', '6502', '克拉玛依区', null, '1', null);
INSERT INTO `district_code` VALUES ('370882', '3708', '兖州市', null, '1', null);
INSERT INTO `district_code` VALUES ('360729', '3607', '全南县', null, '1', null);
INSERT INTO `district_code` VALUES ('450324', '4503', '全州县', null, '1', null);
INSERT INTO `district_code` VALUES ('341124', '3411', '全椒县', null, '1', null);
INSERT INTO `district_code` VALUES ('340405', '3404', '八公山区', null, '1', null);
INSERT INTO `district_code` VALUES ('542127', '5421', '八宿县', null, '1', null);
INSERT INTO `district_code` VALUES ('451102', '4511', '八步区', null, '1', null);
INSERT INTO `district_code` VALUES ('220602', '2206', '八道江区', null, '1', null);
INSERT INTO `district_code` VALUES ('220381', '2203', '公主岭市', null, '1', null);
INSERT INTO `district_code` VALUES ('421022', '4210', '公安县', null, '1', null);
INSERT INTO `district_code` VALUES ('320116', '3201', '六合区', null, '1', null);
INSERT INTO `district_code` VALUES ('520203', '5202', '六枝特区', null, '1', null);
INSERT INTO `district_code` VALUES ('533325', '5333', '兰坪白族普米族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('371302', '3713', '兰山区', null, '1', null);
INSERT INTO `district_code` VALUES ('330781', '3307', '兰溪市', null, '1', null);
INSERT INTO `district_code` VALUES ('410225', '4102', '兰考县', null, '1', null);
INSERT INTO `district_code` VALUES ('231222', '2312', '兰西县', null, '1', null);
INSERT INTO `district_code` VALUES ('632521', '6325', '共和县', null, '1', null);
INSERT INTO `district_code` VALUES ('360482', '3604', '共青城市', null, '1', null);
INSERT INTO `district_code` VALUES ('520424', '5204', '关岭布依族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('450924', '4509', '兴业县', null, '1', null);
INSERT INTO `district_code` VALUES ('522301', '5223', '兴义市', null, '1', null);
INSERT INTO `district_code` VALUES ('522322', '5223', '兴仁县', null, '1', null);
INSERT INTO `district_code` VALUES ('321281', '3212', '兴化市', null, '1', null);
INSERT INTO `district_code` VALUES ('141123', '1411', '兴县', null, '1', null);
INSERT INTO `district_code` VALUES ('150924', '1509', '兴和县', null, '1', null);
INSERT INTO `district_code` VALUES ('360732', '3607', '兴国县', null, '1', null);
INSERT INTO `district_code` VALUES ('211481', '2114', '兴城市', null, '1', null);
INSERT INTO `district_code` VALUES ('450102', '4501', '兴宁区', null, '1', null);
INSERT INTO `district_code` VALUES ('441481', '4414', '兴宁市', null, '1', null);
INSERT INTO `district_code` VALUES ('230405', '2304', '兴安区', null, '1', null);
INSERT INTO `district_code` VALUES ('450325', '4503', '兴安县', null, '1', null);
INSERT INTO `district_code` VALUES ('451302', '4513', '兴宾区', null, '1', null);
INSERT INTO `district_code` VALUES ('230407', '2304', '兴山区', null, '1', null);
INSERT INTO `district_code` VALUES ('420526', '4205', '兴山县', null, '1', null);
INSERT INTO `district_code` VALUES ('610481', '6104', '兴平市', null, '1', null);
INSERT INTO `district_code` VALUES ('640104', '6401', '兴庆区', null, '1', null);
INSERT INTO `district_code` VALUES ('511528', '5115', '兴文县', null, '1', null);
INSERT INTO `district_code` VALUES ('632524', '6325', '兴海县', null, '1', null);
INSERT INTO `district_code` VALUES ('130822', '1308', '兴隆县', null, '1', null);
INSERT INTO `district_code` VALUES ('211103', '2111', '兴隆台区', null, '1', null);
INSERT INTO `district_code` VALUES ('131181', '1311', '冀州市', null, '1', null);
INSERT INTO `district_code` VALUES ('130523', '1305', '内丘县', null, '1', null);
INSERT INTO `district_code` VALUES ('411325', '4113', '内乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('410527', '4105', '内黄县', null, '1', null);
INSERT INTO `district_code` VALUES ('522327', '5223', '册亨县', null, '1', null);
INSERT INTO `district_code` VALUES ('513433', '5134', '冕宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('220122', '2201', '农安县', null, '1', null);
INSERT INTO `district_code` VALUES ('371525', '3715', '冠县', null, '1', null);
INSERT INTO `district_code` VALUES ('431381', '4313', '冷水江市', null, '1', null);
INSERT INTO `district_code` VALUES ('431103', '4311', '冷水滩区', null, '1', null);
INSERT INTO `district_code` VALUES ('150622', '1506', '准格尔旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150925', '1509', '凉城县', null, '1', null);
INSERT INTO `district_code` VALUES ('620602', '6206', '凉州区', null, '1', null);
INSERT INTO `district_code` VALUES ('451027', '4510', '凌云县', null, '1', null);
INSERT INTO `district_code` VALUES ('210703', '2107', '凌河区', null, '1', null);
INSERT INTO `district_code` VALUES ('210781', '2107', '凌海市', null, '1', null);
INSERT INTO `district_code` VALUES ('211382', '2113', '凌源市', null, '1', null);
INSERT INTO `district_code` VALUES ('520327', '5203', '凤冈县', null, '1', null);
INSERT INTO `district_code` VALUES ('433123', '4331', '凤凰县', null, '1', null);
INSERT INTO `district_code` VALUES ('610330', '6103', '凤县', null, '1', null);
INSERT INTO `district_code` VALUES ('340421', '3404', '凤台县', null, '1', null);
INSERT INTO `district_code` VALUES ('210682', '2106', '凤城市', null, '1', null);
INSERT INTO `district_code` VALUES ('451223', '4512', '凤山县', null, '1', null);
INSERT INTO `district_code` VALUES ('530921', '5309', '凤庆县', null, '1', null);
INSERT INTO `district_code` VALUES ('410704', '4107', '凤泉区', null, '1', null);
INSERT INTO `district_code` VALUES ('610322', '6103', '凤翔县', null, '1', null);
INSERT INTO `district_code` VALUES ('341126', '3411', '凤阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('451481', '4514', '凭祥市', null, '1', null);
INSERT INTO `district_code` VALUES ('522601', '5226', '凯里市', null, '1', null);
INSERT INTO `district_code` VALUES ('360521', '3605', '分宜县', null, '1', null);
INSERT INTO `district_code` VALUES ('632224', '6322', '刚察县', null, '1', null);
INSERT INTO `district_code` VALUES ('422802', '4228', '利川市', null, '1', null);
INSERT INTO `district_code` VALUES ('510802', '5108', '利州区', null, '1', null);
INSERT INTO `district_code` VALUES ('370522', '3705', '利津县', null, '1', null);
INSERT INTO `district_code` VALUES ('341623', '3416', '利辛县', null, '1', null);
INSERT INTO `district_code` VALUES ('640302', '6403', '利通区', null, '1', null);
INSERT INTO `district_code` VALUES ('230804', '2308', '前进区', null, '1', null);
INSERT INTO `district_code` VALUES ('220721', '2207', '前郭尔罗斯蒙古族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('532931', '5329', '剑川县', null, '1', null);
INSERT INTO `district_code` VALUES ('522629', '5226', '剑河县', null, '1', null);
INSERT INTO `district_code` VALUES ('510823', '5108', '剑阁县', null, '1', null);
INSERT INTO `district_code` VALUES ('542229', '5422', '加查县', null, '1', null);
INSERT INTO `district_code` VALUES ('520326', '5203', '务川仡佬族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('230921', '2309', '勃利县', null, '1', null);
INSERT INTO `district_code` VALUES ('610725', '6107', '勉县', null, '1', null);
INSERT INTO `district_code` VALUES ('532822', '5328', '勐海县', null, '1', null);
INSERT INTO `district_code` VALUES ('532823', '5328', '勐腊县', null, '1', null);
INSERT INTO `district_code` VALUES ('340111', '3401', '包河区', null, '1', null);
INSERT INTO `district_code` VALUES ('440982', '4409', '化州市', null, '1', null);
INSERT INTO `district_code` VALUES ('150922', '1509', '化德县', null, '1', null);
INSERT INTO `district_code` VALUES ('632127', '6321', '化隆回族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('330206', '3302', '北仑区', null, '1', null);
INSERT INTO `district_code` VALUES ('410503', '4105', '北关区', null, '1', null);
INSERT INTO `district_code` VALUES ('430511', '4305', '北塔区', null, '1', null);
INSERT INTO `district_code` VALUES ('320204', '3202', '北塘区', null, '1', null);
INSERT INTO `district_code` VALUES ('231181', '2311', '北安市', null, '1', null);
INSERT INTO `district_code` VALUES ('510726', '5107', '北川羌族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('130603', '1306', '北市区', null, '1', null);
INSERT INTO `district_code` VALUES ('130304', '1303', '北戴河区', null, '1', null);
INSERT INTO `district_code` VALUES ('231202', '2312', '北林区', null, '1', null);
INSERT INTO `district_code` VALUES ('450981', '4509', '北流市', null, '1', null);
INSERT INTO `district_code` VALUES ('431002', '4310', '北湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('500109', '50', '北碚区', null, '1', null);
INSERT INTO `district_code` VALUES ('211381', '2113', '北票市', null, '1', null);
INSERT INTO `district_code` VALUES ('120113', '12', '北辰区', null, '1', null);
INSERT INTO `district_code` VALUES ('210782', '2107', '北镇市', null, '1', null);
INSERT INTO `district_code` VALUES ('210311', '2103', '千山区', null, '1', null);
INSERT INTO `district_code` VALUES ('610328', '6103', '千阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('620824', '6208', '华亭县', null, '1', null);
INSERT INTO `district_code` VALUES ('610521', '6105', '华县', null, '1', null);
INSERT INTO `district_code` VALUES ('530723', '5307', '华坪县', null, '1', null);
INSERT INTO `district_code` VALUES ('530424', '5304', '华宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('350629', '3506', '华安县', null, '1', null);
INSERT INTO `district_code` VALUES ('420703', '4207', '华容区', null, '1', null);
INSERT INTO `district_code` VALUES ('430623', '4306', '华容县', null, '1', null);
INSERT INTO `district_code` VALUES ('621023', '6210', '华池县', null, '1', null);
INSERT INTO `district_code` VALUES ('511681', '5116', '华蓥市', null, '1', null);
INSERT INTO `district_code` VALUES ('610582', '6105', '华阴市', null, '1', null);
INSERT INTO `district_code` VALUES ('410902', '4109', '华龙区', null, '1', null);
INSERT INTO `district_code` VALUES ('623022', '6230', '卓尼县', null, '1', null);
INSERT INTO `district_code` VALUES ('150921', '1509', '卓资县', null, '1', null);
INSERT INTO `district_code` VALUES ('371722', '3717', '单县', null, '1', null);
INSERT INTO `district_code` VALUES ('361023', '3610', '南丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('451221', '4512', '南丹县', null, '1', null);
INSERT INTO `district_code` VALUES ('410923', '4109', '南乐县', null, '1', null);
INSERT INTO `district_code` VALUES ('220102', '2201', '南关区', null, '1', null);
INSERT INTO `district_code` VALUES ('532324', '5323', '南华县', null, '1', null);
INSERT INTO `district_code` VALUES ('430921', '4309', '南县', null, '1', null);
INSERT INTO `district_code` VALUES ('411321', '4113', '南召县', null, '1', null);
INSERT INTO `district_code` VALUES ('130527', '1305', '南和县', null, '1', null);
INSERT INTO `district_code` VALUES ('361021', '3610', '南城县', null, '1', null);
INSERT INTO `district_code` VALUES ('350583', '3505', '南安市', null, '1', null);
INSERT INTO `district_code` VALUES ('130581', '1305', '南宫市', null, '1', null);
INSERT INTO `district_code` VALUES ('230404', '2304', '南山区', null, '1', null);
INSERT INTO `district_code` VALUES ('230703', '2307', '南岔区', null, '1', null);
INSERT INTO `district_code` VALUES ('230103', '2301', '南岗区', null, '1', null);
INSERT INTO `district_code` VALUES ('430412', '4304', '南岳区', null, '1', null);
INSERT INTO `district_code` VALUES ('500108', '50', '南岸区', null, '1', null);
INSERT INTO `district_code` VALUES ('500119', '50', '南川区', null, '1', null);
INSERT INTO `district_code` VALUES ('130604', '1306', '南市区', null, '1', null);
INSERT INTO `district_code` VALUES ('360782', '3607', '南康市', null, '1', null);
INSERT INTO `district_code` VALUES ('120104', '12', '南开区', null, '1', null);
INSERT INTO `district_code` VALUES ('360121', '3601', '南昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('520102', '5201', '南明区', null, '1', null);
INSERT INTO `district_code` VALUES ('542322', '5423', '南木林县', null, '1', null);
INSERT INTO `district_code` VALUES ('511922', '5119', '南江县', null, '1', null);
INSERT INTO `district_code` VALUES ('440115', '4401', '南沙区', null, '1', null);
INSERT INTO `district_code` VALUES ('469032', '4690', '南沙群岛', null, '1', null);
INSERT INTO `district_code` VALUES ('330503', '3305', '南浔区', null, '1', null);
INSERT INTO `district_code` VALUES ('440605', '4406', '南海区', null, '1', null);
INSERT INTO `district_code` VALUES ('532926', '5329', '南涧彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('330402', '3304', '南湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('511503', '5115', '南溪区', null, '1', null);
INSERT INTO `district_code` VALUES ('420624', '4206', '南漳县', null, '1', null);
INSERT INTO `district_code` VALUES ('440523', '4405', '南澳县', null, '1', null);
INSERT INTO `district_code` VALUES ('130927', '1309', '南皮县', null, '1', null);
INSERT INTO `district_code` VALUES ('211404', '2114', '南票区', null, '1', null);
INSERT INTO `district_code` VALUES ('210505', '2105', '南芬区', null, '1', null);
INSERT INTO `district_code` VALUES ('341103', '3411', '南谯区', null, '1', null);
INSERT INTO `district_code` VALUES ('140211', '1402', '南郊区', null, '1', null);
INSERT INTO `district_code` VALUES ('610721', '6107', '南郑县', null, '1', null);
INSERT INTO `district_code` VALUES ('511321', '5113', '南部县', null, '1', null);
INSERT INTO `district_code` VALUES ('320203', '3202', '南长区', null, '1', null);
INSERT INTO `district_code` VALUES ('340223', '3402', '南陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('440282', '4402', '南雄市', null, '1', null);
INSERT INTO `district_code` VALUES ('350627', '3506', '南靖县', null, '1', null);
INSERT INTO `district_code` VALUES ('652701', '6527', '博乐市', null, '1', null);
INSERT INTO `district_code` VALUES ('371625', '3716', '博兴县', null, '1', null);
INSERT INTO `district_code` VALUES ('370304', '3703', '博山区', null, '1', null);
INSERT INTO `district_code` VALUES ('652829', '6528', '博湖县', null, '1', null);
INSERT INTO `district_code` VALUES ('410822', '4108', '博爱县', null, '1', null);
INSERT INTO `district_code` VALUES ('450923', '4509', '博白县', null, '1', null);
INSERT INTO `district_code` VALUES ('441322', '4413', '博罗县', null, '1', null);
INSERT INTO `district_code` VALUES ('130637', '1306', '博野县', null, '1', null);
INSERT INTO `district_code` VALUES ('411224', '4112', '卢氏县', null, '1', null);
INSERT INTO `district_code` VALUES ('130324', '1303', '卢龙县', null, '1', null);
INSERT INTO `district_code` VALUES ('411303', '4113', '卧龙区', null, '1', null);
INSERT INTO `district_code` VALUES ('410403', '4104', '卫东区', null, '1', null);
INSERT INTO `district_code` VALUES ('410703', '4107', '卫滨区', null, '1', null);
INSERT INTO `district_code` VALUES ('410781', '4107', '卫辉市', null, '1', null);
INSERT INTO `district_code` VALUES ('610203', '6102', '印台区', null, '1', null);
INSERT INTO `district_code` VALUES ('520625', '5206', '印江土家族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('370282', '3702', '即墨市', null, '1', null);
INSERT INTO `district_code` VALUES ('370102', '3701', '历下区', null, '1', null);
INSERT INTO `district_code` VALUES ('370112', '3701', '历城区', null, '1', null);
INSERT INTO `district_code` VALUES ('640402', '6404', '原州区', null, '1', null);
INSERT INTO `district_code` VALUES ('140981', '1409', '原平市', null, '1', null);
INSERT INTO `district_code` VALUES ('410725', '4107', '原阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('230704', '2307', '友好区', null, '1', null);
INSERT INTO `district_code` VALUES ('230522', '2305', '友谊县', null, '1', null);
INSERT INTO `district_code` VALUES ('211102', '2111', '双台子区', null, '1', null);
INSERT INTO `district_code` VALUES ('230182', '2301', '双城市', null, '1', null);
INSERT INTO `district_code` VALUES ('211302', '2113', '双塔区', null, '1', null);
INSERT INTO `district_code` VALUES ('431321', '4313', '双峰县', null, '1', null);
INSERT INTO `district_code` VALUES ('532322', '5323', '双柏县', null, '1', null);
INSERT INTO `district_code` VALUES ('130802', '1308', '双桥区', null, '1', null);
INSERT INTO `district_code` VALUES ('530925', '5309', '双江拉祜族佤族布朗族傣族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('510122', '5101', '双流县', null, '1', null);
INSERT INTO `district_code` VALUES ('430502', '4305', '双清区', null, '1', null);
INSERT INTO `district_code` VALUES ('130803', '1308', '双滦区', null, '1', null);
INSERT INTO `district_code` VALUES ('431123', '4311', '双牌县', null, '1', null);
INSERT INTO `district_code` VALUES ('220382', '2203', '双辽市', null, '1', null);
INSERT INTO `district_code` VALUES ('220112', '2201', '双阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('510524', '5105', '叙永县', null, '1', null);
INSERT INTO `district_code` VALUES ('450303', '4503', '叠彩区', null, '1', null);
INSERT INTO `district_code` VALUES ('433126', '4331', '古丈县', null, '1', null);
INSERT INTO `district_code` VALUES ('140181', '1401', '古交市', null, '1', null);
INSERT INTO `district_code` VALUES ('130204', '1302', '古冶区', null, '1', null);
INSERT INTO `district_code` VALUES ('141025', '1410', '古县', null, '1', null);
INSERT INTO `district_code` VALUES ('530702', '5307', '古城区', null, '1', null);
INSERT INTO `district_code` VALUES ('210702', '2107', '古塔区', null, '1', null);
INSERT INTO `district_code` VALUES ('620622', '6206', '古浪县', null, '1', null);
INSERT INTO `district_code` VALUES ('350922', '3509', '古田县', null, '1', null);
INSERT INTO `district_code` VALUES ('510525', '5105', '古蔺县', null, '1', null);
INSERT INTO `district_code` VALUES ('321183', '3211', '句容市', null, '1', null);
INSERT INTO `district_code` VALUES ('411104', '4111', '召陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('370405', '3704', '台儿庄区', null, '1', null);
INSERT INTO `district_code` VALUES ('410927', '4109', '台前县', null, '1', null);
INSERT INTO `district_code` VALUES ('210321', '2103', '台安县', null, '1', null);
INSERT INTO `district_code` VALUES ('440781', '4407', '台山市', null, '1', null);
INSERT INTO `district_code` VALUES ('350103', '3501', '台江区', null, '1', null);
INSERT INTO `district_code` VALUES ('522630', '5226', '台江县', null, '1', null);
INSERT INTO `district_code` VALUES ('451002', '4510', '右江区', null, '1', null);
INSERT INTO `district_code` VALUES ('140623', '1406', '右玉县', null, '1', null);
INSERT INTO `district_code` VALUES ('410422', '4104', '叶县', null, '1', null);
INSERT INTO `district_code` VALUES ('653126', '6531', '叶城县', null, '1', null);
INSERT INTO `district_code` VALUES ('623001', '6230', '合作市', null, '1', null);
INSERT INTO `district_code` VALUES ('451381', '4513', '合山市', null, '1', null);
INSERT INTO `district_code` VALUES ('500117', '50', '合川区', null, '1', null);
INSERT INTO `district_code` VALUES ('621024', '6210', '合水县', null, '1', null);
INSERT INTO `district_code` VALUES ('510522', '5105', '合江县', null, '1', null);
INSERT INTO `district_code` VALUES ('450521', '4505', '合浦县', null, '1', null);
INSERT INTO `district_code` VALUES ('610524', '6105', '合阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('410306', '4103', '吉利区', null, '1', null);
INSERT INTO `district_code` VALUES ('141028', '1410', '吉县', null, '1', null);
INSERT INTO `district_code` VALUES ('360821', '3608', '吉安县', null, '1', null);
INSERT INTO `district_code` VALUES ('360802', '3608', '吉州区', null, '1', null);
INSERT INTO `district_code` VALUES ('654326', '6543', '吉木乃县', null, '1', null);
INSERT INTO `district_code` VALUES ('652327', '6523', '吉木萨尔县', null, '1', null);
INSERT INTO `district_code` VALUES ('360822', '3608', '吉水县', null, '1', null);
INSERT INTO `district_code` VALUES ('542335', '5423', '吉隆县', null, '1', null);
INSERT INTO `district_code` VALUES ('433101', '4331', '吉首市', null, '1', null);
INSERT INTO `district_code` VALUES ('632321', '6323', '同仁县', null, '1', null);
INSERT INTO `district_code` VALUES ('350212', '3502', '同安区', null, '1', null);
INSERT INTO `district_code` VALUES ('632522', '6325', '同德县', null, '1', null);
INSERT INTO `district_code` VALUES ('640324', '6403', '同心县', null, '1', null);
INSERT INTO `district_code` VALUES ('230881', '2308', '同江市', null, '1', null);
INSERT INTO `district_code` VALUES ('511821', '5118', '名山县', null, '1', null);
INSERT INTO `district_code` VALUES ('652101', '6521', '吐鲁番市', null, '1', null);
INSERT INTO `district_code` VALUES ('230402', '2304', '向阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('430611', '4306', '君山区', null, '1', null);
INSERT INTO `district_code` VALUES ('340522', '3405', '含山县', null, '1', null);
INSERT INTO `district_code` VALUES ('320681', '3206', '启东市', null, '1', null);
INSERT INTO `district_code` VALUES ('320506', '3205', '吴中区', null, '1', null);
INSERT INTO `district_code` VALUES ('330502', '3305', '吴兴区', null, '1', null);
INSERT INTO `district_code` VALUES ('610829', '6108', '吴堡县', null, '1', null);
INSERT INTO `district_code` VALUES ('440883', '4408', '吴川市', null, '1', null);
INSERT INTO `district_code` VALUES ('130928', '1309', '吴桥县', null, '1', null);
INSERT INTO `district_code` VALUES ('320584', '3205', '吴江市', null, '1', null);
INSERT INTO `district_code` VALUES ('610626', '6106', '吴起县', null, '1', null);
INSERT INTO `district_code` VALUES ('530114', '5301', '呈贡区', null, '1', null);
INSERT INTO `district_code` VALUES ('350925', '3509', '周宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('370306', '3703', '周村区', null, '1', null);
INSERT INTO `district_code` VALUES ('610124', '6101', '周至县', null, '1', null);
INSERT INTO `district_code` VALUES ('230111', '2301', '呼兰区', null, '1', null);
INSERT INTO `district_code` VALUES ('652323', '6523', '呼图壁县', null, '1', null);
INSERT INTO `district_code` VALUES ('232721', '2327', '呼玛县', null, '1', null);
INSERT INTO `district_code` VALUES ('340523', '3405', '和县', null, '1', null);
INSERT INTO `district_code` VALUES ('654226', '6542', '和布克赛尔蒙古自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('120101', '12', '和平区', null, '1', null);
INSERT INTO `district_code` VALUES ('441624', '4416', '和平县', null, '1', null);
INSERT INTO `district_code` VALUES ('622925', '6229', '和政县', null, '1', null);
INSERT INTO `district_code` VALUES ('150123', '1501', '和林格尔县', null, '1', null);
INSERT INTO `district_code` VALUES ('653221', '6532', '和田县', null, '1', null);
INSERT INTO `district_code` VALUES ('653201', '6532', '和田市', null, '1', null);
INSERT INTO `district_code` VALUES ('652828', '6528', '和硕县', null, '1', null);
INSERT INTO `district_code` VALUES ('652827', '6528', '和静县', null, '1', null);
INSERT INTO `district_code` VALUES ('140723', '1407', '和顺县', null, '1', null);
INSERT INTO `district_code` VALUES ('222406', '2224', '和龙市', null, '1', null);
INSERT INTO `district_code` VALUES ('422826', '4228', '咸丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('421202', '4212', '咸安区', null, '1', null);
INSERT INTO `district_code` VALUES ('652201', '6522', '哈密市', null, '1', null);
INSERT INTO `district_code` VALUES ('654324', '6543', '哈巴河县', null, '1', null);
INSERT INTO `district_code` VALUES ('320921', '3209', '响水县', null, '1', null);
INSERT INTO `district_code` VALUES ('130627', '1306', '唐县', null, '1', null);
INSERT INTO `district_code` VALUES ('411328', '4113', '唐河县', null, '1', null);
INSERT INTO `district_code` VALUES ('130230', '1302', '唐海县', null, '1', null);
INSERT INTO `district_code` VALUES ('611023', '6110', '商南县', null, '1', null);
INSERT INTO `district_code` VALUES ('411524', '4115', '商城县', null, '1', null);
INSERT INTO `district_code` VALUES ('611002', '6110', '商州区', null, '1', null);
INSERT INTO `district_code` VALUES ('411623', '4116', '商水县', null, '1', null);
INSERT INTO `district_code` VALUES ('370126', '3701', '商河县', null, '1', null);
INSERT INTO `district_code` VALUES ('150923', '1509', '商都县', null, '1', null);
INSERT INTO `district_code` VALUES ('653101', '6531', '喀什市', null, '1', null);
INSERT INTO `district_code` VALUES ('211324', '2113', '喀喇沁左翼蒙古族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('150428', '1504', '喀喇沁旗', null, '1', null);
INSERT INTO `district_code` VALUES ('513432', '5134', '喜德县', null, '1', null);
INSERT INTO `district_code` VALUES ('330421', '3304', '嘉善县', null, '1', null);
INSERT INTO `district_code` VALUES ('310114', '31', '嘉定区', null, '1', null);
INSERT INTO `district_code` VALUES ('370829', '3708', '嘉祥县', null, '1', null);
INSERT INTO `district_code` VALUES ('431024', '4310', '嘉禾县', null, '1', null);
INSERT INTO `district_code` VALUES ('230722', '2307', '嘉荫县', null, '1', null);
INSERT INTO `district_code` VALUES ('511304', '5113', '嘉陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('421221', '4212', '嘉鱼县', null, '1', null);
INSERT INTO `district_code` VALUES ('542422', '5424', '嘉黎县', null, '1', null);
INSERT INTO `district_code` VALUES ('542523', '5425', '噶尔县', null, '1', null);
INSERT INTO `district_code` VALUES ('632725', '6327', '囊谦县', null, '1', null);
INSERT INTO `district_code` VALUES ('441284', '4412', '四会市', null, '1', null);
INSERT INTO `district_code` VALUES ('150929', '1509', '四子王旗', null, '1', null);
INSERT INTO `district_code` VALUES ('370205', '3702', '四方区', null, '1', null);
INSERT INTO `district_code` VALUES ('230505', '2305', '四方台区', null, '1', null);
INSERT INTO `district_code` VALUES ('150103', '1501', '回民区', null, '1', null);
INSERT INTO `district_code` VALUES ('421121', '4211', '团风县', null, '1', null);
INSERT INTO `district_code` VALUES ('130828', '1308', '围场满族蒙古族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('411525', '4115', '固始县', null, '1', null);
INSERT INTO `district_code` VALUES ('131022', '1310', '固安县', null, '1', null);
INSERT INTO `district_code` VALUES ('340323', '3403', '固镇县', null, '1', null);
INSERT INTO `district_code` VALUES ('150222', '1502', '固阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('222402', '2224', '图们市', null, '1', null);
INSERT INTO `district_code` VALUES ('659003', '6590', '图木舒克市', null, '1', null);
INSERT INTO `district_code` VALUES ('150221', '1502', '土默特右旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150121', '1501', '土默特左旗', null, '1', null);
INSERT INTO `district_code` VALUES ('370704', '3707', '坊子区', null, '1', null);
INSERT INTO `district_code` VALUES ('440804', '4408', '坡头区', null, '1', null);
INSERT INTO `district_code` VALUES ('140827', '1408', '垣曲县', null, '1', null);
INSERT INTO `district_code` VALUES ('370521', '3705', '垦利县', null, '1', null);
INSERT INTO `district_code` VALUES ('500231', '50', '垫江县', null, '1', null);
INSERT INTO `district_code` VALUES ('341302', '3413', '埇桥区', null, '1', null);
INSERT INTO `district_code` VALUES ('630102', '6301', '城东区', null, '1', null);
INSERT INTO `district_code` VALUES ('450202', '4502', '城中区', null, '1', null);
INSERT INTO `district_code` VALUES ('540102', '5401', '城关区', null, '1', null);
INSERT INTO `district_code` VALUES ('630105', '6301', '城北区', null, '1', null);
INSERT INTO `district_code` VALUES ('140202', '1402', '城区', null, '1', null);
INSERT INTO `district_code` VALUES ('350302', '3503', '城厢区', null, '1', null);
INSERT INTO `district_code` VALUES ('500229', '50', '城口县', null, '1', null);
INSERT INTO `district_code` VALUES ('610722', '6107', '城固县', null, '1', null);
INSERT INTO `district_code` VALUES ('230306', '2303', '城子河区', null, '1', null);
INSERT INTO `district_code` VALUES ('430529', '4305', '城步苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('630104', '6301', '城西区', null, '1', null);
INSERT INTO `district_code` VALUES ('370214', '3702', '城阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('540125', '5401', '堆龙德庆县', null, '1', null);
INSERT INTO `district_code` VALUES ('653131', '6531', '塔什库尔干塔吉克自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('654201', '6542', '塔城市', null, '1', null);
INSERT INTO `district_code` VALUES ('232722', '2327', '塔河县', null, '1', null);
INSERT INTO `district_code` VALUES ('440183', '4401', '增城市', null, '1', null);
INSERT INTO `district_code` VALUES ('530822', '5308', '墨江哈尼族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('653222', '6532', '墨玉县', null, '1', null);
INSERT INTO `district_code` VALUES ('540127', '5401', '墨竹工卡县', null, '1', null);
INSERT INTO `district_code` VALUES ('542624', '5426', '墨脱县', null, '1', null);
INSERT INTO `district_code` VALUES ('513230', '5132', '壤塘县', null, '1', null);
INSERT INTO `district_code` VALUES ('140427', '1404', '壶关县', null, '1', null);
INSERT INTO `district_code` VALUES ('130404', '1304', '复兴区', null, '1', null);
INSERT INTO `district_code` VALUES ('140828', '1408', '夏县', null, '1', null);
INSERT INTO `district_code` VALUES ('623027', '6230', '夏河县', null, '1', null);
INSERT INTO `district_code` VALUES ('371427', '3714', '夏津县', null, '1', null);
INSERT INTO `district_code` VALUES ('411426', '4114', '夏邑县', null, '1', null);
INSERT INTO `district_code` VALUES ('152531', '1525', '多伦县', null, '1', null);
INSERT INTO `district_code` VALUES ('210104', '2101', '大东区', null, '1', null);
INSERT INTO `district_code` VALUES ('320982', '3209', '大丰市', null, '1', null);
INSERT INTO `district_code` VALUES ('360723', '3607', '大余县', null, '1', null);
INSERT INTO `district_code` VALUES ('530624', '5306', '大关县', null, '1', null);
INSERT INTO `district_code` VALUES ('110115', '11', '大兴区', null, '1', null);
INSERT INTO `district_code` VALUES ('420281', '4202', '大冶市', null, '1', null);
INSERT INTO `district_code` VALUES ('451229', '4512', '大化瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('131028', '1310', '大厂回族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('230606', '2306', '大同区', null, '1', null);
INSERT INTO `district_code` VALUES ('140227', '1402', '大同县', null, '1', null);
INSERT INTO `district_code` VALUES ('130425', '1304', '大名县', null, '1', null);
INSERT INTO `district_code` VALUES ('131025', '1310', '大城县', null, '1', null);
INSERT INTO `district_code` VALUES ('441422', '4414', '大埔县', null, '1', null);
INSERT INTO `district_code` VALUES ('532326', '5323', '大姚县', null, '1', null);
INSERT INTO `district_code` VALUES ('141030', '1410', '大宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('510304', '5103', '大安区', null, '1', null);
INSERT INTO `district_code` VALUES ('220882', '2208', '大安市', null, '1', null);
INSERT INTO `district_code` VALUES ('420922', '4209', '大悟县', null, '1', null);
INSERT INTO `district_code` VALUES ('451424', '4514', '大新县', null, '1', null);
INSERT INTO `district_code` VALUES ('520521', '5205', '大方县', null, '1', null);
INSERT INTO `district_code` VALUES ('640202', '6402', '大武口区', null, '1', null);
INSERT INTO `district_code` VALUES ('211121', '2111', '大洼县', null, '1', null);
INSERT INTO `district_code` VALUES ('500104', '50', '大渡口区', null, '1', null);
INSERT INTO `district_code` VALUES ('532901', '5329', '大理市', null, '1', null);
INSERT INTO `district_code` VALUES ('350425', '3504', '大田县', null, '1', null);
INSERT INTO `district_code` VALUES ('210882', '2108', '大石桥市', null, '1', null);
INSERT INTO `district_code` VALUES ('430503', '4305', '大祥区', null, '1', null);
INSERT INTO `district_code` VALUES ('511724', '5117', '大竹县', null, '1', null);
INSERT INTO `district_code` VALUES ('510923', '5109', '大英县', null, '1', null);
INSERT INTO `district_code` VALUES ('610523', '6105', '大荔县', null, '1', null);
INSERT INTO `district_code` VALUES ('340803', '3408', '大观区', null, '1', null);
INSERT INTO `district_code` VALUES ('500111', '50', '大足区', null, '1', null);
INSERT INTO `district_code` VALUES ('340402', '3404', '大通区', null, '1', null);
INSERT INTO `district_code` VALUES ('630121', '6301', '大通回族土族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('510129', '5101', '大邑县', null, '1', null);
INSERT INTO `district_code` VALUES ('430211', '4302', '天元区', null, '1', null);
INSERT INTO `district_code` VALUES ('511825', '5118', '天全县', null, '1', null);
INSERT INTO `district_code` VALUES ('331023', '3310', '天台县', null, '1', null);
INSERT INTO `district_code` VALUES ('320402', '3204', '天宁区', null, '1', null);
INSERT INTO `district_code` VALUES ('650102', '6501', '天山区', null, '1', null);
INSERT INTO `district_code` VALUES ('451222', '4512', '天峨县', null, '1', null);
INSERT INTO `district_code` VALUES ('632823', '6328', '天峻县', null, '1', null);
INSERT INTO `district_code` VALUES ('430103', '4301', '天心区', null, '1', null);
INSERT INTO `district_code` VALUES ('522627', '5226', '天柱县', null, '1', null);
INSERT INTO `district_code` VALUES ('370105', '3701', '天桥区', null, '1', null);
INSERT INTO `district_code` VALUES ('440106', '4401', '天河区', null, '1', null);
INSERT INTO `district_code` VALUES ('620623', '6206', '天祝藏族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('451425', '4514', '天等县', null, '1', null);
INSERT INTO `district_code` VALUES ('140222', '1402', '天镇县', null, '1', null);
INSERT INTO `district_code` VALUES ('341181', '3411', '天长市', null, '1', null);
INSERT INTO `district_code` VALUES ('429006', '4290', '天门市', null, '1', null);
INSERT INTO `district_code` VALUES ('152527', '1525', '太仆寺旗', null, '1', null);
INSERT INTO `district_code` VALUES ('320585', '3205', '太仓市', null, '1', null);
INSERT INTO `district_code` VALUES ('210711', '2107', '太和区', null, '1', null);
INSERT INTO `district_code` VALUES ('341222', '3412', '太和县', null, '1', null);
INSERT INTO `district_code` VALUES ('211011', '2110', '太子河区', null, '1', null);
INSERT INTO `district_code` VALUES ('210904', '2109', '太平区', null, '1', null);
INSERT INTO `district_code` VALUES ('411627', '4116', '太康县', null, '1', null);
INSERT INTO `district_code` VALUES ('340825', '3408', '太湖县', null, '1', null);
INSERT INTO `district_code` VALUES ('610331', '6103', '太白县', null, '1', null);
INSERT INTO `district_code` VALUES ('140726', '1407', '太谷县', null, '1', null);
INSERT INTO `district_code` VALUES ('650106', '6501', '头屯河区', null, '1', null);
INSERT INTO `district_code` VALUES ('420506', '4205', '夷陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('511126', '5111', '夹江县', null, '1', null);
INSERT INTO `district_code` VALUES ('652325', '6523', '奇台县', null, '1', null);
INSERT INTO `district_code` VALUES ('150525', '1505', '奈曼旗', null, '1', null);
INSERT INTO `district_code` VALUES ('330283', '3302', '奉化市', null, '1', null);
INSERT INTO `district_code` VALUES ('360921', '3609', '奉新县', null, '1', null);
INSERT INTO `district_code` VALUES ('500236', '50', '奉节县', null, '1', null);
INSERT INTO `district_code` VALUES ('310120', '31', '奉贤区', null, '1', null);
INSERT INTO `district_code` VALUES ('654003', '6540', '奎屯市', null, '1', null);
INSERT INTO `district_code` VALUES ('370705', '3707', '奎文区', null, '1', null);
INSERT INTO `district_code` VALUES ('320623', '3206', '如东县', null, '1', null);
INSERT INTO `district_code` VALUES ('320682', '3206', '如皋市', null, '1', null);
INSERT INTO `district_code` VALUES ('440222', '4402', '始兴县', null, '1', null);
INSERT INTO `district_code` VALUES ('532325', '5323', '姚安县', null, '1', null);
INSERT INTO `district_code` VALUES ('321284', '3212', '姜堰市', null, '1', null);
INSERT INTO `district_code` VALUES ('530629', '5306', '威信县', null, '1', null);
INSERT INTO `district_code` VALUES ('130533', '1305', '威县', null, '1', null);
INSERT INTO `district_code` VALUES ('520526', '5205', '威宁彝族回族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('511024', '5110', '威远县', null, '1', null);
INSERT INTO `district_code` VALUES ('431302', '4313', '娄星区', null, '1', null);
INSERT INTO `district_code` VALUES ('140123', '1401', '娄烦县', null, '1', null);
INSERT INTO `district_code` VALUES ('330702', '3307', '婺城区', null, '1', null);
INSERT INTO `district_code` VALUES ('361130', '3611', '婺源县', null, '1', null);
INSERT INTO `district_code` VALUES ('231121', '2311', '嫩江县', null, '1', null);
INSERT INTO `district_code` VALUES ('610831', '6108', '子洲县', null, '1', null);
INSERT INTO `district_code` VALUES ('610623', '6106', '子长县', null, '1', null);
INSERT INTO `district_code` VALUES ('231124', '2311', '孙吴县', null, '1', null);
INSERT INTO `district_code` VALUES ('141181', '1411', '孝义市', null, '1', null);
INSERT INTO `district_code` VALUES ('420902', '4209', '孝南区', null, '1', null);
INSERT INTO `district_code` VALUES ('420921', '4209', '孝昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('410883', '4108', '孟州市', null, '1', null);
INSERT INTO `district_code` VALUES ('130930', '1309', '孟村回族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('410322', '4103', '孟津县', null, '1', null);
INSERT INTO `district_code` VALUES ('530827', '5308', '孟连傣族拉祜族佤族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('430124', '4301', '宁乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('350424', '3504', '宁化县', null, '1', null);
INSERT INTO `district_code` VALUES ('513427', '5134', '宁南县', null, '1', null);
INSERT INTO `district_code` VALUES ('621026', '6210', '宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('341881', '3418', '宁国市', null, '1', null);
INSERT INTO `district_code` VALUES ('150429', '1504', '宁城县', null, '1', null);
INSERT INTO `district_code` VALUES ('231084', '2310', '宁安市', null, '1', null);
INSERT INTO `district_code` VALUES ('610726', '6107', '宁强县', null, '1', null);
INSERT INTO `district_code` VALUES ('451422', '4514', '宁明县', null, '1', null);
INSERT INTO `district_code` VALUES ('130528', '1305', '宁晋县', null, '1', null);
INSERT INTO `district_code` VALUES ('140925', '1409', '宁武县', null, '1', null);
INSERT INTO `district_code` VALUES ('220702', '2207', '宁江区', null, '1', null);
INSERT INTO `district_code` VALUES ('120221', '12', '宁河县', null, '1', null);
INSERT INTO `district_code` VALUES ('371422', '3714', '宁津县', null, '1', null);
INSERT INTO `district_code` VALUES ('530821', '5308', '宁洱哈尼族彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('330226', '3302', '宁海县', null, '1', null);
INSERT INTO `district_code` VALUES ('530724', '5307', '宁蒗彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('431126', '4311', '宁远县', null, '1', null);
INSERT INTO `district_code` VALUES ('360730', '3607', '宁都县', null, '1', null);
INSERT INTO `district_code` VALUES ('370921', '3709', '宁阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('610923', '6109', '宁陕县', null, '1', null);
INSERT INTO `district_code` VALUES ('411423', '4114', '宁陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('370784', '3707', '安丘市', null, '1', null);
INSERT INTO `district_code` VALUES ('360123', '3601', '安义县', null, '1', null);
INSERT INTO `district_code` VALUES ('430721', '4307', '安乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('431028', '4310', '安仁县', null, '1', null);
INSERT INTO `district_code` VALUES ('430923', '4309', '安化县', null, '1', null);
INSERT INTO `district_code` VALUES ('510724', '5107', '安县', null, '1', null);
INSERT INTO `district_code` VALUES ('330523', '3305', '安吉县', null, '1', null);
INSERT INTO `district_code` VALUES ('130683', '1306', '安国市', null, '1', null);
INSERT INTO `district_code` VALUES ('222426', '2224', '安图县', null, '1', null);
INSERT INTO `district_code` VALUES ('610624', '6106', '安塞县', null, '1', null);
INSERT INTO `district_code` VALUES ('542425', '5424', '安多县', null, '1', null);
INSERT INTO `district_code` VALUES ('620105', '6201', '安宁区', null, '1', null);
INSERT INTO `district_code` VALUES ('530181', '5301', '安宁市', null, '1', null);
INSERT INTO `district_code` VALUES ('621102', '6211', '安定区', null, '1', null);
INSERT INTO `district_code` VALUES ('510904', '5109', '安居区', null, '1', null);
INSERT INTO `district_code` VALUES ('512021', '5120', '安岳县', null, '1', null);
INSERT INTO `district_code` VALUES ('131125', '1311', '安平县', null, '1', null);
INSERT INTO `district_code` VALUES ('130632', '1306', '安新县', null, '1', null);
INSERT INTO `district_code` VALUES ('131002', '1310', '安次区', null, '1', null);
INSERT INTO `district_code` VALUES ('141026', '1410', '安泽县', null, '1', null);
INSERT INTO `district_code` VALUES ('360302', '3603', '安源区', null, '1', null);
INSERT INTO `district_code` VALUES ('350524', '3505', '安溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('360829', '3608', '安福县', null, '1', null);
INSERT INTO `district_code` VALUES ('231281', '2312', '安达市', null, '1', null);
INSERT INTO `district_code` VALUES ('360726', '3607', '安远县', null, '1', null);
INSERT INTO `district_code` VALUES ('410522', '4105', '安阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('420982', '4209', '安陆市', null, '1', null);
INSERT INTO `district_code` VALUES ('522328', '5223', '安龙县', null, '1', null);
INSERT INTO `district_code` VALUES ('211004', '2110', '宏伟区', null, '1', null);
INSERT INTO `district_code` VALUES ('621223', '6212', '宕昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('530111', '5301', '官渡区', null, '1', null);
INSERT INTO `district_code` VALUES ('130626', '1306', '定兴县', null, '1', null);
INSERT INTO `district_code` VALUES ('360728', '3607', '定南县', null, '1', null);
INSERT INTO `district_code` VALUES ('469021', '4690', '定安县', null, '1', null);
INSERT INTO `district_code` VALUES ('130682', '1306', '定州市', null, '1', null);
INSERT INTO `district_code` VALUES ('542324', '5423', '定日县', null, '1', null);
INSERT INTO `district_code` VALUES ('330902', '3309', '定海区', null, '1', null);
INSERT INTO `district_code` VALUES ('542332', '5423', '定结县', null, '1', null);
INSERT INTO `district_code` VALUES ('140921', '1409', '定襄县', null, '1', null);
INSERT INTO `district_code` VALUES ('610825', '6108', '定边县', null, '1', null);
INSERT INTO `district_code` VALUES ('341125', '3411', '定远县', null, '1', null);
INSERT INTO `district_code` VALUES ('371727', '3717', '定陶县', null, '1', null);
INSERT INTO `district_code` VALUES ('411302', '4113', '宛城区', null, '1', null);
INSERT INTO `district_code` VALUES ('360924', '3609', '宜丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('320282', '3202', '宜兴市', null, '1', null);
INSERT INTO `district_code` VALUES ('610222', '6102', '宜君县', null, '1', null);
INSERT INTO `district_code` VALUES ('420684', '4206', '宜城市', null, '1', null);
INSERT INTO `district_code` VALUES ('511521', '5115', '宜宾县', null, '1', null);
INSERT INTO `district_code` VALUES ('610630', '6106', '宜川县', null, '1', null);
INSERT INTO `district_code` VALUES ('451281', '4512', '宜州市', null, '1', null);
INSERT INTO `district_code` VALUES ('340811', '3408', '宜秀区', null, '1', null);
INSERT INTO `district_code` VALUES ('431022', '4310', '宜章县', null, '1', null);
INSERT INTO `district_code` VALUES ('530125', '5301', '宜良县', null, '1', null);
INSERT INTO `district_code` VALUES ('420581', '4205', '宜都市', null, '1', null);
INSERT INTO `district_code` VALUES ('410327', '4103', '宜阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('361026', '3610', '宜黄县', null, '1', null);
INSERT INTO `district_code` VALUES ('410421', '4104', '宝丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('511827', '5118', '宝兴县', null, '1', null);
INSERT INTO `district_code` VALUES ('120115', '12', '宝坻区', null, '1', null);
INSERT INTO `district_code` VALUES ('610602', '6106', '宝塔区', null, '1', null);
INSERT INTO `district_code` VALUES ('440306', '4403', '宝安区', null, '1', null);
INSERT INTO `district_code` VALUES ('230506', '2305', '宝山区', null, '1', null);
INSERT INTO `district_code` VALUES ('321023', '3210', '宝应县', null, '1', null);
INSERT INTO `district_code` VALUES ('230523', '2305', '宝清县', null, '1', null);
INSERT INTO `district_code` VALUES ('130705', '1307', '宣化区', null, '1', null);
INSERT INTO `district_code` VALUES ('130721', '1307', '宣化县', null, '1', null);
INSERT INTO `district_code` VALUES ('530381', '5303', '宣威市', null, '1', null);
INSERT INTO `district_code` VALUES ('341802', '3418', '宣州区', null, '1', null);
INSERT INTO `district_code` VALUES ('422825', '4228', '宣恩县', null, '1', null);
INSERT INTO `district_code` VALUES ('511722', '5117', '宣汉县', null, '1', null);
INSERT INTO `district_code` VALUES ('450921', '4509', '容县', null, '1', null);
INSERT INTO `district_code` VALUES ('130629', '1306', '容城县', null, '1', null);
INSERT INTO `district_code` VALUES ('220103', '2201', '宽城区', null, '1', null);
INSERT INTO `district_code` VALUES ('130827', '1308', '宽城满族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('210624', '2106', '宽甸满族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('230125', '2301', '宾县', null, '1', null);
INSERT INTO `district_code` VALUES ('532924', '5329', '宾川县', null, '1', null);
INSERT INTO `district_code` VALUES ('450126', '4501', '宾阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('321302', '3213', '宿城区', null, '1', null);
INSERT INTO `district_code` VALUES ('340826', '3408', '宿松县', null, '1', null);
INSERT INTO `district_code` VALUES ('321311', '3213', '宿豫区', null, '1', null);
INSERT INTO `district_code` VALUES ('110228', '11', '密云县', null, '1', null);
INSERT INTO `district_code` VALUES ('230382', '2303', '密山市', null, '1', null);
INSERT INTO `district_code` VALUES ('610628', '6106', '富县', null, '1', null);
INSERT INTO `district_code` VALUES ('532628', '5326', '富宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('451123', '4511', '富川瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('610528', '6105', '富平县', null, '1', null);
INSERT INTO `district_code` VALUES ('230206', '2302', '富拉尔基区', null, '1', null);
INSERT INTO `district_code` VALUES ('530124', '5301', '富民县', null, '1', null);
INSERT INTO `district_code` VALUES ('530325', '5303', '富源县', null, '1', null);
INSERT INTO `district_code` VALUES ('654322', '6543', '富蕴县', null, '1', null);
INSERT INTO `district_code` VALUES ('230227', '2302', '富裕县', null, '1', null);
INSERT INTO `district_code` VALUES ('230882', '2308', '富锦市', null, '1', null);
INSERT INTO `district_code` VALUES ('330183', '3301', '富阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('510322', '5103', '富顺县', null, '1', null);
INSERT INTO `district_code` VALUES ('370703', '3707', '寒亭区', null, '1', null);
INSERT INTO `district_code` VALUES ('150927', '1509', '察哈尔右翼中旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150926', '1509', '察哈尔右翼前旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150928', '1509', '察哈尔右翼后旗', null, '1', null);
INSERT INTO `district_code` VALUES ('654022', '6540', '察布查尔锡伯自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('542626', '5426', '察隅县', null, '1', null);
INSERT INTO `district_code` VALUES ('542126', '5421', '察雅县', null, '1', null);
INSERT INTO `district_code` VALUES ('360734', '3607', '寻乌县', null, '1', null);
INSERT INTO `district_code` VALUES ('530129', '5301', '寻甸回族彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('370783', '3707', '寿光市', null, '1', null);
INSERT INTO `district_code` VALUES ('341521', '3415', '寿县', null, '1', null);
INSERT INTO `district_code` VALUES ('350924', '3509', '寿宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('140725', '1407', '寿阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('410727', '4107', '封丘县', null, '1', null);
INSERT INTO `district_code` VALUES ('441225', '4412', '封开县', null, '1', null);
INSERT INTO `district_code` VALUES ('510922', '5109', '射洪县', null, '1', null);
INSERT INTO `district_code` VALUES ('320924', '3209', '射阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('350428', '3504', '将乐县', null, '1', null);
INSERT INTO `district_code` VALUES ('410223', '4102', '尉氏县', null, '1', null);
INSERT INTO `district_code` VALUES ('652823', '6528', '尉犁县', null, '1', null);
INSERT INTO `district_code` VALUES ('140105', '1401', '小店区', null, '1', null);
INSERT INTO `district_code` VALUES ('520114', '5201', '小河区', null, '1', null);
INSERT INTO `district_code` VALUES ('513227', '5132', '小金县', null, '1', null);
INSERT INTO `district_code` VALUES ('230502', '2305', '尖山区', null, '1', null);
INSERT INTO `district_code` VALUES ('632322', '6323', '尖扎县', null, '1', null);
INSERT INTO `district_code` VALUES ('140108', '1401', '尖草坪区', null, '1', null);
INSERT INTO `district_code` VALUES ('130725', '1307', '尚义县', null, '1', null);
INSERT INTO `district_code` VALUES ('230183', '2301', '尚志市', null, '1', null);
INSERT INTO `district_code` VALUES ('350426', '3504', '尤溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('141002', '1410', '尧都区', null, '1', null);
INSERT INTO `district_code` VALUES ('654028', '6540', '尼勒克县', null, '1', null);
INSERT INTO `district_code` VALUES ('540123', '5401', '尼木县', null, '1', null);
INSERT INTO `district_code` VALUES ('542430', '5424', '尼玛县', null, '1', null);
INSERT INTO `district_code` VALUES ('350923', '3509', '屏南县', null, '1', null);
INSERT INTO `district_code` VALUES ('511529', '5115', '屏山县', null, '1', null);
INSERT INTO `district_code` VALUES ('532523', '5325', '屏边苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('469022', '4690', '屯昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('341002', '3410', '屯溪区', null, '1', null);
INSERT INTO `district_code` VALUES ('140424', '1404', '屯留县', null, '1', null);
INSERT INTO `district_code` VALUES ('620725', '6207', '山丹县', null, '1', null);
INSERT INTO `district_code` VALUES ('370406', '3704', '山亭区', null, '1', null);
INSERT INTO `district_code` VALUES ('410603', '4106', '山城区', null, '1', null);
INSERT INTO `district_code` VALUES ('130303', '1303', '山海关区', null, '1', null);
INSERT INTO `district_code` VALUES ('410811', '4108', '山阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('611024', '6110', '山阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('140621', '1406', '山阴县', null, '1', null);
INSERT INTO `district_code` VALUES ('610323', '6103', '岐山县', null, '1', null);
INSERT INTO `district_code` VALUES ('522626', '5226', '岑巩县', null, '1', null);
INSERT INTO `district_code` VALUES ('450481', '4504', '岑溪市', null, '1', null);
INSERT INTO `district_code` VALUES ('542338', '5423', '岗巴县', null, '1', null);
INSERT INTO `district_code` VALUES ('141127', '1411', '岚县', null, '1', null);
INSERT INTO `district_code` VALUES ('371103', '3711', '岚山区', null, '1', null);
INSERT INTO `district_code` VALUES ('610925', '6109', '岚皋县', null, '1', null);
INSERT INTO `district_code` VALUES ('140929', '1409', '岢岚县', null, '1', null);
INSERT INTO `district_code` VALUES ('210323', '2103', '岫岩满族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('230503', '2305', '岭东区', null, '1', null);
INSERT INTO `district_code` VALUES ('330921', '3309', '岱山县', null, '1', null);
INSERT INTO `district_code` VALUES ('370911', '3709', '岱岳区', null, '1', null);
INSERT INTO `district_code` VALUES ('430304', '4303', '岳塘区', null, '1', null);
INSERT INTO `district_code` VALUES ('653128', '6531', '岳普湖县', null, '1', null);
INSERT INTO `district_code` VALUES ('511621', '5116', '岳池县', null, '1', null);
INSERT INTO `district_code` VALUES ('340828', '3408', '岳西县', null, '1', null);
INSERT INTO `district_code` VALUES ('430621', '4306', '岳阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('430602', '4306', '岳阳楼区', null, '1', null);
INSERT INTO `district_code` VALUES ('430104', '4301', '岳麓区', null, '1', null);
INSERT INTO `district_code` VALUES ('621126', '6211', '岷县', null, '1', null);
INSERT INTO `district_code` VALUES ('370404', '3704', '峄城区', null, '1', null);
INSERT INTO `district_code` VALUES ('360823', '3608', '峡江县', null, '1', null);
INSERT INTO `district_code` VALUES ('530426', '5304', '峨山彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('511181', '5111', '峨眉山市', null, '1', null);
INSERT INTO `district_code` VALUES ('511132', '5111', '峨边彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('130406', '1304', '峰峰矿区', null, '1', null);
INSERT INTO `district_code` VALUES ('370212', '3702', '崂山区', null, '1', null);
INSERT INTO `district_code` VALUES ('620802', '6208', '崆峒区', null, '1', null);
INSERT INTO `district_code` VALUES ('360725', '3607', '崇义县', null, '1', null);
INSERT INTO `district_code` VALUES ('361024', '3610', '崇仁县', null, '1', null);
INSERT INTO `district_code` VALUES ('620823', '6208', '崇信县', null, '1', null);
INSERT INTO `district_code` VALUES ('320202', '3202', '崇安区', null, '1', null);
INSERT INTO `district_code` VALUES ('320602', '3206', '崇川区', null, '1', null);
INSERT INTO `district_code` VALUES ('510184', '5101', '崇州市', null, '1', null);
INSERT INTO `district_code` VALUES ('310230', '31', '崇明县', null, '1', null);
INSERT INTO `district_code` VALUES ('130733', '1307', '崇礼县', null, '1', null);
INSERT INTO `district_code` VALUES ('421223', '4212', '崇阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('330683', '3306', '嵊州市', null, '1', null);
INSERT INTO `district_code` VALUES ('330922', '3309', '嵊泗县', null, '1', null);
INSERT INTO `district_code` VALUES ('410325', '4103', '嵩县', null, '1', null);
INSERT INTO `district_code` VALUES ('530127', '5301', '嵩明县', null, '1', null);
INSERT INTO `district_code` VALUES ('532927', '5329', '巍山彝族回族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('411602', '4116', '川汇区', null, '1', null);
INSERT INTO `district_code` VALUES ('340181', '3401', '巢湖市', null, '1', null);
INSERT INTO `district_code` VALUES ('230403', '2304', '工农区', null, '1', null);
INSERT INTO `district_code` VALUES ('542622', '5426', '工布江达县', null, '1', null);
INSERT INTO `district_code` VALUES ('140226', '1402', '左云县', null, '1', null);
INSERT INTO `district_code` VALUES ('140722', '1407', '左权县', null, '1', null);
INSERT INTO `district_code` VALUES ('542128', '5421', '左贡县', null, '1', null);
INSERT INTO `district_code` VALUES ('530622', '5306', '巧家县', null, '1', null);
INSERT INTO `district_code` VALUES ('371724', '3717', '巨野县', null, '1', null);
INSERT INTO `district_code` VALUES ('130529', '1305', '巨鹿县', null, '1', null);
INSERT INTO `district_code` VALUES ('410181', '4101', '巩义市', null, '1', null);
INSERT INTO `district_code` VALUES ('654024', '6540', '巩留县', null, '1', null);
INSERT INTO `district_code` VALUES ('500237', '50', '巫山县', null, '1', null);
INSERT INTO `district_code` VALUES ('500238', '50', '巫溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('422823', '4228', '巴东县', null, '1', null);
INSERT INTO `district_code` VALUES ('500113', '50', '巴南区', null, '1', null);
INSERT INTO `district_code` VALUES ('513335', '5133', '巴塘县', null, '1', null);
INSERT INTO `district_code` VALUES ('511902', '5119', '巴州区', null, '1', null);
INSERT INTO `district_code` VALUES ('230126', '2301', '巴彦县', null, '1', null);
INSERT INTO `district_code` VALUES ('150423', '1504', '巴林右旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150422', '1504', '巴林左旗', null, '1', null);
INSERT INTO `district_code` VALUES ('653130', '6531', '巴楚县', null, '1', null);
INSERT INTO `district_code` VALUES ('652222', '6522', '巴里坤哈萨克自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('542429', '5424', '巴青县', null, '1', null);
INSERT INTO `district_code` VALUES ('451227', '4512', '巴马瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('370103', '3701', '市中区', null, '1', null);
INSERT INTO `district_code` VALUES ('370203', '3702', '市北区', null, '1', null);
INSERT INTO `district_code` VALUES ('370202', '3702', '市南区', null, '1', null);
INSERT INTO `district_code` VALUES ('654321', '6543', '布尔津县', null, '1', null);
INSERT INTO `district_code` VALUES ('513429', '5134', '布拖县', null, '1', null);
INSERT INTO `district_code` VALUES ('530323', '5303', '师宗县', null, '1', null);
INSERT INTO `district_code` VALUES ('230713', '2307', '带岭区', null, '1', null);
INSERT INTO `district_code` VALUES ('430482', '4304', '常宁市', null, '1', null);
INSERT INTO `district_code` VALUES ('330822', '3308', '常山县', null, '1', null);
INSERT INTO `district_code` VALUES ('320581', '3205', '常熟市', null, '1', null);
INSERT INTO `district_code` VALUES ('450330', '4503', '平乐县', null, '1', null);
INSERT INTO `district_code` VALUES ('130532', '1305', '平乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('610926', '6109', '平利县', null, '1', null);
INSERT INTO `district_code` VALUES ('450821', '4508', '平南县', null, '1', null);
INSERT INTO `district_code` VALUES ('371426', '3714', '平原县', null, '1', null);
INSERT INTO `district_code` VALUES ('350628', '3506', '平和县', null, '1', null);
INSERT INTO `district_code` VALUES ('520421', '5204', '平坝县', null, '1', null);
INSERT INTO `district_code` VALUES ('522727', '5227', '平塘县', null, '1', null);
INSERT INTO `district_code` VALUES ('632121', '6321', '平安县', null, '1', null);
INSERT INTO `district_code` VALUES ('140321', '1403', '平定县', null, '1', null);
INSERT INTO `district_code` VALUES ('210502', '2105', '平山区', null, '1', null);
INSERT INTO `district_code` VALUES ('130131', '1301', '平山县', null, '1', null);
INSERT INTO `district_code` VALUES ('620403', '6204', '平川区', null, '1', null);
INSERT INTO `district_code` VALUES ('370283', '3702', '平度市', null, '1', null);
INSERT INTO `district_code` VALUES ('230108', '2301', '平房区', null, '1', null);
INSERT INTO `district_code` VALUES ('511923', '5119', '平昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('451023', '4510', '平果县', null, '1', null);
INSERT INTO `district_code` VALUES ('411503', '4115', '平桥区', null, '1', null);
INSERT INTO `district_code` VALUES ('510727', '5107', '平武县', null, '1', null);
INSERT INTO `district_code` VALUES ('320503', '3205', '平江区', null, '1', null);
INSERT INTO `district_code` VALUES ('430626', '4306', '平江县', null, '1', null);
INSERT INTO `district_code` VALUES ('130823', '1308', '平泉县', null, '1', null);
INSERT INTO `district_code` VALUES ('330482', '3304', '平湖市', null, '1', null);
INSERT INTO `district_code` VALUES ('350128', '3501', '平潭县', null, '1', null);
INSERT INTO `district_code` VALUES ('640221', '6402', '平罗县', null, '1', null);
INSERT INTO `district_code` VALUES ('411723', '4117', '平舆县', null, '1', null);
INSERT INTO `district_code` VALUES ('110117', '11', '平谷区', null, '1', null);
INSERT INTO `district_code` VALUES ('441426', '4414', '平远县', null, '1', null);
INSERT INTO `district_code` VALUES ('140728', '1407', '平遥县', null, '1', null);
INSERT INTO `district_code` VALUES ('371326', '3713', '平邑县', null, '1', null);
INSERT INTO `district_code` VALUES ('330326', '3303', '平阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('370124', '3701', '平阴县', null, '1', null);
INSERT INTO `district_code` VALUES ('140829', '1408', '平陆县', null, '1', null);
INSERT INTO `district_code` VALUES ('140425', '1404', '平顺县', null, '1', null);
INSERT INTO `district_code` VALUES ('140603', '1406', '平鲁区', null, '1', null);
INSERT INTO `district_code` VALUES ('361122', '3611', '广丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('532627', '5326', '广南县', null, '1', null);
INSERT INTO `district_code` VALUES ('441223', '4412', '广宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('511602', '5116', '广安区', null, '1', null);
INSERT INTO `district_code` VALUES ('130531', '1305', '广宗县', null, '1', null);
INSERT INTO `district_code` VALUES ('130432', '1304', '广平县', null, '1', null);
INSERT INTO `district_code` VALUES ('341822', '3418', '广德县', null, '1', null);
INSERT INTO `district_code` VALUES ('361030', '3610', '广昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('421381', '4213', '广水市', null, '1', null);
INSERT INTO `district_code` VALUES ('510681', '5106', '广汉市', null, '1', null);
INSERT INTO `district_code` VALUES ('622924', '6229', '广河县', null, '1', null);
INSERT INTO `district_code` VALUES ('140223', '1402', '广灵县', null, '1', null);
INSERT INTO `district_code` VALUES ('131003', '1310', '广阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('321002', '3210', '广陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('370523', '3705', '广饶县', null, '1', null);
INSERT INTO `district_code` VALUES ('210283', '2102', '庄河市', null, '1', null);
INSERT INTO `district_code` VALUES ('620825', '6208', '庄浪县', null, '1', null);
INSERT INTO `district_code` VALUES ('371423', '3714', '庆云县', null, '1', null);
INSERT INTO `district_code` VALUES ('331126', '3311', '庆元县', null, '1', null);
INSERT INTO `district_code` VALUES ('621021', '6210', '庆城县', null, '1', null);
INSERT INTO `district_code` VALUES ('231224', '2312', '庆安县', null, '1', null);
INSERT INTO `district_code` VALUES ('360402', '3604', '庐山区', null, '1', null);
INSERT INTO `district_code` VALUES ('340124', '3401', '庐江县', null, '1', null);
INSERT INTO `district_code` VALUES ('340103', '3401', '庐阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('150524', '1505', '库伦旗', null, '1', null);
INSERT INTO `district_code` VALUES ('652801', '6528', '库尔勒市', null, '1', null);
INSERT INTO `district_code` VALUES ('652923', '6529', '库车县', null, '1', null);
INSERT INTO `district_code` VALUES ('140622', '1406', '应县', null, '1', null);
INSERT INTO `district_code` VALUES ('420981', '4209', '应城市', null, '1', null);
INSERT INTO `district_code` VALUES ('610822', '6108', '府谷县', null, '1', null);
INSERT INTO `district_code` VALUES ('622922', '6229', '康乐县', null, '1', null);
INSERT INTO `district_code` VALUES ('130723', '1307', '康保县', null, '1', null);
INSERT INTO `district_code` VALUES ('621224', '6212', '康县', null, '1', null);
INSERT INTO `district_code` VALUES ('513321', '5133', '康定县', null, '1', null);
INSERT INTO `district_code` VALUES ('210123', '2101', '康平县', null, '1', null);
INSERT INTO `district_code` VALUES ('542331', '5423', '康马县', null, '1', null);
INSERT INTO `district_code` VALUES ('440881', '4408', '廉江市', null, '1', null);
INSERT INTO `district_code` VALUES ('222401', '2224', '延吉市', null, '1', null);
INSERT INTO `district_code` VALUES ('230129', '2301', '延寿县', null, '1', null);
INSERT INTO `district_code` VALUES ('610622', '6106', '延川县', null, '1', null);
INSERT INTO `district_code` VALUES ('350702', '3507', '延平区', null, '1', null);
INSERT INTO `district_code` VALUES ('110229', '11', '延庆县', null, '1', null);
INSERT INTO `district_code` VALUES ('410726', '4107', '延津县', null, '1', null);
INSERT INTO `district_code` VALUES ('610621', '6106', '延长县', null, '1', null);
INSERT INTO `district_code` VALUES ('230203', '2302', '建华区', null, '1', null);
INSERT INTO `district_code` VALUES ('422822', '4228', '建始县', null, '1', null);
INSERT INTO `district_code` VALUES ('350430', '3504', '建宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('211322', '2113', '建平县', null, '1', null);
INSERT INTO `district_code` VALUES ('330182', '3301', '建德市', null, '1', null);
INSERT INTO `district_code` VALUES ('211422', '2114', '建昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('532524', '5325', '建水县', null, '1', null);
INSERT INTO `district_code` VALUES ('320925', '3209', '建湖县', null, '1', null);
INSERT INTO `district_code` VALUES ('350783', '3507', '建瓯市', null, '1', null);
INSERT INTO `district_code` VALUES ('320105', '3201', '建邺区', null, '1', null);
INSERT INTO `district_code` VALUES ('350784', '3507', '建阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('330824', '3308', '开化县', null, '1', null);
INSERT INTO `district_code` VALUES ('211282', '2112', '开原市', null, '1', null);
INSERT INTO `district_code` VALUES ('500234', '50', '开县', null, '1', null);
INSERT INTO `district_code` VALUES ('410224', '4102', '开封县', null, '1', null);
INSERT INTO `district_code` VALUES ('130205', '1302', '开平区', null, '1', null);
INSERT INTO `district_code` VALUES ('440783', '4407', '开平市', null, '1', null);
INSERT INTO `district_code` VALUES ('511723', '5117', '开江县', null, '1', null);
INSERT INTO `district_code` VALUES ('430105', '4301', '开福区', null, '1', null);
INSERT INTO `district_code` VALUES ('532502', '5325', '开远市', null, '1', null);
INSERT INTO `district_code` VALUES ('520121', '5201', '开阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('150523', '1505', '开鲁县', null, '1', null);
INSERT INTO `district_code` VALUES ('340203', '3402', '弋江区', null, '1', null);
INSERT INTO `district_code` VALUES ('361126', '3611', '弋阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('211005', '2110', '弓长岭区', null, '1', null);
INSERT INTO `district_code` VALUES ('130722', '1307', '张北县', null, '1', null);
INSERT INTO `district_code` VALUES ('620525', '6205', '张家川回族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('320582', '3205', '张家港市', null, '1', null);
INSERT INTO `district_code` VALUES ('370303', '3703', '张店区', null, '1', null);
INSERT INTO `district_code` VALUES ('420303', '4203', '张湾区', null, '1', null);
INSERT INTO `district_code` VALUES ('532526', '5325', '弥勒县', null, '1', null);
INSERT INTO `district_code` VALUES ('532925', '5329', '弥渡县', null, '1', null);
INSERT INTO `district_code` VALUES ('340521', '3405', '当涂县', null, '1', null);
INSERT INTO `district_code` VALUES ('420582', '4205', '当阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('540122', '5401', '当雄县', null, '1', null);
INSERT INTO `district_code` VALUES ('530628', '5306', '彝良县', null, '1', null);
INSERT INTO `district_code` VALUES ('610427', '6104', '彬县', null, '1', null);
INSERT INTO `district_code` VALUES ('511422', '5114', '彭山县', null, '1', null);
INSERT INTO `district_code` VALUES ('510182', '5101', '彭州市', null, '1', null);
INSERT INTO `district_code` VALUES ('500243', '50', '彭水苗族土家族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('360430', '3604', '彭泽县', null, '1', null);
INSERT INTO `district_code` VALUES ('640425', '6404', '彭阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('210922', '2109', '彰武县', null, '1', null);
INSERT INTO `district_code` VALUES ('130625', '1306', '徐水县', null, '1', null);
INSERT INTO `district_code` VALUES ('310104', '31', '徐汇区', null, '1', null);
INSERT INTO `district_code` VALUES ('440825', '4408', '徐闻县', null, '1', null);
INSERT INTO `district_code` VALUES ('513338', '5133', '得荣县', null, '1', null);
INSERT INTO `district_code` VALUES ('632128', '6321', '循化撒拉族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('370826', '3708', '微山县', null, '1', null);
INSERT INTO `district_code` VALUES ('632802', '6328', '德令哈市', null, '1', null);
INSERT INTO `district_code` VALUES ('451024', '4510', '德保县', null, '1', null);
INSERT INTO `district_code` VALUES ('361181', '3611', '德兴市', null, '1', null);
INSERT INTO `district_code` VALUES ('350526', '3505', '德化县', null, '1', null);
INSERT INTO `district_code` VALUES ('371402', '3714', '德城区', null, '1', null);
INSERT INTO `district_code` VALUES ('360426', '3604', '德安县', null, '1', null);
INSERT INTO `district_code` VALUES ('441226', '4412', '德庆县', null, '1', null);
INSERT INTO `district_code` VALUES ('220183', '2201', '德惠市', null, '1', null);
INSERT INTO `district_code` VALUES ('513424', '5134', '德昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('513330', '5133', '德格县', null, '1', null);
INSERT INTO `district_code` VALUES ('520626', '5206', '德江县', null, '1', null);
INSERT INTO `district_code` VALUES ('330521', '3305', '德清县', null, '1', null);
INSERT INTO `district_code` VALUES ('533422', '5334', '德钦县', null, '1', null);
INSERT INTO `district_code` VALUES ('621227', '6212', '徽县', null, '1', null);
INSERT INTO `district_code` VALUES ('341004', '3410', '徽州区', null, '1', null);
INSERT INTO `district_code` VALUES ('610625', '6106', '志丹县', null, '1', null);
INSERT INTO `district_code` VALUES ('500233', '50', '忠县', null, '1', null);
INSERT INTO `district_code` VALUES ('451321', '4513', '忻城县', null, '1', null);
INSERT INTO `district_code` VALUES ('140902', '1409', '忻府区', null, '1', null);
INSERT INTO `district_code` VALUES ('140624', '1406', '怀仁县', null, '1', null);
INSERT INTO `district_code` VALUES ('340822', '3408', '怀宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('130728', '1307', '怀安县', null, '1', null);
INSERT INTO `district_code` VALUES ('130730', '1307', '怀来县', null, '1', null);
INSERT INTO `district_code` VALUES ('110116', '11', '怀柔区', null, '1', null);
INSERT INTO `district_code` VALUES ('340321', '3403', '怀远县', null, '1', null);
INSERT INTO `district_code` VALUES ('441224', '4412', '怀集县', null, '1', null);
INSERT INTO `district_code` VALUES ('520624', '5206', '思南县', null, '1', null);
INSERT INTO `district_code` VALUES ('350203', '3502', '思明区', null, '1', null);
INSERT INTO `district_code` VALUES ('530802', '5308', '思茅区', null, '1', null);
INSERT INTO `district_code` VALUES ('230303', '2303', '恒山区', null, '1', null);
INSERT INTO `district_code` VALUES ('440785', '4407', '恩平市', null, '1', null);
INSERT INTO `district_code` VALUES ('422801', '4228', '恩施市', null, '1', null);
INSERT INTO `district_code` VALUES ('450332', '4503', '恭城瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('411528', '4115', '息县', null, '1', null);
INSERT INTO `district_code` VALUES ('520122', '5201', '息烽县', null, '1', null);
INSERT INTO `district_code` VALUES ('441323', '4413', '惠东县', null, '1', null);
INSERT INTO `district_code` VALUES ('640205', '6402', '惠农区', null, '1', null);
INSERT INTO `district_code` VALUES ('441302', '4413', '惠城区', null, '1', null);
INSERT INTO `district_code` VALUES ('350521', '3505', '惠安县', null, '1', null);
INSERT INTO `district_code` VALUES ('320206', '3202', '惠山区', null, '1', null);
INSERT INTO `district_code` VALUES ('445224', '4452', '惠来县', null, '1', null);
INSERT INTO `district_code` VALUES ('371621', '3716', '惠民县', null, '1', null);
INSERT INTO `district_code` VALUES ('522731', '5227', '惠水县', null, '1', null);
INSERT INTO `district_code` VALUES ('410108', '4101', '惠济区', null, '1', null);
INSERT INTO `district_code` VALUES ('441303', '4413', '惠阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('430821', '4308', '慈利县', null, '1', null);
INSERT INTO `district_code` VALUES ('330282', '3302', '慈溪市', null, '1', null);
INSERT INTO `district_code` VALUES ('510108', '5101', '成华区', null, '1', null);
INSERT INTO `district_code` VALUES ('621221', '6212', '成县', null, '1', null);
INSERT INTO `district_code` VALUES ('130424', '1304', '成安县', null, '1', null);
INSERT INTO `district_code` VALUES ('371723', '3717', '成武县', null, '1', null);
INSERT INTO `district_code` VALUES ('320405', '3204', '戚墅堰区', null, '1', null);
INSERT INTO `district_code` VALUES ('610125', '6101', '户县', null, '1', null);
INSERT INTO `district_code` VALUES ('420325', '4203', '房县', null, '1', null);
INSERT INTO `district_code` VALUES ('110111', '11', '房山区', null, '1', null);
INSERT INTO `district_code` VALUES ('150783', '1507', '扎兰屯市', null, '1', null);
INSERT INTO `district_code` VALUES ('542222', '5422', '扎囊县', null, '1', null);
INSERT INTO `district_code` VALUES ('152223', '1522', '扎赉特旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150526', '1505', '扎鲁特旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150122', '1501', '托克托县', null, '1', null);
INSERT INTO `district_code` VALUES ('652123', '6521', '托克逊县', null, '1', null);
INSERT INTO `district_code` VALUES ('654224', '6542', '托里县', null, '1', null);
INSERT INTO `district_code` VALUES ('321182', '3211', '扬中市', null, '1', null);
INSERT INTO `district_code` VALUES ('220724', '2207', '扶余县', null, '1', null);
INSERT INTO `district_code` VALUES ('411621', '4116', '扶沟县', null, '1', null);
INSERT INTO `district_code` VALUES ('451421', '4514', '扶绥县', null, '1', null);
INSERT INTO `district_code` VALUES ('610324', '6103', '扶风县', null, '1', null);
INSERT INTO `district_code` VALUES ('130821', '1308', '承德县', null, '1', null);
INSERT INTO `district_code` VALUES ('130323', '1303', '抚宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('220621', '2206', '抚松县', null, '1', null);
INSERT INTO `district_code` VALUES ('230833', '2308', '抚远县', null, '1', null);
INSERT INTO `district_code` VALUES ('210421', '2104', '抚顺县', null, '1', null);
INSERT INTO `district_code` VALUES ('542326', '5423', '拉孜县', null, '1', null);
INSERT INTO `district_code` VALUES ('370685', '3706', '招远市', null, '1', null);
INSERT INTO `district_code` VALUES ('652926', '6529', '拜城县', null, '1', null);
INSERT INTO `district_code` VALUES ('230231', '2302', '拜泉县', null, '1', null);
INSERT INTO `district_code` VALUES ('330105', '3301', '拱墅区', null, '1', null);
INSERT INTO `district_code` VALUES ('210603', '2106', '振兴区', null, '1', null);
INSERT INTO `district_code` VALUES ('210604', '2106', '振安区', null, '1', null);
INSERT INTO `district_code` VALUES ('420804', '4208', '掇刀区', null, '1', null);
INSERT INTO `district_code` VALUES ('542527', '5425', '措勤县', null, '1', null);
INSERT INTO `district_code` VALUES ('542227', '5422', '措美县', null, '1', null);
INSERT INTO `district_code` VALUES ('445221', '4452', '揭东县', null, '1', null);
INSERT INTO `district_code` VALUES ('445222', '4452', '揭西县', null, '1', null);
INSERT INTO `district_code` VALUES ('430223', '4302', '攸县', null, '1', null);
INSERT INTO `district_code` VALUES ('542526', '5425', '改则县', null, '1', null);
INSERT INTO `district_code` VALUES ('350725', '3507', '政和县', null, '1', null);
INSERT INTO `district_code` VALUES ('131126', '1311', '故城县', null, '1', null);
INSERT INTO `district_code` VALUES ('150430', '1504', '敖汉旗', null, '1', null);
INSERT INTO `district_code` VALUES ('222403', '2224', '敦化市', null, '1', null);
INSERT INTO `district_code` VALUES ('620982', '6209', '敦煌市', null, '1', null);
INSERT INTO `district_code` VALUES ('621222', '6212', '文县', null, '1', null);
INSERT INTO `district_code` VALUES ('211003', '2110', '文圣区', null, '1', null);
INSERT INTO `district_code` VALUES ('131026', '1310', '文安县', null, '1', null);
INSERT INTO `district_code` VALUES ('532601', '5326', '文山市', null, '1', null);
INSERT INTO `district_code` VALUES ('410502', '4105', '文峰区', null, '1', null);
INSERT INTO `district_code` VALUES ('330328', '3303', '文成县', null, '1', null);
INSERT INTO `district_code` VALUES ('469005', '4690', '文昌市', null, '1', null);
INSERT INTO `district_code` VALUES ('141121', '1411', '文水县', null, '1', null);
INSERT INTO `district_code` VALUES ('371081', '3710', '文登市', null, '1', null);
INSERT INTO `district_code` VALUES ('440403', '4404', '斗门区', null, '1', null);
INSERT INTO `district_code` VALUES ('440233', '4402', '新丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('130184', '1301', '新乐市', null, '1', null);
INSERT INTO `district_code` VALUES ('410721', '4107', '新乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('440705', '4407', '新会区', null, '1', null);
INSERT INTO `district_code` VALUES ('230902', '2309', '新兴区', null, '1', null);
INSERT INTO `district_code` VALUES ('445321', '4453', '新兴县', null, '1', null);
INSERT INTO `district_code` VALUES ('431322', '4313', '新化县', null, '1', null);
INSERT INTO `district_code` VALUES ('320411', '3204', '新北区', null, '1', null);
INSERT INTO `district_code` VALUES ('130105', '1301', '新华区', null, '1', null);
INSERT INTO `district_code` VALUES ('411523', '4115', '新县', null, '1', null);
INSERT INTO `district_code` VALUES ('652925', '6529', '新和县', null, '1', null);
INSERT INTO `district_code` VALUES ('150102', '1501', '新城区', null, '1', null);
INSERT INTO `district_code` VALUES ('430528', '4305', '新宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('410323', '4103', '新安县', null, '1', null);
INSERT INTO `district_code` VALUES ('210422', '2104', '新宾满族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('410183', '4101', '新密市', null, '1', null);
INSERT INTO `district_code` VALUES ('150727', '1507', '新巴尔虎右旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150726', '1507', '新巴尔虎左旗', null, '1', null);
INSERT INTO `district_code` VALUES ('130602', '1306', '新市区', null, '1', null);
INSERT INTO `district_code` VALUES ('360824', '3608', '新干县', null, '1', null);
INSERT INTO `district_code` VALUES ('530427', '5304', '新平彝族傣族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('360122', '3601', '新建县', null, '1', null);
INSERT INTO `district_code` VALUES ('210402', '2104', '新抚区', null, '1', null);
INSERT INTO `district_code` VALUES ('330624', '3306', '新昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('431227', '4312', '新晃侗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('210181', '2101', '新民市', null, '1', null);
INSERT INTO `district_code` VALUES ('320381', '3203', '新沂市', null, '1', null);
INSERT INTO `district_code` VALUES ('130530', '1305', '新河县', null, '1', null);
INSERT INTO `district_code` VALUES ('370982', '3709', '新泰市', null, '1', null);
INSERT INTO `district_code` VALUES ('510132', '5101', '新津县', null, '1', null);
INSERT INTO `district_code` VALUES ('420117', '4201', '新洲区', null, '1', null);
INSERT INTO `district_code` VALUES ('320705', '3207', '新浦区', null, '1', null);
INSERT INTO `district_code` VALUES ('654025', '6540', '新源县', null, '1', null);
INSERT INTO `district_code` VALUES ('431128', '4311', '新田县', null, '1', null);
INSERT INTO `district_code` VALUES ('140825', '1408', '新绛县', null, '1', null);
INSERT INTO `district_code` VALUES ('350802', '3508', '新罗区', null, '1', null);
INSERT INTO `district_code` VALUES ('140212', '1402', '新荣区', null, '1', null);
INSERT INTO `district_code` VALUES ('411729', '4117', '新蔡县', null, '1', null);
INSERT INTO `district_code` VALUES ('210903', '2109', '新邱区', null, '1', null);
INSERT INTO `district_code` VALUES ('430522', '4305', '新邵县', null, '1', null);
INSERT INTO `district_code` VALUES ('410184', '4101', '新郑市', null, '1', null);
INSERT INTO `district_code` VALUES ('510114', '5101', '新都区', null, '1', null);
INSERT INTO `district_code` VALUES ('411329', '4113', '新野县', null, '1', null);
INSERT INTO `district_code` VALUES ('230707', '2307', '新青区', null, '1', null);
INSERT INTO `district_code` VALUES ('513329', '5133', '新龙县', null, '1', null);
INSERT INTO `district_code` VALUES ('411322', '4113', '方城县', null, '1', null);
INSERT INTO `district_code` VALUES ('141128', '1411', '方山县', null, '1', null);
INSERT INTO `district_code` VALUES ('230124', '2301', '方正县', null, '1', null);
INSERT INTO `district_code` VALUES ('530521', '5305', '施甸县', null, '1', null);
INSERT INTO `district_code` VALUES ('522623', '5226', '施秉县', null, '1', null);
INSERT INTO `district_code` VALUES ('210212', '2102', '旅顺口区', null, '1', null);
INSERT INTO `district_code` VALUES ('341825', '3418', '旌德县', null, '1', null);
INSERT INTO `district_code` VALUES ('510603', '5106', '旌阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('340225', '3402', '无为县', null, '1', null);
INSERT INTO `district_code` VALUES ('130130', '1301', '无极县', null, '1', null);
INSERT INTO `district_code` VALUES ('371623', '3716', '无棣县', null, '1', null);
INSERT INTO `district_code` VALUES ('542301', '5423', '日喀则市', null, '1', null);
INSERT INTO `district_code` VALUES ('542524', '5425', '日土县', null, '1', null);
INSERT INTO `district_code` VALUES ('610429', '6104', '旬邑县', null, '1', null);
INSERT INTO `district_code` VALUES ('610928', '6109', '旬阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('510821', '5108', '旺苍县', null, '1', null);
INSERT INTO `district_code` VALUES ('542327', '5423', '昂仁县', null, '1', null);
INSERT INTO `district_code` VALUES ('230205', '2302', '昂昂溪区', null, '1', null);
INSERT INTO `district_code` VALUES ('320583', '3205', '昆山市', null, '1', null);
INSERT INTO `district_code` VALUES ('150203', '1502', '昆都仑区', null, '1', null);
INSERT INTO `district_code` VALUES ('370725', '3707', '昌乐县', null, '1', null);
INSERT INTO `district_code` VALUES ('652301', '6523', '昌吉市', null, '1', null);
INSERT INTO `district_code` VALUES ('211224', '2112', '昌图县', null, '1', null);
INSERT INTO `district_code` VALUES ('530524', '5305', '昌宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('110114', '11', '昌平区', null, '1', null);
INSERT INTO `district_code` VALUES ('360202', '3602', '昌江区', null, '1', null);
INSERT INTO `district_code` VALUES ('469026', '4690', '昌江黎族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('220202', '2202', '昌邑区', null, '1', null);
INSERT INTO `district_code` VALUES ('370786', '3707', '昌邑市', null, '1', null);
INSERT INTO `district_code` VALUES ('542121', '5421', '昌都县', null, '1', null);
INSERT INTO `district_code` VALUES ('130322', '1303', '昌黎县', null, '1', null);
INSERT INTO `district_code` VALUES ('341182', '3411', '明光市', null, '1', null);
INSERT INTO `district_code` VALUES ('210504', '2105', '明山区', null, '1', null);
INSERT INTO `district_code` VALUES ('231225', '2312', '明水县', null, '1', null);
INSERT INTO `district_code` VALUES ('350421', '3504', '明溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('130633', '1306', '易县', null, '1', null);
INSERT INTO `district_code` VALUES ('530425', '5304', '易门县', null, '1', null);
INSERT INTO `district_code` VALUES ('140724', '1407', '昔阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('360427', '3604', '星子县', null, '1', null);
INSERT INTO `district_code` VALUES ('451121', '4511', '昭平县', null, '1', null);
INSERT INTO `district_code` VALUES ('654026', '6540', '昭苏县', null, '1', null);
INSERT INTO `district_code` VALUES ('513431', '5134', '昭觉县', null, '1', null);
INSERT INTO `district_code` VALUES ('530602', '5306', '昭阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('530122', '5301', '晋宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('350111', '3501', '晋安区', null, '1', null);
INSERT INTO `district_code` VALUES ('130183', '1301', '晋州市', null, '1', null);
INSERT INTO `district_code` VALUES ('350582', '3505', '晋江市', null, '1', null);
INSERT INTO `district_code` VALUES ('140110', '1401', '晋源区', null, '1', null);
INSERT INTO `district_code` VALUES ('542521', '5425', '普兰县', null, '1', null);
INSERT INTO `district_code` VALUES ('210282', '2102', '普兰店市', null, '1', null);
INSERT INTO `district_code` VALUES ('445281', '4452', '普宁市', null, '1', null);
INSERT INTO `district_code` VALUES ('522323', '5223', '普安县', null, '1', null);
INSERT INTO `district_code` VALUES ('520422', '5204', '普定县', null, '1', null);
INSERT INTO `district_code` VALUES ('513428', '5134', '普格县', null, '1', null);
INSERT INTO `district_code` VALUES ('310107', '31', '普陀区', null, '1', null);
INSERT INTO `district_code` VALUES ('530823', '5308', '景东彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('131127', '1311', '景县', null, '1', null);
INSERT INTO `district_code` VALUES ('331127', '3311', '景宁畲族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('620423', '6204', '景泰县', null, '1', null);
INSERT INTO `district_code` VALUES ('532801', '5328', '景洪市', null, '1', null);
INSERT INTO `district_code` VALUES ('530824', '5308', '景谷傣族彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('522324', '5223', '晴隆县', null, '1', null);
INSERT INTO `district_code` VALUES ('130435', '1304', '曲周县', null, '1', null);
INSERT INTO `district_code` VALUES ('542226', '5422', '曲松县', null, '1', null);
INSERT INTO `district_code` VALUES ('540124', '5401', '曲水县', null, '1', null);
INSERT INTO `district_code` VALUES ('440205', '4402', '曲江区', null, '1', null);
INSERT INTO `district_code` VALUES ('141021', '1410', '曲沃县', null, '1', null);
INSERT INTO `district_code` VALUES ('370881', '3708', '曲阜市', null, '1', null);
INSERT INTO `district_code` VALUES ('130634', '1306', '曲阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('632726', '6327', '曲麻莱县', null, '1', null);
INSERT INTO `district_code` VALUES ('371721', '3717', '曹县', null, '1', null);
INSERT INTO `district_code` VALUES ('421303', '4213', '曾都区', null, '1', null);
INSERT INTO `district_code` VALUES ('360602', '3606', '月湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('140602', '1406', '朔城区', null, '1', null);
INSERT INTO `district_code` VALUES ('542627', '5426', '朗县', null, '1', null);
INSERT INTO `district_code` VALUES ('430112', '4301', '望城区', null, '1', null);
INSERT INTO `district_code` VALUES ('231221', '2312', '望奎县', null, '1', null);
INSERT INTO `district_code` VALUES ('340827', '3408', '望江县', null, '1', null);
INSERT INTO `district_code` VALUES ('210404', '2104', '望花区', null, '1', null);
INSERT INTO `district_code` VALUES ('522326', '5223', '望谟县', null, '1', null);
INSERT INTO `district_code` VALUES ('130631', '1306', '望都县', null, '1', null);
INSERT INTO `district_code` VALUES ('510812', '5108', '朝天区', null, '1', null);
INSERT INTO `district_code` VALUES ('110105', '11', '朝阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('211321', '2113', '朝阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('230127', '2301', '木兰县', null, '1', null);
INSERT INTO `district_code` VALUES ('652328', '6523', '木垒哈萨克自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('513422', '5134', '木里藏族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('610112', '6101', '未央区', null, '1', null);
INSERT INTO `district_code` VALUES ('210521', '2105', '本溪满族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('542522', '5425', '札达县', null, '1', null);
INSERT INTO `district_code` VALUES ('632722', '6327', '杂多县', null, '1', null);
INSERT INTO `district_code` VALUES ('370213', '3702', '李沧区', null, '1', null);
INSERT INTO `district_code` VALUES ('140107', '1401', '杏花岭区', null, '1', null);
INSERT INTO `district_code` VALUES ('230624', '2306', '杜尔伯特蒙古族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('340602', '3406', '杜集区', null, '1', null);
INSERT INTO `district_code` VALUES ('410221', '4102', '杞县', null, '1', null);
INSERT INTO `district_code` VALUES ('422827', '4228', '来凤县', null, '1', null);
INSERT INTO `district_code` VALUES ('341122', '3411', '来安县', null, '1', null);
INSERT INTO `district_code` VALUES ('310110', '31', '杨浦区', null, '1', null);
INSERT INTO `district_code` VALUES ('610403', '6104', '杨陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('150826', '1508', '杭锦后旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150625', '1506', '杭锦旗', null, '1', null);
INSERT INTO `district_code` VALUES ('230109', '2301', '松北区', null, '1', null);
INSERT INTO `district_code` VALUES ('150404', '1504', '松山区', null, '1', null);
INSERT INTO `district_code` VALUES ('520628', '5206', '松桃苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('310117', '31', '松江区', null, '1', null);
INSERT INTO `district_code` VALUES ('350724', '3507', '松溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('421087', '4210', '松滋市', null, '1', null);
INSERT INTO `district_code` VALUES ('513224', '5132', '松潘县', null, '1', null);
INSERT INTO `district_code` VALUES ('331124', '3311', '松阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('231025', '2310', '林口县', null, '1', null);
INSERT INTO `district_code` VALUES ('540121', '5401', '林周县', null, '1', null);
INSERT INTO `district_code` VALUES ('410581', '4105', '林州市', null, '1', null);
INSERT INTO `district_code` VALUES ('230623', '2306', '林甸县', null, '1', null);
INSERT INTO `district_code` VALUES ('542621', '5426', '林芝县', null, '1', null);
INSERT INTO `district_code` VALUES ('150424', '1504', '林西县', null, '1', null);
INSERT INTO `district_code` VALUES ('420583', '4205', '枝江市', null, '1', null);
INSERT INTO `district_code` VALUES ('340823', '3408', '枞阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('131121', '1311', '枣强县', null, '1', null);
INSERT INTO `district_code` VALUES ('420683', '4206', '枣阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('130524', '1305', '柏乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('411424', '4114', '柘城县', null, '1', null);
INSERT INTO `district_code` VALUES ('350926', '3509', '柘荣县', null, '1', null);
INSERT INTO `district_code` VALUES ('611026', '6110', '柞水县', null, '1', null);
INSERT INTO `district_code` VALUES ('652929', '6529', '柯坪县', null, '1', null);
INSERT INTO `district_code` VALUES ('330802', '3308', '柯城区', null, '1', null);
INSERT INTO `district_code` VALUES ('450205', '4502', '柳北区', null, '1', null);
INSERT INTO `district_code` VALUES ('450204', '4502', '柳南区', null, '1', null);
INSERT INTO `district_code` VALUES ('450222', '4502', '柳城县', null, '1', null);
INSERT INTO `district_code` VALUES ('141125', '1411', '柳林县', null, '1', null);
INSERT INTO `district_code` VALUES ('450221', '4502', '柳江县', null, '1', null);
INSERT INTO `district_code` VALUES ('220524', '2205', '柳河县', null, '1', null);
INSERT INTO `district_code` VALUES ('320113', '3201', '栖霞区', null, '1', null);
INSERT INTO `district_code` VALUES ('370686', '3706', '栖霞市', null, '1', null);
INSERT INTO `district_code` VALUES ('430221', '4302', '株洲县', null, '1', null);
INSERT INTO `district_code` VALUES ('150785', '1507', '根河市', null, '1', null);
INSERT INTO `district_code` VALUES ('632801', '6328', '格尔木市', null, '1', null);
INSERT INTO `district_code` VALUES ('130124', '1301', '栾城县', null, '1', null);
INSERT INTO `district_code` VALUES ('410324', '4103', '栾川县', null, '1', null);
INSERT INTO `district_code` VALUES ('431027', '4310', '桂东县', null, '1', null);
INSERT INTO `district_code` VALUES ('450881', '4508', '桂平市', null, '1', null);
INSERT INTO `district_code` VALUES ('431021', '4310', '桂阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('131102', '1311', '桃城区', null, '1', null);
INSERT INTO `district_code` VALUES ('230903', '2309', '桃山区', null, '1', null);
INSERT INTO `district_code` VALUES ('430922', '4309', '桃江县', null, '1', null);
INSERT INTO `district_code` VALUES ('430725', '4307', '桃源县', null, '1', null);
INSERT INTO `district_code` VALUES ('330483', '3304', '桐乡市', null, '1', null);
INSERT INTO `district_code` VALUES ('340881', '3408', '桐城市', null, '1', null);
INSERT INTO `district_code` VALUES ('330122', '3301', '桐庐县', null, '1', null);
INSERT INTO `district_code` VALUES ('411330', '4113', '桐柏县', null, '1', null);
INSERT INTO `district_code` VALUES ('520322', '5203', '桐梓县', null, '1', null);
INSERT INTO `district_code` VALUES ('542224', '5422', '桑日县', null, '1', null);
INSERT INTO `district_code` VALUES ('430822', '4308', '桑植县', null, '1', null);
INSERT INTO `district_code` VALUES ('210522', '2105', '桓仁满族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('370321', '3703', '桓台县', null, '1', null);
INSERT INTO `district_code` VALUES ('130103', '1301', '桥东区', null, '1', null);
INSERT INTO `district_code` VALUES ('130104', '1301', '桥西区', null, '1', null);
INSERT INTO `district_code` VALUES ('230822', '2308', '桦南县', null, '1', null);
INSERT INTO `district_code` VALUES ('230826', '2308', '桦川县', null, '1', null);
INSERT INTO `district_code` VALUES ('220282', '2202', '桦甸市', null, '1', null);
INSERT INTO `district_code` VALUES ('411402', '4114', '梁园区', null, '1', null);
INSERT INTO `district_code` VALUES ('420702', '4207', '梁子湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('370832', '3708', '梁山县', null, '1', null);
INSERT INTO `district_code` VALUES ('500228', '50', '梁平县', null, '1', null);
INSERT INTO `district_code` VALUES ('533122', '5331', '梁河县', null, '1', null);
INSERT INTO `district_code` VALUES ('350402', '3504', '梅列区', null, '1', null);
INSERT INTO `district_code` VALUES ('441421', '4414', '梅县', null, '1', null);
INSERT INTO `district_code` VALUES ('441402', '4414', '梅江区', null, '1', null);
INSERT INTO `district_code` VALUES ('220581', '2205', '梅河口市', null, '1', null);
INSERT INTO `district_code` VALUES ('230208', '2302', '梅里斯达斡尔族区', null, '1', null);
INSERT INTO `district_code` VALUES ('510725', '5107', '梓潼县', null, '1', null);
INSERT INTO `district_code` VALUES ('230305', '2303', '梨树区', null, '1', null);
INSERT INTO `district_code` VALUES ('220322', '2203', '梨树县', null, '1', null);
INSERT INTO `district_code` VALUES ('331002', '3310', '椒江区', null, '1', null);
INSERT INTO `district_code` VALUES ('320803', '3208', '楚州区', null, '1', null);
INSERT INTO `district_code` VALUES ('532301', '5323', '楚雄市', null, '1', null);
INSERT INTO `district_code` VALUES ('620123', '6201', '榆中县', null, '1', null);
INSERT INTO `district_code` VALUES ('220182', '2201', '榆树市', null, '1', null);
INSERT INTO `district_code` VALUES ('140702', '1407', '榆次区', null, '1', null);
INSERT INTO `district_code` VALUES ('140721', '1407', '榆社县', null, '1', null);
INSERT INTO `district_code` VALUES ('610802', '6108', '榆阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('445202', '4452', '榕城区', null, '1', null);
INSERT INTO `district_code` VALUES ('522632', '5226', '榕江县', null, '1', null);
INSERT INTO `district_code` VALUES ('370104', '3701', '槐荫区', null, '1', null);
INSERT INTO `district_code` VALUES ('420606', '4206', '樊城区', null, '1', null);
INSERT INTO `district_code` VALUES ('360982', '3609', '樟树市', null, '1', null);
INSERT INTO `district_code` VALUES ('450127', '4501', '横县', null, '1', null);
INSERT INTO `district_code` VALUES ('610823', '6108', '横山县', null, '1', null);
INSERT INTO `district_code` VALUES ('361125', '3611', '横峰县', null, '1', null);
INSERT INTO `district_code` VALUES ('341021', '3410', '歙县', null, '1', null);
INSERT INTO `district_code` VALUES ('621025', '6210', '正宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('520324', '5203', '正安县', null, '1', null);
INSERT INTO `district_code` VALUES ('130123', '1301', '正定县', null, '1', null);
INSERT INTO `district_code` VALUES ('152530', '1525', '正蓝旗', null, '1', null);
INSERT INTO `district_code` VALUES ('152529', '1525', '正镶白旗', null, '1', null);
INSERT INTO `district_code` VALUES ('411724', '4117', '正阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('330723', '3307', '武义县', null, '1', null);
INSERT INTO `district_code` VALUES ('140429', '1404', '武乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('510107', '5101', '武侯区', null, '1', null);
INSERT INTO `district_code` VALUES ('430581', '4305', '武冈市', null, '1', null);
INSERT INTO `district_code` VALUES ('610431', '6104', '武功县', null, '1', null);
INSERT INTO `district_code` VALUES ('371428', '3714', '武城县', null, '1', null);
INSERT INTO `district_code` VALUES ('350782', '3507', '武夷山市', null, '1', null);
INSERT INTO `district_code` VALUES ('360423', '3604', '武宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('130481', '1304', '武安市', null, '1', null);
INSERT INTO `district_code` VALUES ('532329', '5323', '武定县', null, '1', null);
INSERT INTO `district_code` VALUES ('451323', '4513', '武宣县', null, '1', null);
INSERT INTO `district_code` VALUES ('620524', '6205', '武山县', null, '1', null);
INSERT INTO `district_code` VALUES ('150125', '1501', '武川县', null, '1', null);
INSERT INTO `district_code` VALUES ('350824', '3508', '武平县', null, '1', null);
INSERT INTO `district_code` VALUES ('131123', '1311', '武强县', null, '1', null);
INSERT INTO `district_code` VALUES ('420106', '4201', '武昌区', null, '1', null);
INSERT INTO `district_code` VALUES ('440203', '4402', '武江区', null, '1', null);
INSERT INTO `district_code` VALUES ('120114', '12', '武清区', null, '1', null);
INSERT INTO `district_code` VALUES ('421182', '4211', '武穴市', null, '1', null);
INSERT INTO `district_code` VALUES ('511622', '5116', '武胜县', null, '1', null);
INSERT INTO `district_code` VALUES ('320412', '3204', '武进区', null, '1', null);
INSERT INTO `district_code` VALUES ('131122', '1311', '武邑县', null, '1', null);
INSERT INTO `district_code` VALUES ('621202', '6212', '武都区', null, '1', null);
INSERT INTO `district_code` VALUES ('410823', '4108', '武陟县', null, '1', null);
INSERT INTO `district_code` VALUES ('430702', '4307', '武陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('430811', '4308', '武陵源区', null, '1', null);
INSERT INTO `district_code` VALUES ('500232', '50', '武隆县', null, '1', null);
INSERT INTO `district_code` VALUES ('450122', '4501', '武鸣县', null, '1', null);
INSERT INTO `district_code` VALUES ('410505', '4105', '殷都区', null, '1', null);
INSERT INTO `district_code` VALUES ('542423', '5424', '比如县', null, '1', null);
INSERT INTO `district_code` VALUES ('653227', '6532', '民丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('620722', '6207', '民乐县', null, '1', null);
INSERT INTO `district_code` VALUES ('620621', '6206', '民勤县', null, '1', null);
INSERT INTO `district_code` VALUES ('632122', '6321', '民和回族土族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('411421', '4114', '民权县', null, '1', null);
INSERT INTO `district_code` VALUES ('520221', '5202', '水城县', null, '1', null);
INSERT INTO `district_code` VALUES ('530630', '5306', '水富县', null, '1', null);
INSERT INTO `district_code` VALUES ('650105', '6501', '水磨沟区', null, '1', null);
INSERT INTO `district_code` VALUES ('360825', '3608', '永丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('532327', '5323', '永仁县', null, '1', null);
INSERT INTO `district_code` VALUES ('360425', '3604', '永修县', null, '1', null);
INSERT INTO `district_code` VALUES ('431023', '4310', '永兴县', null, '1', null);
INSERT INTO `district_code` VALUES ('220221', '2202', '永吉县', null, '1', null);
INSERT INTO `district_code` VALUES ('141032', '1410', '永和县', null, '1', null);
INSERT INTO `district_code` VALUES ('530625', '5306', '永善县', null, '1', null);
INSERT INTO `district_code` VALUES ('330324', '3303', '永嘉县', null, '1', null);
INSERT INTO `district_code` VALUES ('411481', '4114', '永城市', null, '1', null);
INSERT INTO `district_code` VALUES ('640121', '6401', '永宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('350481', '3504', '永安市', null, '1', null);
INSERT INTO `district_code` VALUES ('430802', '4308', '永定区', null, '1', null);
INSERT INTO `district_code` VALUES ('350822', '3508', '永定县', null, '1', null);
INSERT INTO `district_code` VALUES ('610426', '6104', '永寿县', null, '1', null);
INSERT INTO `district_code` VALUES ('500118', '50', '永川区', null, '1', null);
INSERT INTO `district_code` VALUES ('532928', '5329', '永平县', null, '1', null);
INSERT INTO `district_code` VALUES ('130429', '1304', '永年县', null, '1', null);
INSERT INTO `district_code` VALUES ('330784', '3307', '永康市', null, '1', null);
INSERT INTO `district_code` VALUES ('530923', '5309', '永德县', null, '1', null);
INSERT INTO `district_code` VALUES ('360830', '3608', '永新县', null, '1', null);
INSERT INTO `district_code` VALUES ('620321', '6203', '永昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('350525', '3505', '永春县', null, '1', null);
INSERT INTO `district_code` VALUES ('350125', '3501', '永泰县', null, '1', null);
INSERT INTO `district_code` VALUES ('140881', '1408', '永济市', null, '1', null);
INSERT INTO `district_code` VALUES ('131023', '1310', '永清县', null, '1', null);
INSERT INTO `district_code` VALUES ('620121', '6201', '永登县', null, '1', null);
INSERT INTO `district_code` VALUES ('450326', '4503', '永福县', null, '1', null);
INSERT INTO `district_code` VALUES ('530722', '5307', '永胜县', null, '1', null);
INSERT INTO `district_code` VALUES ('622923', '6229', '永靖县', null, '1', null);
INSERT INTO `district_code` VALUES ('433127', '4331', '永顺县', null, '1', null);
INSERT INTO `district_code` VALUES ('520303', '5203', '汇川区', null, '1', null);
INSERT INTO `district_code` VALUES ('420113', '4201', '汉南区', null, '1', null);
INSERT INTO `district_code` VALUES ('610702', '6107', '汉台区', null, '1', null);
INSERT INTO `district_code` VALUES ('430722', '4307', '汉寿县', null, '1', null);
INSERT INTO `district_code` VALUES ('420984', '4209', '汉川市', null, '1', null);
INSERT INTO `district_code` VALUES ('511823', '5118', '汉源县', null, '1', null);
INSERT INTO `district_code` VALUES ('610902', '6109', '汉滨区', null, '1', null);
INSERT INTO `district_code` VALUES ('420105', '4201', '汉阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('610921', '6109', '汉阴县', null, '1', null);
INSERT INTO `district_code` VALUES ('411727', '4117', '汝南县', null, '1', null);
INSERT INTO `district_code` VALUES ('431026', '4310', '汝城县', null, '1', null);
INSERT INTO `district_code` VALUES ('410482', '4104', '汝州市', null, '1', null);
INSERT INTO `district_code` VALUES ('410326', '4103', '汝阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('330204', '3302', '江东区', null, '1', null);
INSERT INTO `district_code` VALUES ('330205', '3302', '江北区', null, '1', null);
INSERT INTO `district_code` VALUES ('431129', '4311', '江华瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('450105', '4501', '江南区', null, '1', null);
INSERT INTO `district_code` VALUES ('520621', '5206', '江口县', null, '1', null);
INSERT INTO `district_code` VALUES ('441702', '4417', '江城区', null, '1', null);
INSERT INTO `district_code` VALUES ('530826', '5308', '江城哈尼族彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('420115', '4201', '江夏区', null, '1', null);
INSERT INTO `district_code` VALUES ('542323', '5423', '江孜县', null, '1', null);
INSERT INTO `district_code` VALUES ('320115', '3201', '江宁区', null, '1', null);
INSERT INTO `district_code` VALUES ('511523', '5115', '江安县', null, '1', null);
INSERT INTO `district_code` VALUES ('330881', '3308', '江山市', null, '1', null);
INSERT INTO `district_code` VALUES ('420102', '4201', '江岸区', null, '1', null);
INSERT INTO `district_code` VALUES ('530421', '5304', '江川县', null, '1', null);
INSERT INTO `district_code` VALUES ('330104', '3301', '江干区', null, '1', null);
INSERT INTO `district_code` VALUES ('431125', '4311', '江永县', null, '1', null);
INSERT INTO `district_code` VALUES ('420103', '4201', '江汉区', null, '1', null);
INSERT INTO `district_code` VALUES ('510781', '5107', '江油市', null, '1', null);
INSERT INTO `district_code` VALUES ('500116', '50', '江津区', null, '1', null);
INSERT INTO `district_code` VALUES ('451402', '4514', '江洲区', null, '1', null);
INSERT INTO `district_code` VALUES ('440704', '4407', '江海区', null, '1', null);
INSERT INTO `district_code` VALUES ('220605', '2206', '江源区', null, '1', null);
INSERT INTO `district_code` VALUES ('542122', '5421', '江达县', null, '1', null);
INSERT INTO `district_code` VALUES ('321012', '3210', '江都区', null, '1', null);
INSERT INTO `district_code` VALUES ('510502', '5105', '江阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('320281', '3202', '江阴市', null, '1', null);
INSERT INTO `district_code` VALUES ('421024', '4210', '江陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('230828', '2308', '汤原县', null, '1', null);
INSERT INTO `district_code` VALUES ('230712', '2307', '汤旺河区', null, '1', null);
INSERT INTO `district_code` VALUES ('410523', '4105', '汤阴县', null, '1', null);
INSERT INTO `district_code` VALUES ('430681', '4306', '汨罗市', null, '1', null);
INSERT INTO `district_code` VALUES ('222424', '2224', '汪清县', null, '1', null);
INSERT INTO `district_code` VALUES ('370830', '3708', '汶上县', null, '1', null);
INSERT INTO `district_code` VALUES ('513221', '5132', '汶川县', null, '1', null);
INSERT INTO `district_code` VALUES ('141034', '1410', '汾西县', null, '1', null);
INSERT INTO `district_code` VALUES ('141182', '1411', '汾阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('140430', '1404', '沁县', null, '1', null);
INSERT INTO `district_code` VALUES ('140521', '1405', '沁水县', null, '1', null);
INSERT INTO `district_code` VALUES ('140431', '1404', '沁源县', null, '1', null);
INSERT INTO `district_code` VALUES ('410882', '4108', '沁阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('371321', '3713', '沂南县', null, '1', null);
INSERT INTO `district_code` VALUES ('371323', '3713', '沂水县', null, '1', null);
INSERT INTO `district_code` VALUES ('370323', '3703', '沂源县', null, '1', null);
INSERT INTO `district_code` VALUES ('430981', '4309', '沅江市', null, '1', null);
INSERT INTO `district_code` VALUES ('431222', '4312', '沅陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('411624', '4116', '沈丘县', null, '1', null);
INSERT INTO `district_code` VALUES ('210113', '2101', '沈北新区', null, '1', null);
INSERT INTO `district_code` VALUES ('210103', '2101', '沈河区', null, '1', null);
INSERT INTO `district_code` VALUES ('511129', '5111', '沐川县', null, '1', null);
INSERT INTO `district_code` VALUES ('650103', '6501', '沙依巴克区', null, '1', null);
INSERT INTO `district_code` VALUES ('350427', '3504', '沙县', null, '1', null);
INSERT INTO `district_code` VALUES ('640502', '6405', '沙坡头区', null, '1', null);
INSERT INTO `district_code` VALUES ('500106', '50', '沙坪坝区', null, '1', null);
INSERT INTO `district_code` VALUES ('421002', '4210', '沙市区', null, '1', null);
INSERT INTO `district_code` VALUES ('210204', '2102', '沙河口区', null, '1', null);
INSERT INTO `district_code` VALUES ('130582', '1305', '沙河市', null, '1', null);
INSERT INTO `district_code` VALUES ('420822', '4208', '沙洋县', null, '1', null);
INSERT INTO `district_code` VALUES ('511111', '5111', '沙湾区', null, '1', null);
INSERT INTO `district_code` VALUES ('654223', '6542', '沙湾县', null, '1', null);
INSERT INTO `district_code` VALUES ('652924', '6529', '沙雅县', null, '1', null);
INSERT INTO `district_code` VALUES ('320322', '3203', '沛县', null, '1', null);
INSERT INTO `district_code` VALUES ('130921', '1309', '沧县', null, '1', null);
INSERT INTO `district_code` VALUES ('320502', '3205', '沧浪区', null, '1', null);
INSERT INTO `district_code` VALUES ('530927', '5309', '沧源佤族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('321322', '3213', '沭阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('120102', '12', '河东区', null, '1', null);
INSERT INTO `district_code` VALUES ('120105', '12', '河北区', null, '1', null);
INSERT INTO `district_code` VALUES ('632324', '6323', '河南蒙古族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('370503', '3705', '河口区', null, '1', null);
INSERT INTO `district_code` VALUES ('532532', '5325', '河口瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('140930', '1409', '河曲县', null, '1', null);
INSERT INTO `district_code` VALUES ('140882', '1408', '河津市', null, '1', null);
INSERT INTO `district_code` VALUES ('120103', '12', '河西区', null, '1', null);
INSERT INTO `district_code` VALUES ('130984', '1309', '河间市', null, '1', null);
INSERT INTO `district_code` VALUES ('632724', '6327', '治多县', null, '1', null);
INSERT INTO `district_code` VALUES ('130724', '1307', '沽源县', null, '1', null);
INSERT INTO `district_code` VALUES ('371624', '3716', '沾化县', null, '1', null);
INSERT INTO `district_code` VALUES ('530328', '5303', '沾益县', null, '1', null);
INSERT INTO `district_code` VALUES ('520627', '5206', '沿河土家族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('510311', '5103', '沿滩区', null, '1', null);
INSERT INTO `district_code` VALUES ('320311', '3203', '泉山区', null, '1', null);
INSERT INTO `district_code` VALUES ('350505', '3505', '泉港区', null, '1', null);
INSERT INTO `district_code` VALUES ('130981', '1309', '泊头市', null, '1', null);
INSERT INTO `district_code` VALUES ('411726', '4117', '泌阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('210124', '2101', '法库县', null, '1', null);
INSERT INTO `district_code` VALUES ('341324', '3413', '泗县', null, '1', null);
INSERT INTO `district_code` VALUES ('370831', '3708', '泗水县', null, '1', null);
INSERT INTO `district_code` VALUES ('321324', '3213', '泗洪县', null, '1', null);
INSERT INTO `district_code` VALUES ('321323', '3213', '泗阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('542625', '5426', '波密县', null, '1', null);
INSERT INTO `district_code` VALUES ('321283', '3212', '泰兴市', null, '1', null);
INSERT INTO `district_code` VALUES ('360826', '3608', '泰和县', null, '1', null);
INSERT INTO `district_code` VALUES ('350429', '3504', '泰宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('370902', '3709', '泰山区', null, '1', null);
INSERT INTO `district_code` VALUES ('230224', '2302', '泰来县', null, '1', null);
INSERT INTO `district_code` VALUES ('330329', '3303', '泰顺县', null, '1', null);
INSERT INTO `district_code` VALUES ('510521', '5105', '泸县', null, '1', null);
INSERT INTO `district_code` VALUES ('513322', '5133', '泸定县', null, '1', null);
INSERT INTO `district_code` VALUES ('533321', '5333', '泸水县', null, '1', null);
INSERT INTO `district_code` VALUES ('433122', '4331', '泸溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('532527', '5325', '泸西县', null, '1', null);
INSERT INTO `district_code` VALUES ('140525', '1405', '泽州县', null, '1', null);
INSERT INTO `district_code` VALUES ('632323', '6323', '泽库县', null, '1', null);
INSERT INTO `district_code` VALUES ('653124', '6531', '泽普县', null, '1', null);
INSERT INTO `district_code` VALUES ('341823', '3418', '泾县', null, '1', null);
INSERT INTO `district_code` VALUES ('620821', '6208', '泾川县', null, '1', null);
INSERT INTO `district_code` VALUES ('640424', '6404', '泾源县', null, '1', null);
INSERT INTO `district_code` VALUES ('610423', '6104', '泾阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('610723', '6107', '洋县', null, '1', null);
INSERT INTO `district_code` VALUES ('611021', '6110', '洛南县', null, '1', null);
INSERT INTO `district_code` VALUES ('410328', '4103', '洛宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('610629', '6106', '洛川县', null, '1', null);
INSERT INTO `district_code` VALUES ('542228', '5422', '洛扎县', null, '1', null);
INSERT INTO `district_code` VALUES ('350504', '3505', '洛江区', null, '1', null);
INSERT INTO `district_code` VALUES ('653224', '6532', '洛浦县', null, '1', null);
INSERT INTO `district_code` VALUES ('542132', '5421', '洛隆县', null, '1', null);
INSERT INTO `district_code` VALUES ('410311', '4103', '洛龙区', null, '1', null);
INSERT INTO `district_code` VALUES ('430525', '4305', '洞口县', null, '1', null);
INSERT INTO `district_code` VALUES ('330322', '3303', '洞头县', null, '1', null);
INSERT INTO `district_code` VALUES ('120112', '12', '津南区', null, '1', null);
INSERT INTO `district_code` VALUES ('430781', '4307', '津市市', null, '1', null);
INSERT INTO `district_code` VALUES ('420111', '4201', '洪山区', null, '1', null);
INSERT INTO `district_code` VALUES ('431281', '4312', '洪江市', null, '1', null);
INSERT INTO `district_code` VALUES ('320829', '3208', '洪泽县', null, '1', null);
INSERT INTO `district_code` VALUES ('141024', '1410', '洪洞县', null, '1', null);
INSERT INTO `district_code` VALUES ('421083', '4210', '洪湖市', null, '1', null);
INSERT INTO `district_code` VALUES ('511423', '5114', '洪雅县', null, '1', null);
INSERT INTO `district_code` VALUES ('220802', '2208', '洮北区', null, '1', null);
INSERT INTO `district_code` VALUES ('220881', '2208', '洮南市', null, '1', null);
INSERT INTO `district_code` VALUES ('532930', '5329', '洱源县', null, '1', null);
INSERT INTO `district_code` VALUES ('440204', '4402', '浈江区', null, '1', null);
INSERT INTO `district_code` VALUES ('411502', '4115', '浉河区', null, '1', null);
INSERT INTO `district_code` VALUES ('419001', '4190', '济源市', null, '1', null);
INSERT INTO `district_code` VALUES ('370125', '3701', '济阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('430181', '4301', '浏阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('140225', '1402', '浑源县', null, '1', null);
INSERT INTO `district_code` VALUES ('360403', '3604', '浔阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('410621', '4106', '浚县', null, '1', null);
INSERT INTO `district_code` VALUES ('421125', '4211', '浠水县', null, '1', null);
INSERT INTO `district_code` VALUES ('310115', '31', '浦东新区', null, '1', null);
INSERT INTO `district_code` VALUES ('450722', '4507', '浦北县', null, '1', null);
INSERT INTO `district_code` VALUES ('320111', '3201', '浦口区', null, '1', null);
INSERT INTO `district_code` VALUES ('350722', '3507', '浦城县', null, '1', null);
INSERT INTO `district_code` VALUES ('330726', '3307', '浦江县', null, '1', null);
INSERT INTO `district_code` VALUES ('542233', '5422', '浪卡子县', null, '1', null);
INSERT INTO `district_code` VALUES ('141027', '1410', '浮山县', null, '1', null);
INSERT INTO `district_code` VALUES ('360222', '3602', '浮梁县', null, '1', null);
INSERT INTO `district_code` VALUES ('441521', '4415', '海丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('231283', '2312', '海伦市', null, '1', null);
INSERT INTO `district_code` VALUES ('130924', '1309', '海兴县', null, '1', null);
INSERT INTO `district_code` VALUES ('150302', '1503', '海勃湾区', null, '1', null);
INSERT INTO `district_code` VALUES ('150303', '1503', '海南区', null, '1', null);
INSERT INTO `district_code` VALUES ('640522', '6405', '海原县', null, '1', null);
INSERT INTO `district_code` VALUES ('450502', '4505', '海城区', null, '1', null);
INSERT INTO `district_code` VALUES ('210381', '2103', '海城市', null, '1', null);
INSERT INTO `district_code` VALUES ('330481', '3304', '海宁市', null, '1', null);
INSERT INTO `district_code` VALUES ('320621', '3206', '海安县', null, '1', null);
INSERT INTO `district_code` VALUES ('210902', '2109', '海州区', null, '1', null);
INSERT INTO `district_code` VALUES ('150702', '1507', '海拉尔区', null, '1', null);
INSERT INTO `district_code` VALUES ('632223', '6322', '海晏县', null, '1', null);
INSERT INTO `district_code` VALUES ('330203', '3302', '海曙区', null, '1', null);
INSERT INTO `district_code` VALUES ('231083', '2310', '海林市', null, '1', null);
INSERT INTO `district_code` VALUES ('350205', '3502', '海沧区', null, '1', null);
INSERT INTO `district_code` VALUES ('110108', '11', '海淀区', null, '1', null);
INSERT INTO `district_code` VALUES ('130302', '1303', '海港区', null, '1', null);
INSERT INTO `district_code` VALUES ('440105', '4401', '海珠区', null, '1', null);
INSERT INTO `district_code` VALUES ('330424', '3304', '海盐县', null, '1', null);
INSERT INTO `district_code` VALUES ('320684', '3206', '海门市', null, '1', null);
INSERT INTO `district_code` VALUES ('370687', '3706', '海阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('321202', '3212', '海陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('130426', '1304', '涉县', null, '1', null);
INSERT INTO `district_code` VALUES ('130623', '1306', '涞水县', null, '1', null);
INSERT INTO `district_code` VALUES ('130630', '1306', '涞源县', null, '1', null);
INSERT INTO `district_code` VALUES ('320826', '3208', '涟水县', null, '1', null);
INSERT INTO `district_code` VALUES ('431382', '4313', '涟源市', null, '1', null);
INSERT INTO `district_code` VALUES ('341621', '3416', '涡阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('321111', '3211', '润州区', null, '1', null);
INSERT INTO `district_code` VALUES ('410305', '4103', '涧西区', null, '1', null);
INSERT INTO `district_code` VALUES ('510703', '5107', '涪城区', null, '1', null);
INSERT INTO `district_code` VALUES ('500102', '50', '涪陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('350303', '3503', '涵江区', null, '1', null);
INSERT INTO `district_code` VALUES ('130681', '1306', '涿州市', null, '1', null);
INSERT INTO `district_code` VALUES ('130731', '1307', '涿鹿县', null, '1', null);
INSERT INTO `district_code` VALUES ('370302', '3703', '淄川区', null, '1', null);
INSERT INTO `district_code` VALUES ('411326', '4113', '淅川县', null, '1', null);
INSERT INTO `district_code` VALUES ('410622', '4106', '淇县', null, '1', null);
INSERT INTO `district_code` VALUES ('410611', '4106', '淇滨区', null, '1', null);
INSERT INTO `district_code` VALUES ('340311', '3403', '淮上区', null, '1', null);
INSERT INTO `district_code` VALUES ('411527', '4115', '淮滨县', null, '1', null);
INSERT INTO `district_code` VALUES ('411626', '4116', '淮阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('320804', '3208', '淮阴区', null, '1', null);
INSERT INTO `district_code` VALUES ('131182', '1311', '深州市', null, '1', null);
INSERT INTO `district_code` VALUES ('130128', '1301', '深泽县', null, '1', null);
INSERT INTO `district_code` VALUES ('610430', '6104', '淳化县', null, '1', null);
INSERT INTO `district_code` VALUES ('330127', '3301', '淳安县', null, '1', null);
INSERT INTO `district_code` VALUES ('410922', '4109', '清丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('210423', '2104', '清原满族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('441802', '4418', '清城区', null, '1', null);
INSERT INTO `district_code` VALUES ('140121', '1401', '清徐县', null, '1', null);
INSERT INTO `district_code` VALUES ('441827', '4418', '清新县', null, '1', null);
INSERT INTO `district_code` VALUES ('620521', '6205', '清水县', null, '1', null);
INSERT INTO `district_code` VALUES ('150124', '1501', '清水河县', null, '1', null);
INSERT INTO `district_code` VALUES ('211204', '2112', '清河区', null, '1', null);
INSERT INTO `district_code` VALUES ('130534', '1305', '清河县', null, '1', null);
INSERT INTO `district_code` VALUES ('210905', '2109', '清河门区', null, '1', null);
INSERT INTO `district_code` VALUES ('350423', '3504', '清流县', null, '1', null);
INSERT INTO `district_code` VALUES ('320811', '3208', '清浦区', null, '1', null);
INSERT INTO `district_code` VALUES ('610830', '6108', '清涧县', null, '1', null);
INSERT INTO `district_code` VALUES ('130622', '1306', '清苑县', null, '1', null);
INSERT INTO `district_code` VALUES ('520181', '5201', '清镇市', null, '1', null);
INSERT INTO `district_code` VALUES ('411221', '4112', '渑池县', null, '1', null);
INSERT INTO `district_code` VALUES ('500103', '50', '渝中区', null, '1', null);
INSERT INTO `district_code` VALUES ('500112', '50', '渝北区', null, '1', null);
INSERT INTO `district_code` VALUES ('360502', '3605', '渝水区', null, '1', null);
INSERT INTO `district_code` VALUES ('511725', '5117', '渠县', null, '1', null);
INSERT INTO `district_code` VALUES ('410825', '4108', '温县', null, '1', null);
INSERT INTO `district_code` VALUES ('652922', '6529', '温宿县', null, '1', null);
INSERT INTO `district_code` VALUES ('331081', '3310', '温岭市', null, '1', null);
INSERT INTO `district_code` VALUES ('510115', '5101', '温江区', null, '1', null);
INSERT INTO `district_code` VALUES ('652723', '6527', '温泉县', null, '1', null);
INSERT INTO `district_code` VALUES ('610404', '6104', '渭城区', null, '1', null);
INSERT INTO `district_code` VALUES ('621123', '6211', '渭源县', null, '1', null);
INSERT INTO `district_code` VALUES ('610302', '6103', '渭滨区', null, '1', null);
INSERT INTO `district_code` VALUES ('450802', '4508', '港北区', null, '1', null);
INSERT INTO `district_code` VALUES ('450803', '4508', '港南区', null, '1', null);
INSERT INTO `district_code` VALUES ('450602', '4506', '港口区', null, '1', null);
INSERT INTO `district_code` VALUES ('320611', '3206', '港闸区', null, '1', null);
INSERT INTO `district_code` VALUES ('510704', '5107', '游仙区', null, '1', null);
INSERT INTO `district_code` VALUES ('520328', '5203', '湄潭县', null, '1', null);
INSERT INTO `district_code` VALUES ('360429', '3604', '湖口县', null, '1', null);
INSERT INTO `district_code` VALUES ('411202', '4112', '湖滨区', null, '1', null);
INSERT INTO `district_code` VALUES ('350206', '3502', '湖里区', null, '1', null);
INSERT INTO `district_code` VALUES ('360313', '3603', '湘东区', null, '1', null);
INSERT INTO `district_code` VALUES ('430381', '4303', '湘乡市', null, '1', null);
INSERT INTO `district_code` VALUES ('445102', '4451', '湘桥区', null, '1', null);
INSERT INTO `district_code` VALUES ('430321', '4303', '湘潭县', null, '1', null);
INSERT INTO `district_code` VALUES ('430624', '4306', '湘阴县', null, '1', null);
INSERT INTO `district_code` VALUES ('410411', '4104', '湛河区', null, '1', null);
INSERT INTO `district_code` VALUES ('630122', '6301', '湟中县', null, '1', null);
INSERT INTO `district_code` VALUES ('630123', '6301', '湟源县', null, '1', null);
INSERT INTO `district_code` VALUES ('360105', '3601', '湾里区', null, '1', null);
INSERT INTO `district_code` VALUES ('431224', '4312', '溆浦县', null, '1', null);
INSERT INTO `district_code` VALUES ('441602', '4416', '源城区', null, '1', null);
INSERT INTO `district_code` VALUES ('411102', '4111', '源汇区', null, '1', null);
INSERT INTO `district_code` VALUES ('320124', '3201', '溧水县', null, '1', null);
INSERT INTO `district_code` VALUES ('320481', '3204', '溧阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('210503', '2105', '溪湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('410526', '4105', '滑县', null, '1', null);
INSERT INTO `district_code` VALUES ('370481', '3704', '滕州市', null, '1', null);
INSERT INTO `district_code` VALUES ('130621', '1306', '满城县', null, '1', null);
INSERT INTO `district_code` VALUES ('150781', '1507', '满洲里市', null, '1', null);
INSERT INTO `district_code` VALUES ('130224', '1302', '滦南县', null, '1', null);
INSERT INTO `district_code` VALUES ('130223', '1302', '滦县', null, '1', null);
INSERT INTO `district_code` VALUES ('130824', '1308', '滦平县', null, '1', null);
INSERT INTO `district_code` VALUES ('371602', '3716', '滨城区', null, '1', null);
INSERT INTO `district_code` VALUES ('330108', '3301', '滨江区', null, '1', null);
INSERT INTO `district_code` VALUES ('320922', '3209', '滨海县', null, '1', null);
INSERT INTO `district_code` VALUES ('120116', '12', '滨海新区', null, '1', null);
INSERT INTO `district_code` VALUES ('320211', '3202', '滨湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('230304', '2303', '滴道区', null, '1', null);
INSERT INTO `district_code` VALUES ('232723', '2327', '漠河县', null, '1', null);
INSERT INTO `district_code` VALUES ('621125', '6211', '漳县', null, '1', null);
INSERT INTO `district_code` VALUES ('350881', '3508', '漳平市', null, '1', null);
INSERT INTO `district_code` VALUES ('350623', '3506', '漳浦县', null, '1', null);
INSERT INTO `district_code` VALUES ('532922', '5329', '漾濞彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('370702', '3707', '潍城区', null, '1', null);
INSERT INTO `district_code` VALUES ('340406', '3404', '潘集区', null, '1', null);
INSERT INTO `district_code` VALUES ('340824', '3408', '潜山县', null, '1', null);
INSERT INTO `district_code` VALUES ('429005', '4290', '潜江市', null, '1', null);
INSERT INTO `district_code` VALUES ('140481', '1404', '潞城市', null, '1', null);
INSERT INTO `district_code` VALUES ('411526', '4115', '潢川县', null, '1', null);
INSERT INTO `district_code` VALUES ('440514', '4405', '潮南区', null, '1', null);
INSERT INTO `district_code` VALUES ('445121', '4451', '潮安县', null, '1', null);
INSERT INTO `district_code` VALUES ('440513', '4405', '潮阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('610522', '6105', '潼关县', null, '1', null);
INSERT INTO `district_code` VALUES ('500223', '50', '潼南县', null, '1', null);
INSERT INTO `district_code` VALUES ('610525', '6105', '澄城县', null, '1', null);
INSERT INTO `district_code` VALUES ('530422', '5304', '澄江县', null, '1', null);
INSERT INTO `district_code` VALUES ('440515', '4405', '澄海区', null, '1', null);
INSERT INTO `district_code` VALUES ('469023', '4690', '澄迈县', null, '1', null);
INSERT INTO `district_code` VALUES ('530828', '5308', '澜沧拉祜族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('430723', '4307', '澧县', null, '1', null);
INSERT INTO `district_code` VALUES ('340621', '3406', '濉溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('440512', '4405', '濠江区', null, '1', null);
INSERT INTO `district_code` VALUES ('410928', '4109', '濮阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('410304', '4103', '瀍河回族区', null, '1', null);
INSERT INTO `district_code` VALUES ('320723', '3207', '灌云县', null, '1', null);
INSERT INTO `district_code` VALUES ('320724', '3207', '灌南县', null, '1', null);
INSERT INTO `district_code` VALUES ('450327', '4503', '灌阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('610111', '6101', '灞桥区', null, '1', null);
INSERT INTO `district_code` VALUES ('211081', '2110', '灯塔市', null, '1', null);
INSERT INTO `district_code` VALUES ('140224', '1402', '灵丘县', null, '1', null);
INSERT INTO `district_code` VALUES ('620822', '6208', '灵台县', null, '1', null);
INSERT INTO `district_code` VALUES ('411282', '4112', '灵宝市', null, '1', null);
INSERT INTO `district_code` VALUES ('130126', '1301', '灵寿县', null, '1', null);
INSERT INTO `district_code` VALUES ('450721', '4507', '灵山县', null, '1', null);
INSERT INTO `district_code` VALUES ('450323', '4503', '灵川县', null, '1', null);
INSERT INTO `district_code` VALUES ('640181', '6401', '灵武市', null, '1', null);
INSERT INTO `district_code` VALUES ('341323', '3413', '灵璧县', null, '1', null);
INSERT INTO `district_code` VALUES ('140729', '1407', '灵石县', null, '1', null);
INSERT INTO `district_code` VALUES ('513327', '5133', '炉霍县', null, '1', null);
INSERT INTO `district_code` VALUES ('430225', '4302', '炎陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('420504', '4205', '点军区', null, '1', null);
INSERT INTO `district_code` VALUES ('340604', '3406', '烈山区', null, '1', null);
INSERT INTO `district_code` VALUES ('652826', '6528', '焉耆回族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('231004', '2310', '爱民区', null, '1', null);
INSERT INTO `district_code` VALUES ('231102', '2311', '爱辉区', null, '1', null);
INSERT INTO `district_code` VALUES ('150782', '1507', '牙克石市', null, '1', null);
INSERT INTO `district_code` VALUES ('532323', '5323', '牟定县', null, '1', null);
INSERT INTO `district_code` VALUES ('370612', '3706', '牟平区', null, '1', null);
INSERT INTO `district_code` VALUES ('371702', '3717', '牡丹区', null, '1', null);
INSERT INTO `district_code` VALUES ('410711', '4107', '牧野区', null, '1', null);
INSERT INTO `district_code` VALUES ('654027', '6540', '特克斯县', null, '1', null);
INSERT INTO `district_code` VALUES ('511123', '5111', '犍为县', null, '1', null);
INSERT INTO `district_code` VALUES ('522726', '5227', '独山县', null, '1', null);
INSERT INTO `district_code` VALUES ('650202', '6502', '独山子区', null, '1', null);
INSERT INTO `district_code` VALUES ('340703', '3407', '狮子山区', null, '1', null);
INSERT INTO `district_code` VALUES ('420505', '4205', '猇亭区', null, '1', null);
INSERT INTO `district_code` VALUES ('130929', '1309', '献县', null, '1', null);
INSERT INTO `district_code` VALUES ('320102', '3201', '玄武区', null, '1', null);
INSERT INTO `district_code` VALUES ('520622', '5206', '玉屏侗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('361123', '3611', '玉山县', null, '1', null);
INSERT INTO `district_code` VALUES ('450902', '4509', '玉州区', null, '1', null);
INSERT INTO `district_code` VALUES ('632721', '6327', '玉树县', null, '1', null);
INSERT INTO `district_code` VALUES ('150104', '1501', '玉泉区', null, '1', null);
INSERT INTO `district_code` VALUES ('331021', '3310', '玉环县', null, '1', null);
INSERT INTO `district_code` VALUES ('130229', '1302', '玉田县', null, '1', null);
INSERT INTO `district_code` VALUES ('620981', '6209', '玉门市', null, '1', null);
INSERT INTO `district_code` VALUES ('530721', '5307', '玉龙纳西族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('610202', '6102', '王益区', null, '1', null);
INSERT INTO `district_code` VALUES ('632626', '6326', '玛多县', null, '1', null);
INSERT INTO `district_code` VALUES ('623025', '6230', '玛曲县', null, '1', null);
INSERT INTO `district_code` VALUES ('632621', '6326', '玛沁县', null, '1', null);
INSERT INTO `district_code` VALUES ('652324', '6523', '玛纳斯县', null, '1', null);
INSERT INTO `district_code` VALUES ('621022', '6210', '环县', null, '1', null);
INSERT INTO `district_code` VALUES ('451226', '4512', '环江毛南族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('371002', '3710', '环翠区', null, '1', null);
INSERT INTO `district_code` VALUES ('511526', '5115', '珙县', null, '1', null);
INSERT INTO `district_code` VALUES ('360203', '3602', '珠山区', null, '1', null);
INSERT INTO `district_code` VALUES ('430405', '4304', '珠晖区', null, '1', null);
INSERT INTO `district_code` VALUES ('542428', '5424', '班戈县', null, '1', null);
INSERT INTO `district_code` VALUES ('632622', '6326', '班玛县', null, '1', null);
INSERT INTO `district_code` VALUES ('222404', '2224', '珲春市', null, '1', null);
INSERT INTO `district_code` VALUES ('341102', '3411', '琅琊区', null, '1', null);
INSERT INTO `district_code` VALUES ('513222', '5132', '理县', null, '1', null);
INSERT INTO `district_code` VALUES ('513334', '5133', '理塘县', null, '1', null);
INSERT INTO `district_code` VALUES ('469030', '4690', '琼中黎族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('460107', '4601', '琼山区', null, '1', null);
INSERT INTO `district_code` VALUES ('469002', '4690', '琼海市', null, '1', null);
INSERT INTO `district_code` VALUES ('542225', '5422', '琼结县', null, '1', null);
INSERT INTO `district_code` VALUES ('533102', '5331', '瑞丽市', null, '1', null);
INSERT INTO `district_code` VALUES ('330381', '3303', '瑞安市', null, '1', null);
INSERT INTO `district_code` VALUES ('360481', '3604', '瑞昌市', null, '1', null);
INSERT INTO `district_code` VALUES ('360781', '3607', '瑞金市', null, '1', null);
INSERT INTO `district_code` VALUES ('340102', '3401', '瑶海区', null, '1', null);
INSERT INTO `district_code` VALUES ('500227', '50', '璧山县', null, '1', null);
INSERT INTO `district_code` VALUES ('620922', '6209', '瓜州县', null, '1', null);
INSERT INTO `district_code` VALUES ('210281', '2102', '瓦房店市', null, '1', null);
INSERT INTO `district_code` VALUES ('522725', '5227', '瓮安县', null, '1', null);
INSERT INTO `district_code` VALUES ('330304', '3303', '瓯海区', null, '1', null);
INSERT INTO `district_code` VALUES ('210211', '2102', '甘井子区', null, '1', null);
INSERT INTO `district_code` VALUES ('230225', '2302', '甘南县', null, '1', null);
INSERT INTO `district_code` VALUES ('513328', '5133', '甘孜县', null, '1', null);
INSERT INTO `district_code` VALUES ('620702', '6207', '甘州区', null, '1', null);
INSERT INTO `district_code` VALUES ('632623', '6326', '甘德县', null, '1', null);
INSERT INTO `district_code` VALUES ('610627', '6106', '甘泉县', null, '1', null);
INSERT INTO `district_code` VALUES ('513435', '5134', '甘洛县', null, '1', null);
INSERT INTO `district_code` VALUES ('620523', '6205', '甘谷县', null, '1', null);
INSERT INTO `district_code` VALUES ('451022', '4510', '田东县', null, '1', null);
INSERT INTO `district_code` VALUES ('340403', '3404', '田家庵区', null, '1', null);
INSERT INTO `district_code` VALUES ('451029', '4510', '田林县', null, '1', null);
INSERT INTO `district_code` VALUES ('451021', '4510', '田阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('542426', '5424', '申扎县', null, '1', null);
INSERT INTO `district_code` VALUES ('440923', '4409', '电白县', null, '1', null);
INSERT INTO `district_code` VALUES ('341282', '3412', '界首市', null, '1', null);
INSERT INTO `district_code` VALUES ('610729', '6107', '留坝县', null, '1', null);
INSERT INTO `district_code` VALUES ('610727', '6107', '略阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('440113', '4401', '番禺区', null, '1', null);
INSERT INTO `district_code` VALUES ('653122', '6531', '疏勒县', null, '1', null);
INSERT INTO `district_code` VALUES ('653121', '6531', '疏附县', null, '1', null);
INSERT INTO `district_code` VALUES ('410185', '4101', '登封市', null, '1', null);
INSERT INTO `district_code` VALUES ('320103', '3201', '白下区', null, '1', null);
INSERT INTO `district_code` VALUES ('440111', '4401', '白云区', null, '1', null);
INSERT INTO `district_code` VALUES ('150206', '1502', '白云鄂博矿区', null, '1', null);
INSERT INTO `district_code` VALUES ('211002', '2110', '白塔区', null, '1', null);
INSERT INTO `district_code` VALUES ('542329', '5423', '白朗县', null, '1', null);
INSERT INTO `district_code` VALUES ('610527', '6105', '白水县', null, '1', null);
INSERT INTO `district_code` VALUES ('469025', '4690', '白沙黎族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('610929', '6109', '白河县', null, '1', null);
INSERT INTO `district_code` VALUES ('513331', '5133', '白玉县', null, '1', null);
INSERT INTO `district_code` VALUES ('650204', '6502', '白碱滩区', null, '1', null);
INSERT INTO `district_code` VALUES ('620402', '6204', '白银区', null, '1', null);
INSERT INTO `district_code` VALUES ('210105', '2101', '皇姑区', null, '1', null);
INSERT INTO `district_code` VALUES ('620122', '6201', '皋兰县', null, '1', null);
INSERT INTO `district_code` VALUES ('653223', '6532', '皮山县', null, '1', null);
INSERT INTO `district_code` VALUES ('140322', '1403', '盂县', null, '1', null);
INSERT INTO `district_code` VALUES ('533123', '5331', '盈江县', null, '1', null);
INSERT INTO `district_code` VALUES ('510723', '5107', '盐亭县', null, '1', null);
INSERT INTO `district_code` VALUES ('130925', '1309', '盐山县', null, '1', null);
INSERT INTO `district_code` VALUES ('640323', '6403', '盐池县', null, '1', null);
INSERT INTO `district_code` VALUES ('530623', '5306', '盐津县', null, '1', null);
INSERT INTO `district_code` VALUES ('140802', '1408', '盐湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('513423', '5134', '盐源县', null, '1', null);
INSERT INTO `district_code` VALUES ('440308', '4403', '盐田区', null, '1', null);
INSERT INTO `district_code` VALUES ('510422', '5104', '盐边县', null, '1', null);
INSERT INTO `district_code` VALUES ('320903', '3209', '盐都区', null, '1', null);
INSERT INTO `district_code` VALUES ('421023', '4210', '监利县', null, '1', null);
INSERT INTO `district_code` VALUES ('210881', '2108', '盖州市', null, '1', null);
INSERT INTO `district_code` VALUES ('520222', '5202', '盘县', null, '1', null);
INSERT INTO `district_code` VALUES ('211122', '2111', '盘山县', null, '1', null);
INSERT INTO `district_code` VALUES ('530103', '5301', '盘龙区', null, '1', null);
INSERT INTO `district_code` VALUES ('320830', '3208', '盱眙县', null, '1', null);
INSERT INTO `district_code` VALUES ('320507', '3205', '相城区', null, '1', null);
INSERT INTO `district_code` VALUES ('340603', '3406', '相山区', null, '1', null);
INSERT INTO `district_code` VALUES ('610326', '6103', '眉县', null, '1', null);
INSERT INTO `district_code` VALUES ('411422', '4114', '睢县', null, '1', null);
INSERT INTO `district_code` VALUES ('320324', '3203', '睢宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('411403', '4114', '睢阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('341722', '3417', '石台县', null, '1', null);
INSERT INTO `district_code` VALUES ('360735', '3607', '石城县', null, '1', null);
INSERT INTO `district_code` VALUES ('532525', '5325', '石屏县', null, '1', null);
INSERT INTO `district_code` VALUES ('430204', '4302', '石峰区', null, '1', null);
INSERT INTO `district_code` VALUES ('150205', '1502', '石拐区', null, '1', null);
INSERT INTO `district_code` VALUES ('110107', '11', '石景山区', null, '1', null);
INSERT INTO `district_code` VALUES ('530126', '5301', '石林彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('500240', '50', '石柱土家族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('511824', '5118', '石棉县', null, '1', null);
INSERT INTO `district_code` VALUES ('141126', '1411', '石楼县', null, '1', null);
INSERT INTO `district_code` VALUES ('659001', '6590', '石河子市', null, '1', null);
INSERT INTO `district_code` VALUES ('610922', '6109', '石泉县', null, '1', null);
INSERT INTO `district_code` VALUES ('513332', '5133', '石渠县', null, '1', null);
INSERT INTO `district_code` VALUES ('350581', '3505', '石狮市', null, '1', null);
INSERT INTO `district_code` VALUES ('430726', '4307', '石门县', null, '1', null);
INSERT INTO `district_code` VALUES ('520623', '5206', '石阡县', null, '1', null);
INSERT INTO `district_code` VALUES ('421081', '4210', '石首市', null, '1', null);
INSERT INTO `district_code` VALUES ('430407', '4304', '石鼓区', null, '1', null);
INSERT INTO `district_code` VALUES ('410404', '4104', '石龙区', null, '1', null);
INSERT INTO `district_code` VALUES ('140203', '1402', '矿区', null, '1', null);
INSERT INTO `district_code` VALUES ('341321', '3413', '砀山县', null, '1', null);
INSERT INTO `district_code` VALUES ('532622', '5326', '砚山县', null, '1', null);
INSERT INTO `district_code` VALUES ('420104', '4201', '硚口区', null, '1', null);
INSERT INTO `district_code` VALUES ('411725', '4117', '确山县', null, '1', null);
INSERT INTO `district_code` VALUES ('623026', '6230', '碌曲县', null, '1', null);
INSERT INTO `district_code` VALUES ('610103', '6101', '碑林区', null, '1', null);
INSERT INTO `district_code` VALUES ('520602', '5206', '碧江区', null, '1', null);
INSERT INTO `district_code` VALUES ('230207', '2302', '碾子山区', null, '1', null);
INSERT INTO `district_code` VALUES ('130427', '1304', '磁县', null, '1', null);
INSERT INTO `district_code` VALUES ('330727', '3307', '磐安县', null, '1', null);
INSERT INTO `district_code` VALUES ('220284', '2202', '磐石市', null, '1', null);
INSERT INTO `district_code` VALUES ('150822', '1508', '磴口县', null, '1', null);
INSERT INTO `district_code` VALUES ('621226', '6212', '礼县', null, '1', null);
INSERT INTO `district_code` VALUES ('610425', '6104', '礼泉县', null, '1', null);
INSERT INTO `district_code` VALUES ('411327', '4113', '社旗县', null, '1', null);
INSERT INTO `district_code` VALUES ('430426', '4304', '祁东县', null, '1', null);
INSERT INTO `district_code` VALUES ('140727', '1407', '祁县', null, '1', null);
INSERT INTO `district_code` VALUES ('632222', '6322', '祁连县', null, '1', null);
INSERT INTO `district_code` VALUES ('341024', '3410', '祁门县', null, '1', null);
INSERT INTO `district_code` VALUES ('431121', '4311', '祁阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('429021', '4290', '神农架林区', null, '1', null);
INSERT INTO `district_code` VALUES ('610821', '6108', '神木县', null, '1', null);
INSERT INTO `district_code` VALUES ('140927', '1409', '神池县', null, '1', null);
INSERT INTO `district_code` VALUES ('532923', '5329', '祥云县', null, '1', null);
INSERT INTO `district_code` VALUES ('532331', '5323', '禄丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('530128', '5301', '禄劝彝族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('440604', '4406', '禅城区', null, '1', null);
INSERT INTO `district_code` VALUES ('350981', '3509', '福安市', null, '1', null);
INSERT INTO `district_code` VALUES ('370611', '3706', '福山区', null, '1', null);
INSERT INTO `district_code` VALUES ('522702', '5227', '福泉市', null, '1', null);
INSERT INTO `district_code` VALUES ('654323', '6543', '福海县', null, '1', null);
INSERT INTO `district_code` VALUES ('350181', '3501', '福清市', null, '1', null);
INSERT INTO `district_code` VALUES ('440304', '4403', '福田区', null, '1', null);
INSERT INTO `district_code` VALUES ('533323', '5333', '福贡县', null, '1', null);
INSERT INTO `district_code` VALUES ('350982', '3509', '福鼎市', null, '1', null);
INSERT INTO `district_code` VALUES ('340304', '3403', '禹会区', null, '1', null);
INSERT INTO `district_code` VALUES ('371482', '3714', '禹城市', null, '1', null);
INSERT INTO `district_code` VALUES ('411081', '4110', '禹州市', null, '1', null);
INSERT INTO `district_code` VALUES ('410205', '4102', '禹王台区', null, '1', null);
INSERT INTO `district_code` VALUES ('141102', '1411', '离石区', null, '1', null);
INSERT INTO `district_code` VALUES ('500241', '50', '秀山土家族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('350305', '3503', '秀屿区', null, '1', null);
INSERT INTO `district_code` VALUES ('450302', '4503', '秀峰区', null, '1', null);
INSERT INTO `district_code` VALUES ('330411', '3304', '秀洲区', null, '1', null);
INSERT INTO `district_code` VALUES ('460105', '4601', '秀英区', null, '1', null);
INSERT INTO `district_code` VALUES ('150502', '1505', '科尔沁区', null, '1', null);
INSERT INTO `district_code` VALUES ('152222', '1522', '科尔沁右翼中旗', null, '1', null);
INSERT INTO `district_code` VALUES ('152221', '1522', '科尔沁右翼前旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150521', '1505', '科尔沁左翼中旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150522', '1505', '科尔沁左翼后旗', null, '1', null);
INSERT INTO `district_code` VALUES ('620522', '6205', '秦安县', null, '1', null);
INSERT INTO `district_code` VALUES ('620502', '6205', '秦州区', null, '1', null);
INSERT INTO `district_code` VALUES ('320104', '3201', '秦淮区', null, '1', null);
INSERT INTO `district_code` VALUES ('610402', '6104', '秦都区', null, '1', null);
INSERT INTO `district_code` VALUES ('420527', '4205', '秭归县', null, '1', null);
INSERT INTO `district_code` VALUES ('622927', '6229', '积石山保安族东乡族撒拉族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('632723', '6327', '称多县', null, '1', null);
INSERT INTO `district_code` VALUES ('140824', '1408', '稷山县', null, '1', null);
INSERT INTO `district_code` VALUES ('513337', '5133', '稻城县', null, '1', null);
INSERT INTO `district_code` VALUES ('231085', '2310', '穆棱市', null, '1', null);
INSERT INTO `district_code` VALUES ('152224', '1522', '突泉县', null, '1', null);
INSERT INTO `district_code` VALUES ('210304', '2103', '立山区', null, '1', null);
INSERT INTO `district_code` VALUES ('210802', '2108', '站前区', null, '1', null);
INSERT INTO `district_code` VALUES ('370181', '3701', '章丘市', null, '1', null);
INSERT INTO `district_code` VALUES ('360702', '3607', '章贡区', null, '1', null);
INSERT INTO `district_code` VALUES ('441202', '4412', '端州区', null, '1', null);
INSERT INTO `district_code` VALUES ('420323', '4203', '竹山县', null, '1', null);
INSERT INTO `district_code` VALUES ('420324', '4203', '竹溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('653225', '6532', '策勒县', null, '1', null);
INSERT INTO `district_code` VALUES ('511527', '5115', '筠连县', null, '1', null);
INSERT INTO `district_code` VALUES ('512081', '5120', '简阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('410104', '4101', '管城回族区', null, '1', null);
INSERT INTO `district_code` VALUES ('650109', '6501', '米东区', null, '1', null);
INSERT INTO `district_code` VALUES ('510421', '5104', '米易县', null, '1', null);
INSERT INTO `district_code` VALUES ('542623', '5426', '米林县', null, '1', null);
INSERT INTO `district_code` VALUES ('610827', '6108', '米脂县', null, '1', null);
INSERT INTO `district_code` VALUES ('542124', '5421', '类乌齐县', null, '1', null);
INSERT INTO `district_code` VALUES ('652722', '6527', '精河县', null, '1', null);
INSERT INTO `district_code` VALUES ('542427', '5424', '索县', null, '1', null);
INSERT INTO `district_code` VALUES ('520425', '5204', '紫云苗族布依族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('441621', '4416', '紫金县', null, '1', null);
INSERT INTO `district_code` VALUES ('610924', '6109', '紫阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('500110', '50', '綦江区', null, '1', null);
INSERT INTO `district_code` VALUES ('140924', '1409', '繁峙县', null, '1', null);
INSERT INTO `district_code` VALUES ('340222', '3402', '繁昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('513233', '5132', '红原县', null, '1', null);
INSERT INTO `district_code` VALUES ('620111', '6201', '红古区', null, '1', null);
INSERT INTO `district_code` VALUES ('530402', '5304', '红塔区', null, '1', null);
INSERT INTO `district_code` VALUES ('421122', '4211', '红安县', null, '1', null);
INSERT INTO `district_code` VALUES ('640303', '6403', '红寺堡区', null, '1', null);
INSERT INTO `district_code` VALUES ('150402', '1504', '红山区', null, '1', null);
INSERT INTO `district_code` VALUES ('230605', '2306', '红岗区', null, '1', null);
INSERT INTO `district_code` VALUES ('410702', '4107', '红旗区', null, '1', null);
INSERT INTO `district_code` VALUES ('230715', '2307', '红星区', null, '1', null);
INSERT INTO `district_code` VALUES ('120106', '12', '红桥区', null, '1', null);
INSERT INTO `district_code` VALUES ('532529', '5325', '红河县', null, '1', null);
INSERT INTO `district_code` VALUES ('520302', '5203', '红花岗区', null, '1', null);
INSERT INTO `district_code` VALUES ('510503', '5105', '纳溪区', null, '1', null);
INSERT INTO `district_code` VALUES ('520525', '5205', '纳雍县', null, '1', null);
INSERT INTO `district_code` VALUES ('210911', '2109', '细河区', null, '1', null);
INSERT INTO `district_code` VALUES ('520524', '5205', '织金县', null, '1', null);
INSERT INTO `district_code` VALUES ('330621', '3306', '绍兴县', null, '1', null);
INSERT INTO `district_code` VALUES ('140826', '1408', '绛县', null, '1', null);
INSERT INTO `district_code` VALUES ('211421', '2114', '绥中县', null, '1', null);
INSERT INTO `district_code` VALUES ('430527', '4305', '绥宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('610826', '6108', '绥德县', null, '1', null);
INSERT INTO `district_code` VALUES ('231226', '2312', '绥棱县', null, '1', null);
INSERT INTO `district_code` VALUES ('530626', '5306', '绥江县', null, '1', null);
INSERT INTO `district_code` VALUES ('230422', '2304', '绥滨县', null, '1', null);
INSERT INTO `district_code` VALUES ('231081', '2310', '绥芬河市', null, '1', null);
INSERT INTO `district_code` VALUES ('520323', '5203', '绥阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('341824', '3418', '绩溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('533423', '5334', '维西傈僳族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('510683', '5106', '绵竹市', null, '1', null);
INSERT INTO `district_code` VALUES ('220106', '2201', '绿园区', null, '1', null);
INSERT INTO `district_code` VALUES ('532531', '5325', '绿春县', null, '1', null);
INSERT INTO `district_code` VALUES ('331122', '3311', '缙云县', null, '1', null);
INSERT INTO `district_code` VALUES ('451225', '4512', '罗城仫佬族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('445381', '4453', '罗定市', null, '1', null);
INSERT INTO `district_code` VALUES ('411521', '4115', '罗山县', null, '1', null);
INSERT INTO `district_code` VALUES ('530324', '5303', '罗平县', null, '1', null);
INSERT INTO `district_code` VALUES ('371311', '3713', '罗庄区', null, '1', null);
INSERT INTO `district_code` VALUES ('510626', '5106', '罗江县', null, '1', null);
INSERT INTO `district_code` VALUES ('440303', '4403', '罗湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('350123', '3501', '罗源县', null, '1', null);
INSERT INTO `district_code` VALUES ('421123', '4211', '罗田县', null, '1', null);
INSERT INTO `district_code` VALUES ('522728', '5227', '罗甸县', null, '1', null);
INSERT INTO `district_code` VALUES ('460108', '4601', '美兰区', null, '1', null);
INSERT INTO `district_code` VALUES ('513436', '5134', '美姑县', null, '1', null);
INSERT INTO `district_code` VALUES ('230708', '2307', '美溪区', null, '1', null);
INSERT INTO `district_code` VALUES ('440229', '4402', '翁源县', null, '1', null);
INSERT INTO `district_code` VALUES ('150426', '1504', '翁牛特旗', null, '1', null);
INSERT INTO `district_code` VALUES ('350213', '3502', '翔安区', null, '1', null);
INSERT INTO `district_code` VALUES ('511502', '5115', '翠屏区', null, '1', null);
INSERT INTO `district_code` VALUES ('230706', '2307', '翠峦区', null, '1', null);
INSERT INTO `district_code` VALUES ('141022', '1410', '翼城县', null, '1', null);
INSERT INTO `district_code` VALUES ('610204', '6102', '耀州区', null, '1', null);
INSERT INTO `district_code` VALUES ('410302', '4103', '老城区', null, '1', null);
INSERT INTO `district_code` VALUES ('420682', '4206', '老河口市', null, '1', null);
INSERT INTO `district_code` VALUES ('210811', '2108', '老边区', null, '1', null);
INSERT INTO `district_code` VALUES ('430481', '4304', '耒阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('530926', '5309', '耿马傣族佤族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('542336', '5423', '聂拉木县', null, '1', null);
INSERT INTO `district_code` VALUES ('542424', '5424', '聂荣县', null, '1', null);
INSERT INTO `district_code` VALUES ('620923', '6209', '肃北蒙古族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('620721', '6207', '肃南裕固族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('130926', '1309', '肃宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('620902', '6209', '肃州区', null, '1', null);
INSERT INTO `district_code` VALUES ('231282', '2312', '肇东市', null, '1', null);
INSERT INTO `district_code` VALUES ('230621', '2306', '肇州县', null, '1', null);
INSERT INTO `district_code` VALUES ('230622', '2306', '肇源县', null, '1', null);
INSERT INTO `district_code` VALUES ('340122', '3401', '肥东县', null, '1', null);
INSERT INTO `district_code` VALUES ('130428', '1304', '肥乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('370983', '3709', '肥城市', null, '1', null);
INSERT INTO `district_code` VALUES ('340123', '3401', '肥西县', null, '1', null);
INSERT INTO `district_code` VALUES ('370284', '3702', '胶南市', null, '1', null);
INSERT INTO `district_code` VALUES ('370281', '3702', '胶州市', null, '1', null);
INSERT INTO `district_code` VALUES ('530522', '5305', '腾冲县', null, '1', null);
INSERT INTO `district_code` VALUES ('510302', '5103', '自流井区', null, '1', null);
INSERT INTO `district_code` VALUES ('220283', '2202', '舒兰市', null, '1', null);
INSERT INTO `district_code` VALUES ('341523', '3415', '舒城县', null, '1', null);
INSERT INTO `district_code` VALUES ('410481', '4104', '舞钢市', null, '1', null);
INSERT INTO `district_code` VALUES ('411121', '4111', '舞阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('623023', '6230', '舟曲县', null, '1', null);
INSERT INTO `district_code` VALUES ('510903', '5109', '船山区', null, '1', null);
INSERT INTO `district_code` VALUES ('220204', '2202', '船营区', null, '1', null);
INSERT INTO `district_code` VALUES ('450108', '4501', '良庆区', null, '1', null);
INSERT INTO `district_code` VALUES ('513333', '5133', '色达县', null, '1', null);
INSERT INTO `district_code` VALUES ('533103', '5331', '芒市', null, '1', null);
INSERT INTO `district_code` VALUES ('542129', '5421', '芒康县', null, '1', null);
INSERT INTO `district_code` VALUES ('350602', '3506', '芗城区', null, '1', null);
INSERT INTO `district_code` VALUES ('430102', '4301', '芙蓉区', null, '1', null);
INSERT INTO `district_code` VALUES ('340221', '3402', '芜湖县', null, '1', null);
INSERT INTO `district_code` VALUES ('370602', '3706', '芝罘区', null, '1', null);
INSERT INTO `district_code` VALUES ('511826', '5118', '芦山县', null, '1', null);
INSERT INTO `district_code` VALUES ('430203', '4302', '芦淞区', null, '1', null);
INSERT INTO `district_code` VALUES ('360323', '3603', '芦溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('140830', '1408', '芮城县', null, '1', null);
INSERT INTO `district_code` VALUES ('433124', '4331', '花垣县', null, '1', null);
INSERT INTO `district_code` VALUES ('340503', '3405', '花山区', null, '1', null);
INSERT INTO `district_code` VALUES ('520111', '5201', '花溪区', null, '1', null);
INSERT INTO `district_code` VALUES ('440114', '4401', '花都区', null, '1', null);
INSERT INTO `district_code` VALUES ('431228', '4312', '芷江侗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('330327', '3303', '苍南县', null, '1', null);
INSERT INTO `district_code` VALUES ('371324', '3713', '苍山县', null, '1', null);
INSERT INTO `district_code` VALUES ('450421', '4504', '苍梧县', null, '1', null);
INSERT INTO `district_code` VALUES ('510824', '5108', '苍溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('431003', '4310', '苏仙区', null, '1', null);
INSERT INTO `district_code` VALUES ('210111', '2101', '苏家屯区', null, '1', null);
INSERT INTO `district_code` VALUES ('152524', '1525', '苏尼特右旗', null, '1', null);
INSERT INTO `district_code` VALUES ('152523', '1525', '苏尼特左旗', null, '1', null);
INSERT INTO `district_code` VALUES ('513232', '5132', '若尔盖县', null, '1', null);
INSERT INTO `district_code` VALUES ('652824', '6528', '若羌县', null, '1', null);
INSERT INTO `district_code` VALUES ('653123', '6531', '英吉沙县', null, '1', null);
INSERT INTO `district_code` VALUES ('421124', '4211', '英山县', null, '1', null);
INSERT INTO `district_code` VALUES ('441881', '4418', '英德市', null, '1', null);
INSERT INTO `district_code` VALUES ('440902', '4409', '茂南区', null, '1', null);
INSERT INTO `district_code` VALUES ('513223', '5132', '茂县', null, '1', null);
INSERT INTO `district_code` VALUES ('440903', '4409', '茂港区', null, '1', null);
INSERT INTO `district_code` VALUES ('410926', '4109', '范县', null, '1', null);
INSERT INTO `district_code` VALUES ('230904', '2309', '茄子河区', null, '1', null);
INSERT INTO `district_code` VALUES ('420302', '4203', '茅箭区', null, '1', null);
INSERT INTO `district_code` VALUES ('371523', '3715', '茌平县', null, '1', null);
INSERT INTO `district_code` VALUES ('430224', '4302', '茶陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('421003', '4210', '荆州区', null, '1', null);
INSERT INTO `district_code` VALUES ('350304', '3503', '荔城区', null, '1', null);
INSERT INTO `district_code` VALUES ('522722', '5227', '荔波县', null, '1', null);
INSERT INTO `district_code` VALUES ('440103', '4401', '荔湾区', null, '1', null);
INSERT INTO `district_code` VALUES ('450331', '4503', '荔蒲县', null, '1', null);
INSERT INTO `district_code` VALUES ('510321', '5103', '荣县', null, '1', null);
INSERT INTO `district_code` VALUES ('371082', '3710', '荣成市', null, '1', null);
INSERT INTO `district_code` VALUES ('500226', '50', '荣昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('511822', '5118', '荥经县', null, '1', null);
INSERT INTO `district_code` VALUES ('410182', '4101', '荥阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('430202', '4302', '荷塘区', null, '1', null);
INSERT INTO `district_code` VALUES ('653125', '6531', '莎车县', null, '1', null);
INSERT INTO `district_code` VALUES ('371327', '3713', '莒南县', null, '1', null);
INSERT INTO `district_code` VALUES ('371122', '3711', '莒县', null, '1', null);
INSERT INTO `district_code` VALUES ('371522', '3715', '莘县', null, '1', null);
INSERT INTO `district_code` VALUES ('150722', '1507', '莫力达瓦达斡尔族自治旗', null, '1', null);
INSERT INTO `district_code` VALUES ('371202', '3712', '莱城区', null, '1', null);
INSERT INTO `district_code` VALUES ('370613', '3706', '莱山区', null, '1', null);
INSERT INTO `district_code` VALUES ('370683', '3706', '莱州市', null, '1', null);
INSERT INTO `district_code` VALUES ('370285', '3702', '莱西市', null, '1', null);
INSERT INTO `district_code` VALUES ('370682', '3706', '莱阳市', null, '1', null);
INSERT INTO `district_code` VALUES ('610104', '6101', '莲湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('360321', '3603', '莲花县', null, '1', null);
INSERT INTO `district_code` VALUES ('331102', '3311', '莲都区', null, '1', null);
INSERT INTO `district_code` VALUES ('410724', '4107', '获嘉县', null, '1', null);
INSERT INTO `district_code` VALUES ('230421', '2304', '萝北县', null, '1', null);
INSERT INTO `district_code` VALUES ('440116', '4401', '萝岗区', null, '1', null);
INSERT INTO `district_code` VALUES ('511322', '5113', '营山县', null, '1', null);
INSERT INTO `district_code` VALUES ('341322', '3413', '萧县', null, '1', null);
INSERT INTO `district_code` VALUES ('330109', '3301', '萧山区', null, '1', null);
INSERT INTO `district_code` VALUES ('542337', '5423', '萨嘎县', null, '1', null);
INSERT INTO `district_code` VALUES ('230602', '2306', '萨尔图区', null, '1', null);
INSERT INTO `district_code` VALUES ('542325', '5423', '萨迦县', null, '1', null);
INSERT INTO `district_code` VALUES ('341622', '3416', '蒙城县', null, '1', null);
INSERT INTO `district_code` VALUES ('450423', '4504', '蒙山县', null, '1', null);
INSERT INTO `district_code` VALUES ('532503', '5325', '蒙自市', null, '1', null);
INSERT INTO `district_code` VALUES ('371328', '3713', '蒙阴县', null, '1', null);
INSERT INTO `district_code` VALUES ('141033', '1410', '蒲县', null, '1', null);
INSERT INTO `district_code` VALUES ('610526', '6105', '蒲城县', null, '1', null);
INSERT INTO `district_code` VALUES ('510131', '5101', '蒲江县', null, '1', null);
INSERT INTO `district_code` VALUES ('430408', '4304', '蒸湘区', null, '1', null);
INSERT INTO `district_code` VALUES ('431127', '4311', '蓝山县', null, '1', null);
INSERT INTO `district_code` VALUES ('610122', '6101', '蓝田县', null, '1', null);
INSERT INTO `district_code` VALUES ('120225', '12', '蓟县', null, '1', null);
INSERT INTO `district_code` VALUES ('511323', '5113', '蓬安县', null, '1', null);
INSERT INTO `district_code` VALUES ('440703', '4407', '蓬江区', null, '1', null);
INSERT INTO `district_code` VALUES ('510921', '5109', '蓬溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('370684', '3706', '蓬莱市', null, '1', null);
INSERT INTO `district_code` VALUES ('130726', '1307', '蔚县', null, '1', null);
INSERT INTO `district_code` VALUES ('420114', '4201', '蔡甸区', null, '1', null);
INSERT INTO `district_code` VALUES ('350902', '3509', '蕉城区', null, '1', null);
INSERT INTO `district_code` VALUES ('441427', '4414', '蕉岭县', null, '1', null);
INSERT INTO `district_code` VALUES ('421126', '4211', '蕲春县', null, '1', null);
INSERT INTO `district_code` VALUES ('370403', '3704', '薛城区', null, '1', null);
INSERT INTO `district_code` VALUES ('130182', '1301', '藁城市', null, '1', null);
INSERT INTO `district_code` VALUES ('450422', '4504', '藤县', null, '1', null);
INSERT INTO `district_code` VALUES ('320505', '3205', '虎丘区', null, '1', null);
INSERT INTO `district_code` VALUES ('230381', '2303', '虎林市', null, '1', null);
INSERT INTO `district_code` VALUES ('411425', '4114', '虞城县', null, '1', null);
INSERT INTO `district_code` VALUES ('310109', '31', '虹口区', null, '1', null);
INSERT INTO `district_code` VALUES ('340303', '3403', '蚌山区', null, '1', null);
INSERT INTO `district_code` VALUES ('220281', '2202', '蛟河市', null, '1', null);
INSERT INTO `district_code` VALUES ('340104', '3401', '蜀山区', null, '1', null);
INSERT INTO `district_code` VALUES ('450404', '4504', '蝶山区', null, '1', null);
INSERT INTO `district_code` VALUES ('450224', '4502', '融安县', null, '1', null);
INSERT INTO `district_code` VALUES ('450225', '4502', '融水苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('130635', '1306', '蠡县', null, '1', null);
INSERT INTO `district_code` VALUES ('130125', '1301', '行唐县', null, '1', null);
INSERT INTO `district_code` VALUES ('430424', '4304', '衡东县', null, '1', null);
INSERT INTO `district_code` VALUES ('430422', '4304', '衡南县', null, '1', null);
INSERT INTO `district_code` VALUES ('430423', '4304', '衡山县', null, '1', null);
INSERT INTO `district_code` VALUES ('430421', '4304', '衡阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('330803', '3308', '衢江区', null, '1', null);
INSERT INTO `district_code` VALUES ('360902', '3609', '袁州区', null, '1', null);
INSERT INTO `district_code` VALUES ('130108', '1301', '裕华区', null, '1', null);
INSERT INTO `district_code` VALUES ('341503', '3415', '裕安区', null, '1', null);
INSERT INTO `district_code` VALUES ('654225', '6542', '裕民县', null, '1', null);
INSERT INTO `district_code` VALUES ('140423', '1404', '襄垣县', null, '1', null);
INSERT INTO `district_code` VALUES ('420602', '4206', '襄城区', null, '1', null);
INSERT INTO `district_code` VALUES ('411025', '4110', '襄城县', null, '1', null);
INSERT INTO `district_code` VALUES ('420607', '4206', '襄州区', null, '1', null);
INSERT INTO `district_code` VALUES ('141023', '1410', '襄汾县', null, '1', null);
INSERT INTO `district_code` VALUES ('211223', '2112', '西丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('152526', '1525', '西乌珠穆沁旗', null, '1', null);
INSERT INTO `district_code` VALUES ('610724', '6107', '西乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('450107', '4501', '西乡塘区', null, '1', null);
INSERT INTO `district_code` VALUES ('511325', '5113', '西充县', null, '1', null);
INSERT INTO `district_code` VALUES ('510403', '5104', '西区', null, '1', null);
INSERT INTO `district_code` VALUES ('411622', '4116', '西华县', null, '1', null);
INSERT INTO `district_code` VALUES ('640422', '6404', '西吉县', null, '1', null);
INSERT INTO `district_code` VALUES ('621225', '6212', '西和县', null, '1', null);
INSERT INTO `district_code` VALUES ('620104', '6201', '西固区', null, '1', null);
INSERT INTO `district_code` VALUES ('110102', '11', '西城区', null, '1', null);
INSERT INTO `district_code` VALUES ('420203', '4202', '西塞山区', null, '1', null);
INSERT INTO `district_code` VALUES ('640105', '6401', '西夏区', null, '1', null);
INSERT INTO `district_code` VALUES ('220403', '2204', '西安区', null, '1', null);
INSERT INTO `district_code` VALUES ('530112', '5301', '西山区', null, '1', null);
INSERT INTO `district_code` VALUES ('210203', '2102', '西岗区', null, '1', null);
INSERT INTO `district_code` VALUES ('411323', '4113', '西峡县', null, '1', null);
INSERT INTO `district_code` VALUES ('621002', '6210', '西峰区', null, '1', null);
INSERT INTO `district_code` VALUES ('410303', '4103', '西工区', null, '1', null);
INSERT INTO `district_code` VALUES ('210803', '2108', '西市区', null, '1', null);
INSERT INTO `district_code` VALUES ('411721', '4117', '西平县', null, '1', null);
INSERT INTO `district_code` VALUES ('513401', '5134', '西昌市', null, '1', null);
INSERT INTO `district_code` VALUES ('230705', '2307', '西林区', null, '1', null);
INSERT INTO `district_code` VALUES ('451030', '4510', '西林县', null, '1', null);
INSERT INTO `district_code` VALUES ('469031', '4690', '西沙群岛', null, '1', null);
INSERT INTO `district_code` VALUES ('330106', '3301', '西湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('532623', '5326', '西畴县', null, '1', null);
INSERT INTO `district_code` VALUES ('530829', '5308', '西盟佤族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('520402', '5204', '西秀区', null, '1', null);
INSERT INTO `district_code` VALUES ('420502', '4205', '西陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('120111', '12', '西青区', null, '1', null);
INSERT INTO `district_code` VALUES ('450804', '4508', '覃塘区', null, '1', null);
INSERT INTO `district_code` VALUES ('410802', '4108', '解放区', null, '1', null);
INSERT INTO `district_code` VALUES ('230604', '2306', '让胡路区', null, '1', null);
INSERT INTO `district_code` VALUES ('230281', '2302', '讷河市', null, '1', null);
INSERT INTO `district_code` VALUES ('411023', '4110', '许昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('350624', '3506', '诏安县', null, '1', null);
INSERT INTO `district_code` VALUES ('370782', '3707', '诸城市', null, '1', null);
INSERT INTO `district_code` VALUES ('330681', '3306', '诸暨市', null, '1', null);
INSERT INTO `district_code` VALUES ('211281', '2112', '调兵山市', null, '1', null);
INSERT INTO `district_code` VALUES ('340404', '3404', '谢家集区', null, '1', null);
INSERT INTO `district_code` VALUES ('542328', '5423', '谢通门县', null, '1', null);
INSERT INTO `district_code` VALUES ('341602', '3416', '谯城区', null, '1', null);
INSERT INTO `district_code` VALUES ('420625', '4206', '谷城县', null, '1', null);
INSERT INTO `district_code` VALUES ('450304', '4503', '象山区', null, '1', null);
INSERT INTO `district_code` VALUES ('330225', '3302', '象山县', null, '1', null);
INSERT INTO `district_code` VALUES ('451322', '4513', '象州县', null, '1', null);
INSERT INTO `district_code` VALUES ('522325', '5223', '贞丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('510303', '5103', '贡井区', null, '1', null);
INSERT INTO `district_code` VALUES ('542223', '5422', '贡嘎县', null, '1', null);
INSERT INTO `district_code` VALUES ('533324', '5333', '贡山独龙族怒族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('542123', '5421', '贡觉县', null, '1', null);
INSERT INTO `district_code` VALUES ('632525', '6325', '贵南县', null, '1', null);
INSERT INTO `district_code` VALUES ('522723', '5227', '贵定县', null, '1', null);
INSERT INTO `district_code` VALUES ('632523', '6325', '贵德县', null, '1', null);
INSERT INTO `district_code` VALUES ('341702', '3417', '贵池区', null, '1', null);
INSERT INTO `district_code` VALUES ('360681', '3606', '贵溪市', null, '1', null);
INSERT INTO `district_code` VALUES ('371325', '3713', '费县', null, '1', null);
INSERT INTO `district_code` VALUES ('640122', '6401', '贺兰县', null, '1', null);
INSERT INTO `district_code` VALUES ('320305', '3203', '贾汪区', null, '1', null);
INSERT INTO `district_code` VALUES ('511025', '5110', '资中县', null, '1', null);
INSERT INTO `district_code` VALUES ('431081', '4310', '资兴市', null, '1', null);
INSERT INTO `district_code` VALUES ('450329', '4503', '资源县', null, '1', null);
INSERT INTO `district_code` VALUES ('361028', '3610', '资溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('430902', '4309', '资阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('150105', '1501', '赛罕区', null, '1', null);
INSERT INTO `district_code` VALUES ('130129', '1301', '赞皇县', null, '1', null);
INSERT INTO `district_code` VALUES ('360721', '3607', '赣县', null, '1', null);
INSERT INTO `district_code` VALUES ('320721', '3207', '赣榆县', null, '1', null);
INSERT INTO `district_code` VALUES ('440802', '4408', '赤坎区', null, '1', null);
INSERT INTO `district_code` VALUES ('130732', '1307', '赤城县', null, '1', null);
INSERT INTO `district_code` VALUES ('421281', '4212', '赤壁市', null, '1', null);
INSERT INTO `district_code` VALUES ('520381', '5203', '赤水市', null, '1', null);
INSERT INTO `district_code` VALUES ('430903', '4309', '赫山区', null, '1', null);
INSERT INTO `district_code` VALUES ('520527', '5205', '赫章县', null, '1', null);
INSERT INTO `district_code` VALUES ('130133', '1301', '赵县', null, '1', null);
INSERT INTO `district_code` VALUES ('330602', '3306', '越城区', null, '1', null);
INSERT INTO `district_code` VALUES ('440104', '4401', '越秀区', null, '1', null);
INSERT INTO `district_code` VALUES ('513434', '5134', '越西县', null, '1', null);
INSERT INTO `district_code` VALUES ('130203', '1302', '路北区', null, '1', null);
INSERT INTO `district_code` VALUES ('130202', '1302', '路南区', null, '1', null);
INSERT INTO `district_code` VALUES ('331004', '3310', '路桥区', null, '1', null);
INSERT INTO `district_code` VALUES ('652822', '6528', '轮台县', null, '1', null);
INSERT INTO `district_code` VALUES ('220523', '2205', '辉南县', null, '1', null);
INSERT INTO `district_code` VALUES ('410782', '4107', '辉县市', null, '1', null);
INSERT INTO `district_code` VALUES ('130181', '1301', '辛集市', null, '1', null);
INSERT INTO `district_code` VALUES ('431223', '4312', '辰溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('542133', '5421', '边坝县', null, '1', null);
INSERT INTO `district_code` VALUES ('210122', '2101', '辽中县', null, '1', null);
INSERT INTO `district_code` VALUES ('211021', '2110', '辽阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('511721', '5117', '达县', null, '1', null);
INSERT INTO `district_code` VALUES ('650107', '6501', '达坂城区', null, '1', null);
INSERT INTO `district_code` VALUES ('540126', '5401', '达孜县', null, '1', null);
INSERT INTO `district_code` VALUES ('150223', '1502', '达尔罕茂明安联合旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150621', '1506', '达拉特旗', null, '1', null);
INSERT INTO `district_code` VALUES ('632624', '6326', '达日县', null, '1', null);
INSERT INTO `district_code` VALUES ('130283', '1302', '迁安市', null, '1', null);
INSERT INTO `district_code` VALUES ('130227', '1302', '迁西县', null, '1', null);
INSERT INTO `district_code` VALUES ('340802', '3408', '迎江区', null, '1', null);
INSERT INTO `district_code` VALUES ('140106', '1401', '迎泽区', null, '1', null);
INSERT INTO `district_code` VALUES ('130903', '1309', '运河区', null, '1', null);
INSERT INTO `district_code` VALUES ('360124', '3601', '进贤县', null, '1', null);
INSERT INTO `district_code` VALUES ('420525', '4205', '远安县', null, '1', null);
INSERT INTO `district_code` VALUES ('320703', '3207', '连云区', null, '1', null);
INSERT INTO `district_code` VALUES ('441826', '4418', '连南瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('350825', '3508', '连城县', null, '1', null);
INSERT INTO `district_code` VALUES ('211402', '2114', '连山区', null, '1', null);
INSERT INTO `district_code` VALUES ('441825', '4418', '连山壮族瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('441882', '4418', '连州市', null, '1', null);
INSERT INTO `district_code` VALUES ('441623', '4416', '连平县', null, '1', null);
INSERT INTO `district_code` VALUES ('350122', '3501', '连江县', null, '1', null);
INSERT INTO `district_code` VALUES ('623024', '6230', '迭部县', null, '1', null);
INSERT INTO `district_code` VALUES ('231123', '2311', '逊克县', null, '1', null);
INSERT INTO `district_code` VALUES ('220521', '2205', '通化县', null, '1', null);
INSERT INTO `district_code` VALUES ('421222', '4212', '通城县', null, '1', null);
INSERT INTO `district_code` VALUES ('421224', '4212', '通山县', null, '1', null);
INSERT INTO `district_code` VALUES ('511702', '5117', '通川区', null, '1', null);
INSERT INTO `district_code` VALUES ('110112', '11', '通州区', null, '1', null);
INSERT INTO `district_code` VALUES ('220822', '2208', '通榆县', null, '1', null);
INSERT INTO `district_code` VALUES ('511921', '5119', '通江县', null, '1', null);
INSERT INTO `district_code` VALUES ('230128', '2301', '通河县', null, '1', null);
INSERT INTO `district_code` VALUES ('530423', '5304', '通海县', null, '1', null);
INSERT INTO `district_code` VALUES ('621121', '6211', '通渭县', null, '1', null);
INSERT INTO `district_code` VALUES ('410222', '4102', '通许县', null, '1', null);
INSERT INTO `district_code` VALUES ('431230', '4312', '通道侗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('360827', '3608', '遂川县', null, '1', null);
INSERT INTO `district_code` VALUES ('411728', '4117', '遂平县', null, '1', null);
INSERT INTO `district_code` VALUES ('331123', '3311', '遂昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('440823', '4408', '遂溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('431124', '4311', '道县', null, '1', null);
INSERT INTO `district_code` VALUES ('230104', '2301', '道外区', null, '1', null);
INSERT INTO `district_code` VALUES ('513326', '5133', '道孚县', null, '1', null);
INSERT INTO `district_code` VALUES ('520325', '5203', '道真仡佬族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('230102', '2301', '道里区', null, '1', null);
INSERT INTO `district_code` VALUES ('520321', '5203', '遵义县', null, '1', null);
INSERT INTO `district_code` VALUES ('130281', '1302', '遵化市', null, '1', null);
INSERT INTO `district_code` VALUES ('411381', '4113', '邓州市', null, '1', null);
INSERT INTO `district_code` VALUES ('450109', '4501', '邕宁区', null, '1', null);
INSERT INTO `district_code` VALUES ('321003', '3210', '邗江区', null, '1', null);
INSERT INTO `district_code` VALUES ('510183', '5101', '邛崃市', null, '1', null);
INSERT INTO `district_code` VALUES ('130521', '1305', '邢台县', null, '1', null);
INSERT INTO `district_code` VALUES ('451026', '4510', '那坡县', null, '1', null);
INSERT INTO `district_code` VALUES ('542421', '5424', '那曲县', null, '1', null);
INSERT INTO `district_code` VALUES ('130402', '1304', '邯山区', null, '1', null);
INSERT INTO `district_code` VALUES ('130421', '1304', '邯郸县', null, '1', null);
INSERT INTO `district_code` VALUES ('130430', '1304', '邱县', null, '1', null);
INSERT INTO `district_code` VALUES ('320382', '3203', '邳州市', null, '1', null);
INSERT INTO `district_code` VALUES ('430521', '4305', '邵东县', null, '1', null);
INSERT INTO `district_code` VALUES ('350781', '3507', '邵武市', null, '1', null);
INSERT INTO `district_code` VALUES ('430523', '4305', '邵阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('370883', '3708', '邹城市', null, '1', null);
INSERT INTO `district_code` VALUES ('371626', '3716', '邹平县', null, '1', null);
INSERT INTO `district_code` VALUES ('511623', '5116', '邻水县', null, '1', null);
INSERT INTO `district_code` VALUES ('445322', '4453', '郁南县', null, '1', null);
INSERT INTO `district_code` VALUES ('140311', '1403', '郊区', null, '1', null);
INSERT INTO `district_code` VALUES ('341821', '3418', '郎溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('410425', '4104', '郏县', null, '1', null);
INSERT INTO `district_code` VALUES ('371725', '3717', '郓城县', null, '1', null);
INSERT INTO `district_code` VALUES ('420321', '4203', '郧县', null, '1', null);
INSERT INTO `district_code` VALUES ('420322', '4203', '郧西县', null, '1', null);
INSERT INTO `district_code` VALUES ('510124', '5101', '郫县', null, '1', null);
INSERT INTO `district_code` VALUES ('371322', '3713', '郯城县', null, '1', null);
INSERT INTO `district_code` VALUES ('411625', '4116', '郸城县', null, '1', null);
INSERT INTO `district_code` VALUES ('632822', '6328', '都兰县', null, '1', null);
INSERT INTO `district_code` VALUES ('522701', '5227', '都匀市', null, '1', null);
INSERT INTO `district_code` VALUES ('451228', '4512', '都安瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('360428', '3604', '都昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('510181', '5101', '都江堰市', null, '1', null);
INSERT INTO `district_code` VALUES ('411103', '4111', '郾城区', null, '1', null);
INSERT INTO `district_code` VALUES ('150723', '1507', '鄂伦春自治旗', null, '1', null);
INSERT INTO `district_code` VALUES ('420704', '4207', '鄂城区', null, '1', null);
INSERT INTO `district_code` VALUES ('150623', '1506', '鄂托克前旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150624', '1506', '鄂托克旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150724', '1507', '鄂温克族自治旗', null, '1', null);
INSERT INTO `district_code` VALUES ('371726', '3717', '鄄城县', null, '1', null);
INSERT INTO `district_code` VALUES ('330212', '3302', '鄞州区', null, '1', null);
INSERT INTO `district_code` VALUES ('411024', '4110', '鄢陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('652122', '6521', '鄯善县', null, '1', null);
INSERT INTO `district_code` VALUES ('361128', '3611', '鄱阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('500242', '50', '酉阳土家族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('430281', '4302', '醴陵市', null, '1', null);
INSERT INTO `district_code` VALUES ('330703', '3307', '金东区', null, '1', null);
INSERT INTO `district_code` VALUES ('370828', '3708', '金乡县', null, '1', null);
INSERT INTO `district_code` VALUES ('640106', '6401', '金凤区', null, '1', null);
INSERT INTO `district_code` VALUES ('511113', '5111', '金口河区', null, '1', null);
INSERT INTO `district_code` VALUES ('610303', '6103', '金台区', null, '1', null);
INSERT INTO `district_code` VALUES ('320482', '3204', '金坛市', null, '1', null);
INSERT INTO `district_code` VALUES ('451202', '4512', '金城江区', null, '1', null);
INSERT INTO `district_code` VALUES ('510121', '5101', '金堂县', null, '1', null);
INSERT INTO `district_code` VALUES ('620921', '6209', '金塔县', null, '1', null);
INSERT INTO `district_code` VALUES ('341502', '3415', '金安区', null, '1', null);
INSERT INTO `district_code` VALUES ('340502', '3405', '金家庄区', null, '1', null);
INSERT INTO `district_code` VALUES ('341524', '3415', '金寨县', null, '1', null);
INSERT INTO `district_code` VALUES ('310116', '31', '金山区', null, '1', null);
INSERT INTO `district_code` VALUES ('230709', '2307', '金山屯区', null, '1', null);
INSERT INTO `district_code` VALUES ('620302', '6203', '金川区', null, '1', null);
INSERT INTO `district_code` VALUES ('513226', '5132', '金川县', null, '1', null);
INSERT INTO `district_code` VALUES ('210213', '2102', '金州区', null, '1', null);
INSERT INTO `district_code` VALUES ('440511', '4405', '金平区', null, '1', null);
INSERT INTO `district_code` VALUES ('532530', '5325', '金平苗族瑶族傣族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('410211', '4102', '金明区', null, '1', null);
INSERT INTO `district_code` VALUES ('410105', '4101', '金水区', null, '1', null);
INSERT INTO `district_code` VALUES ('520523', '5205', '金沙县', null, '1', null);
INSERT INTO `district_code` VALUES ('320831', '3208', '金湖县', null, '1', null);
INSERT INTO `district_code` VALUES ('440404', '4404', '金湾区', null, '1', null);
INSERT INTO `district_code` VALUES ('361027', '3610', '金溪县', null, '1', null);
INSERT INTO `district_code` VALUES ('510106', '5101', '金牛区', null, '1', null);
INSERT INTO `district_code` VALUES ('451324', '4513', '金秀瑶族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('350527', '3505', '金门县', null, '1', null);
INSERT INTO `district_code` VALUES ('320504', '3205', '金阊区', null, '1', null);
INSERT INTO `district_code` VALUES ('513430', '5134', '金阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('520201', '5202', '钟山区', null, '1', null);
INSERT INTO `district_code` VALUES ('451122', '4511', '钟山县', null, '1', null);
INSERT INTO `district_code` VALUES ('320404', '3204', '钟楼区', null, '1', null);
INSERT INTO `district_code` VALUES ('420881', '4208', '钟祥市', null, '1', null);
INSERT INTO `district_code` VALUES ('371203', '3712', '钢城区', null, '1', null);
INSERT INTO `district_code` VALUES ('450703', '4507', '钦北区', null, '1', null);
INSERT INTO `district_code` VALUES ('450702', '4507', '钦南区', null, '1', null);
INSERT INTO `district_code` VALUES ('210302', '2103', '铁东区', null, '1', null);
INSERT INTO `district_code` VALUES ('230781', '2307', '铁力市', null, '1', null);
INSERT INTO `district_code` VALUES ('420205', '4202', '铁山区', null, '1', null);
INSERT INTO `district_code` VALUES ('450512', '4505', '铁山港区', null, '1', null);
INSERT INTO `district_code` VALUES ('211221', '2112', '铁岭县', null, '1', null);
INSERT INTO `district_code` VALUES ('210106', '2101', '铁西区', null, '1', null);
INSERT INTO `district_code` VALUES ('230204', '2302', '铁锋区', null, '1', null);
INSERT INTO `district_code` VALUES ('361124', '3611', '铅山县', null, '1', null);
INSERT INTO `district_code` VALUES ('340702', '3407', '铜官山区', null, '1', null);
INSERT INTO `district_code` VALUES ('320312', '3203', '铜山区', null, '1', null);
INSERT INTO `district_code` VALUES ('500224', '50', '铜梁县', null, '1', null);
INSERT INTO `district_code` VALUES ('340721', '3407', '铜陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('360926', '3609', '铜鼓县', null, '1', null);
INSERT INTO `district_code` VALUES ('211202', '2112', '银州区', null, '1', null);
INSERT INTO `district_code` VALUES ('450503', '4505', '银海区', null, '1', null);
INSERT INTO `district_code` VALUES ('542232', '5422', '错那县', null, '1', null);
INSERT INTO `district_code` VALUES ('320205', '3202', '锡山区', null, '1', null);
INSERT INTO `district_code` VALUES ('152502', '1525', '锡林浩特市', null, '1', null);
INSERT INTO `district_code` VALUES ('522628', '5226', '锦屏县', null, '1', null);
INSERT INTO `district_code` VALUES ('510104', '5101', '锦江区', null, '1', null);
INSERT INTO `district_code` VALUES ('621027', '6210', '镇原县', null, '1', null);
INSERT INTO `district_code` VALUES ('610927', '6109', '镇坪县', null, '1', null);
INSERT INTO `district_code` VALUES ('520423', '5204', '镇宁布依族苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('611025', '6110', '镇安县', null, '1', null);
INSERT INTO `district_code` VALUES ('610728', '6107', '镇巴县', null, '1', null);
INSERT INTO `district_code` VALUES ('411324', '4113', '镇平县', null, '1', null);
INSERT INTO `district_code` VALUES ('530924', '5309', '镇康县', null, '1', null);
INSERT INTO `district_code` VALUES ('530825', '5308', '镇沅彝族哈尼族拉祜族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('330211', '3302', '镇海区', null, '1', null);
INSERT INTO `district_code` VALUES ('220821', '2208', '镇赉县', null, '1', null);
INSERT INTO `district_code` VALUES ('522625', '5226', '镇远县', null, '1', null);
INSERT INTO `district_code` VALUES ('530627', '5306', '镇雄县', null, '1', null);
INSERT INTO `district_code` VALUES ('340202', '3402', '镜湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('152528', '1525', '镶黄旗', null, '1', null);
INSERT INTO `district_code` VALUES ('340121', '3401', '长丰县', null, '1', null);
INSERT INTO `district_code` VALUES ('350182', '3501', '长乐市', null, '1', null);
INSERT INTO `district_code` VALUES ('330522', '3305', '长兴县', null, '1', null);
INSERT INTO `district_code` VALUES ('410728', '4107', '长垣县', null, '1', null);
INSERT INTO `district_code` VALUES ('140428', '1404', '长子县', null, '1', null);
INSERT INTO `district_code` VALUES ('310105', '31', '长宁区', null, '1', null);
INSERT INTO `district_code` VALUES ('511524', '5115', '长宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('130102', '1301', '长安区', null, '1', null);
INSERT INTO `district_code` VALUES ('500115', '50', '长寿区', null, '1', null);
INSERT INTO `district_code` VALUES ('370634', '3706', '长岛县', null, '1', null);
INSERT INTO `district_code` VALUES ('220722', '2207', '长岭县', null, '1', null);
INSERT INTO `district_code` VALUES ('610428', '6104', '长武县', null, '1', null);
INSERT INTO `district_code` VALUES ('350821', '3508', '长汀县', null, '1', null);
INSERT INTO `district_code` VALUES ('430121', '4301', '长沙县', null, '1', null);
INSERT INTO `district_code` VALUES ('140421', '1404', '长治县', null, '1', null);
INSERT INTO `district_code` VALUES ('350625', '3506', '长泰县', null, '1', null);
INSERT INTO `district_code` VALUES ('450405', '4504', '长洲区', null, '1', null);
INSERT INTO `district_code` VALUES ('210224', '2102', '长海县', null, '1', null);
INSERT INTO `district_code` VALUES ('370113', '3701', '长清区', null, '1', null);
INSERT INTO `district_code` VALUES ('220623', '2206', '长白朝鲜族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('411082', '4110', '长葛市', null, '1', null);
INSERT INTO `district_code` VALUES ('420528', '4205', '长阳土家族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('522729', '5227', '长顺县', null, '1', null);
INSERT INTO `district_code` VALUES ('110109', '11', '门头沟区', null, '1', null);
INSERT INTO `district_code` VALUES ('632221', '6322', '门源回族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('310112', '31', '闵行区', null, '1', null);
INSERT INTO `district_code` VALUES ('310108', '31', '闸北区', null, '1', null);
INSERT INTO `district_code` VALUES ('140823', '1408', '闻喜县', null, '1', null);
INSERT INTO `district_code` VALUES ('350121', '3501', '闽侯县', null, '1', null);
INSERT INTO `district_code` VALUES ('350124', '3501', '闽清县', null, '1', null);
INSERT INTO `district_code` VALUES ('511381', '5113', '阆中市', null, '1', null);
INSERT INTO `district_code` VALUES ('610114', '6101', '阎良区', null, '1', null);
INSERT INTO `district_code` VALUES ('341225', '3412', '阜南县', null, '1', null);
INSERT INTO `district_code` VALUES ('131128', '1311', '阜城县', null, '1', null);
INSERT INTO `district_code` VALUES ('320923', '3209', '阜宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('130624', '1306', '阜平县', null, '1', null);
INSERT INTO `district_code` VALUES ('652302', '6523', '阜康市', null, '1', null);
INSERT INTO `district_code` VALUES ('210921', '2109', '阜新蒙古族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('450603', '4506', '防城区', null, '1', null);
INSERT INTO `district_code` VALUES ('441723', '4417', '阳东县', null, '1', null);
INSERT INTO `district_code` VALUES ('371622', '3716', '阳信县', null, '1', null);
INSERT INTO `district_code` VALUES ('130727', '1307', '阳原县', null, '1', null);
INSERT INTO `district_code` VALUES ('140522', '1405', '阳城县', null, '1', null);
INSERT INTO `district_code` VALUES ('441823', '4418', '阳山县', null, '1', null);
INSERT INTO `district_code` VALUES ('420222', '4202', '阳新县', null, '1', null);
INSERT INTO `district_code` VALUES ('231003', '2310', '阳明区', null, '1', null);
INSERT INTO `district_code` VALUES ('441781', '4417', '阳春市', null, '1', null);
INSERT INTO `district_code` VALUES ('140122', '1401', '阳曲县', null, '1', null);
INSERT INTO `district_code` VALUES ('450321', '4503', '阳朔县', null, '1', null);
INSERT INTO `district_code` VALUES ('441721', '4417', '阳西县', null, '1', null);
INSERT INTO `district_code` VALUES ('371521', '3715', '阳谷县', null, '1', null);
INSERT INTO `district_code` VALUES ('140221', '1402', '阳高县', null, '1', null);
INSERT INTO `district_code` VALUES ('620924', '6209', '阿克塞哈萨克族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('652901', '6529', '阿克苏市', null, '1', null);
INSERT INTO `district_code` VALUES ('653022', '6530', '阿克陶县', null, '1', null);
INSERT INTO `district_code` VALUES ('654301', '6543', '阿勒泰市', null, '1', null);
INSERT INTO `district_code` VALUES ('653023', '6530', '阿合奇县', null, '1', null);
INSERT INTO `district_code` VALUES ('653001', '6530', '阿图什市', null, '1', null);
INSERT INTO `district_code` VALUES ('513231', '5132', '阿坝县', null, '1', null);
INSERT INTO `district_code` VALUES ('230112', '2301', '阿城区', null, '1', null);
INSERT INTO `district_code` VALUES ('152202', '1522', '阿尔山市', null, '1', null);
INSERT INTO `district_code` VALUES ('152522', '1525', '阿巴嘎旗', null, '1', null);
INSERT INTO `district_code` VALUES ('152922', '1529', '阿拉善右旗', null, '1', null);
INSERT INTO `district_code` VALUES ('152921', '1529', '阿拉善左旗', null, '1', null);
INSERT INTO `district_code` VALUES ('659002', '6590', '阿拉尔市', null, '1', null);
INSERT INTO `district_code` VALUES ('652928', '6529', '阿瓦提县', null, '1', null);
INSERT INTO `district_code` VALUES ('150721', '1507', '阿荣旗', null, '1', null);
INSERT INTO `district_code` VALUES ('150421', '1504', '阿鲁科尔沁旗', null, '1', null);
INSERT INTO `district_code` VALUES ('441581', '4415', '陆丰市', null, '1', null);
INSERT INTO `district_code` VALUES ('450922', '4509', '陆川县', null, '1', null);
INSERT INTO `district_code` VALUES ('441523', '4415', '陆河县', null, '1', null);
INSERT INTO `district_code` VALUES ('530322', '5303', '陆良县', null, '1', null);
INSERT INTO `district_code` VALUES ('610327', '6103', '陇县', null, '1', null);
INSERT INTO `district_code` VALUES ('533124', '5331', '陇川县', null, '1', null);
INSERT INTO `district_code` VALUES ('621122', '6211', '陇西县', null, '1', null);
INSERT INTO `district_code` VALUES ('610304', '6103', '陈仓区', null, '1', null);
INSERT INTO `district_code` VALUES ('150725', '1507', '陈巴尔虎旗', null, '1', null);
INSERT INTO `district_code` VALUES ('411222', '4112', '陕县', null, '1', null);
INSERT INTO `district_code` VALUES ('371421', '3714', '陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('140524', '1405', '陵川县', null, '1', null);
INSERT INTO `district_code` VALUES ('469028', '4690', '陵水黎族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('130825', '1308', '隆化县', null, '1', null);
INSERT INTO `district_code` VALUES ('430524', '4305', '隆回县', null, '1', null);
INSERT INTO `district_code` VALUES ('542231', '5422', '隆子县', null, '1', null);
INSERT INTO `district_code` VALUES ('450123', '4501', '隆安县', null, '1', null);
INSERT INTO `district_code` VALUES ('130525', '1305', '隆尧县', null, '1', null);
INSERT INTO `district_code` VALUES ('640423', '6404', '隆德县', null, '1', null);
INSERT INTO `district_code` VALUES ('511028', '5110', '隆昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('451031', '4510', '隆林各族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('530502', '5305', '隆阳区', null, '1', null);
INSERT INTO `district_code` VALUES ('421321', '4213', '随县', null, '1', null);
INSERT INTO `district_code` VALUES ('141031', '1410', '隰县', null, '1', null);
INSERT INTO `district_code` VALUES ('610113', '6101', '雁塔区', null, '1', null);
INSERT INTO `district_code` VALUES ('450311', '4503', '雁山区', null, '1', null);
INSERT INTO `district_code` VALUES ('430406', '4304', '雁峰区', null, '1', null);
INSERT INTO `district_code` VALUES ('512002', '5120', '雁江区', null, '1', null);
INSERT INTO `district_code` VALUES ('130638', '1306', '雄县', null, '1', null);
INSERT INTO `district_code` VALUES ('513325', '5133', '雅江县', null, '1', null);
INSERT INTO `district_code` VALUES ('150902', '1509', '集宁区', null, '1', null);
INSERT INTO `district_code` VALUES ('220582', '2205', '集安市', null, '1', null);
INSERT INTO `district_code` VALUES ('350211', '3502', '集美区', null, '1', null);
INSERT INTO `district_code` VALUES ('230521', '2305', '集贤县', null, '1', null);
INSERT INTO `district_code` VALUES ('511802', '5118', '雨城区', null, '1', null);
INSERT INTO `district_code` VALUES ('340504', '3405', '雨山区', null, '1', null);
INSERT INTO `district_code` VALUES ('430302', '4303', '雨湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('430111', '4301', '雨花区', null, '1', null);
INSERT INTO `district_code` VALUES ('320114', '3201', '雨花台区', null, '1', null);
INSERT INTO `district_code` VALUES ('431102', '4311', '零陵区', null, '1', null);
INSERT INTO `district_code` VALUES ('522634', '5226', '雷山县', null, '1', null);
INSERT INTO `district_code` VALUES ('440882', '4408', '雷州市', null, '1', null);
INSERT INTO `district_code` VALUES ('513437', '5134', '雷波县', null, '1', null);
INSERT INTO `district_code` VALUES ('654023', '6540', '霍城县', null, '1', null);
INSERT INTO `district_code` VALUES ('341525', '3415', '霍山县', null, '1', null);
INSERT INTO `district_code` VALUES ('141082', '1410', '霍州市', null, '1', null);
INSERT INTO `district_code` VALUES ('150581', '1505', '霍林郭勒市', null, '1', null);
INSERT INTO `district_code` VALUES ('341522', '3415', '霍邱县', null, '1', null);
INSERT INTO `district_code` VALUES ('440803', '4408', '霞山区', null, '1', null);
INSERT INTO `district_code` VALUES ('350921', '3509', '霞浦县', null, '1', null);
INSERT INTO `district_code` VALUES ('131081', '1310', '霸州市', null, '1', null);
INSERT INTO `district_code` VALUES ('360104', '3601', '青云谱区', null, '1', null);
INSERT INTO `district_code` VALUES ('231223', '2312', '青冈县', null, '1', null);
INSERT INTO `district_code` VALUES ('360803', '3608', '青原区', null, '1', null);
INSERT INTO `district_code` VALUES ('130922', '1309', '青县', null, '1', null);
INSERT INTO `district_code` VALUES ('150204', '1502', '青山区', null, '1', null);
INSERT INTO `district_code` VALUES ('360111', '3601', '青山湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('510822', '5108', '青川县', null, '1', null);
INSERT INTO `district_code` VALUES ('370781', '3707', '青州市', null, '1', null);
INSERT INTO `district_code` VALUES ('654325', '6543', '青河县', null, '1', null);
INSERT INTO `district_code` VALUES ('310118', '31', '青浦区', null, '1', null);
INSERT INTO `district_code` VALUES ('331121', '3311', '青田县', null, '1', null);
INSERT INTO `district_code` VALUES ('510113', '5101', '青白江区', null, '1', null);
INSERT INTO `district_code` VALUES ('511425', '5114', '青神县', null, '1', null);
INSERT INTO `district_code` VALUES ('450103', '4501', '青秀区', null, '1', null);
INSERT INTO `district_code` VALUES ('510105', '5101', '青羊区', null, '1', null);
INSERT INTO `district_code` VALUES ('640381', '6403', '青铜峡市', null, '1', null);
INSERT INTO `district_code` VALUES ('341723', '3417', '青阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('130321', '1303', '青龙满族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('220622', '2206', '靖宇县', null, '1', null);
INSERT INTO `district_code` VALUES ('360925', '3609', '靖安县', null, '1', null);
INSERT INTO `district_code` VALUES ('431229', '4312', '靖州苗族侗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('321282', '3212', '靖江市', null, '1', null);
INSERT INTO `district_code` VALUES ('451025', '4510', '靖西县', null, '1', null);
INSERT INTO `district_code` VALUES ('610824', '6108', '靖边县', null, '1', null);
INSERT INTO `district_code` VALUES ('620421', '6204', '靖远县', null, '1', null);
INSERT INTO `district_code` VALUES ('140926', '1409', '静乐县', null, '1', null);
INSERT INTO `district_code` VALUES ('620826', '6208', '静宁县', null, '1', null);
INSERT INTO `district_code` VALUES ('310106', '31', '静安区', null, '1', null);
INSERT INTO `district_code` VALUES ('120223', '12', '静海县', null, '1', null);
INSERT INTO `district_code` VALUES ('542525', '5425', '革吉县', null, '1', null);
INSERT INTO `district_code` VALUES ('610581', '6105', '韩城市', null, '1', null);
INSERT INTO `district_code` VALUES ('430382', '4303', '韶山市', null, '1', null);
INSERT INTO `district_code` VALUES ('411681', '4116', '项城市', null, '1', null);
INSERT INTO `district_code` VALUES ('110113', '11', '顺义区', null, '1', null);
INSERT INTO `district_code` VALUES ('210411', '2104', '顺城区', null, '1', null);
INSERT INTO `district_code` VALUES ('130636', '1306', '顺平县', null, '1', null);
INSERT INTO `district_code` VALUES ('511302', '5113', '顺庆区', null, '1', null);
INSERT INTO `district_code` VALUES ('440606', '4406', '顺德区', null, '1', null);
INSERT INTO `district_code` VALUES ('350721', '3507', '顺昌县', null, '1', null);
INSERT INTO `district_code` VALUES ('410203', '4102', '顺河回族区', null, '1', null);
INSERT INTO `district_code` VALUES ('341226', '3412', '颍上县', null, '1', null);
INSERT INTO `district_code` VALUES ('341203', '3412', '颍东区', null, '1', null);
INSERT INTO `district_code` VALUES ('341202', '3412', '颍州区', null, '1', null);
INSERT INTO `district_code` VALUES ('341204', '3412', '颍泉区', null, '1', null);
INSERT INTO `district_code` VALUES ('150784', '1507', '额尔古纳市', null, '1', null);
INSERT INTO `district_code` VALUES ('654221', '6542', '额敏县', null, '1', null);
INSERT INTO `district_code` VALUES ('152923', '1529', '额济纳旗', null, '1', null);
INSERT INTO `district_code` VALUES ('445122', '4451', '饶平县', null, '1', null);
INSERT INTO `district_code` VALUES ('230524', '2305', '饶河县', null, '1', null);
INSERT INTO `district_code` VALUES ('131124', '1311', '饶阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('130433', '1304', '馆陶县', null, '1', null);
INSERT INTO `district_code` VALUES ('230110', '2301', '香坊区', null, '1', null);
INSERT INTO `district_code` VALUES ('533421', '5334', '香格里拉县', null, '1', null);
INSERT INTO `district_code` VALUES ('131024', '1310', '香河县', null, '1', null);
INSERT INTO `district_code` VALUES ('440402', '4404', '香洲区', null, '1', null);
INSERT INTO `district_code` VALUES ('532625', '5326', '马关县', null, '1', null);
INSERT INTO `district_code` VALUES ('513229', '5132', '马尔康县', null, '1', null);
INSERT INTO `district_code` VALUES ('350105', '3501', '马尾区', null, '1', null);
INSERT INTO `district_code` VALUES ('450124', '4501', '马山县', null, '1', null);
INSERT INTO `district_code` VALUES ('410804', '4108', '马村区', null, '1', null);
INSERT INTO `district_code` VALUES ('511133', '5111', '马边彝族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('530321', '5303', '马龙县', null, '1', null);
INSERT INTO `district_code` VALUES ('411702', '4117', '驿城区', null, '1', null);
INSERT INTO `district_code` VALUES ('511525', '5115', '高县', null, '1', null);
INSERT INTO `district_code` VALUES ('620724', '6207', '高台县', null, '1', null);
INSERT INTO `district_code` VALUES ('371526', '3715', '高唐县', null, '1', null);
INSERT INTO `district_code` VALUES ('511303', '5113', '高坪区', null, '1', null);
INSERT INTO `district_code` VALUES ('360983', '3609', '高安市', null, '1', null);
INSERT INTO `district_code` VALUES ('370785', '3707', '高密市', null, '1', null);
INSERT INTO `district_code` VALUES ('440981', '4409', '高州市', null, '1', null);
INSERT INTO `district_code` VALUES ('140581', '1405', '高平市', null, '1', null);
INSERT INTO `district_code` VALUES ('440608', '4406', '高明区', null, '1', null);
INSERT INTO `district_code` VALUES ('320125', '3201', '高淳县', null, '1', null);
INSERT INTO `district_code` VALUES ('321203', '3212', '高港区', null, '1', null);
INSERT INTO `district_code` VALUES ('130684', '1306', '高碑店市', null, '1', null);
INSERT INTO `district_code` VALUES ('441283', '4412', '高要市', null, '1', null);
INSERT INTO `district_code` VALUES ('130127', '1301', '高邑县', null, '1', null);
INSERT INTO `district_code` VALUES ('321084', '3210', '高邮市', null, '1', null);
INSERT INTO `district_code` VALUES ('130628', '1306', '高阳县', null, '1', null);
INSERT INTO `district_code` VALUES ('610126', '6101', '高陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('370322', '3703', '高青县', null, '1', null);
INSERT INTO `district_code` VALUES ('130434', '1304', '魏县', null, '1', null);
INSERT INTO `district_code` VALUES ('411002', '4110', '魏都区', null, '1', null);
INSERT INTO `district_code` VALUES ('370827', '3708', '鱼台县', null, '1', null);
INSERT INTO `district_code` VALUES ('450203', '4502', '鱼峰区', null, '1', null);
INSERT INTO `district_code` VALUES ('410423', '4104', '鲁山县', null, '1', null);
INSERT INTO `district_code` VALUES ('530621', '5306', '鲁甸县', null, '1', null);
INSERT INTO `district_code` VALUES ('210804', '2108', '鲅鱼圈区', null, '1', null);
INSERT INTO `district_code` VALUES ('350502', '3505', '鲤城区', null, '1', null);
INSERT INTO `district_code` VALUES ('340207', '3402', '鸠江区', null, '1', null);
INSERT INTO `district_code` VALUES ('230321', '2303', '鸡东县', null, '1', null);
INSERT INTO `district_code` VALUES ('230302', '2303', '鸡冠区', null, '1', null);
INSERT INTO `district_code` VALUES ('130431', '1304', '鸡泽县', null, '1', null);
INSERT INTO `district_code` VALUES ('431202', '4312', '鹤城区', null, '1', null);
INSERT INTO `district_code` VALUES ('410602', '4106', '鹤山区', null, '1', null);
INSERT INTO `district_code` VALUES ('440784', '4407', '鹤山市', null, '1', null);
INSERT INTO `district_code` VALUES ('422828', '4228', '鹤峰县', null, '1', null);
INSERT INTO `district_code` VALUES ('532932', '5329', '鹤庆县', null, '1', null);
INSERT INTO `district_code` VALUES ('130804', '1308', '鹰手营子矿区', null, '1', null);
INSERT INTO `district_code` VALUES ('330302', '3303', '鹿城区', null, '1', null);
INSERT INTO `district_code` VALUES ('450223', '4502', '鹿寨县', null, '1', null);
INSERT INTO `district_code` VALUES ('130185', '1301', '鹿泉市', null, '1', null);
INSERT INTO `district_code` VALUES ('411628', '4116', '鹿邑县', null, '1', null);
INSERT INTO `district_code` VALUES ('530302', '5303', '麒麟区', null, '1', null);
INSERT INTO `district_code` VALUES ('610329', '6103', '麟游县', null, '1', null);
INSERT INTO `district_code` VALUES ('653127', '6531', '麦盖提县', null, '1', null);
INSERT INTO `district_code` VALUES ('620503', '6205', '麦积区', null, '1', null);
INSERT INTO `district_code` VALUES ('421181', '4211', '麻城市', null, '1', null);
INSERT INTO `district_code` VALUES ('230307', '2303', '麻山区', null, '1', null);
INSERT INTO `district_code` VALUES ('532624', '5326', '麻栗坡县', null, '1', null);
INSERT INTO `district_code` VALUES ('522635', '5226', '麻江县', null, '1', null);
INSERT INTO `district_code` VALUES ('440811', '4408', '麻章区', null, '1', null);
INSERT INTO `district_code` VALUES ('431226', '4312', '麻阳苗族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('440112', '4401', '黄埔区', null, '1', null);
INSERT INTO `district_code` VALUES ('341003', '3410', '黄山区', null, '1', null);
INSERT INTO `district_code` VALUES ('370211', '3702', '黄岛区', null, '1', null);
INSERT INTO `district_code` VALUES ('331003', '3310', '黄岩区', null, '1', null);
INSERT INTO `district_code` VALUES ('421102', '4211', '黄州区', null, '1', null);
INSERT INTO `district_code` VALUES ('522622', '5226', '黄平县', null, '1', null);
INSERT INTO `district_code` VALUES ('421127', '4211', '黄梅县', null, '1', null);
INSERT INTO `district_code` VALUES ('310101', '31', '黄浦区', null, '1', null);
INSERT INTO `district_code` VALUES ('420202', '4202', '黄石港区', null, '1', null);
INSERT INTO `district_code` VALUES ('420116', '4201', '黄陂区', null, '1', null);
INSERT INTO `district_code` VALUES ('610632', '6106', '黄陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('130983', '1309', '黄骅市', null, '1', null);
INSERT INTO `district_code` VALUES ('610631', '6106', '黄龙县', null, '1', null);
INSERT INTO `district_code` VALUES ('140426', '1404', '黎城县', null, '1', null);
INSERT INTO `district_code` VALUES ('361022', '3610', '黎川县', null, '1', null);
INSERT INTO `district_code` VALUES ('522631', '5226', '黎平县', null, '1', null);
INSERT INTO `district_code` VALUES ('210726', '2107', '黑山县', null, '1', null);
INSERT INTO `district_code` VALUES ('513228', '5132', '黑水县', null, '1', null);
INSERT INTO `district_code` VALUES ('500114', '50', '黔江区', null, '1', null);
INSERT INTO `district_code` VALUES ('520522', '5205', '黔西县', null, '1', null);
INSERT INTO `district_code` VALUES ('341023', '3410', '黟县', null, '1', null);
INSERT INTO `district_code` VALUES ('430703', '4307', '鼎城区', null, '1', null);
INSERT INTO `district_code` VALUES ('441203', '4412', '鼎湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('320106', '3201', '鼓楼区', null, '1', null);
INSERT INTO `district_code` VALUES ('371425', '3714', '齐河县', null, '1', null);
INSERT INTO `district_code` VALUES ('222405', '2224', '龙井市', null, '1', null);
INSERT INTO `district_code` VALUES ('410202', '4102', '龙亭区', null, '1', null);
INSERT INTO `district_code` VALUES ('230603', '2306', '龙凤区', null, '1', null);
INSERT INTO `district_code` VALUES ('460106', '4601', '龙华区', null, '1', null);
INSERT INTO `district_code` VALUES ('360727', '3607', '龙南县', null, '1', null);
INSERT INTO `district_code` VALUES ('370681', '3706', '龙口市', null, '1', null);
INSERT INTO `district_code` VALUES ('211303', '2113', '龙城区', null, '1', null);
INSERT INTO `district_code` VALUES ('340302', '3403', '龙子湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('410506', '4105', '龙安区', null, '1', null);
INSERT INTO `district_code` VALUES ('220402', '2204', '龙山区', null, '1', null);
INSERT INTO `district_code` VALUES ('433130', '4331', '龙山县', null, '1', null);
INSERT INTO `district_code` VALUES ('440307', '4403', '龙岗区', null, '1', null);
INSERT INTO `district_code` VALUES ('441622', '4416', '龙川县', null, '1', null);
INSERT INTO `district_code` VALUES ('451423', '4514', '龙州县', null, '1', null);
INSERT INTO `district_code` VALUES ('350603', '3506', '龙文区', null, '1', null);
INSERT INTO `district_code` VALUES ('230221', '2302', '龙江县', null, '1', null);
INSERT INTO `district_code` VALUES ('230202', '2302', '龙沙区', null, '1', null);
INSERT INTO `district_code` VALUES ('331181', '3311', '龙泉市', null, '1', null);
INSERT INTO `district_code` VALUES ('510112', '5101', '龙泉驿区', null, '1', null);
INSERT INTO `district_code` VALUES ('350681', '3506', '龙海市', null, '1', null);
INSERT INTO `district_code` VALUES ('211403', '2114', '龙港区', null, '1', null);
INSERT INTO `district_code` VALUES ('330825', '3308', '龙游县', null, '1', null);
INSERT INTO `district_code` VALUES ('440507', '4405', '龙湖区', null, '1', null);
INSERT INTO `district_code` VALUES ('330303', '3303', '龙湾区', null, '1', null);
INSERT INTO `district_code` VALUES ('220203', '2202', '龙潭区', null, '1', null);
INSERT INTO `district_code` VALUES ('450328', '4503', '龙胜各族自治县', null, '1', null);
INSERT INTO `district_code` VALUES ('522730', '5227', '龙里县', null, '1', null);
INSERT INTO `district_code` VALUES ('441324', '4413', '龙门县', null, '1', null);
INSERT INTO `district_code` VALUES ('530523', '5305', '龙陵县', null, '1', null);
INSERT INTO `district_code` VALUES ('510504', '5105', '龙马潭区', null, '1', null);

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈ID',
  `content` varchar(400) NOT NULL COMMENT '反馈内容',
  `create_date` datetime DEFAULT NULL COMMENT '反馈日期',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志',
  `email` varchar(100) DEFAULT NULL COMMENT '联系邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系手机',
  `user_id` int(7) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------

-- ----------------------------
-- Table structure for icon_record
-- ----------------------------
DROP TABLE IF EXISTS `icon_record`;
CREATE TABLE `icon_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `icon_name` varchar(255) DEFAULT NULL COMMENT '图标名字',
  `image_name` varchar(255) DEFAULT NULL COMMENT '图片名称',
  `icon_type` varchar(255) DEFAULT NULL COMMENT '图标类型(1：首页 ，2：商圈)',
  `order_by` varchar(255) DEFAULT NULL COMMENT '排序',
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志(1:不删除，其他删除)',
  `image_path` varchar(255) DEFAULT NULL COMMENT '图片存放路径',
  `icon_path` varchar(255) DEFAULT NULL COMMENT '图标存放路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of icon_record
-- ----------------------------
INSERT INTO `icon_record` VALUES ('1', '0', '通知列表', null, '1', '1', null, null, null, null);
INSERT INTO `icon_record` VALUES ('2', '0', '二维码扫描', null, '1', '2', null, null, null, null);
INSERT INTO `icon_record` VALUES ('3', '0', '扫描列表', null, '1', '3', null, null, null, null);
INSERT INTO `icon_record` VALUES ('4', '0', '个人信息', null, '1', '4', null, null, null, null);
INSERT INTO `icon_record` VALUES ('5', '0', '账户设置', null, '1', '5', null, null, null, null);
INSERT INTO `icon_record` VALUES ('6', '0', '我的纠错', null, '1', '6', null, null, null, null);
INSERT INTO `icon_record` VALUES ('7', '0', '金融服务', null, '2', '1', null, null, null, null);
INSERT INTO `icon_record` VALUES ('8', '0', '法律服务', null, '2', '2', null, null, null, null);
INSERT INTO `icon_record` VALUES ('9', '0', '租车服务', null, '2', '3', null, null, null, null);
INSERT INTO `icon_record` VALUES ('10', '0', '保险服务', null, '2', '4', null, null, null, null);
INSERT INTO `icon_record` VALUES ('11', '0', '物流服务', null, '2', '5', null, null, null, null);
INSERT INTO `icon_record` VALUES ('12', '0', '网络服务', null, '2', '6', null, null, null, null);
INSERT INTO `icon_record` VALUES ('13', '0', '人员服务', null, '2', '7', null, null, null, null);
INSERT INTO `icon_record` VALUES ('14', '0', '印刷服务', null, '2', '8', null, null, null, null);
INSERT INTO `icon_record` VALUES ('15', '0', '翻译服务', null, '2', '9', null, null, null, null);
INSERT INTO `icon_record` VALUES ('16', '0', '医疗服务', null, '2', '10', null, null, null, null);
INSERT INTO `icon_record` VALUES ('17', '0', '广告服务', null, '2', '11', null, null, null, null);
INSERT INTO `icon_record` VALUES ('18', '0', '办公服务', null, '2', '12', null, null, null, null);

-- ----------------------------
-- Table structure for inform
-- ----------------------------
DROP TABLE IF EXISTS `inform`;
CREATE TABLE `inform` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  `monitor_id` int(11) DEFAULT NULL COMMENT '监踪Id',
  `crefo_no` varchar(255) DEFAULT NULL COMMENT '科氏号码',
  `subject_company` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `inform_type_id` int(11) DEFAULT NULL COMMENT '通知类型Id(1.订单完成通知 2.监踪变更通知 3.余额不足通 4.系统通知)',
  `inform_type_name` varchar(255) DEFAULT NULL COMMENT '通知类型名称',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_view` varchar(255) DEFAULT NULL COMMENT '是否查看过( 1未查阅，其他已查阅)',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志(1:不删除，其他删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inform
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `real_name` varchar(255) DEFAULT NULL COMMENT '登录人',
  `order_num` varchar(255) DEFAULT NULL COMMENT '订单编号',
  `order_date` datetime DEFAULT NULL COMMENT '订单日期',
  `finish_date` datetime DEFAULT NULL COMMENT '完成日期',
  `order_status` varchar(255) DEFAULT NULL COMMENT '订单状态	0取消，1待确认，2反馈中，3制作中，4完成）',
  `crefo_no` varchar(255) DEFAULT NULL COMMENT '科氏号码',
  `subject_name` varchar(255) DEFAULT NULL COMMENT '调查对象',
  `subject_tel` varchar(255) DEFAULT NULL COMMENT '调查电话',
  `subject_add` varchar(255) DEFAULT NULL COMMENT '调查地址',
  `subject_zip` varchar(255) DEFAULT NULL COMMENT '调查邮编',
  `subject_note` varchar(255) DEFAULT NULL COMMENT '调查其他信息',
  `file_type` varchar(255) DEFAULT NULL COMMENT '文件类型',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `reg` varchar(255) DEFAULT NULL COMMENT '注册号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `source_flag` varchar(255) DEFAULT NULL COMMENT '订购方式	0:人工输入，1：搜索下单',
  `base_price` double DEFAULT NULL COMMENT '报告基价',
  `money` double DEFAULT NULL COMMENT '价格  报告基价+监踪价格',
  `monitor_flag` varchar(255) DEFAULT NULL COMMENT '监踪标识',
  `monitor_period` varchar(255) DEFAULT NULL COMMENT '监踪期限',
  `monitor_price` double DEFAULT NULL COMMENT '监踪基价',
  `cpm_order_id` int(11) DEFAULT NULL COMMENT 'cpm订单id',
  `cpm_customer_id` int(11) DEFAULT NULL COMMENT 'cpm客户id',
  `is_view` varchar(255) DEFAULT NULL COMMENT '是否查看过  //0:未查看过，1：查看过 待确认状态下：(1查看过html不可删除，2订单有备注不可查看)',
  `reference_num` varchar(255) DEFAULT NULL COMMENT '参考号',
  `cpm_report_type_id` int(11) DEFAULT NULL COMMENT 'cpm报告类型',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志	1:不删除，其他删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('174', '45', '18721411720', null, '2017050613310631552', '2017-05-06 13:31:32', null, '1', null, '商安信（上海）企业管理咨询有限公司', 'nullnull', '逸仙路2816号b栋12层', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `order` VALUES ('175', '45', '18721411720', null, '2017050613320613822', '2017-05-06 13:32:14', null, '1', null, '商安信（上海）企业管理咨询有限公司', 'nullnull', '逸仙路2816号b栋12层', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `order` VALUES ('176', '45', '18721411720', null, '2017050615040626202', '2017-05-06 15:04:26', null, '1', null, '商安信（上海）企业管理咨询有限公司', 'nullnull', '逸仙路2816号b栋12层', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for province_code
-- ----------------------------
DROP TABLE IF EXISTS `province_code`;
CREATE TABLE `province_code` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name_cn` varchar(50) NOT NULL COMMENT '中文名称',
  `name_en` varchar(100) NOT NULL COMMENT '英文名称',
  `del_flag` varchar(2) NOT NULL COMMENT '删除标志',
  `c_id` varchar(255) DEFAULT NULL COMMENT '国家ID',
  `order_by` int(2) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`),
  KEY `sdfas` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province_code
-- ----------------------------
INSERT INTO `province_code` VALUES ('53', '云南省', 'Yunnan', '1', '86', '10');
INSERT INTO `province_code` VALUES ('15', '内蒙古自治区', 'Inner Mongolia Autonomous Region', '1', '86', '10');
INSERT INTO `province_code` VALUES ('22', '吉林省', 'Jilin', '1', '86', '10');
INSERT INTO `province_code` VALUES ('51', '四川省', 'Sichuan', '1', '86', '10');
INSERT INTO `province_code` VALUES ('64', '宁夏回族自治区', 'Ningxia', '1', '86', '10');
INSERT INTO `province_code` VALUES ('34', '安徽省', 'Anhui', '1', '86', '10');
INSERT INTO `province_code` VALUES ('37', '山东省', 'Shandong', '1', '86', '10');
INSERT INTO `province_code` VALUES ('14', '山西省', 'Shanxi Province', '1', '86', '10');
INSERT INTO `province_code` VALUES ('44', '广东省', 'Guangdong', '1', '86', '2');
INSERT INTO `province_code` VALUES ('45', '广西壮族自治区', 'Guangxi Zhuang Autonomous Region', '1', '86', '10');
INSERT INTO `province_code` VALUES ('65', '新疆维吾尔自治区', 'Xinjiang', '1', '86', '10');
INSERT INTO `province_code` VALUES ('32', '江苏省', 'Jiangsu', '1', '86', '2');
INSERT INTO `province_code` VALUES ('36', '江西省', 'Jiangxi', '1', '86', '10');
INSERT INTO `province_code` VALUES ('13', '河北省', 'Hebei', '1', '86', '10');
INSERT INTO `province_code` VALUES ('41', '河南省', 'Henan', '1', '86', '10');
INSERT INTO `province_code` VALUES ('33', '浙江省', 'Zhejiang', '1', '86', '2');
INSERT INTO `province_code` VALUES ('46', '海南省', 'Hainan', '1', '86', '10');
INSERT INTO `province_code` VALUES ('42', '湖北省', 'Hubei', '1', '86', '10');
INSERT INTO `province_code` VALUES ('43', '湖南省', 'Hunan', '1', '86', '10');
INSERT INTO `province_code` VALUES ('62', '甘肃省', 'Gansu', '1', '86', '10');
INSERT INTO `province_code` VALUES ('35', '福建省', 'Fujian', '1', '86', '10');
INSERT INTO `province_code` VALUES ('54', '西藏自治区', 'Xizang', '1', '86', '10');
INSERT INTO `province_code` VALUES ('52', '贵州省', 'Guizhou', '1', '86', '10');
INSERT INTO `province_code` VALUES ('21', '辽宁省', 'Liaoning', '1', '86', '10');
INSERT INTO `province_code` VALUES ('61', '陕西省', 'Shaanxi Province', '1', '86', '10');
INSERT INTO `province_code` VALUES ('63', '青海省', 'Qinghai', '1', '86', '10');
INSERT INTO `province_code` VALUES ('23', '黑龙江省', 'Heilongjiang', '1', '86', '10');
INSERT INTO `province_code` VALUES ('1', '北京', 'Beijing', '1', '86', '1');
INSERT INTO `province_code` VALUES ('2', '上海', 'Shanghai', '1', '86', '1');
INSERT INTO `province_code` VALUES ('3', '天津', 'Tianjing', '1', '86', '2');
INSERT INTO `province_code` VALUES ('4', '重庆', 'Chongqing', '1', '86', '2');

-- ----------------------------
-- Table structure for publicize
-- ----------------------------
DROP TABLE IF EXISTS `publicize`;
CREATE TABLE `publicize` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '推广ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `full_company` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司全称名称',
  `abb_company` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '公司简称名称',
  `tel` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '电话',
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '手机',
  `fax` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '传真',
  `zip` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮编',
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '地址',
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `website` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '网址',
  `del_flag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '删除标志(1:不删除，其他删除)',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `publicize_flag_id` int(11) DEFAULT NULL COMMENT '推广标签',
  `introduction` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '企业简介',
  `credit_risk_score` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '企业风险评分',
  `view_count` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '浏览次数',
  `main_products` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '产品简介',
  `repayment_index` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '偿还',
  `creditRisk_evaluation` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '信用风险评级',
  `credits` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '建议信用额度',
  `card_id` int(11) NOT NULL COMMENT '名片ID',
  `photo_path` varchar(255) COLLATE utf8_unicode_ci DEFAULT '' COMMENT '图片路径',
  `area_code` int(11) DEFAULT NULL COMMENT '电话区号',
  `contact_card_id` int(11) DEFAULT NULL COMMENT '联系名片ID',
  `country_code` int(11) DEFAULT NULL COMMENT '国家代码',
  `province_code` int(11) DEFAULT NULL COMMENT '省代码',
  `city_code` int(11) DEFAULT NULL COMMENT '市代码',
  `district_code` int(11) DEFAULT NULL COMMENT '区代码',
  `create_date` datetime DEFAULT NULL COMMENT '推广日期',
  `credit_certification` int(11) DEFAULT NULL COMMENT '信用认证分数(null：未认证)',
  `credit_verification` int(11) DEFAULT NULL COMMENT '名片核实分数(null：未核实)',
  `publicize_score` int(11) DEFAULT NULL COMMENT '综合分数(用于排序)',
  `keyword` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '关键字(暂时不用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of publicize
-- ----------------------------
INSERT INTO `publicize` VALUES ('14', '45', '1', '11', '11', '11', '1111', '111', '', '111', '111', '1', '2017-05-06 16:52:47', null, '111', null, '86', '1111', null, null, null, '117', 'group1/M00/00/0E/wKgBKE8HyuWAShXcAAFqx8BKAgo565.jpg', null, null, null, null, null, null, '2017-05-06 15:19:13', null, null, null, null);

-- ----------------------------
-- Table structure for publicize_fee
-- ----------------------------
DROP TABLE IF EXISTS `publicize_fee`;
CREATE TABLE `publicize_fee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '推广扣费ID',
  `publicize_id` int(11) NOT NULL COMMENT '推广ID',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户名称',
  `type` int(11) DEFAULT NULL COMMENT '扣费类型(1：被查看过推广信息、2：被加好友、3：被打过电话)',
  `money` float DEFAULT NULL COMMENT '费用',
  `ip` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Ip',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '删除标志(1:不删除，其他删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of publicize_fee
-- ----------------------------

-- ----------------------------
-- Table structure for publicize_flag
-- ----------------------------
DROP TABLE IF EXISTS `publicize_flag`;
CREATE TABLE `publicize_flag` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of publicize_flag
-- ----------------------------

-- ----------------------------
-- Table structure for publicize_photo
-- ----------------------------
DROP TABLE IF EXISTS `publicize_photo`;
CREATE TABLE `publicize_photo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '图片ID',
  `publicize_id` int(11) NOT NULL COMMENT '推广ID',
  `photo_path` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '图片路径',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '删除标志(1:不删除，其他删除)',
  `order_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '自定义排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of publicize_photo
-- ----------------------------
INSERT INTO `publicize_photo` VALUES ('1', '14', 'group1/M00/00/0E/wKgBKE8Huc6AEug5AAQ_P89nhEE609.jpg', '2017-05-06 15:39:53', null, '2');
INSERT INTO `publicize_photo` VALUES ('2', '14', 'group1/M00/00/0E/wKgBKE8Huc-ARISmAAQ_P89nhEE072.jpg', '2017-05-06 15:39:59', null, '1');
INSERT INTO `publicize_photo` VALUES ('3', '14', 'group1/M00/00/0E/wKgBKE8Huf-AHLDcAAQ_P89nhEE675.jpg', '2017-05-06 15:40:41', null, '1');
INSERT INTO `publicize_photo` VALUES ('4', '14', 'group1/M00/00/0E/wKgBKE8HugKACLlnAAQ_P89nhEE292.jpg', '2017-05-06 15:40:44', null, '2');
INSERT INTO `publicize_photo` VALUES ('5', '14', 'group1/M00/00/0E/wKgBKE8HysSASVQUAAL5rOKN3ko065.jpg', '2017-05-06 16:52:14', null, '1');
INSERT INTO `publicize_photo` VALUES ('6', '14', 'group1/M00/00/0E/wKgBKE8HysSAVKweAAL5rOKN3ko621.jpg', '2017-05-06 16:52:14', null, '2');

-- ----------------------------
-- Table structure for recharge_log
-- ----------------------------
DROP TABLE IF EXISTS `recharge_log`;
CREATE TABLE `recharge_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `log_id` int(11) NOT NULL COMMENT '通知Id',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `login_ip` varchar(255) NOT NULL COMMENT '登陆IP',
  `recharge_date` datetime NOT NULL COMMENT '充值日期',
  `capital` datetime NOT NULL COMMENT '本钱',
  `recharge_money` varchar(255) NOT NULL COMMENT '充值金额',
  `current_money` varchar(255) NOT NULL COMMENT '当前金额',
  `recharge_num` varchar(255) NOT NULL COMMENT '充值订单号',
  `recharge_status` varchar(255) NOT NULL COMMENT '充值状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recharge_log
-- ----------------------------

-- ----------------------------
-- Table structure for scanning_card
-- ----------------------------
DROP TABLE IF EXISTS `scanning_card`;
CREATE TABLE `scanning_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `carduu_id` int(11) DEFAULT NULL COMMENT '扫描唯一id',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `mobile1` varchar(255) DEFAULT NULL COMMENT '移动电话1',
  `mobile2` varchar(255) DEFAULT NULL COMMENT '移动电话2',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `tel1` varchar(255) DEFAULT NULL COMMENT '电话1',
  `tel2` varchar(255) DEFAULT NULL COMMENT '电话2',
  `fax` varchar(255) DEFAULT NULL COMMENT '传真(1未查阅，其他已查阅)',
  `company_name` varchar(255) DEFAULT NULL COMMENT '公司名称',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `website` varchar(255) DEFAULT NULL COMMENT '网址',
  `logo` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  `fields` varchar(255) DEFAULT NULL COMMENT '完成度',
  `audit` varchar(255) DEFAULT NULL COMMENT '是否识别(大于1无法识别)',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志(1:不删除，其他删除)',
  `areaCode1` varchar(255) DEFAULT NULL COMMENT '区号1( 电话区号1)',
  `areaCode2` varchar(255) DEFAULT NULL COMMENT '区号2(电话区号2)',
  `photo_path` varchar(255) DEFAULT NULL COMMENT '头像路径',
  `path` varchar(255) DEFAULT NULL,
  `b_card_flag` varchar(255) DEFAULT NULL COMMENT '是否已经加入到名片(1：加入  其他都为未加入)',
  `zip` varchar(255) DEFAULT NULL COMMENT '邮编',
  `hea_sculpture_path` varchar(255) DEFAULT NULL COMMENT '头像路径',
  `shwo_hea_sculpture_path` varchar(255) DEFAULT NULL COMMENT '显示头像路径',
  `name_coordinate` varchar(255) DEFAULT NULL COMMENT '名字坐标',
  `position_coordinate` varchar(255) DEFAULT NULL COMMENT '职位坐标',
  `mobile1_coordinate` varchar(255) DEFAULT NULL COMMENT '移动电话1坐标',
  `mobile2_coordinate` varchar(255) DEFAULT NULL COMMENT '移动电话2坐标',
  `email_coordinate` varchar(255) DEFAULT NULL COMMENT '邮箱坐标',
  `tel1_coordinate` varchar(255) DEFAULT NULL COMMENT '电话1坐标',
  `tel2_coordinate` varchar(255) DEFAULT NULL COMMENT '电话2坐标',
  `fax_coordinate` varchar(255) DEFAULT NULL COMMENT '传真坐标',
  `company_name_coordinate` varchar(255) DEFAULT NULL COMMENT '公司坐标',
  `address_coordinate` varchar(255) DEFAULT NULL COMMENT '地址坐标',
  `website_coordinate` varchar(255) DEFAULT NULL COMMENT '网址坐标',
  `area_code1_coordinate` varchar(255) DEFAULT NULL COMMENT '区号1坐标',
  `area_code2_coordinate` varchar(255) DEFAULT NULL COMMENT '区号2坐标',
  `zip_coordinate` varchar(255) DEFAULT NULL COMMENT '邮编坐标',
  `correct_coordinate` varchar(255) DEFAULT NULL COMMENT '纠正坐标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scanning_card
-- ----------------------------
INSERT INTO `scanning_card` VALUES ('41', '45', null, '陆歆煜', '执行副总裁', '+8613801808362', '', 'aaron.lu@3acredit.com', '36386226', '', '', '商安信(上海)企业管理咨询股份有限公司', '中国上海市逸仙路2816号华滋奔腾大厦B幢12层', 'www.3acredit.cn', '', '2017-05-06 16:16:24', '2017-05-06 16:17:18', '', '', '', '+8621', '', 'group1/M00/00/0E/wKgBKE8Hwl-AZeGjAArIzynRCUo469.jpg', '', '', '200441', '', '', '669,1330,732,1330,732,1532,669,1532', '611,1342,650,1342,650,1531,611,1531', '268,570,310,570,310,926,268,926', '', '201,491,249,491,249,925,201,925', '331,430,372,430,372,926,331,926', '', '', '613,213,665,213,665,1042,613,1042', '393,375,497,375,497,1041,393,1041', '138,611,185,611,185,926,138,926', '331,430,372,430,372,926,331,926', '', '393,375,497,375,497,1041,393,1041', '90');

-- ----------------------------
-- Table structure for scanning_card_extend
-- ----------------------------
DROP TABLE IF EXISTS `scanning_card_extend`;
CREATE TABLE `scanning_card_extend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID号',
  `scanning_card_id` int(11) NOT NULL COMMENT '关联名片ID',
  `type` varchar(255) NOT NULL COMMENT '扩展类型(mobile,email,fax,web,zip)',
  `param_type` varchar(255) DEFAULT NULL COMMENT '参数类型(住宅,工作,iPhone,手机,主要,其他)',
  `param1` varchar(255) DEFAULT NULL COMMENT '参数1',
  `param2` varchar(255) DEFAULT NULL COMMENT '参数2',
  `param_ext` varchar(255) DEFAULT NULL COMMENT '参数扩展',
  `param_note` varchar(255) DEFAULT NULL COMMENT '参数备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1558 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of scanning_card_extend
-- ----------------------------
INSERT INTO `scanning_card_extend` VALUES ('1552', '41', 'mobile', null, null, '+8613801808362', null, '268,570,310,570,310,926,268,926');
INSERT INTO `scanning_card_extend` VALUES ('1553', '41', 'tel', null, '+8621', '36386226', null, '331,430,372,430,372,926,331,926');
INSERT INTO `scanning_card_extend` VALUES ('1554', '41', 'email', null, null, 'aaron.lu@3acredit.com', null, '201,491,249,491,249,925,201,925');
INSERT INTO `scanning_card_extend` VALUES ('1555', '41', 'web', null, null, 'www.3acredit.cn', null, '138,611,185,611,185,926,138,926');
INSERT INTO `scanning_card_extend` VALUES ('1556', '41', 'zip', null, null, '200441', null, null);
INSERT INTO `scanning_card_extend` VALUES ('1557', '41', 'fax', null, null, '36386718', null, null);

-- ----------------------------
-- Table structure for share_record
-- ----------------------------
DROP TABLE IF EXISTS `share_record`;
CREATE TABLE `share_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `del_flag` varchar(20) DEFAULT NULL COMMENT '删除标志',
  `feed_id` int(11) NOT NULL COMMENT '反馈ID',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系手机',
  `email` varchar(255) DEFAULT NULL COMMENT '联系邮箱',
  `create_date` datetime DEFAULT NULL COMMENT '日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of share_record
-- ----------------------------

-- ----------------------------
-- Table structure for titles
-- ----------------------------
DROP TABLE IF EXISTS `titles`;
CREATE TABLE `titles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `title_content` varchar(255) NOT NULL COMMENT '反馈内容',
  `title_date` datetime DEFAULT NULL COMMENT '主题时间',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `question_type` varchar(255) DEFAULT NULL COMMENT '问题类型(1：积分充值 2：订单 3：报告 4：账单 5：核实纠错  10:其他)',
  `email` varchar(255) DEFAULT NULL COMMENT '联系邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系手机',
  `photo_path1` varchar(255) DEFAULT NULL COMMENT '图片1',
  `photo_path2` varchar(255) DEFAULT NULL COMMENT '图片2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of titles
-- ----------------------------

-- ----------------------------
-- Table structure for user_token
-- ----------------------------
DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户登录id',
  `u_id` int(11) NOT NULL COMMENT '用户ID',
  `token` int(11) NOT NULL COMMENT 'token值',
  `last_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登录时间',
  `expire_time` datetime NOT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_token
-- ----------------------------
INSERT INTO `user_token` VALUES ('30', '44', '117258', '2017-05-06 16:49:25', '2017-06-05 16:49:25');
INSERT INTO `user_token` VALUES ('31', '45', '798300', '2017-05-06 16:23:07', '2017-06-05 16:23:07');
INSERT INTO `user_token` VALUES ('32', '46', '60604', '2017-05-06 14:54:45', '2017-06-05 14:54:45');
INSERT INTO `user_token` VALUES ('33', '47', '507423', '2017-05-06 16:34:09', '2017-06-05 16:34:09');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `area_code` varchar(255) DEFAULT NULL COMMENT '电话区号',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志(1:不删除，其他删除)',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `mobile_num` varchar(255) DEFAULT NULL COMMENT '手机号',
  `order_mail` varchar(255) DEFAULT NULL COMMENT '订单发送邮箱',
  `photo_path` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `position` varchar(255) DEFAULT NULL COMMENT '职位',
  `pwd` varchar(255) NOT NULL COMMENT '密码(必填，不得修改)',
  `real_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `report_mail` varchar(255) DEFAULT NULL COMMENT '报告发送邮箱',
  `statement_mail` varchar(255) DEFAULT NULL COMMENT '账单发送邮箱',
  `tel` varchar(255) DEFAULT NULL COMMENT '电话',
  `user_name` varchar(255) NOT NULL COMMENT '用户账户(必填，不得修改)',
  `website` varchar(255) DEFAULT NULL COMMENT '网站',
  `qr_code_path` varchar(255) DEFAULT NULL COMMENT '二维码',
  `phone_token` varchar(255) DEFAULT NULL COMMENT '用户设备',
  `show_photo_path` varchar(255) DEFAULT NULL COMMENT '显示头像地址',
  `show_qr_code_path` varchar(255) DEFAULT NULL COMMENT '显示二维码地址',
  `balance` float DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('44', null, null, null, '11111111@sina.com', '13822222222', null, null, null, '1BBD886460827015E5D605ED44252251', null, null, null, null, '13822222222', null, null, null, null, null, null);
INSERT INTO `users` VALUES ('45', null, null, null, '951368238@qq.com', '18721411720', null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', null, null, null, null, '18721411720', null, null, null, null, null, null);
INSERT INTO `users` VALUES ('46', null, null, null, '757182953@vip.qq.com', '13020285890', null, null, null, 'E10ADC3949BA59ABBE56E057F20F883E', null, null, null, null, '13020285890', null, null, 'Atk8HNjpWEn7GtTIroQfwmXF1RaB8B0rNplbeMuNVBcA', null, null, null);
INSERT INTO `users` VALUES ('47', null, null, null, '867221711@qq.com', '15821369435', null, null, null, '96E79218965EB72C92A549DD5A330112', null, null, null, null, '15821369435', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for verification_code
-- ----------------------------
DROP TABLE IF EXISTS `verification_code`;
CREATE TABLE `verification_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `del_flag` varchar(2) DEFAULT NULL,
  `token_code` varchar(10) DEFAULT NULL COMMENT '验证码',
  `token_status` varchar(2) DEFAULT NULL COMMENT '验证状态',
  `create_time` datetime DEFAULT NULL,
  `user_email` varchar(100) DEFAULT NULL COMMENT '用户邮箱',
  `user_name` varchar(100) DEFAULT NULL COMMENT '用户名',
  `user_phone` varchar(100) DEFAULT NULL COMMENT '用户手机',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verification_code
-- ----------------------------

-- ----------------------------
-- Table structure for verification_result
-- ----------------------------
DROP TABLE IF EXISTS `verification_result`;
CREATE TABLE `verification_result` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '核实ID',
  `card_id` int(11) NOT NULL COMMENT '名片ID',
  `company_status_result` varchar(255) DEFAULT NULL COMMENT '企业状态结果(存续,注销等)',
  `company_address_tel_address_result` varchar(255) DEFAULT NULL COMMENT '公司地址电话地址结果',
  `company_name_tel_name_result` varchar(255) DEFAULT NULL COMMENT '公司名称电话名称',
  `card_name_mobile_name` varchar(255) DEFAULT NULL COMMENT '名片名字手机名字',
  `company_name_icp_name_result` varchar(255) DEFAULT NULL COMMENT '公司名字ICP备案名字',
  `other_info_result` varchar(255) DEFAULT NULL COMMENT '其他',
  `total_score` int(11) DEFAULT NULL COMMENT '总分',
  `del_flag` varchar(255) DEFAULT NULL COMMENT '删除标志(1:不删除，其他删除)',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `update_time` datetime DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of verification_result
-- ----------------------------
INSERT INTO `verification_result` VALUES ('22', '117', '一致', null, null, '不详', null, '14', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('23', '117', '一致', null, null, '不详', null, '14', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('24', '117', '一致', null, null, '不详', null, '14', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('25', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('26', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('27', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('28', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('29', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('30', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('31', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('32', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('33', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('34', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('35', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('36', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('37', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('38', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('39', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('40', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('41', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('42', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('43', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('44', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('45', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('46', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('47', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('48', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('49', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('50', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('51', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('52', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('53', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('54', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('55', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('56', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('57', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('58', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('59', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('60', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('61', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('62', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('63', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('64', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('65', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('66', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('67', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('68', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('69', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('70', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('71', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('72', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('73', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('74', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('75', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('76', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('77', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('78', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('79', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('80', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('81', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('82', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('83', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('84', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('85', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('86', '119', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('87', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('88', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('89', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('90', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('91', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('92', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('93', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('94', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('95', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('96', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('97', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('98', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('99', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('100', '118', '一致', null, null, '不一致', null, '11', '20', null, '45', null);
INSERT INTO `verification_result` VALUES ('101', '120', '一致', null, null, '不一致', null, '11', '20', null, '45', null);

-- ----------------------------
-- Table structure for versions
-- ----------------------------
DROP TABLE IF EXISTS `versions`;
CREATE TABLE `versions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '版本Id',
  `del_flag` varchar(2) NOT NULL COMMENT '删除标志',
  `update_time` varchar(50) NOT NULL COMMENT '更新时间',
  `url` varchar(500) NOT NULL COMMENT '下载地址',
  `version_no` varchar(20) NOT NULL COMMENT '版本号',
  `version_type` varchar(2) NOT NULL COMMENT '版本类型( 1:IOS, 2:Android;)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of versions
-- ----------------------------
