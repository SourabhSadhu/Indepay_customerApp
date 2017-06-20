package com.indepay.consumerapp.MoneyTransactions.cashDeposit;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.indepay.consumerapp.R;

public class CashDepositAdapter extends BaseAdapter {
    Context context;

    public CashDepositAdapter(Context context) {
        this.context =context;
        this.notifyDataSetChanged();

    }

    private static class ViewHolder {
        TextView bankName,accNumber,branchAddress;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return CashDeposit.listCashDeposit.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return CashDeposit.listCashDeposit.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        // TODO Auto-generated method stub
        final ViewHolder holder;
        final int positionFinal = position+1;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.cash_deposit_adapter, null);
            holder = new ViewHolder();

            holder.bankName = (TextView) convertView.findViewById(R.id.textBankNameId);
            holder.accNumber = (TextView) convertView.findViewById(R.id.textAccNumberId);
            holder.branchAddress = (TextView) convertView.findViewById(R.id.textBranchAddressId);

            convertView.setTag(holder);
        }

        else
        {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.bankName.setText(CashDeposit.listCashDeposit.get(position).getBankName());
        holder.accNumber.setText(CashDeposit.listCashDeposit.get(position).getAccNumber());
        holder.branchAddress.setText(CashDeposit.listCashDeposit.get(position).getBranchAddress());


        return convertView;
    }

}
