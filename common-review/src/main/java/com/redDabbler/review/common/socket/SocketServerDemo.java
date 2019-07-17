package com.redDabbler.review.common.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class SocketServerDemo {
    public void connect(){
        try{
            ServerSocket serverSocket = new ServerSocket(8082);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            String out = new String(bytes);
            System.out.println(out);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(out.getBytes());
        }catch (IOException e){
            log.error("socket connect failed ",e);
        }

    }
}
