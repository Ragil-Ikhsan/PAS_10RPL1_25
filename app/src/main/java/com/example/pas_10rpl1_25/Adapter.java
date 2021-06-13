package com.example.pas_10rpl1_25;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Holder> {
    Context context;
    int posku;
    ArrayList<ListData> listData = new ArrayList<>();

    public Adapter(Context context, ArrayList<ListData> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.Nama.setText(listData.get(i).getNama());
        //holder.Deskripsi.setText(listData.get(i).getDeskripsi());
        holder.Foto.setImageResource(listData.get(i).getImage());

        holder.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int Position) {
                String gTitle = listData.get(Position).getNama();
                String gDesc = listData.get(Position).getDeskripsi();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) holder.Foto.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] bytes = stream.toByteArray();

                Intent intent = new Intent(context, Detail_Activity.class);
                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iDesc", gDesc);
                intent.putExtra("iImage", bytes);
                context.startActivity(intent);
            }

            @Override
            public boolean OnItemHold(MenuItem menu, int position) {
                switch (menu.getItemId()){
                    case R.id.delete:
                    listData.remove(position);
                    notifyDataSetChanged();
                    break;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
