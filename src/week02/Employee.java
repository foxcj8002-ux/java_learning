package week02;

public class Employee {
    private String id;
    private String name;
    private double salary;
    public Employee(){}
    public Employee(String id,String name,double salary) {
        this.id = id;
        this.name  = name;
        setSalary(salary);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 0) {
            System.out.println("薪资不能为负数！");
            return;
        }
        this.salary = salary;
    }

    public void introduce() {
        System.out.println("员工编号：" + id +
                "，姓名：" + name +
                "，工资：" + salary);
    }
}
