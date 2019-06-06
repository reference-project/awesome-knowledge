# 优化MySql语句

## 使用慢查询日志获取有性能问题的Sql语句
```bash
SHOW VARIABLES LIKE '%slow_query%';
SET GLOBAL slow_query_log=ON; # 启动记录慢查询日志
SET GLOBAL slow_query_log_file='/usr/local/mysql/oms-slow.log'; # 指定慢查询日志的存放路径
SET GLOBAL long_query_time=0.1; # 指定记录慢查询日志的阈值（单位为秒）
SET GLOBAL log_queries_not_using_indexes=ON; # 是否记录未使用索引的SQL
```

## 使用mysqldumpslow分析慢查询日志
```bash
mysqldumpslow -s r -t 10 slow-mysql.log

# 按照哪种排序方式输出结果
# c - 总次数
# t - 总时间
# c - 锁的时间
# r - 总数据行数
# 前面加a代表平均的意思
-s order (c, t, l, r, at, al, ar)
# 
-t top

# 示例
Reading mysql slow query log from oms-slow.log
Count: 1  Time=19s (19s)  Lock=0.00s (0s)  Rows=0.0 (0), root[root]@localhost
SELECT * FROM `test` WHERE `name` = `me`;
```

## 实时查询数据库中的慢查询
```bash
SELECT * FROM information_schema.PROCESSLIST WHERE TIME > 1000;
```