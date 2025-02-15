# Setup and Run Selenium Webdriver

## I. Cài đặt Java Environment:

### 1. DOWN VÀ SETUP JAVA 8:
Go to [link](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) and download version respective with your system.

Sau khi install, open Terminal and input:
```
$ java -version
```
Nếu hiện dòng thông báo tương ứng là cài đặt thành công (version có thể khác tuỳ thời điểm cài)
```
java version "1.8.0_211"
Java(TM) SE Runtime Environment (build 1.8.0_211-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.211-b12, mixed mode)
```

### 2. TẠO BIẾN MÔI TRƯỜNG CHO JAVA
**Mở Terminal, nhập vào:**
```
$ cd ~/
$ touch .bash_profile
```
**Khi tạo .bash_profile rồi, mở Terminal, nhập vào:** <br>
```
$ nano ~/.bash_profile
hoặc
$ open -e .bash_profile
```
**Nhập các dòng sau vào .bash_profile, sau đó lưu lại:**
```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_141.jdk
export PATH=${JAVA_HOME}/Contents/Home/bin:$PATH
export PATH=/usr/local/bin:/usr/local/sbin:~/bin:$PATH
export PATH=$PATH:/opt/bin:$PATH
```
<i>Mục đích là cái biến môi trường này sẽ chỉ về cái thư mục mà Java JDK được cài để có thể thực thi biên dịch và run code.</i>

## III. Cài đặt Intellij IDEA và setup project

### 1. Cài đặt
Download [here](https://www.jetbrains.com/idea/download/#section=mac) and Install

### 2. Setup project
Pull project từ Git <br>
Open Intellij IDEA <br>
Open project đã pull về <br>
Click phải vào Maven, chọn Reimport

## IV. Lưu ý:
1. Khi gặp page có basic Authenticate thì truyền:
```
driver.get(https://[usename]:[password]@url)
Nếu password có ký tự đặc biệt: #,$, ... thì dùng unicode-converter để chuyển đổi
```
