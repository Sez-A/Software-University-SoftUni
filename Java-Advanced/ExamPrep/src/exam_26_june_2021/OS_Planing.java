package exam_26_june_2021;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OS_Planing {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        List<Integer> tasks = Arrays.stream(scan.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> threads = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int taskToKill = Integer.parseInt(scan.nextLine());


        while (!tasks.isEmpty()) {
            if (threads.isEmpty()) {
                break;
            }
            int taskInd = tasks.size() - 1;
            int threadInd = 0;

            Integer currentTask = tasks.get(taskInd);
            Integer currentThread = threads.get(threadInd);

            if (currentTask == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n"
                        , currentThread, taskToKill);
                break;
            }
            if (currentThread >= currentTask) {
                tasks.remove(taskInd);
                threads.remove(threadInd);
            } else {
                threads.remove(threadInd);
            }
        }

        List<String> listToPrint = convertToStringList(threads);

        System.out.println(String.join(" ", listToPrint));
    }

    private static <T> List<String> convertToStringList(List<T> list) {
        List<String> stringList = new ArrayList<>();
        for (T element : list) {
            stringList.add(String.valueOf(element));
        }
        return stringList;
    }
}
