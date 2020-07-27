package com.example.vendor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class MenuChangeRequest extends AppCompatActivity {

    Button Submit, ViewRequestList;
    TextView reason,newmenu;
    FirebaseFirestore firestore;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_change_request);
        reason=findViewById(R.id.Reason);
        newmenu=findViewById(R.id.newmenu);
        Submit = findViewById(R.id.cancel_order_request_submit);
        ViewRequestList = findViewById(R.id.cancel_order_request_viewlist);
        firestore= FirebaseFirestore.getInstance();




        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MenuChangeRequest.this, "Submitted!!", Toast.LENGTH_SHORT).show();
            }
        });

        ViewRequestList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuChangeRequest.this,MenuRequestDetails.class);
                startActivity(intent);

            }
        });
    }
}