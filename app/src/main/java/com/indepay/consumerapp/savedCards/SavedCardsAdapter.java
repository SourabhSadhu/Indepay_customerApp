package com.indepay.consumerapp.savedCards;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.indepay.consumerapp.R;


public class SavedCardsAdapter extends BaseAdapter {

    Context context;
    ImageButton deleteBtn;

    public SavedCardsAdapter(Context context) {
        this.context =context;

    }

    private static class ViewHolder {
        TextView cardName,cardNo;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return SavedCards.savedcardList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return SavedCards.savedcardList.get(position);
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
            convertView = inflater.inflate(R.layout.saved_cards_adapter, null);
            holder = new ViewHolder();

            holder.cardName = (TextView) convertView.findViewById(R.id.textCardNameId);
            holder.cardNo = (TextView) convertView.findViewById(R.id.textCardNoId);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();

        }
        holder.cardName.setText(SavedCards.savedcardList.get(position).getCardName());
        holder.cardNo.setText(SavedCards.savedcardList.get(position).getCardNo());

//            dbadapter = new DatabaseAdapter(context);


        deleteBtn = (ImageButton) convertView.findViewById(R.id.deleteBtnId);
//            deleteBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    dbadapter.deleteNotification(notificatonList.get(position).dbId);
//                    notificatonList.remove(position);
//                    notifyDataSetChanged();
//                }
//            });


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

