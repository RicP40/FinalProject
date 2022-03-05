package com.example.finalproject;

import com.google.gson.annotations.SerializedName;

public class Inventory {
    @SerializedName("id")
    private Integer id;
    @SerializedName("bookID")
    private Integer bookID;
    @SerializedName("branchID")
    private Integer branchID;
    @SerializedName("quantity")
    private Integer quantity;

    public Inventory(){
    }

    public Inventory(Integer bookID, Integer branchID, Integer quantity){
        this.bookID = bookID;
        this.branchID = branchID;
        this.quantity = quantity;
    }



    public Inventory(Integer id, Integer bookID, Integer branchID, Integer quantity){
        this.id = id;
        this.bookID = bookID;
        this.branchID = branchID;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", bookID='" + bookID + '\'' +
                ", branchID='" + branchID + '\'' +
                ", quantity='" + quantity + '\'' +

                '}';
    }
}
