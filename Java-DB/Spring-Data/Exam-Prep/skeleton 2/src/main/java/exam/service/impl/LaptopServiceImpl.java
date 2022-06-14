package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerSeedDTO;
import exam.model.dto.LaptopSeedDTO;
import exam.model.entity.Customer;
import exam.model.entity.Laptop;
import exam.model.enums.Warranty;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Service
public class LaptopServiceImpl implements LaptopService {
    private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ShopService shopService;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ModelMapper modelMapper,
                             Gson gson, ValidationUtil validationUtil, ShopService shopService) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.shopService = shopService;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson.fromJson(this.readLaptopsFileContent(), LaptopSeedDTO[].class))
                .filter(laptopSeedDTO -> {
                    boolean isValid = this.validationUtil.isValid(laptopSeedDTO);

                    if (!isValid || laptopRepository.findByMacAddress(laptopSeedDTO.getMacAddress()) != null) {
                        sb.append("Invalid Laptop")
                                .append(System.lineSeparator());
                        isValid = false;
                    } else {
                        sb.append(String.format("Successfully imported Laptop %s %.2f - %d %d",
                                        laptopSeedDTO.getMacAddress(),
                                        laptopSeedDTO.getCpuSpeed(),
                                        laptopSeedDTO.getRam(),
                                        laptopSeedDTO.getStorage()))
                                .append(System.lineSeparator());
                    }

                    return isValid;
                })
                .map(laptopSeedDTO -> {
                    Laptop laptop = modelMapper.map(laptopSeedDTO, Laptop.class);
                    laptop.setShop(shopService.findShopByName(laptopSeedDTO.getShop().getName()));
                    return laptop;
                })
                .forEach(laptopRepository::save);

        return sb.toString();
    }

    @Override
    public String exportBestLaptops() {
        return null;
    }
}
