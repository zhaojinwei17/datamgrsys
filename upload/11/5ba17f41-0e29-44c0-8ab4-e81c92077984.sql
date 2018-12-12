/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : datamgrsys

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 10/12/2018 19:19:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dataname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '资料名称',
  `groupname` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '小组名称',
  `uploadmen` int(11) DEFAULT NULL COMMENT '上传人名称',
  `memo` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '资料简介',
  `enclosure` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '附件地址',
  `ip` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT 'ip地址',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  `times` bigint(20) DEFAULT NULL COMMENT '浏览次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of data
-- ----------------------------
BEGIN;
INSERT INTO `data` VALUES (39, '话术', '甜心小组', 34, '回到济南', NULL, '127.0.0.1', '2018-12-10 03:42:14', '2018-12-10 03:42:14', 0);
COMMIT;

-- ----------------------------
-- Table structure for enclosure
-- ----------------------------
DROP TABLE IF EXISTS `enclosure`;
CREATE TABLE `enclosure` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dataid` int(11) DEFAULT NULL COMMENT '资料id',
  `filename` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '附件原始名',
  `filepath` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '附件上传路径',
  `filesize` double DEFAULT NULL COMMENT '附件大小',
  `uploadtime` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of enclosure
-- ----------------------------
BEGIN;
INSERT INTO `enclosure` VALUES (32, 39, 'datamgrsys.sql', '/upload/17/7532deec-756b-4d78-bd8b-e128e679348c.sql', 0.005023956298828125, '2018-12-10 03:42:14');
INSERT INTO `enclosure` VALUES (33, 39, '资料管理平台说明.docx', '/upload/11/f0d573e2-05f8-4cfd-bb06-50925af6d6d0.docx', 0.3396883010864258, '2018-12-10 03:42:14');
INSERT INTO `enclosure` VALUES (34, 39, '蒙通的linux服务器配置.docx', '/upload/10/ca89982a-00bf-4d0a-a985-90307120d587.docx', 0.011698722839355469, '2018-12-10 03:42:14');
INSERT INTO `enclosure` VALUES (35, 39, 'ft5_81_form.zip', '/upload/17/6e30762f-d9ec-473d-a9e2-54b411a79d86.zip', 0.7949857711791992, '2018-12-10 03:42:14');
COMMIT;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `permissionid` int(11) DEFAULT NULL,
  `permname` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `permissionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '密码',
  `classes` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '班级',
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '联系方式',
  `groupname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '小组名',
  `roleid` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户角色',
  `cremen` int(11) DEFAULT NULL COMMENT '创建人id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `updatemen` int(11) DEFAULT NULL COMMENT '修改人id',
  `updatetime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (34, 'zjw', '$2a$10$KC2udblEA3O4DjopabjwfePlGxBdO06SniS4t38F0WtpbDDqR/8Ti', '245', '18390956380', '甜心小组', '0', 0, '2018-12-09 19:56:31', 0, '2018-12-09 19:56:31');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
