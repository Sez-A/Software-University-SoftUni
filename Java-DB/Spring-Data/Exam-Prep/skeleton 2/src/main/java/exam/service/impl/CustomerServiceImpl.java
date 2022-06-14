package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerSeedDTO;
import exam.model.entity.Customer;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.service.TownService;
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
public class CustomerServiceImpl implements CustomerService {
    private static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper,
                               Gson gson, ValidationUtil validationUtil, TownService townService) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(this.gson.fromJson(this.readCustomersFileContent(), CustomerSeedDTO[].class))
                .filter(customerSeedDTO -> {
                    boolean isValid = this.validationUtil.isValid(customerSeedDTO);

                    if (!isValid || customerRepository.findCustomerByEmail(customerSeedDTO.getEmail()) != null) {
                        sb.append("Invalid Customer")
                                .append(System.lineSeparator());
                        isValid = false;
                    } else {
                        sb.append(String.format("Successfully imported Customer %s %s - %s",
                                        customerSeedDTO.getFirstName(),
                                        customerSeedDTO.getLastName(),
                                        customerSeedDTO.getEmail()))
                                .append(System.lineSeparator());
                    }

                    return isValid;
                })
                .map(customerSeedDTO -> {
                    Customer customer = modelMapper.map(customerSeedDTO, Customer.class);
                    customer.setTown(townService.findTownByName(customerSeedDTO.getTown().getName()));

                    LocalDate registeredOn = LocalDate.parse(customerSeedDTO.getRegisteredOn(),
                            DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    customer.setRegisteredOn(registeredOn);
                    return customer;
                })
                .forEach(customerRepository::save);

        return sb.toString();
    }
}
