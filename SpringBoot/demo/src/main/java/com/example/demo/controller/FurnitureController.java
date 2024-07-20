package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.FurnitureService;

@Controller
public class FurnitureController {

    @Autowired
    private FurnitureService furnitureService;

    @RequestMapping(value = "/furniture", method = RequestMethod.GET)
    public String getFurniture(Model model) {
        model.addAttribute("allFurniture", furnitureService.findAllFurniture());
        return "allFurniture"; // Adjusted path to match the location in templates folder
    }
}
