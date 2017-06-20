package com.indepay.consumerapp.MyTransactions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.indepay.consumerapp.MyAgents.MyAgentsBean;
import com.indepay.consumerapp.R;

import java.util.ArrayList;


public class MyTransactions extends AppCompatActivity {

    ListView myTransactionsListView;
    public static ArrayList<MyTransactionsBean> myTransactionsHistoryList = new ArrayList<MyTransactionsBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_transactions);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Transaction History");

        myTransactionsListView = (ListView)findViewById(R.id.myTransactionsListViewId);


        myTransactionsHistoryList.add(new MyTransactionsBean("Cash PickUp","25th April","10000"));
        myTransactionsHistoryList.add(new MyTransactionsBean("Cash Deposit","26th April","58632"));
        myTransactionsHistoryList.add(new MyTransactionsBean("Sent Money","27th April","70000"));
        myTransactionsHistoryList.add(new MyTransactionsBean("Mobile Top Up","28th April","455"));
        myTransactionsHistoryList.add(new MyTransactionsBean("Recieved Money","29th April","250000"));
        myTransactionsHistoryList.add(new MyTransactionsBean("Failed Order","30th April","18000000"));


        MyTransactionsAdapter adapter = new MyTransactionsAdapter(MyTransactions.this);
        myTransactionsListView.setAdapter(adapter);

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
