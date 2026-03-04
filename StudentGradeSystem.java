
import java.util.ArrayList;
import java.util.Scanner;

class Student {

    String name;
    ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double getAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }

        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.size();
    }

    public String getLetterGrade() {
        double avg = getAverage();

        if (avg >= 90) {
            return "A";
        } else if (avg >= 80) {
            return "B";
        } else if (avg >= 70) {
            return "C";
        } else if (avg >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}

public class StudentGradeSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {

            System.out.println("\n=== Student Grade System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Enter Grades");
            System.out.println("3. Display Student Grades");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    students.add(new Student(name));
                    System.out.println("Student added!");
                }

                case 2 -> {
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                        break;
                    }

                    System.out.println("Students:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).name);
                    }

                    System.out.print("Select student by number: ");
                    int sIndex = sc.nextInt() - 1;

                    if (sIndex < 0 || sIndex >= students.size()) {
                        System.out.println("Invalid selection!");
                        break;
                    }

                    System.out.print("Enter grade (0-100): ");
                    double grade = sc.nextDouble();

                    if (grade < 0 || grade > 100) {
                        System.out.println("Invalid grade!");
                        break;
                    }

                    students.get(sIndex).addGrade(grade);
                    System.out.println("Grade added!");
                }

                case 3 -> {
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                        break;
                    }

                    System.out.println("\nStudent Grades:");
                    for (Student student : students) {
                        System.out.println("\nName: " + student.name);
                        System.out.println("Grades: " + student.grades);
                        System.out.printf("Average: %.2f\n", student.getAverage());
                        System.out.println("Letter Grade: " + student.getLetterGrade());
                    }
                }

                case 4 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }

                default ->
                    System.out.println("Invalid option!");
            }
        }
    }
}
