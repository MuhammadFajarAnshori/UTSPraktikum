package com.azhar.switchlayout;


public class Item {
    private int imgResId;
    private String nama;
    private String titles;
    private String type;

    public Item(int imgResId, String nama, String titles, String type) {
        this.imgResId = imgResId;
        this.nama = nama;
        this.titles = titles;
        this.type = type;
    }

    public int getImgResId() {
        return imgResId;
    }

    public String getTitle() {
        return nama;
    }

    public String getTitles() { return titles;}

    public String getComments() {return type;}
}
