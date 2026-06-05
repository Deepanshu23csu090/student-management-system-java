import java.io.*;
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();
    private final String FILE_NAME = "students.txt";

    public StudentManager() {
        loadStudents();
    }

    public void addStudent(Student student) {

        if (searchStudent(student.getId()) != null) {
            System.out.println("Student ID Already Exists");
            return;
        }

        students.add(student);
        saveStudents();

        System.out.println("Student Added Successfully");
    }

    public void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found");
            return;
        }

        for (Student s : students) {

            System.out.println("----------------");
            System.out.println(s);
        }
    }

    public Student searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    public void deleteStudent(int id) {

        Student student = searchStudent(id);

        if (student != null) {

            students.remove(student);

            saveStudents();

            System.out.println("Student Deleted");

        } else {

            System.out.println("Student Not Found");
        }
    }

    public void updateStudent(
            int id,
            String name,
            int age,
            String course) {

        Student student = searchStudent(id);

        if (student != null) {

            student.setName(name);
            student.setAge(age);
            student.setCourse(course);

            saveStudents();

            System.out.println("Student Updated");

        } else {

            System.out.println("Student Not Found");
        }
    }

    private void saveStudents() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(FILE_NAME));

            for (Student s : students) {

                writer.write(
                        s.getId() + "," +
                        s.getName() + "," +
                        s.getAge() + "," +
                        s.getCourse());

                writer.newLine();
            }

            writer.close();

        } catch (Exception e) {

            System.out.println("Error saving students.");
        }
    }

    private void loadStudents() {

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) {
                return;
            }

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];

                students.add(
                        new Student(
                                id,
                                name,
                                age,
                                course));
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("Error loading students.");
        }
    }
}