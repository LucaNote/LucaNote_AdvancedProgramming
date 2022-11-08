package be.vives.ti.map;

public class Student {

    private String rNumber;
    private String name;
    private String className;

    public Student(String rNumber, String name, String className) {
        this.rNumber = rNumber;
        this.name = name;
        this.className = className;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getrNumber() {
        return rNumber;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public int hashCode(){
        return name.length();
    }

    @Override
    public String toString() {
        return "Student{" +
                "rNumber='" + rNumber + '\'' +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}