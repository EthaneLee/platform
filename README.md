# platform

## 一、后台
### 1.1 开发环境
### 1.2 技术选型
### 1.3 项目结构
common : 公共代码模块，主要放置一些工具类 <br>
core ：封装业务模块，主要封装公共业务模块 <br>
admin : 后台管理模块，包含用户、角色、菜单管理等 <br>
backup ：系统数据备份还原模块，可选择独立部署 <br>
monitor ： 系统监控服务端，监控spring boot应用 <br>
producer : 服务提供者示例，方便在此基础上搭建模块 <br>
consumer : 服务消费者示例，方便在此基础上搭建模块 <br>
hystrix ： 服务熔断监控模块，收集汇总熔断统计信息 <br>
zuul : API服务网关模块，统一管理和转发外部调用请求 <br>
config ： 配置中心服务端，生成GIT配置文件的访问接口 <br>
consul : 注册中心 <br>
zipkin ：链路追踪 <br>
config-repo : 配置中心仓库，在GIT上统一存储系统配置文件 <br>
pom ： 聚合模块