/*
Navicat MySQL Data Transfer

Source Server         : Compasser_blog
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : bankmanagersystem

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-03-10 10:13:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for trader
-- ----------------------------
DROP TABLE IF EXISTS `trader`;
CREATE TABLE `trader` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trade` varchar(50) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `dataTime` varchar(50) DEFAULT NULL,
  `userNO` varchar(50) DEFAULT NULL,
  `money` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_uNO` (`userNO`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trader
-- ----------------------------
INSERT INTO `trader` VALUES ('36', '存款', '1000', '2017-12-29 16:13:27', '1514509301926', '1000');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) DEFAULT NULL,
  `userAge` int(11) DEFAULT NULL,
  `idCard` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `userAddress` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `userSex` varchar(50) DEFAULT NULL,
  `userNO` varchar(50) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `userflag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_userNO` (`userNO`),
  KEY `index_bal_uno` (`balance`,`userNO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('3', '孔潭活', '21', '441224199609140518', '13560468205', '广东广州', '天河区中山大道西293号', 'E10ADC3949BA59ABBE56E057F20F883E', '男', '1514509301926', '1000', '0');

-- ----------------------------
-- View structure for view_trader
-- ----------------------------
DROP VIEW IF EXISTS `view_trader`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `view_trader` AS select * from trader ;

-- ----------------------------
-- View structure for view_userinfo
-- ----------------------------
DROP VIEW IF EXISTS `view_userinfo`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `view_userinfo` AS select * from userinfo ;
