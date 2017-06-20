package com.indepay.consumerapp.MyAgents;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import com.indepay.consumerapp.R;

import java.util.ArrayList;

/**
 * Created by Vinod Sharma on 5/1/2017.
 */

public class MyAgents extends AppCompatActivity {
    public static Context mcontext;
    public static MyAgentsAdapter myAgentsAdpter;
    public static ArrayList<MyAgentsBean> myAgentsList = new ArrayList<MyAgentsBean>();
    ListView myAgentsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_agents);

        mcontext = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Agents");
        myAgentsListView = (ListView) findViewById(R.id.myAgentsListViewId);

        myAgentsList.add(new MyAgentsBean("Deepak Gangwar", "gduwqhiwqgduiwqdgi", "7530946909"));
        myAgentsList.add(new MyAgentsBean("NoBody", "htyjtt", "8885968653"));
        myAgentsList.add(new MyAgentsBean("Perfect", "bhth", "7852356985"));
        myAgentsList.add(new MyAgentsBean("Vikas Kumar", "egrhrh", "9985685635"));
        myAgentsList.add(new MyAgentsBean("Mohan Singh", "rjntrjktju", "9932535864"));

        MyAgentsAdapter adapter = new MyAgentsAdapter(MyAgents.this);
        myAgentsListView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.meenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {

            //noinspection SimplifiableIfStatement
            case R.id.addAgentId:

                Intent intent = new Intent(MyAgents.this, AddAgent.class);
                startActivity(intent);
                return true;

            case android.R.id.home:
                finish();
                myAgentsList.clear();
                return true;

             default:
            return super.onOptionsItemSelected(item);
        }


    }
}
