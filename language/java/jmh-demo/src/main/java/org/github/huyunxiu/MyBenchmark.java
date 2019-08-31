/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.github.huyunxiu;

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
