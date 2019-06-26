package com.ray1203.gostopcalc;

import java.io.Serializable;

public class ListViewItem implements Serializable {
    private int score,go,
                pi,ddi,kkeut,bomb,gwang,_ID;
    private boolean bi,chung_dan,hong_dan,cho_dan,
                    pi_bak,gwang_bak,mung_bak,
                    godori,mungtungguri,nagari;

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int sc) {
        score=sc;
    }

    public int getGo(){ return go; }

    public ListViewItem() {
        score=0;go=0;pi=0;ddi=0;kkeut=0;bomb=0;gwang=0;
        bi=false;chung_dan=false;hong_dan=false;cho_dan=false;
        pi_bak=false;gwang_bak=false;mung_bak=false;
        godori=false;mungtungguri=false;nagari=false;

    }

    public ListViewItem(int score, int go, int pi, int ddi, int kkeut, int bomb, int gwang, boolean bi, boolean chung_dan, boolean hong_dan, boolean cho_dan, boolean pi_bak, boolean gwang_bak, boolean mung_bak, boolean godori, boolean mungtungguri, boolean nagari) {
        this.score = score;
        this.go = go;
        this.pi = pi;
        this.ddi = ddi;
        this.kkeut = kkeut;
        this.bomb = bomb;
        this.gwang = gwang;

        this.bi = bi;
        this.chung_dan = chung_dan;
        this.hong_dan = hong_dan;
        this.cho_dan = cho_dan;
        this.pi_bak = pi_bak;
        this.gwang_bak = gwang_bak;
        this.mung_bak = mung_bak;
        this.godori = godori;
        this.mungtungguri = mungtungguri;
        this.nagari = nagari;
    }
    public ListViewItem(int score, int go, int pi, int ddi, int kkeut, int bomb, int gwang, boolean bi, boolean chung_dan, boolean hong_dan, boolean cho_dan, boolean pi_bak, boolean gwang_bak, boolean mung_bak, boolean godori, boolean mungtungguri, boolean nagari,int _ID) {
        this.score = score;
        this.go = go;
        this.pi = pi;
        this.ddi = ddi;
        this.kkeut = kkeut;
        this.bomb = bomb;
        this.gwang = gwang;

        this.bi = bi;
        this.chung_dan = chung_dan;
        this.hong_dan = hong_dan;
        this.cho_dan = cho_dan;
        this.pi_bak = pi_bak;
        this.gwang_bak = gwang_bak;
        this.mung_bak = mung_bak;
        this.godori = godori;
        this.mungtungguri = mungtungguri;
        this.nagari = nagari;
        this._ID=_ID;
    }
    public void setGo(int g) {
        go=g;
    }


    public int getPi() { return pi; }
    public void setPi(int pi) { this.pi = pi; }

    public int getDdi() { return ddi; }
    public void setDdi(int ddi) { this.ddi = ddi; }

    public int getKkeut() { return kkeut; }
    public void setKkeut(int kkeut) { this.kkeut = kkeut; }

    public int getBomb() { return bomb; }
    public void setBomb(int bomb) { this.bomb = bomb; }

    public int getGwang() { return gwang; }
    public void setGwang(int gwang) { this.gwang = gwang; }


    public boolean isBi() { return bi; }
    public void setBi(boolean bi) { this.bi = bi; }

    public boolean isChung_dan() { return chung_dan; }
    public void setChung_dan(boolean chung_dan) { this.chung_dan = chung_dan; }

    public boolean isHong_dan() { return hong_dan; }
    public void setHong_dan(boolean hong_dan) { this.hong_dan = hong_dan; }

    public boolean isCho_dan() { return cho_dan; }
    public void setCho_dan(boolean cho_dan) { this.cho_dan = cho_dan; }


    public boolean isPi_bak() { return pi_bak; }
    public void setPi_bak(boolean pi_bak) { this.pi_bak = pi_bak; }

    public boolean isGwang_bak() { return gwang_bak; }
    public void setGwang_bak(boolean gwang_bak) { this.gwang_bak = gwang_bak; }

    public boolean isMung_bak() { return mung_bak; }
    public void setMung_bak(boolean mung_bak) { this.mung_bak = mung_bak; }


    public boolean isGodori() { return godori; }
    public void setGodori(boolean godori) { this.godori = godori; }

    public boolean isMungtungguri() { return mungtungguri; }
    public void setMungtungguri(boolean mungtungguri) { this.mungtungguri = mungtungguri; }

    public boolean isNagari() { return nagari; }
    public void setNagari(boolean nagari) { this.nagari = nagari; }
}
