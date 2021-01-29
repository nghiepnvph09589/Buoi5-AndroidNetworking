package com.example.buoi5.lab3retrofit;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadData {
    private static List<Contact> data;
    public static String jSONStr = null;
    public List<Contact> loadJSON(TextView textView){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://batdongsanabc.000webhostapp.com/mob403lab3/").addConverterFactory(GsonConverterFactory.create()).build();
        RequestRe requestRe = retrofit.create(RequestRe.class);
        Call<ListContact> call = requestRe.getJSON();
        call.enqueue(new Callback<ListContact>() {
            @Override
            public void onResponse(Call<ListContact> call, Response<ListContact> response) {
                ListContact jsonReponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonReponse.getContact()));
                for (Contact c: data)
                {
                    jSONStr += "Name: " +c.getName() +"\n\n";
                    jSONStr += "Email: " +c.getEmail() +"\n\n";
                    jSONStr += "Mobile: " +c.getMobile() +"\n\n";
                }
                textView.setText(jSONStr);
            }

            @Override
            public void onFailure(Call<ListContact> call, Throwable t) {
                Log.e("Error", t.getMessage());
//                textView.setText(textView);
            }
        });
        return data;
    }
}
