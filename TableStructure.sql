CREATE TABLE `userdatas` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `usr_key` varchar(255) NOT NULL,
  `usr_value` varchar(255) NOT NULL DEFAULT '',
  `user_id` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `users` (
  `usrid` mediumint(9) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL DEFAULT '''',
  `user_id` varchar(30) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `email_id` varchar(30) NOT NULL DEFAULT '''',
  `phoneNo` varchar(20) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  PRIMARY KEY (`usrid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;