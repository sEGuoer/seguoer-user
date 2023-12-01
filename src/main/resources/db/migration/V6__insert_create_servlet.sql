INSERT INTO blog.post (title, slug, cover, description, content, status, type, attachment, is_free, price, user_id,
                       view_count, reply_count, created_at, updated_at, deleted_at)
VALUES ('从0创建自己的饥荒服务器', null, '/cover/post/0d626c86-c38a-4b61-a6a8-8f714e69ec41.png',
        'gamer servlet create', '## 饥荒服务器创建（steam游戏类似）

### 1.first step ?️  get servlet config

#### create a servlet in web

登陆官网[dst  login page](https://accounts.klei.com/login)
![image.png](/vd/9041e0d5-66d2-48b7-a975-46aa9af9dfe3.png)

#### 拿到一些准备文件

然后我们创建好之后有相关配置
![image.png](/vd/796dbc35-cc6e-4c85-a16e-5d3a82d624ab.png)

### 2.second step: ?️ linux servlet

首先我们先进入我们要搭建服务器的云服务器或本地服务器（这里以云为例，操作系统为linux）。

通过点击它的链接我们会发现有6步
![image.png](/vd/1a63d41c-436e-476e-b98f-520057f07698.png)
这时候我们先点2，跟着里面下载steamcmd的步骤执行。
若需要给steam用户权限，可以用以下命令

```
usermod -g root steam
```

操作完成后直接click step3 ，往下做。其中如果电脑上没有运行过饥荒。
显而易见步骤中的Download the Zip archive, extract the content, and place the folder “MyDediServer” inside **~/.klei/DoNotStarveTogether/**。就需要我们去在服务器对应位置创建对应文件夹，在linux中我们用

```
mkdir -p ~/.klei/DoNotStarveTogether
```

### 3.finally step: add run sh and open endpoint

#### 脚本运行

再加入运行脚本时，我们可以通过直接传输文件或在服务器上直接创建（例子通过vim创建）对应脚本然后编辑，最后运行，命令分别如下：

```
scp  {local/path} {user-name}@{remote-ip}:/path/to/file

vim filepath/***

nohup filepath/*** &
```

nohup代表日志输出到文件（有默认值），&代表后台运行，这样我们就可以启动服务器了

#### 开放端口

饥荒需要开放5个端口，这样才能让别人也进来玩，其中需要哪些协议开放具体可以查，就不过多赘述了（10888，10998，10999是我记得的几个）,到这里服务器就已经架设完毕。


', 1, 'post', null, 1, null, 1, 0, 0, '2023-12-01 17:38:28', null, null);

