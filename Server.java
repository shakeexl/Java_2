package com.geekbrains.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private int port;
    private List<ClientHandler> clients;

    public Server(int port) {
        this.port = port;
        this.clients = new ArrayList<>();
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("The server is running on the port " + port + "...");
            while (true) {
                System.out.println("Waiting for a new client...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                new ClientHandler(socket, this);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public void broadcastMessage(String message) throws IOException {
        for (ClientHandler clientHandler : clients) {
            clientHandler.sendMessage(message);
        }
    }

    public boolean isNickBusy(String nickname) {
        for (ClientHandler clientHandler : clients) {
            if(clientHandler.getUsername().equals(nickname)) {
                return true;
            }
        }
        return false;
    }
    public void whisperMessage(ClientHandler from, String to, String msg) throws IOException {
        for (ClientHandler client: clients) {
            if(client.getUsername().equals(to)) {
                client.sendMessage("[W from: " + from.getUsername() + "] " + msg);
                break;
            }
        }
        from.sendMessage("[W to: " + to + "] " + msg);
    }
}
