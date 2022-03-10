package fun.gengzi.factory.support;


import fun.gengzi.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * cglib 形式实例化对象策略
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
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

        Class beanClass = beanDefinition.getBeanClass();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanClass);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (ctor == null) {
            return enhancer.create();
        }
        return enhancer.create(ctor.getParameterTypes(), args);
    }
}
