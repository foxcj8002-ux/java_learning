package week01;

public class Student {
    private final String id;
    private String name;
    private int age;
    private double score;


    public Student(String id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public boolean equals(Object object) {
        //情况1
        if(object == this) {
            return true;
        }
        //情况2
        if(!(object instanceof Student)) {
            return false;
        }
        //情况3
        Student student = (Student) object;

        return this.id.equals(student.id);
    }
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
    @Override
    public String toString() {
        return "Student{id='" + id +
                "', name='" + name +
                "', age=" + age +
                ", score=" + score +
                "}";
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if((name == null) || (name.isBlank())) {
            return false;
        }
        this.name = name;
        return true;
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if(age<0 || age>150) return false;
        this.age = age;
        return true;
    }

    public double getScore() {
        return score;
    }

    public boolean setScore(double score) {
        if(score<0 || score>100) return false;
        this.score = score;
        return true;
    }
}
