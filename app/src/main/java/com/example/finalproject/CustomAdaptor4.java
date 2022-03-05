package com.example.finalproject;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomAdaptor4 extends RecyclerView.Adapter<CustomAdaptor4.CustomViewHolder4> {
    private List<Inventory> inventoryList;
    private Context context;

    public CustomAdaptor4(Context context, List<Inventory> inventoryList){
        this.context = context;
        this.inventoryList = inventoryList;
    }

    class CustomViewHolder4 extends RecyclerView.ViewHolder {
        public final View mView;

        TextView txtId;
        TextView txtBookID;
        TextView txtBranchID;
        TextView txtQuantity;


        CustomViewHolder4(View itemView) {
            super(itemView);
            mView = itemView;

            txtId = mView.findViewById(R.id.txtId);
            txtBookID = mView.findViewById(R.id.txtBookID);
            txtBranchID = mView.findViewById(R.id.txtBranchID);
            txtQuantity = mView.findViewById(R.id.txtQuantity);

        }
    }

    @Override
    public CustomAdaptor4.CustomViewHolder4 onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom4_row, parent, false);
        return new CustomViewHolder4(view);
    }

    @Override
    public void onBindViewHolder(CustomAdaptor4.CustomViewHolder4 holder, int position) {
        holder.txtId.setText(inventoryList.get(position).getId().toString());
        holder.txtBookID.setText(inventoryList.get(position).getBookID().toString());
        holder.txtBranchID.setText(inventoryList.get(position).getBranchID().toString());
        holder.txtQuantity.setText(inventoryList.get(position).getQuantity().toString());

    }

    @Override
    public int getItemCount() {
        return inventoryList.size();
    }
}
