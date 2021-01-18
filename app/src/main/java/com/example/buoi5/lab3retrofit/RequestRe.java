package com.example.buoi5.lab3retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestRe {
    @GET("json_data.json")
    Call<ListContact> getJSON();
}
