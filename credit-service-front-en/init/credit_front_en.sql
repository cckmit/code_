/*
Navicat MySQL Data Transfer

Source Server         : 192.168.1.185
Source Server Version : 50635
Source Host           : 192.168.1.185:3306
Source Database       : credit_front_en

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-05-10 15:47:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bank_infos
-- ----------------------------
DROP TABLE IF EXISTS `bank_infos`;
CREATE TABLE `bank_infos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bank_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `house_number` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `postal_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `province` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  `name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for basic_infos
-- ----------------------------
DROP TABLE IF EXISTS `basic_infos`;
CREATE TABLE `basic_infos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_com_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `company_status_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `company_status_text` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_address` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_city` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_house_number` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_street` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_tel` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_post_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact_province` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_code` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `location` text COLLATE utf8_unicode_ci,
  `note` text COLLATE utf8_unicode_ci,
  `other_address` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_city` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_country` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_house_number` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_postal_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_provice` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_street` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_tel` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_address` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_city` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_com_name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_country` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_form` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_global_form` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_house_number` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_local_form` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_postal_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_province` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_street` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_tel` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_type` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registry` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vat_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vat_date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `website` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `listed_stock_exchange` text COLLATE utf8_unicode_ci,
  `location_status` text COLLATE utf8_unicode_ci,
  `deadline` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_capital` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `share_num` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contatct_country` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contatct_fax` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `location_dec` text COLLATE utf8_unicode_ci,
  `reg_other_information` text COLLATE utf8_unicode_ci,
  `full_report_id` int(11) DEFAULT NULL,
  `reg_other_id` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for change_infos
-- ----------------------------
DROP TABLE IF EXISTS `change_infos`;
CREATE TABLE `change_infos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `form_change_date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name_change_date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `previous_address` text COLLATE utf8_unicode_ci,
  `previous_common_code` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  `previous_form` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `previous_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `previous_provider_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `change_date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `change_type` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for financial_figures
-- ----------------------------
DROP TABLE IF EXISTS `financial_figures`;
CREATE TABLE `financial_figures` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auditor_comment_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `auditor_comment_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `auditor_name_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `auditor_name_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `crefo_no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `internal_use` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_financial` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `isid` int(11) DEFAULT NULL,
  `note_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `osid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  `supplier_num` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for financial_statement
-- ----------------------------
DROP TABLE IF EXISTS `financial_statement`;
CREATE TABLE `financial_statement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `advisors` varchar(40) COLLATE utf8_unicode_ci DEFAULT NULL,
  `amortisation` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `auditor_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bank_liabilities` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `bank_liabilitiesDueAfter1Year` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `called_up_share_capital` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cash` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `consolidated_accounts` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contingent_liabilities` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `currency` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `depreciation` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dividends` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `extraordinary_costs` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `extraordinary_income` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `financial_expenses` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `financial_income` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `finished_goods` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `goodwill` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `group_payables` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `group_payables_due_after_1_year` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `group_receivables` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `investments` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `land_and_buildings` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `loans_to_group` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `minority_interests` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `miscellaneous_fixed_assets` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `miscellaneous_liabilities` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `miscellaneous_liabilities_due_after_1_year` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `miscellaneous_receivables` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `net_worth` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `operating_costs` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `operating_profit` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_appropriations` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_current_assets` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_intangible_assets` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_inventories` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_loans` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_loans_or_finance` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_loans_or_finance_due_after_1_year` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_reserves` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `other_tangible_assets` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pension_costs` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `plant_and_machinery` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `profit_after_tax` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `profit_before_tax` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `raw_materials` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `receivables_due_after_1_year` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `retained_profit` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `revenue` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `revenue_reserves` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `share_premium` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `solicitor_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tax` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_assets` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_current_assets` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_current_liabilities` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_fixed_assets` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_intangible_assets` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_inventories` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_liabilities` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_long_term_liabilities` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_other_fixed_assets` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_receivables` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_shareholders_equity` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total_tangible_assets` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `trade_payables` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `trade_payables_due_after_1_year` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `trade_receivables` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `wages_and_salaries` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `weeks` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `work_in_progress` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `working_capital` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curr_common_description` text COLLATE utf8_unicode_ci,
  `curr_common_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curr_contract_limit` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curr_credit_limit` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `curr_provider_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date_of_latest_rating_change` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pre_common_description` text COLLATE utf8_unicode_ci,
  `pre_common_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pre_credit_limit` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pre_provider_value` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_financial` int(100) DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  `local_credit_rating` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for full_report
-- ----------------------------
DROP TABLE IF EXISTS `full_report`;
CREATE TABLE `full_report` (
  `update_time` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '企业名称',
  `company_no` varchar(255) DEFAULT NULL COMMENT '科氏号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for history_infos
-- ----------------------------
DROP TABLE IF EXISTS `history_infos`;
CREATE TABLE `history_infos` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `establish_date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `history_dec` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for identification
-- ----------------------------
DROP TABLE IF EXISTS `identification`;
CREATE TABLE `identification` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_financial` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `financial_content` text COLLATE utf8_unicode_ci,
  `comments` text COLLATE utf8_unicode_ci,
  `comments_data_supplied` text COLLATE utf8_unicode_ci,
  `interviewed` text COLLATE utf8_unicode_ci,
  `position` text COLLATE utf8_unicode_ci,
  `attach_path` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for json_report
-- ----------------------------
DROP TABLE IF EXISTS `json_report`;
CREATE TABLE `json_report` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `country` varchar(20) DEFAULT NULL,
  `company_id` varchar(40) DEFAULT NULL,
  `report_type` varchar(20) DEFAULT NULL,
  `language` varchar(20) DEFAULT NULL,
  `request_json` text,
  `response_json` longtext,
  `ip` varchar(100) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `request_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `comName` (`report_type`),
  KEY `crefoNo` (`country`)
) ENGINE=MyISAM AUTO_INCREMENT=225 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for legal_infos
-- ----------------------------
DROP TABLE IF EXISTS `legal_infos`;
CREATE TABLE `legal_infos` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bankruptcy` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cautionary_ucc_filings` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `judgment_filings` tinytext COLLATE utf8_unicode_ci,
  `sum` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tax_lien_filings` text COLLATE utf8_unicode_ci,
  `ucc_filings` text COLLATE utf8_unicode_ci,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for managements
-- ----------------------------
DROP TABLE IF EXISTS `managements`;
CREATE TABLE `managements` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `appointment_date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birth_date` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `common_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gender` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `house_number` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `manage_type` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `position` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `post_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `provider_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `province` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `manage_note` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=243 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for media_records
-- ----------------------------
DROP TABLE IF EXISTS `media_records`;
CREATE TABLE `media_records` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `detail_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `detail_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mtid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `osid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `supplier_num` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for operatings
-- ----------------------------
DROP TABLE IF EXISTS `operatings`;
CREATE TABLE `operatings` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_code` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activity_description` text COLLATE utf8_unicode_ci,
  `brands` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `business_overview` text COLLATE utf8_unicode_ci,
  `competitors` text COLLATE utf8_unicode_ci,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee_info` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `employee_num` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `export_area` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `import_area` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `operations_area` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `year` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `clients` text COLLATE utf8_unicode_ci,
  `comments_staff` text COLLATE utf8_unicode_ci,
  `sales_are` text COLLATE utf8_unicode_ci,
  `suppliers` text COLLATE utf8_unicode_ci,
  `terms_payment` text COLLATE utf8_unicode_ci,
  `trade_references` text COLLATE utf8_unicode_ci,
  `other_comment` text COLLATE utf8_unicode_ci,
  `main_business` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for other_infos
-- ----------------------------
DROP TABLE IF EXISTS `other_infos`;
CREATE TABLE `other_infos` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for payment_histories
-- ----------------------------
DROP TABLE IF EXISTS `payment_histories`;
CREATE TABLE `payment_histories` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pay_history` text COLLATE utf8_unicode_ci,
  `pay_info` text COLLATE utf8_unicode_ci,
  `term` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for public_records
-- ----------------------------
DROP TABLE IF EXISTS `public_records`;
CREATE TABLE `public_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `filed_by` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `filed_date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `filing_type` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fling_number` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `jurisdiction` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_report_id` int(11) DEFAULT NULL,
  `public_note` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for registration_infos
-- ----------------------------
DROP TABLE IF EXISTS `registration_infos`;
CREATE TABLE `registration_infos` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `building_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `building_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `business_scope_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `business_scope_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chn_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `city_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cpid` int(11) DEFAULT NULL,
  `crefo_no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `csid` int(11) DEFAULT NULL,
  `ctid` int(11) DEFAULT NULL,
  `deadline` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `district_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `district_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `establish_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `eu_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `int_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `is_market` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `legal_name_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `legal_name_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `legal_position_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `legal_position_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `market_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `market_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mcid` int(11) DEFAULT NULL,
  `paid_capital` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `paid_currency` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `province_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `province_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_capital` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_currency` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registration_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `registration_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tax` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `us_code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zip` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for related_companies
-- ----------------------------
DROP TABLE IF EXISTS `related_companies`;
CREATE TABLE `related_companies` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `city` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `house_number` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `postal_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `province` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `related_type` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `safe_number` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `vat_code` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `related_note` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=349 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for shareholder_infos
-- ----------------------------
DROP TABLE IF EXISTS `shareholder_infos`;
CREATE TABLE `shareholder_infos` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `share_address` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `share_issued_capital` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `share_name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `share_nominal_capital` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `share_percent` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `share_note` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for trade_references
-- ----------------------------
DROP TABLE IF EXISTS `trade_references`;
CREATE TABLE `trade_references` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_crefo_no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cooperation_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `cpid` int(11) DEFAULT NULL,
  `crefo_no` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `csid` int(11) DEFAULT NULL,
  `del_flag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `establish_date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `flag` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note_cn` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `note_en` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `osid` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `reg` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `supplier_num` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tel` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Table structure for uccs
-- ----------------------------
DROP TABLE IF EXISTS `uccs`;
CREATE TABLE `uccs` (
  `full_report_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crefo_no` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `del_flag` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  `filed_date` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fling_number` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `secured_party` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ucc_note` text COLLATE utf8_unicode_ci,
  `update_time` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
