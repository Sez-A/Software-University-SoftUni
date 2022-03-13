package commandPattern.commands;

import commandPattern.Product;

public class DecreaseProductPriceCommand implements Command {
    private final Product product;
    private final int amount;

    public DecreaseProductPriceCommand(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String executeAction() {
        String result = String.format("The price for the %s has been decreased by %d€."
                , this.product.getName(), this.amount);
        this.product.decreasePrice(this.amount);
        return result;
    }
}
