package com.example.testlistview;

import com.example.testlistview.model.Animal;

import java.util.ArrayList;

/**
 * Created by RTA on 10/29/2017.
 */

public class AnimalData {

    private static AnimalData sInstance;

    public ArrayList<Animal> animalList;

    public static AnimalData getInstance() {
        return sInstance;
    }

    public AnimalData getsInstance(){
        if(sInstance == null){
            sInstance = new AnimalData();
        }
        return sInstance;
    }
}
