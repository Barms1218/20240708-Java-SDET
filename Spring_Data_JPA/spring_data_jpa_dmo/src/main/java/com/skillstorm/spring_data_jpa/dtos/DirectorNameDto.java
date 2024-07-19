package com.skillstorm.spring_data_jpa.dtos;

import org.springframework.beans.factory.annotation.Value;

public interface DirectorNameDto {

    @Value("#{target.firstName + \" \" + target.lastName}")
    int getFullName();
}
