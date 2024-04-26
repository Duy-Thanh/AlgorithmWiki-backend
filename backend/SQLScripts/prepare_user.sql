-- PLEASE RUN THIS SQL SCRIPT UNDER ROOT USER !! --

-- prepare_user.sql - SQL query to create user and then grant neccessary privileges --
-- Copyright (C) 2016 - 2024 CyberDay Studios. (Author: Nguyen Duy Thanh). All right reserved. --

DELIMITER //
CREATE PROCEDURE CreateUserIfNotExists(IN username VARCHAR(255), IN user_pass VARCHAR(255))
BEGIN
    DECLARE user_exists INT;
    SELECT COUNT(*) INTO user_exists FROM mysql.user WHERE user = username;
    IF user_exists = 0 THEN
        SET @create_user_query = CONCAT('CREATE USER ''', username, '''@''localhost'' IDENTIFIED BY ''', user_pass, ''';');
        PREPARE stmt FROM @create_user_query;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;
    END IF;
END//
DELIMITER ;