package com.example.testforvrgsoft.network;

import com.example.testforvrgsoft.models.Publications;
import com.example.testforvrgsoft.models.TopResponse;

import io.reactivex.Observable;

import retrofit2.http.GET;

public interface Api {
    @GET("top.json")
    Observable<TopResponse> getPub();
}
