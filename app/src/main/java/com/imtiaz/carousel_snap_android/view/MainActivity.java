package com.imtiaz.carousel_snap_android.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import com.imtiaz.carousel_snap_android.R;
import com.imtiaz.carousel_snap_android.model.ItemModel;
import com.imtiaz.carousel_snap_android.shadowtransforner.ShadowTransformer;
import com.imtiaz.carousel_snap_android.adapters.CardPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private ShadowTransformer mFragmentCardShadowTransformer;
    private ArrayList<ItemModel> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        ItemModel model = new ItemModel();
        model.setTitle("A1");
        model.setSubTitle("I am A1");
        arrayList.add(model);


        model = new ItemModel();
        model.setTitle("A2");
        model.setSubTitle("I am A2");
        arrayList.add(model);


        model = new ItemModel();
        model.setTitle("A3");
        model.setSubTitle("I am A3");
        arrayList.add(model);

        model = new ItemModel();
        model.setTitle("A4");
        model.setSubTitle("I am A4");
        arrayList.add(model);

        model = new ItemModel();
        model.setTitle("A5");
        model.setSubTitle("I am A5");
        arrayList.add(model);

        model = new ItemModel();
        model.setTitle("A6");
        model.setSubTitle("I am A6");
        arrayList.add(model);


        mCardAdapter = new CardPagerAdapter(MainActivity.this,arrayList);

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }


    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

}
