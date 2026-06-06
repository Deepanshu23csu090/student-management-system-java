public class Student {

    private int id;
    private String name;
    private int age;
    private String course;
    private String status;

    // Constructor for new students
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.status = "PENDING";
    }

    // Constructor for loading students from file
    public Student(int id, String name, int age, String course, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.status = status;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nName: " + name +
                "\nAge: " + age +
                "\nCourse: " + course +
                "\nStatus: " + status;
    }
}