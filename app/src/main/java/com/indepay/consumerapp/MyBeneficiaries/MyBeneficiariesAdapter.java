package com.indepay.consumerapp.MyBeneficiaries;

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

import com.indepay.consumerapp.MoneyTransactions.sendMoney.AddPayee;
import com.indepay.consumerapp.MyAgents.MyAgents;
import com.indepay.consumerapp.R;



public class MyBeneficiariesAdapter extends BaseAdapter {

    Context context;
    Button edit,delete;


    public MyBeneficiariesAdapter(Context context) {
        this.context =context;

    }

    private static class ViewHolder {
        TextView name,bankName,ifscCode;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return MyBeneficiaries.myBeneficiariesList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return MyBeneficiaries.myBeneficiariesList.get(position);
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
            convertView = inflater.inflate(R.layout.my_beneficiaries_adapter, null);
            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.editNameId);
            holder.bankName = (TextView) convertView.findViewById(R.id.editBankNameNo);
            holder.ifscCode = (TextView) convertView.findViewById(R.id.editIfscCodeId);




            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.name.setText(MyBeneficiaries.myBeneficiariesList.get(position).getName());
        holder.bankName.setText(MyBeneficiaries.myBeneficiariesList.get(position).getBankName());
        holder.ifscCode.setText( MyBeneficiaries.myBeneficiariesList.get(position).getIfscCode());



        edit = (Button)convertView.findViewById(R.id.editBtnId);
        delete = (Button)convertView.findViewById(R.id.deleteBtnId);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                MyBeneficiaries.myBeneficiariesList.remove(position);
                Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AddPayee.class);
                context.startActivity(intent);

            }

        });

        return convertView;
    }

}

