package com.iit.sramaraj.tradeforfun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Main2Activity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> listItems = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        request getans= new request();
        try {
            listItems = getans.execute().get();
            //display(ret);
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ListAdapter listNotices = new ListAdapter(this, R.layout.custom_adapter_view, listItems, StockInfo.noticepics);
        lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(listNotices);
    }
}
