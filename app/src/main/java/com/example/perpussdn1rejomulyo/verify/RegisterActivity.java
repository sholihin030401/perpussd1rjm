package com.example.perpussdn1rejomulyo.verify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.chivorn.smartmaterialspinner.SmartMaterialSpinner;
import com.example.perpussdn1rejomulyo.R;
import com.example.perpussdn1rejomulyo.UserHelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText namaUser, tglahirUser, asalsklUser;
    SmartMaterialSpinner<String> spJK, spUser;
    List<String> listJK, listUser;
    String name, datebirth, sch, gender, type_user;

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        namaUser = findViewById(R.id.namalengkap);
        tglahirUser = findViewById(R.id.tgllahir);
        asalsklUser = findViewById(R.id.asal_sklh);

        spJK = findViewById(R.id.jk);
        listJK = new ArrayList<>();
        listJK.add("Laki-laki");
        listJK.add("Perempuan");
        spJK.setItem(listJK);

        spUser = findViewById(R.id.user_tipe);
        listUser = new ArrayList<>();
        listUser.add("Siswa");
        listUser.add("Guru");
        spUser.setItem(listUser);

        findViewById(R.id.btndaftar).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        name = namaUser.getText().toString();
        datebirth = tglahirUser.getText().toString();
        sch = asalsklUser.getText().toString();
        gender = spJK.getSelectedItem().toString();
        type_user = spUser.getSelectedItem().toString();

        UserHelper helper = new UserHelper(name,datebirth,sch,gender,type_user);

        reference.child(name).setValue(helper);
    }
}