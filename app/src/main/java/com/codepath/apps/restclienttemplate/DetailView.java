package com.codepath.apps.restclienttemplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.User;

import org.parceler.Parcels;


public class DetailView extends AppCompatActivity {

    Tweet tweet;
    User user;

    public ImageView ivProfileImage;
    private TextView tvUsername;
    public  TextView tvBody;
    public TextView tvTime;
    public TextView tvAtName;
    public ImageView entityTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

      // perform findViewById lookups
        ivProfileImage = (ImageView) findViewById(R.id.ivProfileImage);
        tvUsername = (TextView) findViewById(R.id.tvUserName);
        tvBody = (TextView) findViewById(R.id.tvBody);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvAtName = (TextView) findViewById(R.id.tvAtName);
        entityTweet = (ImageView) findViewById(R.id.entity_tweet);

        // unwrap the tweet passed in via intent
        tweet = (Tweet) Parcels.unwrap(getIntent().getParcelableExtra(Tweet.class.getSimpleName()));
        user = (User) Parcels.unwrap(getIntent().getParcelableExtra(User.class.getSimpleName()));


        // set the title and overview
        tvUsername.setText(tweet.user.getName());
        tvBody.setText(tweet.getBody());
        tvTime.setText(tweet.getCreatedAt());
        tvAtName.setText("@" + tweet.user.getScreenName());



        //load image using glide
        Glide.with(this)
                .load(tweet.user.profileImageUrl)
                .into(ivProfileImage);

        if(tweet.hasEntities){
            String entitiesUrl = tweet.entity.loadURL;
            entityTweet.setVisibility(View.VISIBLE);
            Glide.with(this).load(entitiesUrl).into(entityTweet);
        } else{
            entityTweet.setVisibility(View.GONE);
        }
    }


}
