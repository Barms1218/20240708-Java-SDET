package com.example.demo.models;

public class Furniture {
    private int id;
    private String type;
    private int size;

    // Constructor
    public Furniture(int id, String type, int size) {
        this.id = id;
        this.type = type;
        this.size = size;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
