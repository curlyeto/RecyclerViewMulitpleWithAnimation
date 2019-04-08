package com.example.ertugrul.recyclerviewmultiplyviewholderexample.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;

import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.ertugrul.recyclerviewmultiplyviewholderexample.Model.Kisi;
import com.example.ertugrul.recyclerviewmultiplyviewholderexample.Model.Reklam;
import com.example.ertugrul.recyclerviewmultiplyviewholderexample.R;

import java.util.ArrayList;
import java.util.List;


public class KisiReklamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final static int TYPE_KISI=1,TYPE_Reklam=2;
    private List<Object> KisiReklam =new ArrayList();
    private Context context;

    public KisiReklamAdapter(Context context){
        this.context=context;
    }
    public  void setKisiReklam( List<Object> KisiReklam){
        this.KisiReklam=KisiReklam;
    }

    @Override
    public int getItemViewType(int position) {
        /*
         * List içerisindeki gelen tipi yakalabilecegimiz mettot
         * */
        if (KisiReklam.get(position) instanceof Kisi) {
            return TYPE_KISI;
        } else if (KisiReklam.get(position) instanceof Reklam) {
            return TYPE_Reklam;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout=0;
        RecyclerView.ViewHolder viewHolder;

        switch (viewType){
            case TYPE_KISI:
                layout= R.layout.kisi_satir;
                View kisiview= LayoutInflater.from( parent.getContext() ).inflate( layout,parent,false );
                viewHolder=new KisiViewHolder(kisiview);
                break;
            case TYPE_Reklam:
                layout=R.layout.reklam_satir;
                View reklamview= LayoutInflater.from( parent.getContext() ).inflate( layout,parent,false );
                viewHolder=new ReklamViewHolder(reklamview);
                break;
                default:
                    viewHolder=null;
                    break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType=holder.getItemViewType();

        switch (viewType){
            case TYPE_KISI:
                Kisi kisi=(Kisi)KisiReklam.get(position);
                ((KisiViewHolder)holder).showKisiDetails(kisi);

                break;
            case TYPE_Reklam:
                Reklam reklam=(Reklam) KisiReklam.get(position);
                ((ReklamViewHolder)holder).showReklamDetails(reklam);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return KisiReklam.size();
    }

    public class  KisiViewHolder extends RecyclerView.ViewHolder {

        private TextView ivKisiAd,ivKisiYas;
        private ImageView ivKisiResim;

        public KisiViewHolder(View itemvView){
        super(itemvView);
        ivKisiAd=itemvView.findViewById( R.id.ivKisiAd );
        ivKisiYas=itemvView.findViewById( R.id.ivKisiYas );
        ivKisiResim=itemvView.findViewById( R.id.ivKisiResim );



    }

        public void showKisiDetails(Kisi kisi){
             // Attach values for each item
        String kisiad  =kisi.getName();
        int resim =kisi.getResim();
        int kisiyas =kisi.getYas();
            ivKisiAd.setText(kisiad);
            ivKisiYas.setText( ""+ kisiyas );
            ivKisiResim.setImageResource( resim );
    }



}
    public class ReklamViewHolder extends RecyclerView.ViewHolder{
        private TextView ivreklam;
        public ReklamViewHolder(View itemview){
            super(itemview);
            ivreklam=itemview.findViewById( R.id.tvReklam );
        }
        public void showReklamDetails(Reklam reklam){
            String reklamm=reklam.getReklamId();
            ivreklam.setText( reklamm );

        }
    }
}
