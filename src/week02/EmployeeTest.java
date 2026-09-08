package week02;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new Employee("001", "张三", 6000);
        employees[1] = new Programmer("002", "李四", 10000, "Java");
        employees[2] = new Programmer("003", "王五", 11000, "Python");
        employees[3] = new Manager("004", "赵六", 15000, 10);

        for(Employee employee : employees) {
            employee.introduce();
        }

        Workable[] workers = new Workable[3];

        workers[0] = new Programmer("002", "李四", 10000, "Java");
        workers[1] = new Programmer("003", "王五", 11000, "Python");
        workers[2] = new Manager("004", "赵六", 15000, 10);

        for(Workable workable : workers) {
            workable.work();
        }
    }
}
