package com.indepay.consumerapp.MyAgents;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.indepay.consumerapp.R;


public class MyAgentsAdapter extends BaseAdapter {

    Context context;
    Button call,delete;


    public MyAgentsAdapter(Context context) {
        this.context =context;

    }

    private static class ViewHolder {
        TextView agentName,agentAddress,agentMobileNo;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return MyAgents.myAgentsList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return MyAgents.myAgentsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.my_agents_adapter, null);
            holder = new ViewHolder();

            holder.agentName = (TextView) convertView.findViewById(R.id.editAgentNameId);
            holder.agentAddress = (TextView) convertView.findViewById(R.id.editAgentAddressId);
            holder.agentMobileNo = (TextView) convertView.findViewById(R.id.editAgentMobNo);




            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.agentName.setText(MyAgents.myAgentsList.get(position).getAgentName());
        holder.agentAddress.setText(MyAgents.myAgentsList.get(position).getAgentAddress());
        holder.agentMobileNo.setText("(" + MyAgents.myAgentsList.get(position).getAgentMobileNo()+ ")");



        call = (Button)convertView.findViewById(R.id.callBtnId);
        delete = (Button)convertView.findViewById(R.id.deleteBtnId);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // dbadapter.deleteNotification(notificatonList.get(position).dbId);
                    try {
                        MyAgents.myAgentsList.remove(position);
                        Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });

         call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    return;
                }
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String agentMobileNo = MyAgents.myAgentsList.get(position).getAgentMobileNo();
                callIntent.setData(Uri.parse("tel:" +agentMobileNo));
                MyAgents.mcontext.startActivity(callIntent);
            }

            });

        return convertView;
    }

}

