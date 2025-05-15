package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;
    private final Feline feline;

    public Lion(String gender, Feline feline) throws Exception {
        if ("Самец".equals(gender)) {
            this.hasMane = true;
        } else if ("Самка".equals(gender)) {
            this.hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
        this.feline = feline;
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public int getKittens() {
        return feline.getKittens();
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
    }
}

