package com.jrDeffect.javacore.repository;

import com.google.gson.Gson;
import com.jrDeffect.javacore.model.Region;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.reflect.TypeToken;

public class JsonRegionRepositoryImpl implements RegionRepository {

    private final Gson gson = new Gson();
    private final String REGION_FILE_PATH = "./src/main/resources/regions.json";


    @Override
    public Region getById(Long id) {

        return getAllRegionsInternal().stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Region> getAll() {
        return getAllRegionsInternal();
    }

    private List<Region> getAllRegionsInternal() {
        Type regionListType = new TypeToken<ArrayList<Region>>() {
        }.getType();
        return gson.fromJson(REGION_FILE_PATH, regionListType);

    }

    @Override
    public Region save(Region region) {
        return null;
    }

    @Override
    public Region update(Region region) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

        List<Region> regions = getAllRegionsInternal();
        regions.removeIf(r -> r.getId().equals(id)); //TODO: write to file
    }
}
