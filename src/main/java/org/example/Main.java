package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Hello world!");

        int tick = 0;
        while(true){
            tick++;
            System.out.println("Tick: "+ tick);

            sendTickToAPI(tick);

            System.out.println("Sleeping...");
            sleep(300000);
        }
    }

    private static void sendTickToAPI(int tick) throws IOException {
        String url = "https://twitch-iptv.onrender.com/index";
        URL obj = new URL(url);
        HttpURLConnection httpcon = (HttpURLConnection) obj.openConnection();
        httpcon.setRequestMethod("GET");
        httpcon.setRequestProperty("User-Agent", "Mozilla/5.0");
        System.out.println("Response: "  + httpcon.getResponseMessage());


        InputStream ip = httpcon.getInputStream();

        BufferedReader br1 = new BufferedReader(
                new InputStreamReader(ip));

        StringBuilder response
                = new StringBuilder();
        String responseSingle = null;

        while ((responseSingle = br1.readLine())
                != null) {
            response.append(responseSingle);
        }
        String xx = response.toString();
        System.out.println(xx);
    }
}