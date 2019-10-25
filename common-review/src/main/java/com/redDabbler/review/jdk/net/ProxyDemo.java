package com.redDabbler.review.jdk.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class ProxyDemo {


    public static void main(String[]args) {
        String proxyHost = "127.0.0.1";
        String proxyPort = "1080";

        System.setProperty("http.proxyHost", proxyHost);
        System.setProperty("http.proxyPort", proxyPort);

        demo2();
    }

    public static void demo1() {
        URL url = null;
        try {
            url = new URL("http://www.google.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            URLConnection urlConnection = url.openConnection();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static  void demo2(){
        SocketAddress socketAddress = new InetSocketAddress("127.0.0.1",1080);
        Proxy proxy = new Proxy(Proxy.Type.HTTP,socketAddress);
        try {
            URL url = new URL("http://www.google.com");
            URLConnection urlConnection = url.openConnection(proxy);
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}