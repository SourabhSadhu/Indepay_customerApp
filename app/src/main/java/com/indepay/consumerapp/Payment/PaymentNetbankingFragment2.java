package com.indepay.consumerapp.Payment;


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

import com.indepay.consumerapp.MoneyTransactions.mobileTopUp.InvoiceMobileTopUp;
import com.indepay.consumerapp.R;

import java.util.ArrayList;
import java.util.Collections;

public class PaymentNetbankingFragment2 extends Fragment {
    Context context;
    Spinner nameofBank;
    Button submitNetBankingPaymentBtn;
    public PaymentNetbankingFragment2() {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.payment_netbanking, container, false);

        nameofBank = (Spinner)rootView.findViewById(R.id.nameofbankId);
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

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getContext(), listNameofBank);
        nameofBank.setAdapter(adapter);

        submitNetBankingPaymentBtn = (Button)rootView.findViewById(R.id.submitNetBankingPaymentBtnId);
        submitNetBankingPaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),InvoiceMobileTopUp.class);
                startActivity(intent);
            }
        });
        return rootView;


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
            TextView txt = new TextView(getContext());
            txt.setPadding(13, 13, 13, 13);
            txt.setTextSize(17);
            txt.setGravity(Gravity.LEFT);
            txt.setTextAppearance(getContext(), R.style.RedHUGEText);
            txt.setText(asr.get(position));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            TextView txt = new TextView(getContext());
            txt.setGravity(Gravity.CENTER);
            txt.setPadding(5, 5, 20, 5);
            txt.setTextSize(17);
            txt.setTextAppearance(getContext(), R.style.RedHUGEText);
            txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dwn_aro, 0);
            txt.setText(asr.get(i));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }
    }
}