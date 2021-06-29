package com.jrDeffect.javacore;

import com.jrDeffect.javacore.view.PostView;
import com.jrDeffect.javacore.view.RegionView;
import com.jrDeffect.javacore.view.WriterView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RegionView regionView = new RegionView();
        PostView postView = new PostView();
        WriterView writerView = new WriterView();

        Scanner scan = new Scanner(System.in);
        int input = 0;
        while (input < 6) {

            System.out.println("1. Regions list; 2. Desired region 3. Create region; 4. Update region; 5. Delete region; 6. Exit");
            input = scan.nextInt();

            switch (input) {
                case 1:
                    regionView.getAllRegions();
                    break;
                case 2:
                    regionView.getRegionId();
                case 3:
                    regionView.createRegion();
                    break;
                case 4:
                    regionView.editRegion();
                    break;
                case 5:
                    regionView.delete();
                    break;
                case 6:
                    System.out.println("exit");
                    return;
                default:
                    System.out.println("Wrong input! Please enter values from the list");
                    input = 1;
            }
        }

    }
     //class MainView{}
}
