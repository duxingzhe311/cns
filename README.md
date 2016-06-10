# 1、背景
cns将作为云平台服务上下游解耦的组件，通过名字管理所有的关联服务。
## 1.1 名词解释
* instance: 实例，提供某一个服务的最小单元
* service: 服务，包含一个或多个instance
* host: 机器，部署instance的机器
* CNS: cloud naming service, 名字服务，根据名字获取云端服务列表的服务

## 1.2 应用场景
* CLI，command line interface, 部署在所有的服务器上，供运维人员使用
* java sdk, 以jar包的形式嵌入java服务中
* http api, 以http的形式提供服务

## 1.3 与其他解耦组件的区别
* LVS
* nginx
* zookeeper

# 2、设计思路
## 2.1 设计原则
1. DRY, don't repeat yourself, 尽可能的重用
1. 扩展性要好，底层可支持多种云平台或自己的IAAS平台
1. 方便使用，各公司可基于代码方便搭建一套属于自己的cns服务

## 2.2 架构图
 ![cns架构图](https://www.on-img.com/chart_image/thumb/575a6614e4b0a98950d4b2b9.png)

 cns-interface只以标准http api的形式对外暴露接口，方便其他服务接入。

 其他说明：
 1. 初期可先不考虑使用redis
 1. 在cns-interface层，可以有web界面，供人工管理cns服务

 # 3、详细设计
 ## 3.1 数据库表结构
 t_instance

 | 字段 | 类型 | 说明 |
 |---|---|---|
 | id | long | 自增, 主键 |
 | instance_id | int | 实例序号 |
 | service_id | int | service的id |
 | ip | varchar | 部署的服务器IP | 
 | port | int | 服务端口号 | 
 | status | int | 0: 可用, 1:不可用, 可能会有其他状态 |
 | tag | varchar | 存储其他扩展信息 | 

 t_service

 | 字段 | 类型 | 说明 |
 |---|---|---|
 | id | long | 自增，主键 |
 | platform | varchar | 平台名, online/preonline |
 | module | varchar | 模块名 |
 | type | varchar | 服务类型, ecs/rds等 |
 | idc | varchar | 机房名称, qd/bj等 |

 t_host

 | 字段 | 类型 | 说明 |
 |---|---|---|
 | id | long | 自增，主键 |
 | ip | varchar | ip地址，内网 |
 | name | varchar | hostname |
 | cpu_quota | int | cpu核数 |
 | mem_quota | int | 内存大小 MB |
 | disk_quota | int | 磁盘大小 MB | 
 | out_ip | varchar | 外网IP | 
 | idc | varchar | 所属机房名称 |

 ## 3.2 支持的功能
 1. 根据service获取所有ip:port（可用、不可用、全部）。应用场景：程序中配置文件中配置下游service name。
 1. 根据ip获取该机器上所有部署的服务实例instance。应用场景：在机器故障/下线时可以将所有instance迁移走。
 1. 将某个instance置为可用/不可用。应用场景：服务上下线，扩缩容。
