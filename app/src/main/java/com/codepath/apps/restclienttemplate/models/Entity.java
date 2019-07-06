package com.codepath.apps.restclienttemplate.models;

import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class Entity {

    public String loadURL;

    public Entity() {}

    public static Entity fromJSON(JSONObject jsonObject) throws Exception{
        Entity entity = new Entity();
        entity.loadURL = jsonObject.getJSONArray("media").getJSONObject(0).getString("media_url_https");

        return entity;
    }
}
