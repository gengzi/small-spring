package fun.gengzi.factory.support;


import fun.gengzi.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化策略
 *
 *
 */
public interface InstantiationStrategy {


    /**
     * 实例化bean对象
     * @param beanName beanname
     * @param beanDefinition bean的定义信息
     * @param args 构造器参数
     * @return
     */
    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object... args);


}
