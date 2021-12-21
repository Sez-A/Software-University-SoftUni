import java.util.*;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> initialGuests = Arrays.stream(scan.nextLine().split("\\s+"))
                .sorted()
                .collect(Collectors.toList());

        List<String> guests = new ArrayList<>(initialGuests);

        String command = "";
        while (!(command = scan.nextLine()).equals("Party!")) {
            String[] tokens = command.split("\\s+");
            int matchCnt = 0;
            String currentGuestName = "";
            guests = guests.stream().sorted(String::compareTo).collect(Collectors.toList());
            if (tokens[0].equals("Remove")) {
                switch (tokens[1]) {
                    case "StartsWith":
                        guests.removeIf(guest -> guest.startsWith(tokens[2]));
                        break;
                    case "Length":
                        int length = Integer.parseInt(tokens[2]);
                        guests.removeIf(guest -> guest.length() == length);
                        break;
                    case "EndsWith":
                        guests.removeIf(guest -> guest.endsWith(tokens[2]));
                        break;
                }
            } else if (tokens[0].equals("Double")) {

                switch (tokens[1]) {
                    case "StartsWith":
                        for (String guest : initialGuests) {
                            if (!currentGuestName.equals(guest)) {
                                matchCnt = nameExistNTimes(guests, guest);
                                if (guest.startsWith(tokens[2])) {
                                    for (int i = 0; i < matchCnt; i++) {
                                        guests.add(guest);
                                    }
                                }
                            }
                            currentGuestName = guest;
                        }
                        break;
                    case "Length":
                        int length = Integer.parseInt(tokens[2]);
                        for (String guest : initialGuests) {
                            if (!currentGuestName.equals(guest)) {
                                matchCnt = nameExistNTimes(guests, guest);
                                if (guest.length() == length) {
                                    for (int i = 0; i < matchCnt; i++) {
                                        guests.add(guest);
                                    }
                                }
                            }
                            currentGuestName = guest;
                        }
                        break;
                    case "EndsWith":
                        for (String guest : initialGuests) {
                            if (!currentGuestName.equals(guest)) {
                                matchCnt = nameExistNTimes(guests, guest);
                                if (guest.endsWith(tokens[2])) {
                                    for (int i = 0; i < matchCnt; i++) {
                                        guests.add(guest);
                                    }
                                }
                            }
                            currentGuestName = guest;
                        }
                        break;
                }
            }
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            guests = guests
                    .stream()
                    .sorted(String::compareTo)
                    .collect(Collectors.toList());

            System.out.print(String.join(", ", guests) + " are going to the party!");
        }
    }

    private static int nameExistNTimes(List<String> guests, String guest) {
        int cnt = 0;
        for (String current : guests) {
            if (current.equals(guest)) {
                cnt++;
            }
        }
        return cnt;
    }
}
