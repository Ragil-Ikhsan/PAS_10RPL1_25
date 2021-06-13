package com.example.pas_10rpl1_25;

import android.view.MenuItem;
import android.view.View;

public interface ItemClickListener {
    void onItemClickListener (View v, int Position);
    boolean OnItemHold (MenuItem menu, int position);
}
