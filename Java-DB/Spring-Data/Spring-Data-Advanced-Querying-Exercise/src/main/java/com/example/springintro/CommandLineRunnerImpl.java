package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        //   seedData();
        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //   printAllAuthorsAndNumberOfTheirBooks();
        //   pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        userInterface();
    }


    private void userInterface() throws IOException {
        menuAndChooseMessage();
        int exerciseNum;
        while ((exerciseNum = Integer.parseInt(reader.readLine())) != 15) {
            switch (exerciseNum) {
                case 1 -> exerciseOne();
                case 2 -> exerciseTwo();
                case 3 -> exerciseThree();
                case 4 -> exerciseFour();
                case 5 -> exerciseFive();
                case 6 -> exerciseSix();
                case 7 -> exerciseSeven();
                case 8 -> exerciseEighth();
                case 9 -> exerciseNine();
                case 10 -> exerciseTen();
                case 11 -> exerciseEleven();
                default -> System.out.println("Please enter correct value!");
            }
            menuAndChooseMessage();
        }
    }

    private void exerciseEleven() throws IOException {
        System.out.println("Please enter book name:");
        System.out.println(this.bookService
                .findBookByName(reader.readLine()));
    }

    private void exerciseTen() {
        this.authorService
                .findAuthorFullNameAndBookCopies()
                .forEach(System.out::println);
    }


    private void menuAndChooseMessage() {
        menu();
        System.out.println("Please select exercise number:");
    }

    private void menu() {
        System.out.println();
        System.out.println("-----------------Menu-----------------");
        System.out.println("1. Books Titles by Age Restriction");
        System.out.println("2. Golden Books");
        System.out.println("3. Books by Price");
        System.out.println("4. Not Released Books");
        System.out.println("5. Books Released Before Date");
        System.out.println("6. Authors Search");
        System.out.println("7. Books Search");
        System.out.println("8. Book Titles Search");
        System.out.println("9. Count Books");
        System.out.println("10. Total Book Copies");
        System.out.println("11. Reduced Book");
        System.out.println("15. Exit");

        System.out.println();
    }

    private void exerciseNine() throws IOException {
        System.out.println("Please enter size");
        System.out.println("All books count is: " +
                this.bookService
                        .findAllBooksCountWithLengthLongerThan(Integer.parseInt(reader.readLine())));
    }

    private void exerciseEighth() throws IOException {
        System.out.println("Please enter string: ");
        this.bookService
                .findAllBooksWithAuthorLastNameStartsWith(reader.readLine())
                .forEach(System.out::println);
    }

    private void exerciseSeven() throws IOException {
        System.out.println("Please enter string:");
        this.bookService
                .findAllBooksByContainingString(reader.readLine())
                .forEach(System.out::println);
    }

    private void exerciseSix() throws IOException {
        System.out.println("Please enter string: ");
        this.authorService.findAllAuthorsFirstnameEndsWith(reader.readLine())
                .forEach(System.out::println);
    }

    private void exerciseFive() throws IOException {
        System.out.println("Please enter release date in format dd-MM-yyyy.");

        this.bookService.findAllBooksReleaseDateBefore(LocalDate.parse(reader.readLine(),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy")))
                .forEach(System.out::println);
    }

    private void exerciseFour() throws IOException {
        System.out.println("Please enter year:");
        this.bookService
                .findAllBooksNotReleasedIn(Integer.parseInt(reader.readLine()))
                .forEach(System.out::println);
    }

    private void exerciseThree() throws IOException {
        System.out.println("Please enter price for lower bound: ");
        BigDecimal lowerBoundPrice = BigDecimal.valueOf(Double.parseDouble(reader.readLine()));
        System.out.println("Please enter price for upper bound: ");
        BigDecimal upperBoundPrice = BigDecimal.valueOf(Double.parseDouble(reader.readLine()));

        this.bookService
                .findAllBooksWithPriceLowerThanAndHigherThan(lowerBoundPrice, upperBoundPrice)
                .forEach(System.out::println);
    }

    private void exerciseTwo() throws IOException {
        System.out.println("Please enter edition type: (NORMAL, PROMO, GOLD)");
        String editionType = reader.readLine().toUpperCase();
        System.out.println("Please enter copies count:");
        int copies = Integer.parseInt(reader.readLine());
        this.bookService
                .findAllBooksWithEditionTypeAndCopiesLessThan(editionType, copies)
                .forEach(System.out::println);
    }

    private void exerciseOne() throws IOException {
        System.out.println("Please enter age restriction: (MINOR, TEEN, ADULT)");
        this.bookService
                .findAllBooksByAgeRestriction(reader.readLine().toUpperCase())
                .forEach(System.out::println);
    }


    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
