/*
 Navicat Premium Data Transfer

 Source Server         : yushu
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : lite_shop

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 20/09/2020 17:20:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_log
-- ----------------------------
DROP TABLE IF EXISTS `admin_log`;
CREATE TABLE `admin_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `admin` varchar(32) NOT NULL DEFAULT '' COMMENT '管理员名',
  `ip` varchar(32) NOT NULL DEFAULT '' COMMENT '登录IP地址',
  `action` varchar(64) NOT NULL DEFAULT '' COMMENT '操作动作',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT ' 操作状态 1-成功 0-失败',
  `result` varchar(64) NOT NULL DEFAULT '' COMMENT '操作结果',
  `comment` varchar(255) DEFAULT NULL COMMENT '补充信息',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1068 DEFAULT CHARSET=utf8mb4 COMMENT='用户操作日志表';

-- ----------------------------
-- Records of admin_log
-- ----------------------------
BEGIN;
INSERT INTO `admin_log` VALUES (1, 'admin', '', '', 1, '操作成功', NULL, NULL, NULL);
INSERT INTO `admin_log` VALUES (2, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, NULL, NULL);
INSERT INTO `admin_log` VALUES (3, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-15 16:34:41', NULL);
INSERT INTO `admin_log` VALUES (4, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-15 16:40:05', NULL);
INSERT INTO `admin_log` VALUES (5, 'admin', '0:0:0:0:0:0:0:1', '获取用户列表', 1, '操作成功', NULL, '2020-07-15 16:45:00', NULL);
INSERT INTO `admin_log` VALUES (6, 'admin', '0:0:0:0:0:0:0:1', '获取用户列表', 1, '操作成功', NULL, '2020-07-15 16:45:38', NULL);
INSERT INTO `admin_log` VALUES (7, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-15 21:58:48', NULL);
INSERT INTO `admin_log` VALUES (8, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-15 22:04:17', NULL);
INSERT INTO `admin_log` VALUES (9, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-15 22:59:17', NULL);
INSERT INTO `admin_log` VALUES (10, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-16 19:57:04', NULL);
INSERT INTO `admin_log` VALUES (11, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-16 20:08:38', NULL);
INSERT INTO `admin_log` VALUES (12, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-16 20:10:41', NULL);
INSERT INTO `admin_log` VALUES (13, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-16 20:19:13', NULL);
INSERT INTO `admin_log` VALUES (14, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-16 20:22:28', NULL);
INSERT INTO `admin_log` VALUES (15, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-16 20:28:20', NULL);
INSERT INTO `admin_log` VALUES (16, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-16 21:45:27', NULL);
INSERT INTO `admin_log` VALUES (17, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-16 21:45:42', NULL);
INSERT INTO `admin_log` VALUES (18, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-16 22:43:53', NULL);
INSERT INTO `admin_log` VALUES (19, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-17 22:02:47', NULL);
INSERT INTO `admin_log` VALUES (20, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-17 22:07:42', NULL);
INSERT INTO `admin_log` VALUES (21, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-17 22:07:53', NULL);
INSERT INTO `admin_log` VALUES (22, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-17 22:08:59', NULL);
INSERT INTO `admin_log` VALUES (23, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-17 22:12:27', NULL);
INSERT INTO `admin_log` VALUES (24, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-17 22:21:06', NULL);
INSERT INTO `admin_log` VALUES (25, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-17 22:21:25', NULL);
INSERT INTO `admin_log` VALUES (26, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-17 22:26:55', NULL);
INSERT INTO `admin_log` VALUES (27, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-17 22:28:10', NULL);
INSERT INTO `admin_log` VALUES (28, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-17 22:29:22', NULL);
INSERT INTO `admin_log` VALUES (29, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-17 22:52:51', NULL);
INSERT INTO `admin_log` VALUES (30, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-17 23:31:43', NULL);
INSERT INTO `admin_log` VALUES (31, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-17 23:34:04', NULL);
INSERT INTO `admin_log` VALUES (32, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-17 23:36:25', NULL);
INSERT INTO `admin_log` VALUES (33, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 09:45:10', NULL);
INSERT INTO `admin_log` VALUES (34, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 09:51:27', NULL);
INSERT INTO `admin_log` VALUES (35, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 09:52:11', NULL);
INSERT INTO `admin_log` VALUES (36, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-18 09:54:00', NULL);
INSERT INTO `admin_log` VALUES (37, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 10:00:12', NULL);
INSERT INTO `admin_log` VALUES (38, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 13:46:25', NULL);
INSERT INTO `admin_log` VALUES (39, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 14:05:18', NULL);
INSERT INTO `admin_log` VALUES (40, '订单管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 14:08:57', NULL);
INSERT INTO `admin_log` VALUES (41, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 14:09:54', NULL);
INSERT INTO `admin_log` VALUES (42, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 14:24:06', NULL);
INSERT INTO `admin_log` VALUES (43, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 14:24:08', NULL);
INSERT INTO `admin_log` VALUES (44, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 14:24:10', NULL);
INSERT INTO `admin_log` VALUES (45, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 16:28:33', NULL);
INSERT INTO `admin_log` VALUES (46, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 17:08:39', NULL);
INSERT INTO `admin_log` VALUES (47, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 17:19:25', NULL);
INSERT INTO `admin_log` VALUES (48, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 17:25:29', NULL);
INSERT INTO `admin_log` VALUES (49, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 17:27:24', NULL);
INSERT INTO `admin_log` VALUES (50, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 17:37:40', NULL);
INSERT INTO `admin_log` VALUES (51, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-18 17:51:32', NULL);
INSERT INTO `admin_log` VALUES (52, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 17:52:09', NULL);
INSERT INTO `admin_log` VALUES (53, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-18 17:52:22', NULL);
INSERT INTO `admin_log` VALUES (54, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 17:53:16', NULL);
INSERT INTO `admin_log` VALUES (55, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-18 17:53:43', NULL);
INSERT INTO `admin_log` VALUES (56, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 17:55:42', NULL);
INSERT INTO `admin_log` VALUES (57, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-18 17:56:08', NULL);
INSERT INTO `admin_log` VALUES (58, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-18 17:56:54', NULL);
INSERT INTO `admin_log` VALUES (59, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-18 17:57:58', NULL);
INSERT INTO `admin_log` VALUES (60, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-18 18:01:06', NULL);
INSERT INTO `admin_log` VALUES (61, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 18:50:35', NULL);
INSERT INTO `admin_log` VALUES (62, '运营管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-18 20:37:51', NULL);
INSERT INTO `admin_log` VALUES (63, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-19 22:50:44', NULL);
INSERT INTO `admin_log` VALUES (64, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-19 22:53:42', NULL);
INSERT INTO `admin_log` VALUES (65, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-19 22:55:24', NULL);
INSERT INTO `admin_log` VALUES (66, '运营管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-20 20:32:17', NULL);
INSERT INTO `admin_log` VALUES (67, '运营管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-20 21:00:33', NULL);
INSERT INTO `admin_log` VALUES (68, '运营管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-20 21:05:46', NULL);
INSERT INTO `admin_log` VALUES (69, '运营管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-20 21:14:37', NULL);
INSERT INTO `admin_log` VALUES (70, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-20 21:18:20', NULL);
INSERT INTO `admin_log` VALUES (71, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-20 21:37:28', NULL);
INSERT INTO `admin_log` VALUES (72, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-20 21:55:16', NULL);
INSERT INTO `admin_log` VALUES (73, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-20 22:02:27', NULL);
INSERT INTO `admin_log` VALUES (74, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-20 22:02:40', NULL);
INSERT INTO `admin_log` VALUES (75, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-20 22:03:38', NULL);
INSERT INTO `admin_log` VALUES (76, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-20 22:04:42', NULL);
INSERT INTO `admin_log` VALUES (77, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-20 22:20:11', NULL);
INSERT INTO `admin_log` VALUES (78, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-20 22:24:37', NULL);
INSERT INTO `admin_log` VALUES (79, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-20 22:25:05', NULL);
INSERT INTO `admin_log` VALUES (80, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-20 23:12:45', NULL);
INSERT INTO `admin_log` VALUES (81, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-20 23:13:13', NULL);
INSERT INTO `admin_log` VALUES (82, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-20 23:31:52', NULL);
INSERT INTO `admin_log` VALUES (83, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:01:30', NULL);
INSERT INTO `admin_log` VALUES (84, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:06:30', NULL);
INSERT INTO `admin_log` VALUES (85, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:07:48', NULL);
INSERT INTO `admin_log` VALUES (86, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:09:28', NULL);
INSERT INTO `admin_log` VALUES (87, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:10:13', NULL);
INSERT INTO `admin_log` VALUES (88, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:10:45', NULL);
INSERT INTO `admin_log` VALUES (89, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:14:20', NULL);
INSERT INTO `admin_log` VALUES (90, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:16:30', NULL);
INSERT INTO `admin_log` VALUES (91, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:16:38', NULL);
INSERT INTO `admin_log` VALUES (92, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:31:38', NULL);
INSERT INTO `admin_log` VALUES (93, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:31:40', NULL);
INSERT INTO `admin_log` VALUES (94, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:31:41', NULL);
INSERT INTO `admin_log` VALUES (95, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:31:41', NULL);
INSERT INTO `admin_log` VALUES (96, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 11:32:33', NULL);
INSERT INTO `admin_log` VALUES (97, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 12:29:25', NULL);
INSERT INTO `admin_log` VALUES (98, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:21:15', NULL);
INSERT INTO `admin_log` VALUES (99, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:26:04', NULL);
INSERT INTO `admin_log` VALUES (100, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:28:38', NULL);
INSERT INTO `admin_log` VALUES (101, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:28:48', NULL);
INSERT INTO `admin_log` VALUES (102, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:28:50', NULL);
INSERT INTO `admin_log` VALUES (103, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:29:20', NULL);
INSERT INTO `admin_log` VALUES (104, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 13:29:47', NULL);
INSERT INTO `admin_log` VALUES (105, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:32:57', NULL);
INSERT INTO `admin_log` VALUES (106, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:36:50', NULL);
INSERT INTO `admin_log` VALUES (107, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:37:00', NULL);
INSERT INTO `admin_log` VALUES (108, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 13:37:05', NULL);
INSERT INTO `admin_log` VALUES (109, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:37:10', NULL);
INSERT INTO `admin_log` VALUES (110, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:37:18', NULL);
INSERT INTO `admin_log` VALUES (111, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:37:21', NULL);
INSERT INTO `admin_log` VALUES (112, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:37:23', NULL);
INSERT INTO `admin_log` VALUES (113, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:37:26', NULL);
INSERT INTO `admin_log` VALUES (114, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:37:37', NULL);
INSERT INTO `admin_log` VALUES (115, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:37:41', NULL);
INSERT INTO `admin_log` VALUES (116, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:37:46', NULL);
INSERT INTO `admin_log` VALUES (117, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:37:52', NULL);
INSERT INTO `admin_log` VALUES (118, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:37:53', NULL);
INSERT INTO `admin_log` VALUES (119, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:39:45', NULL);
INSERT INTO `admin_log` VALUES (120, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 13:39:53', NULL);
INSERT INTO `admin_log` VALUES (121, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:39:58', NULL);
INSERT INTO `admin_log` VALUES (122, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:40:04', NULL);
INSERT INTO `admin_log` VALUES (123, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:40:46', NULL);
INSERT INTO `admin_log` VALUES (124, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:41:56', NULL);
INSERT INTO `admin_log` VALUES (125, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:43:15', NULL);
INSERT INTO `admin_log` VALUES (126, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:43:20', NULL);
INSERT INTO `admin_log` VALUES (127, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:43:34', NULL);
INSERT INTO `admin_log` VALUES (128, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:46:39', NULL);
INSERT INTO `admin_log` VALUES (129, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:47:24', NULL);
INSERT INTO `admin_log` VALUES (130, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:47:28', NULL);
INSERT INTO `admin_log` VALUES (131, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:48:43', NULL);
INSERT INTO `admin_log` VALUES (132, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:48:53', NULL);
INSERT INTO `admin_log` VALUES (133, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:48:55', NULL);
INSERT INTO `admin_log` VALUES (134, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 13:49:24', NULL);
INSERT INTO `admin_log` VALUES (135, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 13:50:14', NULL);
INSERT INTO `admin_log` VALUES (136, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:50:19', NULL);
INSERT INTO `admin_log` VALUES (137, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:50:20', NULL);
INSERT INTO `admin_log` VALUES (138, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:50:41', NULL);
INSERT INTO `admin_log` VALUES (139, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:50:43', NULL);
INSERT INTO `admin_log` VALUES (140, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 13:52:52', NULL);
INSERT INTO `admin_log` VALUES (141, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:16:01', NULL);
INSERT INTO `admin_log` VALUES (142, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:16:17', NULL);
INSERT INTO `admin_log` VALUES (143, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:17:42', NULL);
INSERT INTO `admin_log` VALUES (144, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:18:47', NULL);
INSERT INTO `admin_log` VALUES (145, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:20:15', NULL);
INSERT INTO `admin_log` VALUES (146, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:21:55', NULL);
INSERT INTO `admin_log` VALUES (147, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:22:50', NULL);
INSERT INTO `admin_log` VALUES (148, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:23:01', NULL);
INSERT INTO `admin_log` VALUES (149, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:23:44', NULL);
INSERT INTO `admin_log` VALUES (150, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:24:33', NULL);
INSERT INTO `admin_log` VALUES (151, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:24:34', NULL);
INSERT INTO `admin_log` VALUES (152, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:24:54', NULL);
INSERT INTO `admin_log` VALUES (153, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:25:12', NULL);
INSERT INTO `admin_log` VALUES (154, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:29:24', NULL);
INSERT INTO `admin_log` VALUES (155, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:29:31', NULL);
INSERT INTO `admin_log` VALUES (156, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:31:31', NULL);
INSERT INTO `admin_log` VALUES (157, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:31:58', NULL);
INSERT INTO `admin_log` VALUES (158, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:32:22', NULL);
INSERT INTO `admin_log` VALUES (159, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:34:03', NULL);
INSERT INTO `admin_log` VALUES (160, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:34:10', NULL);
INSERT INTO `admin_log` VALUES (161, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:35:06', NULL);
INSERT INTO `admin_log` VALUES (162, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:35:15', NULL);
INSERT INTO `admin_log` VALUES (163, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:36:17', NULL);
INSERT INTO `admin_log` VALUES (164, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:36:22', NULL);
INSERT INTO `admin_log` VALUES (165, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:37:29', NULL);
INSERT INTO `admin_log` VALUES (166, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:37:34', NULL);
INSERT INTO `admin_log` VALUES (167, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:39:24', NULL);
INSERT INTO `admin_log` VALUES (168, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:39:29', NULL);
INSERT INTO `admin_log` VALUES (169, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:39:29', NULL);
INSERT INTO `admin_log` VALUES (170, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:39:35', NULL);
INSERT INTO `admin_log` VALUES (171, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:39:35', NULL);
INSERT INTO `admin_log` VALUES (172, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:39:42', NULL);
INSERT INTO `admin_log` VALUES (173, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:39:42', NULL);
INSERT INTO `admin_log` VALUES (174, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:41:44', NULL);
INSERT INTO `admin_log` VALUES (175, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:41:44', NULL);
INSERT INTO `admin_log` VALUES (176, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:42:25', NULL);
INSERT INTO `admin_log` VALUES (177, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:42:26', NULL);
INSERT INTO `admin_log` VALUES (178, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:43:09', NULL);
INSERT INTO `admin_log` VALUES (179, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:43:26', NULL);
INSERT INTO `admin_log` VALUES (180, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:43:46', NULL);
INSERT INTO `admin_log` VALUES (181, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:43:54', NULL);
INSERT INTO `admin_log` VALUES (182, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:45:51', NULL);
INSERT INTO `admin_log` VALUES (183, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:45:51', NULL);
INSERT INTO `admin_log` VALUES (184, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:47:26', NULL);
INSERT INTO `admin_log` VALUES (185, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:47:26', NULL);
INSERT INTO `admin_log` VALUES (186, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:50:04', NULL);
INSERT INTO `admin_log` VALUES (187, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:50:04', NULL);
INSERT INTO `admin_log` VALUES (188, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:57:21', NULL);
INSERT INTO `admin_log` VALUES (189, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:57:21', NULL);
INSERT INTO `admin_log` VALUES (190, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 16:59:06', NULL);
INSERT INTO `admin_log` VALUES (191, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 16:59:06', NULL);
INSERT INTO `admin_log` VALUES (192, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:00:30', NULL);
INSERT INTO `admin_log` VALUES (193, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:00:30', NULL);
INSERT INTO `admin_log` VALUES (194, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:01:46', NULL);
INSERT INTO `admin_log` VALUES (195, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:01:47', NULL);
INSERT INTO `admin_log` VALUES (196, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:02:27', NULL);
INSERT INTO `admin_log` VALUES (197, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:02:27', NULL);
INSERT INTO `admin_log` VALUES (198, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:04:26', NULL);
INSERT INTO `admin_log` VALUES (199, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:04:26', NULL);
INSERT INTO `admin_log` VALUES (200, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:04:31', NULL);
INSERT INTO `admin_log` VALUES (201, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:04:31', NULL);
INSERT INTO `admin_log` VALUES (202, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:06:06', NULL);
INSERT INTO `admin_log` VALUES (203, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:06:06', NULL);
INSERT INTO `admin_log` VALUES (204, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:07:01', NULL);
INSERT INTO `admin_log` VALUES (205, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:07:01', NULL);
INSERT INTO `admin_log` VALUES (206, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:07:52', NULL);
INSERT INTO `admin_log` VALUES (207, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:07:52', NULL);
INSERT INTO `admin_log` VALUES (208, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:08:15', NULL);
INSERT INTO `admin_log` VALUES (209, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:08:15', NULL);
INSERT INTO `admin_log` VALUES (210, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:09:24', NULL);
INSERT INTO `admin_log` VALUES (211, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:09:24', NULL);
INSERT INTO `admin_log` VALUES (212, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:10:19', NULL);
INSERT INTO `admin_log` VALUES (213, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:10:19', NULL);
INSERT INTO `admin_log` VALUES (214, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:11:04', NULL);
INSERT INTO `admin_log` VALUES (215, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:11:04', NULL);
INSERT INTO `admin_log` VALUES (216, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:11:20', NULL);
INSERT INTO `admin_log` VALUES (217, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:11:20', NULL);
INSERT INTO `admin_log` VALUES (218, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:11:36', NULL);
INSERT INTO `admin_log` VALUES (219, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:11:36', NULL);
INSERT INTO `admin_log` VALUES (220, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:12:07', NULL);
INSERT INTO `admin_log` VALUES (221, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:12:07', NULL);
INSERT INTO `admin_log` VALUES (222, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:13:35', NULL);
INSERT INTO `admin_log` VALUES (223, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:13:35', NULL);
INSERT INTO `admin_log` VALUES (224, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:14:02', NULL);
INSERT INTO `admin_log` VALUES (225, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:14:03', NULL);
INSERT INTO `admin_log` VALUES (226, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:15:56', NULL);
INSERT INTO `admin_log` VALUES (227, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:15:59', NULL);
INSERT INTO `admin_log` VALUES (228, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:19:06', NULL);
INSERT INTO `admin_log` VALUES (229, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:19:09', NULL);
INSERT INTO `admin_log` VALUES (230, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:19:20', NULL);
INSERT INTO `admin_log` VALUES (231, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 17:20:10', NULL);
INSERT INTO `admin_log` VALUES (232, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 17:20:14', NULL);
INSERT INTO `admin_log` VALUES (233, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 17:20:14', NULL);
INSERT INTO `admin_log` VALUES (234, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 20:10:35', NULL);
INSERT INTO `admin_log` VALUES (235, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:10:35', NULL);
INSERT INTO `admin_log` VALUES (236, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 20:17:18', NULL);
INSERT INTO `admin_log` VALUES (237, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 20:17:24', NULL);
INSERT INTO `admin_log` VALUES (238, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:17:24', NULL);
INSERT INTO `admin_log` VALUES (239, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:20:38', NULL);
INSERT INTO `admin_log` VALUES (240, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:21:35', NULL);
INSERT INTO `admin_log` VALUES (241, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:22:09', NULL);
INSERT INTO `admin_log` VALUES (242, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:35:13', NULL);
INSERT INTO `admin_log` VALUES (243, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:38:28', NULL);
INSERT INTO `admin_log` VALUES (244, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:38:29', NULL);
INSERT INTO `admin_log` VALUES (245, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:39:22', NULL);
INSERT INTO `admin_log` VALUES (246, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:42:07', NULL);
INSERT INTO `admin_log` VALUES (247, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:42:43', NULL);
INSERT INTO `admin_log` VALUES (248, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:45:38', NULL);
INSERT INTO `admin_log` VALUES (249, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:45:48', NULL);
INSERT INTO `admin_log` VALUES (250, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:47:04', NULL);
INSERT INTO `admin_log` VALUES (251, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:48:15', NULL);
INSERT INTO `admin_log` VALUES (252, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:48:46', NULL);
INSERT INTO `admin_log` VALUES (253, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:50:40', NULL);
INSERT INTO `admin_log` VALUES (254, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:53:02', NULL);
INSERT INTO `admin_log` VALUES (255, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:54:46', NULL);
INSERT INTO `admin_log` VALUES (256, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:57:07', NULL);
INSERT INTO `admin_log` VALUES (257, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 20:58:35', NULL);
INSERT INTO `admin_log` VALUES (258, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 20:58:40', NULL);
INSERT INTO `admin_log` VALUES (259, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 21:07:55', NULL);
INSERT INTO `admin_log` VALUES (260, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:07:55', NULL);
INSERT INTO `admin_log` VALUES (261, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:21:09', NULL);
INSERT INTO `admin_log` VALUES (262, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:21:46', NULL);
INSERT INTO `admin_log` VALUES (263, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:22:18', NULL);
INSERT INTO `admin_log` VALUES (264, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:24:32', NULL);
INSERT INTO `admin_log` VALUES (265, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:25:14', NULL);
INSERT INTO `admin_log` VALUES (266, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:25:56', NULL);
INSERT INTO `admin_log` VALUES (267, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:26:15', NULL);
INSERT INTO `admin_log` VALUES (268, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:28:22', NULL);
INSERT INTO `admin_log` VALUES (269, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:33:09', NULL);
INSERT INTO `admin_log` VALUES (270, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:34:50', NULL);
INSERT INTO `admin_log` VALUES (271, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:35:24', NULL);
INSERT INTO `admin_log` VALUES (272, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:37:17', NULL);
INSERT INTO `admin_log` VALUES (273, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:39:25', NULL);
INSERT INTO `admin_log` VALUES (274, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:45:51', NULL);
INSERT INTO `admin_log` VALUES (275, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:52:38', NULL);
INSERT INTO `admin_log` VALUES (276, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:58:42', NULL);
INSERT INTO `admin_log` VALUES (277, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 21:58:48', NULL);
INSERT INTO `admin_log` VALUES (278, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 21:59:59', NULL);
INSERT INTO `admin_log` VALUES (279, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 22:00:02', NULL);
INSERT INTO `admin_log` VALUES (280, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:00:02', NULL);
INSERT INTO `admin_log` VALUES (281, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:04:50', NULL);
INSERT INTO `admin_log` VALUES (282, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 22:05:34', NULL);
INSERT INTO `admin_log` VALUES (283, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 22:05:38', NULL);
INSERT INTO `admin_log` VALUES (284, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:05:38', NULL);
INSERT INTO `admin_log` VALUES (285, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 22:08:06', NULL);
INSERT INTO `admin_log` VALUES (286, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 22:08:14', NULL);
INSERT INTO `admin_log` VALUES (287, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:08:15', NULL);
INSERT INTO `admin_log` VALUES (288, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:16:52', NULL);
INSERT INTO `admin_log` VALUES (289, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:19:35', NULL);
INSERT INTO `admin_log` VALUES (290, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:21:53', NULL);
INSERT INTO `admin_log` VALUES (291, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:21:55', NULL);
INSERT INTO `admin_log` VALUES (292, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:28:13', NULL);
INSERT INTO `admin_log` VALUES (293, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:29:46', NULL);
INSERT INTO `admin_log` VALUES (294, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:34:49', NULL);
INSERT INTO `admin_log` VALUES (295, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:34:52', NULL);
INSERT INTO `admin_log` VALUES (296, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:37:57', NULL);
INSERT INTO `admin_log` VALUES (297, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:37:59', NULL);
INSERT INTO `admin_log` VALUES (298, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 22:38:07', NULL);
INSERT INTO `admin_log` VALUES (299, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 22:38:11', NULL);
INSERT INTO `admin_log` VALUES (300, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:38:11', NULL);
INSERT INTO `admin_log` VALUES (301, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:39:57', NULL);
INSERT INTO `admin_log` VALUES (302, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:41:29', NULL);
INSERT INTO `admin_log` VALUES (303, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:41:34', NULL);
INSERT INTO `admin_log` VALUES (304, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 22:43:33', NULL);
INSERT INTO `admin_log` VALUES (305, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 22:43:38', NULL);
INSERT INTO `admin_log` VALUES (306, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:43:39', NULL);
INSERT INTO `admin_log` VALUES (307, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:46:50', NULL);
INSERT INTO `admin_log` VALUES (308, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:48:52', NULL);
INSERT INTO `admin_log` VALUES (309, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-21 22:48:56', NULL);
INSERT INTO `admin_log` VALUES (310, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-21 22:49:00', NULL);
INSERT INTO `admin_log` VALUES (311, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:49:01', NULL);
INSERT INTO `admin_log` VALUES (312, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-21 22:52:24', NULL);
INSERT INTO `admin_log` VALUES (313, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 19:36:55', NULL);
INSERT INTO `admin_log` VALUES (314, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:36:55', NULL);
INSERT INTO `admin_log` VALUES (315, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:39:30', NULL);
INSERT INTO `admin_log` VALUES (316, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:39:37', NULL);
INSERT INTO `admin_log` VALUES (317, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:45:53', NULL);
INSERT INTO `admin_log` VALUES (318, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:46:35', NULL);
INSERT INTO `admin_log` VALUES (319, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:46:47', NULL);
INSERT INTO `admin_log` VALUES (320, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-22 19:47:10', NULL);
INSERT INTO `admin_log` VALUES (321, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 19:47:21', NULL);
INSERT INTO `admin_log` VALUES (322, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:47:21', NULL);
INSERT INTO `admin_log` VALUES (323, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:48:25', NULL);
INSERT INTO `admin_log` VALUES (324, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:51:17', NULL);
INSERT INTO `admin_log` VALUES (325, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:51:19', NULL);
INSERT INTO `admin_log` VALUES (326, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:55:41', NULL);
INSERT INTO `admin_log` VALUES (327, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:56:10', NULL);
INSERT INTO `admin_log` VALUES (328, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-22 19:57:33', NULL);
INSERT INTO `admin_log` VALUES (329, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 19:57:37', NULL);
INSERT INTO `admin_log` VALUES (330, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:57:37', NULL);
INSERT INTO `admin_log` VALUES (331, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 19:57:50', NULL);
INSERT INTO `admin_log` VALUES (332, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:02:06', NULL);
INSERT INTO `admin_log` VALUES (333, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:05:52', NULL);
INSERT INTO `admin_log` VALUES (334, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:06:09', NULL);
INSERT INTO `admin_log` VALUES (335, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-22 20:06:50', NULL);
INSERT INTO `admin_log` VALUES (336, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 20:06:54', NULL);
INSERT INTO `admin_log` VALUES (337, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:06:54', NULL);
INSERT INTO `admin_log` VALUES (338, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:07:59', NULL);
INSERT INTO `admin_log` VALUES (339, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:19:47', NULL);
INSERT INTO `admin_log` VALUES (340, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:20:52', NULL);
INSERT INTO `admin_log` VALUES (341, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:23:43', NULL);
INSERT INTO `admin_log` VALUES (342, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:25:30', NULL);
INSERT INTO `admin_log` VALUES (343, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:26:43', NULL);
INSERT INTO `admin_log` VALUES (344, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:26:48', NULL);
INSERT INTO `admin_log` VALUES (345, 'admin', '0:0:0:0:0:0:0:1', '后台用户注销', 1, '操作成功', NULL, '2020-07-22 20:27:36', NULL);
INSERT INTO `admin_log` VALUES (346, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 20:27:39', NULL);
INSERT INTO `admin_log` VALUES (347, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:27:39', NULL);
INSERT INTO `admin_log` VALUES (348, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:34:45', NULL);
INSERT INTO `admin_log` VALUES (349, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:35:59', NULL);
INSERT INTO `admin_log` VALUES (350, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:36:00', NULL);
INSERT INTO `admin_log` VALUES (351, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 20:36:03', NULL);
INSERT INTO `admin_log` VALUES (352, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:37:21', NULL);
INSERT INTO `admin_log` VALUES (353, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 20:40:06', NULL);
INSERT INTO `admin_log` VALUES (354, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:40:06', NULL);
INSERT INTO `admin_log` VALUES (355, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 20:46:23', NULL);
INSERT INTO `admin_log` VALUES (356, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:46:23', NULL);
INSERT INTO `admin_log` VALUES (357, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 20:46:54', NULL);
INSERT INTO `admin_log` VALUES (358, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:46:54', NULL);
INSERT INTO `admin_log` VALUES (359, '商品管理测试', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 20:48:16', NULL);
INSERT INTO `admin_log` VALUES (360, '商品管理测试', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:48:16', NULL);
INSERT INTO `admin_log` VALUES (361, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-22 20:48:47', NULL);
INSERT INTO `admin_log` VALUES (362, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-22 20:48:47', NULL);
INSERT INTO `admin_log` VALUES (363, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-23 23:28:50', NULL);
INSERT INTO `admin_log` VALUES (364, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 09:38:21', NULL);
INSERT INTO `admin_log` VALUES (365, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 09:38:21', NULL);
INSERT INTO `admin_log` VALUES (366, 'admin', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-24 09:38:21', NULL);
INSERT INTO `admin_log` VALUES (367, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 09:42:19', NULL);
INSERT INTO `admin_log` VALUES (368, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 09:42:19', NULL);
INSERT INTO `admin_log` VALUES (369, 'admin', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-24 09:42:27', NULL);
INSERT INTO `admin_log` VALUES (370, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 10:10:27', NULL);
INSERT INTO `admin_log` VALUES (371, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:10:28', NULL);
INSERT INTO `admin_log` VALUES (372, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:12:50', NULL);
INSERT INTO `admin_log` VALUES (373, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:13:12', NULL);
INSERT INTO `admin_log` VALUES (374, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:20:21', NULL);
INSERT INTO `admin_log` VALUES (375, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:21:03', NULL);
INSERT INTO `admin_log` VALUES (376, 'admin', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-24 10:21:05', NULL);
INSERT INTO `admin_log` VALUES (377, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 10:22:46', NULL);
INSERT INTO `admin_log` VALUES (378, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:22:46', NULL);
INSERT INTO `admin_log` VALUES (379, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:24:16', NULL);
INSERT INTO `admin_log` VALUES (380, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:24:59', NULL);
INSERT INTO `admin_log` VALUES (381, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:25:18', NULL);
INSERT INTO `admin_log` VALUES (382, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:27:40', NULL);
INSERT INTO `admin_log` VALUES (383, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:36:24', NULL);
INSERT INTO `admin_log` VALUES (384, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:38:18', NULL);
INSERT INTO `admin_log` VALUES (385, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:39:05', NULL);
INSERT INTO `admin_log` VALUES (386, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:40:06', NULL);
INSERT INTO `admin_log` VALUES (387, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:40:56', NULL);
INSERT INTO `admin_log` VALUES (388, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:44:45', NULL);
INSERT INTO `admin_log` VALUES (389, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:45:27', NULL);
INSERT INTO `admin_log` VALUES (390, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:47:33', NULL);
INSERT INTO `admin_log` VALUES (391, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:52:26', NULL);
INSERT INTO `admin_log` VALUES (392, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:52:38', NULL);
INSERT INTO `admin_log` VALUES (393, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 10:55:29', NULL);
INSERT INTO `admin_log` VALUES (394, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 10:55:29', NULL);
INSERT INTO `admin_log` VALUES (395, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 10:59:42', NULL);
INSERT INTO `admin_log` VALUES (396, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 11:00:43', NULL);
INSERT INTO `admin_log` VALUES (397, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 11:01:25', NULL);
INSERT INTO `admin_log` VALUES (398, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 11:04:41', NULL);
INSERT INTO `admin_log` VALUES (399, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 11:05:50', NULL);
INSERT INTO `admin_log` VALUES (400, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 11:07:31', NULL);
INSERT INTO `admin_log` VALUES (401, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 11:08:03', NULL);
INSERT INTO `admin_log` VALUES (402, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 11:08:12', NULL);
INSERT INTO `admin_log` VALUES (403, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 11:33:34', NULL);
INSERT INTO `admin_log` VALUES (404, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 11:33:34', NULL);
INSERT INTO `admin_log` VALUES (405, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 11:35:53', NULL);
INSERT INTO `admin_log` VALUES (406, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 11:36:12', NULL);
INSERT INTO `admin_log` VALUES (407, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 11:36:12', NULL);
INSERT INTO `admin_log` VALUES (408, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 13:42:26', NULL);
INSERT INTO `admin_log` VALUES (409, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 13:42:27', NULL);
INSERT INTO `admin_log` VALUES (410, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 13:48:35', NULL);
INSERT INTO `admin_log` VALUES (411, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 15:05:17', NULL);
INSERT INTO `admin_log` VALUES (412, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:05:17', NULL);
INSERT INTO `admin_log` VALUES (413, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:05:49', NULL);
INSERT INTO `admin_log` VALUES (414, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:06:04', NULL);
INSERT INTO `admin_log` VALUES (415, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:06:19', NULL);
INSERT INTO `admin_log` VALUES (416, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 15:15:23', NULL);
INSERT INTO `admin_log` VALUES (417, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:15:24', NULL);
INSERT INTO `admin_log` VALUES (418, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 15:19:48', NULL);
INSERT INTO `admin_log` VALUES (419, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:19:48', NULL);
INSERT INTO `admin_log` VALUES (420, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:22:26', NULL);
INSERT INTO `admin_log` VALUES (421, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:22:31', NULL);
INSERT INTO `admin_log` VALUES (422, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:25:02', NULL);
INSERT INTO `admin_log` VALUES (423, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:25:26', NULL);
INSERT INTO `admin_log` VALUES (424, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:39:43', NULL);
INSERT INTO `admin_log` VALUES (425, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 15:40:27', NULL);
INSERT INTO `admin_log` VALUES (426, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:40:27', NULL);
INSERT INTO `admin_log` VALUES (427, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:41:51', NULL);
INSERT INTO `admin_log` VALUES (428, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:45:54', NULL);
INSERT INTO `admin_log` VALUES (429, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:47:43', NULL);
INSERT INTO `admin_log` VALUES (430, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:48:46', NULL);
INSERT INTO `admin_log` VALUES (431, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:51:53', NULL);
INSERT INTO `admin_log` VALUES (432, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:52:54', NULL);
INSERT INTO `admin_log` VALUES (433, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:55:14', NULL);
INSERT INTO `admin_log` VALUES (434, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:57:11', NULL);
INSERT INTO `admin_log` VALUES (435, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:58:39', NULL);
INSERT INTO `admin_log` VALUES (436, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 15:59:11', NULL);
INSERT INTO `admin_log` VALUES (437, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:00:28', NULL);
INSERT INTO `admin_log` VALUES (438, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:02:15', NULL);
INSERT INTO `admin_log` VALUES (439, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:02:55', NULL);
INSERT INTO `admin_log` VALUES (440, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:05:17', NULL);
INSERT INTO `admin_log` VALUES (441, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:05:37', NULL);
INSERT INTO `admin_log` VALUES (442, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:06:38', NULL);
INSERT INTO `admin_log` VALUES (443, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:08:16', NULL);
INSERT INTO `admin_log` VALUES (444, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 16:08:43', NULL);
INSERT INTO `admin_log` VALUES (445, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:08:43', NULL);
INSERT INTO `admin_log` VALUES (446, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:09:27', NULL);
INSERT INTO `admin_log` VALUES (447, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:16:28', NULL);
INSERT INTO `admin_log` VALUES (448, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:17:33', NULL);
INSERT INTO `admin_log` VALUES (449, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:18:43', NULL);
INSERT INTO `admin_log` VALUES (450, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:21:09', NULL);
INSERT INTO `admin_log` VALUES (451, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:21:58', NULL);
INSERT INTO `admin_log` VALUES (452, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:24:18', NULL);
INSERT INTO `admin_log` VALUES (453, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:26:37', NULL);
INSERT INTO `admin_log` VALUES (454, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:27:52', NULL);
INSERT INTO `admin_log` VALUES (455, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:37:45', NULL);
INSERT INTO `admin_log` VALUES (456, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:39:12', NULL);
INSERT INTO `admin_log` VALUES (457, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:40:15', NULL);
INSERT INTO `admin_log` VALUES (458, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:41:36', NULL);
INSERT INTO `admin_log` VALUES (459, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:42:37', NULL);
INSERT INTO `admin_log` VALUES (460, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:45:17', NULL);
INSERT INTO `admin_log` VALUES (461, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:46:08', NULL);
INSERT INTO `admin_log` VALUES (462, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 16:54:08', NULL);
INSERT INTO `admin_log` VALUES (463, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:54:08', NULL);
INSERT INTO `admin_log` VALUES (464, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 16:59:39', NULL);
INSERT INTO `admin_log` VALUES (465, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 16:59:39', NULL);
INSERT INTO `admin_log` VALUES (466, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 17:00:30', NULL);
INSERT INTO `admin_log` VALUES (467, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 17:03:01', NULL);
INSERT INTO `admin_log` VALUES (468, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:29:34', NULL);
INSERT INTO `admin_log` VALUES (469, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:29:59', NULL);
INSERT INTO `admin_log` VALUES (470, '商品管理测试', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:30:28', NULL);
INSERT INTO `admin_log` VALUES (471, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:31:39', NULL);
INSERT INTO `admin_log` VALUES (472, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:32:29', NULL);
INSERT INTO `admin_log` VALUES (473, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:34:06', NULL);
INSERT INTO `admin_log` VALUES (474, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:36:22', NULL);
INSERT INTO `admin_log` VALUES (475, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:37:01', NULL);
INSERT INTO `admin_log` VALUES (476, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:42:01', NULL);
INSERT INTO `admin_log` VALUES (477, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:43:28', NULL);
INSERT INTO `admin_log` VALUES (478, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:45:03', NULL);
INSERT INTO `admin_log` VALUES (479, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:45:25', NULL);
INSERT INTO `admin_log` VALUES (480, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:46:02', NULL);
INSERT INTO `admin_log` VALUES (481, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:48:00', NULL);
INSERT INTO `admin_log` VALUES (482, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:48:07', NULL);
INSERT INTO `admin_log` VALUES (483, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:48:19', NULL);
INSERT INTO `admin_log` VALUES (484, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:48:19', NULL);
INSERT INTO `admin_log` VALUES (485, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:48:20', NULL);
INSERT INTO `admin_log` VALUES (486, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:48:21', NULL);
INSERT INTO `admin_log` VALUES (487, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:50:17', NULL);
INSERT INTO `admin_log` VALUES (488, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 17:50:34', NULL);
INSERT INTO `admin_log` VALUES (489, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 17:52:36', NULL);
INSERT INTO `admin_log` VALUES (490, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 17:53:20', NULL);
INSERT INTO `admin_log` VALUES (491, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 17:54:08', NULL);
INSERT INTO `admin_log` VALUES (492, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 17:55:18', NULL);
INSERT INTO `admin_log` VALUES (493, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 17:55:44', NULL);
INSERT INTO `admin_log` VALUES (494, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 17:56:39', NULL);
INSERT INTO `admin_log` VALUES (495, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 17:59:43', NULL);
INSERT INTO `admin_log` VALUES (496, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:00:46', NULL);
INSERT INTO `admin_log` VALUES (497, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 18:01:09', NULL);
INSERT INTO `admin_log` VALUES (498, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:01:09', NULL);
INSERT INTO `admin_log` VALUES (499, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:03:56', NULL);
INSERT INTO `admin_log` VALUES (500, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:15:02', NULL);
INSERT INTO `admin_log` VALUES (501, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:15:55', NULL);
INSERT INTO `admin_log` VALUES (502, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:16:58', NULL);
INSERT INTO `admin_log` VALUES (503, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:17:30', NULL);
INSERT INTO `admin_log` VALUES (504, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:18:16', NULL);
INSERT INTO `admin_log` VALUES (505, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:18:55', NULL);
INSERT INTO `admin_log` VALUES (506, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:20:05', NULL);
INSERT INTO `admin_log` VALUES (507, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:21:31', NULL);
INSERT INTO `admin_log` VALUES (508, 'admin', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-24 18:21:31', NULL);
INSERT INTO `admin_log` VALUES (509, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 18:22:14', NULL);
INSERT INTO `admin_log` VALUES (510, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:22:14', NULL);
INSERT INTO `admin_log` VALUES (511, 'admin', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-24 18:22:14', NULL);
INSERT INTO `admin_log` VALUES (512, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 18:23:45', NULL);
INSERT INTO `admin_log` VALUES (513, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:23:45', NULL);
INSERT INTO `admin_log` VALUES (514, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:24:38', NULL);
INSERT INTO `admin_log` VALUES (515, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:26:31', NULL);
INSERT INTO `admin_log` VALUES (516, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:33:37', NULL);
INSERT INTO `admin_log` VALUES (517, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:35:47', NULL);
INSERT INTO `admin_log` VALUES (518, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:36:32', NULL);
INSERT INTO `admin_log` VALUES (519, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:38:47', NULL);
INSERT INTO `admin_log` VALUES (520, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:39:07', NULL);
INSERT INTO `admin_log` VALUES (521, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:41:11', NULL);
INSERT INTO `admin_log` VALUES (522, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:41:46', NULL);
INSERT INTO `admin_log` VALUES (523, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:42:13', NULL);
INSERT INTO `admin_log` VALUES (524, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 18:43:10', NULL);
INSERT INTO `admin_log` VALUES (525, '商品管理测试', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 20:09:54', NULL);
INSERT INTO `admin_log` VALUES (526, '商品管理测试', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 20:09:54', NULL);
INSERT INTO `admin_log` VALUES (527, '商品管理测试', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-24 20:10:21', NULL);
INSERT INTO `admin_log` VALUES (528, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 20:10:38', NULL);
INSERT INTO `admin_log` VALUES (529, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 20:10:38', NULL);
INSERT INTO `admin_log` VALUES (530, 'admin', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-24 20:10:45', NULL);
INSERT INTO `admin_log` VALUES (531, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 20:11:02', NULL);
INSERT INTO `admin_log` VALUES (532, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 20:11:02', NULL);
INSERT INTO `admin_log` VALUES (533, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 20:15:06', NULL);
INSERT INTO `admin_log` VALUES (534, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 20:15:06', NULL);
INSERT INTO `admin_log` VALUES (535, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 20:15:18', NULL);
INSERT INTO `admin_log` VALUES (536, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 20:16:33', NULL);
INSERT INTO `admin_log` VALUES (537, 'admin', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-24 20:16:56', NULL);
INSERT INTO `admin_log` VALUES (538, '商品管理测试', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 20:17:23', NULL);
INSERT INTO `admin_log` VALUES (539, '商品管理测试', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 20:17:23', NULL);
INSERT INTO `admin_log` VALUES (540, '商品管理测试', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-24 20:17:37', NULL);
INSERT INTO `admin_log` VALUES (541, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 20:17:49', NULL);
INSERT INTO `admin_log` VALUES (542, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 20:17:49', NULL);
INSERT INTO `admin_log` VALUES (543, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 20:32:09', NULL);
INSERT INTO `admin_log` VALUES (544, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 20:48:35', NULL);
INSERT INTO `admin_log` VALUES (545, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 20:48:35', NULL);
INSERT INTO `admin_log` VALUES (546, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-24 21:11:19', NULL);
INSERT INTO `admin_log` VALUES (547, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:11:20', NULL);
INSERT INTO `admin_log` VALUES (548, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:21:26', NULL);
INSERT INTO `admin_log` VALUES (549, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:23:21', NULL);
INSERT INTO `admin_log` VALUES (550, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:25:42', NULL);
INSERT INTO `admin_log` VALUES (551, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:27:25', NULL);
INSERT INTO `admin_log` VALUES (552, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:31:47', NULL);
INSERT INTO `admin_log` VALUES (553, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:33:31', NULL);
INSERT INTO `admin_log` VALUES (554, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:36:30', NULL);
INSERT INTO `admin_log` VALUES (555, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:39:48', NULL);
INSERT INTO `admin_log` VALUES (556, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:42:48', NULL);
INSERT INTO `admin_log` VALUES (557, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:43:03', NULL);
INSERT INTO `admin_log` VALUES (558, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:43:09', NULL);
INSERT INTO `admin_log` VALUES (559, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:44:41', NULL);
INSERT INTO `admin_log` VALUES (560, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:45:02', NULL);
INSERT INTO `admin_log` VALUES (561, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:45:58', NULL);
INSERT INTO `admin_log` VALUES (562, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:47:05', NULL);
INSERT INTO `admin_log` VALUES (563, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:48:09', NULL);
INSERT INTO `admin_log` VALUES (564, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 21:59:21', NULL);
INSERT INTO `admin_log` VALUES (565, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:03:23', NULL);
INSERT INTO `admin_log` VALUES (566, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:03:40', NULL);
INSERT INTO `admin_log` VALUES (567, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:04:23', NULL);
INSERT INTO `admin_log` VALUES (568, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:05:24', NULL);
INSERT INTO `admin_log` VALUES (569, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:05:37', NULL);
INSERT INTO `admin_log` VALUES (570, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:08:02', NULL);
INSERT INTO `admin_log` VALUES (571, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:08:22', NULL);
INSERT INTO `admin_log` VALUES (572, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:09:09', NULL);
INSERT INTO `admin_log` VALUES (573, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:09:53', NULL);
INSERT INTO `admin_log` VALUES (574, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:10:07', NULL);
INSERT INTO `admin_log` VALUES (575, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:10:53', NULL);
INSERT INTO `admin_log` VALUES (576, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:13:37', NULL);
INSERT INTO `admin_log` VALUES (577, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:14:49', NULL);
INSERT INTO `admin_log` VALUES (578, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:16:43', NULL);
INSERT INTO `admin_log` VALUES (579, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:17:15', NULL);
INSERT INTO `admin_log` VALUES (580, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:17:26', NULL);
INSERT INTO `admin_log` VALUES (581, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:17:59', NULL);
INSERT INTO `admin_log` VALUES (582, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:18:54', NULL);
INSERT INTO `admin_log` VALUES (583, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:19:24', NULL);
INSERT INTO `admin_log` VALUES (584, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:19:35', NULL);
INSERT INTO `admin_log` VALUES (585, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:20:10', NULL);
INSERT INTO `admin_log` VALUES (586, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:20:47', NULL);
INSERT INTO `admin_log` VALUES (587, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-24 22:34:34', NULL);
INSERT INTO `admin_log` VALUES (588, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-25 21:35:30', NULL);
INSERT INTO `admin_log` VALUES (589, 'admin', '0:0:0:0:0:0:0:1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-25 21:36:18', NULL);
INSERT INTO `admin_log` VALUES (590, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-25 21:54:56', NULL);
INSERT INTO `admin_log` VALUES (591, 'admin', '0:0:0:0:0:0:0:1', '', 1, '操作成功', NULL, '2020-07-25 22:08:51', NULL);
INSERT INTO `admin_log` VALUES (592, 'admin', '0:0:0:0:0:0:0:1', '', 1, '操作成功', NULL, '2020-07-25 22:13:09', NULL);
INSERT INTO `admin_log` VALUES (593, 'admin', '0:0:0:0:0:0:0:1', '', 1, '操作成功', NULL, '2020-07-25 22:13:49', NULL);
INSERT INTO `admin_log` VALUES (594, 'admin', '0:0:0:0:0:0:0:1', '', 1, '操作成功', NULL, '2020-07-25 22:14:30', NULL);
INSERT INTO `admin_log` VALUES (595, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-25 22:29:58', NULL);
INSERT INTO `admin_log` VALUES (596, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-25 22:36:29', NULL);
INSERT INTO `admin_log` VALUES (597, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-25 22:39:02', NULL);
INSERT INTO `admin_log` VALUES (598, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-25 22:46:59', NULL);
INSERT INTO `admin_log` VALUES (599, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-25 23:11:45', NULL);
INSERT INTO `admin_log` VALUES (600, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-25 23:15:00', NULL);
INSERT INTO `admin_log` VALUES (601, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-25 23:22:38', NULL);
INSERT INTO `admin_log` VALUES (602, 'admin', '0:0:0:0:0:0:0:1', '', 1, '操作成功', NULL, '2020-07-25 23:23:17', NULL);
INSERT INTO `admin_log` VALUES (603, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-25 23:25:45', NULL);
INSERT INTO `admin_log` VALUES (604, 'admin', '0:0:0:0:0:0:0:1', '', 1, '操作成功', NULL, '2020-07-25 23:26:04', NULL);
INSERT INTO `admin_log` VALUES (605, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-26 20:18:57', NULL);
INSERT INTO `admin_log` VALUES (606, 'admin', '0:0:0:0:0:0:0:1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-26 20:19:11', NULL);
INSERT INTO `admin_log` VALUES (607, 'admin', '0:0:0:0:0:0:0:1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-26 20:19:29', NULL);
INSERT INTO `admin_log` VALUES (608, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-26 20:55:10', NULL);
INSERT INTO `admin_log` VALUES (609, 'admin', '0:0:0:0:0:0:0:1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-26 20:55:21', NULL);
INSERT INTO `admin_log` VALUES (610, 'admin', '0:0:0:0:0:0:0:1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-26 20:56:29', NULL);
INSERT INTO `admin_log` VALUES (611, 'admin', '0:0:0:0:0:0:0:1', '后台用户登录', 1, '操作成功', NULL, '2020-07-26 22:18:53', NULL);
INSERT INTO `admin_log` VALUES (612, 'admin', '0:0:0:0:0:0:0:1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-26 22:19:15', NULL);
INSERT INTO `admin_log` VALUES (613, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-26 22:38:10', NULL);
INSERT INTO `admin_log` VALUES (614, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-26 22:38:11', NULL);
INSERT INTO `admin_log` VALUES (615, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-26 22:41:19', NULL);
INSERT INTO `admin_log` VALUES (616, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-26 22:44:36', NULL);
INSERT INTO `admin_log` VALUES (617, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-26 22:48:57', NULL);
INSERT INTO `admin_log` VALUES (618, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-26 22:57:27', NULL);
INSERT INTO `admin_log` VALUES (619, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-26 22:58:33', NULL);
INSERT INTO `admin_log` VALUES (620, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 09:15:25', NULL);
INSERT INTO `admin_log` VALUES (621, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 09:15:25', NULL);
INSERT INTO `admin_log` VALUES (622, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 09:26:06', NULL);
INSERT INTO `admin_log` VALUES (623, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 09:26:46', NULL);
INSERT INTO `admin_log` VALUES (624, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 09:31:20', NULL);
INSERT INTO `admin_log` VALUES (625, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 10:09:53', NULL);
INSERT INTO `admin_log` VALUES (626, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:09:53', NULL);
INSERT INTO `admin_log` VALUES (627, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:09:54', NULL);
INSERT INTO `admin_log` VALUES (628, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:10:57', NULL);
INSERT INTO `admin_log` VALUES (629, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:10:58', NULL);
INSERT INTO `admin_log` VALUES (630, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:12:16', NULL);
INSERT INTO `admin_log` VALUES (631, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:14:09', NULL);
INSERT INTO `admin_log` VALUES (632, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:14:10', NULL);
INSERT INTO `admin_log` VALUES (633, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:15:21', NULL);
INSERT INTO `admin_log` VALUES (634, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:15:39', NULL);
INSERT INTO `admin_log` VALUES (635, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:15:39', NULL);
INSERT INTO `admin_log` VALUES (636, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:16:01', NULL);
INSERT INTO `admin_log` VALUES (637, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:16:02', NULL);
INSERT INTO `admin_log` VALUES (638, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:16:16', NULL);
INSERT INTO `admin_log` VALUES (639, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:17:55', NULL);
INSERT INTO `admin_log` VALUES (640, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:17:56', NULL);
INSERT INTO `admin_log` VALUES (641, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:19:24', NULL);
INSERT INTO `admin_log` VALUES (642, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:19:25', NULL);
INSERT INTO `admin_log` VALUES (643, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:19:33', NULL);
INSERT INTO `admin_log` VALUES (644, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:19:38', NULL);
INSERT INTO `admin_log` VALUES (645, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:19:48', NULL);
INSERT INTO `admin_log` VALUES (646, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:19:58', NULL);
INSERT INTO `admin_log` VALUES (647, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:20:04', NULL);
INSERT INTO `admin_log` VALUES (648, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:21:37', NULL);
INSERT INTO `admin_log` VALUES (649, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:21:53', NULL);
INSERT INTO `admin_log` VALUES (650, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:23:29', NULL);
INSERT INTO `admin_log` VALUES (651, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:24:40', NULL);
INSERT INTO `admin_log` VALUES (652, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:25:04', NULL);
INSERT INTO `admin_log` VALUES (653, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:25:16', NULL);
INSERT INTO `admin_log` VALUES (654, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:25:34', NULL);
INSERT INTO `admin_log` VALUES (655, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:25:54', NULL);
INSERT INTO `admin_log` VALUES (656, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:26:27', NULL);
INSERT INTO `admin_log` VALUES (657, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:26:35', NULL);
INSERT INTO `admin_log` VALUES (658, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:26:36', NULL);
INSERT INTO `admin_log` VALUES (659, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:28:08', NULL);
INSERT INTO `admin_log` VALUES (660, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:28:09', NULL);
INSERT INTO `admin_log` VALUES (661, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:32:03', NULL);
INSERT INTO `admin_log` VALUES (662, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:32:26', NULL);
INSERT INTO `admin_log` VALUES (663, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:33:27', NULL);
INSERT INTO `admin_log` VALUES (664, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:33:28', NULL);
INSERT INTO `admin_log` VALUES (665, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:34:31', NULL);
INSERT INTO `admin_log` VALUES (666, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:40:47', NULL);
INSERT INTO `admin_log` VALUES (667, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:41:42', NULL);
INSERT INTO `admin_log` VALUES (668, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:41:44', NULL);
INSERT INTO `admin_log` VALUES (669, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:42:07', NULL);
INSERT INTO `admin_log` VALUES (670, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:43:10', NULL);
INSERT INTO `admin_log` VALUES (671, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:43:44', NULL);
INSERT INTO `admin_log` VALUES (672, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:49:31', NULL);
INSERT INTO `admin_log` VALUES (673, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:51:35', NULL);
INSERT INTO `admin_log` VALUES (674, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:52:52', NULL);
INSERT INTO `admin_log` VALUES (675, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:54:14', NULL);
INSERT INTO `admin_log` VALUES (676, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:54:56', NULL);
INSERT INTO `admin_log` VALUES (677, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 10:56:23', NULL);
INSERT INTO `admin_log` VALUES (678, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:56:24', NULL);
INSERT INTO `admin_log` VALUES (679, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:57:20', NULL);
INSERT INTO `admin_log` VALUES (680, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 10:57:38', NULL);
INSERT INTO `admin_log` VALUES (681, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 11:02:24', NULL);
INSERT INTO `admin_log` VALUES (682, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:02:25', NULL);
INSERT INTO `admin_log` VALUES (683, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:04:51', NULL);
INSERT INTO `admin_log` VALUES (684, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 11:06:10', NULL);
INSERT INTO `admin_log` VALUES (685, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:06:12', NULL);
INSERT INTO `admin_log` VALUES (686, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 11:10:07', NULL);
INSERT INTO `admin_log` VALUES (687, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:10:08', NULL);
INSERT INTO `admin_log` VALUES (688, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:11:00', NULL);
INSERT INTO `admin_log` VALUES (689, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:11:52', NULL);
INSERT INTO `admin_log` VALUES (690, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:13:09', NULL);
INSERT INTO `admin_log` VALUES (691, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:13:31', NULL);
INSERT INTO `admin_log` VALUES (692, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 11:15:57', NULL);
INSERT INTO `admin_log` VALUES (693, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:15:58', NULL);
INSERT INTO `admin_log` VALUES (694, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 11:16:06', NULL);
INSERT INTO `admin_log` VALUES (695, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:16:07', NULL);
INSERT INTO `admin_log` VALUES (696, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:16:12', NULL);
INSERT INTO `admin_log` VALUES (697, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:16:21', NULL);
INSERT INTO `admin_log` VALUES (698, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:18:22', NULL);
INSERT INTO `admin_log` VALUES (699, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 11:18:38', NULL);
INSERT INTO `admin_log` VALUES (700, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:18:39', NULL);
INSERT INTO `admin_log` VALUES (701, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 11:20:35', NULL);
INSERT INTO `admin_log` VALUES (702, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:20:36', NULL);
INSERT INTO `admin_log` VALUES (703, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:20:55', NULL);
INSERT INTO `admin_log` VALUES (704, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:21:16', NULL);
INSERT INTO `admin_log` VALUES (705, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:22:35', NULL);
INSERT INTO `admin_log` VALUES (706, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:22:57', NULL);
INSERT INTO `admin_log` VALUES (707, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:24:24', NULL);
INSERT INTO `admin_log` VALUES (708, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:24:34', NULL);
INSERT INTO `admin_log` VALUES (709, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:24:40', NULL);
INSERT INTO `admin_log` VALUES (710, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 11:30:05', NULL);
INSERT INTO `admin_log` VALUES (711, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:30:06', NULL);
INSERT INTO `admin_log` VALUES (712, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 11:32:17', NULL);
INSERT INTO `admin_log` VALUES (713, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:32:17', NULL);
INSERT INTO `admin_log` VALUES (714, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:33:01', NULL);
INSERT INTO `admin_log` VALUES (715, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:33:12', NULL);
INSERT INTO `admin_log` VALUES (716, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:33:15', NULL);
INSERT INTO `admin_log` VALUES (717, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:33:17', NULL);
INSERT INTO `admin_log` VALUES (718, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:35:12', NULL);
INSERT INTO `admin_log` VALUES (719, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:36:45', NULL);
INSERT INTO `admin_log` VALUES (720, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:38:59', NULL);
INSERT INTO `admin_log` VALUES (721, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:39:25', NULL);
INSERT INTO `admin_log` VALUES (722, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:39:36', NULL);
INSERT INTO `admin_log` VALUES (723, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:46:27', NULL);
INSERT INTO `admin_log` VALUES (724, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:48:43', NULL);
INSERT INTO `admin_log` VALUES (725, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:50:26', NULL);
INSERT INTO `admin_log` VALUES (726, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 11:50:52', NULL);
INSERT INTO `admin_log` VALUES (727, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:50:53', NULL);
INSERT INTO `admin_log` VALUES (728, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:51:23', NULL);
INSERT INTO `admin_log` VALUES (729, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 11:51:56', NULL);
INSERT INTO `admin_log` VALUES (730, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 12:53:17', NULL);
INSERT INTO `admin_log` VALUES (731, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 12:53:17', NULL);
INSERT INTO `admin_log` VALUES (732, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 12:53:17', NULL);
INSERT INTO `admin_log` VALUES (733, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 12:53:55', NULL);
INSERT INTO `admin_log` VALUES (734, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 12:54:43', NULL);
INSERT INTO `admin_log` VALUES (735, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 12:59:36', NULL);
INSERT INTO `admin_log` VALUES (736, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 12:59:59', NULL);
INSERT INTO `admin_log` VALUES (737, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:00:48', NULL);
INSERT INTO `admin_log` VALUES (738, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:01:12', NULL);
INSERT INTO `admin_log` VALUES (739, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:03:08', NULL);
INSERT INTO `admin_log` VALUES (740, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:05:54', NULL);
INSERT INTO `admin_log` VALUES (741, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:07:27', NULL);
INSERT INTO `admin_log` VALUES (742, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:07:28', NULL);
INSERT INTO `admin_log` VALUES (743, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:10:31', NULL);
INSERT INTO `admin_log` VALUES (744, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:14:22', NULL);
INSERT INTO `admin_log` VALUES (745, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:14:22', NULL);
INSERT INTO `admin_log` VALUES (746, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:15:27', NULL);
INSERT INTO `admin_log` VALUES (747, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:18:53', NULL);
INSERT INTO `admin_log` VALUES (748, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:19:55', NULL);
INSERT INTO `admin_log` VALUES (749, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:22:25', NULL);
INSERT INTO `admin_log` VALUES (750, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:22:26', NULL);
INSERT INTO `admin_log` VALUES (751, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:22:49', NULL);
INSERT INTO `admin_log` VALUES (752, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:22:58', NULL);
INSERT INTO `admin_log` VALUES (753, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:23:06', NULL);
INSERT INTO `admin_log` VALUES (754, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:23:36', NULL);
INSERT INTO `admin_log` VALUES (755, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:23:44', NULL);
INSERT INTO `admin_log` VALUES (756, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:24:21', NULL);
INSERT INTO `admin_log` VALUES (757, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:24:22', NULL);
INSERT INTO `admin_log` VALUES (758, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:24:31', NULL);
INSERT INTO `admin_log` VALUES (759, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:28:37', NULL);
INSERT INTO `admin_log` VALUES (760, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:29:46', NULL);
INSERT INTO `admin_log` VALUES (761, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:37:02', NULL);
INSERT INTO `admin_log` VALUES (762, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:38:05', NULL);
INSERT INTO `admin_log` VALUES (763, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:38:06', NULL);
INSERT INTO `admin_log` VALUES (764, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:39:54', NULL);
INSERT INTO `admin_log` VALUES (765, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:40:46', NULL);
INSERT INTO `admin_log` VALUES (766, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:41:14', NULL);
INSERT INTO `admin_log` VALUES (767, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:42:24', NULL);
INSERT INTO `admin_log` VALUES (768, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:42:52', NULL);
INSERT INTO `admin_log` VALUES (769, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:43:37', NULL);
INSERT INTO `admin_log` VALUES (770, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:44:20', NULL);
INSERT INTO `admin_log` VALUES (771, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:44:21', NULL);
INSERT INTO `admin_log` VALUES (772, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:46:40', NULL);
INSERT INTO `admin_log` VALUES (773, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:46:41', NULL);
INSERT INTO `admin_log` VALUES (774, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:47:03', NULL);
INSERT INTO `admin_log` VALUES (775, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:49:42', NULL);
INSERT INTO `admin_log` VALUES (776, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:49:43', NULL);
INSERT INTO `admin_log` VALUES (777, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:50:40', NULL);
INSERT INTO `admin_log` VALUES (778, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:52:28', NULL);
INSERT INTO `admin_log` VALUES (779, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:52:29', NULL);
INSERT INTO `admin_log` VALUES (780, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:52:31', NULL);
INSERT INTO `admin_log` VALUES (781, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:53:50', NULL);
INSERT INTO `admin_log` VALUES (782, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:53:51', NULL);
INSERT INTO `admin_log` VALUES (783, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:54:11', NULL);
INSERT INTO `admin_log` VALUES (784, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:54:45', NULL);
INSERT INTO `admin_log` VALUES (785, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:54:46', NULL);
INSERT INTO `admin_log` VALUES (786, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:55:17', NULL);
INSERT INTO `admin_log` VALUES (787, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:56:17', NULL);
INSERT INTO `admin_log` VALUES (788, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:56:18', NULL);
INSERT INTO `admin_log` VALUES (789, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:56:19', NULL);
INSERT INTO `admin_log` VALUES (790, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:56:43', NULL);
INSERT INTO `admin_log` VALUES (791, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:57:01', NULL);
INSERT INTO `admin_log` VALUES (792, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:57:34', NULL);
INSERT INTO `admin_log` VALUES (793, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:57:35', NULL);
INSERT INTO `admin_log` VALUES (794, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:58:37', NULL);
INSERT INTO `admin_log` VALUES (795, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 13:58:45', NULL);
INSERT INTO `admin_log` VALUES (796, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:58:46', NULL);
INSERT INTO `admin_log` VALUES (797, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 13:59:18', NULL);
INSERT INTO `admin_log` VALUES (798, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:01:46', NULL);
INSERT INTO `admin_log` VALUES (799, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:01:47', NULL);
INSERT INTO `admin_log` VALUES (800, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:02:33', NULL);
INSERT INTO `admin_log` VALUES (801, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:06:04', NULL);
INSERT INTO `admin_log` VALUES (802, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:06:06', NULL);
INSERT INTO `admin_log` VALUES (803, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:06:11', NULL);
INSERT INTO `admin_log` VALUES (804, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:06:32', NULL);
INSERT INTO `admin_log` VALUES (805, 'admin', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-27 14:10:02', NULL);
INSERT INTO `admin_log` VALUES (806, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 14:10:14', NULL);
INSERT INTO `admin_log` VALUES (807, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:10:14', NULL);
INSERT INTO `admin_log` VALUES (808, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:10:24', NULL);
INSERT INTO `admin_log` VALUES (809, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:12:58', NULL);
INSERT INTO `admin_log` VALUES (810, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:12:59', NULL);
INSERT INTO `admin_log` VALUES (811, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:13:33', NULL);
INSERT INTO `admin_log` VALUES (812, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:13:44', NULL);
INSERT INTO `admin_log` VALUES (813, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:13:51', NULL);
INSERT INTO `admin_log` VALUES (814, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:13:58', NULL);
INSERT INTO `admin_log` VALUES (815, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:14:03', NULL);
INSERT INTO `admin_log` VALUES (816, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:14:49', NULL);
INSERT INTO `admin_log` VALUES (817, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:17:28', NULL);
INSERT INTO `admin_log` VALUES (818, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:18:07', NULL);
INSERT INTO `admin_log` VALUES (819, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:18:53', NULL);
INSERT INTO `admin_log` VALUES (820, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:18:54', NULL);
INSERT INTO `admin_log` VALUES (821, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:20:19', NULL);
INSERT INTO `admin_log` VALUES (822, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:20:44', NULL);
INSERT INTO `admin_log` VALUES (823, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:20:45', NULL);
INSERT INTO `admin_log` VALUES (824, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:21:56', NULL);
INSERT INTO `admin_log` VALUES (825, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:32:26', NULL);
INSERT INTO `admin_log` VALUES (826, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:32:27', NULL);
INSERT INTO `admin_log` VALUES (827, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:32:48', NULL);
INSERT INTO `admin_log` VALUES (828, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:32:49', NULL);
INSERT INTO `admin_log` VALUES (829, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:33:27', NULL);
INSERT INTO `admin_log` VALUES (830, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:33:28', NULL);
INSERT INTO `admin_log` VALUES (831, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:39:59', NULL);
INSERT INTO `admin_log` VALUES (832, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:40:01', NULL);
INSERT INTO `admin_log` VALUES (833, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:43:51', NULL);
INSERT INTO `admin_log` VALUES (834, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:45:15', NULL);
INSERT INTO `admin_log` VALUES (835, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:45:49', NULL);
INSERT INTO `admin_log` VALUES (836, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:46:44', NULL);
INSERT INTO `admin_log` VALUES (837, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:46:46', NULL);
INSERT INTO `admin_log` VALUES (838, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:47:49', NULL);
INSERT INTO `admin_log` VALUES (839, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:47:50', NULL);
INSERT INTO `admin_log` VALUES (840, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:49:02', NULL);
INSERT INTO `admin_log` VALUES (841, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:49:03', NULL);
INSERT INTO `admin_log` VALUES (842, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:55:00', NULL);
INSERT INTO `admin_log` VALUES (843, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 14:55:40', NULL);
INSERT INTO `admin_log` VALUES (844, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:55:40', NULL);
INSERT INTO `admin_log` VALUES (845, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:57:23', NULL);
INSERT INTO `admin_log` VALUES (846, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:58:01', NULL);
INSERT INTO `admin_log` VALUES (847, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 14:58:59', NULL);
INSERT INTO `admin_log` VALUES (848, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:00:55', NULL);
INSERT INTO `admin_log` VALUES (849, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:01:07', NULL);
INSERT INTO `admin_log` VALUES (850, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:02:01', NULL);
INSERT INTO `admin_log` VALUES (851, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 15:02:43', NULL);
INSERT INTO `admin_log` VALUES (852, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 15:02:58', NULL);
INSERT INTO `admin_log` VALUES (853, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 15:03:29', NULL);
INSERT INTO `admin_log` VALUES (854, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 15:03:52', NULL);
INSERT INTO `admin_log` VALUES (855, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 15:04:40', NULL);
INSERT INTO `admin_log` VALUES (856, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 15:04:40', NULL);
INSERT INTO `admin_log` VALUES (857, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:04:58', NULL);
INSERT INTO `admin_log` VALUES (858, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 15:06:15', NULL);
INSERT INTO `admin_log` VALUES (859, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:06:16', NULL);
INSERT INTO `admin_log` VALUES (860, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:12:46', NULL);
INSERT INTO `admin_log` VALUES (861, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:12:47', NULL);
INSERT INTO `admin_log` VALUES (862, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 15:15:02', NULL);
INSERT INTO `admin_log` VALUES (863, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:16:56', NULL);
INSERT INTO `admin_log` VALUES (864, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:17:30', NULL);
INSERT INTO `admin_log` VALUES (865, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:18:31', NULL);
INSERT INTO `admin_log` VALUES (866, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:18:46', NULL);
INSERT INTO `admin_log` VALUES (867, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:22:58', NULL);
INSERT INTO `admin_log` VALUES (868, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:23:01', NULL);
INSERT INTO `admin_log` VALUES (869, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:23:06', NULL);
INSERT INTO `admin_log` VALUES (870, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:23:34', NULL);
INSERT INTO `admin_log` VALUES (871, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:24:00', NULL);
INSERT INTO `admin_log` VALUES (872, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:05', NULL);
INSERT INTO `admin_log` VALUES (873, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:07', NULL);
INSERT INTO `admin_log` VALUES (874, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:09', NULL);
INSERT INTO `admin_log` VALUES (875, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:11', NULL);
INSERT INTO `admin_log` VALUES (876, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:12', NULL);
INSERT INTO `admin_log` VALUES (877, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:13', NULL);
INSERT INTO `admin_log` VALUES (878, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:13', NULL);
INSERT INTO `admin_log` VALUES (879, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:16', NULL);
INSERT INTO `admin_log` VALUES (880, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:27', NULL);
INSERT INTO `admin_log` VALUES (881, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:35', NULL);
INSERT INTO `admin_log` VALUES (882, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:38', NULL);
INSERT INTO `admin_log` VALUES (883, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:40', NULL);
INSERT INTO `admin_log` VALUES (884, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:43', NULL);
INSERT INTO `admin_log` VALUES (885, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:25:56', NULL);
INSERT INTO `admin_log` VALUES (886, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:26:12', NULL);
INSERT INTO `admin_log` VALUES (887, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:26:52', NULL);
INSERT INTO `admin_log` VALUES (888, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:26:55', NULL);
INSERT INTO `admin_log` VALUES (889, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:26:56', NULL);
INSERT INTO `admin_log` VALUES (890, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:26:58', NULL);
INSERT INTO `admin_log` VALUES (891, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:00', NULL);
INSERT INTO `admin_log` VALUES (892, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:02', NULL);
INSERT INTO `admin_log` VALUES (893, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:03', NULL);
INSERT INTO `admin_log` VALUES (894, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:14', NULL);
INSERT INTO `admin_log` VALUES (895, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:23', NULL);
INSERT INTO `admin_log` VALUES (896, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 15:27:30', NULL);
INSERT INTO `admin_log` VALUES (897, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:31', NULL);
INSERT INTO `admin_log` VALUES (898, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:34', NULL);
INSERT INTO `admin_log` VALUES (899, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:37', NULL);
INSERT INTO `admin_log` VALUES (900, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:38', NULL);
INSERT INTO `admin_log` VALUES (901, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:39', NULL);
INSERT INTO `admin_log` VALUES (902, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:43', NULL);
INSERT INTO `admin_log` VALUES (903, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:27:47', NULL);
INSERT INTO `admin_log` VALUES (904, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:28:39', NULL);
INSERT INTO `admin_log` VALUES (905, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:28:42', NULL);
INSERT INTO `admin_log` VALUES (906, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:28:45', NULL);
INSERT INTO `admin_log` VALUES (907, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:28:46', NULL);
INSERT INTO `admin_log` VALUES (908, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:28:47', NULL);
INSERT INTO `admin_log` VALUES (909, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:28:48', NULL);
INSERT INTO `admin_log` VALUES (910, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:28:49', NULL);
INSERT INTO `admin_log` VALUES (911, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:28:50', NULL);
INSERT INTO `admin_log` VALUES (912, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:28:52', NULL);
INSERT INTO `admin_log` VALUES (913, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:28:55', NULL);
INSERT INTO `admin_log` VALUES (914, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:29:22', NULL);
INSERT INTO `admin_log` VALUES (915, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:29:51', NULL);
INSERT INTO `admin_log` VALUES (916, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:30:03', NULL);
INSERT INTO `admin_log` VALUES (917, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:30:18', NULL);
INSERT INTO `admin_log` VALUES (918, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:30:47', NULL);
INSERT INTO `admin_log` VALUES (919, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:30:52', NULL);
INSERT INTO `admin_log` VALUES (920, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:31:31', NULL);
INSERT INTO `admin_log` VALUES (921, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:31:35', NULL);
INSERT INTO `admin_log` VALUES (922, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:32:11', NULL);
INSERT INTO `admin_log` VALUES (923, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:32:39', NULL);
INSERT INTO `admin_log` VALUES (924, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:32:40', NULL);
INSERT INTO `admin_log` VALUES (925, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:32:42', NULL);
INSERT INTO `admin_log` VALUES (926, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:35:49', NULL);
INSERT INTO `admin_log` VALUES (927, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 15:38:07', NULL);
INSERT INTO `admin_log` VALUES (928, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:38:10', NULL);
INSERT INTO `admin_log` VALUES (929, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:39:13', NULL);
INSERT INTO `admin_log` VALUES (930, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:46:34', NULL);
INSERT INTO `admin_log` VALUES (931, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 15:58:23', NULL);
INSERT INTO `admin_log` VALUES (932, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:00:20', NULL);
INSERT INTO `admin_log` VALUES (933, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:03:06', NULL);
INSERT INTO `admin_log` VALUES (934, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:04:07', NULL);
INSERT INTO `admin_log` VALUES (935, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:04:08', NULL);
INSERT INTO `admin_log` VALUES (936, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:04:12', NULL);
INSERT INTO `admin_log` VALUES (937, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:04:13', NULL);
INSERT INTO `admin_log` VALUES (938, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:13:45', NULL);
INSERT INTO `admin_log` VALUES (939, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:14:58', NULL);
INSERT INTO `admin_log` VALUES (940, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:14:59', NULL);
INSERT INTO `admin_log` VALUES (941, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:17:42', NULL);
INSERT INTO `admin_log` VALUES (942, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:17:42', NULL);
INSERT INTO `admin_log` VALUES (943, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:18:42', NULL);
INSERT INTO `admin_log` VALUES (944, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:19:10', NULL);
INSERT INTO `admin_log` VALUES (945, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:20:20', NULL);
INSERT INTO `admin_log` VALUES (946, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:20:21', NULL);
INSERT INTO `admin_log` VALUES (947, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:22:17', NULL);
INSERT INTO `admin_log` VALUES (948, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:22:19', NULL);
INSERT INTO `admin_log` VALUES (949, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:23:49', NULL);
INSERT INTO `admin_log` VALUES (950, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:23:49', NULL);
INSERT INTO `admin_log` VALUES (951, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:26:54', NULL);
INSERT INTO `admin_log` VALUES (952, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:26:55', NULL);
INSERT INTO `admin_log` VALUES (953, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:31:29', NULL);
INSERT INTO `admin_log` VALUES (954, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:31:31', NULL);
INSERT INTO `admin_log` VALUES (955, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:32:55', NULL);
INSERT INTO `admin_log` VALUES (956, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:33:05', NULL);
INSERT INTO `admin_log` VALUES (957, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:33:10', NULL);
INSERT INTO `admin_log` VALUES (958, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:33:33', NULL);
INSERT INTO `admin_log` VALUES (959, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:33:35', NULL);
INSERT INTO `admin_log` VALUES (960, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:33:45', NULL);
INSERT INTO `admin_log` VALUES (961, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:33:49', NULL);
INSERT INTO `admin_log` VALUES (962, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:33:51', NULL);
INSERT INTO `admin_log` VALUES (963, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:34:14', NULL);
INSERT INTO `admin_log` VALUES (964, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:34:17', NULL);
INSERT INTO `admin_log` VALUES (965, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:34:26', NULL);
INSERT INTO `admin_log` VALUES (966, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:34:27', NULL);
INSERT INTO `admin_log` VALUES (967, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:34:39', NULL);
INSERT INTO `admin_log` VALUES (968, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:34:49', NULL);
INSERT INTO `admin_log` VALUES (969, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:35:12', NULL);
INSERT INTO `admin_log` VALUES (970, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:35:15', NULL);
INSERT INTO `admin_log` VALUES (971, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:35:43', NULL);
INSERT INTO `admin_log` VALUES (972, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:35:44', NULL);
INSERT INTO `admin_log` VALUES (973, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:37:33', NULL);
INSERT INTO `admin_log` VALUES (974, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:38:01', NULL);
INSERT INTO `admin_log` VALUES (975, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:39:54', NULL);
INSERT INTO `admin_log` VALUES (976, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:48:12', NULL);
INSERT INTO `admin_log` VALUES (977, 'admin', '127.0.0.1', '后台用户注销', 1, '操作成功', NULL, '2020-07-27 16:48:20', NULL);
INSERT INTO `admin_log` VALUES (978, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 16:48:36', NULL);
INSERT INTO `admin_log` VALUES (979, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:48:36', NULL);
INSERT INTO `admin_log` VALUES (980, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:48:41', NULL);
INSERT INTO `admin_log` VALUES (981, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:49:51', NULL);
INSERT INTO `admin_log` VALUES (982, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:49:52', NULL);
INSERT INTO `admin_log` VALUES (983, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:53:09', NULL);
INSERT INTO `admin_log` VALUES (984, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:53:15', NULL);
INSERT INTO `admin_log` VALUES (985, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:56:55', NULL);
INSERT INTO `admin_log` VALUES (986, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:56:56', NULL);
INSERT INTO `admin_log` VALUES (987, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:57:50', NULL);
INSERT INTO `admin_log` VALUES (988, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:57:55', NULL);
INSERT INTO `admin_log` VALUES (989, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:57:56', NULL);
INSERT INTO `admin_log` VALUES (990, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:59:23', NULL);
INSERT INTO `admin_log` VALUES (991, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 16:59:47', NULL);
INSERT INTO `admin_log` VALUES (992, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 16:59:48', NULL);
INSERT INTO `admin_log` VALUES (993, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:02:37', NULL);
INSERT INTO `admin_log` VALUES (994, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:02:38', NULL);
INSERT INTO `admin_log` VALUES (995, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:04:17', NULL);
INSERT INTO `admin_log` VALUES (996, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:04:18', NULL);
INSERT INTO `admin_log` VALUES (997, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:05:17', NULL);
INSERT INTO `admin_log` VALUES (998, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:09:21', NULL);
INSERT INTO `admin_log` VALUES (999, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:09:33', NULL);
INSERT INTO `admin_log` VALUES (1000, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:09:34', NULL);
INSERT INTO `admin_log` VALUES (1001, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:10:05', NULL);
INSERT INTO `admin_log` VALUES (1002, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:10:16', NULL);
INSERT INTO `admin_log` VALUES (1003, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:10:28', NULL);
INSERT INTO `admin_log` VALUES (1004, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:10:49', NULL);
INSERT INTO `admin_log` VALUES (1005, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:10:50', NULL);
INSERT INTO `admin_log` VALUES (1006, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:12:43', NULL);
INSERT INTO `admin_log` VALUES (1007, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:12:44', NULL);
INSERT INTO `admin_log` VALUES (1008, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:14:09', NULL);
INSERT INTO `admin_log` VALUES (1009, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 17:15:27', NULL);
INSERT INTO `admin_log` VALUES (1010, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:15:27', NULL);
INSERT INTO `admin_log` VALUES (1011, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:15:33', NULL);
INSERT INTO `admin_log` VALUES (1012, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:19:51', NULL);
INSERT INTO `admin_log` VALUES (1013, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:19:58', NULL);
INSERT INTO `admin_log` VALUES (1014, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:20:25', NULL);
INSERT INTO `admin_log` VALUES (1015, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:22:59', NULL);
INSERT INTO `admin_log` VALUES (1016, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:23:00', NULL);
INSERT INTO `admin_log` VALUES (1017, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:24:26', NULL);
INSERT INTO `admin_log` VALUES (1018, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:24:27', NULL);
INSERT INTO `admin_log` VALUES (1019, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:24:44', NULL);
INSERT INTO `admin_log` VALUES (1020, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:24:55', NULL);
INSERT INTO `admin_log` VALUES (1021, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:24:56', NULL);
INSERT INTO `admin_log` VALUES (1022, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:25:46', NULL);
INSERT INTO `admin_log` VALUES (1023, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:28:32', NULL);
INSERT INTO `admin_log` VALUES (1024, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 17:28:51', NULL);
INSERT INTO `admin_log` VALUES (1025, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 17:28:51', NULL);
INSERT INTO `admin_log` VALUES (1026, 'admin', '127.0.0.1', '后台用户登录', 1, '操作成功', NULL, '2020-07-27 21:05:14', NULL);
INSERT INTO `admin_log` VALUES (1027, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 21:05:14', NULL);
INSERT INTO `admin_log` VALUES (1028, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:05:14', NULL);
INSERT INTO `admin_log` VALUES (1029, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:11:37', NULL);
INSERT INTO `admin_log` VALUES (1030, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:13:24', NULL);
INSERT INTO `admin_log` VALUES (1031, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 21:13:36', NULL);
INSERT INTO `admin_log` VALUES (1032, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:13:37', NULL);
INSERT INTO `admin_log` VALUES (1033, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:14:08', NULL);
INSERT INTO `admin_log` VALUES (1034, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 21:15:21', NULL);
INSERT INTO `admin_log` VALUES (1035, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:15:22', NULL);
INSERT INTO `admin_log` VALUES (1036, 'admin', '127.0.0.1', '获取后台用户信息', 1, '操作成功', NULL, '2020-07-27 21:16:14', NULL);
INSERT INTO `admin_log` VALUES (1037, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:16:16', NULL);
INSERT INTO `admin_log` VALUES (1038, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:18:20', NULL);
INSERT INTO `admin_log` VALUES (1039, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:18:24', NULL);
INSERT INTO `admin_log` VALUES (1040, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:18:26', NULL);
INSERT INTO `admin_log` VALUES (1041, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:18:28', NULL);
INSERT INTO `admin_log` VALUES (1042, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:18:32', NULL);
INSERT INTO `admin_log` VALUES (1043, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:18:33', NULL);
INSERT INTO `admin_log` VALUES (1044, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:18:35', NULL);
INSERT INTO `admin_log` VALUES (1045, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:19:03', NULL);
INSERT INTO `admin_log` VALUES (1046, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:19:23', NULL);
INSERT INTO `admin_log` VALUES (1047, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:20:20', NULL);
INSERT INTO `admin_log` VALUES (1048, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:20:22', NULL);
INSERT INTO `admin_log` VALUES (1049, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:20:33', NULL);
INSERT INTO `admin_log` VALUES (1050, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:20:34', NULL);
INSERT INTO `admin_log` VALUES (1051, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:23:06', NULL);
INSERT INTO `admin_log` VALUES (1052, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:23:19', NULL);
INSERT INTO `admin_log` VALUES (1053, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:23:39', NULL);
INSERT INTO `admin_log` VALUES (1054, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:23:41', NULL);
INSERT INTO `admin_log` VALUES (1055, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:23:48', NULL);
INSERT INTO `admin_log` VALUES (1056, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:23:50', NULL);
INSERT INTO `admin_log` VALUES (1057, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:23:55', NULL);
INSERT INTO `admin_log` VALUES (1058, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:23:57', NULL);
INSERT INTO `admin_log` VALUES (1059, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:26:11', NULL);
INSERT INTO `admin_log` VALUES (1060, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:26:16', NULL);
INSERT INTO `admin_log` VALUES (1061, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:26:18', NULL);
INSERT INTO `admin_log` VALUES (1062, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:26:19', NULL);
INSERT INTO `admin_log` VALUES (1063, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:26:22', NULL);
INSERT INTO `admin_log` VALUES (1064, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:26:24', NULL);
INSERT INTO `admin_log` VALUES (1065, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:27:01', NULL);
INSERT INTO `admin_log` VALUES (1066, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:27:05', NULL);
INSERT INTO `admin_log` VALUES (1067, 'admin', '127.0.0.1', '查询用户操作日志', 1, '操作成功', NULL, '2020-07-27 21:27:27', NULL);
COMMIT;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父级id',
  `title` varchar(64) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `level` int(1) NOT NULL DEFAULT '0' COMMENT '菜单级数',
  `sort` int(4) NOT NULL DEFAULT '0' COMMENT '排序',
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '前端名称',
  `icon` varchar(128) NOT NULL DEFAULT '' COMMENT '前端图标',
  `hidden` int(1) NOT NULL DEFAULT '0' COMMENT '前端隐藏',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='后台菜单表';

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
BEGIN;
INSERT INTO `admin_menu` VALUES (1, 0, '会员管理', 0, 1, 'member', 'huiyuan', 0, '2020-07-18 10:06:05', '2020-07-18 10:06:08', 0);
INSERT INTO `admin_menu` VALUES (2, 1, '会员列表', 1, 0, 'memberList', 'member', 0, '2020-07-18 10:08:46', '2020-07-18 10:08:50', 0);
INSERT INTO `admin_menu` VALUES (3, 1, '收货地址', 1, 0, 'address', 'address', 0, '2020-07-18 10:09:36', '2020-07-18 10:09:39', 0);
INSERT INTO `admin_menu` VALUES (4, 1, '会员收藏', 1, 0, 'collect', 'collect', 0, '2020-07-18 10:10:29', '2020-07-18 10:10:31', 0);
INSERT INTO `admin_menu` VALUES (5, 1, '会员足迹', 1, 0, 'history', 'history', 0, '2020-07-18 10:11:20', '2020-07-18 10:11:23', 0);
INSERT INTO `admin_menu` VALUES (6, 1, '意见反馈', 1, 0, 'opinion', 'opinion', 0, '2020-07-18 10:12:01', '2020-07-18 10:12:04', 0);
INSERT INTO `admin_menu` VALUES (7, 0, '商品管理', 0, 2, 'product', 'shangpin', 0, '2020-07-18 10:14:43', '2020-07-18 10:14:46', 0);
INSERT INTO `admin_menu` VALUES (8, 7, '品牌制造商', 1, 0, 'brand', 'brand', 0, '2020-07-18 10:15:54', '2020-07-18 10:15:56', 0);
INSERT INTO `admin_menu` VALUES (9, 7, '商品类目', 1, 0, 'category', 'category', 0, '2020-07-18 10:16:20', '2020-07-18 10:16:23', 0);
INSERT INTO `admin_menu` VALUES (10, 7, '商品维护', 1, 0, 'productList', 'product-list', 0, '2020-07-18 10:17:12', '2020-07-18 10:17:14', 0);
INSERT INTO `admin_menu` VALUES (11, 7, '商品上架', 1, 0, 'addProduct', 'product-add', 0, '2020-07-18 10:21:44', '2020-07-18 10:21:47', 0);
INSERT INTO `admin_menu` VALUES (12, 0, '订单管理', 0, 3, 'order', 'dingdan', 0, '2020-07-18 10:21:51', '2020-07-18 10:21:53', 0);
INSERT INTO `admin_menu` VALUES (13, 12, '订单列表', 1, 0, 'orderList', 'order-list', 0, '2020-07-18 10:23:05', '2020-07-18 10:23:08', 0);
INSERT INTO `admin_menu` VALUES (14, 12, '售后管理', 1, 0, 'aftersale', 'aftersale', 0, '2020-07-18 10:25:17', '2020-07-18 10:25:20', 0);
INSERT INTO `admin_menu` VALUES (15, 7, '商品评论', 1, 0, 'comment', 'comment', 0, '2020-07-18 10:27:35', '2020-07-18 10:27:38', 0);
INSERT INTO `admin_menu` VALUES (16, 0, '运营管理', 0, 4, 'operation', 'yunyingernyuan', 0, '2020-07-18 10:30:39', '2020-07-18 10:30:42', 0);
INSERT INTO `admin_menu` VALUES (17, 16, '专题管理', 1, 0, 'topic', 'topic', 0, '2020-07-18 10:31:35', '2020-07-18 10:31:41', 0);
INSERT INTO `admin_menu` VALUES (18, 16, '优惠券管理', 1, 0, 'coupon', 'coupon', 0, '2020-07-18 10:35:38', '2020-07-18 10:35:46', 0);
INSERT INTO `admin_menu` VALUES (19, 0, '系统管理', 0, 5, 'system', 'xitong', 0, '2020-07-18 10:37:46', '2020-07-18 10:37:49', 0);
INSERT INTO `admin_menu` VALUES (20, 19, '后台用户管理', 1, 0, 'admin', 'admin', 0, '2020-07-18 10:38:32', '2020-07-18 10:38:34', 0);
INSERT INTO `admin_menu` VALUES (21, 19, '角色管理', 1, 0, 'role', 'role', 0, '2020-07-18 10:39:42', '2020-07-18 10:39:45', 0);
INSERT INTO `admin_menu` VALUES (22, 19, '操作日志', 1, 0, 'log', 'log', 0, '2020-07-18 10:40:17', '2020-07-18 10:40:20', 0);
INSERT INTO `admin_menu` VALUES (23, 0, '配置管理', 0, 6, 'setting', 'shezhi', 0, '2020-07-18 10:43:09', '2020-07-18 10:43:11', 0);
INSERT INTO `admin_menu` VALUES (24, 23, '订单配置', 1, 0, 'orderConfig', 'order-config', 0, '2020-07-18 10:44:21', '2020-07-18 10:44:24', 0);
INSERT INTO `admin_menu` VALUES (25, 23, '运费配置', 1, 0, 'freight', 'freight', 0, '2020-07-18 10:45:19', '2020-07-18 10:45:22', 0);
INSERT INTO `admin_menu` VALUES (26, 0, '统计报表', 0, 7, 'statistics', 'tongji', 0, '2020-07-18 10:47:11', '2020-07-18 10:47:13', 0);
INSERT INTO `admin_menu` VALUES (27, 26, '用户统计', 1, 0, 'memberStatistics', 'member-statistics', 0, '2020-07-18 10:47:58', '2020-07-18 10:48:00', 0);
INSERT INTO `admin_menu` VALUES (28, 26, '商品统计', 1, 0, 'productStatistics', 'order-statistics', 0, '2020-07-18 10:48:46', '2020-07-18 10:48:48', 0);
INSERT INTO `admin_menu` VALUES (29, 26, '订单统计', 1, 0, 'orderStatistics', 'product-tatistics', 0, '2020-07-18 10:49:36', '2020-07-18 10:49:38', 0);
COMMIT;

-- ----------------------------
-- Table structure for admin_resource
-- ----------------------------
DROP TABLE IF EXISTS `admin_resource`;
CREATE TABLE `admin_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源id',
  `category_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源分类id',
  `name` varchar(128) NOT NULL DEFAULT '' COMMENT '资源名称',
  `url` varchar(128) NOT NULL DEFAULT '' COMMENT '资源url',
  `detail` varchar(255) NOT NULL DEFAULT '' COMMENT '资源描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COMMENT='后台资源表';

-- ----------------------------
-- Records of admin_resource
-- ----------------------------
BEGIN;
INSERT INTO `admin_resource` VALUES (1, 1, '会员管理', '/member/**', '操作会员模块', '2020-07-18 14:35:56', NULL, 0);
INSERT INTO `admin_resource` VALUES (2, 1, '浏览历史管理', '/member/history/**', '操作会员浏览记录', '2020-07-18 14:43:08', NULL, 0);
INSERT INTO `admin_resource` VALUES (3, 1, '收货地址管理', '/member/address/**', '操作会员收货地址', '2020-07-18 14:44:12', NULL, 0);
INSERT INTO `admin_resource` VALUES (4, 1, '意见反馈管理', '/member/opinion/**', '操作意见反馈', '2020-07-18 14:45:04', NULL, 0);
INSERT INTO `admin_resource` VALUES (5, 1, '会员收藏管理', '/member/collect/**', '操作会员收藏管理', '2020-07-18 14:47:10', NULL, 0);
INSERT INTO `admin_resource` VALUES (6, 2, '品牌管理', '/product_brand/**', '操作商品品牌', '2020-07-18 14:49:45', NULL, 0);
INSERT INTO `admin_resource` VALUES (7, 2, '商品维护', '/product/**', '操作商品', '2020-07-18 14:50:12', NULL, 0);
INSERT INTO `admin_resource` VALUES (8, 2, '商品评论', '/product/comment/**', '操作商品评论', '2020-07-18 14:50:49', NULL, 0);
INSERT INTO `admin_resource` VALUES (9, 2, '商品类目', '/product/category/**', '操作商品类目', '2020-07-18 14:52:06', NULL, 0);
INSERT INTO `admin_resource` VALUES (10, 3, '订单管理', '/order/**', '操作订单', '2020-07-18 14:53:21', NULL, 0);
INSERT INTO `admin_resource` VALUES (11, 3, '售后管理', '/order_aftersale/**', '操作售后', '2020-07-18 14:54:26', NULL, 0);
INSERT INTO `admin_resource` VALUES (12, 4, '运营管理', '/operation/**', '操作运营管理', '2020-07-18 14:55:16', NULL, 0);
INSERT INTO `admin_resource` VALUES (13, 4, '优惠券管理', '/operation/coupon/**', '操作优惠券', '2020-07-18 14:55:51', NULL, 0);
INSERT INTO `admin_resource` VALUES (14, 4, '专题管理', '/operation/topic/**', '操作专题', '2020-07-18 14:56:18', NULL, 0);
INSERT INTO `admin_resource` VALUES (16, 5, '管理用户', '/system/user/**', '管理用户', '2020-07-18 14:57:48', NULL, 0);
INSERT INTO `admin_resource` VALUES (17, 5, '角色管理', '/system/user_role/**', '管理角色', '2020-07-18 14:58:24', NULL, 0);
INSERT INTO `admin_resource` VALUES (18, 5, '操作日志', '/system/log/**', '查看日志', '2020-07-18 14:59:51', NULL, 0);
INSERT INTO `admin_resource` VALUES (20, 6, '订单配置', '/setting/order/**', '配置订单', '2020-07-18 15:01:17', NULL, 0);
INSERT INTO `admin_resource` VALUES (21, 6, '运费配置', '/setting/freight/**', '配置运费', '2020-07-18 15:02:05', NULL, 0);
INSERT INTO `admin_resource` VALUES (22, 7, '用户统计', '/statistics/member/**', '查看用户报表', '2020-07-18 15:03:02', NULL, 0);
INSERT INTO `admin_resource` VALUES (23, 7, '商品统计', '/statistics/product/**', '查看商品统计', '2020-07-18 15:05:07', NULL, 0);
INSERT INTO `admin_resource` VALUES (24, 7, '订单统计', '/statistics/order/**', '查看订单统计', '2020-07-18 15:05:39', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for admin_resource_category
-- ----------------------------
DROP TABLE IF EXISTS `admin_resource_category`;
CREATE TABLE `admin_resource_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源分类id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '分类名称',
  `sort` int(4) NOT NULL DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='资源分类表';

-- ----------------------------
-- Records of admin_resource_category
-- ----------------------------
BEGIN;
INSERT INTO `admin_resource_category` VALUES (1, '会员管理', 0, '2020-07-18 15:07:11', NULL, 0);
INSERT INTO `admin_resource_category` VALUES (2, '商品管理', 0, '2020-07-18 15:07:26', NULL, 0);
INSERT INTO `admin_resource_category` VALUES (3, '订单管理', 0, '2020-07-18 15:07:48', NULL, 0);
INSERT INTO `admin_resource_category` VALUES (4, '运营管理', 0, '2020-07-18 15:08:10', NULL, 0);
INSERT INTO `admin_resource_category` VALUES (5, '系统管理', 0, '2020-07-18 15:08:55', NULL, 0);
INSERT INTO `admin_resource_category` VALUES (6, '配置管理', 0, '2020-07-18 15:09:14', NULL, 0);
INSERT INTO `admin_resource_category` VALUES (7, '统计管理', 0, '2020-07-18 15:09:25', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名',
  `desc` varchar(64) DEFAULT NULL COMMENT '角色描述',
  `enabled` int(1) DEFAULT '1' COMMENT '角色状态 0-禁用 1-启用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表\n';

-- ----------------------------
-- Records of admin_role
-- ----------------------------
BEGIN;
INSERT INTO `admin_role` VALUES (1, '超级管理员', '拥有所有查看和操作功能', 1, '2020-07-17 22:56:44', '2020-07-17 22:56:48', 0);
INSERT INTO `admin_role` VALUES (2, '商品管理员', '只能查看及操作商品', 1, '2020-07-17 22:57:15', '2020-07-17 22:57:17', 0);
INSERT INTO `admin_role` VALUES (3, '订单管理员', '只能查看及操作订单', 1, '2020-07-17 22:57:35', '2020-07-17 22:57:38', 0);
INSERT INTO `admin_role` VALUES (4, '运营管理员', '只能进行运营查看和操作', 1, '2020-07-17 22:59:04', '2020-07-17 22:59:08', 0);
COMMIT;

-- ----------------------------
-- Table structure for admin_role_menu_relatioin
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu_relatioin`;
CREATE TABLE `admin_role_menu_relatioin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色菜单关联id',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '菜单id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单关系表';

-- ----------------------------
-- Records of admin_role_menu_relatioin
-- ----------------------------
BEGIN;
INSERT INTO `admin_role_menu_relatioin` VALUES (1, 1, 1, '2020-07-18 10:51:01', '2020-07-18 10:51:05', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (2, 1, 2, '2020-07-18 10:51:16', '2020-07-18 10:51:20', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (3, 1, 3, '2020-07-18 10:51:59', '2020-07-18 10:52:38', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (4, 1, 4, '2020-07-18 10:52:40', '2020-07-18 10:52:46', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (5, 1, 5, '2020-07-18 10:52:47', '2020-07-18 10:52:49', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (6, 1, 6, '2020-07-18 10:52:49', '2020-07-18 10:52:50', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (7, 1, 7, '2020-07-18 10:52:51', '2020-07-18 10:52:53', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (8, 1, 8, '2020-07-18 10:53:23', '2020-07-18 10:53:26', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (9, 1, 9, '2020-07-18 10:53:26', '2020-07-18 10:53:28', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (10, 1, 10, '2020-07-18 10:53:20', '2020-07-18 10:53:20', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (11, 1, 11, '2020-07-18 10:53:39', '2020-07-18 10:53:39', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (12, 1, 12, '2020-07-18 10:53:44', '2020-07-18 10:53:44', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (13, 1, 13, '2020-07-18 10:54:14', '2020-07-18 10:54:16', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (14, 1, 14, '2020-07-18 10:54:19', '2020-07-18 10:54:22', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (15, 1, 15, '2020-07-18 10:54:22', '2020-07-18 10:54:25', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (16, 1, 16, '2020-07-18 10:54:26', '2020-07-18 10:54:29', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (17, 1, 17, '2020-07-18 10:55:00', '2020-07-18 10:54:57', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (18, 1, 18, '2020-07-18 10:55:36', '2020-07-18 10:55:36', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (19, 1, 19, '2020-07-18 10:55:57', '2020-07-18 10:55:57', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (20, 1, 20, '2020-07-18 10:56:20', '2020-07-18 10:56:18', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (21, 1, 21, '2020-07-18 10:56:14', '2020-07-18 10:56:17', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (22, 1, 22, '2020-07-18 10:56:39', '2020-07-18 10:56:35', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (23, 1, 23, '2020-07-18 10:56:49', '2020-07-18 10:56:51', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (24, 1, 24, '2020-07-18 10:57:00', '2020-07-18 10:57:02', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (25, 1, 25, '2020-07-18 10:57:11', '2020-07-18 10:57:13', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (26, 1, 26, '2020-07-18 10:57:29', '2020-07-18 10:57:26', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (27, 1, 27, '2020-07-18 10:57:34', '2020-07-18 10:57:36', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (28, 1, 28, '2020-07-18 10:57:43', '2020-07-18 10:57:45', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (29, 1, 29, '2020-07-18 10:57:57', '2020-07-18 10:57:59', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (30, 2, 7, '2020-07-18 10:58:32', '2020-07-18 10:58:36', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (31, 2, 8, '2020-07-18 10:58:53', '2020-07-18 10:58:54', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (32, 2, 9, '2020-07-18 10:59:02', '2020-07-18 10:59:04', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (33, 2, 10, '2020-07-18 10:59:17', '2020-07-18 10:59:19', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (34, 2, 11, '2020-07-18 10:59:28', '2020-07-18 10:59:30', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (35, 2, 26, '2020-07-18 11:00:51', '2020-07-18 11:00:53', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (36, 2, 28, '2020-07-18 11:01:15', '2020-07-18 11:01:19', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (37, 3, 12, '2020-07-18 11:02:26', '2020-07-18 11:02:28', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (38, 3, 13, '2020-07-18 11:02:44', '2020-07-18 11:02:46', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (39, 3, 14, '2020-07-18 11:02:52', '2020-07-18 11:02:54', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (40, 3, 15, '2020-07-18 11:03:14', '2020-07-18 11:03:16', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (41, 3, 23, '2020-07-18 11:04:46', '2020-07-18 11:04:46', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (42, 3, 24, '2020-07-18 11:04:49', '2020-07-18 11:04:49', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (43, 3, 26, '2020-07-18 11:05:14', '2020-07-18 11:05:16', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (44, 3, 29, '2020-07-18 11:05:55', '2020-07-18 11:05:57', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (45, 4, 16, '2020-07-18 11:07:07', '2020-07-18 11:07:08', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (46, 4, 17, '2020-07-18 11:07:12', '2020-07-18 11:07:15', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (47, 4, 18, '2020-07-18 11:07:23', '2020-07-18 11:07:25', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (48, 4, 23, '2020-07-18 11:07:49', '2020-07-18 11:07:51', 0);
INSERT INTO `admin_role_menu_relatioin` VALUES (49, 4, 25, '2020-07-18 11:08:00', '2020-07-18 11:08:02', 0);
COMMIT;

-- ----------------------------
-- Table structure for admin_role_resource_relation
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_resource_relation`;
CREATE TABLE `admin_role_resource_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色权限id',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
  `resource_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '资源id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COMMENT='角色资源关系表';

-- ----------------------------
-- Records of admin_role_resource_relation
-- ----------------------------
BEGIN;
INSERT INTO `admin_role_resource_relation` VALUES (1, 1, 1, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (2, 1, 2, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (3, 1, 3, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (4, 1, 4, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (5, 1, 5, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (6, 1, 6, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (7, 1, 7, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (8, 1, 8, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (9, 1, 9, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (10, 1, 10, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (11, 1, 11, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (12, 1, 12, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (13, 1, 13, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (14, 1, 14, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (15, 1, 16, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (16, 1, 17, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (18, 1, 18, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (19, 1, 20, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (20, 1, 21, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (21, 1, 22, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (22, 1, 23, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (23, 1, 24, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (24, 2, 6, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (25, 2, 7, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (26, 2, 8, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (27, 2, 9, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (28, 2, 23, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (29, 3, 10, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (30, 3, 11, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (31, 3, 24, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (32, 4, 12, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (33, 4, 13, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (34, 4, 14, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (35, 3, 20, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (36, 4, 21, '2020-07-18 15:25:52', NULL, 0);
INSERT INTO `admin_role_resource_relation` VALUES (37, 1, 24, NULL, NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for admin_user
-- ----------------------------
DROP TABLE IF EXISTS `admin_user`;
CREATE TABLE `admin_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '后台管理员id',
  `username` varchar(64) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `last_login_ip` varchar(32) NOT NULL DEFAULT '' COMMENT '最近登录ip',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近登录时间',
  `status` int(1) DEFAULT '0' COMMENT '状态 0-可用 1-禁用',
  `avatar` varchar(127) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='管理员用户表';

-- ----------------------------
-- Records of admin_user
-- ----------------------------
BEGIN;
INSERT INTO `admin_user` VALUES (1, 'admin', '$2a$10$oblA1i/2BoD7O/BWz4vrzuhE4582lb3GkfcEG0hUBR.NcDgpAwCqO', '127.0.0.1', '2020-09-20 14:48:24', 0, 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2037620867,87253245&fm=15&gp=0.jpg', '2020-07-15 11:41:07', '2020-09-20 14:48:24', 0);
INSERT INTO `admin_user` VALUES (3, '商品管理测试', '$2a$10$Ukh8vo3hCc6MIuuypU/IleB4zCvvb0vxrilAmufoM6MCvSpeE0DAa', '127.0.0.1', '2020-09-09 21:37:14', 0, NULL, '2020-07-18 09:56:52', '2020-09-09 21:37:14', 0);
INSERT INTO `admin_user` VALUES (4, '订单管理测试', '$2a$10$Ukh8vo3hCc6MIuuypU/IleB4zCvvb0vxrilAmufoM6MCvSpeE0DAa', '0:0:0:0:0:0:0:1', '2020-07-18 14:08:57', 0, NULL, '2020-07-18 09:56:57', '2020-07-18 14:08:57', 0);
INSERT INTO `admin_user` VALUES (5, '运营管理测试', '$2a$10$Ukh8vo3hCc6MIuuypU/IleB4zCvvb0vxrilAmufoM6MCvSpeE0DAa', '127.0.0.1', '2020-08-15 20:56:44', 0, NULL, '2020-07-18 09:57:00', '2020-08-15 20:56:44', 0);
COMMIT;

-- ----------------------------
-- Table structure for admin_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role_relation`;
CREATE TABLE `admin_user_role_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户角色关系表',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `role_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '角色id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of admin_user_role_relation
-- ----------------------------
BEGIN;
INSERT INTO `admin_user_role_relation` VALUES (1, 1, 1, '2020-07-17 23:13:59', '2020-07-17 23:14:02', 0);
INSERT INTO `admin_user_role_relation` VALUES (2, 3, 2, '2020-07-18 10:03:10', '2020-07-18 10:03:21', 0);
INSERT INTO `admin_user_role_relation` VALUES (3, 4, 3, '2020-07-18 10:03:14', '2020-07-18 10:03:24', 0);
INSERT INTO `admin_user_role_relation` VALUES (4, 5, 4, '2020-07-18 10:03:18', '2020-07-18 10:03:27', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_aftersale
-- ----------------------------
DROP TABLE IF EXISTS `mall_aftersale`;
CREATE TABLE `mall_aftersale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '售后id',
  `aftersale_sn` varchar(64) NOT NULL DEFAULT '' COMMENT '售后编号',
  `order_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '订单id',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `type` int(4) DEFAULT NULL COMMENT '售后类型，0是未收货退款，1是已收货（无需退货）退款，2用户退货退款',
  `reason` varchar(64) NOT NULL DEFAULT '' COMMENT '退款原因',
  `amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '退款金额',
  `img` varchar(255) NOT NULL DEFAULT '' COMMENT '退款凭据地址',
  `comment` varchar(255) NOT NULL DEFAULT '' COMMENT '退款说明',
  `status` int(4) NOT NULL DEFAULT '0' COMMENT '售后状态，0是可申请，1是用户已申请，2是管理员审核通过，3是管理员退款成功，4是管理员审核拒绝，5是用户已取消',
  `handle_time` datetime DEFAULT NULL COMMENT '处理时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='售后表';

-- ----------------------------
-- Table structure for mall_attr_group
-- ----------------------------
DROP TABLE IF EXISTS `mall_attr_group`;
CREATE TABLE `mall_attr_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '参数分组id',
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '分组名称',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='参数分组表';

-- ----------------------------
-- Records of mall_attr_group
-- ----------------------------
BEGIN;
INSERT INTO `mall_attr_group` VALUES (1, '连衣裙', '2020-08-05 20:55:45', NULL, 0);
INSERT INTO `mall_attr_group` VALUES (2, 'T恤', '2020-08-10 23:17:37', NULL, 0);
INSERT INTO `mall_attr_group` VALUES (9, '半身裙', '2020-08-12 11:07:54', NULL, 0);
INSERT INTO `mall_attr_group` VALUES (10, '智能手机', '2020-08-15 21:25:52', NULL, 0);
INSERT INTO `mall_attr_group` VALUES (11, '笔记本', '2020-08-27 16:16:25', NULL, 0);
INSERT INTO `mall_attr_group` VALUES (12, '运动鞋', '2020-09-08 22:11:44', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_attr_group_relation
-- ----------------------------
DROP TABLE IF EXISTS `mall_attr_group_relation`;
CREATE TABLE `mall_attr_group_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '参数分组id',
  `attr_group_id` bigint(20) DEFAULT '0' COMMENT '分组id',
  `attr_id` bigint(20) DEFAULT '0' COMMENT '参数Id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COMMENT='参数分组关系表';

-- ----------------------------
-- Records of mall_attr_group_relation
-- ----------------------------
BEGIN;
INSERT INTO `mall_attr_group_relation` VALUES (1, 1, 1, '2020-08-05 20:56:14', NULL, 1);
INSERT INTO `mall_attr_group_relation` VALUES (2, 1, 2, '2020-08-05 20:56:44', NULL, 1);
INSERT INTO `mall_attr_group_relation` VALUES (3, 1, 3, '2020-08-05 20:56:42', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (4, 1, 4, '2020-08-05 20:56:39', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (5, 1, 5, '2020-08-05 20:56:51', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (6, 1, 8, '2020-08-05 20:56:58', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (7, 1, 9, '2020-08-05 20:57:05', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (8, 1, 10, '2020-08-05 20:57:13', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (9, 1, 11, '2020-08-05 20:57:20', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (10, 1, 12, '2020-08-05 20:57:27', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (11, 1, 13, '2020-08-05 20:57:38', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (12, 1, 14, '2020-08-05 20:57:46', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (13, 1, 16, '2020-08-05 20:59:08', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (14, 1, 15, '2020-08-05 20:59:12', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (16, 2, 18, '2020-08-10 23:17:37', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (17, 2, 19, '2020-08-10 23:25:27', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (18, 2, 20, '2020-08-10 23:25:47', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (19, 2, 21, '2020-08-11 22:27:30', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (20, 2, 22, '2020-08-11 22:27:47', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (21, 2, 23, '2020-08-11 22:28:04', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (22, 2, 24, '2020-08-11 22:28:31', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (24, 2, 26, '2020-08-11 22:46:45', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (25, 1, 27, '2020-08-12 10:51:39', NULL, 1);
INSERT INTO `mall_attr_group_relation` VALUES (26, 1, 28, '2020-08-12 10:51:56', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (27, 1, 29, '2020-08-12 10:52:31', NULL, 1);
INSERT INTO `mall_attr_group_relation` VALUES (28, 9, 30, '2020-08-12 11:07:54', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (29, 9, 31, '2020-08-12 11:08:20', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (30, 9, 32, '2020-08-12 11:08:35', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (31, 9, 33, '2020-08-12 11:08:50', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (32, 9, 34, '2020-08-12 11:09:10', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (33, 10, 35, '2020-08-15 21:25:52', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (34, 10, 36, '2020-08-15 21:26:05', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (35, 10, 37, '2020-08-15 21:26:16', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (36, 10, 38, '2020-08-15 21:26:28', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (37, 10, 39, '2020-08-15 21:26:39', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (38, 10, 40, '2020-08-15 21:26:56', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (39, 10, 41, '2020-08-15 21:27:10', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (40, 10, 42, '2020-08-15 21:27:23', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (41, 10, 43, '2020-08-15 21:28:07', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (42, 10, 44, '2020-08-15 21:28:34', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (43, 11, 45, '2020-08-27 16:16:25', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (44, 11, 46, '2020-08-27 16:16:46', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (45, 11, 47, '2020-08-27 16:16:59', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (46, 11, 48, '2020-08-27 16:17:13', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (47, 11, 49, '2020-08-27 16:17:30', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (48, 11, 50, '2020-08-27 16:17:47', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (49, 12, 51, '2020-09-08 22:11:44', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (50, 12, 52, '2020-09-08 22:11:59', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (51, 12, 53, '2020-09-08 22:12:11', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (52, 12, 54, '2020-09-08 22:12:24', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (53, 12, 55, '2020-09-08 22:12:40', NULL, 0);
INSERT INTO `mall_attr_group_relation` VALUES (54, 12, 56, '2020-09-08 22:12:54', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `mall_attr_value`;
CREATE TABLE `mall_attr_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '参数值id',
  `attr_value` varchar(255) NOT NULL DEFAULT '' COMMENT '参数值',
  `spu_id` bigint(20) DEFAULT NULL COMMENT '商品spuId',
  `attr_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '参数名id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COMMENT='属性值表';

-- ----------------------------
-- Records of mall_attr_value
-- ----------------------------
BEGIN;
INSERT INTO `mall_attr_value` VALUES (1, 'Apple/苹果', 1, 35, '2020-08-15 22:52:02', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (2, 'iPhone11', 1, 36, '2020-08-15 22:52:28', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (3, '苹果A13', 1, 37, '2020-08-15 22:52:57', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (4, '4G', 1, 38, '2020-08-15 22:54:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (5, '64GB,128GB,256GB', 1, 39, '2020-08-15 22:54:26', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (6, 'IOS', 1, 40, '2020-08-15 22:55:03', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (7, '6.1英寸', 1, 41, '2020-08-15 22:55:23', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (8, '1792*828像素', 1, 42, '2020-08-15 22:56:19', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (9, '双卡双待', 1, 43, '2020-08-15 22:56:44', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (10, '2019-09', 1, 44, '2020-08-15 22:57:09', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (11, 'Xiaomi/小米', 2, 35, '2020-08-21 16:04:36', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (12, '小米10 PRO', 2, 36, '2020-08-21 16:06:28', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (13, '骁龙865', 2, 37, '2020-08-21 16:06:31', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (14, '5G', 2, 38, '2020-08-21 16:06:34', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (15, '8+256GB 12+256GB 12+512GB', 2, 39, '2020-08-21 16:06:59', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (16, 'MIUI', 2, 40, '2020-08-21 16:07:30', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (17, '6.67英寸', 2, 41, '2020-08-21 16:07:47', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (18, '2340*1080 FHD+', 2, 42, '2020-08-21 16:08:15', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (19, '双卡双待', 2, 43, '2020-08-21 16:08:54', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (20, '2020', 2, 44, '2020-08-21 16:08:51', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (22, '华为', 5, 35, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_attr_value` VALUES (23, 'nova7', 5, 36, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_attr_value` VALUES (24, '麒麟960', 5, 37, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_attr_value` VALUES (25, '8GB', 5, 38, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_attr_value` VALUES (26, '128GB,256GB', 5, 39, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_attr_value` VALUES (27, '安卓', 5, 40, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_attr_value` VALUES (28, '5.7', 5, 41, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_attr_value` VALUES (29, '1920*1080', 5, 42, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_attr_value` VALUES (30, '双卡双待', 5, 43, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_attr_value` VALUES (31, '2020年', 5, 44, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_attr_value` VALUES (32, '酷睿I5', 6, 45, '2020-08-27 16:50:50', '2020-09-02 10:42:51', 1);
INSERT INTO `mall_attr_value` VALUES (33, '16GB', 6, 46, '2020-08-27 16:50:50', '2020-09-02 10:42:51', 1);
INSERT INTO `mall_attr_value` VALUES (34, '14寸', 6, 47, '2020-08-27 16:50:50', '2020-09-02 10:42:51', 1);
INSERT INTO `mall_attr_value` VALUES (35, '集成显卡', 6, 48, '2020-08-27 16:50:50', '2020-09-02 10:42:51', 1);
INSERT INTO `mall_attr_value` VALUES (36, '轻薄本', 6, 49, '2020-08-27 16:50:50', '2020-09-02 10:42:51', 1);
INSERT INTO `mall_attr_value` VALUES (37, '中国', 6, 50, '2020-08-27 16:50:50', '2020-09-02 10:42:51', 1);
INSERT INTO `mall_attr_value` VALUES (48, '短裙', 8, 3, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (49, '常规', 8, 4, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (50, '少女', 8, 5, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (51, '柔软', 8, 8, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (52, '春夏', 8, 9, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (53, '无领', 8, 10, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (54, '无', 8, 11, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (55, '短袖', 8, 12, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (56, '格子', 8, 13, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (57, '面料，100%聚酯纤维 ，里料，100%聚酯纤维', 8, 14, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (58, '2020年', 8, 16, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (59, '常规', 8, 15, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (60, '无弹', 8, 27, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (61, '修身', 8, 28, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (62, '无弹', 8, 29, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (63, '无弹', 18, 30, '2020-09-06 23:04:58', '2020-09-07 22:10:32', 1);
INSERT INTO `mall_attr_value` VALUES (64, '收腰', 18, 31, '2020-09-06 23:04:58', '2020-09-07 22:10:32', 1);
INSERT INTO `mall_attr_value` VALUES (65, '短裙', 18, 32, '2020-09-06 23:04:58', '2020-09-07 22:10:32', 1);
INSERT INTO `mall_attr_value` VALUES (66, '韩版', 18, 34, '2020-09-06 23:04:58', '2020-09-07 22:10:32', 1);
INSERT INTO `mall_attr_value` VALUES (67, '常规', 18, 33, '2020-09-06 23:04:58', '2020-09-07 22:10:32', 1);
INSERT INTO `mall_attr_value` VALUES (68, '平底', 19, 51, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (69, '适中', 19, 52, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (70, '系带', 19, 53, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (71, '春夏秋冬', 19, 54, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (72, '合成革', 19, 55, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_attr_value` VALUES (73, '女性', 19, 56, '2020-09-08 22:53:49', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_brand
-- ----------------------------
DROP TABLE IF EXISTS `mall_brand`;
CREATE TABLE `mall_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '' COMMENT '品牌名称',
  `logo` varchar(255) NOT NULL DEFAULT '' COMMENT '品牌图片',
  `introduction` varchar(1024) NOT NULL DEFAULT '' COMMENT '品牌介绍',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '上次修改时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COMMENT='品牌分类表';

-- ----------------------------
-- Records of mall_brand
-- ----------------------------
BEGIN;
INSERT INTO `mall_brand` VALUES (1, '苹果', 'https://a.vpimg3.com/upload/goadmin/2020/01/02/67/157797085366910735_120x120_90.jpg', '苹果公司（Apple Inc. ）是美国一家高科技公司。由史蒂夫·乔布斯、斯蒂夫·沃兹尼亚克和罗·韦恩(Ron Wayne)等人于1976年4月1日创立，并命名为美国苹果电脑公司（Apple Computer Inc. ），2007年1月9日更名为苹果公司，总部位于加利福尼亚州的库比蒂诺', '2020-08-12 14:36:24', '2020-08-15 16:24:37', 0);
INSERT INTO `mall_brand` VALUES (2, '小米', 'https://a.vpimg3.com/upload/goadmin/2020/03/07/171/158354651899410132_120x120_90.png', '小米是一家以手机、智能硬件和IoT平台为核心的互联网公司，以智能手机、智能电视、笔记本等丰富的产品与服务。致力于让全球每个人都能享受科技带来的美好生活', '2020-08-12 16:23:38', NULL, 0);
INSERT INTO `mall_brand` VALUES (3, '联想', 'https://a.vpimg3.com/upload/goadmin/2018/01/31/74/15173986858202_120x120_90.jpg', '联想集团（下称联想）是一家成立于中国、业务遍及180个市场的全球化科技公司。联想聚焦全球化发展，树立了行业领先的多元企业文化和运营模式典范，服务全球超过10亿用户。作为值得信赖的全球科技企业领导者，联想助力客户，把握明日科技，变革今日世界。', '2020-08-12 16:45:55', NULL, 0);
INSERT INTO `mall_brand` VALUES (4, '华为', 'http://qemdt7zgj.bkt.clouddn.com/88f6563d-db9d-45a3-a9b8-9294a22b293e.jpg', '华为消费者业务产品全面覆盖手机、移动宽带终端、终端云等，凭借自身的全球化网络优势、全球化运营能力，致力于将最新的科技带给消费者，让世界各地享受到技术进步的喜悦，以行践言，实现梦想。', '2020-08-13 22:21:41', NULL, 0);
INSERT INTO `mall_brand` VALUES (5, 'vivo', 'http://qemdt7zgj.bkt.clouddn.com/84b6b45e-0008-4742-b6ef-d34c71f88084.jpg', 'vivo是一家全球性的移动互联网智能终端公司，致力于为消费者打造拥有极致拍照、畅快游戏、Hi-Fi音乐的智能手机产品。当季的明星产品主要有vivo S7、vivo X50系列、Y51s、NEX 3S等。', '2020-08-13 22:24:37', NULL, 0);
INSERT INTO `mall_brand` VALUES (6, '戴尔', 'http://qemdt7zgj.bkt.clouddn.com/7adbdc11-0944-4040-98ee-07a2d565481d.png', '戴尔（Dell），是一家总部位于美国德克萨斯州朗德罗克的世界五百强企业，由迈克尔·戴尔于1984年创立。戴尔以生产、设计、销售家用以及办公室电脑而闻名，不过它同时也涉足高端电脑市场，生产与销售服务器、数据储存设备、网络设备等。', '2020-08-13 22:27:47', NULL, 0);
INSERT INTO `mall_brand` VALUES (7, 'La Chapelle SPORT', 'http://qg6txnoqg.hb-bkt.clouddn.com/product/brand/5d941d6e-eedf-4415-ba9d-985688686f4c.jpeg', '“La Chapelle SPORT”是拉夏贝尔La chapelle集团旗下的一个时尚休闲品牌，主打休闲少女风格，La Chapelle SPORT一直致力于为年轻一代传递健康、时尚、青春、自由的力量，广受消费者的认可及喜爱。', '2020-09-05 22:59:08', NULL, 0);
INSERT INTO `mall_brand` VALUES (8, '卡帝乐鳄鱼', 'http://qg6txnoqg.hb-bkt.clouddn.com/product/brand/fa6c5067-39ae-46a2-ad08-396d61a65073.png', '卡帝乐鳄鱼于1947年创立于新加坡，并于1993年进入中国大陆，2011年初，品牌在全国已经设有2000多家的各类专卖店铺。由于卡帝乐鳄鱼CARTELO品牌的知名度，以及社会的认知度，连续多年获得国家统计局颁发的全国市场十大畅销品牌等殊荣。', '2020-09-06 22:33:05', NULL, 0);
INSERT INTO `mall_brand` VALUES (9, '耐克', 'http://qg6txnoqg.hb-bkt.clouddn.com/product/brand/d1f1dda7-d756-40db-8468-980438c09b20.jpg', 'Just do it！1972年，耐克Nike成立于美国俄勒冈州，耐克一直将激励全世界的每一位运动员并为其献上好的产品视为光荣的任务。耐克首创的气垫技术给体育界带来了一场革命。', '2020-09-08 22:08:52', '2020-09-08 22:10:36', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_brand_category_relation
-- ----------------------------
DROP TABLE IF EXISTS `mall_brand_category_relation`;
CREATE TABLE `mall_brand_category_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '品牌分类关系表ID',
  `brand_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '品牌id',
  `category_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '三级分类id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COMMENT='品牌分类关系表';

-- ----------------------------
-- Records of mall_brand_category_relation
-- ----------------------------
BEGIN;
INSERT INTO `mall_brand_category_relation` VALUES (1, 1, 92, '2020-08-12 14:38:40', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (2, 1, 93, '2020-08-12 14:38:43', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (3, 1, 94, '2020-08-12 14:38:46', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (4, 1, 95, '2020-08-12 14:38:49', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (5, 2, 92, '2020-08-12 16:24:40', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (6, 2, 93, '2020-08-12 16:24:43', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (7, 2, 94, '2020-08-12 16:24:46', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (8, 3, 93, '2020-08-12 16:47:16', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (9, 3, 94, '2020-08-12 16:47:23', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (10, 3, 95, '2020-08-12 16:47:31', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (11, 4, 92, '2020-08-13 22:21:41', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (12, 4, 94, '2020-08-13 22:21:41', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (13, 4, 93, '2020-08-13 22:21:41', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (14, 5, 92, '2020-08-13 22:24:37', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (15, 6, 94, '2020-08-13 22:27:47', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (16, 6, 95, '2020-08-13 22:27:47', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (20, 3, 92, '2020-08-15 11:04:34', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (21, 1, 6, '2020-08-15 11:14:37', NULL, 1);
INSERT INTO `mall_brand_category_relation` VALUES (22, 1, 9, '2020-08-15 14:51:46', NULL, 1);
INSERT INTO `mall_brand_category_relation` VALUES (23, 1, 28, '2020-08-15 14:53:31', NULL, 1);
INSERT INTO `mall_brand_category_relation` VALUES (24, 1, 69, '2020-08-15 14:55:53', NULL, 1);
INSERT INTO `mall_brand_category_relation` VALUES (25, 1, 7, '2020-08-15 14:56:29', NULL, 1);
INSERT INTO `mall_brand_category_relation` VALUES (26, 6, 95, '2020-08-15 15:22:59', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (27, 7, 6, '2020-09-05 22:59:08', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (28, 7, 7, '2020-09-05 22:59:08', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (29, 7, 9, '2020-09-05 22:59:08', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (30, 8, 7, '2020-09-06 22:33:05', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (31, 8, 9, '2020-09-06 22:33:05', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (32, 9, 28, '2020-09-08 22:08:52', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (33, 9, 10, '2020-09-08 22:08:52', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (34, 9, 29, '2020-09-08 22:08:52', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (35, 9, 60, '2020-09-08 22:08:52', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (36, 9, 62, '2020-09-08 22:08:52', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (37, 9, 61, '2020-09-08 22:08:52', NULL, 0);
INSERT INTO `mall_brand_category_relation` VALUES (38, 9, 71, '2020-09-08 22:08:52', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_brand_goods_relation
-- ----------------------------
DROP TABLE IF EXISTS `mall_brand_goods_relation`;
CREATE TABLE `mall_brand_goods_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '品牌商品id',
  `brand_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '品牌id',
  `goods_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='品牌商品关系表';

-- ----------------------------
-- Records of mall_brand_goods_relation
-- ----------------------------
BEGIN;
INSERT INTO `mall_brand_goods_relation` VALUES (1, 6, 6, '2020-08-27 16:50:50', '2020-08-30 14:59:29', 1);
INSERT INTO `mall_brand_goods_relation` VALUES (2, 2, 2, '2020-09-02 15:38:13', NULL, 0);
INSERT INTO `mall_brand_goods_relation` VALUES (4, 7, 8, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_brand_goods_relation` VALUES (14, 8, 18, '2020-09-06 23:04:58', NULL, 1);
INSERT INTO `mall_brand_goods_relation` VALUES (15, 9, 19, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_brand_goods_relation` VALUES (16, 4, 5, NULL, NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for mall_cart
-- ----------------------------
DROP TABLE IF EXISTS `mall_cart`;
CREATE TABLE `mall_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `total_price` decimal(10,2) DEFAULT '0.00' COMMENT '购物车总价',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购物车';

-- ----------------------------
-- Table structure for mall_cart_item
-- ----------------------------
DROP TABLE IF EXISTS `mall_cart_item`;
CREATE TABLE `mall_cart_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '购物车商品id',
  `cart_id` bigint(20) DEFAULT '0' COMMENT '购物车id',
  `goods_id` bigint(20) DEFAULT '0' COMMENT '商品id',
  `goods_name` varchar(32) DEFAULT '' COMMENT '商品名称',
  `spec_sn` varchar(32) DEFAULT NULL COMMENT '商品规格码',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `number` int(11) DEFAULT NULL COMMENT '商品数量',
  `checked` int(1) DEFAULT '1' COMMENT '是否被选择 0-否，1-是',
  `goods_img` varchar(64) DEFAULT NULL COMMENT '商品图片',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购物车商品';

-- ----------------------------
-- Table structure for mall_category
-- ----------------------------
DROP TABLE IF EXISTS `mall_category`;
CREATE TABLE `mall_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品类目id',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '类目名称',
  `level` int(1) NOT NULL DEFAULT '0' COMMENT '商品级别 0-一级 1 1-二级 2-三级 ',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '父级分类id',
  `img` varchar(255) NOT NULL DEFAULT '' COMMENT '类目图片',
  `icon` varchar(255) NOT NULL DEFAULT '' COMMENT '类目图标',
  `attr_group_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '类目参数id',
  `detail` varchar(255) NOT NULL DEFAULT '' COMMENT '类目描述',
  `sort` int(1) NOT NULL DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最近修改时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1-已删除 0-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COMMENT='商品类目表';

-- ----------------------------
-- Records of mall_category
-- ----------------------------
BEGIN;
INSERT INTO `mall_category` VALUES (1, '女装', 0, 0, '', '', 0, '女装', 0, '2020-08-07 20:23:26', '2020-08-07 20:23:27', 0);
INSERT INTO `mall_category` VALUES (2, '美裙衣橱', 1, 1, '', '', 0, '美裙衣橱', 0, '2020-08-07 23:26:15', '2020-08-07 23:26:15', 0);
INSERT INTO `mall_category` VALUES (3, '百搭上衣', 1, 1, '', '', 0, '百搭上衣', 1, '2020-08-02 23:15:25', NULL, 0);
INSERT INTO `mall_category` VALUES (4, '外套', 1, 1, '', '', 0, '外套', 2, '2020-08-02 23:15:28', NULL, 0);
INSERT INTO `mall_category` VALUES (5, '裤子', 1, 1, '', '', 0, '裤子', 3, '2020-08-02 23:15:31', NULL, 0);
INSERT INTO `mall_category` VALUES (6, '连衣裙', 2, 2, 'https://a.vpimg3.com/upload/goadmin/2020/05/11/140/158918808155810109_120x120_90.jpg', '', 1, '连衣裙', 0, '2020-08-06 13:44:03', NULL, 0);
INSERT INTO `mall_category` VALUES (7, '半身裙', 2, 2, 'https://a.vpimg3.com/upload/goadmin/2018/06/11/11/15286886223150_120x120_90.png', '', 9, '半身裙', 1, '2020-08-06 13:50:25', '2020-08-12 11:07:54', 0);
INSERT INTO `mall_category` VALUES (8, '旗袍', 2, 2, 'https://a.vpimg3.com/upload/goadmin/2019/07/04/0/15622103775507_120x120_90.jpg', '', 0, '旗袍', 2, '2020-08-06 13:52:42', NULL, 0);
INSERT INTO `mall_category` VALUES (9, '修身美裙', 2, 2, 'https://a.vpimg3.com/upload/goadmin/2018/06/11/121/15286878758512_120x120_90.png', '', 0, '修身美裙', 3, '2020-08-06 13:51:58', NULL, 0);
INSERT INTO `mall_category` VALUES (10, 'T恤', 2, 3, 'https://a.vpimg3.com/upload/goadmin/2020/05/11/16/158919081416210617_120x120_90.jpg', '', 2, 'T恤', 0, '2020-08-10 23:24:20', NULL, 0);
INSERT INTO `mall_category` VALUES (11, '衬衫', 2, 3, 'http://qemdt7zgj.bkt.clouddn.com/da7a67a8-45c3-42fa-9628-4767b7ad282e.jpg', '', 0, '衬衫', 1, '2020-08-07 20:44:53', '2020-08-07 20:44:53', 0);
INSERT INTO `mall_category` VALUES (12, '针织衫', 2, 3, 'http://qemdt7zgj.bkt.clouddn.com/b9670403-4ce0-468f-8aa6-b2867b373df4.png', '', 0, '针织衫', 2, '2020-08-07 20:48:17', '2020-08-07 20:48:17', 0);
INSERT INTO `mall_category` VALUES (13, '卫衣', 2, 3, '', '', 0, '卫衣', 3, '2020-08-02 23:15:46', NULL, 0);
INSERT INTO `mall_category` VALUES (14, '毛衣', 2, 3, '', '', 0, '毛衣', 4, '2020-08-02 23:15:51', NULL, 0);
INSERT INTO `mall_category` VALUES (15, '西装外套', 2, 4, '', '', 0, '西装外套', 0, '2020-08-02 22:51:02', NULL, 0);
INSERT INTO `mall_category` VALUES (16, '风衣', 2, 4, '', '', 0, '风衣', 1, '2020-08-02 23:15:55', NULL, 0);
INSERT INTO `mall_category` VALUES (17, '马甲', 2, 4, '', '', 0, '马甲', 2, '2020-08-02 23:15:56', NULL, 0);
INSERT INTO `mall_category` VALUES (18, '针织外套', 2, 4, '', '', 0, '针织外套', 3, '2020-08-02 23:16:00', NULL, 0);
INSERT INTO `mall_category` VALUES (19, '短裤', 2, 5, '', '', 0, '短裤', 0, '2020-08-02 22:56:07', NULL, 0);
INSERT INTO `mall_category` VALUES (20, '牛仔裤', 2, 5, '', '', 0, '牛仔裤', 1, '2020-08-02 23:16:04', NULL, 0);
INSERT INTO `mall_category` VALUES (21, '阔腿裤', 2, 5, '', '', 0, '阔腿裤', 2, '2020-08-02 23:16:06', NULL, 0);
INSERT INTO `mall_category` VALUES (22, '打底裤', 2, 5, '', '', 0, '打底裤', 3, '2020-08-02 23:16:07', NULL, 0);
INSERT INTO `mall_category` VALUES (23, '羽绒裤', 2, 5, '', '', 0, '羽绒裤', 4, '2020-08-02 23:16:48', NULL, 0);
INSERT INTO `mall_category` VALUES (24, '男装', 0, 0, '', '', 0, '男装', 1, '2020-08-02 23:15:20', NULL, 0);
INSERT INTO `mall_category` VALUES (25, '内搭', 1, 24, '', '', 0, '内搭', 0, '2020-08-07 23:26:47', '2020-08-07 23:26:48', 0);
INSERT INTO `mall_category` VALUES (26, '裤装', 1, 24, '', '', 0, '裤装', 1, '2020-08-02 23:16:58', NULL, 0);
INSERT INTO `mall_category` VALUES (27, '外套', 1, 24, '', '', 0, '外套', 2, '2020-08-02 23:17:02', NULL, 0);
INSERT INTO `mall_category` VALUES (28, '短袖T恤', 2, 25, '', '', 0, '短袖T恤', 0, '2020-08-02 23:02:34', NULL, 0);
INSERT INTO `mall_category` VALUES (29, '长袖T恤', 2, 25, '', '', 0, '长袖T恤', 1, '2020-08-02 23:17:43', NULL, 0);
INSERT INTO `mall_category` VALUES (30, '短袖衬衫', 2, 25, '', '', 0, '短袖衬衫', 2, '2020-08-02 23:17:46', NULL, 0);
INSERT INTO `mall_category` VALUES (31, '长袖衬衫', 2, 25, '', '', 0, '长袖衬衫', 3, '2020-08-02 23:17:48', NULL, 0);
INSERT INTO `mall_category` VALUES (32, 'polo衫', 2, 25, '', '', 0, 'polo衫', 4, '2020-08-02 23:17:50', NULL, 0);
INSERT INTO `mall_category` VALUES (33, '毛衣', 2, 25, '', '', 0, '毛衣', 5, '2020-08-02 23:17:53', NULL, 0);
INSERT INTO `mall_category` VALUES (34, '卫衣', 2, 25, '', '', 0, '卫衣', 6, '2020-08-02 23:17:55', NULL, 0);
INSERT INTO `mall_category` VALUES (35, '休闲裤', 2, 26, '', '', 0, '休闲裤', 0, '2020-08-02 23:08:23', NULL, 0);
INSERT INTO `mall_category` VALUES (36, '牛仔裤', 2, 26, '', '', 0, '牛仔裤', 1, '2020-08-02 23:17:59', NULL, 0);
INSERT INTO `mall_category` VALUES (37, '西裤', 2, 26, '', '', 0, '西裤', 2, '2020-08-02 23:18:00', NULL, 0);
INSERT INTO `mall_category` VALUES (38, '运动裤', 2, 26, '', '', 0, '运动裤', 3, '2020-08-02 23:18:01', NULL, 0);
INSERT INTO `mall_category` VALUES (39, '九分裤', 2, 26, '', '', 0, '九分裤', 4, '2020-08-02 23:18:03', NULL, 0);
INSERT INTO `mall_category` VALUES (40, '短裤', 2, 26, '', '', 0, '短裤', 5, '2020-08-02 23:18:05', NULL, 0);
INSERT INTO `mall_category` VALUES (41, '风衣', 2, 27, '', '', 0, '风衣', 0, '2020-08-02 23:11:35', NULL, 0);
INSERT INTO `mall_category` VALUES (42, '薄外套', 2, 27, '', '', 0, '薄外套', 1, '2020-08-02 23:18:14', NULL, 0);
INSERT INTO `mall_category` VALUES (43, '夹克', 2, 27, '', '', 0, '夹克', 2, '2020-08-02 23:18:15', NULL, 0);
INSERT INTO `mall_category` VALUES (44, '大衣', 2, 27, '', '', 0, '大衣', 3, '2020-08-02 23:18:17', NULL, 0);
INSERT INTO `mall_category` VALUES (45, '厚外套', 2, 27, '', '', 0, '厚外套', 4, '2020-08-02 23:18:18', NULL, 0);
INSERT INTO `mall_category` VALUES (46, '西装', 2, 27, '', '', 0, '西装', 5, '2020-08-02 23:18:22', NULL, 0);
INSERT INTO `mall_category` VALUES (47, '羽绒服', 2, 27, '', '', 0, '羽绒服', 6, '2020-08-02 23:18:29', NULL, 0);
INSERT INTO `mall_category` VALUES (48, '女鞋', 0, 0, '', '', 0, '女鞋', 2, '2020-08-03 22:28:22', NULL, 0);
INSERT INTO `mall_category` VALUES (49, '凉鞋', 1, 48, '', '', 0, '凉鞋', 0, '2020-08-03 22:27:57', NULL, 0);
INSERT INTO `mall_category` VALUES (50, '单鞋', 1, 48, '', '', 0, '单鞋', 1, '2020-08-03 22:28:43', NULL, 0);
INSERT INTO `mall_category` VALUES (51, '休闲鞋', 1, 48, '', '', 0, '休闲鞋', 2, '2020-08-03 22:29:55', NULL, 0);
INSERT INTO `mall_category` VALUES (52, '平底凉鞋', 2, 49, '', '', 0, '平底凉鞋', 0, '2020-08-03 22:30:00', NULL, 0);
INSERT INTO `mall_category` VALUES (53, '高跟凉鞋', 2, 49, '', '', 0, '高跟凉鞋', 1, '2020-08-03 22:30:25', NULL, 0);
INSERT INTO `mall_category` VALUES (54, '粗跟凉鞋', 2, 49, '', '', 0, '粗跟凉鞋', 2, '2020-08-03 22:31:09', NULL, 0);
INSERT INTO `mall_category` VALUES (55, '一字带凉鞋', 2, 49, '', '', 0, '一字带凉鞋', 3, '2020-08-03 22:31:24', NULL, 0);
INSERT INTO `mall_category` VALUES (56, '高跟鞋', 2, 50, '', '', 0, '高跟鞋', 0, '2020-08-03 22:32:14', NULL, 0);
INSERT INTO `mall_category` VALUES (57, '低跟鞋', 2, 50, '', '', 0, '低跟鞋', 1, '2020-08-03 22:32:34', NULL, 0);
INSERT INTO `mall_category` VALUES (58, '粗跟鞋', 2, 50, '', '', 0, '粗跟鞋', 2, '2020-08-03 22:32:53', NULL, 0);
INSERT INTO `mall_category` VALUES (59, '尖头鞋', 2, 50, '', '', 0, '粗跟鞋', 3, '2020-08-03 22:33:13', NULL, 0);
INSERT INTO `mall_category` VALUES (60, '板鞋', 2, 51, '', '', 0, '板鞋', 0, '2020-08-03 22:33:38', NULL, 0);
INSERT INTO `mall_category` VALUES (61, '帆布鞋', 2, 51, '', '', 0, '帆布鞋', 1, '2020-08-03 22:33:52', NULL, 0);
INSERT INTO `mall_category` VALUES (62, '运动鞋', 2, 51, '', '', 12, '运动鞋', 2, '2020-08-03 22:34:12', '2020-09-08 22:11:44', 0);
INSERT INTO `mall_category` VALUES (63, '老爹鞋', 2, 51, '', '', 0, '老爹鞋', 3, '2020-08-03 22:34:33', NULL, 0);
INSERT INTO `mall_category` VALUES (64, '小白鞋', 2, 51, '', '', 0, '小白鞋', 4, '2020-08-03 22:36:25', NULL, 0);
INSERT INTO `mall_category` VALUES (65, '男鞋', 0, 0, '', '', 0, '男鞋', 3, '2020-08-07 22:23:57', '2020-08-07 22:23:58', 0);
INSERT INTO `mall_category` VALUES (66, '休闲鞋', 1, 65, '', '', 0, '休闲鞋', 0, '2020-08-03 22:37:00', NULL, 0);
INSERT INTO `mall_category` VALUES (67, '凉鞋', 1, 65, '', '', 0, '凉鞋', 1, '2020-08-03 22:37:21', NULL, 0);
INSERT INTO `mall_category` VALUES (68, '商务鞋', 1, 65, '', '', 0, '商务鞋', 2, '2020-08-03 22:37:44', NULL, 0);
INSERT INTO `mall_category` VALUES (69, '休闲皮鞋', 2, 66, '', '', 0, '休闲皮鞋', 0, '2020-08-03 22:38:56', NULL, 0);
INSERT INTO `mall_category` VALUES (70, '帆布鞋', 2, 66, '', '', 0, '帆布鞋', 1, '2020-08-03 22:39:14', NULL, 0);
INSERT INTO `mall_category` VALUES (71, '运动鞋', 2, 66, '', '', 0, '运动鞋', 2, '2020-08-03 22:39:39', NULL, 0);
INSERT INTO `mall_category` VALUES (72, '豆豆鞋', 2, 66, '', '', 0, '豆豆鞋', 3, '2020-08-03 22:39:59', NULL, 0);
INSERT INTO `mall_category` VALUES (73, '网面鞋', 2, 66, '', '', 0, '网面鞋', 4, '2020-08-03 22:40:23', NULL, 0);
INSERT INTO `mall_category` VALUES (74, '凉鞋', 2, 67, '', '', 0, '凉鞋', 0, '2020-08-03 22:41:01', NULL, 0);
INSERT INTO `mall_category` VALUES (75, '沙滩凉鞋', 2, 67, '', '', 0, '沙滩凉鞋', 1, '2020-08-03 22:41:25', NULL, 0);
INSERT INTO `mall_category` VALUES (76, '洞洞鞋', 2, 67, '', '', 0, '洞洞鞋', 2, '2020-08-03 22:41:48', NULL, 0);
INSERT INTO `mall_category` VALUES (77, '正装鞋', 2, 68, '', '', 0, '正装鞋', 0, '2020-08-03 22:42:14', NULL, 0);
INSERT INTO `mall_category` VALUES (78, '英伦鞋', 2, 68, '', '', 0, '英伦鞋', 1, '2020-08-03 22:42:39', NULL, 0);
INSERT INTO `mall_category` VALUES (79, '系带商务鞋', 2, 68, '', '', 0, '系带商务鞋', 2, '2020-08-03 22:43:09', NULL, 0);
INSERT INTO `mall_category` VALUES (80, '套脚商务鞋', 2, 68, '', '', 0, '套脚商务鞋', 3, '2020-08-03 22:43:28', NULL, 0);
INSERT INTO `mall_category` VALUES (81, '箱包皮具', 0, 0, '', '', 0, '箱包皮具', 4, '2020-08-07 23:25:27', '2020-08-07 23:25:28', 0);
INSERT INTO `mall_category` VALUES (82, '女包', 1, 81, '', '', 0, '女包', 0, '2020-08-07 23:24:25', '2020-08-07 23:24:25', 0);
INSERT INTO `mall_category` VALUES (83, '男包', 1, 81, '', '', 0, '男包', 1, '2020-08-07 23:24:32', '2020-08-07 23:24:33', 0);
INSERT INTO `mall_category` VALUES (84, '家用电器', 0, 0, '', '', 0, '家用电器', 5, '2020-08-07 23:25:34', '2020-08-07 23:25:35', 0);
INSERT INTO `mall_category` VALUES (85, '品质厨电', 1, 84, '', '', 0, '品质厨电', 0, '2020-08-07 23:02:33', '2020-08-07 23:02:34', 0);
INSERT INTO `mall_category` VALUES (86, '空调', 1, 84, '', '', 0, '空调', 1, '2020-08-12 11:24:15', NULL, 0);
INSERT INTO `mall_category` VALUES (87, '手机数码', 0, 0, '', '', 0, '手机数码', 5, '2020-08-12 13:22:29', NULL, 0);
INSERT INTO `mall_category` VALUES (88, '精选手机', 1, 87, '', '', 0, '精选手机', 0, '2020-08-12 13:23:15', NULL, 0);
INSERT INTO `mall_category` VALUES (89, '电脑', 1, 87, '', ' ', 0, '电脑', 1, '2020-08-12 13:24:06', NULL, 0);
INSERT INTO `mall_category` VALUES (90, '数码配件', 1, 87, '', '', 0, '数码配件', 2, '2020-08-12 13:24:34', NULL, 0);
INSERT INTO `mall_category` VALUES (91, '相机', 1, 87, '', '', 0, '相机', 3, '2020-08-12 13:25:10', NULL, 0);
INSERT INTO `mall_category` VALUES (92, '智能手机', 2, 88, 'https://a.vpimg3.com/upload/goadmin/2019/09/29/122/15697503073063_120x120_90.jpg', '', 10, '智能手机', 0, '2020-08-12 13:42:21', '2020-08-15 21:25:52', 0);
INSERT INTO `mall_category` VALUES (93, '平板电脑', 2, 89, 'https://a.vpimg3.com/upload/goadmin/2018/01/31/6/15173937483296_120x120_90.jpg', '', 0, '平板电脑', 0, '2020-08-12 13:42:23', NULL, 0);
INSERT INTO `mall_category` VALUES (94, '笔记本', 2, 89, 'http://qemdt7zgj.bkt.clouddn.com/514493ce-b656-4879-b52b-b344acd55956.jpg', '', 11, '笔记本', 1, '2020-08-12 13:41:19', '2020-08-27 16:16:25', 0);
INSERT INTO `mall_category` VALUES (95, '一体机', 2, 89, 'http://qemdt7zgj.bkt.clouddn.com/fdcc8183-c73e-4926-af29-9034e7045602.jpg', '', 0, '一体机', 2, '2020-08-12 13:46:20', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_category_goods_relation
-- ----------------------------
DROP TABLE IF EXISTS `mall_category_goods_relation`;
CREATE TABLE `mall_category_goods_relation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类商品id',
  `category_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '分类id',
  `goods_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='商品分类关系表';

-- ----------------------------
-- Records of mall_category_goods_relation
-- ----------------------------
BEGIN;
INSERT INTO `mall_category_goods_relation` VALUES (3, 92, 5, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_category_goods_relation` VALUES (4, 94, 6, '2020-08-27 16:50:50', NULL, 1);
INSERT INTO `mall_category_goods_relation` VALUES (5, 92, 2, '2020-09-02 15:36:49', NULL, 0);
INSERT INTO `mall_category_goods_relation` VALUES (7, 6, 8, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_category_goods_relation` VALUES (17, 7, 18, '2020-09-06 23:04:58', NULL, 1);
INSERT INTO `mall_category_goods_relation` VALUES (18, 62, 19, '2020-09-08 22:53:49', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_coupon
-- ----------------------------
DROP TABLE IF EXISTS `mall_coupon`;
CREATE TABLE `mall_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '优惠券id',
  `name` varchar(32) NOT NULL DEFAULT '' COMMENT '优惠券名称',
  `detail` varchar(255) NOT NULL DEFAULT '' COMMENT '优惠券介绍',
  `total` int(11) NOT NULL DEFAULT '0' COMMENT '发放数量 0-无限',
  `discount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额',
  `min` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '最低消费金额',
  `limit` int(11) NOT NULL COMMENT '用户最多领取数量',
  `status` int(1) DEFAULT NULL COMMENT '优惠券状态，如果是0则是正常可用；如果是1则是过期; 如果是2则是下架。',
  `type` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品限制类型，如果0则全商品，如果是1则是类目限制，如果是2则是商品限制。',
  `time_type` int(1) NOT NULL DEFAULT '0' COMMENT '有效时间限制，如果是0，则基于领取时间的有效天数days；如果是1，则start_time和end_time是优惠券有效期；',
  `days` int(11) NOT NULL DEFAULT '0' COMMENT '基于领取时间的有效天数days。',
  `start_time` datetime DEFAULT NULL COMMENT '开始领取时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束领取时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='优惠券';

-- ----------------------------
-- Table structure for mall_coupon_type
-- ----------------------------
DROP TABLE IF EXISTS `mall_coupon_type`;
CREATE TABLE `mall_coupon_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '优惠券类型id',
  `category_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '类目id',
  `coupon_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '优惠券id',
  `goods_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='优惠券类型表';

-- ----------------------------
-- Table structure for mall_goods_attr
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_attr`;
CREATE TABLE `mall_goods_attr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品参数id',
  `attr_name` varchar(64) NOT NULL DEFAULT '' COMMENT '参数名',
  `sort` int(1) NOT NULL DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COMMENT='商品参数表';

-- ----------------------------
-- Records of mall_goods_attr
-- ----------------------------
BEGIN;
INSERT INTO `mall_goods_attr` VALUES (1, '弹性', 0, '2020-08-05 20:50:44', '2020-08-12 10:22:38', 1);
INSERT INTO `mall_goods_attr` VALUES (2, '版型', 0, '2020-08-05 20:54:39', NULL, 1);
INSERT INTO `mall_goods_attr` VALUES (3, '衣长', 0, '2020-08-05 20:54:42', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (4, '厚薄', 0, '2020-08-05 20:54:45', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (5, '风格', 0, '2020-08-05 20:54:47', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (8, '柔软度', 0, '2020-08-05 20:54:51', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (9, '适用季节', 0, '2020-08-05 20:54:54', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (10, '领型', 0, '2020-08-05 20:55:00', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (11, '衣门襟', 0, '2020-08-05 20:55:04', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (12, '袖型', 0, '2020-08-05 20:55:08', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (13, '图案', 0, '2020-08-05 20:55:11', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (14, '面料', 0, '2020-08-05 20:55:19', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (15, '款式', 0, '2020-08-05 20:55:22', '2020-08-12 10:23:36', 0);
INSERT INTO `mall_goods_attr` VALUES (16, '上市时间', 0, '2020-08-05 20:55:26', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (18, '弹性', 0, '2020-08-10 23:17:37', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (19, '版型', 1, '2020-08-10 23:25:27', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (20, '衣长', 2, '2020-08-10 23:25:47', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (21, '厚薄', 3, '2020-08-11 22:27:30', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (22, '适用季节', 5, '2020-08-11 22:27:47', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (23, '上市时间', 4, '2020-08-11 22:28:04', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (24, '面料', 6, '2020-08-11 22:28:31', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (26, '适用人群', 6, '2020-08-11 22:46:45', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (27, '弹性', 0, '2020-08-12 10:51:39', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (28, '版型', 0, '2020-08-12 10:51:56', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (29, '弹性', 0, '2020-08-12 10:52:31', NULL, 1);
INSERT INTO `mall_goods_attr` VALUES (30, '弹性', 0, '2020-08-12 11:07:54', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (31, '版型', 1, '2020-08-12 11:08:20', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (32, '裙长', 2, '2020-08-12 11:08:35', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (33, '厚薄', 4, '2020-08-12 11:08:50', '2020-08-12 11:22:22', 0);
INSERT INTO `mall_goods_attr` VALUES (34, '风格', 3, '2020-08-12 11:09:10', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (35, '品牌', 0, '2020-08-15 21:25:52', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (36, '型号', 1, '2020-08-15 21:26:05', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (37, 'CPU型号', 2, '2020-08-15 21:26:16', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (38, '运行内存', 3, '2020-08-15 21:26:28', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (39, '机身存储', 4, '2020-08-15 21:26:39', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (40, '操作系统', 5, '2020-08-15 21:26:56', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (41, '主屏幕尺寸', 6, '2020-08-15 21:27:10', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (42, '分辨率', 7, '2020-08-15 21:27:23', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (43, '双卡机类型', 8, '2020-08-15 21:28:07', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (44, '上市时间', 9, '2020-08-15 21:28:34', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (45, '处理器', 0, '2020-08-27 16:16:25', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (46, '内存容量', 1, '2020-08-27 16:16:46', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (47, '屏幕尺寸', 2, '2020-08-27 16:16:59', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (48, '显卡', 3, '2020-08-27 16:17:13', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (49, '厚度', 4, '2020-08-27 16:17:30', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (50, '产地', 5, '2020-08-27 16:17:47', '2020-08-27 16:18:04', 0);
INSERT INTO `mall_goods_attr` VALUES (51, '跟型', 0, '2020-09-08 22:11:44', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (52, '脚底软度', 1, '2020-09-08 22:11:59', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (53, '闭合方式', 2, '2020-09-08 22:12:11', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (54, '适用季节', 3, '2020-09-08 22:12:24', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (55, '面材质', 4, '2020-09-08 22:12:40', NULL, 0);
INSERT INTO `mall_goods_attr` VALUES (56, '适用性别', 5, '2020-09-08 22:12:54', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_goods_comment
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_comment`;
CREATE TABLE `mall_goods_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `goods_id` bigint(20) DEFAULT NULL COMMENT '商品ID',
  `spec_sn` varchar(50) NOT NULL DEFAULT '' COMMENT '商品规格',
  `likes` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `score` int(11) NOT NULL DEFAULT '0' COMMENT '评分',
  `content` varchar(1024) NOT NULL DEFAULT '' COMMENT '评论内容',
  `img` varchar(1024) NOT NULL DEFAULT '' COMMENT '评论图片',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='商品评论表';

-- ----------------------------
-- Records of mall_goods_comment
-- ----------------------------
BEGIN;
INSERT INTO `mall_goods_comment` VALUES (1, 1, 1, '1#1-1&2-7', 5, 5, '手机确实很棒，*外形看起来舒服，本来是想着5G手机出来直接换的，直接换了11 手感特别好，颜色很喜欢，大小很合适，特别好看，屏幕音效也特别好，特别特别喜欢，拍照效果也特别好，很清楚，运行速度那就没得说，特别快，面容特别快，待机也很好。这款机子颜色特别多，本人喜欢，双面玻璃，不锈钢机身，四周钢琴烤漆，握起来很有手感，也很大气，手感不错，有份量，音效也还不错，摄像头实拍真实，拍出来的视频也还可以，下了几个app运行的还比较顺畅，暂无卡顿，待机时间比以前几款好多了，整体来说是个不错的选择！特意选了很好看，简直没得说大小正好，比现在用的流畅待机时间长。很喜欢也很推荐购买！用了快一个月才来评价的颜色很喜欢，照相很清楚 像素很好，很清晰，运行速度很快，很流畅。领了1000元的优惠券价格很合适，推荐大家购买 真的很不错 不管是手感还是外观都很喜欢 颜色也多 选了喜欢的 。那屏显音效真的没话说 速度快 特别是音效 听着都有环绕声', 'http://img30.360buyimg.com/shaidan/s720x540_jfs/t1/134741/38/619/125042/5ecf8a0eE093162a6/53c107220685f604.jpg,http://img30.360buyimg.com/shaidan/s720x540_jfs/t1/127032/8/3320/138102/5ecf8a0eEfe6df551/54d297c7cc18567a.jpg,http://img30.360buyimg.com/shaidan/s720x540_jfs/t1/119996/11/3264/121039/5ecf8a0eE0239054b/852020ae4f0666ef.jpg,http://img30.360buyimg.com/shaidan/s720x540_jfs/t1/126121/20/3282/104328/5ecf8a0eEb63bf41d/f0866bd7c03bf385.jpg', '2020-09-14 15:56:36', NULL, 0);
INSERT INTO `mall_goods_comment` VALUES (2, 2, 1, '1#1-2&2-8', 2, 4, '之前用的苹果8，一切没问题，就是电池不耐用！刷机后给老人用了！苹果11真的很不错，除了没有4g，但估计普及4g还早，到时候这个机器也该淘汰了！这台机器最近在背部出现个小裂痕，让我有点懵，因为手机买来第一时间套了手机壳，从来没拆下来用过，顶多拆下来擦擦，到现在也没明白咋回事，因为裂痕旁边没有任何其他划痕！', '', '2020-09-17 12:49:09', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_goods_comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_comment_reply`;
CREATE TABLE `mall_goods_comment_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '回复id',
  `user_id` bigint(20) NOT NULL COMMENT '回复用户ID',
  `comment_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '评论ID',
  `content` varchar(1024) NOT NULL DEFAULT '' COMMENT '回复内容',
  `parent_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '回复评论ID',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of mall_goods_comment_reply
-- ----------------------------
BEGIN;
INSERT INTO `mall_goods_comment_reply` VALUES (1, 2, 1, '别跟我说苹果贵，我的6s，16年用到现在才换，买的时候4200，安卓用不起，更换太快。现在我买的se，3200，再战五年。预算不足的去看看se吧，跟6s一样大', 0, '2020-09-14 15:58:04', NULL, 0);
INSERT INTO `mall_goods_comment_reply` VALUES (2, 1, 1, 'se好评', 1, '2020-09-16 22:20:11', NULL, 0);
INSERT INTO `mall_goods_comment_reply` VALUES (3, 1, 2, '信号怎么样', 0, '2020-09-17 12:46:03', NULL, 0);
INSERT INTO `mall_goods_comment_reply` VALUES (4, 2, 2, '还可以', 3, '2020-09-17 15:31:04', NULL, 0);
INSERT INTO `mall_goods_comment_reply` VALUES (5, 2, 1, '黑色好看', 0, '2020-09-17 16:15:56', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_goods_sku
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_sku`;
CREATE TABLE `mall_goods_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品sku_id',
  `goods_id` bigint(20) DEFAULT '0' COMMENT '商品spu_id',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '单品价格',
  `sales` int(11) NOT NULL DEFAULT '0' COMMENT '单品销量',
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT '单品库存',
  `stock_warning_count` int(11) DEFAULT '10' COMMENT '单品库存阈值',
  `img` varchar(128) NOT NULL DEFAULT '' COMMENT '单品图片地址',
  `spec_sn` varchar(32) NOT NULL DEFAULT '' COMMENT '商品规格信息编码 例 $1#1-1&2-2&3-3',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  KEY `idx_spec_sn` (`spec_sn`) USING BTREE,
  KEY `idx_goods_id` (`goods_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COMMENT='商品sku信息表';

-- ----------------------------
-- Records of mall_goods_sku
-- ----------------------------
BEGIN;
INSERT INTO `mall_goods_sku` VALUES (1, 1, 5499.00, 200, 100, 10, 'http://img.alicdn.com/imgextra/i3/1917047079/O1CN01pC06ke22AEJ8IgFIr_!!2-item_pic.png_430x430q90.jpg', '1#1-1&2-7', '2020-08-15 22:23:06', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (2, 1, 5499.00, 30, 100, 10, 'http://img.alicdn.com/imgextra/i1/1917047079/O1CN01aeFudA22AEJ9sojJP_!!2-item_pic.png_430x430q90.jpg', '1#1-2&2-7', '2020-08-15 22:31:04', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (3, 1, 5499.00, 55, 100, 10, 'http://img.alicdn.com/imgextra/i3/1917047079/O1CN01uqE1Gm22AEJ9snzam_!!2-item_pic.png_430x430q90.jpg', '1#1-3&2-7', '2020-08-15 22:36:10', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (4, 1, 5499.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i3/1917047079/O1CN019UAAq022AEJ9AY42h_!!2-item_pic.png_430x430q90.jpg', '1#1-4&2-7', '2020-08-15 22:37:13', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (5, 1, 5499.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i2/1917047079/O1CN01PP4wv322AEJ9gGIkc_!!2-item_pic.png_430x430q90.jpg', '1#1-5&2-7', '2020-08-15 22:38:43', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (6, 1, 5499.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i2/1917047079/O1CN01KyppMw22AEJAcsczH_!!2-item_pic.png_430x430q90.jpg', '1#1-6&2-7', '2020-08-15 22:39:56', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (7, 1, 5999.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i3/1917047079/O1CN01pC06ke22AEJ8IgFIr_!!2-item_pic.png_430x430q90.jpg', '1#1-1&2-8', '2020-08-15 22:40:46', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (8, 1, 5999.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i1/1917047079/O1CN01aeFudA22AEJ9sojJP_!!2-item_pic.png_430x430q90.jpg', '1#1-2&2-8', '2020-08-15 22:42:24', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (9, 1, 5999.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i3/1917047079/O1CN01uqE1Gm22AEJ9snzam_!!2-item_pic.png_430x430q90.jpg', '1#1-3&2-8', '2020-08-15 22:42:51', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (10, 1, 5999.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i3/1917047079/O1CN019UAAq022AEJ9AY42h_!!2-item_pic.png_430x430q90.jpg', '1#1-4&2-8', '2020-08-15 22:43:37', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (11, 1, 5999.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i2/1917047079/O1CN01PP4wv322AEJ9gGIkc_!!2-item_pic.png_430x430q90.jpg', '1#1-5&2-8', '2020-08-15 22:44:04', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (12, 1, 5999.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i2/1917047079/O1CN01KyppMw22AEJAcsczH_!!2-item_pic.png_430x430q90.jpg', '1#1-6&2-8', '2020-08-15 22:44:29', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (13, 1, 6799.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i3/1917047079/O1CN01pC06ke22AEJ8IgFIr_!!2-item_pic.png_430x430q90.jpg', '1#1-1&2-9', '2020-08-15 22:45:16', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (14, 1, 6799.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i1/1917047079/O1CN01aeFudA22AEJ9sojJP_!!2-item_pic.png_430x430q90.jpg', '1#1-2&2-9', '2020-08-15 22:45:48', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (15, 1, 6799.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i3/1917047079/O1CN01uqE1Gm22AEJ9snzam_!!2-item_pic.png_430x430q90.jpg', '1#1-3&2-9', '2020-08-15 22:46:28', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (16, 1, 6799.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i3/1917047079/O1CN019UAAq022AEJ9AY42h_!!2-item_pic.png_430x430q90.jpg', '1#1-4&2-9', '2020-08-15 22:46:54', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (17, 1, 6799.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i2/1917047079/O1CN01PP4wv322AEJ9gGIkc_!!2-item_pic.png_430x430q90.jpg', '1#1-5&2-9', '2020-08-15 22:47:28', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (18, 1, 6799.00, 0, 100, 10, 'http://img.alicdn.com/imgextra/i2/1917047079/O1CN01KyppMw22AEJAcsczH_!!2-item_pic.png_430x430q90.jpg', '1#1-6&2-9', '2020-08-15 22:48:15', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (19, 2, 4999.00, 0, 0, 10, 'http://img.alicdn.com/imgextra/i4/1714128138/O1CN01wDQrvE29zFlcectOZ_!!1714128138.png_430x430q90.jpg', '2#3-10&4-12', '2020-08-21 16:17:23', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (20, 2, 4999.00, 0, 0, 10, 'http://img.alicdn.com/imgextra/i2/1714128138/O1CN01aPwAyj29zFleZNOAi_!!1714128138.png_430x430q90.jpg', '2#3-11&4-12', '2020-08-21 16:17:27', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (21, 2, 5999.00, 0, 0, 10, 'http://img.alicdn.com/imgextra/i4/1714128138/O1CN01wDQrvE29zFlcectOZ_!!1714128138.png_430x430q90.jpg', '2#3-10&4-13', '2020-08-21 16:18:12', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (22, 2, 5999.00, 0, 0, 10, 'http://img.alicdn.com/imgextra/i2/1714128138/O1CN01aPwAyj29zFleZNOAi_!!1714128138.png_430x430q90.jpg', '2#3-11&4-13', '2020-08-21 16:18:44', NULL, 0);
INSERT INTO `mall_goods_sku` VALUES (23, 18, 79.00, 0, 100, 5, 'http://qg6txnoqg.hb-bkt.clouddn.com/product/img/17eb6202-8cc0-442a-866f-2656686b8670.jpg', '18#16-30&17-31', '2020-09-11 23:23:00', '2020-09-14 10:18:27', 1);
INSERT INTO `mall_goods_sku` VALUES (24, 19, 584.00, 0, 20, 10, 'http://qg6txnoqg.hb-bkt.clouddn.com/product/img/9b8c010a-b08f-487e-a3c2-df7a5d66c35b.jpg', '19#18-34&19-40', '2020-09-12 19:56:05', NULL, 1);
INSERT INTO `mall_goods_sku` VALUES (25, 18, 79.00, 0, 50, 10, 'http://qg6txnoqg.hb-bkt.clouddn.com/product/img/c14b76f5-d7fd-499f-b1a3-ff97e5000b97.jpg', '18#16-30&17-32', '2020-09-12 19:59:44', NULL, 1);
INSERT INTO `mall_goods_sku` VALUES (28, 19, 584.00, 0, 20, 5, 'http://qg6txnoqg.hb-bkt.clouddn.com/product/img/d479951e-2377-4c30-8cb2-2d6f01c204e0.jpg', '19#18-39&19-40', '2020-09-12 22:37:42', NULL, 1);
INSERT INTO `mall_goods_sku` VALUES (29, 18, 79.00, 0, 20, 5, 'http://qg6txnoqg.hb-bkt.clouddn.com/product/img/082013f1-20a0-44fa-9325-d67195e254ac.jpg', '18#16-30&17-33', '2020-09-12 22:42:21', NULL, 1);
INSERT INTO `mall_goods_sku` VALUES (31, 18, 79.00, 0, 50, 10, 'http://qg6txnoqg.hb-bkt.clouddn.com/product/img/f5a2aad2-b87e-49e9-a101-a4f5d081a7bf.jpg', '18#16-30&17-31', '2020-09-14 13:30:31', NULL, 1);
INSERT INTO `mall_goods_sku` VALUES (32, 19, 649.00, 0, 100, 10, 'http://qg6txnoqg.hb-bkt.clouddn.com/product/img/a792c305-eb46-4fbf-8718-686130f65764.jpg', '19#18-34&19-40', '2020-09-14 15:42:51', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_goods_spec
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_spec`;
CREATE TABLE `mall_goods_spec` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品规格id',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '规格名',
  `sort` int(1) NOT NULL DEFAULT '0',
  `goods_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品spu_id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COMMENT='商品规格名表';

-- ----------------------------
-- Records of mall_goods_spec
-- ----------------------------
BEGIN;
INSERT INTO `mall_goods_spec` VALUES (1, '机身颜色', 0, 1, '2020-08-15 22:25:20', '2020-09-10 23:13:27', 0);
INSERT INTO `mall_goods_spec` VALUES (2, '储存容量', 1, 1, '2020-08-15 22:25:43', '2020-09-10 23:13:27', 0);
INSERT INTO `mall_goods_spec` VALUES (3, '机身颜色', 0, 2, '2020-08-21 16:10:02', '2020-09-02 11:29:54', 0);
INSERT INTO `mall_goods_spec` VALUES (4, '储存容量', 1, 2, '2020-08-21 16:10:28', '2020-09-02 11:29:54', 0);
INSERT INTO `mall_goods_spec` VALUES (6, '颜色', 1, 5, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_goods_spec` VALUES (7, '容量', 2, 5, '2020-08-27 15:27:50', NULL, 1);
INSERT INTO `mall_goods_spec` VALUES (8, '尺寸', 1, 6, '2020-08-27 16:50:50', '2020-09-02 11:29:36', 1);
INSERT INTO `mall_goods_spec` VALUES (9, '内存容量', 2, 6, '2020-08-27 16:50:50', '2020-09-02 11:29:36', 1);
INSERT INTO `mall_goods_spec` VALUES (14, '颜色', 1, 8, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_goods_spec` VALUES (15, '尺码', 2, 8, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_goods_spec` VALUES (16, '颜色', 1, 18, '2020-09-06 23:04:58', '2020-09-08 21:52:31', 1);
INSERT INTO `mall_goods_spec` VALUES (17, '尺寸', 2, 18, '2020-09-06 23:04:58', '2020-09-08 21:52:31', 1);
INSERT INTO `mall_goods_spec` VALUES (18, '尺码', 1, 19, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_goods_spec` VALUES (19, '颜色', 2, 19, '2020-09-08 22:53:49', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_goods_spec_value
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_spec_value`;
CREATE TABLE `mall_goods_spec_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '规格值id',
  `spec_value` varchar(255) NOT NULL DEFAULT '' COMMENT '规格值',
  `spec_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '规格id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COMMENT='商品规格值表';

-- ----------------------------
-- Records of mall_goods_spec_value
-- ----------------------------
BEGIN;
INSERT INTO `mall_goods_spec_value` VALUES (1, '白色', 1, '2020-08-15 22:26:31', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (2, '黑色', 1, '2020-08-15 22:26:52', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (3, '绿色', 1, '2020-08-15 22:27:01', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (4, '黄色', 1, '2020-08-15 22:27:15', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (5, '紫色', 1, '2020-08-15 22:27:26', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (6, '红色', 1, '2020-08-15 22:27:34', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (7, '64GB', 2, '2020-08-15 22:28:13', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (8, '128GB', 2, '2020-08-15 22:28:25', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (9, '256GB', 2, '2020-08-15 22:28:45', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (10, '珍珠白', 3, '2020-08-21 16:10:54', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (11, '星空蓝', 3, '2020-08-21 16:11:06', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (12, '8+256GB', 4, '2020-08-21 16:12:13', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (13, '12+512GB', 4, '2020-08-21 16:12:47', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (18, '黑色', 14, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (19, '杏色', 14, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (20, '蓝色', 14, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (21, '紫色', 14, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (22, 'S', 15, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (23, 'M', 15, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (24, 'L', 15, '2020-09-05 23:15:01', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (25, '灰色', 16, '2020-09-06 23:04:58', '2020-09-08 21:47:11', 1);
INSERT INTO `mall_goods_spec_value` VALUES (26, 'M', 17, '2020-09-06 23:04:58', '2020-09-08 21:47:11', 1);
INSERT INTO `mall_goods_spec_value` VALUES (27, 'L', 17, '2020-09-06 23:04:58', '2020-09-08 21:47:11', 1);
INSERT INTO `mall_goods_spec_value` VALUES (28, 'XL', 17, '2020-09-06 23:04:58', '2020-09-08 21:47:11', 1);
INSERT INTO `mall_goods_spec_value` VALUES (29, '黑色', 16, '2020-09-08 21:40:34', NULL, 1);
INSERT INTO `mall_goods_spec_value` VALUES (30, '灰色', 16, '2020-09-08 21:52:08', '2020-09-08 21:52:31', 0);
INSERT INTO `mall_goods_spec_value` VALUES (31, 'M', 17, '2020-09-08 21:52:08', '2020-09-08 21:52:31', 0);
INSERT INTO `mall_goods_spec_value` VALUES (32, 'L', 17, '2020-09-08 21:52:08', '2020-09-08 21:52:31', 0);
INSERT INTO `mall_goods_spec_value` VALUES (33, 'XL', 17, '2020-09-08 21:52:08', '2020-09-08 21:52:31', 0);
INSERT INTO `mall_goods_spec_value` VALUES (34, '36', 18, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (35, '36.5', 18, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (36, '37.5', 18, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (37, '38', 18, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (38, '38.5', 18, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (39, '39', 18, '2020-09-08 22:53:49', NULL, 0);
INSERT INTO `mall_goods_spec_value` VALUES (40, '红色', 19, '2020-09-08 22:53:49', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_goods_spu
-- ----------------------------
DROP TABLE IF EXISTS `mall_goods_spu`;
CREATE TABLE `mall_goods_spu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '商品sku_id',
  `goods_sn` varchar(20) NOT NULL DEFAULT '0' COMMENT '商品编号',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '商品名称',
  `title` varchar(255) NOT NULL DEFAULT '' COMMENT '商品显示标题',
  `category_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '分类id',
  `brand_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '品牌id',
  `weight` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品重量(单位kg)',
  `brief` text NOT NULL COMMENT '商品简要',
  `title_img` varchar(255) NOT NULL DEFAULT '' COMMENT '标题图片',
  `gallery` varchar(1024) NOT NULL DEFAULT '' COMMENT '商品轮播图片列表',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '商品状态0-未上架 1-已上架',
  `sales` int(20) NOT NULL DEFAULT '0' COMMENT '商品销量',
  `hot` int(1) NOT NULL DEFAULT '0' COMMENT '是否热卖 0-否 1-是',
  `sort` int(1) NOT NULL DEFAULT '0' COMMENT '排序',
  `is_new` int(1) NOT NULL DEFAULT '1' COMMENT '是否新品 0-否 1-是',
  `unit` varchar(32) NOT NULL DEFAULT '' COMMENT '商品单位',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品零售价格',
  `discount_price` decimal(10,2) DEFAULT NULL COMMENT '商品折扣价格',
  `attr_group_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '参数分组id',
  `detail` text COMMENT '商品详情',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_goods_sn` (`goods_sn`) USING BTREE,
  KEY `idx_goods_name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COMMENT='商品spu信息表';

-- ----------------------------
-- Records of mall_goods_spu
-- ----------------------------
BEGIN;
INSERT INTO `mall_goods_spu` VALUES (1, '100001001', 'Apple/苹果 iPhone 11 (A2223)', 'Apple/苹果 iPhone 11 (A2223)', 92, 1, 0.47, 'Apple iPhone 11 (A2223) 移动联通电信4G手机 双卡双待', 'https://img12.360buyimg.com/n7/jfs/t1/59022/28/10293/141808/5d78088fEf6e7862d/68836f52ffaaad96.jpg', 'https://img.alicdn.com/imgextra/i3/1917047079/O1CN01GsuSCS22AELzADNIw_!!2-item_pic.png_430x430q90.jpg,https://img.alicdn.com/imgextra/i4/1917047079/O1CN01lbZLx722AELyYpDUR_!!1917047079.png_430x430q90.jpg,https://img.alicdn.com/imgextra/i2/1917047079/O1CN01tf2B5s22AEJ9gGpzX_!!2-item_pic.png_430x430q90.jpg', 1, 0, 1, 1, 1, '件', 5499.00, 5499.00, 10, '<p><img src=\"https://img11.360buyimg.com/cms/jfs/t1/43665/32/14756/2824061/5d77f8b8E3e335a82/af0a3a0ac16b6bb2.png\" style=\"max-width:100%;\"><br></p>', '2020-08-15 23:02:37', '2020-09-02 15:07:07', 0);
INSERT INTO `mall_goods_spu` VALUES (2, '100001002', 'Xiaomi/小米 小米10 Pro', 'Xiaomi/小米 小米10 Pro', 92, 2, 0.00, '小米10pro5g手机骁龙865处理器5G手机拍照', 'http://img.alicdn.com/bao/uploaded/i5/TB1slQyvxD1gK0jSZFKBnQJrVXa_103934.jpg', 'https://img.alicdn.com/imgextra/i4/1714128138/O1CN01nLUWQj29zFlj5d9gi_!!1714128138.jpg_430x430q90.jpg,https://img.alicdn.com/imgextra/i1/1714128138/O1CN01JcPGID29zFlbQWwxo_!!1714128138.jpg_430x430q90.jpg,https://img.alicdn.com/imgextra/i3/1714128138/O1CN01RP2I1a29zFlgV4Jbh_!!1714128138.jpg_430x430q90.jpg', 1, 0, 1, 1, 1, '件', 4999.00, 4999.00, 10, '<p><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/121/1a433222-b63b-4c2a-88aa-ae0ff68bf9e1.jpg!85.webp\" style=\"max-width:100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/115/895d88b7-9180-460f-a62e-ec44ef4ba621.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/53/bf27da9a-b55c-461b-bc88-9545ce2150d6.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/139/9b451753-8c06-4004-8448-7224f194d441.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/153/8f7e35ff-b0a7-40c8-b160-5f4b5b42066d.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/195/e600f2a2-8fb9-41fe-81c9-c59dcc2bfc92.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/22/cdcf9a20-f10b-4a2d-ad1b-4e2770ec7a50.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/22/cdcf9a20-f10b-4a2d-ad1b-4e2770ec7a50.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/30/3a40ba78-a946-4b79-9bb3-ef2a42a69da2.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/30/3a40ba78-a946-4b79-9bb3-ef2a42a69da2.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/89/0deaad79-131a-4e4a-acd9-0d99a34e5ad1.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/16/2ead51dd-d468-434e-a34a-3df6e95edb35.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/101/805bd747-fb4a-44a1-bc70-cc889d634bc2.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/55/e6ab2115-5832-4f7d-aa18-5514502a1343.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/32/99c3cbd6-e155-4efd-be2d-5e793965c1e9.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/59/436db4a0-2635-4a24-9cf6-9e3297c072fc.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/603466/2020/0213/89/4d238570-b719-4bbc-9a92-88bd89fc27d1.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><br></p>', '2020-08-21 16:02:32', '2020-09-02 15:52:49', 0);
INSERT INTO `mall_goods_spu` VALUES (5, '100001003', 'HUAWEI nova 6 全网通5G手机', ' 华为 | HUAWEI nova 6 全网通5G手机   ', 92, 4, 0.00, ' 华为 | HUAWEI nova 6 全网通5G手机  ', 'http://qemdt7zgj.bkt.clouddn.com/product/img/34f82b5c-5e08-4b78-bc6c-261765ce3eeb.jpg', 'http://qemdt7zgj.bkt.clouddn.com/product/gallery/ae9739c6-b0f0-4b33-845a-2066d51e15fb.jpg,http://qemdt7zgj.bkt.clouddn.com/product/gallery/81bba06c-f92d-474f-8809-75940c8619d8.jpg', 0, 0, 0, 3, 1, '件', 2899.00, 2899.00, 10, '<p><img src=\"http://yanxuan.nosdn.127.net/2597f9e2e41093f50761837eb4c2e6be.jpg\" _src=\"http://yanxuan.nosdn.127.net/2597f9e2e41093f50761837eb4c2e6be.jpg\" style=\"\"><img src=\"http://yanxuan.nosdn.127.net/4377adc892bf9d16f9d0fd78f88a6986.jpg\" _src=\"http://yanxuan.nosdn.127.net/4377adc892bf9d16f9d0fd78f88a6986.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/986bd3a7517a356265049443cbb747d9.jpg\" _src=\"http://yanxuan.nosdn.127.net/986bd3a7517a356265049443cbb747d9.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/5cdf3958b3a8d9982b879e3fea1fd616.jpg\" _src=\"http://yanxuan.nosdn.127.net/5cdf3958b3a8d9982b879e3fea1fd616.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/47e5be34ef476258f44f307982c705d4.jpg\" _src=\"http://yanxuan.nosdn.127.net/47e5be34ef476258f44f307982c705d4.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/a2220e4cbb5ebc49e9cecb64176983d9.jpg\" _src=\"http://yanxuan.nosdn.127.net/a2220e4cbb5ebc49e9cecb64176983d9.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/dee62e466465b370c349e37fccd3b596.jpg\" _src=\"http://yanxuan.nosdn.127.net/dee62e466465b370c349e37fccd3b596.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/c021b91f965ac022182eb03b2780e5de.jpg\" _src=\"http://yanxuan.nosdn.127.net/c021b91f965ac022182eb03b2780e5de.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/b9f7afd9441928d7f670fd7879ba869d.jpg\" _src=\"http://yanxuan.nosdn.127.net/b9f7afd9441928d7f670fd7879ba869d.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/8a73b69a2fefbd154a2a6ad45102b565.jpg\" _src=\"http://yanxuan.nosdn.127.net/8a73b69a2fefbd154a2a6ad45102b565.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/5836d918faa9b11eb8d9f97f9787cda9.jpg\" _src=\"http://yanxuan.nosdn.127.net/5836d918faa9b11eb8d9f97f9787cda9.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/8216a8addae2f02a5a570ef45d5ecffc.jpg\" _src=\"http://yanxuan.nosdn.127.net/8216a8addae2f02a5a570ef45d5ecffc.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/da382973dcb0e524a36519baab880204.jpg\" _src=\"http://yanxuan.nosdn.127.net/da382973dcb0e524a36519baab880204.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/f1c6e84d49f74e228bc57934ec7b7500.jpg\" _src=\"http://yanxuan.nosdn.127.net/f1c6e84d49f74e228bc57934ec7b7500.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/2f1d0a20e54d3e2e59a44ffe44ebe405.jpg\" _src=\"http://yanxuan.nosdn.127.net/2f1d0a20e54d3e2e59a44ffe44ebe405.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/a39f2c7580ce5cadc62e8b39d58aca71.jpg\" _src=\"http://yanxuan.nosdn.127.net/a39f2c7580ce5cadc62e8b39d58aca71.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/c71dc416f04615b634d2b6cd0c4215ee.jpg\" _src=\"http://yanxuan.nosdn.127.net/c71dc416f04615b634d2b6cd0c4215ee.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/06ac26ed7d870c5c6f0ce3e07c629471.jpg\" _src=\"http://yanxuan.nosdn.127.net/06ac26ed7d870c5c6f0ce3e07c629471.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/99b180d02726e0213e54dddf4b9b32fd.jpg\" _src=\"http://yanxuan.nosdn.127.net/99b180d02726e0213e54dddf4b9b32fd.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/97de8d2687052976e51fff40d04af2ce.jpg\" _src=\"http://yanxuan.nosdn.127.net/97de8d2687052976e51fff40d04af2ce.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/3f527003599be237095995c98039ef87.jpg\" _src=\"http://yanxuan.nosdn.127.net/3f527003599be237095995c98039ef87.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/ec30289dc1b2beb4b84a08c02a97ef6e.jpg\" _src=\"http://yanxuan.nosdn.127.net/ec30289dc1b2beb4b84a08c02a97ef6e.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/685da1eaddcd26e8e2a1ff4d5d83f29f.jpg\" _src=\"http://yanxuan.nosdn.127.net/685da1eaddcd26e8e2a1ff4d5d83f29f.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/2610f487a733a88973d101dcd1766ee1.jpg\" _src=\"http://yanxuan.nosdn.127.net/2610f487a733a88973d101dcd1766ee1.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/eab3633e648ab2e8412c6801feb6231e.jpg\" _src=\"http://yanxuan.nosdn.127.net/eab3633e648ab2e8412c6801feb6231e.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/7b6c4f220592ea7d5af0072a816fe946.jpg\" _src=\"http://yanxuan.nosdn.127.net/7b6c4f220592ea7d5af0072a816fe946.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/310a777685204ece08592a6e2716c6c9.jpg\" _src=\"http://yanxuan.nosdn.127.net/310a777685204ece08592a6e2716c6c9.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/198239985c74597717e639089ffae25f.jpg\" _src=\"http://yanxuan.nosdn.127.net/198239985c74597717e639089ffae25f.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"></p><p><img src=\"http://yanxuan.nosdn.127.net/dec6b498c899351fe94d99a6dde0ee79.jpg\" _src=\"http://yanxuan.nosdn.127.net/dec6b498c899351fe94d99a6dde0ee79.jpg\" style=\"\"></p><p><img src=\"http://yanxuan.nosdn.127.net/516a17ca73846bc871902b298ce38a97.jpg\" _src=\"http://yanxuan.nosdn.127.net/516a17ca73846bc871902b298ce38a97.jpg\" style=\"\"></p><p><img src=\"http://yanxuan.nosdn.127.net/d8231b81b5ba0e1c244074598c19f003.jpg\" _src=\"http://yanxuan.nosdn.127.net/d8231b81b5ba0e1c244074598c19f003.jpg\" style=\"\"></p><p><img src=\"http://yanxuan.nosdn.127.net/92c704dcf169e9a177a3c762a6a54a46.jpg\" _src=\"http://yanxuan.nosdn.127.net/92c704dcf169e9a177a3c762a6a54a46.jpg\" style=\"\"><img src=\"http://yanxuan.nosdn.127.net/5b9294ad5f78d890453d4a225feed518.jpg\" _src=\"http://yanxuan.nosdn.127.net/5b9294ad5f78d890453d4a225feed518.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/9bb1b8fdfaa7f895bdd7d5c65c42a59b.jpg\" _src=\"http://yanxuan.nosdn.127.net/9bb1b8fdfaa7f895bdd7d5c65c42a59b.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/f342e6d6b75dc1f80972feb415fd4e75.jpg\" _src=\"http://yanxuan.nosdn.127.net/f342e6d6b75dc1f80972feb415fd4e75.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/6c9597cf206066861b3244f634c98e32.jpg\" _src=\"http://yanxuan.nosdn.127.net/6c9597cf206066861b3244f634c98e32.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/970d4dad7d958293fd41ec1f444684f1.jpg\" _src=\"http://yanxuan.nosdn.127.net/970d4dad7d958293fd41ec1f444684f1.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/6f93819b03de07abef8b2d94f1d5c84b.jpg\" _src=\"http://yanxuan.nosdn.127.net/6f93819b03de07abef8b2d94f1d5c84b.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/58c8c56aac61da4ee9fcf34930b76e4e.jpg\" _src=\"http://yanxuan.nosdn.127.net/58c8c56aac61da4ee9fcf34930b76e4e.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/fb6435ec714189d6ad5053bf12d41db7.jpg\" _src=\"http://yanxuan.nosdn.127.net/fb6435ec714189d6ad5053bf12d41db7.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/19cc85ae097247d5d868df993de64e7b.jpg\" _src=\"http://yanxuan.nosdn.127.net/19cc85ae097247d5d868df993de64e7b.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/0ab8e27757cabd39fccdb5fd8ef7b013.jpg\" _src=\"http://yanxuan.nosdn.127.net/0ab8e27757cabd39fccdb5fd8ef7b013.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"></p><p><img src=\"http://yanxuan.nosdn.127.net/03e6f02f8f77b71a82a05dd1a9705057.jpg\" _src=\"http://yanxuan.nosdn.127.net/03e6f02f8f77b71a82a05dd1a9705057.jpg\" style=\"\"></p><p><br></p>', '2020-08-27 15:27:50', '2020-09-08 23:02:11', 1);
INSERT INTO `mall_goods_spu` VALUES (6, '100001101', '灵越5000 10代i3 轻薄笔记本', '灵越5000 10代i3 轻薄笔记本', 94, 6, 0.00, '灵越5000 10代i3 轻薄笔记本', 'http://qemdt7zgj.bkt.clouddn.com/product/img/d85ecd06-e9cd-4618-ad6c-ed5fcad21b69.jpg', 'http://qemdt7zgj.bkt.clouddn.com/product/gallery/0e99fdae-a84b-42dc-88dd-17cdc01c5d1f.jpg', 0, 0, 0, 4, 1, '台', 5399.00, 3269.00, 11, '<p><img src=\"http://yanxuan.nosdn.127.net/2597f9e2e41093f50761837eb4c2e6be.jpg\" _src=\"http://yanxuan.nosdn.127.net/2597f9e2e41093f50761837eb4c2e6be.jpg\" style=\"\"><img src=\"http://yanxuan.nosdn.127.net/4377adc892bf9d16f9d0fd78f88a6986.jpg\" _src=\"http://yanxuan.nosdn.127.net/4377adc892bf9d16f9d0fd78f88a6986.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/986bd3a7517a356265049443cbb747d9.jpg\" _src=\"http://yanxuan.nosdn.127.net/986bd3a7517a356265049443cbb747d9.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/5cdf3958b3a8d9982b879e3fea1fd616.jpg\" _src=\"http://yanxuan.nosdn.127.net/5cdf3958b3a8d9982b879e3fea1fd616.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/47e5be34ef476258f44f307982c705d4.jpg\" _src=\"http://yanxuan.nosdn.127.net/47e5be34ef476258f44f307982c705d4.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/a2220e4cbb5ebc49e9cecb64176983d9.jpg\" _src=\"http://yanxuan.nosdn.127.net/a2220e4cbb5ebc49e9cecb64176983d9.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/dee62e466465b370c349e37fccd3b596.jpg\" _src=\"http://yanxuan.nosdn.127.net/dee62e466465b370c349e37fccd3b596.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/c021b91f965ac022182eb03b2780e5de.jpg\" _src=\"http://yanxuan.nosdn.127.net/c021b91f965ac022182eb03b2780e5de.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/b9f7afd9441928d7f670fd7879ba869d.jpg\" _src=\"http://yanxuan.nosdn.127.net/b9f7afd9441928d7f670fd7879ba869d.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/8a73b69a2fefbd154a2a6ad45102b565.jpg\" _src=\"http://yanxuan.nosdn.127.net/8a73b69a2fefbd154a2a6ad45102b565.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/5836d918faa9b11eb8d9f97f9787cda9.jpg\" _src=\"http://yanxuan.nosdn.127.net/5836d918faa9b11eb8d9f97f9787cda9.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/8216a8addae2f02a5a570ef45d5ecffc.jpg\" _src=\"http://yanxuan.nosdn.127.net/8216a8addae2f02a5a570ef45d5ecffc.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/da382973dcb0e524a36519baab880204.jpg\" _src=\"http://yanxuan.nosdn.127.net/da382973dcb0e524a36519baab880204.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/f1c6e84d49f74e228bc57934ec7b7500.jpg\" _src=\"http://yanxuan.nosdn.127.net/f1c6e84d49f74e228bc57934ec7b7500.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/2f1d0a20e54d3e2e59a44ffe44ebe405.jpg\" _src=\"http://yanxuan.nosdn.127.net/2f1d0a20e54d3e2e59a44ffe44ebe405.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/a39f2c7580ce5cadc62e8b39d58aca71.jpg\" _src=\"http://yanxuan.nosdn.127.net/a39f2c7580ce5cadc62e8b39d58aca71.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/c71dc416f04615b634d2b6cd0c4215ee.jpg\" _src=\"http://yanxuan.nosdn.127.net/c71dc416f04615b634d2b6cd0c4215ee.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/06ac26ed7d870c5c6f0ce3e07c629471.jpg\" _src=\"http://yanxuan.nosdn.127.net/06ac26ed7d870c5c6f0ce3e07c629471.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/99b180d02726e0213e54dddf4b9b32fd.jpg\" _src=\"http://yanxuan.nosdn.127.net/99b180d02726e0213e54dddf4b9b32fd.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/97de8d2687052976e51fff40d04af2ce.jpg\" _src=\"http://yanxuan.nosdn.127.net/97de8d2687052976e51fff40d04af2ce.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/3f527003599be237095995c98039ef87.jpg\" _src=\"http://yanxuan.nosdn.127.net/3f527003599be237095995c98039ef87.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/ec30289dc1b2beb4b84a08c02a97ef6e.jpg\" _src=\"http://yanxuan.nosdn.127.net/ec30289dc1b2beb4b84a08c02a97ef6e.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/685da1eaddcd26e8e2a1ff4d5d83f29f.jpg\" _src=\"http://yanxuan.nosdn.127.net/685da1eaddcd26e8e2a1ff4d5d83f29f.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/2610f487a733a88973d101dcd1766ee1.jpg\" _src=\"http://yanxuan.nosdn.127.net/2610f487a733a88973d101dcd1766ee1.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/eab3633e648ab2e8412c6801feb6231e.jpg\" _src=\"http://yanxuan.nosdn.127.net/eab3633e648ab2e8412c6801feb6231e.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/7b6c4f220592ea7d5af0072a816fe946.jpg\" _src=\"http://yanxuan.nosdn.127.net/7b6c4f220592ea7d5af0072a816fe946.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/310a777685204ece08592a6e2716c6c9.jpg\" _src=\"http://yanxuan.nosdn.127.net/310a777685204ece08592a6e2716c6c9.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/198239985c74597717e639089ffae25f.jpg\" _src=\"http://yanxuan.nosdn.127.net/198239985c74597717e639089ffae25f.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"></p><p><img src=\"http://yanxuan.nosdn.127.net/dec6b498c899351fe94d99a6dde0ee79.jpg\" _src=\"http://yanxuan.nosdn.127.net/dec6b498c899351fe94d99a6dde0ee79.jpg\" style=\"\"></p><p><img src=\"http://yanxuan.nosdn.127.net/516a17ca73846bc871902b298ce38a97.jpg\" _src=\"http://yanxuan.nosdn.127.net/516a17ca73846bc871902b298ce38a97.jpg\" style=\"\"></p><p><img src=\"http://yanxuan.nosdn.127.net/d8231b81b5ba0e1c244074598c19f003.jpg\" _src=\"http://yanxuan.nosdn.127.net/d8231b81b5ba0e1c244074598c19f003.jpg\" style=\"\"></p><p><img src=\"http://yanxuan.nosdn.127.net/92c704dcf169e9a177a3c762a6a54a46.jpg\" _src=\"http://yanxuan.nosdn.127.net/92c704dcf169e9a177a3c762a6a54a46.jpg\" style=\"\"><img src=\"http://yanxuan.nosdn.127.net/5b9294ad5f78d890453d4a225feed518.jpg\" _src=\"http://yanxuan.nosdn.127.net/5b9294ad5f78d890453d4a225feed518.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/9bb1b8fdfaa7f895bdd7d5c65c42a59b.jpg\" _src=\"http://yanxuan.nosdn.127.net/9bb1b8fdfaa7f895bdd7d5c65c42a59b.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/f342e6d6b75dc1f80972feb415fd4e75.jpg\" _src=\"http://yanxuan.nosdn.127.net/f342e6d6b75dc1f80972feb415fd4e75.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/6c9597cf206066861b3244f634c98e32.jpg\" _src=\"http://yanxuan.nosdn.127.net/6c9597cf206066861b3244f634c98e32.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/970d4dad7d958293fd41ec1f444684f1.jpg\" _src=\"http://yanxuan.nosdn.127.net/970d4dad7d958293fd41ec1f444684f1.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/6f93819b03de07abef8b2d94f1d5c84b.jpg\" _src=\"http://yanxuan.nosdn.127.net/6f93819b03de07abef8b2d94f1d5c84b.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/58c8c56aac61da4ee9fcf34930b76e4e.jpg\" _src=\"http://yanxuan.nosdn.127.net/58c8c56aac61da4ee9fcf34930b76e4e.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/fb6435ec714189d6ad5053bf12d41db7.jpg\" _src=\"http://yanxuan.nosdn.127.net/fb6435ec714189d6ad5053bf12d41db7.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/19cc85ae097247d5d868df993de64e7b.jpg\" _src=\"http://yanxuan.nosdn.127.net/19cc85ae097247d5d868df993de64e7b.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"><img src=\"http://yanxuan.nosdn.127.net/0ab8e27757cabd39fccdb5fd8ef7b013.jpg\" _src=\"http://yanxuan.nosdn.127.net/0ab8e27757cabd39fccdb5fd8ef7b013.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;;\"></p><p><img src=\"http://yanxuan.nosdn.127.net/03e6f02f8f77b71a82a05dd1a9705057.jpg\" _src=\"http://yanxuan.nosdn.127.net/03e6f02f8f77b71a82a05dd1a9705057.jpg\" style=\"\"></p><p><br></p>', '2020-08-27 16:50:50', '2020-09-08 23:01:50', 1);
INSERT INTO `mall_goods_spu` VALUES (8, '100002001', '拉夏贝尔旗下女士夏季新款轻熟风气质职业收腰显瘦西装领连衣裙子', '拉夏贝尔旗下女士连衣裙子', 6, 7, 0.10, '拉夏贝尔旗下女士夏季新款轻熟风气质职业收腰显瘦西装领连衣裙子', 'http://qg6txnoqg.hb-bkt.clouddn.com/product/img/cd942d38-6ef2-4c24-b407-132d9f8bec55.jpg', 'http://qg6txnoqg.hb-bkt.clouddn.com/product/gallery/cd84170d-e61c-4e8c-91a6-716e09050af8.jpg,http://qg6txnoqg.hb-bkt.clouddn.com/product/gallery/4c336995-72a4-44f7-b5f3-005f8ed68e16.jpg,http://qg6txnoqg.hb-bkt.clouddn.com/product/gallery/6a2c6d9f-2f17-4b59-ad0a-005875696fa9.jpg', 0, 0, 0, 5, 1, '件', 859.00, 80.00, 1, '<p><img src=\"http://qg6txnoqg.hb-bkt.clouddn.com/product/img/6fad4765-2abd-415a-9c3b-149d427d590b.jpg\" style=\"max-width:100%;\"><img src=\"http://qg6txnoqg.hb-bkt.clouddn.com/product/img/e9529ef0-627c-4cee-90f8-e5aab70a6943.jpg\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><br></p>', '2020-09-05 23:15:01', '2020-09-07 22:08:49', 0);
INSERT INTO `mall_goods_spu` VALUES (18, '100002002', '学院风百褶裙', '学院风百褶裙', 7, 8, 0.10, '【学院风百褶裙】春夏韩版高腰半身裙短裙A字时尚百褶裙二十不惑', 'http://qg6txnoqg.hb-bkt.clouddn.com/product/img/aba2281e-945a-4ce5-a676-5aea49889511.jpg', 'http://qg6txnoqg.hb-bkt.clouddn.com/product/gallery/bf9d1930-1f40-4e7e-a6d6-a419649f5d86.jpg,http://qg6txnoqg.hb-bkt.clouddn.com/product/gallery/737d4618-d501-41b1-8c47-a33c07ac0208.jpg,http://qg6txnoqg.hb-bkt.clouddn.com/product/gallery/723ddce7-a355-40c2-9e9f-73b9583fa36a.jpg,http://qg6txnoqg.hb-bkt.clouddn.com/product/gallery/d1402f3a-d859-4646-85fb-30820f7ec19a.jpg,http://qg6txnoqg.hb-bkt.clouddn.com/product/gallery/c97e9c20-1496-4d69-9eb5-24d045d4b07e.jpg', 0, 0, 0, 6, 1, '件', 269.00, 79.00, 9, '<p><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/614641/2020/0814/186/565b00a0-138a-48a6-ad2f-be08246eb829.jpg!85.webp\" style=\"max-width:100%;\"><br></p>', '2020-09-06 23:04:57', '2020-09-20 14:48:42', 1);
INSERT INTO `mall_goods_spu` VALUES (19, '100003001', '2020秋季新款BLAZER LOW时尚潮流舒适运动休闲鞋', '2020秋季新款BLAZER LOW时尚潮流舒适运动休闲鞋', 62, 9, 1.00, '2020秋季新款BLAZER LOW时尚潮流舒适运动休闲鞋', 'http://qg6txnoqg.hb-bkt.clouddn.com/product/img/c53ee1be-bd3f-41f0-95b2-609474758314.jpg', 'http://qg6txnoqg.hb-bkt.clouddn.com/product/gallery/20e3a312-aab4-4a10-8433-2811b79d8f6d.jpg,http://qg6txnoqg.hb-bkt.clouddn.com/product/gallery/28e8c969-c691-46cd-9b1d-c1ee77bb9b9d.jpg', 1, 0, 0, 7, 1, '双', 649.00, 584.00, 12, '<p><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/2020/09/08/148/e877b514-eccf-4fe8-87af-4b92bfdc7c2d.jpg!85.webp\" style=\"max-width:100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/2020/09/08/97/e2e08480-92e9-40f5-bb5f-4c7c92ced688.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><img src=\"https://h2a.appsimg.com/a.appsimg.com/upload/merchandise/pdcvis/2020/09/08/171/f0e25d54-5eea-4ba6-bfcf-361c684d1a45.jpg!85.webp\" style=\"font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;Helvetica Neue&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;, &quot;Segoe UI Symbol&quot;; max-width: 100%;\"><br></p>', '2020-09-08 22:53:49', '2020-09-14 15:42:51', 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_order
-- ----------------------------
DROP TABLE IF EXISTS `mall_order`;
CREATE TABLE `mall_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_sn` varchar(64) NOT NULL DEFAULT '' COMMENT '订单编号',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '订单状态',
  `aftersale_status` int(1) NOT NULL DEFAULT '0' COMMENT '售后状态，0是可申请，1是用户已申请，2是管理员审核通过，3是管理员退款成功，4是管理员审核拒绝，5是用户已取消',
  `receiver` varchar(32) NOT NULL DEFAULT '' COMMENT '收货人',
  `mobile` varchar(32) NOT NULL DEFAULT '' COMMENT '收货人电话',
  `address` varchar(127) NOT NULL DEFAULT '' COMMENT '收货地址',
  `message` varchar(127) NOT NULL DEFAULT '' COMMENT '留言',
  `freight_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品运费',
  `goods_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品价格',
  `coupon_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠券减免',
  `actual_payment` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '实付款',
  `order_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品总价',
  `pay_type` int(11) NOT NULL DEFAULT '0' COMMENT '支付方式1-微信支付;2-支付宝支付',
  `pay_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '支付id',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `ship_sn` varchar(64) DEFAULT NULL COMMENT '发货编号',
  `ship_channel` varchar(32) DEFAULT NULL COMMENT '快递公司',
  `ship_time` datetime DEFAULT NULL COMMENT '发货时间',
  `refund_amount` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
  `refund_type` varchar(32) DEFAULT NULL COMMENT '退款方式',
  `refund_message` varchar(64) DEFAULT NULL COMMENT '退款备注',
  `refund_time` datetime DEFAULT NULL COMMENT '退款时间',
  `confirm_time` datetime DEFAULT NULL COMMENT '用户确认收货时间',
  `comments` int(11) DEFAULT NULL COMMENT '待评价商品数量',
  `end_time` datetime DEFAULT NULL COMMENT '订单关闭时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最近修改时间',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_sn` (`order_sn`) USING BTREE,
  KEY `idx_create_time` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='商品订单表';

-- ----------------------------
-- Records of mall_order
-- ----------------------------
BEGIN;
INSERT INTO `mall_order` VALUES (1, '20020918100100', 1, 0, 0, '李岩', '15939502821', '漯河市人民路与解放路交叉口', '', 0.00, 5499.00, 200.00, 5299.00, 5499.00, 0, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-09-18 23:01:18', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mall_order_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_order_goods`;
CREATE TABLE `mall_order_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单商品id',
  `order_id` bigint(20) DEFAULT '0' COMMENT '订单id',
  `goods_sn` varchar(64) DEFAULT '' COMMENT '商品编号',
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名',
  `number` int(11) DEFAULT NULL COMMENT '购买数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品售价',
  `goods_spec_sn` varchar(64) DEFAULT NULL COMMENT '商品规格码',
  `goods_img` varchar(64) DEFAULT NULL COMMENT '商品图片',
  `comment` int(11) DEFAULT NULL COMMENT '订单商品评论，如果是-1，则超期不能评价；如果是0，则可以评价；如果其他值，则是comment表里面的评论ID。',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最近修改时间',
  `deleted` int(1) DEFAULT NULL COMMENT '逻辑删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='订单商品表';

-- ----------------------------
-- Records of mall_order_goods
-- ----------------------------
BEGIN;
INSERT INTO `mall_order_goods` VALUES (1, NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for mall_topic
-- ----------------------------
DROP TABLE IF EXISTS `mall_topic`;
CREATE TABLE `mall_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '专题id',
  `title` varchar(255) NOT NULL DEFAULT '0' COMMENT '标题',
  `subtitle` varchar(255) NOT NULL DEFAULT '' COMMENT '子标题',
  `content` text COMMENT '正文',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '专题商品最低价',
  `read_count` int(11) DEFAULT '0' COMMENT '阅读量',
  `img` varchar(255) DEFAULT '' COMMENT '专题图片',
  `sort` int(1) DEFAULT '0' COMMENT '排序',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='专题表';

-- ----------------------------
-- Table structure for mall_topic_goods
-- ----------------------------
DROP TABLE IF EXISTS `mall_topic_goods`;
CREATE TABLE `mall_topic_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '专题商品id',
  `topic_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '专题id',
  `goods_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品id',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='主题商品表';

-- ----------------------------
-- Table structure for mall_user_coupon
-- ----------------------------
DROP TABLE IF EXISTS `mall_user_coupon`;
CREATE TABLE `mall_user_coupon` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户优惠券id',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `coupon_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '优惠券id',
  `status` int(1) NOT NULL DEFAULT '0' COMMENT '优惠券状态 0-可用 1-不可用 2-已过期',
  `number` int(11) NOT NULL DEFAULT '1' COMMENT '优惠券数量',
  `order_id` bigint(20) DEFAULT NULL COMMENT '已使用订单id',
  `crete_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户优惠券';

-- ----------------------------
-- Table structure for mem_address
-- ----------------------------
DROP TABLE IF EXISTS `mem_address`;
CREATE TABLE `mem_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '收货地址id',
  `receiver` varchar(64) NOT NULL DEFAULT '' COMMENT '收货人',
  `receiver_mobile` varchar(32) NOT NULL DEFAULT '' COMMENT '收货人手机号',
  `area` varchar(255) NOT NULL DEFAULT '' COMMENT '收货区域',
  `address` varchar(255) NOT NULL DEFAULT '' COMMENT '详细地址',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最近修改时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1-已删除，0-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='收货地址表';

-- ----------------------------
-- Records of mem_address
-- ----------------------------
BEGIN;
INSERT INTO `mem_address` VALUES (1, '李岩', '15939502821', '河南省漯河市召陵区', '人民路与解放路交叉口', 1, '2020-07-30 12:42:00', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mem_collect
-- ----------------------------
DROP TABLE IF EXISTS `mem_collect`;
CREATE TABLE `mem_collect` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户收藏id',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `spu_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品id',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '上次修改时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1-已删除 0-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户收藏表';

-- ----------------------------
-- Records of mem_collect
-- ----------------------------
BEGIN;
INSERT INTO `mem_collect` VALUES (1, 1, 1, '2020-08-01 22:44:01', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mem_history
-- ----------------------------
DROP TABLE IF EXISTS `mem_history`;
CREATE TABLE `mem_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '浏览历史id',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `spu_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '商品id',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '上次修改时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1-已删除,0-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='浏览历史表';

-- ----------------------------
-- Records of mem_history
-- ----------------------------
BEGIN;
INSERT INTO `mem_history` VALUES (1, 1, 1, '2020-08-02 11:29:26', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mem_opinion
-- ----------------------------
DROP TABLE IF EXISTS `mem_opinion`;
CREATE TABLE `mem_opinion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '反馈id',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `opinion_type` int(1) NOT NULL DEFAULT '0' COMMENT '反馈类型',
  `content` varchar(500) NOT NULL DEFAULT '' COMMENT '反馈内容',
  `img` varchar(500) NOT NULL DEFAULT '' COMMENT '反馈图片',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime DEFAULT NULL COMMENT '最近修改时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 1-已删除 0-未删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='意见反馈表';

-- ----------------------------
-- Records of mem_opinion
-- ----------------------------
BEGIN;
INSERT INTO `mem_opinion` VALUES (1, 1, 0, '有bug', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596370193682&di=8e32a62073f74c54585b65e224343f7f&imgtype=0&src=http%3A%2F%2Fattach.bbs.miui.com%2Fforum%2F201708%2F09%2F074457x2l69b3os2xvbcso.jpg', '2020-08-02 17:19:52', NULL, 0);
INSERT INTO `mem_opinion` VALUES (2, 2, 1, '增加会员积分', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1596370193680&di=80c8822faee6752d4aa5df766556445a&imgtype=0&src=http%3A%2F%2Fexp-picture.cdn.bcebos.com%2F5e9a2820b93acd890178ccba0335dd8a58de8b16.jpg%3Fx-bce-process%3Dimage%2Fresize%2Cm_lfit%2Cw_500%2Climit_1', '2020-08-02 17:20:34', NULL, 0);
COMMIT;

-- ----------------------------
-- Table structure for mem_user
-- ----------------------------
DROP TABLE IF EXISTS `mem_user`;
CREATE TABLE `mem_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '用户密码',
  `mobile` varchar(32) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `nickname` varchar(255) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `gender` varchar(2) NOT NULL COMMENT '用户性别',
  `birthday` date DEFAULT NULL COMMENT '用户生日',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '用户头像',
  `rank` varchar(16) NOT NULL DEFAULT '普通用户' COMMENT '用户等级',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '用户状态 1-可用 0-禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '上次修改时间',
  `deleted` int(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除 0-未删除,1-已删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_mobile` (`mobile`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='会员表\n';

-- ----------------------------
-- Records of mem_user
-- ----------------------------
BEGIN;
INSERT INTO `mem_user` VALUES (1, '', '15939502821', 'ohayou', '男', '1989-11-11', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3302576574,237334394&fm=26&gp=0.jpg', '普通用户', 1, '2020-07-29 20:01:31', '2020-09-17 15:18:30', 0);
INSERT INTO `mem_user` VALUES (2, '', '13783548882', '咿呀咿呀呦', '女', '1987-01-01', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2235240708,3390568978&fm=26&gp=0.jpg', '黄金会员', 1, '2020-07-30 10:58:08', '2020-08-02 16:54:31', 0);
COMMIT;

-- ----------------------------
-- Table structure for sys_freight_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_freight_config`;
CREATE TABLE `sys_freight_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '运费配置id',
  `freight_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '运费价格',
  `relief_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '满足免运费的金额',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='运费设置表';

-- ----------------------------
-- Table structure for sys_order_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_order_config`;
CREATE TABLE `sys_order_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单配置id',
  `expire_time` int(11) NOT NULL DEFAULT '0' COMMENT '订单过期取消时间',
  `time_unit` varchar(10) NOT NULL DEFAULT '分钟' COMMENT '过期时间单位',
  `confirm_days` varchar(10) NOT NULL DEFAULT '0' COMMENT '订单发货后超期未确认收货天数后自动确认收货',
  `comment_days` varchar(10) NOT NULL DEFAULT '0' COMMENT '超过天数未评论取消评论资格',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `deleted` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单设置表';

SET FOREIGN_KEY_CHECKS = 1;
