package com.indepay.consumerapp.savedCards;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.indepay.consumerapp.R;

import java.util.ArrayList;

/**
 * Created by Vinod Sharma on 5/1/2017.
 */

public class SavedCards extends AppCompatActivity {
    ListView listView;
    Button addACardBtn;
    public static ArrayList<SavedCardsBean> savedcardList = new ArrayList<SavedCardsBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_cards);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Saved Cards");

        listView = (ListView)findViewById(R.id.savedCardsListViewId);
        savedcardList.add(new SavedCardsBean("ICICI Debit Card","31654654"));
        savedcardList.add(new SavedCardsBean("Axis Bank Creadit Card","75565"));
        savedcardList.add(new SavedCardsBean("HDFC Shopping Card","5436477"));
        savedcardList.add(new SavedCardsBean("SBI Debit Card","6357474"));
        savedcardList.add(new SavedCardsBean("Yes Bank Card","7473756"));
        savedcardList.add(new SavedCardsBean("DBS Card","75756756756"));

        SavedCardsAdapter adapter = new SavedCardsAdapter(SavedCards.this);
        listView.setAdapter(adapter);

        addACardBtn = (Button)findViewById(R.id.addACardBtnId);
        addACardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCardPopUp();


            }
        });

    }

    Dialog AddCardPopUpDialog= null;
    public void AddCardPopUp() {

        if (AddCardPopUpDialog != null && AddCardPopUpDialog.isShowing())
            return;

        AddCardPopUpDialog = new Dialog(SavedCards.this);
        AddCardPopUpDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        AddCardPopUpDialog.setContentView(R.layout.add_card_popup);
        Button proceedBtn = (Button)AddCardPopUpDialog.findViewById(R.id.proceedBtnId);
        Button cancelBtn = (Button)AddCardPopUpDialog.findViewById(R.id.cancelBtnId);
        TextView textTitle = (TextView)AddCardPopUpDialog.findViewById(R.id.titleId);



        proceedBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SavedCards.this,AddCard.class);
                startActivity(intent);
                    AddCardPopUpDialog.dismiss();

                }


        });


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCardPopUpDialog.dismiss();
            }
        });
        AddCardPopUpDialog.show();
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
