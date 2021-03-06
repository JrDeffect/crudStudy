package com.jrDeffect.javacore.repository.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.jrDeffect.javacore.model.Writer;
import com.jrDeffect.javacore.repository.WriterRepository;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JsonWriterRepositoryImpl implements WriterRepository {

    private final Gson gson = new Gson();
    private final String WRITER_FILE_PATH = "./src/main/resources/writers.json";

    @Override
    public Writer getById(Long id) {
        return getAllWritersInternal().stream().filter(
                r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Writer> getAll() {
        return getAllWritersInternal();
    }

    private List<Writer> getAllWritersInternal() {
        try {
            JsonReader readerJsn = new JsonReader(new FileReader(WRITER_FILE_PATH));
            return gson.fromJson(readerJsn, new TypeToken<List<Writer>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            return Collections.emptyList();
        }
    }

    private Long writerMaxId() {
        List<Writer> writers = getAllWritersInternal();
        return writers.stream().map(Writer::getId)
                .max(Comparator.comparing(Long::valueOf)).orElse(1L) + 1;
    }

    @Override
    public Writer save(Writer writer) {
        List<Writer> writers = getAllWritersInternal();
        Long generatedId = writerMaxId();
        writer.setId(generatedId);
        writers.add(writer);
        try (FileWriter fileWriter = new FileWriter(WRITER_FILE_PATH)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(writers, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writerWriter();
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        List<Writer> writers = getAllWritersInternal();
        for (Writer writerItr : writers) {
            if (writerItr.getId().equals(writer.getId())) {
                writerItr.setFirstName((writer.getFirstName()));
                writerItr.setLastName((writer.getLastName()));
                writerItr.setPosts((writer.getPosts()));
                writerItr.setRegion((writer.getRegion()));
            }
        }
        writerWriter();
        return writer;
    }

    private void writerWriter() {
        List<Writer> writers = getAllWritersInternal();
        try (FileWriter fileWriter = new FileWriter(WRITER_FILE_PATH)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(writers, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        List<Writer> writers = getAllWritersInternal();
        writers.removeIf(r -> r.getId().equals(id));
        try (java.io.Writer jsonWriter = new FileWriter(WRITER_FILE_PATH)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(writers, jsonWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
