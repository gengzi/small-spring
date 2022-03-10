package fun.gengzi.service;

public class GengziService {

    private String name;

    private GengziDao dao;

    public GengziDao getDao() {
        return dao;
    }

    public void setDao(GengziDao dao) {
        this.dao = dao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GengziService(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("打印对象" + name + dao);
    }

}
