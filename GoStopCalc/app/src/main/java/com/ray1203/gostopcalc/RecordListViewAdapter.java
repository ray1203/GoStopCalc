package com.ray1203.gostopcalc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItemList=new ArrayList<>();
    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public  ArrayList<ListViewItem> getItems(){return listViewItemList;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.record_list_item, parent, false);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.txt);
        Button save = (Button) convertView.findViewById(R.id.save);
        Button delete = (Button) convertView.findViewById(R.id.delete);
        LinearLayout background = (LinearLayout)convertView.findViewById(R.id.background);
        final ListViewItem listViewItem = listViewItemList.get(position);

        textView.setText(listViewItem.getScore()+"점 "+listViewItem.getGo()+"고 ");
        delete.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                listViewItemList.remove(pos);
                notifyDataSetChanged();
            }
        }) ;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return convertView;
    }
    public void addItem(ListViewItem listViewItem){
        listViewItemList.add(listViewItem);
    }
    public void deleteAll(){
        listViewItemList.clear();
        notifyDataSetChanged();
    }
}
