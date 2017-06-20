package com.indepay.consumerapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.indepay.consumerapp.LoginProcess.WelcomeBack;
import com.indepay.consumerapp.MoneyTransactions.cashDelivery.CashDelivery;
import com.indepay.consumerapp.MoneyTransactions.cashDeposit.CashDeposit;
import com.indepay.consumerapp.MoneyTransactions.mobileTopUp.MobileTopUp;
import com.indepay.consumerapp.MoneyTransactions.recieveMoney.RecieveMoney;
import com.indepay.consumerapp.MoneyTransactions.sendMoney.SendMoney;
import com.indepay.consumerapp.MyAgents.MyAgents;
import com.indepay.consumerapp.MyBeneficiaries.MyBeneficiaries;
import com.indepay.consumerapp.MyTransactions.MyTransactions;
import com.indepay.consumerapp.Notification.LiveNotification;
import com.indepay.consumerapp.Settings.Settings;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    LinearLayout cashDeposit, cashDelivery,sendMoney,receiveMoney,mobileTopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        initNavigationDrawer();
    }

    public void init(){
        cashDeposit = (LinearLayout) findViewById(R.id.llcashDeposit);
        cashDelivery = (LinearLayout) findViewById(R.id.llcashDelivery);
        sendMoney = (LinearLayout) findViewById(R.id.llsendMoney);
        receiveMoney = (LinearLayout) findViewById(R.id.llreceiveMoney);
        mobileTopUp = (LinearLayout) findViewById(R.id.llmobileTopUp);
        cashDeposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CashDeposit.class));
            }
        });
        cashDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CashDelivery.class));
            }
        });
        sendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SendMoney.class));
            }
        });
        receiveMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, RecieveMoney.class));
            }
        });
        mobileTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, MobileTopUp.class));
            }
        });
    }

    public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.myTransactionsId:
                        Intent intent1 = new Intent(HomeActivity.this,MyTransactions.class);
                        startActivity(intent1);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.myBeneficiariesId:
                        Intent intent2 = new Intent(HomeActivity.this,MyBeneficiaries.class);
                        startActivity(intent2);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.notificationsId:
                        Intent intent3 = new Intent(HomeActivity.this,LiveNotification.class);
                        startActivity(intent3);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.myFavouriteAgent:
                        Intent intent4 = new Intent(HomeActivity.this,MyAgents.class);
                        startActivity(intent4);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.inviteId:
                        Intent intent5 = new Intent(HomeActivity.this,Invite.class);
                        startActivity(intent5);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.settingsId:
                        Intent intent6 = new Intent(HomeActivity.this,Settings.class);
                        startActivity(intent6);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.aboutId:
                        Intent intent7 = new Intent(HomeActivity.this,ContactUs.class);
                        startActivity(intent7);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logoutId:
                        Intent intent8 = new Intent(HomeActivity.this,WelcomeBack.class);
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
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close){

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
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
