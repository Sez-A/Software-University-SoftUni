package com.example.xmlprocessingexercises.service.impl;

import com.example.xmlprocessingexercises.model.dto.SoldProductDto;
import com.example.xmlprocessingexercises.model.dto.UserSeedDto;
import com.example.xmlprocessingexercises.model.dto.UserWithSoldProductsDto;
import com.example.xmlprocessingexercises.model.dto.UsersWithSoldProductsRootDto;
import com.example.xmlprocessingexercises.model.dto.ex_four.SoldProductWithNamePriceDto;
import com.example.xmlprocessingexercises.model.dto.ex_four.SoldProductsWithCntDto;
import com.example.xmlprocessingexercises.model.entity.Product;
import com.example.xmlprocessingexercises.model.entity.User;
import com.example.xmlprocessingexercises.repository.UserRepository;
import com.example.xmlprocessingexercises.service.UserService;
import com.example.xmlprocessingexercises.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean repoIsEmpty() {
        return this.userRepository.count() == 0;
    }

    @Override
    public void seedUsers(List<UserSeedDto> users) {
        users
                .stream()
                .filter(validationUtil::isValid)
                .map(userSeedDto -> modelMapper.map(userSeedDto, User.class))
                .forEach(userRepository::save);


    }

    @Override
    public User getRandomUser() {
        long id = ThreadLocalRandom.current().nextLong(1, userRepository.count() + 1);
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public UsersWithSoldProductsRootDto usersWithAtLeastOneSoldProduct() {
        UsersWithSoldProductsRootDto rootDto = new UsersWithSoldProductsRootDto();
        rootDto.setUsers(this.userRepository.usersWithAtLeastOneSoldProduct()
                .stream().map(user -> {
                    UserWithSoldProductsDto dto = modelMapper.map(user, UserWithSoldProductsDto.class);
                    List<SoldProductDto> soldProducts = dto.getSoldProducts();
                    for (SoldProductDto soldProduct : soldProducts) {
                        if (soldProduct.getBuyerFirstName() == null) {
                            soldProduct.setBuyerFirstName("");
                        }
                        if (soldProduct.getBuyerLastName() == null) {
                            soldProduct.setBuyerLastName("");
                        }
                    }
                    return dto;
                })
                .collect(Collectors.toList()));
        return rootDto;
    }

    @Override
    public com.example.xmlprocessingexercises.model.dto.ex_four.UsersWithSoldProductsRootDto
    usersWithAtLeastOneSoldProductOrderByProductsSize() {
        var rootDto =
                new com.example.xmlprocessingexercises.model.dto.ex_four.
                        UsersWithSoldProductsRootDto();

        List<com.example.xmlprocessingexercises.model.dto.ex_four.UserWithSoldProductsDto> collect
                = this.userRepository.usersWithAtLeastOneSoldProductOrderByProductsCntDesc()
                .stream()
                .map(user -> {
                    var dto = modelMapper.map(user,
                            com.example.xmlprocessingexercises.model.dto.ex_four.UserWithSoldProductsDto.class);
                    var soldProductsWithCntDto = new SoldProductsWithCntDto();
                    List<SoldProductWithNamePriceDto> product = new ArrayList<>();
                    for (Product p : user.getSoldProducts()) {
                        var namePriceDto = new SoldProductWithNamePriceDto();
                        namePriceDto.setName(p.getName());
                        namePriceDto.setPrice(p.getPrice());
                        product.add(namePriceDto);
                    }
                    soldProductsWithCntDto.setCount(product.size());
                    soldProductsWithCntDto.setSoldProducts(product);
                    dto.setSoldProductsWithCntDto(soldProductsWithCntDto);
                    return dto;
                })
                .collect(Collectors.toList());

        rootDto.setUsers(collect);
        rootDto.setCount(collect.size());
        return rootDto;
    }
}
