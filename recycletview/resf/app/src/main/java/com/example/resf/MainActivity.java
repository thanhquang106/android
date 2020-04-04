package com.example.resf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static int[] item_id = {R.drawable.ic_android1,R.drawable.ic_android1,
            R.drawable.ic_android1,R.drawable.ic_android1,R.drawable.ic_android1,
            R.drawable.ic_android1,R.drawable.ic_android1,R.drawable.ic_android1};
    private String[] item_name;
    private List<item> items = new ArrayList<>();
    private RecyclerView recyclerView;
    private RCVA rcva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item_name = getResources().getStringArray(R.array.item_name);
        recyclerView = findViewById(R.id.rcv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        getItem();
        rcva = new RCVA(items);
        recyclerView.setAdapter(rcva);
    }

    private void getItem(){
        int count =0;
        for (String itemname : item_name){
            item item = new item(item_id[count], itemname);
            items.add(item);
            count++;
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case 121:
                rcva.removeItem(item.getGroupId());
                displayMes("deleted");
                return true;
            case 122:
                displayMes("ok");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void displayMes (String mes){
        Snackbar.make(findViewById(R.id.main),mes,Snackbar.LENGTH_SHORT).show();
    }
}
