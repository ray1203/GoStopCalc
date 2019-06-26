package com.ray1203.gostopcalc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CalcActivity extends AppCompatActivity {
    EditText go,pi,ddi,kkeut,bomb,gwang;
    CheckBox bi,chung_dan,hong_dan,cho_dan,
            pi_bak,gwang_bak,mung_bak,
            godori,mungtungguri,nagari;
    Button calc,CHECK_RECORDS,CHECK_HISTORY,RESET,toMain;
    TextView score;
    int result=0;
    public ArrayList<ListViewItem> arrayList;
    public static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        arrayList = new ArrayList<>();
        go = findViewById(R.id.go);
        pi=findViewById(R.id.pi);
        ddi=findViewById(R.id.ddi);
        kkeut=findViewById(R.id.kkeut);
        bomb=findViewById(R.id.bomb);
        gwang=findViewById(R.id.gwang);
        bi=findViewById(R.id.bi);

        chung_dan=findViewById(R.id.chung_dan);
        hong_dan=findViewById(R.id.hong_dan);
        cho_dan=findViewById(R.id.cho_dan);

        pi_bak=findViewById(R.id.pi_bak);
        gwang_bak=findViewById(R.id.gwang_bak);
        mung_bak=findViewById(R.id.mung_bak);

        godori = findViewById(R.id.godori);
        mungtungguri=findViewById(R.id.mungtungguri);
        nagari=findViewById(R.id.nagari);

        calc=findViewById(R.id.calc);
        CHECK_RECORDS=findViewById(R.id.CHECK_RECORDS);
        CHECK_HISTORY = findViewById(R.id.CHECK_HISTORY);
        RESET=findViewById(R.id.RESET);
        toMain = findViewById(R.id.toMain);

        score =findViewById(R.id.score);

        toMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CalcActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        RESET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go.setText(null);
                pi.setText(null);
                ddi.setText(null);
                kkeut.setText(null);
                bomb.setText(null);
                gwang.setText(null);
                bi.setChecked(false);

                chung_dan.setChecked(false);
                hong_dan.setChecked(false);
                cho_dan.setChecked(false);

                pi_bak.setChecked(false);
                gwang_bak.setChecked(false);
                mung_bak.setChecked(false);

                godori.setChecked(false);
                mungtungguri.setChecked(false);
                nagari.setChecked(false);

                score.setText("000점 입니다.");
            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result=0;
                result+=(editTextToInt(go)+
                        plus(editTextToInt(pi)-9)+
                        plus(editTextToInt(ddi)-4)+
                        plus(editTextToInt(kkeut)-4));//고,피,띠,열끗의 점수 합

                if(editTextToInt(gwang)==3){
                    if(bi.isChecked()){
                        result+=2;//비광:2점
                    }else{
                        result+=3;//3광:3점
                    }
                }else if(editTextToInt(gwang)==4){
                    result+=4;//4광:4점
                }else if(editTextToInt(gwang)==5){
                    result+=15;//5광:15점
                }

                if(chung_dan.isChecked()){
                    result+=3;//청단:3점
                }
                if(hong_dan.isChecked()){
                    result+=3;//홍단:3점
                }
                if(cho_dan.isChecked()){
                    result+=3;//초단:3점
                }

                if(godori.isChecked()){
                    result+=5;//고도리:5점
                }

                if(pi_bak.isChecked()){
                    result*=2;//피박:2배
                }
                if(gwang_bak.isChecked()){
                    result*=2;//광박:2배
                }
                if(mung_bak.isChecked()){
                    result*=2;//멍박:2배
                }

                for(int i=0;i<editTextToInt(bomb);i++){
                    result*=2;//흔들기/폭탄:횟수만큼 2배
                }
                if(mungtungguri.isChecked()){
                    result*=2;//멍텅구리:2배
                }
                if(nagari.isChecked()){
                    result*=2;//전판 나가리:2배
                }
                for(int i=0;i<editTextToInt(go)-2;i++){
                    result*=2;//3고부터 1고마다 2배
                }

                if(result!=0){
                    score.setText(result+"점 입니다.");
                    //
                }
                else
                    Toast.makeText(CalcActivity.this, "점수가 없습니다.", Toast.LENGTH_SHORT).show();
                arrayList.add(new ListViewItem(result,editTextToInt(go),editTextToInt(pi),editTextToInt(ddi),editTextToInt(kkeut),editTextToInt(bomb),editTextToInt(gwang),bi.isChecked(),chung_dan.isChecked(),hong_dan.isChecked(),cho_dan.isChecked(),pi_bak.isChecked(),gwang_bak.isChecked(),mung_bak.isChecked(),godori.isChecked(),mungtungguri.isChecked(),nagari.isChecked()));
            }
        });
        CHECK_RECORDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CalcActivity.this,RecordActivity.class);
                i.putExtra("list",arrayList);
                startActivityForResult(i,0);
            }
        });
        CHECK_HISTORY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CalcActivity.this,HistoryActivity.class);
                startActivity(i);
            }
        });
    }
    public int plus(int insert){
        if(insert<0)return 0;
        return insert;
    }
    public int editTextToInt(EditText e){
        try{
            return Integer.parseInt(e.getText().toString());
        }catch (Exception e1){
            return 0;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        arrayList.clear();
        arrayList.addAll((ArrayList<ListViewItem>)data.getSerializableExtra("list"));
    }
    @Override public void onBackPressed() { }
}
