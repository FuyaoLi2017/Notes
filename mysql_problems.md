### mysql installation
brew install mysql
sudo chmod -R a+rwx /usr/local/var/mysql
sudo chown -R _mysql:_mysql /usr/local/var/mysql
sudo mysql.server start

要先启动server，再做其他的操作
had this issue on mac 10.10.5 Yosemite

What I did to solve this

cd /usr/local/var/mysql
sudo rm *.err && sudo rm *.pid
sudo reboot
sudo mysql.server start

### JAVA_HOME settings
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

export JAVA_8_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home
export JAVA_11_HOME=/Library/Java/JavaVirtualMachines/jdk-11.jdk/Contents/Home

https://my.oschina.net/u/2494581/blog/1535185

export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH

echo 'export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_191.jdk/Contents/Home/' >> ~/.bash_profile
source ~/.bash_profile

sudo chmod 755 /etc/profile

对于idea修改java 版本
选择File -》 Project Structure 即可更改JDK版本，在Project SDK中可以选择项目运行的JDK版本
