package com.example.finalproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {


//book
    @GET("get")
    Call<List<Book>> getAllBooks();

    @POST("create")
    Call<Void> createBook(@Body Book book);

    @GET("{id}")
    Call<Book> getBook(@Path("id") Long id);




    //branch
    @GET("get")
    Call<List<Branch>> getAllBranchs();

    @PUT("update")
    Call<Branch> updateBranch(@Path("id") int id, @Body Branch branch);

    @DELETE("delete")
    Call<Branch> deleteBranch(@Path("id") int id);

    @POST("create")
    Call<Void> createBranch(@Body Branch branch);

    @GET("{id}")
    Call<Branch> getBranch(@Path("id") Long id);


    //inventory

    @GET("get")
    Call<List<Inventory>> getAllInventory();

    @POST("create")
    Call<Void> createInventory(@Body Inventory inventory);

    @GET("{id}")
    Call<Inventory> getInventory(@Path("id") Long id);
}