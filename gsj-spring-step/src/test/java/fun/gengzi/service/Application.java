package fun.gengzi.service;


import fun.gengzi.BeanFactory;
import fun.gengzi.PropertyVlues;
import fun.gengzi.factory.config.BeanDefinition;
import fun.gengzi.factory.config.BeanReference;
import fun.gengzi.factory.config.RuntimeBeanNameReference;
import fun.gengzi.factory.support.DefaultListableBeanFactory;

public class Application {

    public static void main(String[] args) {

        BeanDefinition beanDefinition1 = new BeanDefinition(GengziDao.class);

        // 将beandefinition 和 beanname 注册为bean 对象，放入单例池中
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();


        PropertyVlues propertyVlues = new PropertyVlues();
        propertyVlues.addPropertyVlaue("dao",new RuntimeBeanNameReference("dao"));

        // 注册一个Beandefinition
        BeanDefinition beanDefinition = new BeanDefinition(GengziService.class);
        beanDefinition.setPropertyVlues(propertyVlues);

        defaultListableBeanFactory.registerBeanDefinition("gengziService",beanDefinition);
        defaultListableBeanFactory.registerBeanDefinition("dao",beanDefinition1);

        GengziDao dao = (GengziDao) defaultListableBeanFactory.getBean("dao","lisi");


        GengziService gengziService = (GengziService) defaultListableBeanFactory.getBean("gengziService","zhangsan");
        gengziService.print();

        GengziService gengziService1 = (GengziService) defaultListableBeanFactory.getBean("gengziService"); // 单例池
        gengziService1.print();

    }
}
