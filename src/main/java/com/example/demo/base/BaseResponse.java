package com.example.demo.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.example.demo.util.StaticValue.*;

/**
 This class is the basis for any file controller
 */

public abstract class BaseResponse {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ResponseEntity<?> response(String response, Object data, String exception, HttpStatus statusCode) {
        try {
            Map<Object, Object> map = new HashMap<>();
            map.put(RESPONSE, response);
            map.put(DATA, data);
            map.put(EXEPTION, exception);
            return new ResponseEntity<>(map, statusCode);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}