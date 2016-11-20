package com.iit.sramaraj.tradeforfun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Nivash on 11/19/2016.
 */
public class LeaderBoard  extends AppCompatActivity {
    ListView lv;
    ArrayList<String> listItems = new ArrayList<String>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        listItems.add("Goutham    +100.86");
        listItems.add("Andrew    +10.46");
        listItems.add("Mathew     -10.86");
        listItems.add("Mesut Ozil    -80.76");
        listItems.add("Rooney    +600.86");
        listItems.add("Alex Sanchez    -400.86");
        listItems.add("Srinivas    -200.86");
        LeaderAdapter listNotices = new LeaderAdapter(this, R.layout.custom_adapter_view, listItems, StockInfo.imagepics);
        lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(listNotices);
    }
}
