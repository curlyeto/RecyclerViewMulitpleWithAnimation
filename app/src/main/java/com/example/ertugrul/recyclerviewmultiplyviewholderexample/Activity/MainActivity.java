package com.example.ertugrul.recyclerviewmultiplyviewholderexample.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;


import com.example.ertugrul.recyclerviewmultiplyviewholderexample.Adapter.KisiReklamAdapter;
import com.example.ertugrul.recyclerviewmultiplyviewholderexample.Model.Kisi;
import com.example.ertugrul.recyclerviewmultiplyviewholderexample.Model.Reklam;
import com.example.ertugrul.recyclerviewmultiplyviewholderexample.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;
    private List<Object> kisireklamlist;
    private KisiReklamAdapter kisiReklamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        recyclerView=findViewById( R.id.recyclerView );

        linearLayoutManager=new LinearLayoutManager( this );
        recyclerView.setLayoutManager( linearLayoutManager );
        recyclerView.setHasFixedSize( true );
        init();
    }
    private void init(){
        kisireklamlist=new ArrayList<>(  );
        kisiReklamAdapter=new KisiReklamAdapter( MainActivity.this );
        recyclerView.setAdapter( kisiReklamAdapter );


        kisireklamlist.add( new Kisi( "Eminem",R.drawable.eminem,46 ) );
        kisireklamlist.add( new Kisi( "Bill Gates",R.drawable.billgates,63 ) );
        kisireklamlist.add(new Reklam( "Bu bir reklamdır." ) );
        kisireklamlist.add( new Kisi( "Jeff Bezos",R.drawable.jeff,55 ) );

        //Animasyon ekleniyor.
        int resId = R.anim.layout_animation_slide_right;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
        recyclerView.setLayoutAnimation(animation);
        recyclerView.scheduleLayoutAnimation();

        kisiReklamAdapter.setKisiReklam( kisireklamlist );
        kisiReklamAdapter.notifyDataSetChanged();
    }
}
