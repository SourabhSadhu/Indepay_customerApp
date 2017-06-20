package com.indepay.consumerapp.MoneyTransactions.mobileTopUp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.indepay.consumerapp.MyProfile.MyProfile;
import com.indepay.consumerapp.Payment.Payment;
import com.indepay.consumerapp.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Sharad on 28-04-2017.
 */

public class MobileTopUp extends AppCompatActivity {

    Button proceedToPayBtn;
    RelativeLayout browsePlans;
    Spinner mobileOperator,mobileCircle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_top_up);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Mobile Top Up");

        mobileOperator= (Spinner)findViewById(R.id.spinnerMobileOperatorId);
        mobileCircle= (Spinner)findViewById(R.id.spinnerMobileCircleId);

        ArrayList<String> listMobileOperator = new ArrayList<String>();
        listMobileOperator.add("Airtel");
        listMobileOperator.add("Aircel");
        listMobileOperator.add("Idea");
        listMobileOperator.add("Vodafone");
        listMobileOperator.add("Reliance");
        listMobileOperator.add("Jio");
        listMobileOperator.add("BSNL");
        listMobileOperator.add("Telenor");
        listMobileOperator.add("MTS");
        Collections.sort(listMobileOperator);

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(MobileTopUp.this,listMobileOperator);
        mobileOperator.setAdapter(adapter);

        ArrayList<String> listMobileCircle = new ArrayList<String>();
        listMobileCircle.add("Delhi-NCR");
        listMobileCircle.add("North");
        listMobileCircle.add("East");
        listMobileCircle.add("North");
        listMobileCircle.add("South");

        Collections.sort(listMobileCircle);

        CustomSpinnerAdapter adapter1 = new CustomSpinnerAdapter(MobileTopUp.this,listMobileCircle);
        mobileCircle.setAdapter(adapter1);

        browsePlans = (RelativeLayout)findViewById(R.id.rL7);
        browsePlans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MobileTopUp.this, BrowsePlans.class);
                startActivity(intent);
            }
        });

        proceedToPayBtn = (Button)findViewById(R.id.proceedToPayBtnId);
        proceedToPayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MobileTopUp.this, Payment.class);
                startActivity(intent);
            }
        });
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

    public class CustomSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {

        Context activity;
        private ArrayList<String> asr;

        public CustomSpinnerAdapter(Context context, ArrayList<String> asr) {
            this.asr = asr;
            this.activity = context;
        }


        public int getCount() {
            return asr.size();
        }

        public Object getItem(int i) {
            return asr.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }


        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            TextView txt = new TextView(MobileTopUp.this);
            txt.setPadding(13, 13, 13, 13);
            txt.setTextSize(17);
            txt.setGravity(Gravity.LEFT);
            txt.setTextAppearance(MobileTopUp.this, R.style.RedHUGEText);
            txt.setText(asr.get(position));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            TextView txt = new TextView(MobileTopUp.this);
            txt.setGravity(Gravity.CENTER_HORIZONTAL);
            txt.setPadding(0, 0, 35, 0);
            txt.setTextSize(17);
            txt.setTextAppearance(MobileTopUp.this, R.style.RedHUGEText);
            txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dwn_aro, 0);
            txt.setText(asr.get(i));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }
    }
}
