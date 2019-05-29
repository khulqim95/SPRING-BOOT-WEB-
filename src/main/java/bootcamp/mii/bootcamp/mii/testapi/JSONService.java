/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.mii.bootcamp.mii.testapi;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Okala
 */
public class JSONService {

    public String streamToString(InputStream inputStream){
        String text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }
    
    public String getJSON(String JsonUrl) {
        String query_url = JsonUrl;
        String json = null;
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
//            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            InputStream inputStream = conn.getInputStream();
            json = streamToString(inputStream);
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return json;
    }
    
     public JsonObject getJsonObject(String JsonUrl) {
        String query_url = JsonUrl;
        JsonObject json = null;
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
//            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            InputStream inputStream = conn.getInputStream();
            JsonElement element = new JsonParser().parse(new InputStreamReader(inputStream));
            json = element.getAsJsonObject();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return json;
    }
     public JsonElement getJsonElement(String JsonUrl) {
        String query_url = JsonUrl;
        JsonElement element = null;
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
//            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            InputStream inputStream = conn.getInputStream();
            element = new JsonParser().parse(new InputStreamReader(inputStream));
            conn.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return element;
    }
}
