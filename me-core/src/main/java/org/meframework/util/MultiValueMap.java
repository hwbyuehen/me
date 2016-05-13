package org.meframework.util;

import java.util.List;
import java.util.Map;

/**
 * 扩展Map的接口，可以存储多类型的值
 * Created by ht on 2016/5/12.
 */
public interface MultiValueMap<K, V> extends Map<K, List<V>> {

    /**
     * 通过给定的key返回List下的第一个值
     * @param key
     * @return
     */
    V getFirst(K key);

    /**
     * 给定的单个值添加到给定键的值的当前列表中
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 将指定的项存在指定key中
     * @param key
     * @param value
     */
    void set(K key, V value);

    /**
     * 将该map值放入当前容器的下面
     * @param values
     */
    void setAll(Map<K, V> values);

    /**
     * 返回这个Map第一个值
     * @return
     */
    Map<K, V> toSingleValueMap();
}
