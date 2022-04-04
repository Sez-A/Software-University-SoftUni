package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {
    private List<Computer> computers;
    private List<Component> components;
    private List<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        if (alreadyExistComputer(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
        Computer computer = null;
        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;
            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;
        }

        if (computer == null) {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        this.computers.add(computer);
        return String.format(ADDED_COMPUTER, id);
    }


    @Override
    public String addPeripheral(int computerId, int id, String peripheralType,
                                String manufacturer, String model, double price,
                                double overallPerformance, String connectionType) {

        if (alreadyExistPeripheral(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }

        if (!this.alreadyExistComputer(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        Peripheral peripheral = null;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
        }

        if (peripheral == null) {
            throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        this.peripherals.add(peripheral);
        Computer computer = this.getComputerById(computerId);
        computer.addPeripheral(peripheral);
        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }


    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        if (!this.alreadyExistComputer(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        Computer computer = this.getComputerById(computerId);
        Peripheral peripheral = computer.removePeripheral(peripheralType);
        this.peripherals.remove(peripheral);
        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType
            , String manufacturer, String model, double price, double overallPerformance, int generation) {

        if (alreadyExistComponent(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        if (!this.alreadyExistComputer(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        Component component = null;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
        }

        if (component == null) {
            throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        Computer computer = this.getComputerById(computerId);
        computer.addComponent(component);
        this.components.add(component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }


    @Override
    public String removeComponent(String componentType, int computerId) {
        if (!this.alreadyExistComputer(computerId)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        Computer computer = this.getComputerById(computerId);
        Component component = computer.removeComponent(componentType);
        // TODO: 9.12.2021 г. Check here if component don't remove
        this.components.remove(component);
        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override
    public String buyComputer(int id) {
        if (!this.alreadyExistComputer(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        Computer computer = this.getComputerById(id);
        String result = computer.toString();
        this.computers.remove(computer);
        return result;
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computerForSale = new Laptop(10110, "A", "B", 1);
        for (Computer current : computers) {
            if (current.getOverallPerformance() > computerForSale.getOverallPerformance()
                    && current.getPrice() <= budget) {
                computerForSale = current;
            }
        }

        if (computerForSale.getManufacturer().equals("A")
                && computerForSale.getPrice() == 1
                && computerForSale.getId() == 10110) {
            throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        this.computers.remove(computerForSale);

        return computerForSale.toString();
    }

    @Override
    public String getComputerData(int id) {
        if (!this.alreadyExistComputer(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }

        return this.getComputerById(id).toString();
    }

    private boolean alreadyExistComputer(int id) {
        for (Computer computer : computers) {
            if (computer.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private Computer getComputerById(int computerId) {
        for (Computer computer : computers) {
            if (computer.getId() == computerId) {
                return computer;
            }
        }
        return null;
    }

    private boolean alreadyExistComponent(int id) {
        for (Component component : components) {
            if (component.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private boolean alreadyExistPeripheral(int id) {
        for (Peripheral peripheral : peripherals) {
            if (peripheral.getId() == id) {
                return true;
            }
        }
        return false;
    }

}
