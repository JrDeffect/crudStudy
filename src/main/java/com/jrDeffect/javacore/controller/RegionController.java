package com.jrDeffect.javacore.controller;

import com.jrDeffect.javacore.model.Region;
import com.jrDeffect.javacore.repository.gson.JsonRegionRepositoryImpl;
import com.jrDeffect.javacore.repository.RegionRepository;

import java.util.List;

public class RegionController{

   private final RegionRepository jsonRegionRepository = new JsonRegionRepositoryImpl();

    public Region getById(Long id) {
        return jsonRegionRepository.getById(id);
    }

    public List<Region> getAll(){
        return jsonRegionRepository.getAll();
    }

    public Region create(String name){
        Region region = new Region();
        region.setName(name);
        return jsonRegionRepository.save(region);
    }

    public Region update (Long id, String name){
        Region region = new Region(id,name);
        region.setId(id);
        region.setName(name);
        return jsonRegionRepository.update(region);
    }

     public void deleteById(Long id){
        jsonRegionRepository.deleteById(id);
    }
}
