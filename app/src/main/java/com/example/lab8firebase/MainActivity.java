package com.example.lab8firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
        TextView txtinfor ;
        Button btnsignout;
        Toolbar toolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtinfor = findViewById(R.id.txtinfor);

        toolbar = findViewById(R.id.toobar) ;
        setSupportActionBar(toolbar);


        FirebaseUser user  = FirebaseAuth.getInstance().getCurrentUser() ;
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String emai = user.getEmail();
            txtinfor.setText(  "Hello: " + emai);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutoolbar , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId() ;



        if(id==R.id.changemail){
            Toast.makeText(this, "email", Toast.LENGTH_SHORT).show();
        }   if(id==R.id.changepass){
            Toast.makeText(this, "pass", Toast.LENGTH_SHORT).show();
        }
         if(id==R.id.deleteacount){
            Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
        }

         if(id == R.id.updatemail){
        Dialog dialog  = new Dialog(MainActivity.this) ;
        dialog.setContentView(R.layout.dilog_updateuser);
        dialog.show();
         }
         if(id==R.id.logout){
             FirebaseAuth.getInstance().signOut();
             Intent intent = new Intent(MainActivity.this , SignInActivity.class) ;
             startActivity(intent);
             finish();
        }
        return true;


    }
}