package fun.gengzi.factory.support;


import fun.gengzi.BeanFactory;
import fun.gengzi.factory.config.BeanDefinition;

/**
 * 抽象类
 * 抽象bean工厂
 * <p>
 * 获取bean定义信息
 * <p>
 * 生成单例bean
 */
public abstract class AbstractBeanFactory extends DefaultSingtonBeanRegistry implements BeanFactory {

    /**
     * 获取bean
     *
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        // 从单例池中获取
        Object singleton = this.getSingleton(beanName);
        if (singleton != null) {
            return singleton;
        }
        // 注册创建bean
        BeanDefinition beanDefinition = this.getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);

    }

    /**
     * 获取bean 定义信息
     *
     * @param beanName beanName
     * @return
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName);


    /**
     * 根据bean定义信息创建bean
     *
     * @param beanName       beanname
     * @param beanDefinition bean定义信息
     * @return
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);


}
