package com.ray1203.gostopcalc;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordListViewAdapter extends BaseAdapter {
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

    public  ArrayList<ListViewItem> getItems(){return listViewItemList;}
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        parentContext=context;
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
                DBHelper helper = new DBHelper(context);
                    SQLiteDatabase db=helper.getReadableDatabase();
                    ListViewItem item=listViewItemList.get(position);
                String sql="insert into gostop_data(score,go,pi,ddi,kkeut,bomb,gwang," +
                        "bi,chung_dan,hong_dan,cho_dan,pi_bak,gwang_bak,mung_bak," +
                        "godori,mungtungguri,nagari) values ("+item.getScore()+","+item.getGo()+","+item.getPi()+","+item.getDdi()+","+item.getKkeut()+","
                        +item.getBomb()+","+item.getGwang()+","+boolToInt(item.isBi())+","+boolToInt(item.isChung_dan())+","+boolToInt(item.isHong_dan())+","+boolToInt(item.isCho_dan())+","
                        +boolToInt(item.isPi_bak())+","+boolToInt(item.isGwang_bak())+","+boolToInt(item.isMung_bak())+","+boolToInt(item.isGodori())+","+boolToInt(item.isMungtungguri())+","
                        +boolToInt(item.isNagari())+")";
                    db.execSQL(sql);



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
    public void saveAll(){
        DBHelper helper = new DBHelper(parentContext);

        for(int i=0;i<listViewItemList.size();i++){
            SQLiteDatabase db=helper.getReadableDatabase();
            ListViewItem item=listViewItemList.get(i);
            String sql="insert into gostop_data(score,go,pi,ddi,kkeut,bomb,gwang," +
                    "bi,chung_dan,hong_dan,cho_dan,pi_bak,gwang_bak,mung_bak," +
                    "godori,mungtungguri,nagari) values ("+item.getScore()+","+item.getGo()+","+item.getPi()+","+item.getDdi()+","+item.getKkeut()+","
                    +item.getBomb()+","+item.getGwang()+","+boolToInt(item.isBi())+","+boolToInt(item.isChung_dan())+","+boolToInt(item.isHong_dan())+","+boolToInt(item.isCho_dan())+","
                    +boolToInt(item.isPi_bak())+","+boolToInt(item.isGwang_bak())+","+boolToInt(item.isMung_bak())+","+boolToInt(item.isGodori())+","+boolToInt(item.isMungtungguri())+","
                    +boolToInt(item.isNagari())+")";
            db.execSQL(sql);
        }
    }
    public int boolToInt(boolean b){
        if(b)return 1;
        return 0;
    }
}
