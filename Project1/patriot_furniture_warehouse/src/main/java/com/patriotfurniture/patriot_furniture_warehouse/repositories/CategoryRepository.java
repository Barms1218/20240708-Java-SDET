package com.patriotfurniture.patriot_furniture_warehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patriotfurniture.patriot_furniture_warehouse.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
