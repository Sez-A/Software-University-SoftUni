package com.example.battleShips.service.impl;

import com.example.battleShips.model.entity.Ship;
import com.example.battleShips.model.service.ShipServiceModel;
import com.example.battleShips.repository.ShipRepository;
import com.example.battleShips.service.CategoryService;
import com.example.battleShips.service.ShipService;
import com.example.battleShips.service.UserService;
import com.example.battleShips.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, CategoryService categoryService, UserService userService, CurrentUser currentUser) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void addShip(ShipServiceModel shipServiceModel) {
        Ship shipEntity = modelMapper.map(shipServiceModel, Ship.class);

        shipEntity.setCategory(categoryService.findCategoryByCategoryName(shipServiceModel.getCategory()).get());
        shipEntity.setUser(userService.findUserById(currentUser.getId()).get());

        System.out.println();
        shipRepository.save(shipEntity);
    }
}
