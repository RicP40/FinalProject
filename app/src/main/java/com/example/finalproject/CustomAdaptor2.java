package com.example.finalproject;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
public class CustomAdaptor2 extends RecyclerView.Adapter<CustomAdaptor2.CustomViewHolder2> {
    private List<Book> bookList;
    private Context context;

    public CustomAdaptor2(Context context, List<Book> bookList){
        this.context = context;
        this.bookList = bookList;
    }

    class CustomViewHolder2 extends RecyclerView.ViewHolder {
    public final View mView;

    TextView txtId;
    TextView txtAuthor;
    TextView txtTitle;
    TextView txtDescription;
    TextView txtThumbnailUrl;
    TextView txtPrice;

    CustomViewHolder2(View itemView) {
        super(itemView);
        mView = itemView;

        txtId = mView.findViewById(R.id.txtId);
        txtAuthor = mView.findViewById(R.id.txtAuthor);
        txtTitle = mView.findViewById(R.id.txtTitle);
        txtDescription = mView.findViewById(R.id.txtDescription);
        txtThumbnailUrl = mView.findViewById(R.id.txtThumbnailUrl);
        txtPrice = mView.findViewById(R.id.txtPrice);
    }
}

    @Override
    public CustomViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom2_row, parent, false);
        return new CustomViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder2 holder, int position) {
        holder.txtId.setText(bookList.get(position).getId().toString());
        holder.txtAuthor.setText(bookList.get(position).getAuthor());
        holder.txtTitle.setText(bookList.get(position).getTitle());
        holder.txtDescription.setText(bookList.get(position).getDescription());
        holder.txtThumbnailUrl.setText(bookList.get(position).getThumbnailUrl());
        holder.txtPrice.setText(bookList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
