package com.jrDeffect.javacore.controller;

import com.jrDeffect.javacore.model.Region;
import com.jrDeffect.javacore.repository.JsonRegionRepositoryImpl;
import com.jrDeffect.javacore.repository.RegionRepository;

import java.util.List;

public class RegionController{

   private final RegionRepository jsonRegionRepository = new JsonRegionRepositoryImpl();

    Region getById(Long id) {
        return jsonRegionRepository.getById(id);
    }

    List<Region> getAll(){
        return jsonRegionRepository.getAll();
    }

    public Region create(String name){
        Region region = new Region();
        return jsonRegionRepository.save(region);
    }

    public Region update (Long id, String name){
        Region region = new Region(id,name);
        return jsonRegionRepository.update(region);
    }

    void deleteById(Long id){
        jsonRegionRepository.deleteById(id);
    }
}
