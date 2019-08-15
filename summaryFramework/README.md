# summaryFarmework
总结工作中遇到的好的处理方法

## cache
Guava 缓存

## cunstomException
自定义异常类
统一异常

## customData


## multiDatabaseQuery
并发查询多数据库/H2数据库

业务中有这样的要求:数据需要通过不同的数据库数据进行拼接
可以通过使用并发查询多数据库来实现相应时间缩短
优点 : 提高相应时间
缺点 : 数据库压力会增大,代码要求会高一点

## verify
请求参数校验/自定义加解密注解