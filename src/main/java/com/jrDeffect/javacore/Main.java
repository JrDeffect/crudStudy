package com.jrDeffect.javacore;

import com.jrDeffect.javacore.repository.JsonPostRepositoryImpl;
import com.jrDeffect.javacore.repository.JsonRegionRepositoryImpl;
import com.jrDeffect.javacore.repository.JsonWriterRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        JsonRegionRepositoryImpl jsonRegRepoImpl = new JsonRegionRepositoryImpl();
        JsonPostRepositoryImpl jsonPostRepoImpl = new JsonPostRepositoryImpl();
        JsonWriterRepositoryImpl jsonWriterRepoImpl = new JsonWriterRepositoryImpl();

    }
}
