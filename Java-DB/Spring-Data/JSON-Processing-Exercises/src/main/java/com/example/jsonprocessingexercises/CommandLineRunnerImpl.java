package com.example.jsonprocessingexercises;

import com.example.jsonprocessingexercises.model.dto.*;
import com.example.jsonprocessingexercises.service.CategoryService;
import com.example.jsonprocessingexercises.service.ProductService;
import com.example.jsonprocessingexercises.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

import static com.example.jsonprocessingexercises.constant.GlobalConstants.*;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final Gson gson;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader reader;

    public CommandLineRunnerImpl(Gson gson, CategoryService categoryService, UserService userService, ProductService productService) {
        this.gson = gson;

        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedData();
        System.out.println("Please enter exercise number: ");

        while (true) {
            System.out.println();
            menu();
            System.out.println("Please enter your choice: ");
            int exerciseNum = Integer.parseInt(reader.readLine());
            if(exerciseNum == 10) {
                return;
            }
            switch (exerciseNum) {
                case 1 -> exerciseOne();
                case 2 -> exerciseTwo();
                case 3 -> exerciseThree();
                case 4 -> exerciseFour();
                default -> System.out.println("Number " + exerciseNum + " doesn't match any of menu choices");
            }
        }
    }

    private void exerciseFour() throws IOException {
        /* TODO: 19.12.2021 г.
            When you look in users_products.json. Please consider that some users don't have a first name
            and when we write them in json file we visualize only their last name, age, and sold products
            when user have a first name we visualize first name also!
        */
        UsersAndProductsDto root = this.userService.findAllUsersWithSoldProductsOrderByProductCount();
        String json = this.gson.toJson(root);
        this.writeToFile(RESOURCES_OUT_FILES_PATH + USERS_PRODUCTS_FILE_JSON_FILE_PATH, json);
    }

    private void exerciseThree() throws IOException {
        String json = this.gson.toJson(this.categoryService.findCategoriesWithProductsCount());
        this.writeToFile(RESOURCES_OUT_FILES_PATH + CATEGORIES_BY_PRODUCTS_JSON_FILE_PATH, json);
    }

    private void exerciseTwo() throws IOException {
        String json = this.gson.toJson(this.userService.findAllSoldProducts());
        this.writeToFile(RESOURCES_OUT_FILES_PATH + USERS_SOLD_PRODUCTS_JSON_FILE_PATH, json);
    }

    private void exerciseOne() throws IOException {
        System.out.println("Please enter lower price bound");
        double lower = Double.parseDouble(reader.readLine());
        System.out.println("Please enter upper price bound");
        double upper = Double.parseDouble(reader.readLine());
        List<ProductInRangeDto> inRange = this.productService.findAllProductsInRange(lower, upper);
        String content = this.gson.toJson(inRange);
        this.writeToFile(RESOURCES_OUT_FILES_PATH + PRODUCTS_IN_RANGE_JSON_FILE_PATH, content);
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files
                .write(Path.of(filePath), Collections.singleton(content));

    }

    private void menu() {
        System.out.println("--------------------------Menu----------------------------");
        System.out.println("Please enter 1 for Products in Range exercise");
        System.out.println("Please enter 2 for Successfully Sold Products exercise");
        System.out.println("Please enter 3 for Categories by Products Count exercise");
        System.out.println("Please enter 4 for Users and Products exercise");
        System.out.println("Please enter 10 for Exit of program");
        System.out.println("-----------------------------------------------------------");
    }

    private void seedData() throws IOException {
        this.seedCategories();
        this.seedUsers();
        this.seedProducts();
    }

    private void seedProducts() throws IOException {
        String content = Files.readString(Path.of(RESOURCES_JSON_FILES_PATH + PRODUCTS_JSON_FILE_PATH));
        ProductSeedDto[] productSeedDtos = this.gson.fromJson(content, ProductSeedDto[].class);
        this.productService.seedProducts(productSeedDtos);

    }

    private void seedUsers() throws IOException {
        String content = Files.readString(Path.of(RESOURCES_JSON_FILES_PATH + USERS_JSON_FILE_PATH));
        UserSeedDto[] userSeedDtos = this.gson.fromJson(content, UserSeedDto[].class);
        this.userService.seedUsers(userSeedDtos);
    }

    private void seedCategories() throws IOException {
        String content = Files.readString(Path.of(RESOURCES_JSON_FILES_PATH + CATEGORIES_JSON_FILE_PATH));
        CategorySeedDto[] categorySeedDtos = this.gson.fromJson(content, CategorySeedDto[].class);
        this.categoryService.seedCategories(categorySeedDtos);
    }

}
