package com.webseries.webseries.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.webseries.webseries.model.WebSeries;
import com.webseries.webseries.repository.WebSeriesRepository;

public class WebSeriesServiceImp implements WebSeriesService{

    @Autowired
    private WebSeriesRepository seriesRepo;

   
    public String upsertSeries(WebSeries series) {
        seriesRepo.save(series);
        return "Success";
    }

    
    public List<WebSeries> getAllSeries() {
        return seriesRepo.findAll();
    }

    
    public WebSeries getById(Integer id) {
        Optional<WebSeries> findById = seriesRepo.findById(id);

        if(findById.isPresent())
            return findById.get();
        else
            return null;
    }

    
    public List<WebSeries> getByname(String name) {
        return seriesRepo.findByName(name);
    }

   
    public String deleteSeries(Integer id) {
        if(seriesRepo.existsById(id)){
            seriesRepo.deleteById(id);
            return "Deleted Successfully";
        } else{
            return "No record found";
        }
    }
}
