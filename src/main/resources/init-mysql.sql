
INSERT IGNORE INTO roles(name) VALUES('ROLE_USER');
INSERT IGNORE INTO roles(name) VALUES('ROLE_ADMIN') ;

INSERT IGNORE INTO users(created_at, updated_at, email, name, password, username)
VALUES (NOW(), NOW(), 'weblife4us@gmail.com', 'admin', 'password', 'admin');
