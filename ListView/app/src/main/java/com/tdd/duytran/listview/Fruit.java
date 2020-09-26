package com.tdd.duytran.listview;

public class Fruit {
    private String name, description;
    private int Image;

    public Fruit(String name, String description, int image) {
        this.name = name;
        this.description = description;
        Image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
