package com.pursuit.catappfromscratchwithjoannerecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.pursuit.catappfromscratchwithjoannerecyclerview.controller.CatAdapter;
import com.pursuit.catappfromscratchwithjoannerecyclerview.network.CatService;
import com.pursuit.catappfromscratchwithjoannerecyclerview.network.RetrofitSingleton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CatAdapter catAdapter;
    CatService catService;
    List<CatPojo> breedsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.cat_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(catAdapter);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        catService = retrofit.create(CatService.class);
        //Call<CatPojo> call = retrofit.create(CatService.class).getBreeds();
        Call<List<CatPojo>> catCall = catService.getBreeds();
        catCall.enqueue(new Callback<List<CatPojo>>() {
            @Override
            public void onResponse(Call<List<CatPojo>> call, Response<List<CatPojo>> response) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                String[] catBreeds = response.body().get(0).getBreeds();
                CatPojo catPojo = new CatPojo();
                catPojo.setBreeds(catBreeds);
                breedsList.add(catPojo);
                Log.d("lindaresult", "yay");
            }

            @Override
            public void onFailure(Call<List<CatPojo>> call, Throwable t) {
                Log.d("lindaresult", "nay");
            }
        });
//        catCall.enqueue(new Callback<CatPojo>() {
//            @Override
//            public void onResponse(Call<CatPojo> call, Response<CatPojo> response) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                String[] catBreeds = response.body().getBreeds();
//                CatPojo catPojo = new CatPojo();
//                catPojo.setBreeds(catBreeds);
//                breedsList.add(catPojo);
//
//                Log.d("lindaresult", "yay");
//                //response.body().getBreeds().toString();
//                //Picasso.get().load().getUrl()).into();
//            }
//
//            @Override
//            public void onFailure(Call<CatPojo> call, Throwable t) {
//                Log.d("lindaresult", t.toString());
//
//            }
//        });

        catAdapter = new CatAdapter(breedsList);

    }
}
