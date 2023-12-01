CREATE TABLE `post`
(
    `id`          bigint unsigned NOT NULL AUTO_INCREMENT,
    `title`       varchar(255) NOT NULL,
    `slug`        varchar(255)          DEFAULT NULL,
    `cover`       varchar(255)          DEFAULT NULL,
    `description` varchar(512)          DEFAULT NULL,
    `content`     text         NOT NULL,
    `status`      tinyint unsigned NOT NULL DEFAULT '1',
    `type`        char(20)     NOT NULL DEFAULT 'post',
    `attachment`  varchar(255)          DEFAULT NULL,
    `is_free`     tinyint(1) NOT NULL DEFAULT '1',
    `price`       decimal(10, 2)        DEFAULT NULL COMMENT '价格',
    `user_id`     int unsigned NOT NULL,
    `view_count`  int unsigned NOT NULL DEFAULT '0',
    `reply_count` int unsigned NOT NULL DEFAULT '0',
    `created_at`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  datetime NULL DEFAULT NULL,
    `deleted_at`  datetime NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `posts_slug_unique` (`slug`)
);

INSERT INTO `post` (`id`, `title`, `slug`, `cover`, `description`, `content`, `status`, `type`, `attachment`, `is_free`,
                    `price`, `user_id`, `view_count`, `reply_count`)
VALUES (1, 'npm 加速，修改镜像源', 'npm-registry-speedup', '/img/cover/npm-cover.png',
        'npm 国内加速，解决 npm 国内访问速度慢的问题，快速切换、测试 npm 镜像源。\n先通过执行 npm config get registry 查看当前使用的镜像源，接着介绍 3 种修改镜像源的方法：1、临时修改。2、全局修改。\n3、使用第三方工具修改',
        '### 为什么慢\n执行 npm 各种命令的时候，默认是去 npm 官方镜像源获取需要安装的具体软件信息\n\n以下命令查看当前使用的镜像源\n\n```shell\nnpm config get registry\n```\n> 默认源地址在国外，从国内访问的速度肯定比较慢\n\n### 如何修改镜像源\n淘宝维护着一个完整的 npm 镜像源 https://registry.npm.taobao.org/\n#### a). 临时修改\n```shell\nnpm install 软件名 --registry https://registry.npm.taobao.org/\n```\n#### b). 全局修改\n```shell\nnpm config set registry https://registry.npm.taobao.org/\n```\n#### c). 使用第三方软件快速修改、切换 npm 镜像源\n[nrm](https://github.com/Pana/nrm \"nrm\") NPM registry manager\nnrm 不仅可以快速切换镜像源，还可以测试自己网络访问不同源的速度\n\n##### 安装 nrm\n\n```shell\nnpm install -g nrm\n```\n\n##### 列出当前可用的所有镜像源\n```shell\nnrm ls\n\n    npm -----  https://registry.npmjs.org/\n    cnpm ----  http://r.cnpmjs.org/\n    taobao --  https://registry.npm.taobao.org/\n    nj ------  https://registry.nodejitsu.com/\n    rednpm -- http://registry.mirror.cqupt.edu.cn\n    skimdb -- https://skimdb.npmjs.com/registry\n```\n\n##### 使用淘宝镜像源\n```shell\nnrm use taobao\n```\n##### 测试访问速度\n```shell\nnrm test taobao\n```\n\n更多用法查看 [nrm](https://github.com/Pana/nrm \"nrm\")  GitHub',
        1, 'post', NULL, 1, NULL, 1, 1, 0),
       (2, 'yarn 加速，修改镜像源', 'yarn-registry-speedup', '/img/cover/yarn-cover.png',
        'yarn 国内加速，解决 yarn 国内访问速度慢的问题，快速切换、测试 yarn 镜像源。\n先通过执行 yarn config get registry 查看当前使用的镜像源，接着介绍 3 种修改镜像源的方法：1、临时修改。2、全局修改。\n3、使用第三方工具修改',
        '### 为什么慢\n执行 yarn 各种命令的时候，默认是去 npm/yarn 官方镜像源获取需要安装的具体软件信息\n\n以下命令查看当前使用的镜像源\n\n```shell\nyarn config get registry\n```\n> 默认源地址在国外，从国内访问的速度肯定比较慢\n\n### 如何修改镜像源\n淘宝维护着一个完整的 npm 镜像源 https://registry.npm.taobao.org/ 同样适用于 yarn\n\n#### a). 临时修改\n```shell\nyarn save 软件名 --registry https://registry.npm.taobao.org/\n```\n#### b). 全局修改\n```shell\nyarn config set registry https://registry.npm.taobao.org/\n```\n#### c). 使用第三方软件快速修改、切换 yarn 镜像源\n[yrm](https://github.com/i5ting/yrm \"yrm\") YARN registry manager\nyrm 不仅可以快速切换镜像源，还可以测试自己网络访问不同源的速度\n\n##### 安装 yrm\n\n```shell\nnpm install -g yrm\n```\n\n##### 列出当前可用的所有镜像源\n```shell\nyrm ls\n\n    npm -----  https://registry.npmjs.org/\n    cnpm ----  http://r.cnpmjs.org/\n    taobao --  https://registry.npm.taobao.org/\n    nj ------  https://registry.nodejitsu.com/\n    rednpm -- http://registry.mirror.cqupt.edu.cn\n    skimdb -- https://skimdb.npmjs.com/registry\n    yarn ----  https://registry.yarnpkg.com\n```\n\n##### 使用淘宝镜像源\n```shell\nyrm use taobao\n```\n##### 测试访问速度\n```shell\nyrm test taobao\n```\n\n更多用法查看 [yrm](https://github.com/i5ting/yrm \"yrm\")  GitHub',
        1, 'post', NULL, 1, NULL, 1, 1, 0),
       (3, 'composer 加速，修改镜像源', 'composer-repos-speedup', '/img/cover/composer-cover.png',
        'composer 国内加速，解决 composer 国内访问速度慢的问题。\n由于 composer 默认源地址在国外，从国内访问的速度比较慢，虽然不像 npm, maven 有国内阿里巴巴这样的大公司维护着镜像源，\n国内还是能找到加速源，如：laravel-china 提供的国内镜像。本文将介绍两种配置方式：1、配置只在当前项目生效。2、配置全局生效',
        '### 为什么慢\n执行 composer 各种命令的时候，默认是去 composer 官方镜像源获取需要安装的具体软件信息\n\n默认源地址在国外，从国内访问的速度肯定比较慢\n\n### 如何修改镜像源\n目前有热心同仁维护着几个国内镜像\n- https://packagist.phpcomposer.com\n- https://packagist.laravel-china.org\n\ncomposer 不像 npm, maven 有国内阿里巴巴这样的大公司维护着镜像源\n\n由于平时在公司的网络环境默认有梯子，我自己用的不多，不清楚哪个更快更稳定，大家根据自己的网络环境自己测试要选择哪个\n\n#### a). 配置只在当前项目生效\n```shell\ncomposer config repo.packagist composer https://packagist.phpcomposer.com\n\ncomposer config --unset repos.packagist # 取消当前项目配置\n```\n#### b). 配置全局生效\n```shell\ncomposer config -g repo.packagist composer https://packagist.phpcomposer.com\n\ncomposer config -g --unset repos.packagist # 取消全局配置\n```\n\n',
        1, 'post', NULL, 1, NULL, 1, 1, 0),
       (4, 'maven 加速，修改镜像源', 'maven-repository-speedup', '/img/cover/maven-cover.png',
        'maven 国内加速，解决 maven 国内访问速度慢的问题。\n由于 maven 默认源地址在国外，从国内访问的速度比较慢，但是我们可以使用阿里巴巴维护的镜像源进行加速，\n本文将介绍两种配置方式：1、配置只在当前项目生效。2、配置全局生效',
        '### 为什么慢\n执行 mvn 各种命令的时候，默认是去 maven 官方镜像源获取需要安装的具体软件信息\n\n默认源地址在国外，从国内访问的速度肯定比较慢\n\n### 如何修改镜像源\n阿里巴巴维护着一个国内 maven 镜像源\n\n#### a). 配置只在当前项目生效\n\n在 pom.xml 文件内添加以下配置\n\n```xml\n<repositories>\n    <repository>\n        <id>ali-maven</id>\n        <url>http://maven.aliyun.com/nexus/content/groups/public</url>\n    </repository>\n</repositories>\n```\n#### b). 配置全局生效\n\n修改 settings.xml 文件\n\n找到 <mirrors> 标签，在里面加入以下内容\n\n```xml\n<mirror>\n    <id>alimaven</id>\n    <name>aliyun maven</name>\n    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>\n    <mirrorOf>central</mirrorOf>\n</mirror>\n```\n\n可以在以下路径查找到 settings.xml 文件\n\n1. (用户家目录)/.m2/settings.xml\n\n2. (maven安装目录)/conf/settings.xml，\n\n   如果是 Mac 系统通过 brew 命令安装的，在这里：\n\n   /usr/local/Cellar/maven/(版本号)/libexec/conf/settings.xml\n',
        1, 'post', NULL, 1, NULL, 1, 7, 0),
       (5, '股票数据可视化示例', 'stock-data-visualization-template', '/img/cover/data-visualization-cover.png',
        '通过可视化大屏的方式展示股票部分基础数据',
        '### 资源介绍\n\n股票数据可视化大屏示例，用六个区域展示股票基础数据：\n\n* 随机选股\n* CSRC 行业分类统计\n* 上市公司分布地图\n* 沪深部分指数\n* 各省股票数据占比\n* 市值 TOP 10 排行\n\n### 资源截图\n\n![stock-charts](/img/cover/data-visualization.png)',
        1, 'resource', '/attachment/stock-data-visualization-template.zip', 1, NULL, 1, 7, 0),
       (6, 'Servelet-MySQL', 'mysql-for-study', '/img/cover/mysql-blog.png', 'mysql一些基本命令的学习', '

### MySQL
#### 基本命令
+ `sudo apt install mysql-server` enter Y to install

  + `sudo mysql_secure_installation` to run automated securing script
+ Press N for VALIDATE PASSWORD plugin 密码强度
+ Set root password

  + 你要设置的root密码
+ Remove anonymous users? `Y`
+ Disallow root login remotely? `N`
+ Remove test database and access to it? `Y`
+ Reload privilege tables now? `Y`
+ `sudo mysql` to enter MySQL CLI
+ `SELECT user,authentication_string,plugin,host FROM mysql.user;` to verify root user''s auth method
+ `ALTER USER ''root''@''localhost'' IDENTIFIED WITH mysql_native_password BY ''要设置的root密码'';` to set a root password
+ `SELECT user,authentication_string,plugin,host FROM mysql.user;` to verify root user''s auth method
+ `FLUSH PRIVILEGES;` to apply all changes
+ `exit` Enter
+ `mysql -u root -p` to access db from now on, enter password `刚刚设置的root密码`
+ 如果执行上一步的 `sudo mysql_secure_installation` 命令报错，提示需要通过 alert 的方式设置密码，按如下操作：

  + `sudo mysql` to enter MySQL CLI
  + `SELECT user,authentication_string,plugin,host FROM mysql.user;` to verify root user''s auth method
  + `ALTER USER ''root''@''localhost'' IDENTIFIED WITH mysql_native_password BY ''要设置的root密码'';` to set a root password
  + `SELECT user,authentication_string,plugin,host FROM mysql.user;` to verify root user''s auth method
  + `CREATE USER ''root''@''%'' IDENTIFIED WITH mysql_native_password BY ''要设置的root密码'';` # 用来远程登录的root账号
  + `FLUSH PRIVILEGES;` to apply all changes
  + `exit` Enter
  + 再次执行 `sudo mysql_secure_installation`
  + Press y|Y for Yes, any other key for No: n
  + Using existing password for root.
  + Change the password for root ? ((Press y|Y for Yes, any other key for No) : n
  + Remove anonymous users? `Y`
  + Disallow root login remotely? `N`
  + Remove test database and access to it? `Y`
  + Reload privilege tables now? `Y`

#### 允许远程连接 mysql

- 修改配置文件 sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf
- 注释掉这行 #bind-address            = 127.0.0.1
- 修改默认字符集（Encoding、Collation）

  - 主要针对 mysql 8.0 之前的版本，默认是 `latin1`，需要主动修改
  - 从 mysql 8.0 开始，默认已经是 `utf8mb4` 格式了
- `mysql -u root -p` 重新登录 mysql
- `GRANT ALL PRIVILEGES ON *.* TO ''root''@''%'' WITH GRANT OPTION;` # 这条语句为root用户分配了最高权限，可以访问任何数据库

  如果只允许特定的数据库，可以使用类似 `GRANT ALL PRIVILEGES ON laravel.* TO ''root''@''%'' IDENTIFIED WITH GRANT OPTION;` # 注意这里是 `%` 不是 `localhost`，否则只允许在本机连接

+ `FLUSH PRIVILEGES;` to apply all changes
+ `exit` Enter

- 重启 mysql 服务 `sudo systemctl restart mysql`
- 让 mysql 服务开机自启动 `sudo systemctl enable mysql`
- `sudo ufw allow 3306` 防火墙开放 3306 端口

  - 阿里云ECS服务器需要通过控制台添加一条允许访问3306端口的安全组规则

    网卡类型：内网
    规则方向：入方向
    授权策略：允许
    协议类型：TCP

    端口范围：3306/3306
    优先级：1
    授权类型：IPv4地址段访问

    授权对象：0.0.0.0/0
    描述：


', 1, 'post', NULL, 1, NULL, 1, 2, 0),
(7, '搭建自己的服务器-by-aliyun', 'servlet-by-aliyun', '/img/cover/servlet-aliyun.png', '通过aliyun搭建自己的服务武器',
    '## 一. 服务器的获取
### 首先前往[aliyun](https://www.aliyun.com/)

### 选择自己心仪的一款服务器

![img_1.png](img%2Fimg_1.png)
#### 选择自己想要的操作系统等配置
![img.png](img%2Fimg.png)
#### 前往个人中心查看自己的云服务器
![img_2.png](img%2Fimg_2.png)
最好修改一下密码

## 二. 服务器相关配置

### 1. 配置环境
#### （1）首先明确我们所需的运行环境。
我们以需求java为例.

先连接上我们的服务器，然后检查是否有我们所需的配置。
```
ssh {user.name}@{romote-ip}

java -version
```
如果没有
#### (2)下载相关配置
```
apt-cache search openjdk
sudo apt update
sudo apt install openjdk-17-jdk
java -version
```
这里的openjdk指我们需要的，-version来检查是否已经安装好。
### 2.导入文件
#### （1）新建一个项目或者用已有的项目
#### （2）在本地上运行，保证打成jar包前是没有错误的
用mvn package 打包为jar包
#### （3）将jar包导入服务器中
```
# upload to server
scp ./***.jar {user-name}@{romote-ip}:/root

# download from serve
scp {user-name}@{romote-ip}:/path/to/file {local/path}
```
#### (4) 在服务器上运行jar包
```
nohup java -jar ***.jar &
```
nohup是将日志输出在nohup.out文件中，&代表在后台运行

### 3.安全性操作
我们发现在非服务器上访问{romote.ip}+:port时，不会得到我们需要的内容，服务器会拒绝访问，这是阿里云出于安全性考虑。
我们想让别人也可（非本机）访问，就需要在安全组中添加可访问的端口——可以指定哪个端口哪些IP可以访问。

在我们设置好之后，我们先中止在后台运行的程序
```
jps
kill -9 {need-kill-id}
```
然后重新运行，现在我们再次访问，我们会发现
![img_3.png](img%2Fimg_3.png)

我们拿到了我们需要从网址中得到的内容

### 4.服务器操作
我们在运维服务器时，难免会遇到修改文件的需求

我们可以通过以下几种办法更改服务器上的文件

#### （1）直接从本机上传到服务器
例如改好project后打包重新上传到服务器，也可以上传单个文件。
#### （2）修改properties
可以在java -jar命令后加我们需要的环境变量--{properties=？}，如--server.port=8080
#### （3）在服务器上对文件进行操作
这里我们用vim来执行相关操作
```
vim filename
```
', 1, 'post', NULL, 1, NULL, 1, 2, 0),
(8, '||||||||||||||||||||||||||||||', 'just-for-wireframes', '/img/cover/default-cover.png', '|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||', '### ||||||||\n\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n\n```shell\n||||||||||||||||||||||||||||||||||||||||\n```\n\n> ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n\n### |||||||||||||||||\n\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n\n#### |||||||||||||||||\n\n```shell\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n```\n\n#### |||||||||||||||||||||||||\n\n```shell\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n```\n\n#### ||||||||||||||||||||||||||||||||||||||||\n\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n\n##### ||||||||||\n\n```shell\n||||||||||||||||||||\n```\n\n##### |||||||||||||||\n\n```shell\n||||||||||\n\n    |||||||||| -----  ||||||||||||||||||||\n    |||||||||| -----  ||||||||||||||||||||||||||||||||||||||||\n    |||||||||| -----  ||||||||||||||||||||||||||||||||||||||||||||||||||\n    |||||||||| -----  ||||||||||||||||||||\n    |||||||||| -----  ||||||||||||||||||||||||||||||\n    |||||||||| -----  ||||||||||||||||||||||||||||||||||||||||||||||||||\n```\n\n##### |||||||||||||||||||||\n\n```shell\n|||||||||||||||||||||||||||||||||\n```\n\n##### |||||||||||||\n\n```shell\n|||||||||||||||||||||||||||\n```\n\n||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n', 1, 'post', NULL, 1, NULL, 1, 2, 0),
(9, 'spring boot', 'spring-boot-starter', '/img/cover/spring-boot.png', 'spring-boot study', '## spring boot

springboot 框架是为了能够帮助使用 spring 框架的开发者 快速高效的 构建一个基于 spirng 框架以及 spring 生态体系 的应用解决方案。

它是对“约定优于配置”这个理念下 的一个最佳实践。因此它是一个服务于框架的框架，服务的范围是简化配置文件。

## stater

在spring mvc 和framework的基础上，springboot提供了很多你也许需要的stater。

starter是各种依赖的集合，可以根据自己需要忽略其中依赖并更改为自己需要的依赖。
通过starter我们可以更方便的使用我们需要的功能，也可以引入第三方的starter。', 1, 'post', NULL, 1, NULL, 1, 2, 0);
