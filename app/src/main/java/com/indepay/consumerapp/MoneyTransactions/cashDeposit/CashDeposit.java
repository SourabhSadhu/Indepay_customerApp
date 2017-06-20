package com.indepay.consumerapp.MoneyTransactions.cashDeposit;

import android.app.Dialog;
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
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.indepay.consumerapp.HelperClass.AgentInfo;
import com.indepay.consumerapp.R;
import com.indepay.consumerapp.VolleyMethods;

import java.util.ArrayList;


public class CashDeposit extends AppCompatActivity{
    ListView cashDepositList;
    public static ArrayList<CashDepositBean> listCashDeposit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cash_deposit);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Cash Deposit");

        cashDepositList =(ListView) findViewById(R.id.listViewId);

        listCashDeposit.add(new CashDepositBean("YES BANK","287368746287","Pitampura,Rohini,New Delhi"));
        listCashDeposit.add(new CashDepositBean("SBI BANK","654646545455","Rajendra Place,New Delhi"));
        listCashDeposit.add(new CashDepositBean("DENA BANK","797821545477","Laxmi Nagar,New Delhi"));

        CashDepositAdapter adapter = new CashDepositAdapter(getApplication());
        cashDepositList.setAdapter(adapter);

        cashDepositList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                EnerAmountForDeposit(position);
            }
        });
    }

    Dialog enerAmountForDepositPopUp = null;
        public void EnerAmountForDeposit(int pos) {

            if (enerAmountForDepositPopUp != null && enerAmountForDepositPopUp.isShowing())
            return;

        enerAmountForDepositPopUp = new Dialog(CashDeposit.this);
        enerAmountForDepositPopUp.requestWindowFeature(Window.FEATURE_NO_TITLE);
        enerAmountForDepositPopUp.setContentView(R.layout.enter_amount_for_deposit_pop_up);

            final EditText enterAmount = (EditText)enerAmountForDepositPopUp.findViewById(R.id.enterAmountId);
            final TextView serviceCharge = (TextView)enerAmountForDepositPopUp.findViewById(R.id.editServiceChargeId);
            final TextView totalAmountToHandover = (TextView)enerAmountForDepositPopUp.findViewById(R.id.editTotalAmountToHandoverId);
            final Spinner spinnerFavAgent = (Spinner)enerAmountForDepositPopUp.findViewById(R.id.spinnerSelectFavouriteAgentId);

            serviceCharge.setText("50");
            totalAmountToHandover.setText("1000"+"+" +"50");
          Button requestAgentBtn = (Button)enerAmountForDepositPopUp.findViewById(R.id.requestAgentBtnId);

            ArrayList<String> listFavAgent = new ArrayList<String>();
            listFavAgent.add("Vijay Kumar");
            listFavAgent.add("Mohan");
            listFavAgent.add("Munesh");
            CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(CashDeposit.this,listFavAgent);
            spinnerFavAgent.setAdapter(adapter);
        requestAgentBtn.setOnClickListener(new View.OnClickListener() {

                                     @Override
                                     public void onClick(View v) {
                                         VolleyMethods.sendAddress(CashDeposit.this);
                                         /*Intent intent = new Intent(CashDeposit.this,CashPickUpTracking.class);
                                         intent.putExtra("agentInfo",agentInfo);
                                         startActivity(intent);*/
                                         enerAmountForDepositPopUp.dismiss();

                                     }
                                 });
            enerAmountForDepositPopUp.show();
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
            TextView txt = new TextView(CashDeposit.this);
            txt.setPadding(13, 13, 13, 13);
            txt.setTextSize(17);
            txt.setGravity(Gravity.LEFT);
            txt.setTextAppearance(CashDeposit.this, R.style.RedHUGEText);
            txt.setText(asr.get(position));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            TextView txt = new TextView(CashDeposit.this);
            txt.setGravity(Gravity.CENTER_HORIZONTAL);
            txt.setPadding(0, 0, 12, 0);
            txt.setTextSize(17);
            txt.setTextAppearance(CashDeposit.this, R.style.RedHUGEText);
            txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dwn_aro, 0);
            txt.setText(asr.get(i));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }
    }
}
