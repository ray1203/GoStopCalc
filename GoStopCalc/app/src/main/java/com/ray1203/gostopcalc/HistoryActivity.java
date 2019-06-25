package com.ray1203.gostopcalc;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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

        arrayList.add(new ListViewItem(1,2,3,4,5,6,7,true,false,true,false,true,false,true,false,true,false));
        arrayList.add(new ListViewItem());
        arrayList.add(new ListViewItem());
        final ListViewAdapter adapter;
        adapter=new ListViewAdapter();
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
}
