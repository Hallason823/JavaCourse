import java.util.Scanner;

public class Question10 {
    public static final int AMOUNT_STUDENTS = 15;

    public static Scanner input = new Scanner(System.in);

    public static void getGrades(String message, double[] grades) {
        int count = 0;
        while (count < grades.length) {
            System.out.printf(message, count+1);
            grades[count] = input.nextDouble();
            if (grades[count] >= 0) {
                count ++;
            }
            else {
                System.out.printf("\nInvalidy input, the input should be non negative. TRY AGAIN!\n");
            }
        }
    }

    public static void printAverageOfStudents(double[] grades) {
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        System.out.printf("\nThe average of grades is %.2f.", sum/grades.length);
    }
    
    public static void main(String[] args) {
        double[] grades = new double[AMOUNT_STUDENTS];
        getGrades("\nType the grade %dº: ", grades);
        printAverageOfStudents(grades);
    }
}
