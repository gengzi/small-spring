package fun.gengzi.factory.support;

import fun.gengzi.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends  AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        Object instance = null;
        try {
            instance = beanClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        this.registerSingleton(beanName,instance);
        return instance;
    }
}
