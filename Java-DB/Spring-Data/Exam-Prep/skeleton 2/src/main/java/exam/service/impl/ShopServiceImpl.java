package exam.service.impl;

import exam.model.dto.ShopSeedRootDTO;
import exam.model.entity.Shop;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ShopServiceImpl implements ShopService {
    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public ShopServiceImpl(ShopRepository shopRepository, ModelMapper modelMapper,
                           XmlParser xmlParser, ValidationUtil validationUtil, TownService townService) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOPS_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(SHOPS_FILE_PATH, ShopSeedRootDTO.class)
                .getShops()
                .stream()
                .filter(shopSeedDTO -> {
                    boolean isValid = validationUtil.isValid(shopSeedDTO);
                    if (!isValid || shopRepository.findByName(shopSeedDTO.getName()) != null) {
                        sb.append("Invalid shop")
                                .append(System.lineSeparator());
                        isValid = false;
                    } else {
                        sb.append(String.format("Successfully imported Shop %s - %d"
                                        , shopSeedDTO.getName()
                                        , shopSeedDTO.getIncome()))
                                .append(System.lineSeparator());
                    }
                    return isValid;
                })
                .map(validShopSeedDTO -> {
                    Shop shop = modelMapper.map(validShopSeedDTO, Shop.class);
                    shop.setTown(townService.findTownByName(validShopSeedDTO.getTown().getName()));
                    return shop;
                })
                .forEach(shopRepository::save);

        return sb.toString();
    }

    @Override
    public Shop findShopByName(String shopName) {
        return shopRepository.findByName(shopName);
    }
}
