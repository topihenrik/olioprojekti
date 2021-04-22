package com.example.olioprojekti;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;

public class Quotes {

    private static Quotes motivationalQuotes = new Quotes();
    public static Quotes getInstance(){
            return motivationalQuotes;
    }


    public String getRandomQuote(){ //Makes a json array from the string and then selects a random quote from that list and returns a String with the quote and author.
        String json = getJSON();
        Random random = new Random();
        String quote = null;
        String author = null;

        if(json != null){
            try {
                JSONArray jsonArray  = new JSONArray(json);
                JSONObject jObject = jsonArray.getJSONObject(random.nextInt(jsonArray.length()));
                if (jObject.getString("author").equals("null")) {
                    author = "Author Unknown";
                } else {
                    author = jObject.getString("author");
                }
                quote = jObject.getString("text") +"\n"+ " -" + author;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    return quote;
    }

    public String getJSON() { //Reads the motivational quotes api to a string.
        String response = null;
        try {
            URL url = new URL("https://type.fit/api/quotes");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream inputStream = new BufferedInputStream(conn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
            response = stringBuilder.toString();
            inputStream.close();
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
