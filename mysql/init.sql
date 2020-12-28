
DROP DATABASE IF EXISTS app;
CREATE DATABASE app;
USE app;

DROP USER IF EXISTS app_user;
CREATE USER 'app_user'@'%' IDENTIFIED WITH mysql_native_password BY 'qwerty';
GRANT USAGE ON *.* TO 'app_user'@'%';
GRANT ALL PRIVILEGES ON app . * TO 'app_user'@'%';
FLUSH PRIVILEGES;
