package com.wyx.topindicatorbar;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        for (int i = 0; i < 3; i++) {
            View container = getLayoutInflater().inflate(R.layout.containter, null);
            viewContainter.add(container);

            View container2 = getLayoutInflater().inflate(R.layout.containter, null);
            viewContainter2.add(container2);
            View container3 = getLayoutInflater().inflate(R.layout.containter, null);
            viewContainter2.add(container3);

            View container4 = getLayoutInflater().inflate(R.layout.containter, null);
            viewContainter3.add(container4);
        }

        TopIndicatorBar topIndicatorBar = (TopIndicatorBar) findViewById(R.id.topindicatorBar);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getBaseContext(), "You selected" + position, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        topIndicatorBar.initWithEqualStyle(new String[]{"titile1", "titile2", "titile3"}, viewPager);
        topIndicatorBar.setInitColorIndex(2);

        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) findViewById(R.id.horizeScollview);
        TopIndicatorBar topIndicatorBar2 = (TopIndicatorBar) findViewById(R.id.topindicatorBar2);
        ViewPager viewPager2 = (ViewPager) findViewById(R.id.viewpager2);
        viewPager2.setAdapter(pagerAdapter2);
        topIndicatorBar2.init(new String[]{"titile1", "titile2", "titile3", "titile4", "titile5", "titile6", "titile7"}, viewPager2, horizontalScrollView);


        final TopIndicatorBar topIndicatorBar3 = (TopIndicatorBar) findViewById(R.id.topindicatorBar3);
        ViewPager viewPager3 = (ViewPager) findViewById(R.id.viewpager3);
        viewPager3.setAdapter(pagerAdapter3);
        topIndicatorBar3.initWithEqualStyle(new String[]{"titile1", "titile2", "titile3"}, new TopIndicatorBar.TopIndicatorTabChangeListener() {
            @Override
            public void onViewChange(int selected) {
                Toast.makeText(getBaseContext(), "You selected" + selected, Toast.LENGTH_LONG).show();
                topIndicatorBar3.initWithEqualStyle(new String[]{"selected" + selected, "selected" + selected, "selected" + selected}, this);
                topIndicatorBar3.setInitColorIndex(selected);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private ArrayList<View> viewContainter = new ArrayList<View>();
    private ArrayList<View> viewContainter2 = new ArrayList<View>();
    private ArrayList<View> viewContainter3 = new ArrayList<View>();
    private final PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return viewContainter.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (position < viewContainter.size() && position >= 0) {
                ((ViewPager) container).removeView(viewContainter.get(position));
            }

        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = viewContainter.get(position);
            ((ViewPager) container).addView(view);
            return viewContainter.get(position);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
    };
    private final PagerAdapter pagerAdapter2 = new PagerAdapter() {
        @Override
        public int getCount() {
            return viewContainter2.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (position < viewContainter2.size() && position >= 0) {
                ((ViewPager) container).removeView(viewContainter2.get(position));
            }

        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = viewContainter2.get(position);
            ((ViewPager) container).addView(view);
            return viewContainter2.get(position);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
    };
    private final PagerAdapter pagerAdapter3 = new PagerAdapter() {
        @Override
        public int getCount() {
            return viewContainter3.size();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            if (position < viewContainter3.size() && position >= 0) {
                ((ViewPager) container).removeView(viewContainter3.get(position));
            }

        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = viewContainter3.get(position);
            ((ViewPager) container).addView(view);
            return viewContainter3.get(position);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
    };
}
