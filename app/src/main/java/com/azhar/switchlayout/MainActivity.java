package com.azhar.switchlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static com.azhar.switchlayout.ItemAdapter.SPAN_COUNT_ONE;
import static com.azhar.switchlayout.ItemAdapter.SPAN_COUNT_THREE;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;
    private GridLayoutManager gridLayoutManager;
    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        initItemsData();

        gridLayoutManager = new GridLayoutManager(this, SPAN_COUNT_ONE);
        itemAdapter = new ItemAdapter(items, gridLayoutManager);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void initItemsData() {
        items = new ArrayList<>(20);
        items.add(new Item(R.drawable.adammm, "Adam", "The First Human", "Human"));
        items.add(new Item(R.drawable.hades, "Hades", "King Of The Hell", "GOD"));
        items.add(new Item(R.drawable.jack, "Jack The Ripper", "The First Serial Killer", "Human"));
        items.add(new Item(R.drawable.hera, "Heracles", "The Champion Of The Olympus", "GOD"));
        items.add(new Item(R.drawable.kojiro, "Sasaki Kojiro", "The Greatest Swordsman", "Human"));
        items.add(new Item(R.drawable.lubu, "LuBu", "The Strongest General", "Human"));
        items.add(new Item(R.drawable.qin, "Qin Shi Huang", "The Strongest Emperor", "Human"));
        items.add(new Item(R.drawable.raiden, "Raiden Tameemon", "The Strongest Rikishi", "Human"));
        items.add(new Item(R.drawable.shiva, "Shiva", "The Leader of Hindhu", "GOD"));
        items.add(new Item(R.drawable.thor, "Thor", "The God Of Thuders", "GOD"));
        items.add(new Item(R.drawable.zeus, "Zeus", "The God and Leader Of Olympus", "GOD"));
        items.add(new Item(R.drawable.sakata, "Sakata Kintoki", "The Strongest Child", "Human"));
        items.add(new Item(R.drawable.michel, "Michel Nostradamus", "The Greatest Astrologer", "Human"));
        items.add(new Item(R.drawable.nikola, "Nikola Tesla", "The Genius Scientist", "Human"));
        items.add(new Item(R.drawable.zero, "Zerofuku", "The God Of Misfortune", "GOD"));
        items.add(new Item(R.drawable.simo, "Simo Hayha", "The White Death", "Human"));
        items.add(new Item(R.drawable.odin, "Odin", "The God Of Darkness", "GOD"));
        items.add(new Item(R.drawable.belzeebub, "Belzeebub", "The Prince Of The Hell", "GOD"));
        items.add(new Item(R.drawable.soji, "Soji Okita", "The Best Swordsman Shinsengumi", "Human"));
        items.add(new Item(R.drawable.pose, "Poseidon", "The God Of The Sea", "GOD"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meun_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_switch_layout) {
            switchLayout();
            switchIcon(item);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchLayout() {
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_ONE) {
            gridLayoutManager.setSpanCount(SPAN_COUNT_THREE);
        } else {
            gridLayoutManager.setSpanCount(SPAN_COUNT_ONE);
        }
        itemAdapter.notifyItemRangeChanged(0, itemAdapter.getItemCount());
    }

    private void switchIcon(MenuItem item) {
        if (gridLayoutManager.getSpanCount() == SPAN_COUNT_THREE) {
            item.setIcon(getResources().getDrawable(R.drawable.ic_span_3));
        } else {
            item.setIcon(getResources().getDrawable(R.drawable.ic_span_1));
        }
    }
}