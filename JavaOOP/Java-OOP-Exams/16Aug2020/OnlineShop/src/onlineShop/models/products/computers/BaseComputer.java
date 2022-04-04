package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    public BaseComputer(int id, String manufacturer, String model
            , double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        String type = component.getClass().getSimpleName();
        for (Component current : components) {
            if (current.getClass().getSimpleName().equals(type)) {
                throw new IllegalArgumentException(String.format(EXISTING_COMPONENT
                        , type
                        , this.getClass().getSimpleName()
                        , this.getId()));
            }
        }

        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (this.components.isEmpty()) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT
                    , componentType
                    , this.getClass().getSimpleName()
                    , this.getId()));
        }
        for (int i = 0; i < this.components.size(); i++) {
            Component current = this.components.get(i);
            if (current.getClass().getSimpleName().equals(componentType)) {
                this.components.remove(i);
                return current;
            }
        }

        throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT
                , componentType
                , this.getClass().getSimpleName()
                , this.getId()));
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        String type = peripheral.getClass().getSimpleName();
        for (Peripheral current : peripherals) {
            if (current.getClass().getSimpleName().equals(type)) {
                throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL
                        , type
                        , this.getClass().getSimpleName()
                        , this.getId()));
            }
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (this.peripherals.isEmpty()) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL
                    , peripheralType,
                    this.getClass().getSimpleName()
                    , this.getId()));
        }

        for (int i = 0; i < this.peripherals.size(); i++) {
            Peripheral current = this.peripherals.get(i);
            if (current.getClass().getSimpleName().equals(peripheralType)) {
                this.peripherals.remove(i);
                return current;
            }
        }

        throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL
                , peripheralType,
                this.getClass().getSimpleName()
                , this.getId()));
    }

    @Override
    public double getOverallPerformance() {
        if (this.components.isEmpty()) {
            return super.getOverallPerformance();
        }
        double avgComponentsOverallPerformance =
                this.components
                        .stream()
                        .mapToDouble(Product::getOverallPerformance)
                        .average()
                        .getAsDouble();


        return super.getOverallPerformance() + avgComponentsOverallPerformance;
    }

    @Override
    public double getPrice() {

        double allComponentsPrice = 0;
        if (!components.isEmpty()) {
            allComponentsPrice = this.components
                    .stream()
                    .mapToDouble(Product::getPrice)
                    .sum();
        }

        double allPeripheralsPrice = 0;
        if (!peripherals.isEmpty()) {
            allPeripheralsPrice = this.peripherals
                    .stream()
                    .mapToDouble(Product::getPrice)
                    .sum();
        }

        return super.getPrice() + allComponentsPrice + allPeripheralsPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(PRODUCT_TO_STRING
                        , this.getOverallPerformance()
                        , this.getPrice()
                        , this.getClass().getSimpleName()
                        , this.getManufacturer()
                        , this.getModel()
                        , this.getId()))
                .append(System.lineSeparator());

        sb.append(" ").append(String.format(COMPUTER_COMPONENTS_TO_STRING, this.components.size()))
                .append(System.lineSeparator());
        this.components
                .forEach(c -> sb
                        .append(String.format("  %s", c.toString()))
                        .append(System.lineSeparator()));
        double avgPeripheralsOverallPerformance = 0;

        if (!peripherals.isEmpty()) {
            avgPeripheralsOverallPerformance =
                    this.peripherals
                            .stream()
                            .mapToDouble(Product::getOverallPerformance)
                            .average()
                            .getAsDouble();
        }


        sb.append(" ").append(String.format(COMPUTER_PERIPHERALS_TO_STRING
                        , this.peripherals.size()
                        , avgPeripheralsOverallPerformance))
                .append(System.lineSeparator());
        this.peripherals
                .forEach(p -> sb.append(String.format("  %s", p.toString()))
                        .append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
