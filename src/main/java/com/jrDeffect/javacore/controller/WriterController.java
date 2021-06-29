package com.jrDeffect.javacore.controller;

import com.jrDeffect.javacore.model.Writer;
import com.jrDeffect.javacore.repository.gson.JsonWriterRepositoryImpl;
import com.jrDeffect.javacore.repository.WriterRepository;

import java.util.List;

public class WriterController {
    private final WriterRepository jsonWriteRepository = new JsonWriterRepositoryImpl();

    Writer getById(Long id) {
        return jsonWriteRepository.getById(id);
    }

    List<Writer> getAll(){
        return jsonWriteRepository.getAll();
    }

    public Writer create(String firstName,String lastName ){
        Writer writer = new Writer();
        return jsonWriteRepository.save(writer);
    }

    public Writer update (Long id, String firstName, String lastName){
        Writer writer = new Writer();
        writer.setId(id);
        writer.setFirstName(firstName);
        writer.setLastName(lastName);
        return jsonWriteRepository.update(writer);
    }

    void deleteById(Long id){
        jsonWriteRepository.deleteById(id);
    }
}
