package com.jrDeffect.javacore.controller;

import com.jrDeffect.javacore.model.Post;
import com.jrDeffect.javacore.repository.gson.JsonPostRepositoryImpl;
import com.jrDeffect.javacore.repository.PostRepository;


import java.util.List;

public class PostController {

    private final PostRepository jsonPostRepository = new JsonPostRepositoryImpl();

    Post getById(Long id) {
        return jsonPostRepository.getById(id);
    }

    List<Post> getAll(){
        return jsonPostRepository.getAll();
    }

    public Post create(String content){
        Post post = new Post();
        post.setContent(content);
        return jsonPostRepository.save(post);
    }

    public Post update (Long id, String content){
        Post post = new Post();
        post.setId(id);
        post.setContent(content);
        return jsonPostRepository.update(post);
    }

    void deleteById(Long id){
        jsonPostRepository.deleteById(id);
    }
}
