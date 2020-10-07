package com.tdd.duytran.musicapp;

public class Song {
    private String name;
    private int file;
    private boolean isLiked;

    public boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean liked) {
        isLiked = liked;
    }

    public Song(String name, int file) {
        this.name = name;
        this.file = file;
        this.isLiked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }
}
