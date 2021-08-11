package com.example.demo.contoller;

import com.example.demo.base.BaseResponse;
import com.example.demo.entity.Coordinates;
import com.example.demo.model.CoordinatesModel;
import com.example.demo.service.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.demo.util.StaticValue.*;

@RestController
public class CoordinatesController extends BaseResponse {

    @Autowired
    CoordinateService coordinateService;

    /** This controller do the insert in our db */
    @PostMapping("/new-coordinate")
    ResponseEntity<?> newCoordinate(@RequestBody Coordinates coordinates) {
        logger.debug(EXECUTE_SERVICE + "/new-coordinate parameter: {}", coordinates);
        try {
            Coordinates coordinate = coordinateService.saveNewLocation(coordinates);
            logger.debug(RESPONSE_SERVICE + "/new-coordinate response: {}", coordinates);
            return response(OK, coordinate, NULL, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(FAIL_SERVICE + "/new-coordinate exeption: {}", e.toString());
            return response(KO, NULL, e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /** This controller make the search for all coordinates */
    @GetMapping("/get-coordinates")
    ResponseEntity<?> getCoordinates(@RequestBody CoordinatesModel coordinates) {
        logger.debug(EXECUTE_SERVICE + "/get-coordinates parameter: {}", coordinates);
        try {
            Page<Coordinates> listCoordinates = coordinateService.getAllCoordinate(coordinates);
            logger.debug(RESPONSE_SERVICE + "/get-coordinates response: {}", listCoordinates);
            return response(OK, listCoordinates, NULL, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(FAIL_SERVICE + "/get-coordinates exeption: {}", e.getMessage());
            return response(KO, NULL, e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
