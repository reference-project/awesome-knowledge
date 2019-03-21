package com.github.huyunxiu.pattern.singleton;

/**
 * 枚举单例模式
 *
 * @author huyunxiu01@gmail.com
 */
public enum EnumSingleton {

    INSTANCE;

    private Object data;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
