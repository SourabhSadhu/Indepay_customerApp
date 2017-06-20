package com.indepay.consumerapp.MyBeneficiaries;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.indepay.consumerapp.MyAgents.MyAgents;
import com.indepay.consumerapp.MyAgents.MyAgentsAdapter;
import com.indepay.consumerapp.MyAgents.MyAgentsBean;
import com.indepay.consumerapp.R;

import java.util.ArrayList;

/**
 * Created by Vinod Sharma on 5/3/2017.
 */

public class MyBeneficiaries extends AppCompatActivity {
    ListView myBeneficiariesListView;

    public static ArrayList<MyBeneficiariesBean> myBeneficiariesList = new ArrayList<MyBeneficiariesBean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_beneficiaries);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("MY BENEFICIARIES");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setTitle("MY BENEFICIARIES");

        myBeneficiariesListView = (ListView) findViewById(R.id.myBeneficiariesListViewId);

        myBeneficiariesList.add(new MyBeneficiariesBean("Deepak Gangwar", "SBI", "SBIN00056"));
        myBeneficiariesList.add(new MyBeneficiariesBean("NoBody", "YES", "YES65465"));
        myBeneficiariesList.add(new MyBeneficiariesBean("Perfect", "OBC", "OBC626326"));
        myBeneficiariesList.add(new MyBeneficiariesBean("Vikas Kumar", "HDFC", "HDFC4564465"));
        myBeneficiariesList.add(new MyBeneficiariesBean("Mohan Singh", "IDBI", "IDBI654654"));

        MyBeneficiariesAdapter adapter = new MyBeneficiariesAdapter(MyBeneficiaries.this);
        myBeneficiariesListView.setAdapter(adapter);

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
