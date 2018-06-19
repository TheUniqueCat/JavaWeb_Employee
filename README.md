# JavaWeb_Employee
简易的员工信息管理系统JavaBean+JSP+JDBC
数据库：MySQL
演示地址：http://maxcj.cn:8080/JavaWeb_Employee/

## 实现的功能

### 员工
#### 1、员工注册以及登录（ApplicantDAO）
#### 2、员工信息以及简历的添加、修改（ResumeDAO（信息）、InfoDAO（简历））
#### 3、员工查看自己的工资（可实现全部、一个月查询、全年工资统计）
#### 4、查看管理员发布的通知（可进行留言）
#### 5、查看全部员工填写的通信方式（作为一个通讯录）

### 管理员
#### 1、查看、修改员工的信息、简历
#### 2、查看、添加员工的工资
#### 3、发布通知、管理留言
#### 4、删除员工


## 效果图如下
![这里写图片描述](http://img.blog.csdn.net/20171215185126733)


## 附上数据库表结构

### 用户表：tb_applicant
|字段|属性|索引|
|:-|:-|:-|
|applicant_id|int|主键
|applicant_email|varchar|*
|applicant_pwd|varchar|*

### 用户简历表：tb_info_basicinfo
|字段|属性|索引|
|:-|:-|:-|
|info_id|int|主键
|age|int|*
|job|varchar|*
|experience|varchar|*
|applicant_id|int|外键

### 用户信息表：tb_resume_basicinfo
|字段|属性|索引|
|:-|:-|:-|
|basicinfo_id|int|主键
|name|varchar|*
|phone|varchar|*
|email|varchar|*
|sex|varchar|*
|applicant_id|int|外键

### 用户工资表：tb_salary
|字段|属性|索引|
|:-|:-|:-|
|salary_id|int|主键
|post_salary|varchar|*
|attendance_salary|varchar|*
|bonus|varchar|*
|total_salary|varchar|*
|date|varchar|*
|applicant_id|int|外键

### 通知信息表：tb_notice
|字段|属性|索引|
|:-|:-|:-|
|notice_id|int|主键
|notice_title|varchar|*
|notice_content|varchar|*
|notice_date|varchar|*

### 通知留言表：tb_message
|字段|属性|索引|
|:-|:-|:-|
|notice_id|int|主键
|message_content|varchar|*
|notice_id|int|外键
|applicant_id|int|外键


PS：初学者，分包没有太明确。
