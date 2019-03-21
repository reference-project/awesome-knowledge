package com.github.huyunxiu.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 分布式锁Redis实现，基于SpringBoot2
 *
 * @author huyunxiu01@gmail.com
 * @since 2019-03-18
 */
@Component
@Slf4j
public class RedisLock {

    @Resource
    private StringRedisTemplate locaRedisTemplate;

    /**
     * 加锁
     *
     * @param key 要加锁的键去
     * @param value 当前时间 + 超时时间
     * @return 锁是否已经加上
     */
    public boolean lock(String key, String value) {
        if (locaRedisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        String currentValue = locaRedisTemplate.opsForValue().get(key);

        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {
            String oldValue = locaRedisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 解锁
     *
     * @param key 要解锁的键
     * @param value 当前时间 + 超时时间
     */
    public void unlock(String key, String value) {
        try {
            String currentValue = locaRedisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
                locaRedisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {
            String msg = String.format("[Distributed redis lock]: %s unlock error", key);
            log.error(msg, e);
        }
    }
}
