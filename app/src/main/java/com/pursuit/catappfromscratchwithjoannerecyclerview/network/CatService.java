package com.pursuit.catappfromscratchwithjoannerecyclerview.network;

import com.pursuit.catappfromscratchwithjoannerecyclerview.CatPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CatService {
@GET("v1/images/search")
    Call<List<CatPojo>> getBreeds();
}
