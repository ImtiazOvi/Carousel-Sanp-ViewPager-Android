package com.imtiaz.carousel_snap_android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.imtiaz.carousel_snap_android.R;
import com.imtiaz.carousel_snap_android.interfaces.CardAdapter;
import com.imtiaz.carousel_snap_android.model.ItemModel;

import java.util.ArrayList;

public class CardPagerAdapter extends PagerAdapter implements CardAdapter {

    private Context mContext;
    private float mBaseElevation;
    private ArrayList<ItemModel> arrayList;

    public CardPagerAdapter(Context mContext,ArrayList<ItemModel> arrayList ){
        this.mContext = mContext;
        this.arrayList = arrayList;

    }

    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.adapter, container, false);
        container.addView(view);

        // =========================================================================
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        TextView txtTitle =  view.findViewById(R.id.titleTextView);
        TextView txtSubTitle =  view.findViewById(R.id.contentTextView);

        // =========================================================================

        ItemModel model = arrayList.get(position);
        // Getting title from model
        txtTitle.setText(model.getTitle());

        // Getting sub title from model
        txtSubTitle.setText(model.getSubTitle());




        // =========================================================================

        if (mBaseElevation == 0) {
            mBaseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(mBaseElevation * MAX_ELEVATION_FACTOR);
       // mViews.set(position, cardView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        //mViews.set(position, null);
    }



}