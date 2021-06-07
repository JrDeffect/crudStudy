package com.jrDeffect.javacore.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.jrDeffect.javacore.model.Post;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

public class JsonPostRepositoryImpl implements PostRepository{

    private final Gson gson = new Gson();
    private final String POST_FILE_PATH = "./src/main/resources/posts.json";

    @Override
    public Post getById(Long id) {

        return getAllPostsInternal().stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Post> getAll() {

        return getAllPostsInternal();
    }

    private List<Post> getAllPostsInternal() {
        try {
            JsonReader reader = new JsonReader(new FileReader(POST_FILE_PATH));
            return gson.fromJson(reader, new TypeToken<List<Post>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            return Collections.emptyList();
        }
    }

    @Override
    public Post save(Post post) {

        return null;
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

        List<Post> posts = getAllPostsInternal();
        posts.removeIf(r -> r.getId().equals(id)); //TODO: write to file

    }
}
