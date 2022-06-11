package com.example.jsonlab;

import com.example.jsonlab.model.dto.UserCreateDto;
import com.example.jsonlab.model.dto.UserCreatedResponseDto;
import com.example.jsonlab.service.UserService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final Gson gson;
    private FileWriter fileWriter;
    private Scanner scanner;

    public CommandLineRunnerImpl(ModelMapper modelMapper, UserService userService, Gson gson) {
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.gson = gson;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        this.menu();
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice != 6) {


            switch (choice) {
                case 1:
                    System.out.println("Please enter dto info with delimiter space!");
                    String[] dtoInfo = readInfoWithDelimiter(" ");
                    System.out.println(this.userService.save(new UserCreateDto(
                            dtoInfo[1],
                            dtoInfo[2],
                            Integer.parseInt(dtoInfo[3]),
                            new BigDecimal(dtoInfo[4]),
                            Long.parseLong(dtoInfo[5])
                    )));
                    break;
                case 2:
                    System.out.println("Please enter json in one row!");
                    String json = scanner.nextLine();
                    UserCreateDto dto = this.gson.fromJson(json, UserCreateDto.class);
                    UserCreatedResponseDto responseDto = this.userService.saveWithResponse(dto);
                    System.out.println("You successfully save in DB user: ");
                    System.out.println(this.gson.toJson(responseDto));
                    break;
                case 3:
                    System.out.println(this.gson.toJson(this.userService.findAllUsers()));
                    break;
                case 4:
                    System.out.println("Please enter user id: ");
                    try {
                        UserCreatedResponseDto byId = this.userService.
                                findUserById(Long.parseLong(scanner.nextLine()));
                        this.writeInFileJson(byId);
                    } catch (IOException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    List<UserCreatedResponseDto> all = this.userService.findAllUsers();
                    try {
                        this.writeInFileJson(all);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

            }
            this.menu();
            choice = Integer.parseInt(scanner.nextLine());
        }
    }

    private <G> void writeInFileJson(G value) throws IOException {
        String json = this.gson.toJson(value);
        System.out.println("Please write file path: ");
        this.fileWriter = new FileWriter(scanner.nextLine());
        this.gson.toJson(json, this.fileWriter);
        this.fileWriter.flush();
    }


    private String[] readInfoWithDelimiter(String delimiter) {
        return scanner.nextLine().split(delimiter);
    }

    private void menu() {
        System.out.println();
        System.out.println("---------Menu---------");
        String plsCom = "Please enter ";
        System.out.println(plsCom + "1 for Register User from dto");
        System.out.println(plsCom + "2 for Register User from json");
        System.out.println(plsCom + "3 for Get users from DB");
        System.out.println(plsCom + "4 for Get user from DB and write info in file");
        System.out.println(plsCom + "5 for Get all users from DB and write info in file");
        System.out.println(plsCom + "6 for exit of program");
        System.out.println("----------------------");
        System.out.println("Please enter your choice");
    }
}
