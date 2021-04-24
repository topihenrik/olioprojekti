package com.example.olioprojekti;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SwaggerApi {
    public void SwaggerApi() {
        return;
    }
    Gson gson = new Gson();
    static ArrayList<String> arrayList = new ArrayList<>();

    public void readXML2() {
        Log.d("Testi", "STRING445");
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/FoodCalculator?query.diet=omnivore";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            Log.d("String", "Kaikki ok!");
            Type userListType = new TypeToken<ArrayList<String>>(){}.getType();
            //arrayList = gson.fromJson(doc, userListType);



        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return;
    }

    public void readJsonPage(){
        URL url = null;
        try {
            url = new URL("https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/FoodCalculator?query.diet=omnivore");
            Scanner sc = null;
            sc = new Scanner(url.openStream());
            StringBuffer sb = new StringBuffer();
            while(sc.hasNext()) {
                sb.append(sc.next());
            }
            String result = sb.toString();
            Log.d("Contents: ", result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
