package com.example.automappingex.model.dto;

import java.util.ArrayList;
import java.util.List;

public class GameEditDto {
    private Long id;
    private List<String> values;

    public GameEditDto() {
        this.values = new ArrayList<>();
    }

    public GameEditDto(Long id, List<String> values) {
        this.id = id;
        this.values = values;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
