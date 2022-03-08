package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] declaredFields = clazz.getDeclaredFields();

        String accessModifier;
        while (!(accessModifier = reader.readLine()).equals("HARVEST")) {

            for (Field field : declaredFields) {
                int modifier = field.getModifiers();
                if (Modifier.toString(modifier).equals(accessModifier) || accessModifier.equals("all")) {
                    System.out.println(Modifier.toString(modifier) + " "
                            + field.getType().getSimpleName() +" "+ field.getName());
                }
            }
        }
    }
}
