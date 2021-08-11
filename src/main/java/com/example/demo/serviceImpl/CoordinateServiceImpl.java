package com.example.demo.serviceImpl;

import com.example.demo.entity.Coordinates;
import com.example.demo.model.CoordinatesModel;
import com.example.demo.repository.CoordinateRepository;
import com.example.demo.service.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

@Service
public class CoordinateServiceImpl implements CoordinateService {

    @Autowired
    CoordinateRepository coordinateRepository;

    /** This method is used to make the save in db */
    @Override
    public Coordinates saveNewLocation(Coordinates coordinates) {
        return coordinateRepository.save(coordinates);
    }

    /** This method is used to retrive all the coordinates from db */
    @Override
    public Page<Coordinates> getAllCoordinate(CoordinatesModel coordinates) {

        if (coordinates.getType() == null || coordinates.getType().isEmpty())
            coordinates.setType(null);

        if (coordinates.getLatFirstPoint() == null || coordinates.getLatSecondPoint() == null ||
            coordinates.getLngFirstPoint() == null || coordinates.getLatSecondPoint() == null) {
            coordinates.setLatFirstPoint(null);
            coordinates.setLatSecondPoint(null);
            coordinates.setLngFirstPoint(null);
            coordinates.setLngSecondPoint(null);
        }

        Pageable paging;
        if (coordinates.getLimit() == null) paging = PageRequest.of(0, 1);
        else paging = PageRequest.of(0, coordinates.getLimit());

        return coordinateRepository.getCoordinates(coordinates.getLatFirstPoint(), coordinates.getLatSecondPoint(), coordinates.getLngFirstPoint(), coordinates.getLngSecondPoint(), coordinates.getType(), paging);
    }
}
