package com.example.optisol2.deviceapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;


public class FirstFragment extends Fragment {
    private Menu menu;
    Bitmap icon;
    private Resources mResources;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private boolean isListView;
    private TravelListAdapter mAdapter;
    LinearLayout relativeLayout;
    View myView;

    TravelListAdapter.OnItemClickListener onItemClickListener = new TravelListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            Toast.makeText(getActivity(), "Clicked " + position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_PARAM_ID, position);
            startActivity(intent);
        }
    };

    public FirstFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.fragment_first, container, false);
        isListView = true;
        mRecyclerView = (RecyclerView) myView.findViewById(R.id.list);
        CircleImageView cv = (CircleImageView) myView.findViewById(R.id.circleImageView);
        icon = BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.baby);
        RoundedBitmapDrawable drawable = createRoundedBitmapDrawableWithBorder(icon);

        cv.setImageDrawable(drawable);
        final RelativeLayout rel1 = (RelativeLayout) myView.findViewById(R.id.rel_layout);
        final LinearLayout linearLayout = (LinearLayout) myView.findViewById(R.id.linearLayout);
        relativeLayout = (LinearLayout) myView.findViewById(R.id.relativeLayout);
        final CircleImageView fab = (CircleImageView) myView.findViewById(R.id.fab_button);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        mAdapter = new TravelListAdapter(getActivity());
        mRecyclerView.addItemDecoration(new VerticalSpaceItemDecoration(15));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(onItemClickListener);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RelativeLayout rel = (RelativeLayout) myView.findViewById(R.id.rel_layout_2);
                rel.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.GONE);
                rel1.setVisibility(View.GONE);
                fab.setVisibility(View.GONE);
                linearLayout.setVisibility(View.GONE);
                ImageView img = (ImageView) myView.findViewById(R.id.img);
                img.setImageBitmap(icon);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rel.setVisibility(View.GONE);
                        fab.setVisibility(View.VISIBLE);
                        rel1.setVisibility(View.VISIBLE);
                        linearLayout.setVisibility(View.VISIBLE);
                        relativeLayout.setVisibility(View.VISIBLE);
                    }
                });
            }
        });
        myView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        return myView;
    }

    private RoundedBitmapDrawable createRoundedBitmapDrawableWithBorder(Bitmap bitmap) {
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int borderWidthHalf = 10;

        int bitmapRadius = Math.min(bitmapWidth, bitmapHeight) / 2;

        int bitmapSquareWidth = Math.min(bitmapWidth, bitmapHeight);

        int newBitmapSquareWidth = bitmapSquareWidth + borderWidthHalf;

        Bitmap roundedBitmap = Bitmap.createBitmap(newBitmapSquareWidth, newBitmapSquareWidth, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(roundedBitmap);

        canvas.drawColor(Color.RED);
        int x = borderWidthHalf + bitmapSquareWidth - bitmapWidth;
        int y = borderWidthHalf + bitmapSquareWidth - bitmapHeight;

        canvas.drawBitmap(bitmap, x, y, null);
        Paint borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(borderWidthHalf * 2);
        borderPaint.setColor(Color.WHITE);

        canvas.drawCircle(canvas.getWidth() / 2, canvas.getWidth() / 2, newBitmapSquareWidth / 2, borderPaint);

        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(mResources, roundedBitmap);

        roundedBitmapDrawable.setCornerRadius(bitmapRadius);

        roundedBitmapDrawable.setAntiAlias(true);

        return roundedBitmapDrawable;
    }

    public class VerticalSpaceItemDecoration extends RecyclerView.ItemDecoration {

        private final int verticalSpaceHeight;

        public VerticalSpaceItemDecoration(int verticalSpaceHeight) {
            this.verticalSpaceHeight = verticalSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            outRect.bottom = verticalSpaceHeight;
        }
    }


}

