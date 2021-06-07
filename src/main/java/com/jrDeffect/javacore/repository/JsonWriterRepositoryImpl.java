package com.jrDeffect.javacore.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.jrDeffect.javacore.model.Writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

public class JsonWriterRepositoryImpl implements WriterRepository {

    private final Gson gson = new Gson();
    private final String WRITER_FILE_PATH = "./src/main/resources/writers.json";

    @Override
    public Writer getById(Long id) {

        //return getAllWritersInternal().stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
        return null;
    }

    @Override
    public List<Writer> getAll() {

        return getAllWritersInternal();
    }

    private List<Writer> getAllWritersInternal() {
        try {
            JsonReader reader = new JsonReader(new FileReader(WRITER_FILE_PATH));
            return gson.fromJson(reader, new TypeToken<List<Writer>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Writer save(Writer writer) {

        return null;
    }

    @Override
    public Writer update(Writer writer) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

        List<Writer> writers = getAllWritersInternal();
        //writers.removeIf(r -> r.getId().equals(id)); //TODO: write to file

    }
}
