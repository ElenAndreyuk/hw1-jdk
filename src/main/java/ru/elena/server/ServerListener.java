package ru.elena.server;

public class ServerListener implements ServerListenable{
    @Override
    public void onMessageReceived(String msg) {
        System.out.println(msg);
    }
}
