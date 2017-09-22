package com.example.adeilsonassis.processoseletivo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adeilsonassis.processoseletivo.Interfaces.ShotDelegate;
import com.example.adeilsonassis.processoseletivo.Model.Shot;
import com.example.adeilsonassis.processoseletivo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by adeilson.assis on 21/09/2017.
 */

public class ShotAdapter extends RecyclerView.Adapter
{
    Context context;
    List<Shot> shots;

    public ShotAdapter(Context context, List<Shot> shots)
    {
        this.context = context;
        this.shots = shots;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shot,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        ViewHolder viewHolder = (ViewHolder) holder;
        Shot shot = shots.get(position);
        viewHolder.tituloShot.setText(shot.getTitle());
        viewHolder.viemCount.setText(String.valueOf(shot.getViews_count()));
        viewHolder.createdAt.setText(String.valueOf(shot.getCreated_at()));
        Picasso.with(context).load(shot.getImages().getNormal()).placeholder(R.mipmap.ic_nophoto).into(viewHolder.imageShot);
    }

    @Override
    public int getItemCount()
    {
        return shots.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        @BindView(R.id.item_shot_title)
        TextView tituloShot;

        @BindView(R.id.item_shot_viewcount)
        TextView viemCount;

        @BindView(R.id.item_shot_createdat)
        TextView createdAt;

        @BindView(R.id.item_shot_image)
        ImageView imageShot;

        public ViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this,view);
        }

        @OnClick(R.id.item_shot)
        public void clickItem()
        {
            Shot shot = shots.get(getAdapterPosition());
            ShotDelegate delegate = (ShotDelegate) itemView.getContext();
            delegate.lidaComItemSelecionado(shot);
        }
    }
}
