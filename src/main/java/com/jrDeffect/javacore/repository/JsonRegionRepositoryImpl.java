package com.jrDeffect.javacore.repository;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.jrDeffect.javacore.model.Region;

import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
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
        try {
            JsonReader readerJsn = new JsonReader(new FileReader(REGION_FILE_PATH));
            return gson.fromJson(readerJsn, new TypeToken<List<Region>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Region save(Region region) {
        List<Region> regions = getAllRegionsInternal();
        regions.add(region);
        try (Writer jsonWriter = new FileWriter(REGION_FILE_PATH)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(regions, jsonWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return region;
    }

    @Override
    public Region update(Region region) {
        List<Region> regions = getAllRegionsInternal();

        try (FileWriter fileWriter = new FileWriter(REGION_FILE_PATH)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(regions, fileWriter);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return region;
    }

    @Override
    public void deleteById(Long id) {

        List<Region> regions = getAllRegionsInternal();
        regions.removeIf(r -> r.getId().equals(id));
        try (Writer jsonWriter = new FileWriter(REGION_FILE_PATH)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(regions, jsonWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
