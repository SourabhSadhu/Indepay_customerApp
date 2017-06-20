package com.indepay.consumerapp.MyProfile;

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

import com.indepay.consumerapp.R;
import com.indepay.consumerapp.savedCards.AddCard;

import java.util.ArrayList;
import java.util.Collections;


public class BankAccountDetail extends AppCompatActivity {
    Spinner nameofBank;
    Button setpin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bank_account_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bank Account Details");

        setpin = (Button) findViewById(R.id.setpin);

        nameofBank = (Spinner)findViewById(R.id.spinnerNameofBank);
        ArrayList<String> listNameofBank = new ArrayList<String>();
        listNameofBank.add("State Bank of India");
        listNameofBank.add("Central Bank of India");
        listNameofBank.add("Punjab National Bank");
        listNameofBank.add("Axis Bank");
        listNameofBank.add("Yes Bank");
        listNameofBank.add("Kotak Mahindra");
        listNameofBank.add("Allahabad Bank");
        listNameofBank.add("Andhra Bank");
        listNameofBank.add("Bank of India");
        listNameofBank.add("Bank of Baroda");
        listNameofBank.add("Bank of Maharashtra");
        listNameofBank.add("Canara Bank");
        listNameofBank.add("Corporation Bank");
        listNameofBank.add("HDFC Bank");
        listNameofBank.add("Federal Bank");
        Collections.sort(listNameofBank);

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(BankAccountDetail.this,listNameofBank);
        nameofBank.setAdapter(adapter);

        setpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(BankAccountDetail.this, MyProfile.class);
                intent.putExtra("customerName",getIntent().getStringExtra("customerName"));
                intent.putExtra("customerPhone",getIntent().getStringExtra("customerPhone"));
                intent.putExtra("aadharNo",getIntent().getStringExtra("aadharNo"));
                intent.putExtra("dateofBirth",getIntent().getStringExtra("dateofBirth"));
                intent.putExtra("email",getIntent().getStringExtra("email"));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                    Intent intent = new Intent(this, MyProfile.class);
                    startActivity(intent);
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
            TextView txt = new TextView(BankAccountDetail.this);
            txt.setPadding(13, 13, 13, 13);
            txt.setTextSize(15);
            txt.setGravity(Gravity.LEFT);
            txt.setTextAppearance(BankAccountDetail.this, R.style.RedHUGEText);
            txt.setText(asr.get(position));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            TextView txt = new TextView(BankAccountDetail.this);
            txt.setGravity(Gravity.CENTER);
            txt.setPadding(5, 5, 5, 5);
            txt.setTextSize(14);
            txt.setTextAppearance(BankAccountDetail.this, R.style.RedHUGEText);
            txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dwn_aro, 0);
            txt.setText(asr.get(i));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }
    }
}
