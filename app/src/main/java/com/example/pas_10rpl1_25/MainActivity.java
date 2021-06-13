package com.example.pas_10rpl1_25;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView MrecyclerView;
Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MrecyclerView = findViewById(R.id.RecyclerViewData);
        MrecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, getlist());
        MrecyclerView.setAdapter(adapter);
    }

    private ArrayList<ListData> getlist() {
        ArrayList<ListData>listData = new ArrayList<>();
        ArrayList<ListData> models = new ArrayList<>();
        ListData m = new ListData();

        m.setNama("Spiderman");
        m.setDeskripsi("Spider-Man, adalah pahlawan super fiktif dari Marvel Comics yang diciptakan oleh penulis Stan Lee dan artis Steve Ditko. Ia pertama muncul dalam Amazing Fantasy #15. Ia telah menjadi salah satu pahlawan super yang paling terkenal di dunia.");
        m.setImage(R.drawable.spiderman);
        models.add(m);

        m = new ListData();
        m.setNama("Deadpool");
        m.setDeskripsi("Deadpool adalah Prajurit bayaran Wade Wilson, menjalani percobaan untuk menyembuhkan dirinya dari kanker. Ia memperoleh kekuatan dari proses penyembuhan itu, tapi dengan konsekuensi menjadi cacat fisik permanen.");
        m.setImage(R.drawable.deadpool);
        models.add(m);

        m = new ListData();
        m.setNama("Thor");
        m.setDeskripsi("Thor adalah sebuah pahlawan super fiksi yang muncul dalam buku-buku komik Amerika yang diterbitkan oleh Marvel Comics. Karakter tersebut, yang berdasarkan pada dewa mitologi Norse dengan nama yang sama, adalah dewa petir dan memegang sebuah palu, yang memberikannya kemampuan terbang dan mengendalikan cuaca.");
        m.setImage(R.drawable.thor);
        models.add(m);

        m = new ListData();
        m.setNama("Wolverine");
        m.setDeskripsi("Wolverine adalah karakter fiksi yang muncul di buku komik Amerika yang diterbitkan oleh Marvel Comics. Kata Wolverine sendiri diambil dari nama hewan dari California yang diyakini sebagai jelmaan iblis. Beredar kabar seseorang telah melihat hewan tersebut memakan beruang yang ukurannya lebih besar darinya.");
        m.setImage(R.drawable.wolverine);
        models.add(m);
        return models;
    }
}