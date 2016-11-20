package com.iit.sramaraj.tradeforfun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

/**
 * Created by Nivash on 11/19/2016.
 */
public class Trade  extends AppCompatActivity {
    EditText et;
    TextView tx;

String quoteprice="";
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);
        et=(EditText)findViewById(R.id.editText);
      String quotesymbol= et.getText().toString();
        System.out.print("quote"+quotesymbol);
        Log.d("Trade-1", quotesymbol);
        Button submitButton= (Button)findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("Trade", quotesymbol);
                    getQuoteNt nt= new getQuoteNt();
                    try {

                        quoteprice = nt.execute(et.getText().toString()).get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    tx=(TextView)findViewById(R.id.textView2);
                    tx.setText(quoteprice);
                }

        });


    }

}

