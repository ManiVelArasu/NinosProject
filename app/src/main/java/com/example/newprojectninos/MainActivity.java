package com.example.newprojectninos;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMovies;
    private List<Avenger> imageLists;
    private CustomAdapter adapter;
    private ProgressBar load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvMovies = (RecyclerView) findViewById(R.id.rvmovies);
        NestedScrollView nestedSV = findViewById(R.id.NestedSV);
        load = findViewById(R.id.load);
        load.setVisibility(View.VISIBLE);
       /* rvmovies.setHasFixedSize(true);
        rvmovies.setLayoutManager(new LinearLayoutManager(this));*/

        ApiInterface apiInterface = APIClient.getRetrofit().create(ApiInterface.class);
        Call<List<Avenger>> call = apiInterface.getAvenger();
        call.enqueue(new Callback<List<Avenger>>() {
            @Override
            public void onResponse(Call<List<Avenger>> call, Response<List<Avenger>> response) {
                load.setVisibility(View.GONE);
                imageLists = response.body();
                adapter = new CustomAdapter(imageLists, MainActivity.this);
                rvMovies.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Avenger>> call, Throwable t) {
                load.setVisibility(View.GONE);
            }
        });
    }
}
