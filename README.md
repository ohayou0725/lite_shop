# lite_shop微商铺

基于springboot + vue前后端分离的完整小型电商系统

## 项目介绍

lite_shop是一套小型电商系统，该项目为B2C模式电商系统，包括前台商城系统和后台管理系统，基于springboot  + vue打造。后台管理系统包含会员管理、商品管理、订单管理、运营管理、系统管理、统计报表、后台用户管理、权限管理、系统设置等模块。前台管理系统包含首页、商品推荐、商品搜索、专题推荐、用户下单、支付等一套完整电商流程。

##项目演示

后台管理系统lite_shop_admin地址: https://github.com/llyyffhh/lite_shop_admin

![后台截图1.png](https://i.loli.net/2020/09/20/YPAkIb32zMHXvFr.png)



![后台截图2.png](https://i.loli.net/2020/09/20/IRp7HblznxMUvoB.png)

前台商城系统

敬请期待......

##项目架构

![lite_shop架构.jpg](https://i.loli.net/2020/09/20/73PWtHj2cUqh1XL.png)

##技术栈

后端技术

|          技术          |       说明       |  版本  |
| :--------------------: | :--------------: | :----: |
|       SpringBoot       | web容器+MVC框架  | 2.2.7  |
|     SpringSecurity     |  身份认证与授权  | 5.2.4  |
|      Mybati-Plus       |     orm框架      | 3.2.0  |
| mybatis-plus-generator | 持久层代码生成器 | 3.2.0  |
|         Redis          |    分布式缓存    | 4.0.10 |
|         MySQL          |      数据库      | 5.7.28 |
|          jjwt          |     JWT支持      | 0.9.0  |
|         七牛云         |     对象存储     | 7.2.0  |
|         hutool         |      工具包      | 5.3.8  |

前端技术

|        技术        |       说明       |  版本  |
| :----------------: | :--------------: | :----: |
|        Vue         |     前端框架     | 2.6.10 |
|     Vue-router     |   前端路由框架   | 3.1.2  |
|        Vuex        | 全局状态管理框架 | 3.1.1  |
|       Axios        |   前端HTTP框架   | 0.19.0 |
| Ant Design of  Vue |      UI框架      | 1.6.2  |

##功能介绍

####管理后台:

###### 会员管理:

- 会员列表
- 收货地址
- 会员收藏
- 会员足迹
- 意见反馈 

###### 商品管理:

- 商品制造商
- 商品类目
- 商品维护
- 商品上架
- 商品评价

###### 订单管理:

-  订单列表
- 售后管理

###### 运营管理:

- 专题管理
- 优惠券管理 

###### 系统管理:

- 后台用户管理
- 角色管理
- 操作日志

###### 系统设置

- 订单设置
- 运费设置

统计报表

- 用户统计
- 商品统计
- 订单统计

#### 前台商城:

敬请期待.....

## 快速启动

1. 配置开发环境:

   - MySQL5.7
   - JDK1.8或以上
   - Maven
   - Redis
   - Nodejs

2. 导入数据库文件liteshop-db/sql

3. 开通七牛云oss服务，更改liteshop-cord/src/main/resources/application-dev.yaml中qiniu配置信息

   ```yaml
   qiniu:
     accesskey: #accesskey
     secretKey: #对应秘钥
     bucketName: #空间名称
     fileDomain: #域名前缀
   ```

4. 后台服务启动： 直接运行lite-admin-api下com.ohayou.liteshop.AdminApplication的main方法即可

5. 后台管理启动: 

   进入lite_shop_admin根目录，打开命令行

   ```shell
   npm install
   npm run serve
   ```

   运行成功后浏览器打开，输入网址`http://localhost:8000,进入后台管理系统

   用户名:admin 密码:admin

## 警告

- 该项目仅用于学习
- 该项目目前尚处于开发阶段，很多功能还不完善，如使用不承担任何后果

## 问题

- 开发者有问题或者好的建议可以用Issues反馈交流

- 也可加微信进行交流

<img src="https://i.loli.net/2020/09/20/NPBrpl2iCHfbkdW.jpg" alt="WechatIMG1.jpg" style="zoom:50%;" />








