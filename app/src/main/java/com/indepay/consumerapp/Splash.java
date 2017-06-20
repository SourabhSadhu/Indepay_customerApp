package com.indepay.consumerapp;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.indepay.consumerapp.LoginProcess.VerifyMobileNo;
import com.indepay.consumerapp.LoginProcess.WelcomeBack;

public class Splash extends Activity {


    AVLoadingIndicatorView progressBar;
    final int MY_PERMISSIONS_REQUEST_READ_STATE = 101;
    String email;
    String pwd;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    public static int trackingTeam = 0;
    public static boolean isMyTrackingOn = false;
    public static String trackingFrom, trackingTo;
    public static int sendMyLocationAfterEveryChangeInMeters = 500;
    public static boolean canViewTeamLocation = false;
    public static int sendLocationAfterInMins = 5;

    public static String holidayForTracking = "";
    public static int writeLocationToFile = 0;
    public static String messageToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.splash);



        // progressBar = (AVLoadingIndicatorView) findViewById(R.id.indicator);
//        email = tDb.getString(Constant.mobile);
//        pwd = tDb.getString(Constant.pwd);

//        Intent intent = new Intent(this, RegistrationIntentService.class);
//        startService(intent);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run()
            {
               Intent intent =new Intent(Splash.this,VerifyMobileNo.class);
               //Intent intent =new Intent(Splash.this,WelcomeBack.class);
                startActivity(intent);
                finish();

               // init();
            }
        }, 3000);


    }

//    public void init()
//    {
//        if (checkPlayServices()) {
//            // Start IntentService to register this application with GCM.
//            Intent intent = new Intent(this, RegistrationIntentService.class);
//            startService(intent);
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            checkPermission();
//        }
//        else
//        {
//            gps=new GPSTracker(Splash.this);
//            if(!gps.canGetLocation()) {
//                gps.showSettingsAlert();
//            }else
//            {
//                if(!email.equals("") && !pwd.equals("")) {
//                    Home.userId = Integer.parseInt(tDb.getString(Constant.userId));
//                    Home.myname  = tDb.getString(Constant.name);
//
//                    Intent i = new Intent(Splash.this, Home.class);
//                    startActivity(i);
//                    finish();
////                    if (CommonFunction.haveNetworkConnection(Splash.this)) {
////                        //getAppData();
////                    }else {
////                        Intent i = null;
////                        if(tDb.getString(Constant.loginType).equals("6"))
////                            i = new Intent(Splash.this, com.sunstrike.fos.HomePage.class);
////                        else
////                            i = new Intent(Splash.this, com.sunstrike.fos.BranchHomePage.class);
////
////
////                        startActivity(i);
////                        finish();
////                    }
//                }else
//                {
//                    Intent i = new Intent(Splash.this, LoginActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }
//        }
//    }
//    public void checkPermission()
//    {
//        if (ContextCompat.checkSelfPermission(Splash.this,
//                Manifest.permission.READ_PHONE_STATE)
//                != PackageManager.PERMISSION_GRANTED  || ContextCompat.checkSelfPermission(Splash.this,
//                Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED ||  ContextCompat.checkSelfPermission(Splash.this,
//                Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED ||  ContextCompat.checkSelfPermission(Splash.this,
//                Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED ||  ContextCompat.checkSelfPermission(Splash.this,
//                Manifest.permission.CALL_PHONE)
//                != PackageManager.PERMISSION_GRANTED) {
//
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.READ_PHONE_STATE)) {
//
//                gps=new GPSTracker(Splash.this);
//                if(!gps.canGetLocation()) {
//                    gps.showSettingsAlert();
//                }else {
//
//                    if (!email.equals("") && !pwd.equals("")) {
//                        Home.userId = Integer.parseInt(tDb.getString(Constant.userId));
//                        Home.myname  = tDb.getString(Constant.name);
//                        Intent i = new Intent(Splash.this, Home.class);
//                        startActivity(i);
//                        finish();
////                        if (CommonFunction.haveNetworkConnection(Splash.this))
////                            getAppData();
////                        else {
////                            Intent i = new Intent(Splash.this, com.sunstrike.fos.HomePage.class);
////                            startActivity(i);
////                            finish();
////                        }
//                    } else {
//                        Intent i = new Intent(Splash.this, LoginActivity.class);
//                        startActivity(i);
//                        finish();
//                    }
//                }
//
//            }
//            else if (ActivityCompat.shouldShowRequestPermissionRationale(this,
//                    Manifest.permission.ACCESS_FINE_LOCATION)) {
//
//                if(!email.equals("") && !pwd.equals("")) {
//                    Home.userId = Integer.parseInt(tDb.getString(Constant.userId));
//                    Home.myname  = tDb.getString(Constant.name);
//                    Intent i = new Intent(Splash.this, Home.class);
//                    startActivity(i);
//                    finish();
//                    if (CommonFunction.haveNetworkConnection(Splash.this))
//                        getAppData();
//                    else {
//                        Intent i = null;
//                        if(tDb.getString(Constant.loginType).equals("6"))
//                            i = new Intent(Splash.this, com.sunstrike.fos.HomePage.class);
//                        else
//                            i = new Intent(Splash.this, com.sunstrike.fos.BranchHomePage.class);
//
//
//                        startActivity(i);
//                        finish();
//                    }
//                }else
//                {
//                    Intent i = new Intent(Splash.this, LoginActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }
//            else {
//                ActivityCompat.requestPermissions(this,
//                        new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                        MY_PERMISSIONS_REQUEST_READ_STATE);
//                Log.e("", "");
//
//            }
//        }else
//        {
//            gps=new GPSTracker(Splash.this);
//            if(!gps.canGetLocation()) {
//                gps.showSettingsAlert();
//            }else {
//                if (!email.equals("") && !pwd.equals("")) {
//                    Home.userId = Integer.parseInt(tDb.getString(Constant.userId));
//                    Home.myname  = tDb.getString(Constant.name);
//                    Intent i = new Intent(Splash.this, Home.class);
//                    startActivity(i);
//                    finish();
////                    if (CommonFunction.haveNetworkConnection(Splash.this))
////                        getAppData();
////                    else {
////                        Intent i = null;
////                        if(tDb.getString(Constant.loginType).equals("6"))
////                            i = new Intent(Splash.this, com.sunstrike.fos.HomePage.class);
////                        else
////                            i = new Intent(Splash.this, com.sunstrike.fos.BranchHomePage.class);
////
////                        startActivity(i);
////                        finish();
////                    }
//                } else {
//                    Intent i = new Intent(Splash.this, LoginActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }
//        }
//
//    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode,
//                                           String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case MY_PERMISSIONS_REQUEST_READ_STATE: {
//                // If request is cancelled, the result arrays are empty.
//                gps=new GPSTracker(Splash.this);
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    if(!gps.canGetLocation()) {
//                        gps.showSettingsAlert();
//                    }else
//                    {
//                        double lat = gps.getLatitude();
//                        double lon = gps.getLongitude();
//
//                        tDb.putDouble(Constant.lattitude, lat);
//                        tDb.putDouble(Constant.longitude, lon);
//
//                        if(!email.equals("") && !pwd.equals("")) {
//                            Home.userId = Integer.parseInt(tDb.getString(Constant.userId));
//                            Home.myname  = tDb.getString(Constant.name);
//                            Intent i = new Intent(Splash.this, Home.class);
//                            startActivity(i);
//                            finish();
////                            if (CommonFunction.haveNetworkConnection(Splash.this))
////                                getAppData();
////                            else {
////
////                                if(tDb.getString(Constant.loginType).equals("6"))
////                                    i = new Intent(Splash.this, com.sunstrike.fos.HomePage.class);
////                                else
////                                    i = new Intent(Splash.this, com.sunstrike.fos.BranchHomePage.class);
////
////
////                                startActivity(i);
////                                finish();
////                            }
//                        }else
//                        {
//                            Intent i = new Intent(Splash.this, LoginActivity.class);
//                            startActivity(i);
//                            finish();
//                        }
//
//                    }
//                }else
//                {
//                    if(!email.equals("") && !pwd.equals("")) {
//                        Home.userId = Integer.parseInt(tDb.getString(Constant.userId));
//                        Home.myname  = tDb.getString(Constant.name);
//                        Intent i = new Intent(Splash.this, Home.class);
//                        startActivity(i);
//                        finish();
//                        if (CommonFunction.haveNetworkConnection(Splash.this))
//                            getAppData();
//                        else {
//                            Intent i = null;
//                            if(tDb.getString(Constant.loginType).equals("6"))
//                                i = new Intent(Splash.this, com.sunstrike.fos.HomePage.class);
//                            else
//                                i = new Intent(Splash.this, com.sunstrike.fos.BranchHomePage.class);
//
//
//                            startActivity(i);
//                            finish();
//                        }
//                    }else
//                    {
//                        Intent i = new Intent(Splash.this, LoginActivity.class);
//                        startActivity(i);
//                        finish();
//                    }
//
//                }
//            }
//
//        }
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        // TODO Auto-generated method stub
//
//        if(requestCode == 1000){
//
//            GPSTracker  gps1=new GPSTracker(Splash.this);
//            if (resultCode == RESULT_OK){
//
//                double lat = gps1.getLatitude();
//                double lon = gps1.getLongitude();
//
//                tDb.putDouble(Constant.lattitude, lat);
//                tDb.putDouble(Constant.longitude, lon);
//
//                if(!email.equals("") && !pwd.equals("")) {
//                    Home.userId = Integer.parseInt(tDb.getString(Constant.userId));
//                    Home.myname  = tDb.getString(Constant.name);
//                    Intent i = new Intent(Splash.this, Home.class);
//                    startActivity(i);
//                    finish();
////                    if (CommonFunction.haveNetworkConnection(Splash.this))
////                        getAppData();
////                    else {
////                        Intent i = null;
////                        if(tDb.getString(Constant.loginType).equals("6"))
////                            i = new Intent(Splash.this, com.sunstrike.fos.HomePage.class);
////                        else
////                            i = new Intent(Splash.this, com.sunstrike.fos.BranchHomePage.class);
////
////
////                        startActivity(i);
////                        finish();
////                    }
//                }else
//                {
//                    Intent i = new Intent(Splash.this, LoginActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }else if(resultCode == RESULT_CANCELED){
//
//                double lat = gps1.getLatitude();
//                double lon = gps1.getLongitude();
//
//                tDb.putDouble(Constant.lattitude, lat);
//                tDb.putDouble(Constant.longitude, lon);
//
//                if(!email.equals("") && !pwd.equals("")) {
//                    Home.userId = Integer.parseInt(tDb.getString(Constant.userId));
//                    Home.myname  = tDb.getString(Constant.name);
//                    Intent i = new Intent(Splash.this, Home.class);
//                    startActivity(i);
//                    finish();
//                    if (CommonFunction.haveNetworkConnection(Splash.this))
//                        getAppData();
//                    else {
//                        Intent i = null;
//                        if(tDb.getString(Constant.loginType).equals("6"))
//                            i = new Intent(Splash.this, com.sunstrike.fos.HomePage.class);
//                        else
//                            i = new Intent(Splash.this, com.sunstrike.fos.BranchHomePage.class);
//
//
//                        startActivity(i);
//                        finish();
//                    }
//                }else
//                {
//                    Intent i = new Intent(Splash.this, LoginActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }
//
//        }
//
//    }

//    public void getAppData()
//    {
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                if (email.equals("") || pwd.equals("")) {
//                    Intent i = new Intent(Splash.this, LoginActivity.class);
//                    startActivity(i);
//                    finish();
//                } else {
//                    Home.userId = Integer.parseInt(tDb.getString(Constant.userId));
//                    Home.myname  = tDb.getString(Constant.name);
//                    Intent i = new Intent(Splash.this, Home.class);
//                    startActivity(i);
//                    finish();
//                    //new MyAppData().execute();
//                }
//
//            }
//        }, 3000);
//    }


//    class MyAppData extends AsyncTask<String, Void, String>
//    {
//        protected void onPreExecute() {
//            super.onPreExecute();
//            progressBar.setVisibility(View.VISIBLE);
//        }
//
//        @Override
//        protected String doInBackground(String... lang) {
//            String res = "";
//            try {
//
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("user_id", tDb.getString(Constant.userId));
//                params.put("login_type_id", tDb.getString(Constant.loginType));
//                params.put("gcm_id", tDb.getString(Constant.gcmId));
//
//                res = ServerInterface.myAppData(UrlConfig.mMyAppData, params, dbadapter, tDb);
//
//            } catch (Exception e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//            return res;
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            progressBar.setVisibility(View.INVISIBLE);
//            if(!result.equals("fail") && !result.equals(""))
//            {
//                Intent i = new Intent(Splash.this, Home.class);
////                if(tDb.getString(Constant.loginType).equals("6"))
////                    i = new Intent(Splash.this, com.sunstrike.fos.HomePage.class);
////                else
////                    i = new Intent(Splash.this, com.sunstrike.fos.BranchHomePage.class);
//
//
//                startActivity(i);
//                finish();
//            }
//        }
//
//    }
//    private boolean checkPlayServices() {
//        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
//        int result = googleAPI.isGooglePlayServicesAvailable(this);
//        if (result != ConnectionResult.SUCCESS) {
//            if (googleAPI.isUserResolvableError(result)) {
//                googleAPI.getErrorDialog(this, result,
//                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
//            }
//
//            return false;
//        }
//
//        return true;
//    }

//    public void SendMessageToActivity(int msg)
//    {
//        Message m = new Message();
//        m.what = msg;
//        updateHandler.sendMessage(m);
//    }
//
//    public Handler updateHandler = new Handler() {
//
//        // @Override
//        public void handleMessage(NotificationCompat.MessagingStyle.Message msg) {
//
//            int event = msg.what;
//            switch (event) {
//                case 100:
//                    finish();
//                    if(!mobileNo.equals("") && !pwd.equals("")) {
//                        if (CommonFunction.haveNetworkConnection(Splash.this)) {
//
//                        }else {
//                            //Toast.makeText(this,"No Internet Connection", Toast.LENGTH_LONG).show();
//                            Intent i = new Intent(Splash.this, Home.class);
//                            startActivity(i);
//                            finish();
//                        }
//                        getAppData();
//                    }else
//                    {
//                        Intent i = new Intent(Splash.this, LoginActivity.class);
//                        startActivity(i);
//                        finish();
//                    }
            }



