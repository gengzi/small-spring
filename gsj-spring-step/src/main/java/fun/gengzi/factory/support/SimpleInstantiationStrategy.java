package fun.gengzi.factory.support;

import fun.gengzi.BeansException;
import fun.gengzi.factory.config.BeanDefinition;

import java.beans.Beans;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * 简单实例化策略
 * <p>
 * class 的实例化
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    /**
     * 实例化bean对象
     *
     * @param beanName       beanname
     * @param beanDefinition bean的定义信息
     * @param ctor
     * @param args           构造器参数
     * @return
     */
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor ctor, Object... args) {
        try {
            Class beanClass = beanDefinition.getBeanClass();
            if (ctor != null) {
                return beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        throw new BeansException("error instance " + beanName);
    }
}
