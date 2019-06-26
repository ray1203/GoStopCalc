package com.ray1203.gostopcalc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class CalcShowActivity extends AppCompatActivity {
    EditText go,pi,ddi,kkeut,bomb,gwang;
    CheckBox bi,chung_dan,hong_dan,cho_dan,
            pi_bak,gwang_bak,mung_bak,
            godori,mungtungguri,nagari;
    Button back;
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_show);

        go = findViewById(R.id.go);
        pi = findViewById(R.id.pi);
        ddi = findViewById(R.id.ddi);
        kkeut = findViewById(R.id.kkeut);
        bomb = findViewById(R.id.bomb);
        gwang = findViewById(R.id.gwang);
        bi = findViewById(R.id.bi);

        chung_dan = findViewById(R.id.chung_dan);
        hong_dan = findViewById(R.id.hong_dan);
        cho_dan = findViewById(R.id.cho_dan);

        pi_bak = findViewById(R.id.pi_bak);
        gwang_bak = findViewById(R.id.gwang_bak);
        mung_bak = findViewById(R.id.mung_bak);

        godori = findViewById(R.id.godori);
        mungtungguri = findViewById(R.id.mungtungguri);
        nagari = findViewById(R.id.nagari);

        back = findViewById(R.id.back);

        score = findViewById(R.id.score);
        ListViewItem listViewItem;
        listViewItem=(ListViewItem) getIntent().getSerializableExtra("list");
        Log.e(listViewItem.getBomb()+"","");
        go.setText(Integer.toString(listViewItem.getGo()));
        pi.setText(Integer.toString(listViewItem.getPi()));
        ddi.setText(Integer.toString(listViewItem.getDdi()));
        kkeut.setText(Integer.toString(listViewItem.getKkeut()));
        bomb.setText(Integer.toString(listViewItem.getBomb()));
        gwang.setText(Integer.toString(listViewItem.getGwang()));
        bi.setChecked(listViewItem.isBi());
        chung_dan.setChecked(listViewItem.isChung_dan());
        hong_dan.setChecked(listViewItem.isHong_dan());
        cho_dan.setChecked(listViewItem.isCho_dan());
        pi_bak.setChecked(listViewItem.isPi_bak());
        gwang_bak.setChecked(listViewItem.isGwang_bak());
        mung_bak.setChecked(listViewItem.isMung_bak());
        godori.setChecked(listViewItem.isGodori());
        mungtungguri.setChecked(listViewItem.isMungtungguri());
        nagari.setChecked(listViewItem.isNagari());
        score.setText(listViewItem.getScore()+"점 입니다.");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
    @Override public void onBackPressed() { }
}
