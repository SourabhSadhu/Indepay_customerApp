package com.indepay.consumerapp.MyAgents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.indepay.consumerapp.R;


/**
 * Created by Vinod Sharma on 5/2/2017.
 */

public class AddAgent extends AppCompatActivity {
    EditText nameoOfAgent,agentId,agentMobileNoNo,nickName;
    Button sendOTPtoAgentBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_agent);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add Agent");

        MyAgents.myAgentsList.clear();

        nameoOfAgent = (EditText)findViewById(R.id.nameoOfAgentId);
        agentId = (EditText)findViewById(R.id.agentidId);
        agentMobileNoNo = (EditText)findViewById(R.id.agentMobileNoNoId);
        nickName = (EditText)findViewById(R.id.nickNameId);
        sendOTPtoAgentBtn = (Button) findViewById(R.id.sendOTPtoAgentBtnId);

        sendOTPtoAgentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(nameoOfAgent.getText().toString().equals("") || agentId.getText().toString().equals("")||agentMobileNoNo.getText().toString().equals("")||nickName.getText().toString().equals(""))
                {
                    Toast.makeText(AddAgent.this,"Please fill Detail",Toast.LENGTH_LONG).show();
                }
                else {
                    MyAgents.myAgentsList.add(new MyAgentsBean(nameoOfAgent.getText().toString(), agentId.getText().toString(), agentMobileNoNo.getText().toString()));
                    Intent intent = new Intent(AddAgent.this, MyAgents.class);
                    startActivity(intent);
                    //MyAgents.myAgentsAdpter.notifyDataSetChanged();

                    MyAgentsAdapter adapter = new MyAgentsAdapter(AddAgent.this);
                    adapter.notifyDataSetChanged();
                }
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
