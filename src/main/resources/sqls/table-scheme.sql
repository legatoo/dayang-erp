DROP TABLE  `customer`;
CREATE TABLE `customer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `wxId` VARCHAR(60) DEFAULT '' COMMENT '微信ID',
  `wxName` VARCHAR(60) DEFAULT '' COMMENT '微信名',
  `chineseName` VARCHAR(20) DEFAULT '' COMMENT '中文名',
  `mobile` VARCHAR(11) DEFAULT '' COMMENT '用户手机',
  `gender` INT(1) DEFAULT 0 COMMENT '用户性别 0=女 1=男',
  `cityId` INT(11) DEFAULT 0 COMMENT '城市ID',
  `address` VARCHAR(120) DEFAULT '' COMMENT '常住住址',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='顾客信息';

DROP TABLE `appointment`;
CREATE TABLE `appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) NOT NULL COMMENT '用户ID',
  `customerName` VARCHAR(20) DEFAULT '' COMMENT '用户中文名',
  `contactMobile` varchar(11) NOT NULL COMMENT '联系手机',
  `provinceId` INT(11) DEFAULT  0 COMMENT '省ID',
  `provinceName` VARCHAR(30) DEFAULT  0 COMMENT '省名',
  `cityId` INT(11) DEFAULT 0 COMMENT '城市ID',
  `cityName` VARCHAR(30) DEFAULT 0 COMMENT '城市名',
  `address` VARCHAR(250) NOT NULL COMMENT '上门地址',
  `appointmentDay` datetime NOT NULL COMMENT '预约时间(哪天)',
  `hourBegin` VARCHAR(10) NOT NULL COMMENT '预约时间开始 HH:mm',
  `hourEnd` VARCHAR(10) NOT NULL COMMENT '预约时间结束 HH:mm',
  `status` TINYINT(3) DEFAULT 0 COMMENT '预约状态 0=创建 1=进行中 2=已完成',
  `comment` VARCHAR(1024) DEFAULT '' COMMENT '预约单备注',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约信息';

DROP TABLE `system_admin`;
CREATE TABLE `system_admin` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `loginName` VARCHAR(50) NOT NULL COMMENT '登录用户名',
  `secret` VARCHAR(500) NOT NULL COMMENT '加密后的登录密码',
  `status` TINYINT(3) DEFAULT 1 COMMENT '账户状态 1=开启  0=禁用',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统管理员用户';