package com.indepay.consumerapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.indepay.consumerapp.HelperClass.AgentInfo;
import com.indepay.consumerapp.HelperClass.CustomerInfo;
import com.indepay.consumerapp.MoneyTransactions.cashDeposit.CashDeposit;
import com.indepay.consumerapp.MoneyTransactions.cashDeposit.CashPickUpTracking;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 5/18/2017.
 */

public class VolleyMethods {

    public static ArrayList<CustomerInfo> list = new ArrayList<>();
    public static JSONObject authBody = new JSONObject();
    public static JSONObject reqBody = new JSONObject();
    public static JSONObject tranBody = new JSONObject();
    public static AgentInfo agentInfo = new AgentInfo();
    public static void commonValues() {
        authBody = new JSONObject();
        try {
            authBody.put("applicationkey", "0x1ff10000000001");
            authBody.put("ts_sys", "050632344343434565432123");
            authBody.put("imei", "3423423424242");
            authBody.put("indepayid", "1010000001");
            authBody.put("app_version", "342423423");
            authBody.put("os_version", "3434");
            authBody.put("ip_address", "192.168.1.212");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        reqBody = new JSONObject();
        try {
            reqBody.put("req_token", "3243245643");
            reqBody.put("req_type", "23");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void registerCustomer(Context context, String name, String mobile, String vpa) {
        commonValues();
        final String url = "http://192.168.1.80/cLogistic/device/RegisterNewCustomer?cmd=";
        try {
            tranBody.put("name", name);
            tranBody.put("mobile", mobile);
            tranBody.put("vpa", vpa);
            tranBody.put("deviceid", "djfh6dh");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonBody = new JSONObject();
        try {
           /* jsonBody.put("Authentication", authBody);
            jsonBody.put("RequestDetails", reqBody);*/
            jsonBody.put("TransactionData", tranBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url + jsonBody,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.e("String", response);
                            JSONObject arr = new JSONObject(response);
                            /*JSONArray resp = arr.getJSONArray("MappedSubAgentDetails");
                            JSONObject obj;
                            Log.e("String",resp.toString());
                            for(int i=0;i<resp.length();i++) {
                                CustomerInfo mappedISLInfo = new CustomerInfo();
                                obj = resp.getJSONObject(i);
                                mappedISLInfo.setIndepayId(obj.getString("indepayId"));
                                mappedISLInfo.setBalance(obj.getString("balance"));
                                mappedISLInfo.setsAgentLong(obj.getString("sAgentLong"));
                                mappedISLInfo.setsAgentLat(obj.getString("sAgentLat"));
                                list.add(mappedISLInfo);
                            }
                            for(int j=0;j<list.size();j++) {
                                Log.e("Indepayid", list.get(j).getsAgentLat());
                            }*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

        // ApplicationController.getInstance().addToRequestQueue(req);
    }

    public static AgentInfo sendAddress(final Context context) {
        commonValues();
        final String url = "http://192.168.1.80/cLogistic/device/CreateTransaction?cmd=";
        try {
            tranBody.put("latitude", "2990.48849");
            tranBody.put("longitude", "8485.4389543");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonBody = new JSONObject();
        try {
         /*   jsonBody.put("Authentication", authBody);
            jsonBody.put("RequestDetails", reqBody);*/
            jsonBody.put("TransactionData", tranBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url + jsonBody,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.e("String", response);
                            JSONObject arr = new JSONObject(response);
                            //JSONArray resp = arr.getJSONArray("MappedSubAgentDetails");
                            //JSONObject obj;
                            Log.e("String", arr.toString());
                                Log.e("agemt",arr.getString("agentId"));
                                if((arr.getString("statusTransaction")).equals("1")) {
                                    agentInfo.setAgentId(arr.getString("agentId"));
                                    agentInfo.setAgentName(arr.getString("agentName"));
                                    agentInfo.setLatitude(arr.getString("latitude"));
                                    agentInfo.setLongitude(arr.getString("longitude"));
                                    agentInfo.setMobile(arr.getString("mobile"));

                            }
                            /*for (int j = 0; j < list.size(); j++) {
                                Log.e("Indepayid", list.get(j).getsAgentLat());
                            }*/
                            Intent intent = new Intent(context,CashPickUpTracking.class);
                            intent.putExtra("agentInfo",agentInfo);
                            context.startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

        // ApplicationController.getInstance().addToRequestQueue(req);
        return agentInfo;
    }

    public static void updateProfile(Context context, CustomerInfo customerInfo) {
        commonValues();
        final String url = "http://192.168.1.80/cLogistic/device/profileDemo?cmd=";
        try {
            tranBody.put("name", customerInfo.getName());
            tranBody.put("mobile", customerInfo.getMobile());
            tranBody.put("aadhaar", customerInfo.getAadharno());
            tranBody.put("dob", customerInfo.getDob());
            tranBody.put("gender", customerInfo.getGender());
            tranBody.put("email", customerInfo.getEmail());
            tranBody.put("pin", "1234");
            tranBody.put("add1", "Gurugram,Harayana,India");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonBody = new JSONObject();
        try {
           /* jsonBody.put("Authentication", authBody);
            jsonBody.put("RequestDetails", reqBody);*/
            jsonBody.put("TransactionData", tranBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url + jsonBody,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.e("String", response);
                            JSONObject arr = new JSONObject(response);
                            /*JSONArray resp = arr.getJSONArray("MappedSubAgentDetails");
                            JSONObject obj;
                            Log.e("String",resp.toString());
                            for(int i=0;i<resp.length();i++) {
                                CustomerInfo mappedISLInfo = new CustomerInfo();
                                obj = resp.getJSONObject(i);
                                mappedISLInfo.setIndepayId(obj.getString("indepayId"));
                                mappedISLInfo.setBalance(obj.getString("balance"));
                                mappedISLInfo.setsAgentLong(obj.getString("sAgentLong"));
                                mappedISLInfo.setsAgentLat(obj.getString("sAgentLat"));
                                list.add(mappedISLInfo);
                            }
                            for(int j=0;j<list.size();j++) {
                                Log.e("Indepayid", list.get(j).getsAgentLat());
                            }*/
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

        // ApplicationController.getInstance().addToRequestQueue(req);
    }

    public static void selectSubAgent(Context context) {

        final String url = "http://202.134.193.53/cLogistic/selectSubAgent?cmd=";
        try {
            tranBody.put("indepaysubagenttid", "9876543210");
            tranBody.put("transactionrefno", "9876543219876543");
            tranBody.put("indepayislid", "9876543210");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("Authentication", authBody);
            jsonBody.put("RequestDetails", reqBody);
            jsonBody.put("TransactionData", tranBody);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final StringRequest stringRequest = new StringRequest(Request.Method.POST, url + jsonBody,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       /* try {
                            Log.e("String", response);
                          *//*  JSONObject arr = new JSONObject(response);
                            JSONArray resp = arr.getJSONArray("Sub Agent Details");
                            JSONObject obj;*//*
                           // Log.e("String", resp.toString());
                          *//*  for (int i = 0; i < resp.length(); i++) {
                                CustomerInfo customerInfo = new CustomerInfo();
                                obj = resp.getJSONObject(i);
                                customerInfo.setIndepayId(obj.getString("indepayId"));
                                customerInfo.setBalance(obj.getString("balance"));
                                customerInfo.setsAgentLong(obj.getString("sAgentLong"));
                                customerInfo.setsAgentLat(obj.getString("sAgentLat"));
                                list.add(customerInfo);
                            }
                            for (int j = 0; j < list.size(); j++) {
                                Log.e("Indepayid", list.get(j).getsAgentLat());
                            }*//*
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }*/

                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                return hashMap;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

    }
}
