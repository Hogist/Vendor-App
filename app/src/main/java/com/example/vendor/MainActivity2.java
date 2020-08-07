package com.example.vendor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
ImageView logout;
CardView c1,c2,c3,c4,c5,c6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        logout=findViewById(R.id.logout);
        c1=findViewById(R.id.cardview1);
        c3=findViewById(R.id.cardview);
        c2=findViewById(R.id.cardview2);
        c4=findViewById(R.id.cardview4);
        c5=findViewById(R.id.cardview6);
        c6=findViewById(R.id.cardview5);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity2.this)
                        .setTitle("Exit")
                        .setMessage("Do you want to exit")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(MainActivity2.this,MainActivity.class));
                                finish();
                            }
                        })
                        .setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create()
                        .show();

            }
        });


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,Covidhygenic.class);
                startActivity(i);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,Useraccount.class);
                startActivity(i);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,OrderList.class);
                startActivity(i);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,Menudetails.class);
                startActivity(i);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,MenuChangeRequest.class);
                startActivity(i);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this,CancelOrderDetails.class);
                startActivity(i);
            }
        });
    }
}