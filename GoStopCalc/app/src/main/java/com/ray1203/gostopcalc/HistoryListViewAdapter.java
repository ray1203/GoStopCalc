package com.ray1203.gostopcalc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HistoryListViewAdapter extends BaseAdapter {
    private Context parentContext;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        parentContext=context;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.history_list_item, parent, false);
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

                DBHelper helper = new DBHelper(context);
                SQLiteDatabase db=helper.getReadableDatabase();
                String sql = "DELETE FROM gostop_data WHERE _ID = "+""+listViewItem.get_ID()+"";
                db.execSQL(sql);
                Toast.makeText(context, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }) ;
        return convertView;
    }
    public void addItem(ListViewItem listViewItem){
        listViewItemList.add(listViewItem);
    }
    public void deleteAll(){
        listViewItemList.clear();
        notifyDataSetChanged();
        Toast.makeText(parentContext, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
    }
}
