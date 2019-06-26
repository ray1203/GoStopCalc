package com.ray1203.gostopcalc;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
Button tore,deleteAll;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        DBHelper helper = new DBHelper(this);
        listView = findViewById(R.id.listView);
        final ArrayList<ListViewItem> arrayList = new ArrayList<>();//DB에서 값 저장->전부 어댑터에 추가
        tore=findViewById(R.id.toRe);
        deleteAll=findViewById(R.id.deleteAll);
        tore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final SQLiteDatabase db=helper.getWritableDatabase();
        String sql="select * from gostop_data";
        Cursor cursor=db.rawQuery(sql,null);
        cursor.moveToFirst();
        try{
            do{
                arrayList.add(new ListViewItem(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),
                        cursor.getInt(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),
                        cursor.getInt(7)>0,cursor.getInt(8)>0,cursor.getInt(9)>0,cursor.getInt(10)>0,
                        cursor.getInt(11)>0,cursor.getInt(12)>0,cursor.getInt(13)>0,cursor.getInt(14)>0,
                        cursor.getInt(15)>0,cursor.getInt(16)>0,cursor.getInt(17)));
            }
            while(cursor.moveToNext());
        }catch (Exception e){
            db.execSQL("DROP TABLE gostop_data");
        }


//        arrayList.add(new ListViewItem(1,2,3,4,5,6,7,true,false,true,false,true,false,true,false,true,false));
//        arrayList.add(new ListViewItem());
//        arrayList.add(new ListViewItem());
        final HistoryListViewAdapter adapter;
        adapter=new HistoryListViewAdapter();
        listView.setAdapter(adapter);
        for(int i=0;i<arrayList.size();i++){
            adapter.addItem(arrayList.get(i));
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListViewItem item = (ListViewItem) adapterView.getItemAtPosition(i) ;

                Intent intent = new Intent(HistoryActivity.this,CalcShowActivity.class);
                intent.putExtra("list",item);
                startActivity(intent);
            }
        });
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert_confirm = new AlertDialog.Builder(HistoryActivity.this);
                alert_confirm.setMessage("모든 기록을 삭제하시겠습니까?").setCancelable(false).setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrayList.clear();
                                adapter.deleteAll();
                                db.execSQL("delete from gostop_data");
                            }
                        }).setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                return;
                            }
                        });
                AlertDialog alert = alert_confirm.create();
                alert.show();
            }
        });
    }
    @Override public void onBackPressed() { }
}
