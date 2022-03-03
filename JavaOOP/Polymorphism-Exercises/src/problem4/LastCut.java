package problem4;

import java.util.ArrayList;
import java.util.List;

public class LastCut {
    private static List<String> lastCut = new ArrayList<>();

    public static void saveTheLastCut(String lastCutText) {
        lastCut.add(lastCutText);
    }

    public static void clearBuff() {
        lastCut.clear();
    }

    public static String getLastCut() {
        return lastCut.get(0);
    }

    public static boolean isEmpty() {
        if(lastCut.isEmpty())
            return true;

        return false;
    }
    public static void removeContent() {
        if(lastCut.isEmpty()) {

        }else {
            lastCut.remove(0);
        }
    }
}

