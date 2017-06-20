package com.indepay.consumerapp.MoneyTransactions.sendMoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.indepay.consumerapp.R;

/**
 * Created by Sharad on 28-04-2017.
 */

public class SendMoneyToMobileNumber extends AppCompatActivity {

    Button submitPaymentToMobileNoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_money_to_mobilenumber);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Send Money");

        submitPaymentToMobileNoBtn = (Button)findViewById(R.id.submitPaymentToMobileNoBtnId);
        submitPaymentToMobileNoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMoneyToMobileNumber.this,InvoiceSendMoney.class);
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

}
