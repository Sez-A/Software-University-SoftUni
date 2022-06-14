package com.example.objectmapping;

import com.example.objectmapping.models.dto.*;
import com.example.objectmapping.models.dto.datetimetest.DateTimeSource;
import com.example.objectmapping.models.dto.datetimetest.DateTimeTarget;
import com.example.objectmapping.models.dto.firstlastnametest.FirstLastNameSource;
import com.example.objectmapping.models.dto.firstlastnametest.FullNameTarget;
import com.example.objectmapping.models.entities.Employee;
import com.example.objectmapping.repositories.EmployeeRepository;
import com.example.objectmapping.services.EmployeeService;
import com.example.objectmapping.services.util.FormatConverter;
import com.example.objectmapping.services.util.FormatConverterFactory;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;

    private final FormatConverterFactory factory;

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public Main(EmployeeService employeeService, FormatConverterFactory factory, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.factory = factory;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {
//        Stream.of(1,2,3,4,6)
//                .map(el -> el * 2)
//                .peek(el -> System.out.println(el * 2))
//                .collect(Collectors.toList());
//
//
//
////        var source = new DateTimeSource();
////        source.setDate("2020-11-11 12:34:56");
////
////        DateTimeTarget target = this.modelMapper.map(
////                source,
////                DateTimeTarget.class
////        );
//
//
//        var source = new FirstLastNameSource();
//        source.setFirstName("pesho");
//        source.setLastName("petrov");
//
//        var target = this.modelMapper.map(
//                source,
//                FullNameTarget.class
//        );
//
//        List<EmployeeAverageSalaryDto> allWithAvgSalary = this.employeeRepository.findAllWithAvgSalary();
////        "2020-05-05 16:40:50"
//        var sc = new Scanner(System.in);
//
//        System.out.println("Enter format type: ");
//        String formatType = sc.nextLine();
//
//        FormatConverter converter = this.factory.create(formatType);
//        converter.setPrettyPrint();
//
//        TestDto testDto = converter.deserializeFromFile(
//                "./src/main/resources/test-za-dati.xml",
//                TestDto.class
//        );
//
//        var line = sc.nextLine();
//
//
//
//        while (!line.equals("end")) {
//            var cmdParts = line.split(" ", 2);
//            switch (cmdParts[0]) {
//                case "find":
//                    Long id = Long.parseLong(cmdParts[1]);
//                    ManagerDto managerById = this.employeeService.findOne(id);
//
//                    System.out.println(converter.serialize(managerById));
//                    break;
//                case "findAll":
//                    List<ManagerDto> allManagers = this.employeeService.findAll();
//                    System.out.println(converter.serialize(new ManagerCollection(allManagers)));
//                    break;
//                case "save":
//                    String input = cmdParts[1];
//
//                    EmployeeCreateRequest request
//                            = converter.deserialize(input, EmployeeCreateRequest.class);
//
//
//                    EmployeeCreateResponse response = this.employeeService.save(
//                            request
//                    );
//
//                    System.out.println(converter.serialize(response));
//                    break;
//                case "save-from-file":
//                    EmployeeCreateRequest fileRequest = converter.deserializeFromFile(
//                            cmdParts[1],
//                            EmployeeCreateRequest.class
//                    );
//
//                    EmployeeCreateResponse fileResponse = this.employeeService.save(
//                            fileRequest
//                    );
//
//                    System.out.println(converter.serialize(fileResponse));
//                    break;
//                case "findAll-to":
//                    List<ManagerDto> managers = this.employeeService.findAll();
//                    converter.serialize(
//                            new ManagerCollection(managers),
//                            cmdParts[1] + "." + formatType
//                    );
//
//                    System.out.println("Written to file " + cmdParts[1]);
//
//                    break;
//                case "change-format":
//                    converter = this.factory.create(cmdParts[1]);
//                    System.out.println("Format changed to " + cmdParts[1]);
//                    break;
//                case "pretty-print":
//                    converter.setPrettyPrint();
//                    System.out.println("Success");
//                    break;
//            }
//
//            line = sc.nextLine();
//        }


//
//        List<ManagerDto> managers = this.employeeService.findAll();
//        managers.forEach(managerDto -> {
//            if (managerDto.getSubordinates().isEmpty()) {
//                return;
//            }
//            System.out.println(managerDto.getFirstName() + " " + managerDto.getLastName() + " (" + managerDto.getSubordinates().size() + "):");
//            managerDto.getSubordinates().forEach(employeeDto -> {
//                System.out.println("\t" + employeeDto.getFirstName() + " " + employeeDto.getLastName() + " : " + employeeDto.getIncome());
//            });
//        });

        // TODO: 1.12.2021 г.
//        ManagerDto managerDto = new ManagerDto();
//        List<EmployeeDto> employeeDtos = new ArrayList<>();
//
//        EmployeeDto seza = new EmployeeDto();
//        seza.setFirstName("Sezgin");
//        seza.setIncome(new BigDecimal("5000"));
//
//        EmployeeDto ivan = new EmployeeDto();
//        ivan.setFirstName("Ivan");
//        ivan.setIncome(new BigDecimal("5000"));
//
//        employeeDtos.add(seza);
//        employeeDtos.add(ivan);
//
//        managerDto.setSubordinates(employeeDtos);
//        JAXBContext jaxbContext = JAXBContext.newInstance(managerDto.getClass());
//
//        Marshaller marshaller = jaxbContext.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(managerDto, System.out);

        // TODO: 1.12.2021 г. Save employee
//        JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeCreateRequest.class);
//        Scanner scan = new Scanner(System.in);
//        String input = scan.nextLine();
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
//        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//        EmployeeCreateRequest request = (EmployeeCreateRequest) unmarshaller.unmarshal(inputStream);
//
//        EmployeeCreateResponse response = this.employeeService.save(request);
//
//        Marshaller marshaller = jaxbContext.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(response, System.out);

         
        ManagerCollection managerCollection = new ManagerCollection();

        List<ManagerDto> managerDtos = this.employeeService.findAll();
        managerCollection.setManagers(managerDtos);
        JAXBContext jaxbContext = JAXBContext.newInstance(ManagerCollection.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(managerCollection, System.out);

    }
}
