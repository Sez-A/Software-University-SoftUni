package com.example.advquerying;

import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final Scanner scanner;
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public CommandLineRunnerImpl(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        userInterface();
    }

    private void userInterface() {
        chooseAndMenu();
        int choose;
        while ((choose = Integer.parseInt(scanner.nextLine())) != 12) {

            switch (choose) {
                case 1 -> exerciseOne();
                case 2 -> exerciseTwo();
                case 3 -> exerciseThree();
                case 4 -> exerciseFour();
                case 5 -> exerciseFive();
                case 6 -> exerciseSix();
                case 7 -> exerciseSeven();
                case 8 -> exerciseEight();
                case 9 -> exerciseNine();
                case 10 -> exerciseTen();
                case 11 -> exerciseEleven();
                default -> System.out.println("Please enter valid chose number!");
            }
            chooseAndMenu();

        }
    }

    private void exerciseEleven() {
        System.out.println("Please enter ingredients names in one row with space delimiter: ");
        List<String> names = List.of(scanner.nextLine().split("\\s+"));
        System.out.println("Please enter percent: ");
        BigDecimal percent = BigDecimal.valueOf((Double.parseDouble(scanner.nextLine()) / 100));
        System.out.println("Affected rows: " +
                this.ingredientService.updateAllIngredientsByNameIn(names, percent));
    }

    private void exerciseTen() {
        System.out.println("Affected rows: " +
                this.ingredientService.updateAllIngredientsPriceByTenPercent());
    }

    private void exerciseNine() {
        System.out.println("Please enter ingredient name: ");
        System.out.println("Affected rows: " +
                this.ingredientService.deleteIngredientByName(scanner.nextLine()));
    }

    private void exerciseEight() {
        System.out.println("Please enter ingredient count: ");
        int count = Integer.parseInt(scanner.nextLine());
        this.shampooService.findAllShampoosByIngredientCountLessThan(count)
                .forEach(System.out::println);
    }

    private void exerciseSeven() {
        System.out.println("Please enter ingredients on a one row with space: ");
        this.shampooService.findAllShampoosWithIngredientsIn(List.of(scanner.nextLine().split("\\s+")))
                .forEach(System.out::println);
    }

    private void exerciseSix() {
        System.out.println("Please enter price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("All shampoos count is: " +
                this.shampooService.findAllShampooCountByPriceLowerThan(price));
    }

    private void exerciseFive() {
        System.out.println("Please enter ingredients names on a one row with space between them: ");
        List<String> names = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .collect(Collectors.toList());
        this.ingredientService.findAllIngredientsByNames(names)
                .forEach(System.out::println);
    }

    private void exerciseFour() {
        System.out.println("Please enter text: ");

        this.ingredientService.findAllIngredientsByNameStartsWith(scanner.nextLine())
                .forEach(System.out::println);

    }

    private void exerciseThree() {
        System.out.println("Please enter price: ");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
        this.shampooService.findAllShampoosByPriceHigherThan(price)
                .forEach(System.out::println);
    }

    private void exerciseTwo() {
        System.out.println("Please enter size: (SMALL, MEDIUM, LARGE)");
        Size size = Size.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Please enter label id: ");
        long labelId = Long.parseLong(scanner.nextLine());
        this.shampooService.findAllShampoosBySizeOrLabelOrderedByPrice(size, labelId)
                .forEach(System.out::println);
    }

    private void exerciseOne() {
        System.out.println("Please enter size: (SMALL, MEDIUM, LARGE)");
        this.shampooService.findAllShampoosBySize
                        (Size.valueOf(scanner.nextLine().toUpperCase()))
                .forEach(System.out::println);
    }

    private void chooseAndMenu() {
        menu();
        System.out.println("Please choose exercise: ");
    }

    private void menu() {
        System.out.println();
        System.out.println("===================Menu===================");
        System.out.println("1. Select Shampoos by Size");
        System.out.println("2. Select Shampoos by Size or Label");
        System.out.println("3. Select Shampoos by Price");
        System.out.println("4. Select Ingredients by Name");
        System.out.println("5. Select Ingredients by Names");
        System.out.println("6. Count Shampoos by Price");
        System.out.println("7. Select Shampoos by Ingredients");
        System.out.println("8. Select Shampoos by Ingredients Count");
        System.out.println("9. Delete Ingredients by Name");
        System.out.println("10. Update Ingredients by Price");
        System.out.println("11. Update Ingredients by Names");
        System.out.println("12. Exit");
        System.out.println();
    }
}
