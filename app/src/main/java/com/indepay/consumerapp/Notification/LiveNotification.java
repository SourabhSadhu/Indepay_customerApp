package com.indepay.consumerapp.Notification;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import com.indepay.consumerapp.R;

import java.util.ArrayList;


public class LiveNotification extends AppCompatActivity
{

    ListView notificationListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Notifications");
        //dbadapter = new DatabaseAdapter(this);

        notificationListView = (ListView) findViewById(R.id.RecyclerViewNotificationsId);

        ArrayList<NotificationBean> getNotificationList = new ArrayList<NotificationBean>();
        getNotificationList.add(new NotificationBean("Offer","28/04/2017","Install App to earn Talktime."));
        getNotificationList.add(new NotificationBean("Alert","29/04/2017","Suspicious"));
        getNotificationList.add(new NotificationBean("Reward","29/04/2017","Special Offer"));




        NotificationAdapter adapter = new NotificationAdapter(this,getNotificationList);
        notificationListView.setAdapter(adapter);



//        notificationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
//                String posID = cursor.getString(0);
//                int getID = Integer.parseInt(posID);
//
//                Database_TT db = new Database_TT(DeleteTT.this);
//
//                db.deleteEntry(getID);
//
//            }
//        });
        }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}