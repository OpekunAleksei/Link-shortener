create schema if not exists linkshortener;
use linkshortener;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY  (`login`),
  UNIQUE KEY (`password`)
) ;
CREATE TABLE `links` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `shortLink` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `views` int(11) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY  (`user_id`),
  CONSTRAINT FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);CREATE TABLE `tags` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY  (`title`)
) ;
CREATE TABLE `link_tags` (
  `link_id` bigint(20) NOT NULL,
  `tag_id` bigint(20) NOT NULL,
  KEY `FKmqp0dbmv0hjevv6tn3xbl8jpk` (`tag_id`),
  KEY `FK297tsud8ad8vvfw1tv1gi4495` (`link_id`),
  CONSTRAINT  FOREIGN KEY (`link_id`) REFERENCES `links` (`id`),
  CONSTRAINT  FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`)
)