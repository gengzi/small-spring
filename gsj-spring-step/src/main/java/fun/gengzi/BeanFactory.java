package fun.gengzi;


/**
 * Bean 工厂
 * <p>
 * <p>
 * 获取bean
 */
public interface BeanFactory {


    /**
     * 获取bean 对象
     *
     * @param beanName
     * @return
     */
    Object getBean(String beanName);


    /**
     * 获取bean对象
     * @param beanName
     * @param args 多个参数
     * @return
     */
    Object getBean(String beanName, Object... args);


}
