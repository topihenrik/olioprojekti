package com.example.olioprojekti;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class THLData {
    String testRegion = "497";

    public String readJsonSmokerPage(){
        URL url = null;
        String result = null;
        try {
            url = new URL("https://sotkanet.fi/rest/1.1/json?indicator=4404&years=2018&genders=total");
            Scanner sc = null;
            sc = new Scanner(url.openStream());
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext()) {
                sb.append(sc.next());
            }
            result = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public JSONObject jsonSmokerArray() {
        JSONArray jsonArray  = null;
        JSONObject jsonObject = null;
        try {
            jsonArray = new JSONArray(readJsonSmokerPage());
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                if(testRegion.equals(jsonObject.getString("region"))) {
                    break;
                } else {
                    jsonObject = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public String readJsonAlcoholPage(){
        URL url = null;
        String result = null;
        try {
            url = new URL("https://sotkanet.fi/rest/1.1/json?indicator=714&years=2018&genders=total");
            Scanner sc = null;
            sc = new Scanner(url.openStream());
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext()) {
                sb.append(sc.next());
            }
            result = sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public JSONObject jsonAlcoholArray() {
        JSONArray jsonArray  = null;
        JSONObject jsonObject = null;
        try {
            jsonArray = new JSONArray(readJsonAlcoholPage());
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                if(testRegion.equals(jsonObject.getString("region"))) {
                    break;
                } else {
                    jsonObject = null;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
