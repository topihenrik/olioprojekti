package com.example.olioprojekti;

import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class SwaggerApi {
    public void SwaggerApi() {
        return;
    }

    public void readXML() {
        Log.d("Testi", "STRING445");
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://ilmastodieetti.ymparisto.fi/ilmastodieetti/calculatorapi/v1/FoodCalculator?query.diet=omnivore";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            Log.d("String", "Kaikki ok!");

            String element = doc.getElementsByTagName("Total").item(0).getTextContent();

            //NodeList nodeList = doc.getElementsByTagName("Total");
            //Node node = nodeList.item(0);
            //Element element = (Element) node;

            Log.d("Total", "* * * * * * * * * * * * *" + element.toString());


        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return;
    }

}
