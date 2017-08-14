DROP TABLE  `customer`;
CREATE TABLE `customer` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `wxId` VARCHAR(60) DEFAULT '' COMMENT '微信ID',
  `wxName` VARCHAR(60) DEFAULT '' COMMENT '微信名',
  `chineseName` VARCHAR(20) DEFAULT '' COMMENT '中文名',
  `mobile` VARCHAR(11) DEFAULT '' COMMENT '用户手机',
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
  `contactMobile` varchar(11) NOT NULL COMMENT '联系手机',
  `cityId` INT(11) DEFAULT 0 COMMENT '城市ID',
  `address` VARCHAR(250) NOT NULL COMMENT '上门地址',
  `appointmentTime` datetime NOT NULL COMMENT '预约时间',
  `status` TINYINT(3) DEFAULT 0 COMMENT '预约状态 0=创建 1=进行中 2=已完成',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约信息';