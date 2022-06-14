package com.example.football.service.impl;

import com.example.football.models.dto.StatsSeedRootDTO;
import com.example.football.models.entity.Stat;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StatServiceImpl implements StatService {
    private static final String STATS_FILE_PATH = "/Users/sezgin/Documents/SoftUni-Self-Learning/Java-DB/Spring-Data/Exam-Prep/skeleton/skeleton/src/main/resources/files/xml/stats.xml";

    private final StatRepository statRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public StatServiceImpl(StatRepository statRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override

    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_FILE_PATH));
    }

    @Override
    public String importStats() throws JAXBException {
        StringBuilder sb = new StringBuilder();
        xmlParser.fromFile(STATS_FILE_PATH, StatsSeedRootDTO.class)
                .getStats()
                .stream()
                .filter(statSeedDTO -> {
                    boolean isValid = validationUtil.isValid(statSeedDTO);

                    if (!isValid || statRepository.findByPassingAndShootingAndEndurance(
                            statSeedDTO.getPassing(),
                            statSeedDTO.getShooting(),
                            statSeedDTO.getEndurance()) != null) {

                        sb.append("Invalid Stat")
                                .append(System.lineSeparator());

                    } else {
                        sb.append(String.format("Successfully import Stat %.2f - %.2f - %.2f"
                                        , statSeedDTO.getShooting(), statSeedDTO.getPassing()
                                        , statSeedDTO.getEndurance()))
                                .append(System.lineSeparator());
                    }

                    return isValid;
                })
                .map(statSeedDTO -> modelMapper.map(statSeedDTO, Stat.class))
                .forEach(statRepository::save);

        return sb.toString();
    }

    @Override
    public Stat findStatById(Long id) {
        return statRepository.findById(id)
                .orElseThrow();
    }
}
