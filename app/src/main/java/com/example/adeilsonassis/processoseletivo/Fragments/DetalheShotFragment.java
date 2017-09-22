package com.example.adeilsonassis.processoseletivo.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adeilsonassis.processoseletivo.Model.Shot;
import com.example.adeilsonassis.processoseletivo.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetalheShotFragment extends Fragment
{
    @BindView(R.id.detalhe_shot_title)
    TextView detalheShotTitle;

    @BindView(R.id.detalhe_shot_description)
    TextView detalheShotdescription;

    @BindView(R.id.detalhe_shot_viewscount)
    TextView detalheShotViewsCount;

    @BindView(R.id.detalhe_shot_comments_count)
    TextView detalheShotCommentsCount;

    @BindView(R.id.detalhe_shot_cratedat)
    TextView detalheShotCreatedAt;

    @BindView(R.id.detalhe_shot_image)
    ImageView detalheShotImage;

    private Shot shot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_detalhe_shot, container, false);
        ButterKnife.bind(this,view);

        Bundle args = getArguments();
        shot = (Shot) args.getSerializable("shot");

        populaCamposCom(shot);

        return view;
    }

    public void populaCamposCom(Shot shot)
    {
        detalheShotTitle.setText(shot.getTitle());
        detalheShotdescription.setText(Html.fromHtml(shot.getDescription()));
        detalheShotViewsCount.setText("Views: "+String.valueOf(shot.getViews_count()));
        detalheShotCommentsCount.setText("Comments: "+String.valueOf(shot.getComments_count()));
        detalheShotCreatedAt.setText(String.valueOf(shot.getCreated_at()));
        Picasso.with(getContext()).load(shot.getImages().getHidpi()).into(detalheShotImage);
    }


}
