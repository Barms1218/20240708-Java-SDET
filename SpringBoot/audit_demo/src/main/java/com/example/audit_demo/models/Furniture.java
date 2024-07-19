package main.java.com.example.audit_demo.models;

public class Furniture {
    private String type;
    private int weight;
    private int size;

    public Furniture(String type, int weight, int size) {
        this.weight = weight;
        this.type = type;
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    @Override
    public String toString() {
        return "Furniture [type=" + type + ",weight=" + weight + ", size=" + size + "]";
    }

}
