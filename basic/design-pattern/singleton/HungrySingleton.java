package com.github.huyunxiu.pattern.singleton;

import java.io.Serializable;

/**
 * 饿汉式单例模式
 *
 * @author huyunxiu01@gmail.com
 */
public class HungrySingleton implements Serializable {

    static {
        INSTANCE = new HungrySingleton();
    }

    private HungrySingleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("单例模式禁止反射调用");
        }
    }

    private final static HungrySingleton INSTANCE;

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }

    /**
     * 防止单例被序列化破坏
     *
     * @return 返回实例
     */
    private Object readResolve() {
        return INSTANCE;
    }
}
