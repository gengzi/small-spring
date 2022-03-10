package fun.gengzi.factory.config;

public class RuntimeBeanNameReference implements BeanReference {


    private String beanName;

    public RuntimeBeanNameReference(String beanName) {
        this.beanName = beanName;
    }

    /**
     * 获取Bean名称
     *
     * @return
     */
    public String getBeanName() {
        return beanName;
    }
}
