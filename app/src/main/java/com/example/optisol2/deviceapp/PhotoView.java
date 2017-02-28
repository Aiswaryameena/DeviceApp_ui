package com.example.optisol2.deviceapp;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

/**
 * Created by optisol2 on 19R.drawable.01R.drawable.2017.
 */
public class PhotoView extends Activity {
    GridView gv;
    String selection;
    Cursor imgcursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_activity);
        gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(new ImageListAdapter(this, drawable));


    }
public Integer drawable[]={
        R.drawable.ac,
        R.drawable.arrowicon,
        R.drawable.asdffds,
        R.drawable.baby,
        R.drawable.background,
        R.drawable.borabora,
        R.drawable.canada,
        R.drawable.capture,
        R.drawable.captureup,
        R.drawable.comment,
        R.drawable.cu,
        R.drawable.dubai,
        R.drawable.flo,
        R.drawable.flower
,        R.drawable.followers,
        R.drawable.full,
        R.drawable.green,
        R.drawable.heart,
        R.drawable.hint_bulb
 ,       R.drawable.hongkong
  ,      R.drawable.iceland,R.drawable.images
   ,     R.drawable.index
    ,    R.drawable.india
     ,   R.drawable.kenya
      ,  R.drawable.london
       , R.drawable.next
        ,R.drawable.switzerland
        ,R.drawable.sydney
        ,R.drawable.tert
        ,R.drawable.thumbs
};
        
}