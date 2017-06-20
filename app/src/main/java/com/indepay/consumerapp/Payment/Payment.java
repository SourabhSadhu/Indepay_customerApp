package com.indepay.consumerapp.Payment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.indepay.consumerapp.R;


public class Payment extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
        public static Context m_context;
        ViewPager viewPager;
        TabLayout tabLayout;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.payment);
//         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//         setSupportActionBar(toolbar);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Payment");


            m_context = this;

            //Initializing the tablayout
            tabLayout = (TabLayout) findViewById(R.id.tabLayout);

            //Adding the tabs using addTab() method
            tabLayout.addTab(tabLayout.newTab().setText("Debit Card"));
            tabLayout.addTab(tabLayout.newTab().setText("Net Banking"));
            tabLayout.addTab(tabLayout.newTab().setText("UPI"));


            tabLayout.setTabTextColors(Color.GRAY,Color.BLACK);
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
            tabLayout.setSelectedTabIndicatorColor(Color.DKGRAY);


            //Initializing viewPager
            viewPager = (ViewPager) findViewById(R.id.pager);

            //Creating our pager adapter
            PaymentAdapter adapter = new PaymentAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

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
                    finish();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }



        @Override
        public void onBackPressed()
        {
            setResult(Activity.RESULT_OK, new Intent().putExtra("Increment", 1));
            finish();
        }


    }
