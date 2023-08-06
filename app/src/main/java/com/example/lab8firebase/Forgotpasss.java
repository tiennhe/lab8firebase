package com.example.lab8firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Forgotpasss extends AppCompatActivity {
    EditText edtemailforgot ;
    Button btnforgot ;
    TextView txtback ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpasss);
        edtemailforgot = findViewById(R.id.edtemailresetpass) ;
        btnforgot = findViewById(R.id.btnresetpass) ;
        btnforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendpass();
            }


        });

        txtback = findViewById(R.id.txtquaylai) ;
        txtback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    private void sendpass() {
        FirebaseAuth auth= FirebaseAuth.getInstance();
        String userupdate = edtemailforgot.getText().toString().trim();

        auth.sendPasswordResetEmail(userupdate)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Forgotpasss.this, "send sucsessfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}