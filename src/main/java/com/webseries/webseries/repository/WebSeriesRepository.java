package com.webseries.webseries.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webseries.webseries.model.WebSeries;

public interface WebSeriesRepository extends JpaRepository<WebSeries, Integer>{

    List<WebSeries> findByName(String name);
    
}
