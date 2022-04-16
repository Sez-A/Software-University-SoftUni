package viceCity;

import viceCity.core.ControllerImpl;
import viceCity.core.EngineImpl;
import viceCity.core.interfaces.Controller;
import viceCity.core.interfaces.Engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//
//        Iterator<Integer> iterator = integers.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        Controller controller = new ControllerImpl(); // TODO
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
