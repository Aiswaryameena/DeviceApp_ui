package com.example.optisol2.deviceapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by optisol2 on 19-01-2017.
 */
public class HelpActivity extends Activity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_activity);
        TextView text=(TextView)findViewById(R.id.textView15);
        text.setText("Your home page is what you see when you log into this App. It includes your News Feed, the constantly updating list of posts from friends, Pages and other connections you've made. You can react to things you see or search for people and topics that matter to you. Learn how to control what you see in News Feed.");
    }
}
