package fun.gengzi.factory.support;

import cn.hutool.core.bean.BeanUtil;
import fun.gengzi.PropertyValue;
import fun.gengzi.PropertyVlues;
import fun.gengzi.factory.config.BeanDefinition;
import fun.gengzi.factory.config.BeanReference;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Collections;

/**
 * 抽象具有自动注入能力的bean工厂
 * <p>
 * 用于创建bean实例
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private CglibSubclassingInstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args) {
        Class beanClass = beanDefinition.getBeanClass();
        Object instance = null;
        Constructor constructor = null;
        // 获取bean 的构造器集合
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : declaredConstructors) {
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructor = ctor;
                break;
            }
        }
        // 实例化对象
        instance = instantiationStrategy.instantiate(beanName, beanDefinition, constructor, args);

        // 封装属性
        populateBean(beanName, instance, beanDefinition);

        this.registerSingleton(beanName, instance);
        return instance;
    }


    /**
     * 对bean 实例，设置属性。包含基础数据类型和对象类型（引用）
     *
     * @param beanName
     * @param instance
     * @param beanDefinition
     */
    private void populateBean(String beanName, Object instance, BeanDefinition beanDefinition) {
        PropertyVlues propertyVlues = beanDefinition.getPropertyVlues();
        if (propertyVlues == null) {
            return;
        }
        PropertyValue[] propertyValue = propertyVlues.getPropertyValue();
        if (propertyValue == null || propertyValue.length == 0) {
            // 不存在属性，无需注入
            return;
        }
        for (int i = 0; i < propertyValue.length; i++) {
            if (propertyValue[i].getValue() instanceof BeanReference) {
                // 对象bean，需要从bean实例池中查找到这个bean实例
                BeanReference value = (BeanReference) propertyValue[i].getValue();
                String beanName1 = value.getBeanName();
                Object bean = getBean(beanName1);
                BeanUtil.setFieldValue(instance, propertyValue[i].getKey(), bean);
            }else {
                // 基础数据类型
                BeanUtil.setFieldValue(instance, propertyValue[i].getKey(), propertyValue[i].getValue());
            }

        }


    }
}
