-- Используется для примера/тестов подключения сторонней базы данных
drop schema if exists newprojecttest;
create schema newprojecttest;
use newprojecttest;
ALTER DATABASE newprojecttest CHARACTER SET utf8 COLLATE utf8_general_ci;
grant all privileges on newprojecttest.* to 'newproject'@'localhost' identified by '548548';
grant all privileges on newprojecttest.* to 'newproject'@'%' identified by '548548';
CREATE TABLE `test` (`ID` INT NOT NULL,	`USERNAME` VARCHAR(255) NOT NULL DEFAULT '', PRIMARY KEY (`ID`));
INSERT INTO `newprojecttest`.`test` (`ID`, `USERNAME`) VALUES ('1', 'testusername');
