CREATE TABLE `host` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hostname` varchar(64) NOT NULL,
  `ip` varchar(16) NOT NULL,
  `wan_ip` varchar(16) NOT NULL COMMENT 'WAN IP, 外网IP',
  `cpu_quota` int(11) DEFAULT NULL COMMENT 'cpu核数',
  `mem_quota` int(11) DEFAULT NULL COMMENT '内存大小, MB',
  `system_disk_quota` int(11) DEFAULT NULL COMMENT '系统分区大小，MB',
  `home_disk_quota` int(11) DEFAULT NULL COMMENT 'home分区大小, MB',
  `idc` varchar(32) NOT NULL COMMENT '机房',
  PRIMARY KEY (`id`,`hostname`,`ip`),
  UNIQUE KEY `hostname_UNIQUE` (`hostname`),
  UNIQUE KEY `ip_UNIQUE` (`id`),
  UNIQUE KEY `wan_ip_UNIQUE` (`wan_ip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


