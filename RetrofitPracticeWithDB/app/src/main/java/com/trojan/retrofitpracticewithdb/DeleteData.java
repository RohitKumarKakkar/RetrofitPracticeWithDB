package com.trojan.retrofitpracticewithdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.trojan.retrofitpracticewithdb.RetrofitEssentials.ApiClient;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeleteData extends AppCompatActivity {
    EditText edtid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        edtid = findViewById(R.id.edtdelid);
        Button btnDelete = findViewById(R.id.btnDeleteDataFromDB);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteDataFromDb();
            }
        });
    }

    private void DeleteDataFromDb() {
        String id = edtid.getText().toString().trim();

        Call<ResponseBody> call = ApiClient.getInstance().getApi().deleteUserData(id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Toast.makeText(DeleteData.this, "Data Delete Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(DeleteData.this, "Failed to Delete Data", Toast.LENGTH_SHORT).show();
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