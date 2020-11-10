package com.trojan.retrofitpracticewithdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.trojan.retrofitpracticewithdb.Adapter.UserAdapter;
import com.trojan.retrofitpracticewithdb.RetrofitEssentials.ApiClient;
import com.trojan.retrofitpracticewithdb.RetrofitEssentials.UserData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetriveData extends AppCompatActivity {
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    List<UserData> userData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_data);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        LoadData();
    }

    private void LoadData() {
        Call<List<UserData>> call = ApiClient.getInstance().getApi().getUserData();
        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                Toast.makeText(RetriveData.this, "Data Retrive Success", Toast.LENGTH_SHORT).show();
                userData = response.body();
                userAdapter = new UserAdapter(RetriveData.this,userData);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                Toast.makeText(RetriveData.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Log.w("RetriveData.java",t.getLocalizedMessage());
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
