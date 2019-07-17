package com.redDabbler.review.common.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

@Slf4j
public class SocketClientDemo {

    public static void main(String[]args){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入：");
            String input = scanner.nextLine();
            Socket socket = new Socket("127.0.0.1",8082);
            log.info(socket.getInetAddress().getCanonicalHostName());
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(input.getBytes());
            InputStream inputStream = socket.getInputStream();
            byte[]buffer = new byte[1024];
            inputStream.read(buffer);
            String resp = new String(buffer);
            System.out.println("获得："+resp);

        }catch (Exception e){

        }

    }
}
