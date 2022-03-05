package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void viewBookList(View view) {
        // Do something in response to button
        Intent intent2 = new Intent(this, ViewBookListActivity.class);
        startActivity(intent2);
    }

    public void viewBranchList(View view) {
        // Do something in response to button
        Intent intent3 = new Intent(this, ViewBranchActivity.class);
        startActivity(intent3);
    }

    public void viewInventoryList(View view) {
        // Do something in response to button
        Intent intent4 = new Intent(this, ViewInventoryListActivity.class);
        startActivity(intent4);
    }



    public void addBook(View view) {
        // Do something in response to button
        Intent intent6 = new Intent(this, AddBook.class);
        startActivity(intent6);
    }

    public void addBranch(View view) {
        // Do something in response to button
        Intent intent7 = new Intent(this, AddBranch.class);
        startActivity(intent7);
    }

    public void addInventory(View view) {
        // Do something in response to button
        Intent intent8 = new Intent(this, AddInventory.class);
        startActivity(intent8);
    }
}