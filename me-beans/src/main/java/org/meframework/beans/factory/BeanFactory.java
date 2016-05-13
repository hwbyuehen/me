package org.meframework.beans.factory;

import org.meframework.beans.BeansException;

/**
 * Created by ht on 2016/5/11.
 */
public interface BeanFactory {
    /**
     * 加&前缀表示返回Bean工厂，而不是Bean
     */
    String FACTORY_BEAN_PREFIX = "&";

    /**
     * 根据指定名字返回特定Bean对象
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;

    /**
     * 根据指定类型返回指定对象实例
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;

    /**
     *返回特定类型唯一匹配的对象
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(Class<T> requiredType) throws BeansException;

    /**
     * 根据名称返回实例，可以指定共享或独立
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 根据类型返回实例，可以指定共享或独立
     * @param requiredType
     * @param args
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(Class<T> requiredType, Object... args) throws BeansException;

    /**
     * 类工厂是否包含特定名称的Bean
     * @param name
     * @return
     */
    boolean containsBean(String name);

    boolean isSingleton(String name) throws NoSuchBeanDefinitionException;
    // TODO
}
