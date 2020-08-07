package com.example.vendor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Orderdetails extends AppCompatActivity {
    ImageView i1;
    TextView Orderid,Quantity,Totalorderprise,enterprisename,BreakfastItemList,lunchitemlist,dinneritemlist,snacksitemlist,createddatetime,deliveryaddress,orderstatus;
    Button submit,view;
    String OrderDetails;
    @ServerTimestamp
    Date Time;
    private String orderid;
    private String quantity;
    private String Enterprisename;
    private String Orderstatus;
    private String breakfastitemlist;
    private String LunchItemList;
    private String SnacksItemList;
    private String CreateddateTime;
    private String TotalOrderPrice;
    private String DinnerItemList;
    private String DeliveryAddress;

    private List<String> Orderdetails = new ArrayList<>();
    FirebaseFirestore firestore;


      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderid=getIntent().getStringExtra("orderid");
        quantity=getIntent().getStringExtra("quantity");
        Enterprisename=getIntent().getStringExtra("enterprisename");
        Orderstatus=getIntent().getStringExtra("orderstatus");
        breakfastitemlist=getIntent().getStringExtra("BreakfastItemList");
        LunchItemList=getIntent().getStringExtra("LunchItemList");
        SnacksItemList=getIntent().getStringExtra("SnacksItemList");
        CreateddateTime=getIntent().getStringExtra("CreateddateTime");
        TotalOrderPrice=getIntent().getStringExtra("TotalOrderPrice");
        DinnerItemList=getIntent().getStringExtra("DinnerItemList");
        DeliveryAddress=getIntent().getStringExtra("DeliveryAddress");




        setContentView(R.layout.activity_orderdetails);
        i1=findViewById(R.id.imageback5);
        Orderid=findViewById(R.id.textView4);
        Quantity=findViewById(R.id.textView5);
        view=findViewById(R.id.order_now_vieworderlist);
        Totalorderprise=findViewById(R.id.textView6);
        enterprisename=findViewById(R.id.textView7);
        BreakfastItemList=findViewById(R.id.textView8);
        lunchitemlist=findViewById(R.id.textView9);
        dinneritemlist=findViewById(R.id.textView10);
        snacksitemlist=findViewById(R.id.textView11);
        createddatetime=findViewById(R.id.textView12);
        deliveryaddress=findViewById(R.id.textView13);
        orderstatus=findViewById(R.id.textView14);

        firestore = FirebaseFirestore.getInstance();






        submit=findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(com.example.vendor.Orderdetails.this, "Sucessfull", Toast.LENGTH_SHORT).show();
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(com.example.vendor.Orderdetails.this, MainActivity2.class);
                startActivity(i);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(com.example.vendor.Orderdetails.this, OrderList.class);
                startActivity(i);
            }
        });


    }
}