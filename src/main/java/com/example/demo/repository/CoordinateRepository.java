package com.example.demo.repository;

import com.example.demo.entity.Coordinates;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoordinateRepository extends PagingAndSortingRepository<Coordinates, Long> {

    @Query("select cor from  Coordinates cor where " +
            "(:type is null or cor.type = :type) and " +
            "((:lat1 is null or :lat2 is null or :lng1 is null or :lng2 is null) or " +
            "((cor.lat between :lat1 and :lat2) and(cor.lng between :lng1 and :lng2)))  order by cor.type desc ")
    Page<Coordinates> getCoordinates(Double lat1, Double lat2, Double lng1, Double lng2, String type, Pageable pageable);
}

