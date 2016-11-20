package com.iit.sramaraj.tradeforfun;

/**
 * Created by Nivash on 11/19/2016.
 */

    import android.os.AsyncTask;

    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
    import java.net.MalformedURLException;
    import java.net.URL;
import java.util.ArrayList;


    @SuppressWarnings("unused")
    public class request extends AsyncTask<StockInfo,Void,ArrayList> {

        @Override
        protected ArrayList doInBackground(StockInfo... params) {
            ArrayList<String> data = new ArrayList<>();
            String[] watchlist = { "AAPL","GOOG","MSFT" } ;
            String getQuery="";
            for (int i=0; i< watchlist.length;i++) {
                if (i < watchlist.length -1)
                {
                    getQuery += watchlist[i] + "+" ;
                }
                else
                    getQuery += watchlist[i];
            }

            String requestURL = "http://finance.yahoo.com/d/quotes.csv?s="+getQuery +"&f=nbc";
            URL url = null;
            try {
                url = new URL(requestURL);

            HttpURLConnection request = null;
                request = (HttpURLConnection) url.openConnection();


            int responseCode = request.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(request.getInputStream()));
            String inputLine;



            while ((inputLine = in.readLine()) != null) {
                String companyDetails = inputLine.toString();
                data.add(companyDetails);

                //response.append(inputLine);
            }
            in.close();
            /*for(int j=0;j<data.size();j++)
            {
                System.out.println("Company Name :"+ data.get(j)[0]);
                System.out.println("Price :"+ data.get(j)[1]);

                String[] change = (data.get(j)[2]).replace("\"","").split(" - ");
                System.out.println("Today's Change :"+ change[0] );
                System.out.println("Change % :"+ change[1] );
            }*/
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
    }


