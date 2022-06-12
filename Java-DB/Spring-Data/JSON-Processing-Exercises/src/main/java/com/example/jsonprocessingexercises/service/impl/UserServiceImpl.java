package com.example.jsonprocessingexercises.service.impl;

import com.example.jsonprocessingexercises.model.dto.*;
import com.example.jsonprocessingexercises.model.entity.Product;
import com.example.jsonprocessingexercises.model.entity.User;
import com.example.jsonprocessingexercises.repository.UserRepository;
import com.example.jsonprocessingexercises.service.UserService;
import com.example.jsonprocessingexercises.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedUsers(UserSeedDto[] dtos) {
        if (this.userRepository.count() > 0) {
            return;
        }
        Arrays.stream(dtos)
                .filter(validationUtil::isValid)
                .map(dto -> modelMapper.map(dto, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User getRandomUser() {
        Long id = ThreadLocalRandom.current()
                .nextLong(1, this.userRepository.count() + 1);
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UsersSoldProductsDto> findAllSoldProducts() {
        List<User> result = this.userRepository.findAllWithMoreThanOneProductSold();

        for (User user : result) {
            Set<Product> productsWithBuyer = new HashSet<>();
            for (Product product : user.getSoldProducts()) {
                if (product.getBuyer() != null) {
                    productsWithBuyer.add(product);
                }
            }
            user.setSoldProducts(productsWithBuyer);
        }

        return result
                .stream()
                .map(u -> modelMapper.map(u, UsersSoldProductsDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public UsersAndProductsDto findAllUsersWithSoldProductsOrderByProductCount() {

        List<User> users = this.userRepository
                .findAllWithMoreThanOneProductSoldOrderBySoldProductsCntDesc();
        UsersAndProductsDto root = new UsersAndProductsDto();
        root.setUsersCount(users.size());
        root.setUsersWithSoldProducts(users
                .stream()
                .map(user -> {
                    UsersWithSoldProductsDto dto = modelMapper.map(user, UsersWithSoldProductsDto.class);

                    SoldProductsWithPriceDto soldProductsWithPriceDto = dto.getSoldProducts();
                    soldProductsWithPriceDto.setCount(user.getSoldProducts().size());

                    dto.setSoldProducts(soldProductsWithPriceDto);
                    return dto;
                })
                .collect(Collectors.toList()));

        return root;

//        UsersAndProductsDto usersAndProductsDto = new UsersAndProductsDto();
//        usersAndProductsDto.setUsersCount(users.size());
//
//        for (User user : users) {
//            List<UsersWithSoldProductsDto> usersWithSoldProductsDtos = new ArrayList<>();
//
//            // TODO: 30.11.2021 г. Add usersWithSoldProductsDto in list
//
//            UsersWithSoldProductsDto usersWithSoldProductsDto = new UsersWithSoldProductsDto();
//            usersWithSoldProductsDto.setFirstName(user.getFirstName());
//            usersWithSoldProductsDto.setLastName(user.getLastName());
//            usersWithSoldProductsDto.setAge(user.getAge());
//
//            SoldProductsWithPriceDto soldProductsWithPriceDto = new SoldProductsWithPriceDto();
//            soldProductsWithPriceDto.setCount(user.getSoldProducts().size());
//
//            List<ProductWithNameAndPriceDto> productWithNameAndPriceDtos = new ArrayList<>();
//            for (Product product : user.getSoldProducts()) {
//                ProductWithNameAndPriceDto productWithNameAndPriceDto = new ProductWithNameAndPriceDto();
//                productWithNameAndPriceDto.setName(product.getName());
//                productWithNameAndPriceDto.setPrice(product.getPrice());
//                productWithNameAndPriceDtos.add(productWithNameAndPriceDto);
//            }
//
//            soldProductsWithPriceDto.setProducts(productWithNameAndPriceDtos);
//            usersWithSoldProductsDto.setSoldProducts(soldProductsWithPriceDto);
//
//            usersWithSoldProductsDtos.add(usersWithSoldProductsDto);
//            usersAndProductsDto.setUsersWithSoldProducts(usersWithSoldProductsDtos);
//
//        }
    }
}
