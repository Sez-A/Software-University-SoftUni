import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String concealedMessage = scan.nextLine();

        StringBuilder sb = new StringBuilder(concealedMessage);
        String command;


        while (!(command = scan.nextLine()).equals("Reveal")) {
            String[] tokens = command.split(":\\|:");
            switch (tokens[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    sb.insert(index, " ");
                    concealedMessage = sb.toString();
                    System.out.println(concealedMessage);
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    if (concealedMessage.contains(substring)) {
                        int ind = concealedMessage.indexOf(substring);
                        String substring1 = concealedMessage.substring(ind, ind + substring.length());
                        sb.replace(ind, ind + substring.length(), "");
                        //concealedMessage = concealedMessage.replaceFirst(substring1, "");
                        concealedMessage = sb.toString();
                        substring1 = reverseString(substring1);
                        concealedMessage = concealedMessage + substring1;
                        sb = new StringBuilder(concealedMessage);
                        // TODO
                        System.out.println(concealedMessage);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    concealedMessage = concealedMessage.replaceAll(tokens[1], tokens[2]);
                    sb = new StringBuilder(concealedMessage);
                    System.out.println(concealedMessage);
                    break;
            }
        }

        System.out.println("You have a new text message: " + concealedMessage);
    }

    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

}
