package com.indepay.consumerapp.LoginProcess;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.indepay.consumerapp.MyProfile.MyProfile;
import com.indepay.consumerapp.R;

import java.util.ArrayList;

/**
 * Created by Sharad on 27-04-2017.
 */

public class WelcomeBack extends AppCompatActivity{
    TextView forgetPassword;
    Button loginBtn,registerBtn;
    Spinner spinnerCountryCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_back);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Welcome Back");

        spinnerCountryCode = (Spinner)findViewById(R.id.spinnerCountryCodeId);


        ArrayList<String> listCountryCode = new ArrayList<String>();
        listCountryCode.add("India(+91)");
        listCountryCode.add("Indonesia(+62)");

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(WelcomeBack.this,listCountryCode);
        spinnerCountryCode.setAdapter(adapter);

        forgetPassword = (TextView)findViewById(R.id.textforgetPasswordId);
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WelcomeBack.this,ForgotPassword.class);
                startActivity(intent);
            }
        });
        loginBtn = (Button)findViewById(R.id.loginBtnId);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(WelcomeBack.this, PickUpLocation.class);
                Intent intent = new Intent(WelcomeBack.this, VerifyMobileNo.class);
                startActivity(intent);
            }
        });
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
            TextView txt = new TextView(WelcomeBack.this);
            txt.setPadding(13, 13, 13, 13);
            txt.setTextSize(17);
            txt.setGravity(Gravity.LEFT);
            txt.setTextAppearance(WelcomeBack.this, R.style.RedHUGEText);
            txt.setText(asr.get(position));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            TextView txt = new TextView(WelcomeBack.this);
            txt.setGravity(Gravity.CENTER_HORIZONTAL);
            txt.setPadding(0, 0, 25, 0);
            txt.setTextSize(17);
            txt.setTextAppearance(WelcomeBack.this, R.style.RedHUGEText);
            txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dwn_aro, 0);
            txt.setText(asr.get(i));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }
    }

}

