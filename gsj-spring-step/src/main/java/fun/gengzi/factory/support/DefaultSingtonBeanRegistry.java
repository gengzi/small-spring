package fun.gengzi.factory.support;

import fun.gengzi.factory.config.SingletonBeanRegistry;
import sun.net.util.IPAddressUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 默认的单例bean 注册
 * <p>
 * 获取单例bean
 * <p>
 * 注册单例bean
 */
public class DefaultSingtonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 存放所有的单例bean
     */
    private final Map<String, Object> singletonObjects = new HashMap<String, Object>(256);


    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    /**
     * 注册单例bean
     *
     * @param beanName beanName
     * @param object   bean对象
     */
    protected void registerSingleton(String beanName, Object object) {
        singletonObjects.put(beanName, object);
    }


}
