package com.example.adeilsonassis.processoseletivo.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.adeilsonassis.processoseletivo.Adapter.ShotAdapter;
import com.example.adeilsonassis.processoseletivo.Model.Shot;

import com.example.adeilsonassis.processoseletivo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ListaShotsFragment extends Fragment
{

    @BindView(R.id.lista_shots)
    RecyclerView recycler;

    private List<Shot> shots = new ArrayList<>();

    public ListaShotsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_shots, container, false);

        ButterKnife.bind(this, view);

        LinearLayoutManager manager = new LinearLayoutManager(container.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(new ShotAdapter(getActivity(), shots));

        return view;
    }

    public void populaListaCom(List<Shot> shots)
    {
        this.shots.clear();
        this.shots.addAll(shots);
        recycler.getAdapter().notifyDataSetChanged();
    }


}
