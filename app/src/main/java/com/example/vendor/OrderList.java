package com.example.vendor;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OrderList extends AppCompatActivity {


    private static RecyclerView.Adapter adapter;
    protected RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private FirebaseFirestore firestore;
    private static ArrayList<OrderListDataModel> data;
    FirebaseUser user;
    FirebaseAuth mAuth;
    String email;

    static View.OnClickListener myOnclickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        firestore= FirebaseFirestore.getInstance();
        user=mAuth.getInstance().getCurrentUser();

        if(user!=null)
        {
            email=user.getEmail();
        }

        myOnclickListener = new MyOnClickListener(this);
        recyclerView = (RecyclerView)findViewById(R.id.orderlist_recyclerview);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());




        data = new ArrayList<OrderListDataModel>();



        firestore.collection("OrderDetails")
                .whereEqualTo("VEmail",email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot q:task.getResult()){
                            OrderListDataModel M=new OrderListDataModel(String.valueOf(q.getDouble("OrderID")),
                                    q.getString("ECompanyName"),
                                    q.getString("Quantity"),
                                    q.getString("OrderStatus"));
                            data.add(M);
                        }
                    }
                });

        adapter = new OrderlistAdapter(data);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        firestore.collection("OrderDetails").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error!=null){
                    return;
                }

                for(QueryDocumentSnapshot q:value) {
                    OrderListDataModel M=new OrderListDataModel(String.valueOf(q.getDouble("OrderID")),
                            q.getString("ECompanyName"),
                            q.getString("Quantity"),
                            q.getString("OrderStatus"));
                    data.add(M);

                    adapter = new OrderlistAdapter(data);
                    recyclerView.setAdapter(adapter);
                }
            }
        });
    }

    static class MyOnClickListener implements View.OnClickListener{
        private final Context context;

        public MyOnClickListener(Context context) {
            this.context = context;
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(context, "Item Clicked!!", Toast.LENGTH_SHORT).show();
        }
    }

}