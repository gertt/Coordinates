package com.example.demo.service;

import com.example.demo.entity.Coordinates;
import com.example.demo.model.CoordinatesModel;
import org.springframework.data.domain.Page;

public interface CoordinateService {

    Coordinates saveNewLocation(Coordinates coordinatesEntity);

    Page<Coordinates> getAllCoordinate(CoordinatesModel coordinates);
}
