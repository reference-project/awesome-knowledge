package com.github.huyunxiu.pattern.singleton;

import java.io.Serializable;

/**
 * 双重检查懒汉单例模式
 *
 * @author huyunxiu01@gmail.com
 * @since 2019-03-21
 */
public class LazyDoubleCheckSingleton implements Serializable {

    private volatile static LazyDoubleCheckSingleton instance = null;

    private LazyDoubleCheckSingleton() {
        if (instance != null) {
            throw new RuntimeException("单例模式禁止反射调用");
        }
    }

    public static LazyDoubleCheckSingleton getInstance() {
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    instance = new LazyDoubleCheckSingleton();
                }
            }
            instance = new LazyDoubleCheckSingleton();
        }

        return instance;
    }

    /**
     * 防止单例被序列化破坏
     *
     * @return 返回实例
     */
    private Object readResolve() {
        return instance;
    }
}
