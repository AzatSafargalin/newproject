drop schema if exists newproject;
create schema newproject;
use newproject;
ALTER DATABASE newproject CHARACTER SET utf8 COLLATE utf8_general_ci;
grant all privileges on newproject.* to 'newproject'@'localhost' identified by '548548';
grant all privileges on newproject.* to 'newproject'@'%' identified by '548548';
