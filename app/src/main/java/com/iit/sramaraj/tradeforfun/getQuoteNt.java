package com.iit.sramaraj.tradeforfun;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Nivash on 11/19/2016.
 */
public class getQuoteNt extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... params) {
        String Company = params[0];
        System.out.print("++"+Company);
        String result = "";
        Log.d("getQuote-Comp", Company);
        String requestURL = "http://finance.yahoo.com/d/quotes.csv?s="+Company+"&f=o";
        try {
            URL url = new URL(requestURL);


            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            int responseCode = request.getResponseCode();
            System.out.println("---Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(request.getInputStream()));
            String inputLine;

            String[] companyDetails = null;
            if ((inputLine = in.readLine()) != null) {
                result = inputLine.toString();
                Log.d("getQuote-1", inputLine.toString());
            } else
                result = "N/A";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("getQuote", result);
        return result;
    }
}