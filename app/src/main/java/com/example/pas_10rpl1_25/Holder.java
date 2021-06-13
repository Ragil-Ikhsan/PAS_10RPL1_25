package com.example.pas_10rpl1_25;

import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {
ImageView Foto;
TextView Nama, Deskripsi;
ItemClickListener itemClickListener;
    public Holder(@NonNull View itemView) {
        super(itemView);
        this.Foto = itemView.findViewById(R.id.Imagetv);
        this.Nama = itemView.findViewById(R.id.txt_Name);

        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);

    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v, getLayoutPosition());

    }
public void setOnItemClickListener(ItemClickListener ic){
     this.itemClickListener = ic;

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(R.menu.menu1, R.id.delete, 1, "delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return itemClickListener.OnItemHold(item, getLayoutPosition());
            }
        });

    }
}
