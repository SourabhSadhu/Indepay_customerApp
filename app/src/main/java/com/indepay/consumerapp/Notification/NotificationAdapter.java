package com.indepay.consumerapp.Notification;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.indepay.consumerapp.R;

import java.util.ArrayList;


public class NotificationAdapter extends BaseAdapter{

    Context context;
    public ArrayList<NotificationBean> notificatonList;
    ImageButton deleteBtn;

    public NotificationAdapter(Context context,ArrayList<NotificationBean> notificatonList) {
            this.context =context;
             this.notificatonList=notificatonList;

        }

        private static class ViewHolder {
            TextView type,recievedOn,msgDetail;

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return notificatonList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return notificatonList.get(position);
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
                convertView = inflater.inflate(R.layout.notification_adapter, null);
                holder = new ViewHolder();

                holder.type = (TextView) convertView.findViewById(R.id.editTypeId);
                holder.recievedOn = (TextView) convertView.findViewById(R.id.editRecievedId);
                holder.msgDetail = (TextView) convertView.findViewById(R.id.editMessageId);


                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();

            }
            holder.type.setText(notificatonList.get(position).getType());
            holder.recievedOn.setText(notificatonList.get(position).getRecievedOn());
            holder.msgDetail.setText(notificatonList.get(position).getMsgDetail());

//            dbadapter = new DatabaseAdapter(context);


            deleteBtn = (ImageButton) convertView.findViewById(R.id.deleteBtnId);
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // dbadapter.deleteNotification(notificatonList.get(position).dbId);
                    notificatonList.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(context,"Deleted Successfully",Toast.LENGTH_LONG).show();
                }
            });


//    public void alertMessage() {
//        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                switch (which) {
//                    case DialogInterface.BUTTON_POSITIVE:
//                        // Yes button clicked
//                        Toast.makeText(context, "Yes Clicked", Toast.LENGTH_LONG).show();
//                        break;
//                    case DialogInterface.BUTTON_NEGATIVE:
//                        // No button clicked
//                        Toast.makeText(context, "No Clicked", Toast.LENGTH_LONG).show();
//                        break;
//                }
//            }
//        };
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener).setNegativeButton("No", dialogClickListener).show();
//    }

                return convertView;
        }

        }

