package com.example.adeilsonassis.processoseletivo.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by adeilson.assis on 21/09/2017.
 */

public class Shot implements Serializable
{
    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("views_count")
    private int views_count;

    @SerializedName("comments_count")
    private int comments_count;

    @SerializedName("created_at")
    private Date created_at;

    @SerializedName("images")
    private Images images;

    public Shot()
    {

    }

    public Shot(long id, String title, String description)
    {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViews_count() {
        return views_count;
    }

    public void setViews_count(int views_count) {
        this.views_count = views_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public JSONObject toJson()
    {
        JSONObject result = new JSONObject();
        try
        {
            result.put("id", id);
            result.put("title", title);
            result.put("description", description);

            if (images != null)
            {
                result.put("images", images.toJson());
            }

            result.put("views_count", views_count);
            result.put("comments_count", comments_count);
            result.put("created_at", created_at);

        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    public String toGson()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    @Override
    public String toString()
    {
        try
        {
            return toJson().toString(4);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
