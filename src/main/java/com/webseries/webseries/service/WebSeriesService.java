package com.webseries.webseries.service;

import java.util.List;

import com.webseries.webseries.model.WebSeries;

public interface WebSeriesService {
    public String upsertSeries(WebSeries series);

    public List<WebSeries> getAllSeries();

    public WebSeries getById(Integer id);

    public List<WebSeries> getByname(String name);

    public String deleteSeries(Integer id);
}
