import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        Map<String, ArrayList<String>> companies = new TreeMap<>();
        while (!"End".equals(input)) {
            String[] tokens = input.split("->");
            for (int i = 0; i < tokens.length; i++) {
                tokens[i] = tokens[i].trim();
            }
            String companyName = tokens[0];
            String user = tokens[1];
            if(!companies.containsKey(companyName)){
                companies.put(companyName,new ArrayList<>());
            }if(companies.containsKey(companyName) && !companies.get(companyName).contains(user)){
                companies.get(companyName).add(user);
            }
            input = scan.nextLine();
        }
        companies
                .entrySet()
                .stream()
                .forEach(c -> {
                    System.out.println(String.format("%s",c.getKey()));
                    c.getValue()
                            .forEach(e-> System.out.println(String.format("--%s",e)));
                });
    }
}