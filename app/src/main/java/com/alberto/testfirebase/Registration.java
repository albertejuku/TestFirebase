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

public class Registration extends AppCompatActivity {

    EditText password, confirmPasswor, email;
    Button btnRegister, btnLoginActivity;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPasswor = findViewById(R.id.passwordConfirm);
        btnRegister = findViewById(R.id.btnSignUp);
        btnLoginActivity = findViewById(R.id.btnLoginActivity);

        btnLoginActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, Login.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail = email.getText().toString();
                String pass = password.getText().toString();
                String pass1 = confirmPasswor.getText().toString();

                if(mail.equals("") || pass.equals("") || pass1.equals("")){
                    Toast.makeText(Registration.this, "Your cannot leave any field blank", Toast.LENGTH_SHORT).show();
                }else if(!pass1.equals(pass)){
                    Toast.makeText(Registration.this, "The two passwords must match", Toast.LENGTH_SHORT).show();
                }else{

                    mAuth.createUserWithEmailAndPassword(mail, pass).
                            addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Registration.this, "Success, You can now Login", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Registration.this, Login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Registration.this, "Unsuccessful, try again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}