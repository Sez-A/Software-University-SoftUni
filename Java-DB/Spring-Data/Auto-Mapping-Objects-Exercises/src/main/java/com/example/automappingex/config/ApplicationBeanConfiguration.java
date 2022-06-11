package com.example.automappingex.config;

import com.example.automappingex.model.dto.GameAddDto;
import com.example.automappingex.model.entity.Game;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.addMappings(new PropertyMap<AddGameDto, Game>() {
//            @Override
//            protected void configure() {
//                map().setImageThumbnail(source.getThumbnailURL());
//            }
//        });

//        TypeMap<AddGameDto, Game> typeMap = modelMapper.createTypeMap(AddGameDto.class, Game.class);
//        typeMap.addMapping(AddGameDto::getThumbnailURL, Game::setImageThumbnail);


        modelMapper
                .typeMap(GameAddDto.class, Game.class)
                .addMappings(mapper -> mapper.map(GameAddDto::getThumbnailURL, Game::setImageThumbnail));


        return modelMapper;
    }
}
