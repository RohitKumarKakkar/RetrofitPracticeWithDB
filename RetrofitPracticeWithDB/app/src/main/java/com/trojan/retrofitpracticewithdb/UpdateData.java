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

public class UpdateData extends AppCompatActivity {

    EditText etname, etemail, etpassword, etphone, etdob,etid;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_data);

        etname = findViewById(R.id.edtupname);
        etemail = findViewById(R.id.edtupmail);
        etpassword = findViewById(R.id.edtuppassword);
        etphone = findViewById(R.id.edtupphone);
        etdob = findViewById(R.id.edtupdob);
        etid=findViewById(R.id.edtupid);

        btnUpdate=findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateDataToDB();
            }
        });
    }

    private void UpdateDataToDB() {
        String name = etname.getText().toString();
        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();
        String phone = etphone.getText().toString();
        String dob = etdob.getText().toString();
        String id = etid.getText().toString();

        if (dob.isEmpty()) {
            Toast.makeText(UpdateData.this, "Enter Valid Date", Toast.LENGTH_SHORT).show();
            return;
        }

        if (phone.isEmpty() || phone.length() > 10) {
            Toast.makeText(UpdateData.this, "Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.isEmpty() || password.length() < 7) {
            Toast.makeText(UpdateData.this, "Password Must Contain Minimum 7 Letters", Toast.LENGTH_SHORT).show();
            return;
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(UpdateData.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (name.isEmpty()) {
            Toast.makeText(UpdateData.this, "Please Enter a Name", Toast.LENGTH_SHORT).show();
            return;
        }

        Call<ResponseBody> call = ApiClient.getInstance().getApi().updateUserData(id,name, email, password, phone, dob);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(UpdateData.this, "Data Insertion Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(UpdateData.this, "Failed to Insert Data", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}