CREATE TABLE github_repository (`id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, `html_url` VARCHAR(255) NOT NULL, `name` VARCHAR(100) NOT NULL, `description` VARCHAR(255), `language` VARCHAR(16));

CREATE USER 'app'@'%' IDENTIFIED BY 'yw!424%dsgerq';

GRANT SELECT, INSERT, UPDATE ON `github`.`github_repository` TO `app`@`%`;