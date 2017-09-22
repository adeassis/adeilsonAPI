package com.example.adeilsonassis.processoseletivo.Interfaces;

import com.example.adeilsonassis.processoseletivo.Model.Shot;
import com.example.adeilsonassis.processoseletivo.Model.ShotCatalog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by adeilson.assis on 21/09/2017.
 */

public interface ShotsService
{
    @GET("shots?page=1&per_page=30&access_token=b3e6433f6fd566e4187221023e988abf8a9194d0175ef12be80fd2474a1b3750")
    Call<List<Shot>> listaShots();


}
