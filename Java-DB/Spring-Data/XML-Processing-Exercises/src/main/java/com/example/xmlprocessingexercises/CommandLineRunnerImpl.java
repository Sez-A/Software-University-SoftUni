package com.example.xmlprocessingexercises;

import com.example.xmlprocessingexercises.model.dto.*;
import com.example.xmlprocessingexercises.service.CategoryService;
import com.example.xmlprocessingexercises.service.ProductService;
import com.example.xmlprocessingexercises.service.UserService;
import com.example.xmlprocessingexercises.util.XMLParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final String RESOURCES_FILES_PATH_NAME = "src/main/resources/files/";
    private static final String RESOURCES_OUT_FILES_PATH_NAME = RESOURCES_FILES_PATH_NAME + "out/";
    private static final String CATEGORIES_FILE_NAME = "categories.xml";
    private static final String USERS_FILE_NAME = "users.xml";
    private static final String PRODUCTS_FILE_NAME = "products.xml";
    private static final String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.xml";
    private static final String SOLD_PRODUCTS_FILE_NAME = "sold-products.xml";
    private static final String CATEGORIES_BY_PRODUCTS_CNT_DESC_FILE_NAME = "cat-by-products-cnt-desc.xml";
    private static final String SOLD_PRODUCTS_ORDERED_FILE_NAME = "sold-products-ordered.xml";

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final XMLParser xmlParser;
    private final BufferedReader reader;

    public CommandLineRunnerImpl(UserService userService, ProductService productService,
                                 CategoryService categoryService, XMLParser xmlParser) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.xmlParser = xmlParser;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {


        this.seedData();
        while (true) {
            System.out.println();
            menu();
            System.out.println("Please enter exercise number: ");
            int num = Integer.parseInt(reader.readLine());
            if (num == 10) {
                return;
            }
            switch (num) {
                case 1 -> this.productsInRange();
                case 2 -> this.soldProducts();
                case 3 -> this.categoriesByProductsCnt();
                case 4 -> this.usersAndProducts();
                default -> System.out.println("Number " + num + " doesn't match any of menu choices");
            }
        }
    }

    private void usersAndProducts() throws JAXBException {
        com.example.xmlprocessingexercises.model.dto.ex_four
                .UsersWithSoldProductsRootDto rootDto
                = this.userService.usersWithAtLeastOneSoldProductOrderByProductsSize();

        this.xmlParser.writeToFile(RESOURCES_OUT_FILES_PATH_NAME + SOLD_PRODUCTS_ORDERED_FILE_NAME
                , rootDto);
    }

    private void categoriesByProductsCnt() throws JAXBException {
        CategoriesByProductsCountDescRootDto rootDto
                = this.categoryService.findAllCategoriesOrderByProductsCountDesc();
        this.xmlParser.writeToFile(
                RESOURCES_OUT_FILES_PATH_NAME + CATEGORIES_BY_PRODUCTS_CNT_DESC_FILE_NAME
                , rootDto);
    }

    private void soldProducts() throws JAXBException {
        UsersWithSoldProductsRootDto rootDto = this.userService.usersWithAtLeastOneSoldProduct();
        this.xmlParser.writeToFile(RESOURCES_OUT_FILES_PATH_NAME + SOLD_PRODUCTS_FILE_NAME, rootDto);
    }


    private void productsInRange() throws JAXBException {
        ProductInRangeRootDto productsInRange = this.productService.findAllProductsInRange();
        this.xmlParser.writeToFile(RESOURCES_OUT_FILES_PATH_NAME + PRODUCTS_IN_RANGE_FILE_NAME
                , productsInRange);
    }

    private void seedData() throws JAXBException {
        if (this.categoryService.repoIsEmpty()) {
            CategorySeedRootDto categorySeedRootDto = this.xmlParser
                    .fromFile(RESOURCES_FILES_PATH_NAME + CATEGORIES_FILE_NAME
                            , CategorySeedRootDto.class);

            this.categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (this.userService.repoIsEmpty()) {
            UserSeedRootDto userSeedRootDto = this.xmlParser
                    .fromFile(RESOURCES_FILES_PATH_NAME + USERS_FILE_NAME
                            , UserSeedRootDto.class);

            this.userService.seedUsers(userSeedRootDto.getUsers());
        }

        if (this.productService.repoIsEmpty()) {
            ProductSeedRootDto productSeedRootDto = this.xmlParser
                    .fromFile(RESOURCES_FILES_PATH_NAME + PRODUCTS_FILE_NAME
                            , ProductSeedRootDto.class);

            this.productService.seedProducts(productSeedRootDto.getProducts());

        }
    }

    private void menu() {
        System.out.println("-------------Menu-------------");
        System.out.println("1. Products in range");
        System.out.println("2. Successfully sold products");
        System.out.println("3. Categories by products count");
        System.out.println("4. Users and products");
        System.out.println("10. Exit of program");
        System.out.println("------------------------------");
    }
}
