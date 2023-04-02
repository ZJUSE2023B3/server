USE IsLandServer;
-- 向 User 表中插入测试数据
INSERT INTO User (user_name, user_passwd, email) VALUES
    ('user1', 'password1', 'user1@example.com'),
    ('user2', 'password2', 'user2@example.com'),
    ('user3', 'password3', 'user3@example.com');

-- 向 Friend 表中插入测试数据
INSERT INTO Friend (user_id, friend_id) VALUES
    (1, 2),
    (1, 3),
    (2, 3);

-- 向 chatRecord 表中插入测试数据
INSERT INTO chatRecord (user_id, friend_id, message) VALUES
    (1, 2, 'Hello, friend!'),
    (2, 1, 'Hi, there!'),
    (1, 3, 'How are you?'),
    (3, 1, 'I am fine, thank you.'),
    (2, 3, 'What are you doing?'),
    (3, 2, 'Nothing much.');
