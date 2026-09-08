package week02;

public class Manager extends Employee implements Workable{
    private int teamSize;

    public Manager(){}
    public Manager(String id,String name,double salary,int teamSize) {
        super(id,name,salary);
        setTeamSize(teamSize);
    }

    @Override
    public void introduce() {
        System.out.println("员工编号：" + getId() +
                "，姓名：" + getName() +
                "，工资：" + getSalary() +
                "，团队人数：" + teamSize);
    }
    @Override
    public void work() {
        System.out.println("经理正在管理团队");
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        if(teamSize < 1) {
            System.out.println("团队人数不能少于一！");
            return;
        }
        this.teamSize = teamSize;
    }
}
