package commandPattern.commands;

import commandPattern.Product;

public class IncreaseProductPriceCommand implements Command {
    private final Product product;
    private final int amount;

    public IncreaseProductPriceCommand(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    @Override
    public String executeAction() {
        String result =
                String.format("The price for the %s has been increased by %d€."
                        , this.product.getName(), this.amount);
        this.product.increasePrice(this.amount);
        return result;
    }
}
