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
export ANDROID_HOME=/Users/[username]/Library/Android/sdk
export PATH=$ANDROID_HOME/platform-tools:$PATH
export PATH=$ANDROID_HOME/tools:$PATH
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_141.jdk
export PATH=${JAVA_HOME}/Contents/Home/bin:$PATH
export PATH=/usr/local/bin:/usr/local/sbin:~/bin:$PATH
export PATH=$PATH:/opt/bin:$PATH
```
<i>Mục đích là cái biến môi trường này sẽ chỉ về cái thư mục mà Java JDK được cài để có thể thực thi biên dịch và run code.</i>

## II. Cài đặt Driver trình duyệt (Chrome):
Kiểm tra version trình duyệt đang sử dụng <br>
Vào trang [chrome driver](https://sites.google.com/a/chromium.org/chromedriver/downloads) để download driver tương ứng <br>
Kiểm tra chromedriver đã cài đặt thông qua Terminal
```
$ chromedriver -v
ChromeDriver 87.0.4280.88 (89e2380a3e36c3464b5dd1302349b1382549290d-refs/branch-heads/4280@{#1761})
```

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
## V. Bonus Selenium-Grib:
1. Công dụng: Selenium-Grid cho phép người dùng thực thi kiểm thử trên nhiều máy khác nhau với nhiều trình duyệt khác nhau

2. Thiết lập môi trường cho Selenium-Grid <br>
   2.1. Selenium Server: download phiên bản mới nhất của Selenium Server ở [đây](https://www.selenium.dev/downloads/) <br>
   2.2. Hub và Node: <br>
    ***Start hub:*** <br>
      ```
      java –jar selenium-server-standalone-*.jar hub
      ```
    ***Start node:*** <br>
      ```
      java -Dwebdriver.chrome.driver="[driver path]" -jar selenium-server-*.jar node --hub [hubUrl]/register
      ```
    ***Update source:***
    ```
     URL hubUrl = new URL("[hubUrl]/wd/hub");
     DesiredCapabilities capabilities = DesiredCapabilities.chrome();
     capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
     driver = new RemoteWebDriver(hubUrl, capabilities);
    ```
    ***UI track:*** http://localhost:4444/ui/index.html#/ <br>
    ***Selenium-Grid UI:*** download Visgrid and run
    ```
    java -jar visgrid-*.jar
    ```

### Dockerizing our application

#### Running our application in a container

```bash
make up
```

#### Stop and remove container

```bash
make down
```

#### Clean up dangling Docker images

```bash
make clean
```

#### Update `JAR_PACKAGE` URL in Dockerfile when deploy new `autoWebMarketplace.jar`
  - `Amazon S3/Buckets/auto-test-bucket/packages/autoWebMarketplace.jar`
