package com.patriotfurniture.patriot_furniture_warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patriotfurniture.patriot_furniture_warehouse.models.Furniture;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {

}
