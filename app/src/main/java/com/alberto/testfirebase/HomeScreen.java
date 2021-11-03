package com.alberto.testfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class HomeScreen extends AppCompatActivity {

    Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btnLogOut = findViewById(R.id.btnLogOut);

        btnLogOut.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(HomeScreen.this, "You have signed out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeScreen.this, Login.class);
                startActivity(intent);
            }
        });
    }
}