package com.example.android.javadevelopers;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Mifere on 6/13/2017.
 */

public class PersonalDetails extends AppCompatActivity implements View.OnClickListener {
    ImageView user_bak;
    CircleImageView user_image;
    TextView username, url_link;

    Button user_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user_bak = (ImageView) findViewById(R.id.user_bak);
        user_image = (CircleImageView) findViewById(R.id.user_image);
        username = (TextView) findViewById(R.id.username);
        url_link = (TextView) findViewById(R.id.url_link);
        user_share = (Button) findViewById(R.id.user_share);

        url_link.setOnClickListener(this);
        user_share.setOnClickListener(this);

        Intent intent = getIntent();
        String mUsername = intent.getStringExtra("username");
        String mUser_image = intent.getStringExtra("avatar");
        String user_url = intent.getStringExtra("url");

        username.setText(mUsername);
        Picasso.with(this).load(mUser_image).fit().placeholder(R.drawable.portrait).into(user_image);
        Picasso.with(this).load(mUser_image).fit().placeholder(R.drawable.portrait).into(user_bak);

        url_link.setText(user_url);
        url_link.setPaintFlags(url_link.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        String title = getIntent().getStringExtra("username");
        setTitle(title +"'s" + " Profile");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.url_link:
                String url = getIntent().getStringExtra("url");
                Intent toBrowser = new Intent(Intent.ACTION_VIEW);
                toBrowser.setData(Uri.parse(url));
                startActivity(toBrowser);
                break;

            case R.id.user_share:
                String share = getIntent().getStringExtra("username");
                String share_url = getIntent().getStringExtra("url");
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"Hello Eggheads, Check Out This Awesome Developer \n" + "Username: " + share + "\n" + "GitHub Link: " + share_url);
                startActivity(i);
                break;

        }

    }}
