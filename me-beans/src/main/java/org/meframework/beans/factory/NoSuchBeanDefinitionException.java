package org.meframework.beans.factory;

import org.meframework.beans.BeansException;
import org.meframework.util.StringUtils;

/**
 * Created by ht on 2016/5/12.
 */
public class NoSuchBeanDefinitionException extends BeansException {

    /** 丢失的bean的名称 */
    private String beanName;

    /** 丢失的bean的类型 */
    private Class<?> beanType;

    public NoSuchBeanDefinitionException(String name) {
        super("No bean named '" + name + "' is defined");
        this.beanName = name;
    }

    public NoSuchBeanDefinitionException(String name, String message) {
        super("No bean named '" + name + "' is defined: " + message);
        this.beanName = name;
    }

    public NoSuchBeanDefinitionException(Class<?> type) {
        super("No qualifying bean of type [" + type.getName() + "] is defined");
        this.beanType = type;
    }

    public NoSuchBeanDefinitionException(Class<?> type, String message) {
        super("No qualifying bean of type [" + type.getName() + "] is defined: " + message);
        this.beanType = type;
    }

    public NoSuchBeanDefinitionException(Class<?> type, String dependencyDescription, String message) {
        super("No qualifying bean of type [" + type.getName() + "] fount for dependency" +
                (StringUtils.hasLength(dependencyDescription) ? " [" + dependencyDescription + "]" : "") +
                ": " + message);
        this.beanType = type;
    }

    public String getBeanName() {
        return beanName;
    }

    public Class<?> getBeanType() {
        return beanType;
    }

    public int getNumberOfBeansFount() {
        return 0;
    }
}
