
DROP DATABASE IF EXISTS app_db;
CREATE DATABASE app_db;
USE app_db;

DROP USER IF EXISTS app_user;
CREATE USER 'app_user'@'%' IDENTIFIED WITH mysql_native_password BY 'qwerty';
GRANT USAGE ON *.* TO 'app_user'@'%';
GRANT ALL PRIVILEGES ON app_db . * TO 'app_user'@'%';
FLUSH PRIVILEGES;
