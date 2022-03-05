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

public class AddBook extends AppCompatActivity{
    ProgressDialog progressDoalog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        

    }

    public void addBook(View view) {
        progressDoalog = new ProgressDialog(AddBook.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();


        /*Create handle for the RetrofitInstance interface*/
        UserService service = RetrofitClient.getRetrofitInstance().create(UserService.class);

        EditText editAuthor = (EditText) findViewById(R.id.editAuthor);
        EditText editTitle = (EditText) findViewById(R.id.editTitle);
        EditText editDescription = (EditText) findViewById(R.id.editDescription);
        EditText editThumbnailUrl = (EditText) findViewById(R.id.editThumbnailUrl);
        EditText editPrice = (EditText) findViewById(R.id.editPrice);

        Book book = new Book(editAuthor.getText().toString(), editTitle.getText().toString(), editDescription.getText().toString(), editThumbnailUrl.getText().toString(), Integer.parseInt(editPrice.getText().toString()));


        Call<Void> call = service.createBook(book);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                progressDoalog.dismiss();
                //generateDataList(response.body());
                Log.d("Test", "Response received");
                if (response.isSuccessful()){
                    Log.d("Result", "Success");
                    Toast.makeText(AddBook.this, "Successfully added!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(AddBook.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
