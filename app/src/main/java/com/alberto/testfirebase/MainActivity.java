package com.alberto.testfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Animation animation;
    TextView txtView;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txtView = findViewById(R.id.welcome_text);
        animation = AnimationUtils.loadAnimation(this, R.anim.fade_animation);
        txtView.setAnimation(animation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(currentUser == null){
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                    finish();
                }else{
                    Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, 5000);
    }

}