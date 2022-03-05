package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.Pictures;

import java.util.List;

public interface PictureService {
    List<String> findAllUrls();

    Pictures findById(Long id);
}
