import java.util.Scanner;

public class Exemplo13 {

    public static final int LENGTH = 5;

    public static Scanner input = new Scanner(System.in);

    public static void readPerson(Person p) {
        System.out.print("Type the name: ");
        p.name = input.nextLine();
        System.out.print("Type the age: ");
        p.age = input.nextInt();
        System.out.print("Type the weight: ");
        p.weight = input.nextDouble();
        System.out.print("Type the height: ");
        p.height = input.nextDouble();
        input.nextLine();
    }

    public static void printNormalPerson(Person p) {
        System.out.println("-----Print-----");
        System.out.println("Name: " + p.name);
        System.out.println("Age: " + p.age);
        System.out.println("Weight: " + p.weight);
        System.out.println("Height: " + p.height);
    }

    public static void printPerson(Person p) {
        System.out.println("-----Print-----");
        //System.out.println("(" + p.name + ", " + p.age + " years, " + p.weight + " kg, " + p.height + " m)");
        System.out.printf("(%s, %d years, %.2f kg, %.2f m, BMI = %.2f)\n", p.name, p.age, p.weight, p.height, getBodyMassIndex(p));
        //System.out.println(p);
    }

    public static double getBodyMassIndex(Person p) {
        return p.weight/(p.height*p.height);
    }

    public static int getIndexPersontaller(Person[] p, int size) {
        int idx_taller = 0;
        if (size <= 0) {
            return -1;
        }
        for (int i = 1; i < size; i++) {
            if(p[idx_taller].height < p[i].height) {
                idx_taller = i;
            }
        }
        return idx_taller;
    }

    public static double getAverageAge(Person[] p, int size) {
        int sum_age = 0;
        if (size <= 0) {
            return -1.0;
        }
        for (int i = 0; i < size; i++) {
            sum_age += p[i].age;
        }
        return (double)sum_age/(double)size;
    }

    public static double getStdAge(Person[] p, int size) {
        double average_age = getAverageAge(p, size);
        double std_age = 0;
        if (size <= 1) {
            return 0.0;
        }
        for (int i = 0; i < size; i++) {
            std_age += (p[i].age - average_age)*(p[i].age - average_age);
        }
        return Math.sqrt(std_age/(double)(size-1));
    }

    public static void main(String[] args) {
       Person[] people = new Person[LENGTH];
       int idx_taller;
       double average_age, std_age;
       for (int i = 0; i < people.length; i++) {
        System.out.println("-----ENTERING "+(i+1)+"-----");
        people[i] = new Person();
        readPerson(people[i]);
       }
       for (int i = 0; i < people.length; i++) {
        printPerson(people[i]);
       }
       idx_taller = getIndexPersontaller(people, LENGTH);
       System.out.println("The taller person has the idx " + idx_taller);
       average_age = getAverageAge(people, LENGTH);
       System.out.println("The average age is " + average_age);
       std_age = getStdAge(people, LENGTH);
       System.out.println("The std age is " + std_age);
    }
}