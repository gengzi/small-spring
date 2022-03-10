package fun.gengzi.factory.support;

import fun.gengzi.factory.config.BeanDefinition;

public interface BeanDefinitionRegister {

    /**
     *  注册bean定义信息到 bean定义信息池
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
