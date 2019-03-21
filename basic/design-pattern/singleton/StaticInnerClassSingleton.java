package com.github.huyunxiu.pattern.singleton;

import java.io.Serializable;

/**
 * 静态内部类单例模式
 *
 * @author huyunxiu01@gmail.com
 */
public class StaticInnerClassSingleton implements Serializable {

    private StaticInnerClassSingleton() {
        if (InnerClass.instance != null) {
            throw new RuntimeException("单例模式禁止反射调用");
        }
    }

    private static class InnerClass {
        private static StaticInnerClassSingleton instance;
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.instance;
    }

    /**
     * 防止单例被序列化破坏
     *
     * @return 返回实例
     */
    private Object readResolve() {
        return getInstance();
    }
}
