package com.indepay.consumerapp.MoneyTransactions.mobileTopUp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



public class BrowsePlansAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public BrowsePlansAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                BrowsePlansFragment1 tab1 = new BrowsePlansFragment1();
                return tab1;
            case 1:
                BrowsePlansFragment2 tab2 = new BrowsePlansFragment2();
                return tab2;
            case 2:
                BrowsePlansFragment3 tab3 = new BrowsePlansFragment3();
                return tab3;
            case 3:
                BrowsePlansFragment4 tab4 = new BrowsePlansFragment4();
                return tab4;


            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}