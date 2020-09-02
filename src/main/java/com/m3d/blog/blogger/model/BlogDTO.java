package com.m3d.blog.blogger.model;

public class BlogDTO {
    
    private String name;
    private String description;

    public BlogDTO() {
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

    @Override
    public String toString() {
        return "BlogDTO [description=" + description + ", name=" + name + "]";
    }

}