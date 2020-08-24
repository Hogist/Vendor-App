package com.example.vendor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrderlistAdapter extends RecyclerView.Adapter<OrderlistAdapter.MyViewHolder> {

    OrderListDataModel[] orderListDataModels;
    Context context;

    private List<OrderList> mOrders;



    private ArrayList<OrderListDataModel> dataModels;

    public OrderlistAdapter(ArrayList<OrderListDataModel> data, Context context) {
        this.dataModels = data;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderlistAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_list_cardview, parent, false);
        view.setOnClickListener(OrderList.myOnclickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }




    @Override
    public void onBindViewHolder(@NonNull OrderlistAdapter.MyViewHolder holder, int position) {
        TextView OrderID = holder.OrderID;
        TextView EnterpriseName = holder.EnterpriseName;
        TextView Quantity = holder.Quantity;
        TextView TotalOrderPrice=holder.TotalOrderPrice;

        OrderID.setText("Order ID: "+dataModels.get(position).getOrderID());
        EnterpriseName.setText("EnterpriseName: "+dataModels.get(position).getEnterpriseName());
        Quantity.setText("Quantity: "+dataModels.get(position).getQuantity());
        TotalOrderPrice.setText("TotalOrderPrice: "+dataModels.get(position).getTotalOrderPrise());

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView OrderID, EnterpriseName, Quantity, TotalOrderPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.OrderID = (TextView) itemView.findViewById(R.id.order_list_orderid);
            this.EnterpriseName = (TextView) itemView.findViewById(R.id.order_list_Enterprisename);
            this.Quantity = (TextView) itemView.findViewById(R.id.order_list_quantity);
            this.TotalOrderPrice=(TextView)itemView.findViewById(R.id.order_list_orderprise);



        }
    }

}
