package com.example.retrofitapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
//checking -->
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<RetrofitData> data;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this );
        recyclerView.setLayoutManager(layoutManager);



        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        Call<List<RetrofitData>> call = retrofitAPI.getData();
        call.enqueue(new Callback<List<RetrofitData>>() {
            @Override
            public void onResponse(Call<List<RetrofitData>> call, Response<List<RetrofitData>> response) {

                data = response.body();
                adapter = new RecyclerAdapter(data);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(Call<List<RetrofitData>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "There is an error ",Toast.LENGTH_SHORT).show();


            }
        });

    }
}