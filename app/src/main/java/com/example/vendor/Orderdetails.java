package com.example.vendor;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Orderdetails extends AppCompatActivity {
ImageView i1;
TextView Orderid,Quantity,Totalorderprise,enterprisename,BreakfastItemList,lunchitemlist,dinneritemlist,snacksitemlist,createddatetime,deliveryaddress,orderstatus;
Button submit,view;
String OrderDetails;
    @ServerTimestamp
    Date Time;

private List<String> Orderdetails = new ArrayList<>();
FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                Toast.makeText(Orderdetails.this, "Sucessfull", Toast.LENGTH_SHORT).show();
            }
        });
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Orderdetails.this,MainActivity2.class);
                startActivity(i);
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Orderdetails.this,OrderList.class);
                startActivity(i);
            }
        });


    }
}