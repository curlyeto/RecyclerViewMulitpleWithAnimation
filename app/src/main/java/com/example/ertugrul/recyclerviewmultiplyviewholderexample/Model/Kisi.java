package com.example.ertugrul.recyclerviewmultiplyviewholderexample.Model;

public class Kisi {
    private String name;
    private int resim;
    private int yas;

    public Kisi() {
    }
    public Kisi(String name, int resim, int yas) {
        this.name = name;
        this.resim = resim;
        this.yas = yas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getResim() {
        return resim;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }


}


