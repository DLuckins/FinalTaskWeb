package com.example.FinalProjectWeb;

public class Recipe {
    public Recipe() {
    }
    public Recipe(String name, String desc, String imgLink) {
        this.name = name;
        this.desc = desc;
        this.imgLink=imgLink;
    }

    private String name;
    private String imgLink;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
