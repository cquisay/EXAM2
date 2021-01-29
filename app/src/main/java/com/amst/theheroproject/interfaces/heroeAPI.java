package com.amst.theheroproject.interfaces;

import com.amst.theheroproject.heroes.heroe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface heroeAPI {
    @GET("api/3868643479833025/{id}")
    public Call<heroe> find(@Path("id") String id);




}
