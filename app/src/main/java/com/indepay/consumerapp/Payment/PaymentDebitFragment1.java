package com.indepay.consumerapp.Payment;


import android.app.Dialog;
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
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.indepay.consumerapp.MoneyTransactions.mobileTopUp.InvoiceMobileTopUp;
import com.indepay.consumerapp.R;

import java.util.ArrayList;

public class PaymentDebitFragment1 extends Fragment implements NumberPicker.OnValueChangeListener {
    EditText yearSelector;
    Spinner month;
    Context context;
    Button submitDebitBtn;
    public PaymentDebitFragment1 ()
    {
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.payment_debit, container, false);

        month = (Spinner)rootView.findViewById(R.id.monthSpinnerId);

        yearSelector = (EditText)rootView.findViewById(R.id.yearSpinnerId);
        yearSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });

        ArrayList<String> listNameofBank = new ArrayList<String>();
        listNameofBank.add("Jan");
        listNameofBank.add("Feb");
        listNameofBank.add("Mar");
        listNameofBank.add("Apr");
        listNameofBank.add("May");
        listNameofBank.add("Jun");
        listNameofBank.add("Jul");
        listNameofBank.add("Aug");
        listNameofBank.add("Sep");
        listNameofBank.add("Oct");
        listNameofBank.add("Nov");
        listNameofBank.add("Dec");



        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getContext(), listNameofBank);
        month.setAdapter(adapter);

        submitDebitBtn = (Button)rootView.findViewById(R.id.submitDebitPaymentBtnId);
        submitDebitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),InvoiceMobileTopUp.class);
                startActivity(intent);
            }
        });

        return rootView;
    }


    public void show() {

        final Dialog d = new Dialog(getContext());
        d.setTitle("Select Year");
        d.setContentView(R.layout.year_picker_dialog);
        Button b1 = (Button) d.findViewById(R.id.button1);
        Button b2 = (Button) d.findViewById(R.id.button2);
        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(2020);
        np.setMinValue(1990);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(PaymentDebitFragment1.this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yearSelector.setText(String.valueOf(np.getValue())); //set the value to textview
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.dismiss(); // dismiss the dialog
            }
        });
        d.show();


    }


    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

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
