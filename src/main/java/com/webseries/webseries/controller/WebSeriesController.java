package com.webseries.webseries.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webseries.webseries.model.WebSeries;
import com.webseries.webseries.service.WebSeriesService;

import java.util.List;

@RestController
public class WebSeriesController {
    @Autowired
    private WebSeriesService seriesService;

    @PostMapping("/addSeries")
    public ResponseEntity<String> addSeries(@RequestBody WebSeries series){
        return new ResponseEntity<>(seriesService.upsertSeries(series), HttpStatus.ACCEPTED);
    }

    @GetMapping("/series")
    public ResponseEntity<List<WebSeries>> getAllSeries(){
        return new ResponseEntity<>(seriesService.getAllSeries(),HttpStatus.OK);
    }

    @GetMapping("/series/id/{id}")
    public ResponseEntity<WebSeries> getByID(@PathVariable(name = "id") Integer id){
        return new ResponseEntity<>(seriesService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/series/name/{name}")
    public ResponseEntity<List<WebSeries>> getByName(@PathVariable(name = "name") String name){
        return new ResponseEntity<>(seriesService.getByname(name),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateSeries(@RequestBody WebSeries series){
        return new ResponseEntity<>(seriesService.upsertSeries(series), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSeries(@PathVariable(name = "id") Integer id){
        return new ResponseEntity<>(seriesService.deleteSeries(id),HttpStatus.OK);
    }
}
