package com.indepay.consumerapp.MoneyTransactions.mobileTopUp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.indepay.consumerapp.Payment.PaymentAdapter;
import com.indepay.consumerapp.R;

/**
 * Created by Sharad on 29-04-2017.
 */

public class BrowsePlans extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    public static Context m_context;
    ViewPager viewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_plans);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Plans");

        m_context = this;

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Full Talktime"));
        tabLayout.addTab(tabLayout.newTab().setText("3G Data"));
        tabLayout.addTab(tabLayout.newTab().setText("Top Up"));
        tabLayout.addTab(tabLayout.newTab().setText("2G Data"));



        tabLayout.setTabTextColors(Color.GRAY,Color.BLACK);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setSelectedTabIndicatorColor(Color.DKGRAY);


        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.viewPagerBrowsePlansId);

        //Creating our pager adapter
        BrowsePlansAdapter adapter = new BrowsePlansAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                tabLayout.setScrollPosition(position,0,true);


            }

            @Override
            public void onPageSelected(int position) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public void setCurrentTab(int position,float offset,boolean value) {
        tabLayout.setScrollPosition(position,offset,value);
    }
    public void setCurrentItem(int item, boolean smoothScroll) {
        viewPager.setCurrentItem(item, smoothScroll);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        tabLayout.setSelectedTabIndicatorColor(Color.DKGRAY);

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
