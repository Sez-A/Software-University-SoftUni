package commandPattern.commands;

import commandPattern.Product;

public class ChangeProductNameCommand implements Command {
    private final Product product;
    private final String newName;

    public ChangeProductNameCommand(Product product, String newName) {
        this.product = product;
        this.newName = newName;
    }

    @Override
    public String executeAction() {
        String result = String.format("The current name of products is %s.", product.getName());
        this.product.setName(this.newName);
        result = result + " " + String.format("The name of product after change name command is %s.",
                this.newName);
        return result;
    }
}
