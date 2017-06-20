package com.indepay.consumerapp.Settings;

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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.indepay.consumerapp.MoneyTransactions.cashDeposit.CashDeposit;
import com.indepay.consumerapp.MyProfile.MyProfile;
import com.indepay.consumerapp.R;
import com.indepay.consumerapp.savedCards.SavedCards;

import java.util.ArrayList;

public class Settings extends AppCompatActivity {

    de.hdodenhof.circleimageview.CircleImageView userImage;
    RelativeLayout rL4ChangeLanguage,rL2SavedCards,rL3FAQandContact,rL1Account;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Settings");

        userImage = (de.hdodenhof.circleimageview.CircleImageView)findViewById(R.id.circularImageId);
        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, MyProfile.class);
                startActivity(intent);
            }
        });

        rL2SavedCards = (RelativeLayout)findViewById(R.id.rL2);
        rL2SavedCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this, SavedCards.class);
                startActivity(intent);
            }
        });

        rL4ChangeLanguage = (RelativeLayout)findViewById(R.id.rL4);
        rL4ChangeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeLanguage();
            }
        });

        rL3FAQandContact = (RelativeLayout)findViewById(R.id.rL3);
        rL3FAQandContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this,FAQAndContact.class);
                startActivity(intent);
            }
        });

        rL1Account = (RelativeLayout)findViewById(R.id.rL1);
        rL1Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.this,SecuritySettings.class);
                startActivity(intent);
            }
        });

    }

    Dialog changeLanguageDialog = null;
    public void ChangeLanguage( ) {

        if (changeLanguageDialog != null && changeLanguageDialog.isShowing())
            return;

        changeLanguageDialog = new Dialog(Settings.this);
        changeLanguageDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        changeLanguageDialog.setContentView(R.layout.change_language_pop_up);


        final Spinner spinnerFavAgent = (Spinner)changeLanguageDialog.findViewById(R.id.spinnerSelectFavouriteAgentId);


        Button continueButton = (Button)changeLanguageDialog.findViewById(R.id.requestAgentBtnId);

        ArrayList<String> listLanguage = new ArrayList<String>();
        listLanguage.add("English");
        listLanguage.add("Hindi");
        listLanguage.add("Spanish");

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this,listLanguage);
        spinnerFavAgent.setAdapter(adapter);

        continueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                changeLanguageDialog.dismiss();
            }
        });
        changeLanguageDialog.show();
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
            TextView txt = new TextView(Settings.this);
            txt.setPadding(13, 13, 13, 13);
            txt.setTextSize(17);
            txt.setGravity(Gravity.LEFT);
            txt.setTextAppearance(Settings.this, R.style.RedHUGEText);
            txt.setText(asr.get(position));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            TextView txt = new TextView(Settings.this);
            txt.setGravity(Gravity.CENTER_HORIZONTAL);
            txt.setPadding(0, 0, 12, 0);
            txt.setTextSize(17);
            txt.setTextAppearance(Settings.this, R.style.RedHUGEText);
            txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dwn_aro, 0);
            txt.setText(asr.get(i));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }
    }
}
