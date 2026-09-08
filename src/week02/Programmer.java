package week02;

public class Programmer extends Employee implements Workable{
    private String language;
    public Programmer(){}
    public Programmer(String id,String name,double salary,String language) {
        super(id,name,salary);
        this.language = language;
    }

    @Override
    public void introduce() {
        System.out.println("员工编号：" + getId() +
                "，姓名：" + getName() +
                "，工资：" + getSalary() +
                "，主要编程语言：" + language);
    }
    @Override
    public void work() {
        System.out.println("程序员正在编写代码");
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
