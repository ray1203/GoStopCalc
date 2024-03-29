package com.ray1203.gostopcalc;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecordActivity extends AppCompatActivity {
Button tocal,deleteAll,saveAll;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        tocal=findViewById(R.id.toCal);
        deleteAll=findViewById(R.id.deleteAll);
        saveAll=findViewById(R.id.save);
        listView = findViewById(R.id.listView);
        final ArrayList<ListViewItem> arrayList = new ArrayList<>();
        Intent intent = getIntent();

        arrayList.addAll((ArrayList<ListViewItem>) intent.getExtras().getSerializable("list"));
        final RecordListViewAdapter adapter = new RecordListViewAdapter();
        listView.setAdapter(adapter);
        for(int i=0;i<arrayList.size();i++)
            adapter.addItem(arrayList.get(i));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListViewItem item = (ListViewItem) adapterView.getItemAtPosition(i) ;

                Intent intent = new Intent(RecordActivity.this,CalcShowActivity.class);
                intent.putExtra("list",item);
                startActivity(intent);
            }
        });
        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.size()==0)
                    Toast.makeText(RecordActivity.this, "데이터가 없습니다.", Toast.LENGTH_SHORT).show();
                else{
                    AlertDialog.Builder alert_confirm = new AlertDialog.Builder(RecordActivity.this);
                    alert_confirm.setMessage("모든 기록을 삭제하시겠습니까?")
                            .setCancelable(false).setPositiveButton("확인",
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
            }
        });
        saveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(arrayList.size()==0)
                    Toast.makeText(RecordActivity.this, "데이터가 없습니다.", Toast.LENGTH_SHORT).show();
                else
                    adapter.saveAll();
            }
        });
        tocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                data.putExtra("list",adapter.getItems());
                setResult(0,data);
                finish();
            }
        });
    }
    @Override public void onBackPressed() { }
}
