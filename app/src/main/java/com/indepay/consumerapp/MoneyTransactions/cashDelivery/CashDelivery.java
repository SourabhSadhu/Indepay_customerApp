package com.indepay.consumerapp.MoneyTransactions.cashDelivery;

import android.app.Dialog;
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
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.indepay.consumerapp.MoneyTransactions.cashDeposit.CashDeposit;
import com.indepay.consumerapp.MoneyTransactions.cashDeposit.CashPickUpTracking;
import com.indepay.consumerapp.R;
import com.indepay.consumerapp.VolleyMethods;

import java.util.ArrayList;

/**
 * Created by Sharad on 29-04-2017.
 */

public class CashDelivery extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cash_delivery);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cash Delivery");

        EnerAmountForDelivery();

    }


       Dialog enerAmountForDeliveryPopUp = null;

    public void EnerAmountForDelivery() {

        if (enerAmountForDeliveryPopUp != null && enerAmountForDeliveryPopUp.isShowing())
            return;

        enerAmountForDeliveryPopUp = new Dialog(CashDelivery.this);
        enerAmountForDeliveryPopUp.requestWindowFeature(Window.FEATURE_NO_TITLE);
        enerAmountForDeliveryPopUp.setContentView(R.layout.enter_amount_for_delivery_pop_up);

        final EditText enterAmount = (EditText) enerAmountForDeliveryPopUp.findViewById(R.id.enterAmountId);
        final TextView serviceCharge = (TextView) enerAmountForDeliveryPopUp.findViewById(R.id.editServiceChargeId);
        final TextView totalAmountToHandover = (TextView) enerAmountForDeliveryPopUp.findViewById(R.id.editTotalAmountToHandoverId);
        final Spinner spinnerFavAgent = (Spinner) enerAmountForDeliveryPopUp.findViewById(R.id.spinnerSelectFavouriteAgentId);

        serviceCharge.setText("50");
        totalAmountToHandover.setText("1000" + "+" + "50");
        Button requestAgentBtn = (Button) enerAmountForDeliveryPopUp.findViewById(R.id.requestAgentBtnId);

        ArrayList<String> listFavAgent = new ArrayList<String>();
        listFavAgent.add("Vijay Kumar");
        listFavAgent.add("Mohan");
        listFavAgent.add("Munesh");
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(CashDelivery.this, listFavAgent);
        spinnerFavAgent.setAdapter(adapter);
        requestAgentBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CashDelivery.this, CashDeliveryTracking.class);
                startActivity(intent);
                enerAmountForDeliveryPopUp.dismiss();


            }
        });
        enerAmountForDeliveryPopUp.show();
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
            TextView txt = new TextView(CashDelivery.this);
            txt.setPadding(13, 13, 13, 13);
            txt.setTextSize(17);
            txt.setGravity(Gravity.LEFT);
            txt.setTextAppearance(CashDelivery.this, R.style.RedHUGEText);
            txt.setText(asr.get(position));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            TextView txt = new TextView(CashDelivery.this);
            txt.setGravity(Gravity.CENTER_HORIZONTAL);
            txt.setPadding(0, 0, 12, 0);
            txt.setTextSize(17);
            txt.setTextAppearance(CashDelivery.this, R.style.RedHUGEText);
            txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dwn_aro, 0);
            txt.setText(asr.get(i));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }
    }
}