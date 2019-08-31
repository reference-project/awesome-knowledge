# 使用JMH做基准测试

## 1. 项目初始化
### 1.1 如果你还没有项目，你需要使用maven先新建一个项目
```bash
$ mvn archetype:generate \
          -DinteractiveMode=false \
          -DarchetypeGroupId=org.openjdk.jmh \
          -DarchetypeArtifactId=jmh-java-benchmark-archetype \
          -DgroupId=org.github.huyunxiu \
          -DartifactId=jmh-demo \
          -Dversion=1.21
$ cd jmh-demo
```
### 1.2 如果已经存在一个maven项目，你需要在`pom`中加入依赖
```xml
<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-core</artifactId>
    <version>1.21</version>$$
</dependency>
<dependency>
    <groupId>org.openjdk.jmh</groupId>
    <artifactId>jmh-generator-annprocess</artifactId>
    <version>1.21</version>
    <scope>provided</scope>
</dependency>
```

## 2. 你的第一个Benchmark
### 2.1 代码
```java
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

// 测吞吐量
@BenchmarkMode(Mode.Throughput)
// 在开测之前预热三次，默认每次1秒
@Warmup(iterations = 3)
// 正式测试进行10次测试，每次5秒
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
// 两个进程
@Fork(2)
// 八个线程
@Threads(8)
// 输出结果以毫秒为单位
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class MyBenchmark {

    @Benchmark
    public void testStringAdd() {
        String a = "";
        for (int i = 0; i < 10; i++) {
            a += i;
        }
    }

    @Benchmark
    public void testStringBuilderAdd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
    }

    /*
     * ============================== 怎样运行: ====================================
     *
     * a) 通过命令行:
     *    $ mvn clean install
     *    $ java -jar target/benchmarks.jar
     *
     * JMH会在打包后生成一个叫`benchmarks.jar`的包，你可以运行下面的命令来查看可用的运行时选项：
     *    $ java -jar target/benchmarks.jar -h
     *
     * b) 内部调用: 可以通过下面main方法在IDE中进行调用
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
            .include(MyBenchmark.class.getSimpleName())
            .mode(Mode.Throughput)
            .warmupIterations(3)
            .measurementIterations(10)
            .measurementTime(TimeValue.seconds(5))
            .threads(8)
            .forks(2)
            .timeUnit(TimeUnit.MILLISECONDS)
            .build();

        new Runner(opt).run();
    }
}
```
### 2.2 打包并且执行
```bash
$ mvn clean package
$ java -jar target/benchmarks.jar
```

## 3. 常用注解
### @BenchmarkMode
```java
public enum Mode {
    // 吞吐量，单位时间内调用次数
    Throughput("thrpt", "Throughput, ops/time"),
    // 调用的平均时间，每次调用耗时
    AverageTime("avgt", "Average time, time/op"),
    // 随机取样，然后输出取样结果的时间和调用分布
    SampleTime("sample", "Sampling time"),
    // 只运行一次，用来测试冷启动时间
    SingleShotTime("ss", "Single shot invocation time"),
    // 把以上的全部运行一遍
    All("all", "All benchmark modes");
}
```
### @Warmup
预热次数多少次，每轮时长，时间单位多少
### @Measurement 
正式测试多少次，每轮时长，时间单位多少
### @Fork
fork出来的进程数
### @Threads
每个进程中的测试线程
### @OutputTimeUnit
基准测试结果的时间类型。一般选择秒、毫秒、微秒。
### @Param
属性的注解，用于多参数测试
### @Setup
方法级注解，用于测试前的准备工作
### @TearDown
方法级注解，用于测试后的收尾工作
### @State
一个经过@State注解修饰的对象可以变成实例可以在多个benchmark方法中重复使用。
```
public enum Scope {

    /**
     * 实例可以被每个线程共享
     */
    Benchmark,

    /**
     * 每个线程组都创建属于自己的实例
     */
    Group,

    /**
     * 每个线程都创建属于自己的实例
     */
    Thread,
}
```

以上这些注解的示例都可以在[code-tools-jmh](https://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/)中找到。

## 结果

我将测试结果复制到了下方，我们通过测试结果可以看到，该Benchmark测试预热了3次，每次1秒，正式测试执行了10次，每次5秒，Fork了两个进程进行测试，每个进程有八个线程。两个方法对比结果自动被JMH总结在了最下方：
- `testStringAdd`方法采样20（Fork * Thread），每毫秒可以进行26273.540次`testStringAdd`方法，误差率在177.994
- `testStringBuilderAdd`方法采样20（Fork * Thread），每毫秒可以进行63784.573次`testStringBuilderAdd`方法，误差率在15585.404

```
# VM invoker: /usr/lib/jvm/java-1.8-openjdk/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 10 iterations, 5 s each
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: org.github.huyunxiu.MyBenchmark.testStringAdd

# Run progress: 0.00% complete, ETA 00:03:32
# Fork: 1 of 2
# Warmup Iteration   1: 24070.935 ops/ms
# Warmup Iteration   2: 27715.464 ops/ms
# Warmup Iteration   3: 26657.142 ops/ms
Iteration   1: 26408.015 ops/ms
Iteration   2: 26379.936 ops/ms
Iteration   3: 26457.178 ops/ms
Iteration   4: 26409.309 ops/ms
Iteration   5: 26356.791 ops/ms
Iteration   6: 26287.001 ops/ms
Iteration   7: 26343.530 ops/ms
Iteration   8: 26500.643 ops/ms
Iteration   9: 26444.982 ops/ms
Iteration  10: 26147.261 ops/ms

# Run progress: 25.00% complete, ETA 00:02:48
# Fork: 2 of 2
# Warmup Iteration   1: 24178.863 ops/ms
# Warmup Iteration   2: 27796.010 ops/ms
# Warmup Iteration   3: 28196.604 ops/ms
Iteration   1: 26089.449 ops/ms
Iteration   2: 26456.941 ops/ms
Iteration   3: 26357.403 ops/ms
Iteration   4: 26311.814 ops/ms
Iteration   5: 26274.394 ops/ms
Iteration   6: 26291.286 ops/ms
Iteration   7: 26315.298 ops/ms
Iteration   8: 25684.743 ops/ms
Iteration   9: 25915.450 ops/ms
Iteration  10: 26039.381 ops/ms


Result: 26273.540 ±(99.9%) 177.994 ops/ms [Average]
  Statistics: (min, avg, max) = (25684.743, 26273.540, 26500.643), stdev = 204.979
  Confidence interval (99.9%): [26095.546, 26451.535]


# VM invoker: /usr/lib/jvm/java-1.8-openjdk/jre/bin/java
# VM options: <none>
# Warmup: 3 iterations, 1 s each
# Measurement: 10 iterations, 5 s each
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: org.github.huyunxiu.MyBenchmark.testStringBuilderAdd

# Run progress: 50.00% complete, ETA 00:01:52
# Fork: 1 of 2
# Warmup Iteration   1: 124566.448 ops/ms
# Warmup Iteration   2: 45993.389 ops/ms
# Warmup Iteration   3: ^@47952.162 ops/ms
Iteration   1: 46387.849 ops/ms
Iteration   2: 45329.859 ops/ms
Iteration   3: 46437.981 ops/ms
Iteration   4: 46446.515 ops/ms
Iteration   5: 46241.412 ops/ms
Iteration   6: 46494.979 ops/ms
Iteration   7: 46155.375 ops/ms
Iteration   8: 46745.871 ops/ms
Iteration   9: 46515.853 ops/ms
Iteration  10: 46211.136 ops/ms

# Run progress: 75.00% complete, ETA 00:00:56
# Fork: 2 of 2
# Warmup Iteration   1: 129329.281 ops/ms
# Warmup Iteration   2: 154434.228 ops/ms
# Warmup Iteration   3: 76365.668 ops/ms
Iteration   1: ^@81672.394 ops/ms
Iteration   2: 81114.284 ops/ms
Iteration   3: 80339.826 ops/ms
Iteration   4: 81571.572 ops/ms
Iteration   5: 80729.508 ops/ms
Iteration   6: 81072.120 ops/ms
Iteration   7: 81407.681 ops/ms
Iteration   8: 81073.489 ops/ms
Iteration   9: 82379.611 ops/ms
Iteration  10: 81364.154 ops/ms


Result: 63784.573 ±(99.9%) 15585.404 ops/ms [Average]
  Statistics: (min, avg, max) = (45329.859, 63784.573, 82379.611), stdev = 17948.175
  Confidence interval (99.9%): [48199.169, 79369.978]


# Run complete. Total time: 00:03:44

Benchmark                                  Mode  Samples      Score  Score error   Units
o.g.h.MyBenchmark.testStringAdd           thrpt       20  26273.540      177.994  ops/ms
o.g.h.MyBenchmark.testStringBuilderAdd    thrpt       20  63784.573    15585.404  ops/ms
```