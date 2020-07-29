package com.example.vendor;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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

public class CancelOrderDetails extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    protected RecyclerView.LayoutManager layoutManager;
    private FirebaseFirestore firestore;
    private static RecyclerView recyclerView;
    private static ArrayList<MenuChangeRequestDataModel> data3;
    static View.OnClickListener myOnclickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancelrequest);

        firestore= FirebaseFirestore.getInstance();



        myOnclickListener= new MyOnClickListener(this);

        recyclerView = (RecyclerView)findViewById(R.id.cancel_request_recyclerview);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        data3 = new ArrayList<MenuChangeRequestDataModel>();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        firestore.collection("CancelOrderRequest")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for(DocumentSnapshot q:task.getResult()){
                            MenuChangeRequestDataModel M=new MenuChangeRequestDataModel(String.valueOf(q.getDouble("CancelOrderRequestID")),
                                    String.valueOf(q.getDouble("EUserID")),
                                    String.valueOf(q.getBoolean("NextMeal")),
                                    q.getString("Reason"),
                                    String.valueOf(q.getDouble("VUserID")));
                            data3.add(M);
                        }
                    }
                });
        adapter = new MenuChangeRequestAdapter(data3);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        firestore.collection("CancelOrderRequest").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if(error!=null){
                    return;
                }

                for(QueryDocumentSnapshot q:value) {
                    MenuChangeRequestDataModel M=new MenuChangeRequestDataModel(String.valueOf(q.getDouble("CancelOrderRequestID")),
                            String.valueOf(q.getDouble("EUserID")),
                            String.valueOf(q.getBoolean("NextMeal")),
                            q.getString("Reason"),
                            String.valueOf(q.getDouble("VUserID")));
                    data3.add(M);
                    adapter = new MenuChangeRequestAdapter(data3);
                    recyclerView.setAdapter(adapter);
                }
            }
        });
    }

    static class MyOnClickListener implements View.OnClickListener{
        private final Context context;
        MyOnClickListener(Context context){
            this.context = context;
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(context, "item Clicked!!", Toast.LENGTH_SHORT).show();
        }
    }
}