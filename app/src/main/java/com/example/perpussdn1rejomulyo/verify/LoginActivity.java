package com.example.perpussdn1rejomulyo.verify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.example.perpussdn1rejomulyo.MainActivity;
import com.example.perpussdn1rejomulyo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText edtMail, edtPassword;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener authStateListener;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtMail = findViewById(R.id.email);
        edtPassword = findViewById(R.id.password);
        
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.btnlogin).setOnClickListener(v -> loginUser());

        firebaseAuth();
    }

    private void firebaseAuth() {
        authStateListener = firebaseAuth -> {
            FirebaseUser mUser = firebaseAuth.getCurrentUser();

            if (mUser != null){
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        };


    }

    private void loginUser() {
        String mail, pw;

        mail = edtMail.getText().toString();
        pw = edtPassword.getText().toString();

        if (TextUtils.isEmpty(mail) || TextUtils.isEmpty(pw)){
            Toast.makeText(this, "Email atau password tidak boleh kosong", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(mail,pw).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this,RegisterActivity.class));
            } else {
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authStateListener);
    }
}