import java.io.*;
import java.util.*;

public class StudentApp {

    private static final String FILE_NAME = "students.txt";
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        students = loadStudents();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    System.out.println("Thank you!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent(Scanner sc) {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        Student student = new Student(id, name, age);

        students.add(student);
        saveStudent(student);

        System.out.println("Student saved successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void searchStudent(Scanner sc) {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student Found: " + s);
                return;
            }
        }

        System.out.println("Student not found.");
    }

    private static void saveStudent(Student student) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(student.toFileString() + "\n");
        } catch (IOException e) {
            System.out.println("Error writing student data.");
        }
    }

    private static List<Student> loadStudents() {
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                list.add(Student.fromFileString(line));
            }

        } catch (FileNotFoundException e) {
            // File does not exist yet
        } catch (IOException e) {
            System.out.println("Error reading student data.");
        }

        return list;
    }
}

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toFileString() {
        return id + "," + name + "," + age;
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");

        return new Student(
                Integer.parseInt(parts[0]),
                parts[1],
                Integer.parseInt(parts[2])
        );
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}