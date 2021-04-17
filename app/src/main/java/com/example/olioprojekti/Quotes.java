package com.example.olioprojekti;

import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class Quotes {

    private static Quotes sitaatit = new Quotes();

    public static Quotes getInstance(){
            return sitaatit;
    }


    public void readJSON (){
        String json = getJSON();
        System.out.print("JSON" + json);

        if(json != null){
            try {
                JSONArray jsonArray  = new JSONArray(json);
                for(int i = 0; i<jsonArray.length(); i++) {
                    JSONObject jObject = jsonArray.getJSONObject(i);
                    System.out.println(jObject.getString("text"));
                    System.out.println(jObject.getString("author"));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

    public String getJSON() {
        String response = null;
        try {
            URL url = new URL("https://type.fit/api/quotes");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = br.readLine()) != null){
                sb.append(line).append("\n");
            }
            response = sb.toString();
            in.close();

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return response;
    }


}
