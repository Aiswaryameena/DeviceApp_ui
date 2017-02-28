package com.example.optisol2.deviceapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by optisol2 on 19-01-2017.
 */
public class AboutUs extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        TextView text=(TextView)findViewById(R.id.textView16);
        text.setText("Welcome to ProBlogger.net – a Blog that helps bloggers to add income streams to their blogs.\n" +
                "\n" +
                "D Rowse 162My name is Darren Rowse and I’m a full time Blogger making a living from this new and dynamic medium from blogs like Digital Photography School.\n" +
                "\n" +
                "I’m also an author and speaker… but more of that shortly.\n" +
                "From Hobby to Profession\n" +
                "\n" +
                "Back in 2002 I stumbled upon an article about ‘Blogging’. I didn’t know it at the time but that moment changed my life. I know that statements like that belong on those cheesy ‘buy my $1000 training program’ sites (don’t worry I’m not selling anything more than a book) but it is actually true.");
    }
}
