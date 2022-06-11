package com.example.automappingex;

import com.example.automappingex.model.dto.GameAddDto;
import com.example.automappingex.model.dto.LoginUserDto;
import com.example.automappingex.model.dto.UserRegisterDto;
import com.example.automappingex.service.GameService;
import com.example.automappingex.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private BufferedReader reader;
    private final UserService userService;
    private final GameService gameService;

    CommandLineRunnerImpl(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {
        userInterface();
    }

    private void userInterface() throws IOException {
        menu();
        String command = "";
        while (!(command = reader.readLine()).equals("End")) {
            String[] commands = command.split("\\|");
            switch (commands[0]) {
                case "RegisterUser":
                    System.out.println(
                            this.userService.registerUser(new UserRegisterDto(
                                    commands[1], commands[2], commands[3], commands[4])));
                    break;
                case "LoginUser":
                    System.out.println(this.userService
                            .loginUser(new LoginUserDto(commands[1], commands[2])));
                    break;
                case "Logout":
                    System.out.println(this.userService.logout());
                    break;

                /*
                 * For AddGame, EditGame and DeleteGame operations in application must have a logged-in user
                 * and this logged-in user must have an admin!
                 * If you don't know who user is admin in application look a database!
                 */
                case "AddGame":
                    if (this.userService.haveLoggedAdmin()) {
                        System.out.println(this.gameService.addGame(new GameAddDto(
                                commands[1], new BigDecimal(commands[2])
                                , Double.parseDouble(commands[3])
                                , commands[4], commands[5], commands[6]
                                , LocalDate.parse(commands[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                        )));
                    } else {
                        System.out.println("Please enter with admin profile!");
                    }
                    break;
                case "EditGame":
                    Long id = Long.parseLong(commands[1]);
                    if (this.userService.haveLoggedAdmin()) {

                        List<String> values = Arrays.stream(commands).skip(2)
                                .collect(Collectors.toList());
                        this.gameService.editGame(id, values);

                    } else {
                        System.out.println("Please enter with admin profile!");
                    }
                    break;
                case "DeleteGame":
                    if (this.userService.haveLoggedAdmin()) {
                        System.out.println(this.gameService.deleteGame(Long.parseLong(commands[1])));
                    } else {
                        System.out.println("Please enter with admin profile!");

                    }
                    break;
                case "AllGames":
                    this.gameService.findTitleAndPriceOfAllGames();
                    break;
                case "DetailGame":
                    System.out.println(this.gameService.findGameDetailsByTitle(commands[1]));
                    break;
                case "BuyGame":
                    System.out.println("Please enter game name");
                    System.out.println(this.userService.buyGame(reader.readLine()));
                    break;
                case "OwnedGames":
                    try {
                        this.userService.findAllGamesOfLoggedInUser()
                                .forEach(System.out::println);

                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
            menu();
        }
    }


    private void menu() {
        System.out.println();
        System.out.println("---------Menu---------");
        System.out.println("    RegisterUser");
        System.out.println("    LoginUser");
        System.out.println("    Logout");
        System.out.println("    AddGame");
        System.out.println("    EditGame");
        System.out.println("    DeleteGame");
        System.out.println("    AllGames");
        System.out.println("    DetailGame");
        System.out.println("    BuyGame");
        System.out.println("    OwnedGames");
        System.out.println("    End");
        System.out.println("----------------------");
        System.out.println("Please enter your choice");
    }

}
