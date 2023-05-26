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

-- 向 online 表中插入测试数据
INSERT INTO online(user_id, login_time, user_status) VALUES
    (1,'2023.05.23.16:30','normal'),
    (2,'2023.05.23.17:30','normal'),
    (3,'2023.05.24.16:00','exception'),
    (4,'2023.05.25.12:23','normal')
-- 向 online 表中插入测试数据
INSERT INTO Location(user_id, x, y, z, last_update) VALUES
    (1,'233','456','123','2023.05.26.12:00'),
    (2,'368','3824','23','2023.05.26.12:01'),
    (3,'456','232','84758','2023.05.26.12:02'),
    (4,'3974','232','4975','2023.05.26.12:03')