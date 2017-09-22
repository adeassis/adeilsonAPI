package com.example.adeilsonassis.processoseletivo;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.adeilsonassis.processoseletivo.Events.ShotEvent;
import com.example.adeilsonassis.processoseletivo.Fragments.DetalheShotFragment;
import com.example.adeilsonassis.processoseletivo.Fragments.ListaShotsFragment;
import com.example.adeilsonassis.processoseletivo.Interfaces.ShotDelegate;
import com.example.adeilsonassis.processoseletivo.Interfaces.ShotsService;
import com.example.adeilsonassis.processoseletivo.Model.Shot;
import com.example.adeilsonassis.processoseletivo.Model.ShotCatalog;
import com.example.adeilsonassis.processoseletivo.Model.ShotDes;
import com.example.adeilsonassis.processoseletivo.WebService.WebClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ShotDelegate
{
    ListaShotsFragment listaShotsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        listaShotsFragment = new ListaShotsFragment();
        transaction.replace(R.id.frame_principal, listaShotsFragment);
        transaction.commit();

        new WebClient().getShots();
    }

    @Override
    public void lidaComItemSelecionado(Shot shot)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        DetalheShotFragment detalheShotFragment = criaShotCom(shot);
        transaction.replace(R.id.frame_principal, detalheShotFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private DetalheShotFragment criaShotCom(Shot shot)
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable("shot", shot);
        DetalheShotFragment detalheShotFragment = new DetalheShotFragment();
        detalheShotFragment.setArguments(bundle);
        return detalheShotFragment;
    }

    @Subscribe
    public void lidaComSucesso(ShotEvent event)
    {
        listaShotsFragment.populaListaCom(event.getShots());
    }

    @Subscribe
    public void lidaComErro(Throwable t)
    {
        Toast.makeText(this, "Não foi possível carregar os shots... "+t.toString() ,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}
