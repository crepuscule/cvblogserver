DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `nickname` varchar(64) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `email` varchar(64) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `regtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `user`(username,nickname,password,enabled,email,avatar,regtime) VALUES ('crepuscule', 'crepuscule', '202cb962ac59075b964b07152d234b70', '1', 'twilight_wang@163.com', '', '2017-12-08 09:30:22');

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `description`   varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `roles`(name) VALUES ('超级管理员');
INSERT INTO `roles`(name) VALUES ('管理员');
INSERT INTO `roles`(name) VALUES ( '普通用户');
INSERT INTO `roles`(name)  VALUES ( '游客');


DROP TABLE IF EXISTS `roles_user`;
CREATE TABLE `roles_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL DEFAULT '3',
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `uid` (`uid`),
  CONSTRAINT `roles_user_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `roles` (`id`),
  CONSTRAINT `roles_user_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `roles_user`(rid,uid) VALUES ('1', '1');


DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NOT NULL ,
  `catename` varchar(64) NOT NULL,
  `description`   varchar(255) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
INSERT INTO `category`(pid,catename) VALUES ('-1', '机器学习');
INSERT INTO `category`(pid,catename) VALUES ('1','监督学习');


DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(32) NOT NULL,
  `description`   varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `tagName` (`tagName`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;
INSERT INTO `tags`(tagName) VALUES ('支持向量机');
INSERT INTO `tags`(tagName) VALUES ('神经网络');


DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `mdContent` text COMMENT 'md文件源码',
  `htmlContent` text COMMENT 'html源码',
  `summary` text,
  `cid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `publishtime` datetime DEFAULT NULL,
  `edittime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '0表示草稿箱，1表示已发表，2表示已删除',
  `pageView` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `cid` (`cid`),
  KEY `uid` (`uid`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`),
  CONSTRAINT `article_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

INSERT INTO `article`(title,mdContent,htmlContent,summary,cid,uid,publishtime,edittime,state,pageview) VALUES('Linux中安装zookeeper', '最近打算出一个系列，介绍Dubbo的使用。','最近打算出一个系列，介绍Dubbo的使用。','安装zookeeper','2','1','2017-12-24 09:34:29','2017-12-24 09:34:29','1','5');


DROP TABLE IF EXISTS `article_tags`;
CREATE TABLE `article_tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) NOT NULL,
  `tid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tid` (`tid`),
  KEY `aid` (`aid`),
  CONSTRAINT `article_tags_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `article` (`id`) ON DELETE CASCADE,
  CONSTRAINT `article_tags_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `tags` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `article_tags`(aid,tid) VALUES ('1', '1');
INSERT INTO `article_tags`(aid,tid) VALUES ( '1', '2');



DROP TABLE IF EXISTS `attachments`;
CREATE TABLE `attachments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `type` varchar(64) NOT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `attachments`(`name` ,`type` ,`address` ) VALUES ('1.png', 'img','www.crepuscule.xyz/images/1.png');
