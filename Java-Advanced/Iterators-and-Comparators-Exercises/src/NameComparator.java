import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().length() == o2.getName().length()) {
            String o1FirstLetter = o1.getName().substring(0, 1).toLowerCase();
            String o2FirstLetter = o2.getName().substring(0, 1).toLowerCase();

            return o1FirstLetter.compareTo(o2FirstLetter);
        }

        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
