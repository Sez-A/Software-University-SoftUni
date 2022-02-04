package studentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String command = "";

        StudentSystem studentSystem = new StudentSystem();
        while (!(command = scan.nextLine()).equals("Exit")) {
            String[] tokens = command.split("\\s+");
            studentSystem.parseCommand(tokens);
        }
    }
}
