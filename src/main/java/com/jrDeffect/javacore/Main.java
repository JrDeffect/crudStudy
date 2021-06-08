package com.jrDeffect.javacore;

import com.jrDeffect.javacore.repository.JsonPostRepositoryImpl;
import com.jrDeffect.javacore.repository.JsonRegionRepositoryImpl;
import com.jrDeffect.javacore.repository.JsonWriterRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        JsonRegionRepositoryImpl jsonRegRepoImpl = new JsonRegionRepositoryImpl();
        System.out.println(jsonRegRepoImpl.getAll());
        jsonRegRepoImpl.deleteById(666L);

        JsonPostRepositoryImpl jsonPostRepoImpl = new JsonPostRepositoryImpl();
        System.out.println(jsonPostRepoImpl.getAll());

        JsonWriterRepositoryImpl jsonWriterRepoImpl = new JsonWriterRepositoryImpl();
        System.out.println(jsonWriterRepoImpl.getAll());

    }
}
