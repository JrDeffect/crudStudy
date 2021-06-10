package com.jrDeffect.javacore;


import com.jrDeffect.javacore.repository.JsonPostRepositoryImpl;
import com.jrDeffect.javacore.repository.JsonRegionRepositoryImpl;
import com.jrDeffect.javacore.repository.JsonWriterRepositoryImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        JsonRegionRepositoryImpl jsonRegRepoImpl = new JsonRegionRepositoryImpl();
        JsonPostRepositoryImpl jsonPostRepoImpl = new JsonPostRepositoryImpl();
        //JsonWriterRepositoryImpl jsonWriterRepoImpl = new JsonWriterRepositoryImpl();

        Scanner scan = new Scanner(System.in);
        int input = 0;
        while (input < 5) {
            System.out.println("1. All list; 2. Posts; 3. Regions; 4. Writers; 5. Exit");
            input = scan.nextInt();

            switch (input) {
                case 1:
                    System.out.println(jsonPostRepoImpl.getAll());
                    System.out.println(jsonRegRepoImpl.getAll());
                    // System.out.println(jsonWriterRepoImpl.getAll());
                    break;
                case 2:
                    System.out.println(jsonPostRepoImpl.getAll());
                    break;
                case 3:
                    System.out.println(jsonRegRepoImpl.getAll());
                    break;
                case 4:
                    // System.out.println(jsonWriterRepoImpl.getAll());
                    //break;
                case 5:
                    System.out.println("exit");
                    return;
                default:
                    System.out.println("Wrong input! Please enter values from the list");
                    input = 1;
            }
        }
    }
}
