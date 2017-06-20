package com.indepay.consumerapp.LoginProcess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.indepay.consumerapp.MyProfile.MyProfile;
import com.indepay.consumerapp.Payment.Payment;
import com.indepay.consumerapp.R;
import com.indepay.consumerapp.VolleyMethods;

/**
 * Created by Sharad on 27-04-2017.
 */

public class Welcome extends AppCompatActivity {

    RadioButton customerRadioBtn,merchantRadioBtn;
    EditText nameCardHolderId,numberCardHolderId,vpaCardHolderId;
    TextView termsandConditions;
    Button activateMyAccBtn;
    TextView textAlredyaMemberId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Welcome");

        nameCardHolderId = (EditText) findViewById(R.id.nameCardHolderId);
        numberCardHolderId = (EditText) findViewById(R.id.numberCardHolderId);
        vpaCardHolderId = (EditText) findViewById(R.id.vpaCardHolderId);

//        customerRadioBtn = (RadioButton)findViewById(R.id.radioCustomerId);
//        merchantRadioBtn = (RadioButton)findViewById(R.id.radioMerchantId);
//        customerRadioBtn.setChecked(false);
//        merchantRadioBtn.setChecked(false);
//
//        customerRadioBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                merchantRadioBtn.setChecked(false);
//
//            }
//        });
//        merchantRadioBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                customerRadioBtn.setChecked(false);
//
//            }
//        });

        termsandConditions = (TextView) findViewById(R.id.texttermsandConditionsId);
        termsandConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        activateMyAccBtn = (Button)findViewById(R.id.activateMyAccountBtnId);
        activateMyAccBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                VolleyMethods.registerCustomer(Welcome.this,nameCardHolderId.getText().toString(),numberCardHolderId.getText().toString(),vpaCardHolderId.getText().toString());
                Intent intent = new Intent(Welcome.this,MyProfile.class);
                intent.putExtra("customerName",nameCardHolderId.getText().toString());
                intent.putExtra("customerPhone",numberCardHolderId.getText().toString());
                intent.putExtra("customerVpa",vpaCardHolderId.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        textAlredyaMemberId = (TextView)findViewById(R.id.textAlredyaMemberId);
        textAlredyaMemberId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this,WelcomeBack.class);
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

}