package com.jrDeffect.javacore.view;

import com.jrDeffect.javacore.controller.RegionController;
import com.jrDeffect.javacore.model.Region;

import java.util.List;
import java.util.Scanner;

public class RegionView {

    private final RegionController regionController = new RegionController();

    public Region getRegionId(){
        Scanner scanReg = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long inputId = scanReg.nextLong();
        return regionController.getById(inputId);
    }

     public List<Region> getAllRegions() {
        Scanner scanReg = new Scanner(System.in);
        System.out.println("Enter 1 for a list of all regions : ");
        Long inputId = scanReg.nextLong();
        if(inputId == 1){
             regionController.getAll();
        }
        else {
            System.out.println("please try again, enter 1 :");
        }
        return regionController.getAll();
    }

    public Region createRegion() {
        Scanner scanReg = new Scanner(System.in);
        System.out.println("Enter name: ");
        String inputName = scanReg.next();
        return regionController.create(inputName);
    }

    public void editRegion() {
        Scanner scanReg = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long inputId = scanReg.nextLong();
        System.out.println("Enter name: ");
        String inputName = scanReg.next();
        Region updatedRegion = regionController.update(inputId, inputName);
        System.out.println(updatedRegion);
    }

    public void delete() {
        Scanner scanReg = new Scanner(System.in);
        System.out.println("Enter id: ");
        Long inputId = scanReg.nextLong();
        regionController.deleteById(inputId);
    }
}
