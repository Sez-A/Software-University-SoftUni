package com.example.automappingex.service.impl;

import com.example.automappingex.model.dto.GameTitleDto;
import com.example.automappingex.model.dto.LoginUserDto;
import com.example.automappingex.model.dto.UserRegisterDto;
import com.example.automappingex.model.entity.User;
import com.example.automappingex.repository.UserRepository;
import com.example.automappingex.service.GameService;
import com.example.automappingex.service.UserService;
import com.example.automappingex.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private static int registeredUsersCnt = 0;
    private final ValidationUtil validationUtil;
    private final GameService gameService;
    private User currentLoggedUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository
            , ValidationUtil validationUtil, GameService gameService) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.gameService = gameService;
    }

    @Override
    public String registerUser(UserRegisterDto userRegisterDto) {
        if (!(userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword()))) {
            return "Confirm password and password are different";
        }

        StringBuilder sb = new StringBuilder();

        Set<ConstraintViolation<UserRegisterDto>> violations =
                validationUtil.violations(userRegisterDto);
        if (violations.isEmpty()) {
            User user = modelMapper.map(userRegisterDto, User.class);
            if (registeredUsersCnt == 0) {
                user.setAdmin(true);
                registeredUsersCnt++;
            } else {
                user.setAdmin(false);
            }
            this.userRepository.save(user);
            sb.append(userRegisterDto.getFullName()).append(" was registered");
        } else {
            violationsGetErrorMessages(violations, sb);
        }

        return sb.toString().trim();
    }

    @Override
    public String loginUser(LoginUserDto loginUserDto) {
        StringBuilder sb = new StringBuilder();
        Set<ConstraintViolation<LoginUserDto>> violations = validationUtil.violations(loginUserDto);

        if (violations.isEmpty()) {
            User loggedIn = this.userRepository.findByEmailAndPassword(loginUserDto.getEmail()
                    , loginUserDto.getPassword());

            if (loggedIn == null) {
                sb.append("Incorrect username / password");
            } else {
                if (currentLoggedUser == null) {
                    currentLoggedUser = loggedIn;
                    sb.append("Successfully logged in ").append(loggedIn.getFullName());
                } else {
                    sb.append("In application already has logged in user");
                }
            }
        } else {
            violationsGetErrorMessages(violations, sb);
        }

        return sb.toString().trim();
    }

    @Override
    public String logout() {
        StringBuilder sb = new StringBuilder();
        if (currentLoggedUser == null) {
            sb.append("Cannot log out. No user was logged in.");
        } else {
            sb.append(String.format("User %s successfully logged out", currentLoggedUser.getFullName()));
            currentLoggedUser = null;
        }
        return sb.toString().trim();
    }

    @Override
    public boolean haveLoggedAdmin() {
        if (this.currentLoggedUser == null) {
            return false;
        }

        return this.currentLoggedUser.getAdmin();
    }


    @Override
    public String buyGame(String gameName) {
        if (this.currentLoggedUser != null) {
            this.currentLoggedUser.getGames().add(this.gameService.findGameByName(gameName));
            this.userRepository.save(this.currentLoggedUser);
            return currentLoggedUser.getFullName() + " successfully buy " + gameName;
        }
        return "Nobody logged in";
    }

    @Override
    public Set<GameTitleDto> findAllGamesOfLoggedInUser() {
        if (this.currentLoggedUser != null) {
            Set<GameTitleDto> dtos = new HashSet<>();
            this.currentLoggedUser
                    .getGames()
                    .forEach(g -> dtos.add(modelMapper.map(g, GameTitleDto.class)));
            return dtos;
        }

        throw new IllegalStateException("Nobody logged in");
    }

    private <E> void violationsGetErrorMessages(Set<ConstraintViolation<E>> violations, StringBuilder sb) {
        violations
                .stream()
                .map(ConstraintViolation::getMessage)
                .forEach(m -> sb.append(String.format("%s%n", m)));
    }
}
