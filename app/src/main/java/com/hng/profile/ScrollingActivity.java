package com.hng.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {

    CollapsingToolbarLayout collapsingToolbarLayout;
    TextView mFacebook, mTwitter, mGmail, mGithub, mSlack;
    FloatingActionButton fbFacebook, fbTwitter, fbGmail, fbGithub, fbSlack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        innitialiazation();
        setTexts();

    }

    void innitialiazation() {
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        fbFacebook = (FloatingActionButton) findViewById(R.id.fb);
        fbTwitter = (FloatingActionButton) findViewById(R.id.tt);
        fbGmail = (FloatingActionButton) findViewById(R.id.gm);
        fbGithub = (FloatingActionButton) findViewById(R.id.gt);
        fbSlack = (FloatingActionButton) findViewById(R.id.sl);
        mFacebook = (TextView) findViewById(R.id.txt_fb);
        mTwitter = (TextView) findViewById(R.id.txt_twitter);
        mGmail = (TextView) findViewById(R.id.txt_gmail);
        mGithub = (TextView) findViewById(R.id.txt_git);
        mSlack = (TextView) findViewById(R.id.txt_slack);

        fbFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String facebook = "http://www.facebook.com/username";
                passUrl(facebook);
            }
        });

        fbTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String twitter = "http://www.twitter.com/username";
                passUrl(twitter);
            }
        });

        fbGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEmail();
            }
        });

        fbGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String github = "http://www.github.com/username";
                passUrl(github);
            }
        });

        fbSlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String slack = "http://www.slack.com/username";
                passUrl(slack);
            }
        });
    }

    void setTexts() {
        collapsingToolbarLayout.setTitle("Ogechi Okoro");
        mFacebook.setText("@ogechiokoro");
        mTwitter.setText("@ogechiokoro");
        mGmail.setText("@oogehchris");
        mGithub.setText("@ogechiokoro");
        mSlack.setText("@ogechiokoro");
    }

    void passUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        Intent i = Intent.createChooser(intent, null);
        startActivity(i);
    }

    void openEmail() {
        String subject = "HNG Internship";
        String message = "Hi dear! i am Ogechi Okoro";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        Intent mailer = Intent.createChooser(intent, null);
        startActivity(mailer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
