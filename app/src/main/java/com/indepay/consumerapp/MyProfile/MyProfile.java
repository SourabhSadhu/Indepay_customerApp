package com.indepay.consumerapp.MyProfile;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.indepay.consumerapp.HelperClass.CustomerInfo;
import com.indepay.consumerapp.HomeActivity;
import com.indepay.consumerapp.R;
import com.indepay.consumerapp.VolleyMethods;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Sharad on 27-04-2017.
 */

public class MyProfile extends AppCompatActivity {

    EditText countryCode;
    EditText mobileNo;
    EditText name;
    EditText aadharNo;
    static EditText dateofBirth;
    EditText email;
    Spinner gender;
    Button currentAddressDetail,BankDetailsAddBtn;
    Button entertBtn;
    Button updateDetailsBtnId;
    public static Context mcontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Profile");
        mcontext = this;

        final ScrollView scrollView = (ScrollView)findViewById(R.id.scrollViewId);

        countryCode = (EditText)findViewById(R.id.countryCodeNoId);
        mobileNo = (EditText)findViewById(R.id.mobNoId);
        name = (EditText)findViewById(R.id.nameId);
        aadharNo = (EditText)findViewById(R.id.adharNoId);
        dateofBirth = (EditText)findViewById(R.id.editDobId);
        email = (EditText)findViewById(R.id.emailId);
        updateDetailsBtnId = (Button)findViewById(R.id.updateDetailsBtnId);
        BankDetailsAddBtn = (Button)findViewById(R.id.BankDetailsAddBtn);
        name.setText(getIntent().getStringExtra("customerName"));
        mobileNo.setText(getIntent().getStringExtra("customerPhone"));
        aadharNo.setText(getIntent().getStringExtra("aadharNo"));
        dateofBirth.setText(getIntent().getStringExtra("dateofBirth"));
        email.setText(getIntent().getStringExtra("email"));

        entertBtn = (Button)findViewById(R.id.setBtnId);

        gender = (Spinner)findViewById(R.id.spinnerGenderId);

        currentAddressDetail = (Button)findViewById(R.id.currentAddressAddBtn);
        currentAddressDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyProfile.this,CurrentAddress.class);
                intent.putExtra("customerName",getIntent().getStringExtra("customerName"));
                intent.putExtra("customerPhone",getIntent().getStringExtra("customerPhone"));
                intent.putExtra("aadharNo",aadharNo.getText().toString());
                intent.putExtra("dateofBirth",dateofBirth.getText().toString());
                intent.putExtra("email",email.getText().toString());
                intent.putExtra("aadharNo",aadharNo.getText().toString());
                startActivity(intent);
            }
        });


        email.setOnTouchListener(new View.OnTouchListener() {
                                     @Override
                                     public boolean onTouch(View v, MotionEvent event) {

                                         scrollView.smoothScrollTo(0, email.getTop());
                                         scrollView.post(new Runnable() {
                                                             @Override
                                                             public void run() {
                                                                 email.requestFocus();
                                                             }
                                                         }
                                         );
                                         return false;
                                     }
                                 }
        );

        ArrayList<String> listGender = new ArrayList<String>();
        listGender.add("Male");
        listGender.add("Female");
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(MyProfile.this,listGender);
        gender.setAdapter(adapter);


        entertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnterPin();
            }
        });

        BankDetailsAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyProfile.this, BankAccountDetail.class);
                intent.putExtra("customerName",getIntent().getStringExtra("customerName"));
                intent.putExtra("customerPhone",getIntent().getStringExtra("customerPhone"));
                intent.putExtra("aadharNo",aadharNo.getText().toString());
                intent.putExtra("dateofBirth",dateofBirth.getText().toString());
                intent.putExtra("email",email.getText().toString());
                intent.putExtra("aadharNo",aadharNo.getText().toString());
                startActivity(intent);
            }
        });

        updateDetailsBtnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(aadharNo.getText().toString().equals("") && dateofBirth.getText().toString().equals("") && email.getText().toString().equals(""))
                {

                   // Toast.makeText(mcontext, "Please Fill Detail", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(MyProfile.this, HomeActivity.class));
                }
                else
                {
                    CustomerInfo customerInfo = new CustomerInfo();
                    customerInfo.setName(name.getText().toString());
                    customerInfo.setMobile(mobileNo.getText().toString());
                    customerInfo.setAadharno(aadharNo.getText().toString());
                    customerInfo.setDob(dateofBirth.getText().toString());
                    customerInfo.setEmail(email.getText().toString());
                    customerInfo.setGender(gender.getSelectedItem().toString());
                    customerInfo.setAddress(getIntent().getStringExtra("Address"));
                    customerInfo.setPin("1234");
                    //Toast.makeText(mcontext, "Not Completed", Toast.LENGTH_LONG).show();
                    VolleyMethods.updateProfile(MyProfile.this, customerInfo);
                }
            }
        });

        dateofBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getSupportFragmentManager(), "DatePicker");

            }
        });



        dateofBirth.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    dateofBirth.setGravity(Gravity.CENTER | Gravity.CENTER);

                } else {
                    dateofBirth.setGravity(Gravity.CENTER);
                }
            }
        });

    }


    Dialog enterPinDialog = null ;

    public static class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int yy = calendar.get(Calendar.YEAR);
            int mm = calendar.get(Calendar.MONTH);
            int dd = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog d = new DatePickerDialog(getActivity(), this, yy, mm, dd);
            //d.getDatePicker().setMinDate(calendar.getTimeInMillis());
            return d;
        }

        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm+1, dd);
        }
        public void populateSetDate(int year, int month, int day) {
            dateofBirth.setText(day+"-"+month+"-"+year);
        }

    }

    public void EnterPin() {

        if (enterPinDialog != null && enterPinDialog.isShowing())
            return;

        enterPinDialog = new Dialog(mcontext);
        enterPinDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        enterPinDialog.setContentView(R.layout.set_popup);
        Button okBtn = (Button)enterPinDialog.findViewById(R.id.okBtnId);
        Button cancelBtn = (Button)enterPinDialog.findViewById(R.id.cancelBtnId);
        TextView textTitle = (TextView)enterPinDialog.findViewById(R.id.titleId);

        final EditText enterPin = (EditText)enterPinDialog.findViewById(R.id.entereditId);
        final EditText reenterPin = (EditText)enterPinDialog.findViewById(R.id.reentereditId);


        okBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(enterPin.getText().toString().equals(reenterPin.getText().toString()))
                {
                    String pin = enterPin.getText().toString();
                    String repin = reenterPin.getText().toString();
                    enterPinDialog.dismiss();

                }
                else
                {
                    Toast.makeText(mcontext,"Please Check Your Pin",Toast.LENGTH_LONG).show();
                    enterPinDialog.show();
                }
            }
        });


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterPinDialog.dismiss();
            }
        });
        enterPinDialog.show();
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
            TextView txt = new TextView(MyProfile.this);
            txt.setPadding(13, 13, 13, 13);
            txt.setTextSize(17);
            txt.setGravity(Gravity.LEFT);
            txt.setTextAppearance(MyProfile.this, R.style.RedHUGEText);
            txt.setText(asr.get(position));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }

        public View getView(int i, View view, ViewGroup viewgroup) {
            TextView txt = new TextView(MyProfile.this);
            txt.setGravity(Gravity.CENTER_HORIZONTAL);
            txt.setPadding(0, 0, 12, 0);
            txt.setTextSize(17);
            txt.setTextAppearance(MyProfile.this, R.style.RedHUGEText);
            txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.dwn_aro, 0);
            txt.setText(asr.get(i));
            txt.setTextColor(Color.parseColor("#000000"));
            return txt;
        }
    }


}
