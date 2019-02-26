package com.example.Cosmetics.entities;

public class Cosmetic {

private String id;
    private String name;
    private int amount;

public Cosmetic(String id, String name, int amount){
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

public String getId() {
        return this.id;
    }

public void setId(String id) {
        this.id = id;
    }

public String getName() {
        return this.name;
    }

public void setName(String name) {
        this.name = name;
    }

public int getAmount() {
        return amount;
    }

public void setAmount(int amount) {
        this.amount = amount;
    }
}