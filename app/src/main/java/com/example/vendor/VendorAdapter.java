package com.example.vendor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VendorAdapter extends RecyclerView.Adapter<VendorAdapter.MyViewHolder> {

    private ArrayList<VendorDataModel> dataModels;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView vendorId, vendorFullName, companyName, enterpriseId, enterpriseName, menuId;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.vendorId = (TextView)itemView.findViewById(R.id.vendor_details_vendorId);
            this.vendorFullName = (TextView)itemView.findViewById(R.id.vendor_details_venforfullname);
            this.companyName = (TextView)itemView.findViewById(R.id.vendor_details_companyname);
            this.enterpriseId = (TextView)itemView.findViewById(R.id.vendor_details_enterpriseid);
            this.enterpriseName = (TextView)itemView.findViewById(R.id.vendor_details_enterprisename);
            this.menuId = (TextView)itemView.findViewById(R.id.vendor_details_menuid);

        }
    }

    public VendorAdapter(ArrayList<VendorDataModel> data){
        this.dataModels = data;
    }


    @NonNull
    @Override
    public VendorAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vendordetails_cardview,parent,false);
        view.setOnClickListener(Menudetails.myOnclickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VendorAdapter.MyViewHolder holder, int position) {
        TextView VendorID = holder.vendorId;
        TextView VendorFullName = holder.vendorFullName;
        TextView CompanyName = holder.companyName;
        TextView EnterpriseID = holder.enterpriseId;
        TextView EnterpriseName = holder.enterpriseName;
        TextView MenuID = holder.menuId;

        VendorID.setText(dataModels.get(position).getVendorID());
        VendorFullName.setText(dataModels.get(position).getVendorFullName());
        CompanyName.setText(dataModels.get(position).getCompanyName());
        EnterpriseID.setText(dataModels.get(position).getEnterpriseID());
        EnterpriseName.setText(dataModels.get(position).getEnterpriseName());
        MenuID.setText(dataModels.get(position).getMenuId());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }
}
