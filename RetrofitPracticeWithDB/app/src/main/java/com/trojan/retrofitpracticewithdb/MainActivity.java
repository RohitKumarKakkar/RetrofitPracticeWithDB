package com.trojan.retrofitpracticewithdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trojan.retrofitpracticewithdb.RetrofitEssentials.ApiClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText etname, etemail, etpassword, etphone, etdob;
    Button btnInsert, btnRetrieve,btnUpdateData,btnDeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.edtname);
        etemail = findViewById(R.id.edtmail);
        etpassword = findViewById(R.id.edtpassword);
        etphone = findViewById(R.id.edtphone);
        etdob = findViewById(R.id.edtdob);


        btnInsert = findViewById(R.id.btnInsert);
        btnRetrieve = findViewById(R.id.btnRetrieve);
        btnUpdateData = findViewById(R.id.btnUpdateData);
        btnDeleteData = findViewById(R.id.btnDeleteData);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateData();
            }
        });

        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RetriveData.class);
                startActivity(i);
            }
        });

        btnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,UpdateData.class);
                startActivity(i);
            }
        });

        btnDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,DeleteData.class);
                startActivity(i);
            }
        });

    }

    public void ValidateData() {
        String name = etname.getText().toString();
        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();
        String phone = etphone.getText().toString();
        String dob = etdob.getText().toString();

        if (dob.isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter Valid Date", Toast.LENGTH_SHORT).show();
            return;
        }

        if (phone.isEmpty() || phone.length() > 10) {
            Toast.makeText(MainActivity.this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty() || password.length() < 7) {
            Toast.makeText(MainActivity.this, "Password Must Contain Minimum 7 Letters", Toast.LENGTH_SHORT).show();
            return;
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(MainActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (name.isEmpty()) {
            Toast.makeText(MainActivity.this, "Please Enter a Name", Toast.LENGTH_SHORT).show();
            return;
        }

        Call<ResponseBody> call = ApiClient.getInstance().getApi().saveUserData(name, email, password, phone, dob);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(MainActivity.this, "Data Insertion Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to Insert Data", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
