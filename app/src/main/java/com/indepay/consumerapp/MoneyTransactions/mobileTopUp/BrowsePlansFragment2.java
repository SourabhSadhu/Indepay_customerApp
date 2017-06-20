package com.indepay.consumerapp.MoneyTransactions.mobileTopUp;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.indepay.consumerapp.R;

import java.util.ArrayList;
import java.util.Collections;

public class BrowsePlansFragment2 extends Fragment {
    Context context;

    public BrowsePlansFragment2() {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.browse_plans_fragment_2, container, false);

        return rootView;
    }


}