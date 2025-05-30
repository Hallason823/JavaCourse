import java.util.Scanner;

public class Exemplo12 {

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

    public static void main(String[] args) {
        Person p1 = new Person(), p2 = new Person();
        readPerson(p1);
        readPerson(p2);
        printPerson(p1);
        printPerson(p2);
    }
}