package com.example.finalproject;

import android.app.ProgressDialog;
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

public class ViewInventoryListActivity extends AppCompatActivity{
    private CustomAdaptor4 adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_inventory_list);

        progressDoalog = new ProgressDialog(ViewInventoryListActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);

        Call<List<Inventory>> call = service.getAllInventory();
        call.enqueue(new Callback<List<Inventory>>() {
            @Override
            public void onResponse(Call<List<Inventory>> call, Response<List<Inventory>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
                Log.d("Test", "Response received");
                //Log.d("Response", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Inventory>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(ViewInventoryListActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Inventory> inventoryList) {
        recyclerView = findViewById(R.id.customRecyclerView4);
        adapter = new CustomAdaptor4(this,inventoryList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewInventoryListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
