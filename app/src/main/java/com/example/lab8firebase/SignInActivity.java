package com.example.lab8firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    EditText edtemailsignin , edtpasssinin ;

    Button btnsignin ;
    TextView txtdangki  , txtforgotpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        edtemailsignin = findViewById(R.id.edtemailsignin) ;
        edtpasssinin = findViewById(R.id.edtpasssingin) ;
        btnsignin = findViewById(R.id.btnsingin)  ;
        txtforgotpass = findViewById(R.id.forgotpass);
        txtdangki = findViewById(R.id.txtdangki) ;

        txtforgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(SignInActivity.this , Forgotpasss.class);
               startActivity(intent);
            }
        });
        txtdangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SignInActivity.this , SignUpActivity.class);
                startActivity(intent);
            }
        });
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangnhap();
            }
        });
    }
    private void dangnhap(){
        String emai = edtemailsignin.getText().toString().trim();
        String pass = edtpasssinin.getText().toString().trim() ;
        Toast.makeText(this, emai+pass, Toast.LENGTH_SHORT).show();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(emai  , pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignInActivity.this, task+"", Toast.LENGTH_SHORT).show();
                        if(task.isSuccessful()){
                            Intent intent = new Intent(SignInActivity.this , MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(SignInActivity.this, "đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}