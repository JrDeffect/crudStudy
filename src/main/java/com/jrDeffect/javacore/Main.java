package com.jrDeffect.javacore;

import com.jrDeffect.javacore.repository.JsonRegionRepositoryImpl;

public class Main {
    public static void main(String[] args) {

        JsonRegionRepositoryImpl jsonRegRepoImpl = new JsonRegionRepositoryImpl();
        jsonRegRepoImpl.getAll();
        System.out.println(jsonRegRepoImpl.getAll());
    }
}
