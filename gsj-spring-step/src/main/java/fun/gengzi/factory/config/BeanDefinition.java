package fun.gengzi.factory.config;


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

    public BeanDefinition(Class clazz) {
        this.clazz = clazz;
    }

    public Class getBeanClass() {
        return this.clazz;
    }
}
