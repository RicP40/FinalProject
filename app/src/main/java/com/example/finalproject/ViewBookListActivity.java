package com.example.finalproject;

import android.app.Dialog;
import android.app.ProgressDialog;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewBookListActivity extends AppCompatActivity{
    private CustomAdaptor2 adapter;
    private RecyclerView recyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_branch_list);

        /*Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);

        Call<List<Book>> call = service.getAllBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {

                generateDataList(response.body());
                Log.d("Test", "Response received");
                //Log.d("Response", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

                Toast.makeText(ViewBookListActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Book> bookList) {
        recyclerView = findViewById(R.id.customRecyclerView2);
        adapter = new CustomAdaptor2(this,bookList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewBookListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
