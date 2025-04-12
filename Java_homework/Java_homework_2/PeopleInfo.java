import java.util.Scanner;
import java.util.ArrayList;

public class PeopleInfo {

    private ArrayList<Person> people_info = new ArrayList<>();
    private int info_number;

    public static Scanner input = new Scanner(System.in);

    public static Person getPersonInfo() {
        Person person_info = new Person();
        System.out.print("\nType the person gender (M or F): ");
        person_info.setGender(input.next());
        System.out.print("Type the person age (years): ");
        person_info.setAge(input.nextInt());
        System.out.print("Type the person weight (kg): ");
        person_info.setWeight(input.nextDouble());
        return person_info;
    }

    public void getPeopleInfo() {
        String user_answer;
        do {
            this.people_info.add(getPersonInfo());
            System.out.println("\nWould you like to insert other products? (Type \"y\" to confirm)");
            user_answer = input.next();
        } while (user_answer.equalsIgnoreCase("y"));
        info_number = people_info.size();
    }

    public double[] getHeaviestPerson() {
        double[] max_weight_info = {this.people_info.get(0).getAge(), this.people_info.get(0).getWeight()};
        for (int i = 1; i < this.info_number; i++) {
            if (max_weight_info[1] < this.people_info.get(i).getWeight()) {
                max_weight_info = new double[]{this.people_info.get(i).getAge(), this.people_info.get(i).getWeight()};
            }
        }
        return max_weight_info;
    }

    public boolean getUniquenessHeaviestPerson(double[] max_weight_info) {
        boolean uniqueness_heaviest_person = true;
        int heaviest_people_amount = 0, count = 0;
        while (uniqueness_heaviest_person == true && count < this.info_number) {
            if (max_weight_info[1] == this.people_info.get(count).getWeight()) {
                heaviest_people_amount += 1;
                if (heaviest_people_amount > 1) {
                    uniqueness_heaviest_person = false;
                }
            }
            count += 1;
        }
        return uniqueness_heaviest_person;
    }

    public double getYoungMenPercentage(int limit_young_man) {
        double[] men_amount = {0.0, 0.0};
        for (int i = 0; i < this.info_number; i++) {
            if (this.people_info.get(i).getGender().equalsIgnoreCase("m")) {
                if (this.people_info.get(i).getAge() < limit_young_man) {
                    men_amount[0] += 1.0;
                    men_amount[1] += this.people_info.get(i).getWeight();
                }
            }
        }
        return men_amount[0] != 0.0 ? (men_amount[1]/men_amount[0]) : 0.0;
    }

    public double getThinWomenPercentage(int limit_thin_woman) {
        int[] women_amount = {0, 0};
        for (int i = 0; i < this.info_number; i++) {
            if (this.people_info.get(i).getGender().equalsIgnoreCase("f")) {
                women_amount[0] += 1;
                if (this.people_info.get(i).getWeight() < limit_thin_woman) {
                    women_amount[1] += 1;
                }
            }
        }
        return women_amount[0] != 0 ? ((double) women_amount[1]/women_amount[0])*100 : 0.0;
    }

    public void printUsefulInfo(int limit_young_man, int limit_thin_woman) {
        double[] max_weight_info = getHeaviestPerson();
        boolean uniqueness_heaviest_person = getUniquenessHeaviestPerson(max_weight_info);
        double young_man_aver_weight = getYoungMenPercentage(limit_young_man), thin_woman_percentage = getThinWomenPercentage(limit_thin_woman);
        System.out.print("\nThe informations:");
        if (uniqueness_heaviest_person) {
            System.out.print("\nThe heaviest person has the age: " + max_weight_info[0] + ".");
        }
        else {
            System.out.print("\nThe uniqueness the heaviest person is false.");
        }
        System.out.printf("\nThe medium weight of the young men is: ");
        System.out.printf(young_man_aver_weight != 0.0 ? "%,.2f kg." : "null", young_man_aver_weight);        
        System.out.printf("\nThe percentage of the thin women is: %,.2f%%.", thin_woman_percentage);
    }
}