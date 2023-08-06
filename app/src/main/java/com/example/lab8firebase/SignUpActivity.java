package com.example.lab8firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    EditText edtemailsinup , edtpassSignup ;
    Button btnsingup ;
    private FirebaseAuth mAuth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtemailsinup = findViewById(R.id.edtemailsignup);
        edtpassSignup = findViewById(R.id.edtpasssingup);
        btnsingup = findViewById(R.id.btnsingup);

        btnsingup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SignUpActivity.this, "dăng kí", Toast.LENGTH_SHORT).show();
            dangki("vào hàm dangki");
            }
        });
    }
    private void dangki(String mess){

        String email = edtemailsinup.getText().toString().trim() ;
        String pass = edtpassSignup.getText().toString().trim() ;
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignUpActivity.this, mess, Toast.LENGTH_SHORT).show();
                        if (task.isSuccessful()) {

                            Intent inten = new Intent(SignUpActivity.this , SignInActivity.class);
                            startActivity(inten);
                        } else {
                            String errorMessage = task.getException().getMessage();
                            Toast.makeText(SignUpActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}