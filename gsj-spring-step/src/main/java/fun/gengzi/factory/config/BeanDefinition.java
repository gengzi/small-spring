package fun.gengzi.factory.config;


import fun.gengzi.PropertyVlues;

/**
 * 定义bean信息
 * <p>
 * <p>
 * 设置Bean 定义信息
 *
 * 是否延迟加载
 * 父类
 *
 *
 *
 *
 */
public class BeanDefinition {


    private Class clazz;

    private PropertyVlues propertyVlues;

    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
    }


    public PropertyVlues getPropertyVlues() {
        return propertyVlues;
    }

    public void setPropertyVlues(PropertyVlues propertyVlues) {
        this.propertyVlues = propertyVlues;
    }

    public Class getBeanClass() {
        return this.clazz;
    }
}
