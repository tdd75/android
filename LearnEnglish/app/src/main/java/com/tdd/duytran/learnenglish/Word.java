package com.tdd.duytran.learnenglish;

import android.graphics.Bitmap;

public class Word {
    private int id;
    private String english, vietnamese, example;
    private byte[] picture;

    public Word(int id, String english, String vietnamese, String example, byte[] picture) {
        this.id = id;
        this.english = english;
        this.vietnamese = vietnamese;
        this.example = example;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getVietnamese() {
        return vietnamese;
    }

    public void setVietnamese(String vietnamese) {
        this.vietnamese = vietnamese;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
