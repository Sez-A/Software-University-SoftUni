import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            personList.add(person);
        }
        Map<String, Predicate<Person>> predicateMap = new HashMap<>();
        Map<String, Consumer<Person>> consumerMap = new HashMap<>();

        String condition = scan.nextLine();
        int target = Integer.parseInt(scan.nextLine());
        String format = scan.nextLine();

        predicateMap.put("younger", p -> p.getAge() <= target);
        predicateMap.put("older", p -> p.getAge() >= target);

        consumerMap.put("name", p -> System.out.println(p.getName()));
        consumerMap.put("age", p -> System.out.println(p.getAge()));
        consumerMap.put("name age" ,p ->System.out.println(p.getName() + " - " + p.getAge()));
        
        personList
                .stream()
                .filter(predicateMap.get(condition))
                .forEach(consumerMap.get(format));
    }
}
