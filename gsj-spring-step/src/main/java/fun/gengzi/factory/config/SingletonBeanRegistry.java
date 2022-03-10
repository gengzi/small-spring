package fun.gengzi.factory.config;


/**
 * 单例bean 注册
 * <p>
 * <p>
 * 获取单例bean
 */
public interface SingletonBeanRegistry {


    Object getSingleton(String beanName);
}
