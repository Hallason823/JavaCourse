import java.util.Scanner;

public class ManagerStudents {

    public static final int AMOUNT_STUDENTS = 10;

    public static Scanner input = new Scanner(System.in);

    public static void addSingleStudent(Student student) {
      System.out.print("Type the name: ");
      student.name = input.nextLine();
      System.out.print("Type the registration: ");
      student.registration = input.nextLine();
      System.out.print("Type the final average grade: ");
      student.finalAverageGrade = input.nextDouble();
      input.nextLine();
    }

    public static void printSingleStudent(Student student) {
        System.out.printf("{NAME: %s,REGISTRATION: %s,FINAL AVERAGE GRADE: %.2f}\n", 
                          student.name, student.registration, student.finalAverageGrade);
    }

    public static void addStudents(Student[] students, int size) {
        int max_length = Math.min(size, students.length);
        for (int i = 0; i < max_length; i++) {
            System.out.printf("-------ENTERING STUDENT %d-------\n", i+1);
            students[i] = new Student();
            addSingleStudent(students[i]);
        }
    }

    public static void printStudents(Student[] students, int size, String message) {
        int max_length = Math.min(size, students.length);
        System.out.println(message);
        for (int i = 0; i < max_length; i++) {
            printSingleStudent(students[i]);
        }
    }

    public static int[] splitStudentsByPerformance(Student[] all_students, Student[] passed_students, Student[] failed_students, int size, double approval_criteria) {
        int max_length = Math.min(size, all_students.length);
        int[] counts = {0, 0};
        for (int i = 0; i < max_length; i++) {
            if (all_students[i].finalAverageGrade >= approval_criteria) {
                passed_students[counts[0]] = all_students[i];
                counts[0] += 1;
            }
            else {
                failed_students[counts[1]] = all_students[i];
                counts[1] += 1;
            }
        }
        return counts;
    }

    public static int[] splitStudentsByPerformance(Student[] all_students, Student[] passed_students, Student[] failed_students, int size) {
        return splitStudentsByPerformance(all_students, passed_students, failed_students, size, 5.0);
    }

    public static void main (String[] args) {
        Student[] students = new Student[AMOUNT_STUDENTS], passed_students = new Student[AMOUNT_STUDENTS], failed_students = new Student[AMOUNT_STUDENTS];
        int[] split_counts = new int[2];
        addStudents(students, AMOUNT_STUDENTS);
        printStudents(students, AMOUNT_STUDENTS, "-------PRITING ALL STUDENTS-------");
        split_counts = splitStudentsByPerformance(students, passed_students, failed_students, AMOUNT_STUDENTS);
        printStudents(passed_students, split_counts[0], "-------PRITING PASSED STUDENTS-------");
        printStudents(failed_students, split_counts[1], "-------PRITING FAILED STUDENTS-------");
    }
}