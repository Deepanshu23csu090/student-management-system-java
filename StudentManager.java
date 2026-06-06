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

    // =========================
    // WORKFLOW METHODS
    // =========================

    public void verifyStudent(int id) {

        Student student = searchStudent(id);

        if (student != null) {

            if (student.getStatus().equals("PENDING")) {

                student.setStatus("VERIFIED");

                saveStudents();

                System.out.println("Student Verified");

            } else {

                System.out.println(
                        "Only PENDING students can be verified.");
            }

        } else {

            System.out.println("Student Not Found");
        }
    }

    public void approveStudent(int id) {

        Student student = searchStudent(id);

        if (student != null) {

            if (student.getStatus().equals("VERIFIED")) {

                student.setStatus("APPROVED");

                saveStudents();

                System.out.println("Student Approved");

            } else {

                System.out.println(
                        "Student must be VERIFIED before approval.");
            }

        } else {

            System.out.println("Student Not Found");
        }
    }

    public void rejectStudent(int id) {

        Student student = searchStudent(id);

        if (student != null) {

            if (!student.getStatus().equals("APPROVED")) {

                student.setStatus("REJECTED");

                saveStudents();

                System.out.println("Student Rejected");

            } else {

                System.out.println(
                        "Approved students cannot be rejected.");
            }

        } else {

            System.out.println("Student Not Found");
        }
    }

    // =========================
    // FILE HANDLING
    // =========================

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
                        s.getCourse() + "," +
                        s.getStatus());

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
                String status = data[4];

                students.add(
                        new Student(
                                id,
                                name,
                                age,
                                course,
                                status));
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("Error loading students.");
        }
    }
}