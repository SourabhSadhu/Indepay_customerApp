package com.indepay.consumerapp.MoneyTransactions.mobileTopUp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.indepay.consumerapp.R;

public class BrowsePlansFragment3 extends Fragment {

    Context context;
    public BrowsePlansFragment3()
    {
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.browse_plans_fragment_3, container, false);


        return rootView;
    }

}