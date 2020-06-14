CREATE DATABASE IF NOT EXISTS `url_directory`;
use `url_directory`;

DROP table if exists `url_details`;

create table `url_details`( 
 `id` int(11) NOT NULL auto_increment,
 `orignal_url` varchar(200)  default null,
 `short_url` varchar(45)  default null,
 `last_hit` datetime default null,
`ip_address` varchar(45) default null,
`created_by` int(11) default null,
`created_date` datetime default null,
PRIMARY KEY(`id`))
ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET= latin1;

insert into `url_details` value
(1,'https://www.natgeokids.com/ie/discover/animals/general-animals/elephant-facts/', '9d26af0a', now(), '127.0.0.1', 1, now() );