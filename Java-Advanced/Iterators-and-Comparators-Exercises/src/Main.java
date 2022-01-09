import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());


        NameComparator nameComparator = new NameComparator();
        AgeComparator ageComparator = new AgeComparator();

        Set<Person> nameSet = new TreeSet<>(nameComparator);
        Set<Person> ageSet = new TreeSet<>(ageComparator);

        while (n-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            nameSet.add(person);
            ageSet.add(person);
        }


        for (Person person : nameSet) {
            System.out.println(person);
        }

        for (Person person : ageSet) {
            System.out.println(person);
        }

    }
}
