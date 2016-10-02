# fsn_demo_test
fsn twitter demo

DB Table List

CREATE TABLE `tw_twit_info` (
  `twit_idx` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `twit_content` text NOT NULL,
  `twit_wr_user_idx` int(11) NOT NULL,
  `twit_wr_date` datetime NOT NULL,
  `twit_del_flag` char(1) DEFAULT 'N',
  PRIMARY KEY (`twit_idx`),
  KEY `wt_user_idx_IDX` (`twit_wr_user_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tw_user_info` (
  `user_idx` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) NOT NULL DEFAULT '',
  `user_password` varchar(50) NOT NULL DEFAULT '',
  `user_name` varchar(50) NOT NULL DEFAULT '',
  `user_reg_date` datetime NOT NULL,
  PRIMARY KEY (`user_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tw_user_relation_info` (
  `relation_idx` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_idx` int(11) NOT NULL,
  `friend_user_idxs` text,
  PRIMARY KEY (`relation_idx`),
  UNIQUE KEY `User_idx_Uni` (`user_idx`),
  KEY `user_idx_INDEX` (`user_idx`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;