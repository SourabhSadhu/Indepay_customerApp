package com.indepay.consumerapp.MoneyTransactions.recieveMoney;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.indepay.consumerapp.LoginProcess.PickUpLocation;
import com.indepay.consumerapp.R;

/**
 * Created by Sharad on 28-04-2017.
 */

public class RecieveMoney  extends AppCompatActivity{

    Button requestMoneyRecieveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recieve_money);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Recieve Money");

        requestMoneyRecieveBtn = (Button)findViewById(R.id.requestMoneyRecieveBtnId);

        requestMoneyRecieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SuccessMsgRecieveMoney();
            }
        });

    }

    Dialog successMsgRecieveMoneyDialog =null;
    public void SuccessMsgRecieveMoney() {

        if (successMsgRecieveMoneyDialog != null && successMsgRecieveMoneyDialog.isShowing())
            return;

        successMsgRecieveMoneyDialog = new Dialog(RecieveMoney.this);
        successMsgRecieveMoneyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        successMsgRecieveMoneyDialog.setContentView(R.layout.recieve_money_pop_up);

        Button okBtn = (Button)successMsgRecieveMoneyDialog.findViewById(R.id.okBtnId);
        TextView textTitle = (TextView)successMsgRecieveMoneyDialog.findViewById(R.id.titleId);
        TextView fg = (TextView)successMsgRecieveMoneyDialog.findViewById(R.id.editSuccessMsgId);


        okBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(RecieveMoney.this, PickUpLocation.class);
                    startActivity(intent);
                    successMsgRecieveMoneyDialog.dismiss();

            }
        });


        successMsgRecieveMoneyDialog.show();
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
