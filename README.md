#老年人朋友圈 后台系统

## 关于工程
- JDK 1.11、Maven 3.2、Neo4j 3.5
- 使用Spring Boot作为核心框架
- 包含REST API
- Spring Boot内置Web容器，无需另外配置
- application.yml 中可配置服务端口port、服务路径servlet-path
- Application类 run 'Application' 即可启动项目
- 可通过mvn clean package打包，通过java -jar xxx.jar 启动服务
- 对应Android APP API，配合使用

> Neo4j：nosql的图数据库，支持事务性处理，类似sql的查询语言，适用于社交关系等复杂关系网络的构建


通过Neo4j构建了一个完整的社交圈，支持关注，点赞，评论，发布朋友圈等一系列社交行为。

  
感谢阅读这份文档。  