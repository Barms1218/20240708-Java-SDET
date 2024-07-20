package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Furniture;

@Service
public class FurnitureService {

    private final List<Furniture> furnitureList = new ArrayList<>();

    public FurnitureService() {
        furnitureList.add(new Furniture(1, "Chair", 6));
        furnitureList.add(new Furniture(2, "Bed", 50));
        furnitureList.add(new Furniture(3, "Desk", 75));
    }

    public List<Furniture> findAllFurniture() {
        return furnitureList;
    }
}
