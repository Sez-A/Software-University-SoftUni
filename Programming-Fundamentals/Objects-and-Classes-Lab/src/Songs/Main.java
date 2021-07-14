package Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int songsCnt = Integer.parseInt(scan.nextLine());
        List<Songs> songs = new ArrayList<>();
        for (int i = 0; i < songsCnt; i++) {
            String[] data = scan.nextLine().split("_");
            String type = data[0];
            String name = data[1];
            String time = data[2];

            Songs song = new Songs();
            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);
            songs.add(song);
        }
        String typeList = scan.nextLine();
        if (typeList.equals("all")) {
            for (Songs song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Songs song : songs) {
                if (song.getTypeList().equals(typeList)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
