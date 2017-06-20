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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.indepay.consumerapp.R;

import java.util.ArrayList;

/**
 * Created by Sharad on 27-04-2017.
 */

public class ForgotPassword extends AppCompatActivity {
    Button sendOTPBtn,verifyBtn;
    Button resendBtn, callMe;
    EditText enterOTP;
    TextView message;
    Spinner spinnerCountryCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Forgot Password");


        resendBtn = (Button) findViewById(R.id.resendBtnId);
        callMe = (Button) findViewById(R.id.callBtnId);
        enterOTP = (EditText) findViewById(R.id.editOTPId);
        message = (TextView) findViewById(R.id.textMessageOTPId);
        sendOTPBtn = (Button) findViewById(R.id.sendOTPBtnId);
        verifyBtn = (Button)findViewById(R.id.verifyBtnId);

        spinnerCountryCode = (Spinner)findViewById(R.id.spinnerCountryCodeId);

        ArrayList<String> listCountryCode = new ArrayList<String>();
        listCountryCode.add("India(+91)");
        listCountryCode.add("Indonesia(+62)");

       CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(ForgotPassword.this,listCountryCode);
        spinnerCountryCode.setAdapter(adapter);

        resendBtn.setVisibility(View.GONE);
        callMe.setVisibility(View.GONE);
        enterOTP.setVisibility(View.GONE);
        message.setVisibility(View.GONE);
        verifyBtn.setVisibility(View.GONE);

        sendOTPBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resendBtn.setVisibility(View.VISIBLE);
                callMe.setVisibility(View.VISIBLE);
                enterOTP.setVisibility(View.VISIBLE);
                message.setVisibility(View.VISIBLE);
                verifyBtn.setVisibility(View.VISIBLE);

            }
        });


        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPassword.this,ChangePin.class);
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
            TextView txt = new TextView(ForgotPassword.this);
            txt.setPadding(13, 13, 13, 13);
            txt.setTextSize(17);
            txt.setGravity(Gravity.LEFT);
            txt.setTextAppearance(ForgotPassword.this, R.style.RedHUGEText);
            txt.setText(asr.get(position));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            TextView txt = new TextView(ForgotPassword.this);
            txt.setGravity(Gravity.CENTER_HORIZONTAL);
            txt.setPadding(0, 0, 25, 0);
            txt.setTextSize(17);
            txt.setTextAppearance(ForgotPassword.this, R.style.RedHUGEText);
            txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dwn_aro, 0);
            txt.setText(asr.get(i));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }
    }

}

