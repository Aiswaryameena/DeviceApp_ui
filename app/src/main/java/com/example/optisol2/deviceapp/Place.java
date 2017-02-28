package com.example.optisol2.deviceapp;

import android.content.Context;

public class Place {

  public String name;
  public String imageName;
  public boolean isFav;
  public int img;
  public String placevalue;

  public int getImageResourceId(Context context) {
    return context.getResources().getIdentifier(this.imageName,"drawable", context.getPackageName());
  }
}
