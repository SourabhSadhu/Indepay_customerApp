package com.indepay.consumerapp.MoneyTransactions.sendMoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.indepay.consumerapp.R;

/**
 * Created by Sharad on 28-04-2017.
 */

public class SendMoneyToAccountNumber extends AppCompatActivity{
    TextView addPayee;
    Button submitPaymentToAccNumberBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_money_to_accountnumber);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Send Money");

        addPayee = (TextView)findViewById(R.id.textAddPayeeId);
        addPayee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMoneyToAccountNumber.this,AddPayee.class);
                startActivity(intent);
            }
        });

        submitPaymentToAccNumberBtn = (Button)findViewById(R.id.submitPaymentToAccNumberBtnId);
        submitPaymentToAccNumberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMoneyToAccountNumber.this,InvoiceSendMoney.class);
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
