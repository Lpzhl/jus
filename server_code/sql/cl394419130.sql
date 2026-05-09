-- MySQL dump 10.13  Distrib 5.7.44, for Linux (x86_64)
--
-- Host: localhost    Database: cl394419130
-- ------------------------------------------------------
-- Server version	5.7.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `cl394419130`
--

/*!40000 DROP DATABASE IF EXISTS `cl394419130`*/;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `cl394419130` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `cl394419130`;

--
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `adminid` bigint(20) DEFAULT NULL COMMENT '管理员id',
  `ask` longtext COLLATE utf8mb4_unicode_ci COMMENT '提问内容',
  `reply` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `isreply` int(11) DEFAULT NULL COMMENT '是否回复',
  `admin_table_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '管理表',
  `user_table_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户表',
  `is_read` int(11) DEFAULT '0' COMMENT '已读1/未读0',
  `user_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `user_image` longtext COLLATE utf8mb4_unicode_ci COMMENT '用户头像',
  `type` int(11) DEFAULT '1' COMMENT '内容(1:文本,2:图片,3:视频,4:文件,5:表情)',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='咨询问题';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES (1,'2026-04-30 10:52:57',1,'提问内容1','回复内容1',1,'管理表1','用户表1',1,'用户名1','file/chatUser_image1.jpg,file/chatUser_image2.jpg,file/chatUser_image3.jpg',1,1),(2,'2026-04-30 10:52:57',2,'提问内容2','回复内容2',2,'管理表2','用户表2',2,'用户名2','file/chatUser_image2.jpg,file/chatUser_image3.jpg,file/chatUser_image4.jpg',2,2),(3,'2026-04-30 10:52:57',3,'提问内容3','回复内容3',3,'管理表3','用户表3',3,'用户名3','file/chatUser_image3.jpg,file/chatUser_image4.jpg,file/chatUser_image5.jpg',3,3),(4,'2026-04-30 10:52:57',4,'提问内容4','回复内容4',4,'管理表4','用户表4',4,'用户名4','file/chatUser_image4.jpg,file/chatUser_image5.jpg,file/chatUser_image6.jpg',4,4),(5,'2026-04-30 10:52:57',5,'提问内容5','回复内容5',5,'管理表5','用户表5',5,'用户名5','file/chatUser_image5.jpg,file/chatUser_image6.jpg,file/chatUser_image7.jpg',5,5),(6,'2026-04-30 10:52:57',6,'提问内容6','回复内容6',6,'管理表6','用户表6',6,'用户名6','file/chatUser_image6.jpg,file/chatUser_image7.jpg,file/chatUser_image8.jpg',6,6),(7,'2026-04-30 10:52:57',7,'提问内容7','回复内容7',7,'管理表7','用户表7',7,'用户名7','file/chatUser_image7.jpg,file/chatUser_image8.jpg,file/chatUser_image9.jpg',7,7),(8,'2026-04-30 10:52:57',8,'提问内容8','回复内容8',8,'管理表8','用户表8',8,'用户名8','file/chatUser_image8.jpg,file/chatUser_image9.jpg,file/chatUser_image10.jpg',8,8),(9,'2026-04-30 10:52:57',9,'提问内容9','回复内容9',9,'管理表9','用户表9',9,'用户名9','file/chatUser_image9.jpg,file/chatUser_image10.jpg,file/chatUser_image11.jpg',9,9),(10,'2026-04-30 10:52:57',10,'提问内容10','回复内容10',10,'管理表10','用户表10',10,'用户名10','file/chatUser_image10.jpg,file/chatUser_image11.jpg,file/chatUser_image12.jpg',10,10);
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chathelper`
--

DROP TABLE IF EXISTS `chathelper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chathelper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ask` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '提问内容',
  `reply` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='聊天助手';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chathelper`
--

LOCK TABLES `chathelper` WRITE;
/*!40000 ALTER TABLE `chathelper` DISABLE KEYS */;
INSERT INTO `chathelper` VALUES (1,'2026-04-30 10:52:57','提问内容1','回复内容1'),(2,'2026-04-30 10:52:57','提问内容2','回复内容2'),(3,'2026-04-30 10:52:57','提问内容3','回复内容3'),(4,'2026-04-30 10:52:57','提问内容4','回复内容4'),(5,'2026-04-30 10:52:57','提问内容5','回复内容5'),(6,'2026-04-30 10:52:57','提问内容6','回复内容6'),(7,'2026-04-30 10:52:57','提问内容7','回复内容7'),(8,'2026-04-30 10:52:57','提问内容8','回复内容8'),(9,'2026-04-30 10:52:57','提问内容9','回复内容9'),(10,'2026-04-30 10:52:57','提问内容10','回复内容10');
/*!40000 ALTER TABLE `chathelper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '名称',
  `value` longtext COLLATE utf8mb4_unicode_ci COMMENT '值',
  `url` longtext COLLATE utf8mb4_unicode_ci COMMENT '链接',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='轮播图';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
INSERT INTO `config` VALUES (1,'2026-04-30 10:52:58','swiper1','file/swiperPicture1.jpg',NULL),(2,'2026-04-30 10:52:58','swiper2','file/swiperPicture2.jpg',NULL),(3,'2026-04-30 10:52:58','swiper3','file/swiperPicture3.jpg',NULL),(13,'2026-04-30 10:52:58','qf','{\"appId\":\"117884844\", \"apiKey\":\"50N8GH58d5JjrhSwaVhtpFpw\",\"secretKey\":\"P99xHvudQo8o435m5uDOKnh1VIUlosLr\"}',NULL);
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fapiaohexiao`
--

DROP TABLE IF EXISTS `fapiaohexiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fapiaohexiao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fapiaomingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发票名称',
  `fapiaoleixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发票类型',
  `hexiaoshijian` datetime DEFAULT NULL COMMENT '核销时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `fapiaohaoma` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发票号码',
  `shuliang` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='发票核销';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fapiaohexiao`
--

LOCK TABLES `fapiaohexiao` WRITE;
/*!40000 ALTER TABLE `fapiaohexiao` DISABLE KEYS */;
INSERT INTO `fapiaohexiao` VALUES (1,'2026-04-30 10:52:58','广告设计制作发票','增值税专用发票','2026-04-30 18:52:58','拓普制造','M2024005',1),(2,'2026-04-30 10:52:58','物流运输服务发票','增值税电子普通发票','2026-04-30 18:52:58','云境科技','M2024009',2),(3,'2026-04-30 10:52:58','软件开发服务发票','增值税普通发票','2026-04-30 18:52:58','艺境设计','M2024017',3),(4,'2026-04-30 10:52:58','办公家具定制发票','增值税专用发票','2026-04-30 18:52:58','星耀餐饮','M2024016',4),(5,'2026-04-30 10:52:58','办公用品采购发票','增值税电子普通发票','2026-04-30 18:52:58','智联教育','M2024006',5),(6,'2026-04-30 10:52:58','印刷制作服务发票','增值税专用发票','2026-04-30 18:52:58','创想广告','M2024014',6),(7,'2026-04-30 10:52:58','音乐版权使用发票','增值税专用发票','2026-04-30 18:52:58','康益医疗','M2024011',7),(8,'2026-04-30 10:52:58','维修保养服务发票','增值税普通发票','2026-04-30 18:52:58','晶彩珠宝','M2024025',8),(9,'2026-04-30 10:52:58','餐饮服务消费发票','增值税专用发票','2026-04-30 18:52:58','乐活家居','M2024018',9),(10,'2026-04-30 10:52:58','图书采购发票','增值税电子普通发票','2026-04-30 18:52:58','悦动健身','M2024001',10);
/*!40000 ALTER TABLE `fapiaohexiao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fapiaokaiju`
--

DROP TABLE IF EXISTS `fapiaokaiju`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fapiaokaiju` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fapiaomingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发票名称',
  `fapiaoleixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发票类型',
  `shangchuanshijian` datetime DEFAULT NULL COMMENT '上传时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `fapiaotupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '发票图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='发票开具';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fapiaokaiju`
--

LOCK TABLES `fapiaokaiju` WRITE;
/*!40000 ALTER TABLE `fapiaokaiju` DISABLE KEYS */;
INSERT INTO `fapiaokaiju` VALUES (1,'2026-04-30 10:52:58','广告设计制作发票','增值税专用发票','2026-04-30 18:52:58','拓普制造','file/fapiaokaiju_广告设计制作发票1.jpg,file/fapiaokaiju_广告设计制作发票2.jpg,file/fapiaokaiju_广告设计制作发票3.jpg'),(2,'2026-04-30 10:52:58','物流运输服务发票','增值税电子普通发票','2026-04-30 18:52:58','云境科技','file/fapiaokaiju_物流运输服务发票1.jpg,file/fapiaokaiju_物流运输服务发票2.jpg,file/fapiaokaiju_物流运输服务发票3.jpg'),(3,'2026-04-30 10:52:58','软件开发服务发票','增值税普通发票','2026-04-30 18:52:58','艺境设计','file/fapiaokaiju_软件开发服务发票1.jpg,file/fapiaokaiju_软件开发服务发票2.jpg,file/fapiaokaiju_软件开发服务发票3.jpg'),(4,'2026-04-30 10:52:58','办公家具定制发票','增值税专用发票','2026-04-30 18:52:58','星耀餐饮','file/fapiaokaiju_办公家具定制发票1.jpg,file/fapiaokaiju_办公家具定制发票2.jpg,file/fapiaokaiju_办公家具定制发票3.jpg'),(5,'2026-04-30 10:52:58','办公用品采购发票','增值税电子普通发票','2026-04-30 18:52:58','智联教育','file/fapiaokaiju_办公用品采购发票1.jpg,file/fapiaokaiju_办公用品采购发票2.jpg,file/fapiaokaiju_办公用品采购发票3.jpg'),(6,'2026-04-30 10:52:58','印刷制作服务发票','增值税专用发票','2026-04-30 18:52:58','创想广告','file/fapiaokaiju_印刷制作服务发票1.jpg,file/fapiaokaiju_印刷制作服务发票2.jpg,file/fapiaokaiju_印刷制作服务发票3.jpg'),(7,'2026-04-30 10:52:58','音乐版权使用发票','增值税专用发票','2026-04-30 18:52:58','康益医疗','file/fapiaokaiju_音乐版权使用发票1.jpg,file/fapiaokaiju_音乐版权使用发票2.jpg,file/fapiaokaiju_音乐版权使用发票3.jpg'),(8,'2026-04-30 10:52:58','维修保养服务发票','增值税普通发票','2026-04-30 18:52:58','晶彩珠宝','file/fapiaokaiju_维修保养服务发票1.jpg,file/fapiaokaiju_维修保养服务发票2.jpg,file/fapiaokaiju_维修保养服务发票3.jpg'),(9,'2026-04-30 10:52:58','餐饮服务消费发票','增值税专用发票','2026-04-30 18:52:58','乐活家居','file/fapiaokaiju_餐饮服务消费发票1.jpg,file/fapiaokaiju_餐饮服务消费发票2.jpg,file/fapiaokaiju_餐饮服务消费发票3.jpg'),(10,'2026-04-30 10:52:58','图书采购发票','增值税电子普通发票','2026-04-30 18:52:58','悦动健身','file/fapiaokaiju_图书采购发票1.jpg,file/fapiaokaiju_图书采购发票2.jpg,file/fapiaokaiju_图书采购发票3.jpg');
/*!40000 ALTER TABLE `fapiaokaiju` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fapiaoleixing`
--

DROP TABLE IF EXISTS `fapiaoleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fapiaoleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fapiaoleixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发票类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='发票类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fapiaoleixing`
--

LOCK TABLES `fapiaoleixing` WRITE;
/*!40000 ALTER TABLE `fapiaoleixing` DISABLE KEYS */;
INSERT INTO `fapiaoleixing` VALUES (1,'2026-04-30 10:52:57','增值税专用发票'),(2,'2026-04-30 10:52:57','增值税电子普通发票'),(3,'2026-04-30 10:52:57','增值税普通发票'),(4,'2026-04-30 10:52:57','增值税专用发票'),(5,'2026-04-30 10:52:57','增值税电子普通发票'),(6,'2026-04-30 10:52:57','增值税专用发票'),(7,'2026-04-30 10:52:57','增值税专用发票'),(8,'2026-04-30 10:52:57','增值税普通发票'),(9,'2026-04-30 10:52:57','增值税专用发票'),(10,'2026-04-30 10:52:57','增值税电子普通发票');
/*!40000 ALTER TABLE `fapiaoleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fapiaolingyong`
--

DROP TABLE IF EXISTS `fapiaolingyong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fapiaolingyong` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fapiaomingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发票名称',
  `fapiaoleixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发票类型',
  `shangchuanshijian` datetime DEFAULT NULL COMMENT '上传时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='发票领用';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fapiaolingyong`
--

LOCK TABLES `fapiaolingyong` WRITE;
/*!40000 ALTER TABLE `fapiaolingyong` DISABLE KEYS */;
INSERT INTO `fapiaolingyong` VALUES (1,'2026-04-30 10:52:58','广告设计制作发票','增值税专用发票','2026-04-30 18:52:58','拓普制造'),(2,'2026-04-30 10:52:58','物流运输服务发票','增值税电子普通发票','2026-04-30 18:52:58','云境科技'),(3,'2026-04-30 10:52:58','软件开发服务发票','增值税普通发票','2026-04-30 18:52:58','艺境设计'),(4,'2026-04-30 10:52:58','办公家具定制发票','增值税专用发票','2026-04-30 18:52:58','星耀餐饮'),(5,'2026-04-30 10:52:58','办公用品采购发票','增值税电子普通发票','2026-04-30 18:52:58','智联教育'),(6,'2026-04-30 10:52:58','印刷制作服务发票','增值税专用发票','2026-04-30 18:52:58','创想广告'),(7,'2026-04-30 10:52:58','音乐版权使用发票','增值税专用发票','2026-04-30 18:52:58','康益医疗'),(8,'2026-04-30 10:52:58','维修保养服务发票','增值税普通发票','2026-04-30 18:52:58','晶彩珠宝'),(9,'2026-04-30 10:52:58','餐饮服务消费发票','增值税专用发票','2026-04-30 18:52:58','乐活家居'),(10,'2026-04-30 10:52:58','图书采购发票','增值税电子普通发票','2026-04-30 18:52:58','悦动健身');
/*!40000 ALTER TABLE `fapiaolingyong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fapiaozuofei`
--

DROP TABLE IF EXISTS `fapiaozuofei`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fapiaozuofei` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fapiaomingcheng` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发票名称',
  `fapiaoleixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发票类型',
  `zuofeishijian` datetime DEFAULT NULL COMMENT '作废时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `fapiaotupian` longtext COLLATE utf8mb4_unicode_ci COMMENT '发票图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='发票作废';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fapiaozuofei`
--

LOCK TABLES `fapiaozuofei` WRITE;
/*!40000 ALTER TABLE `fapiaozuofei` DISABLE KEYS */;
INSERT INTO `fapiaozuofei` VALUES (1,'2026-04-30 10:52:58','广告设计制作发票','增值税专用发票','2026-04-30 18:52:58','拓普制造','file/fapiaozuofei_广告设计制作发票1.jpg,file/fapiaozuofei_广告设计制作发票2.jpg,file/fapiaozuofei_广告设计制作发票3.jpg'),(2,'2026-04-30 10:52:58','物流运输服务发票','增值税电子普通发票','2026-04-30 18:52:58','云境科技','file/fapiaozuofei_物流运输服务发票1.jpg,file/fapiaozuofei_物流运输服务发票2.jpg,file/fapiaozuofei_物流运输服务发票3.jpg'),(3,'2026-04-30 10:52:58','软件开发服务发票','增值税普通发票','2026-04-30 18:52:58','艺境设计','file/fapiaozuofei_软件开发服务发票1.jpg,file/fapiaozuofei_软件开发服务发票2.jpg,file/fapiaozuofei_软件开发服务发票3.jpg'),(4,'2026-04-30 10:52:58','办公家具定制发票','增值税专用发票','2026-04-30 18:52:58','星耀餐饮','file/fapiaozuofei_办公家具定制发票1.jpg,file/fapiaozuofei_办公家具定制发票2.jpg,file/fapiaozuofei_办公家具定制发票3.jpg'),(5,'2026-04-30 10:52:58','办公用品采购发票','增值税电子普通发票','2026-04-30 18:52:58','智联教育','file/fapiaozuofei_办公用品采购发票1.jpg,file/fapiaozuofei_办公用品采购发票2.jpg,file/fapiaozuofei_办公用品采购发票3.jpg'),(6,'2026-04-30 10:52:58','印刷制作服务发票','增值税专用发票','2026-04-30 18:52:58','创想广告','file/fapiaozuofei_印刷制作服务发票1.jpg,file/fapiaozuofei_印刷制作服务发票2.jpg,file/fapiaozuofei_印刷制作服务发票3.jpg'),(7,'2026-04-30 10:52:58','音乐版权使用发票','增值税专用发票','2026-04-30 18:52:58','康益医疗','file/fapiaozuofei_音乐版权使用发票1.jpg,file/fapiaozuofei_音乐版权使用发票2.jpg,file/fapiaozuofei_音乐版权使用发票3.jpg'),(8,'2026-04-30 10:52:58','维修保养服务发票','增值税普通发票','2026-04-30 18:52:58','晶彩珠宝','file/fapiaozuofei_维修保养服务发票1.jpg,file/fapiaozuofei_维修保养服务发票2.jpg,file/fapiaozuofei_维修保养服务发票3.jpg'),(9,'2026-04-30 10:52:58','餐饮服务消费发票','增值税专用发票','2026-04-30 18:52:58','乐活家居','file/fapiaozuofei_餐饮服务消费发票1.jpg,file/fapiaozuofei_餐饮服务消费发票2.jpg,file/fapiaozuofei_餐饮服务消费发票3.jpg'),(10,'2026-04-30 10:52:58','图书采购发票','增值税电子普通发票','2026-04-30 18:52:58','悦动健身','file/fapiaozuofei_图书采购发票1.jpg,file/fapiaozuofei_图书采购发票2.jpg,file/fapiaozuofei_图书采购发票3.jpg');
/*!40000 ALTER TABLE `fapiaozuofei` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jichushuju`
--

DROP TABLE IF EXISTS `jichushuju`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jichushuju` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `nianfen` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '年份',
  `yuefen` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '月份',
  `xiaoxiangfapiao` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '销项发票',
  `jinxiangfapiao` longtext COLLATE utf8mb4_unicode_ci COMMENT '进项发票',
  `yingshou` double DEFAULT NULL COMMENT '营收',
  `chengbenfeiyong` double DEFAULT NULL COMMENT '成本费用',
  `shenbaoshijian` datetime DEFAULT NULL COMMENT '申报时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  `shenbaojindu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '申报进度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='基础数据';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jichushuju`
--

LOCK TABLES `jichushuju` WRITE;
/*!40000 ALTER TABLE `jichushuju` DISABLE KEYS */;
INSERT INTO `jichushuju` VALUES (1,'2026-04-30 10:52:57','2014','六月','file/jichushuju_广告设计制作发票1.jpg,file/jichushuju_广告设计制作发票2.jpg,file/jichushuju_广告设计制作发票3.jpg','file/jichushuju_广告设计制作发票1.jpg,file/jichushuju_广告设计制作发票2.jpg,file/jichushuju_广告设计制作发票3.jpg',1,1,'2026-04-30 18:52:57','拓普制造',1,'是','','已申报'),(2,'2026-04-30 10:52:57','2021','一月','file/jichushuju_物流运输服务发票1.jpg,file/jichushuju_物流运输服务发票2.jpg,file/jichushuju_物流运输服务发票3.jpg','file/jichushuju_物流运输服务发票1.jpg,file/jichushuju_物流运输服务发票2.jpg,file/jichushuju_物流运输服务发票3.jpg',2,2,'2026-04-30 18:52:57','云境科技',2,'是','','已申报'),(3,'2026-04-30 10:52:57','2023','五月','file/jichushuju_软件开发服务发票1.jpg,file/jichushuju_软件开发服务发票2.jpg,file/jichushuju_软件开发服务发票3.jpg','file/jichushuju_软件开发服务发票1.jpg,file/jichushuju_软件开发服务发票2.jpg,file/jichushuju_软件开发服务发票3.jpg',3,3,'2026-04-30 18:52:57','艺境设计',3,'是','','已申报'),(4,'2026-04-30 10:52:57','2018','八月','file/jichushuju_办公家具定制发票1.jpg,file/jichushuju_办公家具定制发票2.jpg,file/jichushuju_办公家具定制发票3.jpg','file/jichushuju_办公家具定制发票1.jpg,file/jichushuju_办公家具定制发票2.jpg,file/jichushuju_办公家具定制发票3.jpg',4,4,'2026-04-30 18:52:57','星耀餐饮',4,'是','','已申报'),(5,'2026-04-30 10:52:57','2019','二月','file/jichushuju_办公用品采购发票1.jpg,file/jichushuju_办公用品采购发票2.jpg,file/jichushuju_办公用品采购发票3.jpg','file/jichushuju_办公用品采购发票1.jpg,file/jichushuju_办公用品采购发票2.jpg,file/jichushuju_办公用品采购发票3.jpg',5,5,'2026-04-30 18:52:57','智联教育',5,'是','','已申报'),(6,'2026-04-30 10:52:57','2024','十一月','file/jichushuju_印刷制作服务发票1.jpg,file/jichushuju_印刷制作服务发票2.jpg,file/jichushuju_印刷制作服务发票3.jpg','file/jichushuju_印刷制作服务发票1.jpg,file/jichushuju_印刷制作服务发票2.jpg,file/jichushuju_印刷制作服务发票3.jpg',6,6,'2026-04-30 18:52:57','创想广告',6,'是','','已申报'),(7,'2026-04-30 10:52:57','2017','十二月','file/jichushuju_音乐版权使用发票1.jpg,file/jichushuju_音乐版权使用发票2.jpg,file/jichushuju_音乐版权使用发票3.jpg','file/jichushuju_音乐版权使用发票1.jpg,file/jichushuju_音乐版权使用发票2.jpg,file/jichushuju_音乐版权使用发票3.jpg',7,7,'2026-04-30 18:52:57','康益医疗',7,'是','','已申报'),(8,'2026-04-30 10:52:57','2015','四月','file/jichushuju_维修保养服务发票1.jpg,file/jichushuju_维修保养服务发票2.jpg,file/jichushuju_维修保养服务发票3.jpg','file/jichushuju_维修保养服务发票1.jpg,file/jichushuju_维修保养服务发票2.jpg,file/jichushuju_维修保养服务发票3.jpg',8,8,'2026-04-30 18:52:57','晶彩珠宝',8,'是','','已申报'),(9,'2026-04-30 10:52:57','2020','九月','file/jichushuju_餐饮服务消费发票1.jpg,file/jichushuju_餐饮服务消费发票2.jpg,file/jichushuju_餐饮服务消费发票3.jpg','file/jichushuju_餐饮服务消费发票1.jpg,file/jichushuju_餐饮服务消费发票2.jpg,file/jichushuju_餐饮服务消费发票3.jpg',9,9,'2026-04-30 18:52:57','乐活家居',9,'是','','已申报'),(10,'2026-04-30 10:52:57','2025','三月','file/jichushuju_图书采购发票1.jpg,file/jichushuju_图书采购发票2.jpg,file/jichushuju_图书采购发票3.jpg','file/jichushuju_图书采购发票1.jpg,file/jichushuju_图书采购发票2.jpg,file/jichushuju_图书采购发票3.jpg',10,10,'2026-04-30 18:52:57','悦动健身',10,'是','','已申报');
/*!40000 ALTER TABLE `jichushuju` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `menujson` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='菜单';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'2026-04-30 10:52:58','[{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"税务变化\",\"申报进度\",\"首页总数\",\"首页统计\",\"缴纳金额\",\"申报操作\"],\"appFrontIcon\":\"cuIcon-copy\",\"buttons\":[\"查看\",\"申报操作\"],\"classname\":\"jichushuju\",\"menu\":\"基础数据\",\"menuJump\":\"列表\",\"tableName\":\"jichushuju\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"支付\",\"缴款状态\",\"首页总数\",\"首页统计\",\"催缴\"],\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"查看\",\"支付\"],\"classname\":\"shuikuanjiaona\",\"menu\":\"税款缴纳\",\"menuJump\":\"列表\",\"tableName\":\"shuikuanjiaona\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"classname\":\"qianshuicuijiao\",\"menu\":\"欠税催缴\",\"menuJump\":\"列表\",\"tableName\":\"qianshuicuijiao\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"classname\":\"shenbaohuizhi\",\"menu\":\"申报回执\",\"menuJump\":\"列表\",\"tableName\":\"shenbaohuizhi\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"申报回执\"],\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"查看\"],\"classname\":\"shenbaocaozuo\",\"menu\":\"申报操作\",\"menuJump\":\"列表\",\"tableName\":\"shenbaocaozuo\"}],\"fontClass\":\"icon-common28\",\"menu\":\"基础数据管理\",\"unicode\":\"&#xee2d;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"发票类型\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-form\",\"buttons\":[\"查看\",\"修改\",\"删除\",\"新增\"],\"classname\":\"fapiaokaiju\",\"menu\":\"发票开具\",\"menuJump\":\"列表\",\"tableName\":\"fapiaokaiju\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"发票类型\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"查看\",\"删除\",\"新增\"],\"classname\":\"fapiaolingyong\",\"menu\":\"发票领用\",\"menuJump\":\"列表\",\"tableName\":\"fapiaolingyong\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\",\"删除\",\"新增\"],\"classname\":\"fapiaozuofei\",\"menu\":\"发票作废\",\"menuJump\":\"列表\",\"tableName\":\"fapiaozuofei\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\",\"删除\",\"新增\"],\"classname\":\"fapiaohexiao\",\"menu\":\"发票核销\",\"menuJump\":\"列表\",\"tableName\":\"fapiaohexiao\"}],\"fontClass\":\"icon-common15\",\"menu\":\"发票信息管理\",\"unicode\":\"&#xedfc;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"归档\"],\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"查看\",\"新增\"],\"classname\":\"ziliaoshangchuan\",\"menu\":\"资料上传\",\"menuJump\":\"列表\",\"tableName\":\"ziliaoshangchuan\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\"],\"classname\":\"ziliaoguidang\",\"menu\":\"资料归档\",\"menuJump\":\"列表\",\"tableName\":\"ziliaoguidang\"}],\"fontClass\":\"icon-common24\",\"menu\":\"资料上传管理\",\"unicode\":\"&#xee07;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-list\",\"buttons\":[\"查看\"],\"classname\":\"shuiwuhuizongfenxi\",\"menu\":\"税务汇总分析\",\"menuJump\":\"列表\",\"tableName\":\"shuiwuhuizongfenxi\"}],\"fontClass\":\"icon-common46\",\"menu\":\"税务汇总分析管理\",\"unicode\":\"&#xef3d;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\"],\"classname\":\"qiyexiangqing\",\"menu\":\"企业详情\",\"menuJump\":\"列表\",\"tableName\":\"qiyexiangqing\"}],\"fontClass\":\"icon-common38\",\"menu\":\"企业详情管理\",\"unicode\":\"&#xeeb2;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"classname\":\"news\",\"menu\":\"税务资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"税务资讯管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"查看\",\"新增\",\"修改\",\"删除\",\"申报操作\"],\"classname\":\"jichushuju\",\"menu\":\"基础数据\",\"menuJump\":\"列表\",\"tableName\":\"jichushuju\"}],\"menu\":\"基础数据管理\"}],\"hasBackLogin\":\"否\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"是\",\"hasFrontRegister\":\"是\",\"pathName\":\"qiye\",\"roleName\":\"企业\",\"tableName\":\"qiye\"},{\"backMenu\":[{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-taxi\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"config\",\"menu\":\"轮播图\",\"menuJump\":\"列表\",\"tableName\":\"config\"}],\"fontClass\":\"icon-common30\",\"menu\":\"轮播图管理\",\"unicode\":\"&#xee30;\"},{\"child\":[{\"allButtons\":[\"菜单管理\"],\"appFrontIcon\":\"cuIcon-goods\",\"buttons\":[\"菜单管理\"],\"classname\":\"menu\",\"menu\":\"菜单\",\"menuJump\":\"列表\",\"tableName\":\"menu\"}],\"fontClass\":\"icon-common9\",\"menu\":\"菜单管理\",\"unicode\":\"&#xedc9;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-medal\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"news\",\"menu\":\"税务资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"fontClass\":\"icon-common35\",\"menu\":\"税务资讯管理\",\"unicode\":\"&#xee8c;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-present\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"users\",\"menu\":\"管理员\",\"menuJump\":\"列表\",\"tableName\":\"users\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"行业类型\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-list\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"行业类型\",\"首页总数\",\"首页统计\"],\"classname\":\"qiye\",\"menu\":\"企业\",\"menuJump\":\"列表\",\"tableName\":\"qiye\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-clothes\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"xingyeleixing\",\"menu\":\"行业类型\",\"menuJump\":\"列表\",\"tableName\":\"xingyeleixing\"}],\"fontClass\":\"icon-user3\",\"menu\":\"用户管理\",\"unicode\":\"&#xef99;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"syslog\",\"menu\":\"操作日志\",\"menuJump\":\"列表\",\"tableName\":\"syslog\"}],\"fontClass\":\"icon-common19\",\"menu\":\"操作日志管理\",\"unicode\":\"&#xee00;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-newshot\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"systemNotice\",\"menu\":\"系统公告\",\"menuJump\":\"列表\",\"tableName\":\"system_notice\"}],\"fontClass\":\"icon-common3\",\"menu\":\"系统公告管理\",\"unicode\":\"&#xeda5;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"税务变化\",\"申报进度\",\"首页总数\",\"首页统计\",\"缴纳金额\",\"申报操作\"],\"appFrontIcon\":\"cuIcon-copy\",\"buttons\":[\"查看\",\"审核\",\"税务变化\",\"首页总数\",\"首页统计\",\"缴纳金额\",\"申报进度\"],\"classname\":\"jichushuju\",\"menu\":\"基础数据\",\"menuJump\":\"列表\",\"tableName\":\"jichushuju\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"支付\",\"缴款状态\",\"首页总数\",\"首页统计\",\"催缴\"],\"appFrontIcon\":\"cuIcon-full\",\"buttons\":[\"查看\",\"催缴\",\"缴款状态\",\"首页总数\",\"首页统计\"],\"classname\":\"shuikuanjiaona\",\"menu\":\"税款缴纳\",\"menuJump\":\"列表\",\"tableName\":\"shuikuanjiaona\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\"],\"classname\":\"qianshuicuijiao\",\"menu\":\"欠税催缴\",\"menuJump\":\"列表\",\"tableName\":\"qianshuicuijiao\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"查看\",\"修改\",\"删除\"],\"classname\":\"shenbaohuizhi\",\"menu\":\"申报回执\",\"menuJump\":\"列表\",\"tableName\":\"shenbaohuizhi\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"申报回执\"],\"appFrontIcon\":\"cuIcon-news\",\"buttons\":[\"申报回执\",\"查看\"],\"classname\":\"shenbaocaozuo\",\"menu\":\"申报操作\",\"menuJump\":\"列表\",\"tableName\":\"shenbaocaozuo\"}],\"fontClass\":\"icon-common28\",\"menu\":\"基础数据管理\",\"unicode\":\"&#xee2d;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"发票类型\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-time\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"发票类型\",\"首页总数\",\"首页统计\"],\"classname\":\"fapiaoleixing\",\"menu\":\"发票类型\",\"menuJump\":\"列表\",\"tableName\":\"fapiaoleixing\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"发票类型\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-form\",\"buttons\":[\"查看\"],\"classname\":\"fapiaokaiju\",\"menu\":\"发票开具\",\"menuJump\":\"列表\",\"tableName\":\"fapiaokaiju\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"发票类型\",\"首页总数\",\"首页统计\"],\"appFrontIcon\":\"cuIcon-addressbook\",\"buttons\":[\"查看\"],\"classname\":\"fapiaolingyong\",\"menu\":\"发票领用\",\"menuJump\":\"列表\",\"tableName\":\"fapiaolingyong\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"classname\":\"fapiaozuofei\",\"menu\":\"发票作废\",\"menuJump\":\"列表\",\"tableName\":\"fapiaozuofei\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-phone\",\"buttons\":[\"查看\"],\"classname\":\"fapiaohexiao\",\"menu\":\"发票核销\",\"menuJump\":\"列表\",\"tableName\":\"fapiaohexiao\"}],\"fontClass\":\"icon-common15\",\"menu\":\"发票信息管理\",\"unicode\":\"&#xedfc;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\",\"审核\",\"归档\"],\"appFrontIcon\":\"cuIcon-brand\",\"buttons\":[\"查看\",\"审核\",\"归档\"],\"classname\":\"ziliaoshangchuan\",\"menu\":\"资料上传\",\"menuJump\":\"列表\",\"tableName\":\"ziliaoshangchuan\"},{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"查看\"],\"classname\":\"ziliaoguidang\",\"menu\":\"资料归档\",\"menuJump\":\"列表\",\"tableName\":\"ziliaoguidang\"}],\"fontClass\":\"icon-common24\",\"menu\":\"资料上传管理\",\"unicode\":\"&#xee07;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-vipcard\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"qiyexiangqing\",\"menu\":\"企业详情\",\"menuJump\":\"列表\",\"tableName\":\"qiyexiangqing\"}],\"fontClass\":\"icon-common38\",\"menu\":\"企业详情管理\",\"unicode\":\"&#xeeb2;\"},{\"child\":[{\"allButtons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"appFrontIcon\":\"cuIcon-list\",\"buttons\":[\"新增\",\"查看\",\"修改\",\"删除\"],\"classname\":\"shuiwuhuizongfenxi\",\"menu\":\"税务汇总分析\",\"menuJump\":\"列表\",\"tableName\":\"shuiwuhuizongfenxi\"}],\"fontClass\":\"icon-common46\",\"menu\":\"税务汇总分析管理\",\"unicode\":\"&#xef3d;\"}],\"frontMenu\":[{\"child\":[{\"appFrontIcon\":\"cuIcon-camera\",\"buttons\":[\"查看\"],\"classname\":\"news\",\"menu\":\"税务资讯\",\"menuJump\":\"列表\",\"tableName\":\"news\"}],\"menu\":\"税务资讯管理\"},{\"child\":[{\"appFrontIcon\":\"cuIcon-send\",\"buttons\":[\"查看\",\"新增\",\"修改\",\"删除\",\"申报操作\"],\"classname\":\"jichushuju\",\"menu\":\"基础数据\",\"menuJump\":\"列表\",\"tableName\":\"jichushuju\"}],\"menu\":\"基础数据管理\"}],\"hasBackLogin\":\"是\",\"hasBackRegister\":\"否\",\"hasFrontLogin\":\"否\",\"hasFrontRegister\":\"否\",\"pathName\":\"users\",\"roleName\":\"管理员\",\"tableName\":\"users\"}]');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `title` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '标题',
  `introduction` longtext COLLATE utf8mb4_unicode_ci COMMENT '简介',
  `picture` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图片',
  `content` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='税务资讯';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'2026-04-30 10:52:57','深圳恒达物流有限公司','印花税','file/news_深圳恒达物流有限公司1.jpg,file/news_深圳恒达物流有限公司2.jpg,file/news_深圳恒达物流有限公司3.jpg','深圳市宝安区税务局'),(2,'2026-04-30 10:52:57','沈阳和平区商贸有限公司','企业所得税','file/news_沈阳和平区商贸有限公司1.jpg,file/news_沈阳和平区商贸有限公司2.jpg,file/news_沈阳和平区商贸有限公司3.jpg','沈阳市和平区税务局'),(3,'2026-04-30 10:52:57','成都天府餐饮管理有限公司','个人所得税','file/news_成都天府餐饮管理有限公司1.jpg,file/news_成都天府餐饮管理有限公司2.jpg,file/news_成都天府餐饮管理有限公司3.jpg','成都市武侯区税务局'),(4,'2026-04-30 10:52:57','长沙湘江环保科技有限公司','消费税','file/news_长沙湘江环保科技有限公司1.jpg,file/news_长沙湘江环保科技有限公司2.jpg,file/news_长沙湘江环保科技有限公司3.jpg','长沙市雨花区税务局'),(5,'2026-04-30 10:52:57','天津滨海新区科创有限公司','增值税','file/news_天津滨海新区科创有限公司1.jpg,file/news_天津滨海新区科创有限公司2.jpg,file/news_天津滨海新区科创有限公司3.jpg','天津滨海新区税务局'),(6,'2026-04-30 10:52:57','南京宏图建筑工程有限公司','房产税','file/news_南京宏图建筑工程有限公司1.jpg,file/news_南京宏图建筑工程有限公司2.jpg,file/news_南京宏图建筑工程有限公司3.jpg','南京市秦淮区税务局'),(7,'2026-04-30 10:52:57','石家庄长安区科技有限公司','增值税','file/news_石家庄长安区科技有限公司1.jpg,file/news_石家庄长安区科技有限公司2.jpg,file/news_石家庄长安区科技有限公司3.jpg','石家庄市长安区税务局'),(8,'2026-04-30 10:52:57','济南历下区文化有限公司','印花税','file/news_济南历下区文化有限公司1.jpg,file/news_济南历下区文化有限公司2.jpg,file/news_济南历下区文化有限公司3.jpg','济南市历下区税务局'),(9,'2026-04-30 10:52:57','武汉长江运输有限公司','企业所得税','file/news_武汉长江运输有限公司1.jpg,file/news_武汉长江运输有限公司2.jpg,file/news_武汉长江运输有限公司3.jpg','武汉市江汉区税务局'),(10,'2026-04-30 10:52:57','长春朝阳汽车配件有限公司','房产税','file/news_长春朝阳汽车配件有限公司1.jpg,file/news_长春朝阳汽车配件有限公司2.jpg,file/news_长春朝阳汽车配件有限公司3.jpg','长春市朝阳区税务局');
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qianshuicuijiao`
--

DROP TABLE IF EXISTS `qianshuicuijiao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qianshuicuijiao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `nianfen` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '年份',
  `yuefen` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '月份',
  `xiaoxiangfapiao` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '销项发票',
  `jinxiangfapiao` longtext COLLATE utf8mb4_unicode_ci COMMENT '进项发票',
  `yingshou` double DEFAULT NULL COMMENT '营收',
  `chengbenfeiyong` double DEFAULT NULL COMMENT '成本费用',
  `shenbaoshijian` datetime DEFAULT NULL COMMENT '申报时间',
  `shenbaohuizhi` longtext COLLATE utf8mb4_unicode_ci COMMENT '申报回执',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `shuikuanjine` double DEFAULT NULL COMMENT '税款金额',
  `cuijiaoshijian` datetime DEFAULT NULL COMMENT '催缴时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='欠税催缴';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qianshuicuijiao`
--

LOCK TABLES `qianshuicuijiao` WRITE;
/*!40000 ALTER TABLE `qianshuicuijiao` DISABLE KEYS */;
INSERT INTO `qianshuicuijiao` VALUES (1,'2026-04-30 10:52:57','2014','六月','file/qianshuicuijiao_广告设计制作发票1.jpg,file/qianshuicuijiao_广告设计制作发票2.jpg,file/qianshuicuijiao_广告设计制作发票3.jpg','file/qianshuicuijiao_广告设计制作发票1.jpg,file/qianshuicuijiao_广告设计制作发票2.jpg,file/qianshuicuijiao_广告设计制作发票3.jpg',1,1,'2026-04-30 18:52:57','','拓普制造',1,'2026-04-30 18:52:57'),(2,'2026-04-30 10:52:57','2021','一月','file/qianshuicuijiao_物流运输服务发票1.jpg,file/qianshuicuijiao_物流运输服务发票2.jpg,file/qianshuicuijiao_物流运输服务发票3.jpg','file/qianshuicuijiao_物流运输服务发票1.jpg,file/qianshuicuijiao_物流运输服务发票2.jpg,file/qianshuicuijiao_物流运输服务发票3.jpg',2,2,'2026-04-30 18:52:57','','云境科技',2,'2026-04-30 18:52:57'),(3,'2026-04-30 10:52:57','2023','五月','file/qianshuicuijiao_软件开发服务发票1.jpg,file/qianshuicuijiao_软件开发服务发票2.jpg,file/qianshuicuijiao_软件开发服务发票3.jpg','file/qianshuicuijiao_软件开发服务发票1.jpg,file/qianshuicuijiao_软件开发服务发票2.jpg,file/qianshuicuijiao_软件开发服务发票3.jpg',3,3,'2026-04-30 18:52:57','','艺境设计',3,'2026-04-30 18:52:57'),(4,'2026-04-30 10:52:57','2018','八月','file/qianshuicuijiao_办公家具定制发票1.jpg,file/qianshuicuijiao_办公家具定制发票2.jpg,file/qianshuicuijiao_办公家具定制发票3.jpg','file/qianshuicuijiao_办公家具定制发票1.jpg,file/qianshuicuijiao_办公家具定制发票2.jpg,file/qianshuicuijiao_办公家具定制发票3.jpg',4,4,'2026-04-30 18:52:57','','星耀餐饮',4,'2026-04-30 18:52:57'),(5,'2026-04-30 10:52:57','2019','二月','file/qianshuicuijiao_办公用品采购发票1.jpg,file/qianshuicuijiao_办公用品采购发票2.jpg,file/qianshuicuijiao_办公用品采购发票3.jpg','file/qianshuicuijiao_办公用品采购发票1.jpg,file/qianshuicuijiao_办公用品采购发票2.jpg,file/qianshuicuijiao_办公用品采购发票3.jpg',5,5,'2026-04-30 18:52:57','','智联教育',5,'2026-04-30 18:52:57'),(6,'2026-04-30 10:52:57','2024','十一月','file/qianshuicuijiao_印刷制作服务发票1.jpg,file/qianshuicuijiao_印刷制作服务发票2.jpg,file/qianshuicuijiao_印刷制作服务发票3.jpg','file/qianshuicuijiao_印刷制作服务发票1.jpg,file/qianshuicuijiao_印刷制作服务发票2.jpg,file/qianshuicuijiao_印刷制作服务发票3.jpg',6,6,'2026-04-30 18:52:57','','创想广告',6,'2026-04-30 18:52:57'),(7,'2026-04-30 10:52:57','2017','十二月','file/qianshuicuijiao_音乐版权使用发票1.jpg,file/qianshuicuijiao_音乐版权使用发票2.jpg,file/qianshuicuijiao_音乐版权使用发票3.jpg','file/qianshuicuijiao_音乐版权使用发票1.jpg,file/qianshuicuijiao_音乐版权使用发票2.jpg,file/qianshuicuijiao_音乐版权使用发票3.jpg',7,7,'2026-04-30 18:52:57','','康益医疗',7,'2026-04-30 18:52:57'),(8,'2026-04-30 10:52:57','2015','四月','file/qianshuicuijiao_维修保养服务发票1.jpg,file/qianshuicuijiao_维修保养服务发票2.jpg,file/qianshuicuijiao_维修保养服务发票3.jpg','file/qianshuicuijiao_维修保养服务发票1.jpg,file/qianshuicuijiao_维修保养服务发票2.jpg,file/qianshuicuijiao_维修保养服务发票3.jpg',8,8,'2026-04-30 18:52:57','','晶彩珠宝',8,'2026-04-30 18:52:57'),(9,'2026-04-30 10:52:57','2020','九月','file/qianshuicuijiao_餐饮服务消费发票1.jpg,file/qianshuicuijiao_餐饮服务消费发票2.jpg,file/qianshuicuijiao_餐饮服务消费发票3.jpg','file/qianshuicuijiao_餐饮服务消费发票1.jpg,file/qianshuicuijiao_餐饮服务消费发票2.jpg,file/qianshuicuijiao_餐饮服务消费发票3.jpg',9,9,'2026-04-30 18:52:57','','乐活家居',9,'2026-04-30 18:52:57'),(10,'2026-04-30 10:52:57','2025','三月','file/qianshuicuijiao_图书采购发票1.jpg,file/qianshuicuijiao_图书采购发票2.jpg,file/qianshuicuijiao_图书采购发票3.jpg','file/qianshuicuijiao_图书采购发票1.jpg,file/qianshuicuijiao_图书采购发票2.jpg,file/qianshuicuijiao_图书采购发票3.jpg',10,10,'2026-04-30 18:52:57','','悦动健身',10,'2026-04-30 18:52:57');
/*!40000 ALTER TABLE `qianshuicuijiao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qiye`
--

DROP TABLE IF EXISTS `qiye`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qiye` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `qiyemingcheng` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '企业名称',
  `qiyedianhua` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '企业电话',
  `tongyishehuixinyongdaima` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '统一社会信用代码',
  `mima` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `xingyeleixing` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '行业类型',
  `touxiang` longtext COLLATE utf8mb4_unicode_ci COMMENT '头像',
  `max_password_wrong` int(11) NOT NULL DEFAULT '3' COMMENT '最大密码输错次数',
  `is_locked` int(11) NOT NULL DEFAULT '0' COMMENT '用户锁定状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `qiyemingcheng` (`qiyemingcheng`),
  UNIQUE KEY `tongyishehuixinyongdaima` (`tongyishehuixinyongdaima`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='企业';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qiye`
--

LOCK TABLES `qiye` WRITE;
/*!40000 ALTER TABLE `qiye` DISABLE KEYS */;
INSERT INTO `qiye` VALUES (91,'2026-04-30 10:52:57','拓普制造','19819881111','53010200000000000Y','123456','银行业','file/qiye_拓普制造1.jpg,file/qiye_拓普制造2.jpg,file/qiye_拓普制造3.jpg',1,0),(92,'2026-04-30 10:52:57','云境科技','19819881112','51010700000000000W','123456','白酒','file/qiye_云境科技1.jpg,file/qiye_云境科技2.jpg,file/qiye_云境科技3.jpg',2,0),(93,'2026-04-30 10:52:57','艺境设计','19819881113','36010200000000000O','123456','通信设备','file/qiye_艺境设计1.jpg,file/qiye_艺境设计2.jpg,file/qiye_艺境设计3.jpg',3,0),(94,'2026-04-30 10:52:57','星耀餐饮','19819881114','11500103000000000D','123456','白酒','file/qiye_星耀餐饮1.jpg,file/qiye_星耀餐饮2.jpg,file/qiye_星耀餐饮3.jpg',4,0),(95,'2026-04-30 10:52:57','智联教育','19819881115','41010500000000000Q','123456','白色家电','file/qiye_智联教育1.jpg,file/qiye_智联教育2.jpg,file/qiye_智联教育3.jpg',5,0),(96,'2026-04-30 10:52:57','创想广告','19819881116','52010300000000000X','123456','银行业','file/qiye_创想广告1.jpg,file/qiye_创想广告2.jpg,file/qiye_创想广告3.jpg',6,0),(97,'2026-04-30 10:52:57','康益医疗','19819881117','32010600000000000K','123456','房地产开发','file/qiye_康益医疗1.jpg,file/qiye_康益医疗2.jpg,file/qiye_康益医疗3.jpg',7,0),(98,'2026-04-30 10:52:57','晶彩珠宝','19819881118','34010300000000000M','123456','零售','file/qiye_晶彩珠宝1.jpg,file/qiye_晶彩珠宝2.jpg,file/qiye_晶彩珠宝3.jpg',8,0),(99,'2026-04-30 10:52:57','乐活家居','19819881119','14010700000000000F','123456','白色家电','file/qiye_乐活家居1.jpg,file/qiye_乐活家居2.jpg,file/qiye_乐活家居3.jpg',9,0),(100,'2026-04-30 10:52:57','悦动健身','198198811110','37010200000000000P','123456','半导体','file/qiye_悦动健身1.jpg,file/qiye_悦动健身2.jpg,file/qiye_悦动健身3.jpg',10,0);
/*!40000 ALTER TABLE `qiye` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `qiyexiangqing`
--

DROP TABLE IF EXISTS `qiyexiangqing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `qiyexiangqing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `qiyemingcheng` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `shuifuyichang` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '税负异常',
  `yuqishenbao` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '逾期申报',
  `fengxiandian` double DEFAULT NULL COMMENT '风险点',
  `chuangjianshijian` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='企业详情';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `qiyexiangqing`
--

LOCK TABLES `qiyexiangqing` WRITE;
/*!40000 ALTER TABLE `qiyexiangqing` DISABLE KEYS */;
INSERT INTO `qiyexiangqing` VALUES (1,'2026-04-30 10:52:58','拓普制造','是','是',1,'2026-04-30 18:52:58'),(2,'2026-04-30 10:52:58','云境科技','是','是',2,'2026-04-30 18:52:58'),(3,'2026-04-30 10:52:58','艺境设计','是','是',3,'2026-04-30 18:52:58'),(4,'2026-04-30 10:52:58','星耀餐饮','是','是',4,'2026-04-30 18:52:58'),(5,'2026-04-30 10:52:58','智联教育','是','是',5,'2026-04-30 18:52:58'),(6,'2026-04-30 10:52:58','创想广告','是','是',6,'2026-04-30 18:52:58'),(7,'2026-04-30 10:52:58','康益医疗','是','是',7,'2026-04-30 18:52:58'),(8,'2026-04-30 10:52:58','晶彩珠宝','是','是',8,'2026-04-30 18:52:58'),(9,'2026-04-30 10:52:58','乐活家居','是','是',9,'2026-04-30 18:52:58'),(10,'2026-04-30 10:52:58','悦动健身','是','是',10,'2026-04-30 18:52:58');
/*!40000 ALTER TABLE `qiyexiangqing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shenbaocaozuo`
--

DROP TABLE IF EXISTS `shenbaocaozuo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shenbaocaozuo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `nianfen` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '年份',
  `yuefen` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '月份',
  `xiaoxiangfapiao` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '销项发票',
  `jinxiangfapiao` longtext COLLATE utf8mb4_unicode_ci COMMENT '进项发票',
  `yingshou` double DEFAULT NULL COMMENT '营收',
  `chengbenfeiyong` double DEFAULT NULL COMMENT '成本费用',
  `caozuoshijian` datetime DEFAULT NULL COMMENT '操作时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='申报操作';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shenbaocaozuo`
--

LOCK TABLES `shenbaocaozuo` WRITE;
/*!40000 ALTER TABLE `shenbaocaozuo` DISABLE KEYS */;
INSERT INTO `shenbaocaozuo` VALUES (1,'2026-04-30 10:52:57','2014','六月','file/shenbaocaozuo_广告设计制作发票1.jpg,file/shenbaocaozuo_广告设计制作发票2.jpg,file/shenbaocaozuo_广告设计制作发票3.jpg','file/shenbaocaozuo_广告设计制作发票1.jpg,file/shenbaocaozuo_广告设计制作发票2.jpg,file/shenbaocaozuo_广告设计制作发票3.jpg',1,1,'2026-04-30 18:52:57','拓普制造'),(2,'2026-04-30 10:52:57','2021','一月','file/shenbaocaozuo_物流运输服务发票1.jpg,file/shenbaocaozuo_物流运输服务发票2.jpg,file/shenbaocaozuo_物流运输服务发票3.jpg','file/shenbaocaozuo_物流运输服务发票1.jpg,file/shenbaocaozuo_物流运输服务发票2.jpg,file/shenbaocaozuo_物流运输服务发票3.jpg',2,2,'2026-04-30 18:52:57','云境科技'),(3,'2026-04-30 10:52:57','2023','五月','file/shenbaocaozuo_软件开发服务发票1.jpg,file/shenbaocaozuo_软件开发服务发票2.jpg,file/shenbaocaozuo_软件开发服务发票3.jpg','file/shenbaocaozuo_软件开发服务发票1.jpg,file/shenbaocaozuo_软件开发服务发票2.jpg,file/shenbaocaozuo_软件开发服务发票3.jpg',3,3,'2026-04-30 18:52:57','艺境设计'),(4,'2026-04-30 10:52:57','2018','八月','file/shenbaocaozuo_办公家具定制发票1.jpg,file/shenbaocaozuo_办公家具定制发票2.jpg,file/shenbaocaozuo_办公家具定制发票3.jpg','file/shenbaocaozuo_办公家具定制发票1.jpg,file/shenbaocaozuo_办公家具定制发票2.jpg,file/shenbaocaozuo_办公家具定制发票3.jpg',4,4,'2026-04-30 18:52:57','星耀餐饮'),(5,'2026-04-30 10:52:57','2019','二月','file/shenbaocaozuo_办公用品采购发票1.jpg,file/shenbaocaozuo_办公用品采购发票2.jpg,file/shenbaocaozuo_办公用品采购发票3.jpg','file/shenbaocaozuo_办公用品采购发票1.jpg,file/shenbaocaozuo_办公用品采购发票2.jpg,file/shenbaocaozuo_办公用品采购发票3.jpg',5,5,'2026-04-30 18:52:57','智联教育'),(6,'2026-04-30 10:52:57','2024','十一月','file/shenbaocaozuo_印刷制作服务发票1.jpg,file/shenbaocaozuo_印刷制作服务发票2.jpg,file/shenbaocaozuo_印刷制作服务发票3.jpg','file/shenbaocaozuo_印刷制作服务发票1.jpg,file/shenbaocaozuo_印刷制作服务发票2.jpg,file/shenbaocaozuo_印刷制作服务发票3.jpg',6,6,'2026-04-30 18:52:57','创想广告'),(7,'2026-04-30 10:52:57','2017','十二月','file/shenbaocaozuo_音乐版权使用发票1.jpg,file/shenbaocaozuo_音乐版权使用发票2.jpg,file/shenbaocaozuo_音乐版权使用发票3.jpg','file/shenbaocaozuo_音乐版权使用发票1.jpg,file/shenbaocaozuo_音乐版权使用发票2.jpg,file/shenbaocaozuo_音乐版权使用发票3.jpg',7,7,'2026-04-30 18:52:57','康益医疗'),(8,'2026-04-30 10:52:57','2015','四月','file/shenbaocaozuo_维修保养服务发票1.jpg,file/shenbaocaozuo_维修保养服务发票2.jpg,file/shenbaocaozuo_维修保养服务发票3.jpg','file/shenbaocaozuo_维修保养服务发票1.jpg,file/shenbaocaozuo_维修保养服务发票2.jpg,file/shenbaocaozuo_维修保养服务发票3.jpg',8,8,'2026-04-30 18:52:57','晶彩珠宝'),(9,'2026-04-30 10:52:57','2020','九月','file/shenbaocaozuo_餐饮服务消费发票1.jpg,file/shenbaocaozuo_餐饮服务消费发票2.jpg,file/shenbaocaozuo_餐饮服务消费发票3.jpg','file/shenbaocaozuo_餐饮服务消费发票1.jpg,file/shenbaocaozuo_餐饮服务消费发票2.jpg,file/shenbaocaozuo_餐饮服务消费发票3.jpg',9,9,'2026-04-30 18:52:57','乐活家居'),(10,'2026-04-30 10:52:57','2025','三月','file/shenbaocaozuo_图书采购发票1.jpg,file/shenbaocaozuo_图书采购发票2.jpg,file/shenbaocaozuo_图书采购发票3.jpg','file/shenbaocaozuo_图书采购发票1.jpg,file/shenbaocaozuo_图书采购发票2.jpg,file/shenbaocaozuo_图书采购发票3.jpg',10,10,'2026-04-30 18:52:57','悦动健身');
/*!40000 ALTER TABLE `shenbaocaozuo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shenbaohuizhi`
--

DROP TABLE IF EXISTS `shenbaohuizhi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shenbaohuizhi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `nianfen` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '年份',
  `yuefen` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '月份',
  `xiaoxiangfapiao` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '销项发票',
  `jinxiangfapiao` longtext COLLATE utf8mb4_unicode_ci COMMENT '进项发票',
  `yingshou` double DEFAULT NULL COMMENT '营收',
  `chengbenfeiyong` double DEFAULT NULL COMMENT '成本费用',
  `shenbaoshijian` datetime DEFAULT NULL COMMENT '申报时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `shenbaohuizhi` longtext COLLATE utf8mb4_unicode_ci COMMENT '申报回执',
  `beizhu` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='申报回执';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shenbaohuizhi`
--

LOCK TABLES `shenbaohuizhi` WRITE;
/*!40000 ALTER TABLE `shenbaohuizhi` DISABLE KEYS */;
INSERT INTO `shenbaohuizhi` VALUES (1,'2026-04-30 10:52:57','2014','六月','file/shenbaohuizhi_广告设计制作发票1.jpg,file/shenbaohuizhi_广告设计制作发票2.jpg,file/shenbaohuizhi_广告设计制作发票3.jpg','file/shenbaohuizhi_广告设计制作发票1.jpg,file/shenbaohuizhi_广告设计制作发票2.jpg,file/shenbaohuizhi_广告设计制作发票3.jpg',1,1,'2026-04-30 18:52:57','拓普制造','','备注1'),(2,'2026-04-30 10:52:57','2021','一月','file/shenbaohuizhi_物流运输服务发票1.jpg,file/shenbaohuizhi_物流运输服务发票2.jpg,file/shenbaohuizhi_物流运输服务发票3.jpg','file/shenbaohuizhi_物流运输服务发票1.jpg,file/shenbaohuizhi_物流运输服务发票2.jpg,file/shenbaohuizhi_物流运输服务发票3.jpg',2,2,'2026-04-30 18:52:57','云境科技','','备注2'),(3,'2026-04-30 10:52:57','2023','五月','file/shenbaohuizhi_软件开发服务发票1.jpg,file/shenbaohuizhi_软件开发服务发票2.jpg,file/shenbaohuizhi_软件开发服务发票3.jpg','file/shenbaohuizhi_软件开发服务发票1.jpg,file/shenbaohuizhi_软件开发服务发票2.jpg,file/shenbaohuizhi_软件开发服务发票3.jpg',3,3,'2026-04-30 18:52:57','艺境设计','','备注3'),(4,'2026-04-30 10:52:57','2018','八月','file/shenbaohuizhi_办公家具定制发票1.jpg,file/shenbaohuizhi_办公家具定制发票2.jpg,file/shenbaohuizhi_办公家具定制发票3.jpg','file/shenbaohuizhi_办公家具定制发票1.jpg,file/shenbaohuizhi_办公家具定制发票2.jpg,file/shenbaohuizhi_办公家具定制发票3.jpg',4,4,'2026-04-30 18:52:57','星耀餐饮','','备注4'),(5,'2026-04-30 10:52:57','2019','二月','file/shenbaohuizhi_办公用品采购发票1.jpg,file/shenbaohuizhi_办公用品采购发票2.jpg,file/shenbaohuizhi_办公用品采购发票3.jpg','file/shenbaohuizhi_办公用品采购发票1.jpg,file/shenbaohuizhi_办公用品采购发票2.jpg,file/shenbaohuizhi_办公用品采购发票3.jpg',5,5,'2026-04-30 18:52:57','智联教育','','备注5'),(6,'2026-04-30 10:52:57','2024','十一月','file/shenbaohuizhi_印刷制作服务发票1.jpg,file/shenbaohuizhi_印刷制作服务发票2.jpg,file/shenbaohuizhi_印刷制作服务发票3.jpg','file/shenbaohuizhi_印刷制作服务发票1.jpg,file/shenbaohuizhi_印刷制作服务发票2.jpg,file/shenbaohuizhi_印刷制作服务发票3.jpg',6,6,'2026-04-30 18:52:57','创想广告','','备注6'),(7,'2026-04-30 10:52:57','2017','十二月','file/shenbaohuizhi_音乐版权使用发票1.jpg,file/shenbaohuizhi_音乐版权使用发票2.jpg,file/shenbaohuizhi_音乐版权使用发票3.jpg','file/shenbaohuizhi_音乐版权使用发票1.jpg,file/shenbaohuizhi_音乐版权使用发票2.jpg,file/shenbaohuizhi_音乐版权使用发票3.jpg',7,7,'2026-04-30 18:52:57','康益医疗','','备注7'),(8,'2026-04-30 10:52:57','2015','四月','file/shenbaohuizhi_维修保养服务发票1.jpg,file/shenbaohuizhi_维修保养服务发票2.jpg,file/shenbaohuizhi_维修保养服务发票3.jpg','file/shenbaohuizhi_维修保养服务发票1.jpg,file/shenbaohuizhi_维修保养服务发票2.jpg,file/shenbaohuizhi_维修保养服务发票3.jpg',8,8,'2026-04-30 18:52:57','晶彩珠宝','','备注8'),(9,'2026-04-30 10:52:57','2020','九月','file/shenbaohuizhi_餐饮服务消费发票1.jpg,file/shenbaohuizhi_餐饮服务消费发票2.jpg,file/shenbaohuizhi_餐饮服务消费发票3.jpg','file/shenbaohuizhi_餐饮服务消费发票1.jpg,file/shenbaohuizhi_餐饮服务消费发票2.jpg,file/shenbaohuizhi_餐饮服务消费发票3.jpg',9,9,'2026-04-30 18:52:57','乐活家居','','备注9'),(10,'2026-04-30 10:52:57','2025','三月','file/shenbaohuizhi_图书采购发票1.jpg,file/shenbaohuizhi_图书采购发票2.jpg,file/shenbaohuizhi_图书采购发票3.jpg','file/shenbaohuizhi_图书采购发票1.jpg,file/shenbaohuizhi_图书采购发票2.jpg,file/shenbaohuizhi_图书采购发票3.jpg',10,10,'2026-04-30 18:52:57','悦动健身','','备注10');
/*!40000 ALTER TABLE `shenbaohuizhi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shuikuanjiaona`
--

DROP TABLE IF EXISTS `shuikuanjiaona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shuikuanjiaona` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `nianfen` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '年份',
  `yuefen` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '月份',
  `xiaoxiangfapiao` longtext COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '销项发票',
  `jinxiangfapiao` longtext COLLATE utf8mb4_unicode_ci COMMENT '进项发票',
  `yingshou` double DEFAULT NULL COMMENT '营收',
  `chengbenfeiyong` double DEFAULT NULL COMMENT '成本费用',
  `shenbaoshijian` datetime DEFAULT NULL COMMENT '申报时间',
  `wanshuipingzheng` longtext COLLATE utf8mb4_unicode_ci COMMENT '完税凭证',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `shuikuanjine` double DEFAULT NULL COMMENT '税款金额',
  `reversetime` datetime DEFAULT NULL COMMENT '失效时间',
  `ispay` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '未支付' COMMENT '是否支付',
  `zongfeiyong` double DEFAULT NULL COMMENT '总费用',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='税款缴纳';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shuikuanjiaona`
--

LOCK TABLES `shuikuanjiaona` WRITE;
/*!40000 ALTER TABLE `shuikuanjiaona` DISABLE KEYS */;
INSERT INTO `shuikuanjiaona` VALUES (1,'2026-04-30 10:52:57','2014','六月','file/shuikuanjiaona_广告设计制作发票1.jpg,file/shuikuanjiaona_广告设计制作发票2.jpg,file/shuikuanjiaona_广告设计制作发票3.jpg','file/shuikuanjiaona_广告设计制作发票1.jpg,file/shuikuanjiaona_广告设计制作发票2.jpg,file/shuikuanjiaona_广告设计制作发票3.jpg',1,1,'2026-04-30 18:52:57','','拓普制造',1,'2026-05-01 00:00:00','未支付',1,1,1),(2,'2026-04-30 10:52:57','2021','一月','file/shuikuanjiaona_物流运输服务发票1.jpg,file/shuikuanjiaona_物流运输服务发票2.jpg,file/shuikuanjiaona_物流运输服务发票3.jpg','file/shuikuanjiaona_物流运输服务发票1.jpg,file/shuikuanjiaona_物流运输服务发票2.jpg,file/shuikuanjiaona_物流运输服务发票3.jpg',2,2,'2026-04-30 18:52:57','','云境科技',2,'2026-05-01 00:00:00','未支付',2,2,2),(3,'2026-04-30 10:52:57','2023','五月','file/shuikuanjiaona_软件开发服务发票1.jpg,file/shuikuanjiaona_软件开发服务发票2.jpg,file/shuikuanjiaona_软件开发服务发票3.jpg','file/shuikuanjiaona_软件开发服务发票1.jpg,file/shuikuanjiaona_软件开发服务发票2.jpg,file/shuikuanjiaona_软件开发服务发票3.jpg',3,3,'2026-04-30 18:52:57','','艺境设计',3,'2026-05-01 00:00:00','未支付',3,3,3),(4,'2026-04-30 10:52:57','2018','八月','file/shuikuanjiaona_办公家具定制发票1.jpg,file/shuikuanjiaona_办公家具定制发票2.jpg,file/shuikuanjiaona_办公家具定制发票3.jpg','file/shuikuanjiaona_办公家具定制发票1.jpg,file/shuikuanjiaona_办公家具定制发票2.jpg,file/shuikuanjiaona_办公家具定制发票3.jpg',4,4,'2026-04-30 18:52:57','','星耀餐饮',4,'2026-05-01 00:00:00','未支付',4,4,4),(5,'2026-04-30 10:52:57','2019','二月','file/shuikuanjiaona_办公用品采购发票1.jpg,file/shuikuanjiaona_办公用品采购发票2.jpg,file/shuikuanjiaona_办公用品采购发票3.jpg','file/shuikuanjiaona_办公用品采购发票1.jpg,file/shuikuanjiaona_办公用品采购发票2.jpg,file/shuikuanjiaona_办公用品采购发票3.jpg',5,5,'2026-04-30 18:52:57','','智联教育',5,'2026-05-01 00:00:00','未支付',5,5,5),(6,'2026-04-30 10:52:57','2024','十一月','file/shuikuanjiaona_印刷制作服务发票1.jpg,file/shuikuanjiaona_印刷制作服务发票2.jpg,file/shuikuanjiaona_印刷制作服务发票3.jpg','file/shuikuanjiaona_印刷制作服务发票1.jpg,file/shuikuanjiaona_印刷制作服务发票2.jpg,file/shuikuanjiaona_印刷制作服务发票3.jpg',6,6,'2026-04-30 18:52:57','','创想广告',6,'2026-05-01 00:00:00','未支付',6,6,6),(7,'2026-04-30 10:52:57','2017','十二月','file/shuikuanjiaona_音乐版权使用发票1.jpg,file/shuikuanjiaona_音乐版权使用发票2.jpg,file/shuikuanjiaona_音乐版权使用发票3.jpg','file/shuikuanjiaona_音乐版权使用发票1.jpg,file/shuikuanjiaona_音乐版权使用发票2.jpg,file/shuikuanjiaona_音乐版权使用发票3.jpg',7,7,'2026-04-30 18:52:57','','康益医疗',7,'2026-05-01 00:00:00','未支付',7,7,7),(8,'2026-04-30 10:52:57','2015','四月','file/shuikuanjiaona_维修保养服务发票1.jpg,file/shuikuanjiaona_维修保养服务发票2.jpg,file/shuikuanjiaona_维修保养服务发票3.jpg','file/shuikuanjiaona_维修保养服务发票1.jpg,file/shuikuanjiaona_维修保养服务发票2.jpg,file/shuikuanjiaona_维修保养服务发票3.jpg',8,8,'2026-04-30 18:52:57','','晶彩珠宝',8,'2026-05-01 00:00:00','未支付',8,8,8),(9,'2026-04-30 10:52:57','2020','九月','file/shuikuanjiaona_餐饮服务消费发票1.jpg,file/shuikuanjiaona_餐饮服务消费发票2.jpg,file/shuikuanjiaona_餐饮服务消费发票3.jpg','file/shuikuanjiaona_餐饮服务消费发票1.jpg,file/shuikuanjiaona_餐饮服务消费发票2.jpg,file/shuikuanjiaona_餐饮服务消费发票3.jpg',9,9,'2026-04-30 18:52:57','','乐活家居',9,'2026-05-01 00:00:00','未支付',9,9,9),(10,'2026-04-30 10:52:57','2025','三月','file/shuikuanjiaona_图书采购发票1.jpg,file/shuikuanjiaona_图书采购发票2.jpg,file/shuikuanjiaona_图书采购发票3.jpg','file/shuikuanjiaona_图书采购发票1.jpg,file/shuikuanjiaona_图书采购发票2.jpg,file/shuikuanjiaona_图书采购发票3.jpg',10,10,'2026-04-30 18:52:57','','悦动健身',10,'2026-05-01 00:00:00','未支付',10,10,10);
/*!40000 ALTER TABLE `shuikuanjiaona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shuiwuhuizongfenxi`
--

DROP TABLE IF EXISTS `shuiwuhuizongfenxi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shuiwuhuizongfenxi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `qiyeyuedu` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业月度',
  `niandushuiwuhuizongbaobiao` longtext COLLATE utf8mb4_unicode_ci COMMENT '年度税务汇总报表',
  `shuifubianhua` longtext COLLATE utf8mb4_unicode_ci COMMENT '税负变化',
  `shenbaotongguolv` double DEFAULT NULL COMMENT '申报通过率',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='税务汇总分析';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shuiwuhuizongfenxi`
--

LOCK TABLES `shuiwuhuizongfenxi` WRITE;
/*!40000 ALTER TABLE `shuiwuhuizongfenxi` DISABLE KEYS */;
INSERT INTO `shuiwuhuizongfenxi` VALUES (1,'2026-04-30 10:52:58','六月','年度税务汇总报表1','税负变化1',1,'拓普制造'),(2,'2026-04-30 10:52:58','一月','年度税务汇总报表2','税负变化2',2,'云境科技'),(3,'2026-04-30 10:52:58','五月','年度税务汇总报表3','税负变化3',3,'艺境设计'),(4,'2026-04-30 10:52:58','八月','年度税务汇总报表4','税负变化4',4,'星耀餐饮'),(5,'2026-04-30 10:52:58','二月','年度税务汇总报表5','税负变化5',5,'智联教育'),(6,'2026-04-30 10:52:58','十一月','年度税务汇总报表6','税负变化6',6,'创想广告'),(7,'2026-04-30 10:52:58','十二月','年度税务汇总报表7','税负变化7',7,'康益医疗'),(8,'2026-04-30 10:52:58','四月','年度税务汇总报表8','税负变化8',8,'晶彩珠宝'),(9,'2026-04-30 10:52:58','九月','年度税务汇总报表9','税负变化9',9,'乐活家居'),(10,'2026-04-30 10:52:58','三月','年度税务汇总报表10','税负变化10',10,'悦动健身');
/*!40000 ALTER TABLE `shuiwuhuizongfenxi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `syslog`
--

DROP TABLE IF EXISTS `syslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `operation` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户操作',
  `method` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '请求方法',
  `params` longtext COLLATE utf8mb4_unicode_ci COMMENT '请求参数',
  `time` bigint(20) DEFAULT NULL COMMENT '请求时长(毫秒)',
  `ip` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'ip地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='操作日志';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `syslog`
--

LOCK TABLES `syslog` WRITE;
/*!40000 ALTER TABLE `syslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `syslog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_notice`
--

DROP TABLE IF EXISTS `system_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `system_notice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `content` longtext COLLATE utf8mb4_unicode_ci COMMENT '公告内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='系统公告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_notice`
--

LOCK TABLES `system_notice` WRITE;
/*!40000 ALTER TABLE `system_notice` DISABLE KEYS */;
INSERT INTO `system_notice` VALUES (1,'2026-04-30 10:52:57','公告信息...');
/*!40000 ALTER TABLE `system_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `token` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `tablename` varchar(100) DEFAULT NULL COMMENT '表名',
  `role` varchar(100) DEFAULT NULL COMMENT '角色',
  `token` varchar(500) NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='token表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `username` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `role` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '管理员' COMMENT '角色',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='管理员';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2026-04-30 10:52:58','admin','admin','管理员');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `xingyeleixing`
--

DROP TABLE IF EXISTS `xingyeleixing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `xingyeleixing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `xingyeleixing` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '行业类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='行业类型';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `xingyeleixing`
--

LOCK TABLES `xingyeleixing` WRITE;
/*!40000 ALTER TABLE `xingyeleixing` DISABLE KEYS */;
INSERT INTO `xingyeleixing` VALUES (1,'2026-04-30 10:52:57','银行业'),(2,'2026-04-30 10:52:57','白酒'),(3,'2026-04-30 10:52:57','通信设备'),(4,'2026-04-30 10:52:57','白酒'),(5,'2026-04-30 10:52:57','白色家电'),(6,'2026-04-30 10:52:57','银行业'),(7,'2026-04-30 10:52:57','房地产开发'),(8,'2026-04-30 10:52:57','零售'),(9,'2026-04-30 10:52:57','白色家电'),(10,'2026-04-30 10:52:57','半导体');
/*!40000 ALTER TABLE `xingyeleixing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ziliaoguidang`
--

DROP TABLE IF EXISTS `ziliaoguidang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ziliaoguidang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shuiwuhetong` longtext COLLATE utf8mb4_unicode_ci COMMENT '税务合同',
  `fujianpingzheng` longtext COLLATE utf8mb4_unicode_ci COMMENT '附件凭证',
  `shangchuanshijian` datetime DEFAULT NULL COMMENT '上传时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `guidangshijian` datetime DEFAULT NULL COMMENT '归档时间',
  `crossuserid` bigint(20) DEFAULT NULL COMMENT '跨表用户id',
  `crossrefid` bigint(20) DEFAULT NULL COMMENT '跨表主键id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资料归档';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ziliaoguidang`
--

LOCK TABLES `ziliaoguidang` WRITE;
/*!40000 ALTER TABLE `ziliaoguidang` DISABLE KEYS */;
INSERT INTO `ziliaoguidang` VALUES (1,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','拓普制造','2026-04-30 18:52:57',1,1),(2,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','云境科技','2026-04-30 18:52:57',2,2),(3,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','艺境设计','2026-04-30 18:52:57',3,3),(4,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','星耀餐饮','2026-04-30 18:52:57',4,4),(5,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','智联教育','2026-04-30 18:52:57',5,5),(6,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','创想广告','2026-04-30 18:52:57',6,6),(7,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','康益医疗','2026-04-30 18:52:57',7,7),(8,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','晶彩珠宝','2026-04-30 18:52:57',8,8),(9,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','乐活家居','2026-04-30 18:52:57',9,9),(10,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','悦动健身','2026-04-30 18:52:57',10,10);
/*!40000 ALTER TABLE `ziliaoguidang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ziliaoshangchuan`
--

DROP TABLE IF EXISTS `ziliaoshangchuan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ziliaoshangchuan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `shuiwuhetong` longtext COLLATE utf8mb4_unicode_ci COMMENT '税务合同',
  `fujianpingzheng` longtext COLLATE utf8mb4_unicode_ci COMMENT '附件凭证',
  `shangchuanshijian` datetime DEFAULT NULL COMMENT '上传时间',
  `qiyemingcheng` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `sfsh` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT '待审核' COMMENT '是否审核',
  `shhf` longtext COLLATE utf8mb4_unicode_ci COMMENT '回复内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='资料上传';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ziliaoshangchuan`
--

LOCK TABLES `ziliaoshangchuan` WRITE;
/*!40000 ALTER TABLE `ziliaoshangchuan` DISABLE KEYS */;
INSERT INTO `ziliaoshangchuan` VALUES (1,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','拓普制造','是',''),(2,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','云境科技','是',''),(3,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','艺境设计','是',''),(4,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','星耀餐饮','是',''),(5,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','智联教育','是',''),(6,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','创想广告','是',''),(7,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','康益医疗','是',''),(8,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','晶彩珠宝','是',''),(9,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','乐活家居','是',''),(10,'2026-04-30 10:52:57','','','2026-04-30 18:52:57','悦动健身','是','');
/*!40000 ALTER TABLE `ziliaoshangchuan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-01 12:04:54
