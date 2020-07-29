package com.example.vendor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class OrderlistAdapter extends RecyclerView.Adapter<OrderlistAdapter.MyViewHolder> {

   private ArrayList<OrderListDataModel> dataModels;

    public OrderlistAdapter(ArrayList<OrderListDataModel> data) {
        this.dataModels = data;
    }

    @NonNull
    @Override
    public OrderlistAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_cardview,parent,false);
       view.setOnClickListener(OrderList.myOnclickListener);
       MyViewHolder myViewHolder = new MyViewHolder(view);
       return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull OrderlistAdapter.MyViewHolder holder, int position) {
        TextView OrderID = holder.OrderID;
        TextView VendorName=holder.VendorName;
        TextView Quantity= holder.Quantity;
        TextView OrderStatus= holder.OrderStatus;

        OrderID.setText(dataModels.get(position).getOrderID());
        VendorName.setText(dataModels.get(position).getVendorName());
        Quantity.setText(dataModels.get(position).getQuantity());
        OrderStatus.setText(dataModels.get(position).getOrderStatus());

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView OrderID, VendorName, Quantity, OrderStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.OrderID = (TextView)itemView.findViewById(R.id.order_list_orderid);
            this.VendorName = (TextView)itemView.findViewById(R.id.order_list_vendorname);
            this.Quantity = (TextView)itemView.findViewById(R.id.order_list_orderid);
            this.OrderStatus =(TextView)itemView.findViewById(R.id.order_list_orderstatus);

        }
    }

}
