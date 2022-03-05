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

public class ViewBranchActivity extends AppCompatActivity{
    private CustomAdapter3 adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_branch_list);

        progressDoalog = new ProgressDialog(ViewBranchActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);

        Call<List<Branch>> call = service.getAllBranchs();
        call.enqueue(new Callback<List<Branch>>() {
            @Override
            public void onResponse(Call<List<Branch>> call, Response<List<Branch>> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
                Log.d("Test", "Response received");
                //Log.d("Response", response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Branch>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(ViewBranchActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateBranch(int id, Branch u) {
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);

        Call<Branch> call = service.updateBranch(id, u);
        call.enqueue(new Callback<Branch>() {
            @Override
            public void onResponse(Call<Branch> call, Response<Branch> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ViewBranchActivity.this, "Branch updated successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Branch> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void deleteBranch ( int id){
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);
        Call<Branch> call = service.deleteBranch(id);
        call.enqueue(new Callback<Branch>() {
            @Override
            public void onResponse(Call<Branch> call, Response<Branch> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ViewBranchActivity.this, "Branch deleted successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Branch> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }


    private void generateDataList(List<Branch> branchList) {
        recyclerView = findViewById(R.id.customRecyclerView3);
        adapter = new CustomAdapter3(this,branchList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewBranchActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
