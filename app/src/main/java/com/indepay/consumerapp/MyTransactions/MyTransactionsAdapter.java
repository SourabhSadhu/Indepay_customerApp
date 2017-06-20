package com.indepay.consumerapp.MyTransactions;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.indepay.consumerapp.R;


public class MyTransactionsAdapter extends BaseAdapter {

    Context context;
        Button call,delete;


        public MyTransactionsAdapter(Context context) {
            this.context =context;

        }

        private static class ViewHolder {
            TextView TransactionType,TransactionDateAndTime,TransactionAmount;

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return MyTransactions.myTransactionsHistoryList.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return MyTransactions.myTransactionsHistoryList.get(position);
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
                convertView = inflater.inflate(R.layout.my_transactions_adapter, null);
                holder = new ViewHolder();

                holder.TransactionType = (TextView) convertView.findViewById(R.id.editTransactionTypeId);
                holder.TransactionDateAndTime = (TextView) convertView.findViewById(R.id.editTransactionDateAndTimeId);
                holder.TransactionAmount = (TextView) convertView.findViewById(R.id.editTransactionAmountId);




                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();

            }
            holder.TransactionType.setText(MyTransactions.myTransactionsHistoryList.get(position).getTransactionType());
            holder.TransactionDateAndTime.setText(MyTransactions.myTransactionsHistoryList.get(position).getTransactionDateAndTime());
            holder.TransactionAmount.setText( MyTransactions.myTransactionsHistoryList.get(position).getTransactionAmount());


            return convertView;
        }

    }

