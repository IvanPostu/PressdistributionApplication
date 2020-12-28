
DROP DATABASE IF EXISTS destribution_db;
CREATE DATABASE destribution_db;
USE destribution_db;

DROP USER IF EXISTS app_user;
CREATE USER 'app_user'@'%' IDENTIFIED WITH mysql_native_password BY 'qwerty';
GRANT USAGE ON *.* TO 'app_user'@'%';
GRANT ALL PRIVILEGES ON destribution_db . * TO 'app_user'@'%';
FLUSH PRIVILEGES;
