package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarSeedDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private static final String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";

    private final CarRepository carRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CarServiceImpl(CarRepository carRepository,
                          ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson.fromJson(this.readCarsFileContent(), CarSeedDto[].class))
                .filter(carSeedDto -> {
                    boolean isValid = this.validationUtil.isValid(carSeedDto);
                    sb.append(isValid ? String.format("Successfully imported car - %s - %s", carSeedDto.getMake()
                                    , carSeedDto.getModel()) : "Ivalid car")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(carSeedDto -> modelMapper.map(carSeedDto, Car.class))
                .forEach(carRepository::save);

        return sb.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        List<Car> cars = carRepository.findByPictureCountOrderDescThenByMake();

        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(String.format("Car make - %s, model - %s"
                            , car.getMake(), car.getModel()))
                    .append(System.lineSeparator())
                    .append(String.format("\tKilometers - %d", car.getKilometers()))
                    .append(System.lineSeparator())
                    .append(String.format("\tRegistered on - %s", car.getRegisteredOn()))
                    .append(System.lineSeparator())
                    .append(String.format("\tNumber of pictures - %d", car.getPictures().size()))
                    .append(System.lineSeparator());
        }

        return result.toString().trim();
    }

    @Override
    public Car findById(Long id) {
        return this.carRepository.findById(id).orElse(null);
    }
}
