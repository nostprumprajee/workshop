package com.example.Cosmetics.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cosmetic {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;
    private String name;
    private int    amount;

    public Cosmetic(){

    }
    
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