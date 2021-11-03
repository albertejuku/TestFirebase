package com.alberto.testfirebase;

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

public class Login extends AppCompatActivity {

    EditText email, password;
    Button login, regActivity;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);
        login = findViewById(R.id.btnLogin);
        regActivity = findViewById(R.id.btnRegisterActivity);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                oerfags


                String mail = email.getText().toString();
                String pass = password.getText().toString();

                if(mail.equals("") || pass.equals("")){
                    Toast.makeText(Login.this, "Your cannot leave any field blank", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.signInWithEmailAndPassword(mail, pass).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Login.this, "success", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(Login.this, HomeScreen.class);
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(Login.this, "Unsuccessful, try again", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }



//                asdasdgas



            }
        });

        regActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
            }
        });
    }
}