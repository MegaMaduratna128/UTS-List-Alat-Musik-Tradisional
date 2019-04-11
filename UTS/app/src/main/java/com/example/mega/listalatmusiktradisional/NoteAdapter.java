package com.example.mega.listalatmusiktradisional;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteAdapterViewHolder>{

    private ArrayList<NoteAlatMusik> notealatmusik;

    public NoteAdapter(ArrayList<NoteAlatMusik> list) {
        this.notealatmusik = list;
    }

    @Override
    public NoteAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new NoteAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NoteAdapterViewHolder holder, final int position) {
        holder.text_namaalatmusikd.setText(notealatmusik.get(position).getNama_alatmusik());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pindahKeNoteDetail(position, v.getContext());
            }
        });
    }

    private void pindahKeNoteDetail(int position, Context c) {
        Context context = c;
        Intent i = new Intent(context, DetailAlatMusik.class);
        i.putExtra("nama_alatmusik", notealatmusik.get(position).getNama_alatmusik());
        i.putExtra("asal_provinsi", notealatmusik.get(position).getAsal_provinsi());
        i.putExtra("deskripsi_alatmusik", notealatmusik.get(position).getDeskripsi_alatmusik());
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return (notealatmusik != null) ? notealatmusik.size() : 0;
    }

    public class NoteAdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView text_namaalatmusikd,tfNomor;

        public NoteAdapterViewHolder(View itemView) {
            super(itemView);
            text_namaalatmusikd = (TextView) itemView.findViewById(R.id.text_namaalatmusikd);
        }
    }

}
