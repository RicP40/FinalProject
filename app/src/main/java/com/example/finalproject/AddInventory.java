package com.example.finalproject;

import android.app.ProgressDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddInventory extends AppCompatActivity {
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_inventory);
    }

    public void addInventory(View view) {

        progressDoalog = new ProgressDialog(AddInventory.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);

        EditText editBookID = (EditText) findViewById(R.id.editBookID);
        EditText editBranchID = (EditText) findViewById(R.id.editBranchID);
        EditText editQuantity = (EditText) findViewById(R.id.editQuantity);
        Inventory inventory = new Inventory(Integer.parseInt(editBookID.getText().toString()), Integer.parseInt(editBranchID.getText().toString()), Integer.parseInt(editQuantity.getText().toString()));

        Call<Void> call = service.createInventory(inventory);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                progressDoalog.dismiss();
                //generateDataList(response.body());
                Log.d("Test", "Response received");
                if (response.isSuccessful()){
                    Log.d("Result", "Success");
                    Toast.makeText(AddInventory.this, "Successfully added!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(AddInventory.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
