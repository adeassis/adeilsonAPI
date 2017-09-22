package com.example.adeilsonassis.processoseletivo.WebService;

import com.example.adeilsonassis.processoseletivo.Events.ShotEvent;
import com.example.adeilsonassis.processoseletivo.Interfaces.ShotsService;
import com.example.adeilsonassis.processoseletivo.Model.Shot;
import com.example.adeilsonassis.processoseletivo.Model.ShotCatalog;
import com.example.adeilsonassis.processoseletivo.Model.ShotDes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adeilson.assis on 21/09/2017.
 */

public class WebClient
{
    private static final String SERVER_URL = "https://api.dribbble.com/v1/";
    private List<ShotCatalog> shots;

    public void getShots()
    {
        Gson g = new GsonBuilder().registerTypeAdapter(Shot.class,new ShotDes()).create();

        Retrofit client = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create(g))
                .build();

        ShotsService service = client.create(ShotsService.class);

        Call<List<Shot>> call = service.listaShots();

        call.enqueue(new Callback<List<Shot>>()
        {
            @Override
            public void onResponse(Call<List<Shot>> call, Response<List<Shot>> response)
            {
                if(response.isSuccessful())
                {
                    EventBus.getDefault().post(new ShotEvent(response.body()));
                }

            }

            @Override
            public void onFailure(Call<List<Shot>> call, Throwable t)
            {
                EventBus.getDefault().post(t);
            }
        });

    }


}
