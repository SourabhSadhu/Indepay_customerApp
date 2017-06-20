package com.indepay.consumerapp.MoneyTransactions.sendMoney;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.indepay.consumerapp.R;

/**
 * Created by Sharad on 28-04-2017.
 */

public class SendMoney extends AppCompatActivity {

    RelativeLayout rLay1VPA,rLayAccNumber,rLayMobileNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_money);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Send Money");

        rLay1VPA = (RelativeLayout)findViewById(R.id.rL3);
        rLayAccNumber = (RelativeLayout)findViewById(R.id.rL4);
        rLayMobileNumber = (RelativeLayout)findViewById(R.id.rL6);

        rLay1VPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMoney.this,SendMoneyToVPA.class);
                startActivity(intent);
            }
        });

        rLayAccNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMoney.this,SendMoneyToAccountNumber.class);
                startActivity(intent);

            }
        });

        rLayMobileNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMoney.this,SendMoneyToMobileNumber.class);
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
