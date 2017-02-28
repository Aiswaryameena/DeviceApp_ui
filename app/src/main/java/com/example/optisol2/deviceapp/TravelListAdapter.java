package com.example.optisol2.deviceapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TravelListAdapter extends RecyclerView.Adapter<TravelListAdapter.ViewHolder> {

    Context mContext;
    OnItemClickListener mItemClickListener;
    public TravelListAdapter(){

    }
    // 2
    public TravelListAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return new PlaceData().placeList().size();
    }

    // 2
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_places, parent, false);
        return new ViewHolder(view);
    }

    // 3
    @Override @SuppressWarnings("deprecation")
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Place place = new PlaceData().placeList().get(position);
        holder.placeName.setText(place.name);
        holder.placevalue.setText(place.placevalue);
//        Glide.with(mContext).load(place.getImageResourceId(mContext)).into(holder.placeImage);
        holder.placeImage.setImageResource(place.img);
        Bitmap photo = BitmapFactory.decodeResource(mContext.getResources(), place.getImageResourceId(mContext));

//        Palette.generateAsync(photo, new Palette.PaletteAsyncListener() {
//            public void onGenerated(Palette palette) {
//                int bgColor = palette.getMutedColor(mContext.getResources().getColor(android.R.color.black));
//                holder.placeNameHolder.setBackgroundColor(bgColor);
//                holder.textholder.setBackgroundColor(bgColor);
//                holder.cardView.setBackgroundColor(bgColor);
//            }
//        });
        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(mContext, holder.overflow);
                //inflating menu from xml resource
                popup.inflate(R.menu.main);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu_blue:
                                //handle menu1 click
                                Toast.makeText(mContext, "tagged your friends", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_green:
                                //handle menu2 click
                                Toast.makeText(mContext, "saved to gallery", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.menu_red:
                                //handle menu3 click
                                Toast.makeText(mContext, "You shared this post", Toast.LENGTH_SHORT).show();

                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }
    private void showPopupMenu(View view,int position) {
        // inflate menu
        PopupMenu popup = new PopupMenu(view.getContext(),view );
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.main, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener(position));
        popup.show();
    }

    // 3
    @SuppressWarnings("deprecation")
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout placeHolder;
        public RelativeLayout placeNameHolder;
        LinearLayout textholder;
        public TextView placeName,placevalue;
        public ImageView placeImage;
        public CardView cardView;
        public ImageButton overflow;

        public ViewHolder(View itemView) {
            super(itemView);
            placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            placeName = (TextView) itemView.findViewById(R.id.tyt);
            placeNameHolder = (RelativeLayout) itemView.findViewById(R.id.placeNameHolder);
            placeImage = (ImageView) itemView.findViewById(R.id.placeImage);
            placevalue=(TextView)itemView.findViewById(R.id.placeval);
            textholder=(LinearLayout)itemView.findViewById(R.id.linlay);
            cardView=(CardView)itemView.findViewById(R.id.card);
            overflow=(ImageButton) itemView.findViewById(R.id.imageView5);
            placeHolder.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getPosition());
            }
        }
    }
    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}