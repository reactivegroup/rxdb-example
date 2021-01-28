# reactive mysql

[![Gitter Chat](https://badges.gitter.im/Join%20Chat.svg)](https://groups.google.com/g/reactive-group)

Reactive Mysql Example.

通过Reactive驱动访问Mysql数据库的示例程序库

## Contributing

[How to contribute](../CONTRIBUTING.md) 

## 部署数据库实例

1. 在`localhost`启动相应的数据库实例，并创建相应的数据表
      
    请查看 `src/main/resourcest/sql/rxdb.sql`
    
2. 在`configuration`配置类中设置数据库访问连接串，使程序能够连接到数据库实例
    
    请修改 `src/main/java/com.reactive.rxmysql.MysqlConfiguration`
    
## 启动应用程序

1. 通过`SpringBoot`启动应用程序
2. 通过`http`访问应用程序接口进行调试
---
1. 通过`test`单元测试进行调试

