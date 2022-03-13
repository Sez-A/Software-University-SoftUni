import commandPattern.Product;
import commandPattern.commands.ChangeProductNameCommand;
import commandPattern.commands.Command;
import commandPattern.commands.IncreaseProductPriceCommand;
import commandPattern.ModifyPrice;

public class Main {
    public static void main(String[] args) {

        ModifyPrice modifyPrice = new ModifyPrice();

        Product product = new Product("Samsung", 500);

        execute(modifyPrice, new IncreaseProductPriceCommand(product, 100));
        execute(modifyPrice,new ChangeProductNameCommand(product, "Apple"));
        System.out.println(product);
    }

    private static void execute(ModifyPrice modifyPrice, Command command) {
        modifyPrice.setCommand(command);
        System.out.println(modifyPrice.invoke());
    }
}
