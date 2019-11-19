## how to solve the problem
https://stackoverflow.com/questions/18339513/access-denied-for-user-root-mysql-on-mac-os
The solution of

UPDATE user SET authentication_string=PASSWORD("my_password") WHERE User='root';

wasn't working for me, but I did

FLUSH PRIVILEGES;
ALTER USER 'root'@'localhost' IDENTIFIED BY 'MyNewPassword';
