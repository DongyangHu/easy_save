/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : easy_save

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-08-21 19:05:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account_data`
-- ----------------------------
DROP TABLE IF EXISTS `account_data`;
CREATE TABLE `account_data` (
  `DataID` varchar(15) NOT NULL,
  `Account` varchar(50) NOT NULL,
  `Account_pw` varchar(50) NOT NULL,
  `Account_type` varchar(50) NOT NULL,
  `CreateTime` varchar(12) NOT NULL,
  `UserID` varchar(3) NOT NULL,
  PRIMARY KEY (`DataID`),
  KEY `UserID` (`UserID`),
  CONSTRAINT `UserID` FOREIGN KEY (`UserID`) REFERENCES `user_gen` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account_data
-- ----------------------------
INSERT INTO `account_data` VALUES ('003201703231851', '632433151', '12345', 'QQ号', '201703231851', '003');
INSERT INTO `account_data` VALUES ('003201704270950', 'hdyang66', '123456', 'CSDN', '201704270950', '003');
INSERT INTO `account_data` VALUES ('003201705031508', 'will', '123456', 'QQ', '201705031508', '003');
INSERT INTO `account_data` VALUES ('003201705192112', '12345', 'asas', 'asdasd', '201705192112', '003');
INSERT INTO `account_data` VALUES ('003201705201933', '12345', 'asas', 'asdasd', '201705201933', '003');

-- ----------------------------
-- Table structure for `user_gen`
-- ----------------------------
DROP TABLE IF EXISTS `user_gen`;
CREATE TABLE `user_gen` (
  `ID` varchar(3) NOT NULL,
  `Name` varchar(10) NOT NULL,
  `Password` varchar(16) NOT NULL,
  `Flag` varchar(7) NOT NULL,
  `CreateDay` varchar(12) NOT NULL,
  `Note` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_gen
-- ----------------------------
INSERT INTO `user_gen` VALUES ('001', '小明', '123456', 'generic', '201703231735', '小明');
INSERT INTO `user_gen` VALUES ('003', 'hdy', '123456', 'generic', '201703231733', 'hdy');
INSERT INTO `user_gen` VALUES ('904', 'will', '123456', 'generic', '201704270915', 'note');

-- ----------------------------
-- Table structure for `user_su`
-- ----------------------------
DROP TABLE IF EXISTS `user_su`;
CREATE TABLE `user_su` (
  `ID` varchar(4) NOT NULL,
  `Name` varchar(10) NOT NULL,
  `Password` varchar(16) NOT NULL,
  `Flag` varchar(7) NOT NULL,
  `Note` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_su
-- ----------------------------
INSERT INTO `user_su` VALUES ('root', 'root', '123456', 'super', 'root');
