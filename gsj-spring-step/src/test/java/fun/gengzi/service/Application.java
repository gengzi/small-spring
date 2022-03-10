package fun.gengzi.service;


import fun.gengzi.BeanFactory;
import fun.gengzi.factory.config.BeanDefinition;
import fun.gengzi.factory.support.DefaultListableBeanFactory;

public class Application {

    public static void main(String[] args) {

        // 注册一个Beandefinition
        BeanDefinition beanDefinition = new BeanDefinition(GengziService.class);
        // 将beandefinition 和 beanname 注册为bean 对象，放入单例池中
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("gengziService",beanDefinition);

        GengziService gengziService = (GengziService) defaultListableBeanFactory.getBean("gengziService");
        gengziService.print();

        GengziService gengziService1 = (GengziService) defaultListableBeanFactory.getBean("gengziService"); // 单例池
        gengziService1.print();

    }
}
