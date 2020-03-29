CREATE USER 'test_user'@'localhost' IDENTIFIED BY 'test' PASSWORD EXPIRE INTERVAL 30 DAY;

GRANT ALL PRIVILEGES ON web_customer_tracker.* TO 'test_user'@'localhost';