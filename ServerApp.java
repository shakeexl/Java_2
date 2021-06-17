package com.geekbrains.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("The server is running on port 8189. Waiting for a client connection ...");
            Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Client connected");

            String msg;
            while (true) {
                msg = in.readUTF();
                System.out.println(msg);
                out.writeUTF(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
