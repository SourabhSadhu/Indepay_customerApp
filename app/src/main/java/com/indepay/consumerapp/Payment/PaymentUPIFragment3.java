package com.indepay.consumerapp.Payment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.indepay.consumerapp.MoneyTransactions.mobileTopUp.InvoiceMobileTopUp;
import com.indepay.consumerapp.R;

public class PaymentUPIFragment3 extends Fragment {

    Context context;
    Button submitUPIPaymentBtn;
    public PaymentUPIFragment3 ()
    {
        this.context = context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.payment_upi, container, false);

        submitUPIPaymentBtn = (Button)rootView.findViewById(R.id.submitUPIPaymentBtnId);
        submitUPIPaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),InvoiceMobileTopUp.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}