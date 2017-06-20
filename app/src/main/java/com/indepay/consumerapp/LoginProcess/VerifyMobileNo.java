package com.indepay.consumerapp.LoginProcess;

import android.app.Application;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.util.CircularArray;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.indepay.consumerapp.ContactUs;
import com.indepay.consumerapp.Invite;
import com.indepay.consumerapp.MoneyTransactions.cashDelivery.CashDelivery;
import com.indepay.consumerapp.MoneyTransactions.cashDelivery.CashDeliveryTracking;
import com.indepay.consumerapp.MoneyTransactions.cashDeposit.CashDeposit;
import com.indepay.consumerapp.MoneyTransactions.mobileTopUp.MobileTopUp;
import com.indepay.consumerapp.MoneyTransactions.recieveMoney.RecieveMoney;
import com.indepay.consumerapp.MoneyTransactions.sendMoney.SendMoney;
import com.indepay.consumerapp.MyAgents.MyAgents;
import com.indepay.consumerapp.MyBeneficiaries.MyBeneficiaries;
import com.indepay.consumerapp.MyProfile.MyProfile;
import com.indepay.consumerapp.MyTransactions.MyTransactions;
import com.indepay.consumerapp.Notification.LiveNotification;
import com.indepay.consumerapp.R;
import com.indepay.consumerapp.Settings.Settings;
import com.indepay.consumerapp.VolleyMethods;
import com.indepay.consumerapp.savedCards.SavedCards;

public class VerifyMobileNo extends AppCompatActivity {
    Button sendSMS,signIn;
    Menu mainMenu=null;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
   CardView cardViewNavHeaderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_mobile_no);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*initNavigationDrawer();*/


//        cardViewNavHeaderId = (CardView) findViewById(R.id.cardViewNavHeaderId);
//        cardViewNavHeaderId.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(VerifyMobileNo.this, MyProfile.class);
//                startActivity(intent);
//            }
//        });


        sendSMS = (Button) findViewById(R.id.sendSMSBtnId);
        sendSMS.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
                Intent intent = new Intent(VerifyMobileNo.this,Welcome.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        signIn  =(Button)findViewById(R.id.signInBtnId);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               /* Intent intent = new Intent(VerifyMobileNo.this,WelcomeBack.class);
                startActivity(intent);*/
                VolleyMethods.sendAddress(VerifyMobileNo.this);
             /*   Intent launchIntent = getPackageManager().getLaunchIntentForPackage("indepay.revolution");
                if (launchIntent != null) {
                    launchIntent.putExtra("Name","Hey");
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }*/
            }
        });
    }

    /*public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.myTransactionsId:
                        Intent intent1 = new Intent(VerifyMobileNo.this,MyTransactions.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.myBeneficiariesId:
                        Intent intent2 = new Intent(VerifyMobileNo.this,MyBeneficiaries.class);
                        startActivity(intent2);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.notificationsId:
                        Intent intent3 = new Intent(VerifyMobileNo.this,LiveNotification.class);
                        startActivity(intent3);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.myFavouriteAgent:
                        Intent intent4 = new Intent(VerifyMobileNo.this,MyAgents.class);
                        startActivity(intent4);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.inviteId:
                        Intent intent5 = new Intent(VerifyMobileNo.this,Invite.class);
                        startActivity(intent5);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.settingsId:
                        Intent intent6 = new Intent(VerifyMobileNo.this,Settings.class);
                        startActivity(intent6);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.aboutId:
                        Intent intent7 = new Intent(VerifyMobileNo.this,ContactUs.class);
                        startActivity(intent7);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logoutId:
                        Intent intent8 = new Intent(VerifyMobileNo.this,WelcomeBack.class);
                        startActivity(intent8);
                        drawerLayout.closeDrawers();
                        break;

                }
                return true;
            }
        });

        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView)header.findViewById(R.id.tv_email);
        tv_email.setText("Johny  Depp");
        *//*drawerLayout = (DrawerLayout)findViewById(R.id.drawer);*//*

      *//*  ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View v){
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();*//*
    }
*/



   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.sendMoneyId:
                Intent intent = new Intent(VerifyMobileNo.this,SendMoney.class);
                startActivity(intent);
                return true;

            case R.id.recieveMoneyId:
                Intent intent1 = new Intent(VerifyMobileNo.this,RecieveMoney.class);
                startActivity(intent1);
                return true;

            case R.id.mobileTopUpId:
                Intent intent2 = new Intent(VerifyMobileNo.this,MobileTopUp.class);
                startActivity(intent2);
                return true;

            case R.id.cashDepositId:
                Intent intent3 = new Intent(VerifyMobileNo.this,CashDeposit.class);
                startActivity(intent3);
                return true;

            case R.id.cashDeliveryId:
                Intent intent4 = new Intent(VerifyMobileNo.this,CashDeliveryTracking.class);
                startActivity(intent4);
                return true;
//            case R.id.myAgentsId:
//                Intent intent5 = new Intent(VerifyMobileNo.this,MyAgents.class);
//                startActivity(intent5);
//                return true;
//            case R.id.notificationsID:
//                Intent intent7 = new Intent(VerifyMobileNo.this,LiveNotification.class);
//                startActivity(intent7);
//                return true;
//            case R.id.myTransactionsID:
//                Intent intent8 = new Intent(VerifyMobileNo.this,MyTransactions.class);
//                startActivity(intent8);
//                return true;
//            case R.id.mySettingsID:
//                Intent intent9 = new Intent(VerifyMobileNo.this,Settings.class);
//                startActivity(intent9);
//                return true;
//            case R.id.inviteID:
//                Intent intent10 = new Intent(VerifyMobileNo.this,Invite.class);
//                startActivity(intent10);
//                return true;
//            case R.id.aboutID:
//                Intent intent11 = new Intent(VerifyMobileNo.this,ContactUs.class);
//                startActivity(intent11);
//                return true;
//            case R.id.logoutID:
//                Intent intent12 = new Intent(VerifyMobileNo.this,WelcomeBack.class);
//                startActivity(intent12);
//                return true;
//
//            case R.id.myBeneficiariesID:
//                Intent intent13 = new Intent(VerifyMobileNo.this,MyBeneficiaries.class);
//                startActivity(intent13);
//                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        mainMenu=menu;
        return true; }


    //Menu press should open 3 dot menu
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_MENU) {
            return true; }
        return super.onKeyDown(keyCode, event); }
}