package com.indepay.consumerapp.Payment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PaymentAdapter extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public PaymentAdapter(FragmentManager fm, int tabCount) {
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
                PaymentDebitFragment1 tab1 = new PaymentDebitFragment1();
                return tab1;
            case 1:
                PaymentNetbankingFragment2 tab2 = new PaymentNetbankingFragment2();
                return tab2;
            case 2:
                PaymentUPIFragment3 tab3 = new PaymentUPIFragment3();
                return tab3;

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