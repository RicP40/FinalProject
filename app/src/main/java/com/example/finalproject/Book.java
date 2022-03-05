package com.example.finalproject;

import com.google.gson.annotations.SerializedName;


public class Book {
    @SerializedName("id")
    private Integer id;
    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("thumbnailUrl")
    private String thumbnailUrl;
    @SerializedName("price")
    private Integer price;
    @SerializedName("branch")
    private String branch;
    @SerializedName("quantity")
    private Integer quantity;


    public Book(){
    }

    public Book(String author, String title, String description, String thumbnailUrl, Integer price){
        this.author = author;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.price = price;
        this.branch = branch;
        this.quantity = quantity;
    }

    public Book(Integer id, String author, String title, String description, String thumbnailUrl, Integer price){
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.price = price;
        this.branch = branch;
        this.quantity = quantity;
    }


    public Integer getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public Integer getPrice() { return price;}

    public String getBranch() { return branch;}

    public Integer getQuantity() { return quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", price='" + price + '\'' +
                ", branch='" + branch + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }



}
