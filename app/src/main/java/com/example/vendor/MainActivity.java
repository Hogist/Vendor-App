package com.example.vendor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    Button bt;
    EditText VEmailAddress, Vpassword;
    TextView forgot;
    FirebaseFirestore fstore;
    FirebaseAuth fAuth;
    String LoginVendor;
    @ServerTimestamp
    Date Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.button);
        VEmailAddress = findViewById(R.id.email);
        Vpassword = findViewById(R.id.Password);
        forgot = findViewById(R.id.forgot);
        fstore = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String vemailaddress =VEmailAddress .getText().toString().trim();
                final String  VPassword=Vpassword.getText().toString().trim();
                if (TextUtils.isEmpty(vemailaddress)) {
                    VEmailAddress.setError("Email is required.");
                    return;

                }
                if (TextUtils.isEmpty(VPassword)) {
                    Vpassword.setError("password is required.");
                    return;

                }


                fAuth.signInWithEmailAndPassword(vemailaddress,VPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "User logined", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(i);
                            LoginVendor = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("Vendor").document(LoginVendor);
                            final Map<String, Object> Lvendor = new HashMap<>();
                            Lvendor.put("CreatedDate", FieldValue.serverTimestamp());
                            Lvendor.put("VEmailAddress", vemailaddress);
                            Lvendor.put("Vpassword", VPassword);
                            documentReference.set(Lvendor).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG, "onsucess: user profile is logined for" + LoginVendor);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onFailure:" + e.toString());
                                }
                            });
                        } else {
                            Toast.makeText(MainActivity.this, "Error!!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });

    }


}