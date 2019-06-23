package com.ray1203.gostopcalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {
    EditText go,pi,di,kkeut,bomb,light;
    CheckBox bi,blue_dan,red_dan,cho_dan,pi_bak,light_bak,mung_bak,dori,guri,gari;
    Button calc,CHECK_RECORDS,CHECK_HISTORY,reset,toMain;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        go = findViewById(R.id.go);
        pi=findViewById(R.id.pi);
        di=findViewById(R.id.di);
        kkeut=findViewById(R.id.kkeut);
        bomb=findViewById(R.id.bomb);
        light=findViewById(R.id.light);
        bi=findViewById(R.id.bi);
        blue_dan=findViewById(R.id.blue_dan);
        red_dan=findViewById(R.id.red_dan);
        cho_dan=findViewById(R.id.cho_dan);
        pi_bak=findViewById(R.id.pi_bak);
        light_bak=findViewById(R.id.light_bak);
        mung_bak=findViewById(R.id.mung_bak);
        dori = findViewById(R.id.dori);
        guri=findViewById(R.id.guri);
        gari=findViewById(R.id.gari);
        calc=findViewById(R.id.calc);
        CHECK_RECORDS=findViewById(R.id.CHECK_RECORDS);
        CHECK_HISTORY = findViewById(R.id.CHECK_HISTORY);
        reset=findViewById(R.id.reset);
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
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                go.setText(null);
                pi.setText(null);
                di.setText(null);
                kkeut.setText(null);
                bomb.setText(null);
                light.setText(null);
                bi.setChecked(false);
                blue_dan.setChecked(false);
                red_dan.setChecked(false);
                cho_dan.setChecked(false);
                pi_bak.setChecked(false);
                light_bak.setChecked(false);
                mung_bak.setChecked(false);
                dori.setChecked(false);
                guri.setChecked(false);
                gari.setChecked(false);
                score.setText("000점 입니다.");
            }
        });

    }
}
