package com.patriotfurniture.patriot_furniture_warehouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patriotfurniture.patriot_furniture_warehouse.models.Furniture;
import com.patriotfurniture.patriot_furniture_warehouse.repositories.FurnitureRepository;

@RestController
@RequestMapping("/warehouse/furniture")
public class FurnitureController {

    @Autowired
    private FurnitureRepository furnitureRepository;

    @GetMapping
    public List<Furniture> getAllFurniture() {
        return furnitureRepository.findAll();
    }

    public Furniture createFurniture(@RequestBody Furniture furniture) {
        return furnitureRepository.save(furniture);
    }
}
