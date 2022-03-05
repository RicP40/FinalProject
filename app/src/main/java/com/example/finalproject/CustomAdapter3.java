package com.example.finalproject;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CustomAdapter3 extends RecyclerView.Adapter<CustomAdapter3.CustomViewHolder3> {
    private List<Branch> branchList;
    private Context context;

    public CustomAdapter3(Context context, List<Branch> branchList){
        this.context = context;
        this.branchList = branchList;
    }

    class CustomViewHolder3 extends RecyclerView.ViewHolder {
        public final View mView;

        TextView txtId;
        TextView txtBranchName;
        TextView txtAddress;
        TextView txtCity;
        TextView txtState;
        TextView txtZip;
        TextView txtPhone;

        CustomViewHolder3(View itemView) {
            super(itemView);
            mView = itemView;

            txtId = mView.findViewById(R.id.txtId);
            txtBranchName = mView.findViewById(R.id.txtBranchName);
            txtAddress = mView.findViewById(R.id.txtAddress);
            txtCity = mView.findViewById(R.id.txtCity);
            txtState = mView.findViewById(R.id.txtState);
            txtZip = mView.findViewById(R.id.txtZip);
            txtPhone = mView.findViewById(R.id.txtPhone);
        }
    }

    @Override
    public CustomAdapter3.CustomViewHolder3 onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom3_row, parent, false);
        return new CustomViewHolder3(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter3.CustomViewHolder3 holder, int position) {
        holder.txtId.setText(branchList.get(position).getId().toString());
        holder.txtBranchName.setText(branchList.get(position).getBranchName());
        holder.txtAddress.setText(branchList.get(position).getAddress());
        holder.txtCity.setText(branchList.get(position).getCity());
        holder.txtState.setText(branchList.get(position).getState());
        holder.txtZip.setText(branchList.get(position).getZip());
        holder.txtPhone.setText(branchList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return branchList.size();
    }
}
