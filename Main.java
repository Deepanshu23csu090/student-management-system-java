import java.util.Scanner;

public class Main {

    public static int getValidInt(Scanner sc, String message) {

        while (true) {

            try {

                System.out.print(message);
                int value = sc.nextInt();
                sc.nextLine();

                return value;

            } catch (Exception e) {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }

    public static String getValidName(Scanner sc, String message) {

    while (true) {

        System.out.print(message);
        String name = sc.nextLine().trim();

        if (name.matches("[a-zA-Z ]+")) {
            return name;
        }

        System.out.println("Name should contain only alphabets.");
    }
}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Verify Student");
            System.out.println("7. Approve Student");
            System.out.println("8. Reject Student");
            System.out.println("9. Exit");

            choice = getValidInt(sc, "Enter Choice: ");

            switch (choice) {

                case 1 -> {

                    int id = getValidInt(sc, "Enter ID: ");

                    String name = getValidName(sc, "Enter Name: ");
                    

                    int age = getValidInt(sc, "Enter Age: ");

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student student =
                            new Student(id, name, age, course);

                    manager.addStudent(student);
                }

                case 2 -> manager.viewStudents();

                case 3 -> {

                    int searchId =
                            getValidInt(sc, "Enter ID: ");

                    Student found =
                            manager.searchStudent(searchId);

                    if (found != null) {

                        System.out.println("\n----------------");
                        System.out.println(found);

                    } else {

                        System.out.println("Student Not Found");
                    }
                }

                case 4 -> {

                        int updateId =
                            getValidInt(sc, "Enter ID: ");

                        String newName =
                            getValidName(sc, "New Name: ");

                         int newAge =
                            getValidInt(sc, "New Age: ");

                        System.out.print("New Course: ");
                        String newCourse = sc.nextLine();

                        manager.updateStudent(
                        updateId,
                        newName,
                        newAge,
                        newCourse);
                        }

                case 5 -> {

                    int deleteId =
                            getValidInt(sc, "Enter ID: ");

                    manager.deleteStudent(deleteId);
                }

                case 6 -> {

                    int verifyId =
                            getValidInt(sc, "Enter ID: ");

                    manager.verifyStudent(verifyId);
                }

                case 7 -> {

                    int approveId =
                            getValidInt(sc, "Enter ID: ");

                    manager.approveStudent(approveId);
                }

                case 8 -> {

                    int rejectId =
                            getValidInt(sc, "Enter ID: ");

                    manager.rejectStudent(rejectId);
                }

                case 9 -> System.out.println("Thank You");

                default -> System.out.println("Invalid Choice");
            }

        } while (choice != 9);

        sc.close();
    }
}