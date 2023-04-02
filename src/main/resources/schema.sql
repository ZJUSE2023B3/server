-- 检查是否存在数据库 IsLandServer，如果不存在则创建
CREATE DATABASE IF NOT EXISTS IsLandServer;
USE IsLandServer;

-- 检查是否存在数据表 User，如果不存在则创建
CREATE TABLE IF NOT EXISTS User (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL,
    user_passwd VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
-- 检查是否存在数据表 Friend，如果不存在则创建
CREATE TABLE IF NOT EXISTS Friend (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    friend_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (friend_id) REFERENCES User(user_id)
);
-- 检查是否存在数据表 chatRecord，如果不存在则创建
CREATE TABLE IF NOT EXISTS chatRecord (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    friend_id INT NOT NULL,
    message TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User(user_id),
    FOREIGN KEY (friend_id) REFERENCES User(user_id)
);
