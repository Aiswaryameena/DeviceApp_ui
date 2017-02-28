package com.example.optisol2.deviceapp;

import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by optisol2 on 23-01-2017.
 */
class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener, android.widget.PopupMenu.OnMenuItemClickListener {

    private int position;
    TravelListAdapter tr=new TravelListAdapter();
    public MyMenuItemClickListener(int positon) {
        this.position=positon;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.menu_red:
                Toast.makeText(tr.mContext, "You shared this post", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_blue:
                Toast.makeText(tr.mContext, "tagged to your friends", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_green:
                Toast.makeText(tr.mContext, "saved to gallery", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return false;
    }
}
