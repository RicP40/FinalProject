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

public class AddBranch extends AppCompatActivity{
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);
    }

    public void addBranch(View view) {

        progressDoalog = new ProgressDialog(AddBranch.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        /*Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);

        EditText editBranchName = (EditText) findViewById(R.id.editBranchName);
        EditText editAddress = (EditText) findViewById(R.id.editAddress);
        EditText editCity = (EditText) findViewById(R.id.editCity);
        EditText editState = (EditText) findViewById(R.id.editState);
        EditText editZip = (EditText) findViewById(R.id.editZip);
        EditText editPhone = (EditText) findViewById(R.id.editPhone);
        Branch branch = new Branch(editBranchName.getText().toString(), editAddress.getText().toString(), editCity.getText().toString(), editState.getText().toString(), editZip.getText().toString(), editPhone.getText().toString());

        Call<Void> call = service.createBranch(branch);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                progressDoalog.dismiss();
                //generateDataList(response.body());
                Log.d("Test", "Response received");
                if (response.isSuccessful()){
                    Log.d("Result", "Success");
                    Toast.makeText(AddBranch.this, "Successfully added!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(AddBranch.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
